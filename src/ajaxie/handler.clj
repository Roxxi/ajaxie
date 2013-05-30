(ns ajaxie.handler
  (:use compojure.core)
  (:require [compojure.handler :as handler]
            [compojure.route :as route]))

(def a-table (atom {}))

(defroutes app-routes
  (GET "/" []
    (str
     "Submit values via a POST to <pre>localhost:3000/put</pre><br/>"
     "Then use <pre>localhost:3000/get/[key]</pre> to look up a value."))
  (GET "/get/:key" [key]
    (or (@a-table (keyword key))
        (str "No value for \"" key "\" found")))
  (POST "/put" [:as req]
    (swap! a-table #(merge %  (:params req)))
    (str "Merged " (:params req) " resulting in " @a-table))
  (route/resources "/")
  (route/not-found "Not Found"))
  
(def app
  (handler/site app-routes))

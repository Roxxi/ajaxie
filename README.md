# ajaxie

Small web process for playing with ajax.  Only supports GET and POST.

Submit values via a POST to `localhost:3000/put` via a form, then use `localhost:3000/get/[key]` to look up a submitted value

## Prerequisites

You will need [Leiningen][1] 1.7.0 or above installed.

[1]: https://github.com/technomancy/leiningen

Use `brew install leiningen` to install it if you have homebrew

## Running

To start a web server for the application, run:

    lein ring server



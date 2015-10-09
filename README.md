# haproxy-csv-parser

Library that parses HAProxy dashboard information from csv into usable data

An example of how the data looks like could be found [on the demo page](http://demo.haproxy.org/;csv).

## Install

TODO (going to publish on clojars and then add here)

## Usage

Here is how you would print all available headers provided by the csv export:

```clojure
(defn -main[& args]
  (let [metrics (lines "http://demo.haproxy.org/;csv")]
    (println (metrics-names metrics)))
```

While this is how you print the value of `svname` and `smax` respectively:

```clojure
(defn -main[& args]
  (let [metrics (lines "http://demo.haproxy.org/;csv")]
    (println (metric metrics "svname" 1))
    (println (metric metrics "smax" 1))))
```
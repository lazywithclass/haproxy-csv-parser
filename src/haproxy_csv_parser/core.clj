(ns haproxy-csv-parser.core
  (:require [clojure.string :as str]))

(defn lines[url]
  "Splits the downloaded content into lines"
  (str/split (slurp url) #"\n"))

(defn -main[& args]
  (print (nth (lines "http://demo.haproxy.org/;csv") 0))
)

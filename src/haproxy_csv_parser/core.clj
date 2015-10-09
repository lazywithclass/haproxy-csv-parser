(ns haproxy-csv-parser.core
  (:require [clojure.string :as str]))

(defn lines[url]
  "Splits the downloaded content into lines"
  (str/split (slurp url) #"\n"))

(defn- split-line[string] (str/split string #","))

(defn- metric-index[metrics name]
  "Returns the index at which the metric identified by name could be found"
  (.indexOf (split-line (nth metrics 0)) name))

(defn metric[metrics name line]
  "Returns the metric identified by name at the given line"
  (nth (split-line (nth metrics line)) (metric-index metrics name)))

(defn metrics-names[metrics]
  "Returns an array with all the metrics names"
  (split-line (str/replace (nth metrics 0) #"#\s*" "")))

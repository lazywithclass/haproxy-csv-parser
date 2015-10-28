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

(defn- proxy-name[metrics-line]
  "Returns the proxy name for this line"
  (nth (split-line metrics-line) 0))

(defn group-by-proxy-name[metrics name]
  "Returns an array of lines belonging to a proxy name"
  (filter #(= (proxy-name %) name) metrics))

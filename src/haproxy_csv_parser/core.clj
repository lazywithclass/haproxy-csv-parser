(ns haproxy-csv-parser.core)

(defn fetch[url]
  (with-open [stream (.openStream (java.net.URL. url))]
    (let [buf (java.io.BufferedReader.
                (java.io.InputStreamReader. stream))]
      (apply str (line-seq buf)))))


(print (fetch "http://demo.haproxy.org/;csv"))

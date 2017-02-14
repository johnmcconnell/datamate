(defproject datamate "0.1.0-SNAPSHOT"
  :description "A clojure DSL to make Oracle more enjoyable"
  :url "https://github.com/johnmcconnell/datamate"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :plugins [[lein-cljfmt "0.5.6"]
            [lein-codox "0.10.3"]]
  :repositories [["releases" {:url "https://clojars.org/repo"
                              :username :env/clojars_username
                              :password :env/clojars_password}]]
  :dependencies [[org.clojure/clojure "1.8.0"]
                 [org.clojure/test.check "0.9.0"]])

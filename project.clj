(defproject mui "0.1.1-SNAPSHOT"
  :plugins [[lein-cljsbuild "1.0.5"]
            [arohner/lein-npm "0.4.1"]
            [browserify-shim "0.1.0-SNAPSHOT"]]

  :dependencies [[org.clojure/clojure "1.7.0"]
                 [org.clojure/clojurescript "0.0-3308"]
                 [shodan "0.4.1"]]

  :node-dependencies [[material-ui "0.10.2"]
                      [react-tap-event-plugin "0.1.7"]]

  :browserify-builds {:client "resources/material_ui.js"}

  :source-paths ["src"]

  :cljsbuild
  {:builds
   [{:id :client
     :source-paths ["src" "test"]
     :compiler
     {:output-dir "build/out"
      :output-to "resources/public/mui.cljs.js"
      :optimizations :simple 
      ;:pretty-print true
      ;:source-map "build/mui.js.map"
      :preamble ["material_ui.js" "qunit-1.17.1.js"]
      :main "mui"}}]}

  :profiles
  {:dev
   {:plugins []
    :dependencies [[ring "1.3.2"]
                   [compojure "1.3.1"]]
    :main mui.test.server}})

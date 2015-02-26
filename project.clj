(defproject mui "0.1.0-SNAPSHOT"
  :plugins [[lein-cljsbuild "1.0.4"]]
  :dependencies [[org.clojure/clojure "1.6.0"]
                 [org.clojure/clojurescript "0.0-2740"]
                 [shodan "0.4.1"] ; logging
                 #_[reagent "0.5.0-alpha"]]
  :source-paths ["src"]
  :clean-targets ^{:protect false} [:target-path "resources/public/out" "resources/public/ethereum.cljs.js"]
  :cljsbuild
  {:builds
   {:dev
    {:source-paths ["src" "test"]
     :compiler
     {:output-dir "build/out"
      :output-to "resources/public/mui.cljs.js"
      :optimizations :simple 
      ;:pretty-print true
      ;:source-map "build/mui.js.map"
      :preamble ["material_ui.js" #_"reagent/react.js" "qunit-1.17.1.js"]
      ;:externs ["externs/mui.ext.js"]
      }}}}

  :profiles
  {:dev
   {:plugins []
    :dependencies [[ring "1.3.2"]
                   [compojure "1.3.1"]]
    :main mui.test.server}})

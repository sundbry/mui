(ns mui.test
  (:require
    [shodan.console :as log :include-macros true]))

(defn- init-fixture
  []
  nil)

(defn- test-hello [qassert]
  (.ok qassert true "Passed!"))

(defn run-local-tests [qunit]
  (doto qunit
    (.test "Test oracle" test-hello)))

(defn ^:export run-tests []
  (log/info "Starting tests")
  (init-fixture)
  (doto js/QUnit
    (run-local-tests))
  (log/info "Tests complete"))


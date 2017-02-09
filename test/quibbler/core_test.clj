(ns quibbler.core-test
  (:require [clojure.test :refer :all]
            [quibbler.core :refer :all]))

(deftest foo-test
  (testing "returns the value passed to the function"
    (is (= 1 (foo 1)))))

(ns sorting.core-test
  (:require [clojure.test :refer :all]
            [sorting.core :refer :all]))

(deftest test-insertion-sort
 (is (= [] (insertion-sort [])))
 (is (= [1] (insertion-sort [1])))
 (is (= [1 2] (insertion-sort [1 2])))
 (is (= [1 2] (insertion-sort [2 1])))
 (is (= [1 2 3] (insertion-sort [1 2 3])))
 (is (= [1 2 3] (insertion-sort [2 1 3])))
 (is (= [1 2 3] (insertion-sort [2 3 1])))
 (is (= [1 2 3] (insertion-sort [1 3 2])))
 (is (= [1 2 3] (insertion-sort [3 1 2])))
 (is (= [1 2 3] (insertion-sort [3 2 1])))
 (is (= [1 2 3 4 5] (insertion-sort [1 2 3 4 5])))
 (is (= [1 2 3 4 5] (insertion-sort [5 4 3 2 1]))))

(deftest test-insertion-sort
 (is (= [] (quick-sort [])))
 (is (= [1] (quick-sort [1])))
 (is (= [1 2] (quick-sort [1 2])))
 (is (= [1 2] (quick-sort [2 1])))
 (is (= [1 2 3] (quick-sort [1 2 3])))
 (is (= [1 2 3] (quick-sort [2 1 3])))
 (is (= [1 2 3] (quick-sort [2 3 1])))
 (is (= [1 2 3] (quick-sort [1 3 2])))
 (is (= [1 2 3] (quick-sort [3 1 2])))
 (is (= [1 2 3] (quick-sort [3 2 1])))
 (is (= [1 2 3 4 5] (quick-sort [1 2 3 4 5])))
 (is (= [1 2 3 4 5] (quick-sort [5 4 3 2 1]))))
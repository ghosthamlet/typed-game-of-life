(ns test.game-of-life
  (require [game-of-life :refer :all]
           [clojure.test :refer :all]))

(deftest cell-tick-test
  (is (thrown? java.lang.AssertionError (cell-tick {:alive? true :neighbours -1})))

  (is (not (cell-tick {:alive? true :neighbours 1}))) 
  (is (not (cell-tick {:alive? false :neighbours 1}))) 

  (is (cell-tick {:alive? true :neighbours 2}))
  (is (not (cell-tick {:alive? false :neighbours 2}))) 

  (is (cell-tick {:alive? true :neighbours 3}))
  (is (cell-tick {:alive? false :neighbours 3}))

  (is (not (cell-tick {:alive? true :neighbours 4}))) 
  (is (not (cell-tick {:alive? false :neighbours 4})))
  
  (is (thrown? java.lang.AssertionError (cell-tick {:alive? true :neighbours 9}))))

(deftest world-tick-test
  (is (= #{[3 2] [2 2] [1 2]}
           (world-tick #{[2 1] [2 2] [2 3]}))))

(run-tests)


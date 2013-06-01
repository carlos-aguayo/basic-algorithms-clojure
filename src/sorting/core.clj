(ns sorting.core
  (:gen-class))

(defn -main
  [& args]
  ;; work around dangerous default behaviour in Clojure
  (alter-var-root #'*read-eval* (constantly false))
  (println "Hello, World!"))

(defn insert0 
  "Insert an element into a sorted array keeping the array sorted"
  [sorted element]
  (cond
    (empty? sorted) (list element)
    (< element (first sorted)) (conj (seq sorted) element)
    :else (conj (insert0 (rest sorted) element) (first sorted))))

(defn insert1 
  "Insert all elements of unsorted into sorted keeping the array sorted"
  [sorted unsorted]
  (if (empty? unsorted)
    sorted
    (insert1 (insert0 sorted (first unsorted)) (rest unsorted))))

(defn insertion-sort 
  "Sorts the array of elements using the insertion sort algorithm"
  [elements]
  (insert1 [] elements))

(defn quick-sort 
  ;; http://boss-level.com/?p=92
  [[pivot & tail]]
  (if (nil? pivot)
    []
    (lazy-cat (quick-sort (filter #(< % pivot) tail))
              [pivot]
              (quick-sort (filter #(> % pivot) tail)))))

(defn merge0
  [a b]
  (cond
    (nil? (first a)) [b]
    (nil? (first b)) []
    :else (if (< (first a) (first b)) 
      (lazy-cat [first a] merge0((rest a) b))
      (lazy-cat [first b] merge0(a (rest b))))))
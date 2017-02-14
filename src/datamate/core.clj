(ns datamate.core
  (:require
   [clojure.string :as s :refer [lower-case upper-case]]))

(defn- defname
  [s]
  (->
   s
   lower-case
   (s/replace #"_| " "-")
   symbol))

(defmacro o-def
  [s]
  `(def ~(defname s) ~s ~s))

(defn- ->cap-keyword
  [s]
  (if (keyword? s)
    (-> s name upper-case)
    (-> s upper-case)))

(defn varchar2
  "Returns a VARCHAR(i) with i as the size passed to the function"
  ([size] (str "VARCHAR2(" size ")"))
  ([size qualifier] (str "VARCHAR2(" size " " (->cap-keyword qualifier) ")")))

(defn nvarchar2
  "Returns a NVARCHAR(i) with i as the size passed to the function"
  [size] (str "NVARCHAR2(" size ")"))

(o-def "LONG")

(defn number
  "Returns a NUMBER with precision and scale passed in as NUMBER(p, s)"
  ([precision] (str "NUMBER(" precision ")"))
  ([precision scale] (str "NUMBER(" precision ", " scale ")")))

(o-def "DATE")

(o-def "BINARY_FLOAT")

(o-def "BINARY_DOUBLE")

(o-def "TIMESTAMP")

(o-def "LONG RAW")

(o-def "ROWID")

(defn raw
  "Returns a RAW(i) with i as the size passed to the function"
  [size] (str "RAW(" size ")"))

(o-def "CLOB")

(o-def "NCLOB")

(o-def "BLOB")

(o-def "BFILE")

(defn nchar
  "Returns a NCHAR(i) with i as the size passed to the function"
  [size] (str "NCHAR(" size ")"))

(o-def "DEFAULT")

(o-def "NULL")

(o-def "NOT NULL")

(o-def "UNIQUE")

(o-def "PRIMARY KEY")

(o-def "FOREIGN KEY")

(o-def "CHECK")

(ns datamate.core-test
  (:require [datamate.core :refer :all]
            [clojure.test :refer :all]
            [clojure.test.check.clojure-test :refer :all]
            [clojure.test.check.generators :as gen]
            [clojure.test.check.properties :as prop]))

(defspec varchar2-test
  (testing "no qualifiers"
    (prop/for-all [i gen/int]
                  (is (= (str "VARCHAR2(" i ")") (varchar2 i)))))

  (testing "with qualifiers"
    (prop/for-all [i gen/int
                   q (gen/elements ["BYTE" "CHAR"
                                    :byte :char
                                    "char" "byte"
                                    :BYTE :CHAR])]
                  (let [q-> {:BYTE "BYTE"
                             :byte "BYTE"
                             "BYTE" "BYTE"
                             "byte" "BYTE"
                             :CHAR "CHAR"
                             :char "CHAR"
                             "CHAR" "CHAR"
                             "char" "CHAR"}]
                    (is (= (str "VARCHAR2(" i " " (q-> q) ")") (varchar2 i q)))))))

(defspec nvarchar2-test
  (prop/for-all [i gen/int]
                (is (= (str "NVARCHAR2(" i ")") (nvarchar2 i)))))

(deftest long-test
  (is (= "LONG" long)))

(defspec number-test
  (testing "only precision"
    (prop/for-all [i gen/int]
                  (is (= (str "NUMBER(" i ")") (number i)))))

  (testing "precision and scale"
    (prop/for-all [i gen/int
                   j gen/int]
                  (is (= (str "NUMBER(" i ", " j ")") (number i j))))))

(deftest date-test
  (is (= "DATE" date)))

(deftest binary-float-test
  (is (= "BINARY_FLOAT" binary-float)))

(deftest binary-double-test
  (is (= "BINARY_DOUBLE" binary-double)))

(deftest timestamp-test
  (is (= "TIMESTAMP" timestamp)))

(deftest long-raw-test
  (is (= "LONG RAW" long-raw)))

(deftest rowid-test
  (is (= "ROWID" rowid)))

(defspec raw-test
  (prop/for-all [i gen/int]
                (is (= (str "RAW(" i ")") (raw i)))))

(deftest clob-test
  (is (= "CLOB" clob)))

(deftest bfile-test
  (is (= "BFILE" bfile)))

(defspec nchar-test
  (prop/for-all [i gen/int]
                (is (= (str "NCHAR(" i ")") (nchar i)))))

(deftest default-test
  (is (= "DEFAULT" default)))

(deftest null-test
  (is (= "NULL" null)))

(deftest not-null-test
  (is (= "NOT NULL" not-null)))

(deftest primary-key-test
  (is (= "PRIMARY KEY" primary-key)))

(deftest foreign-key-test
  (is (= "FOREIGN KEY" foreign-key)))

(deftest check-test
  (is (= "CHECK" check)))

(deftest sys-guid-test
  (is (= "SYS_GUID()" sys-guid)))

(ns co.paralleluniverse.pulsar
  (:import [java.lang.annotation Retention RetentionPolicy Target ElementType]
           [co.paralleluniverse.lwthreads LightweightThread]
           [co.paralleluniverse.lwthreads.channels Channel]
           [co.paralleluniverse.lwthreads.channels ObjectChannel IntChannel LongChannel FloatChannel DoubleChannel]
           [co.paralleluniverse.actors PulsarActor]
           [co.paralleluniverse.actors FooException Suspendable]
           [co.paralleluniverse.actors ActorTarget]))

(use '[clojure.core.match :only (match)])


;; ## lightweight threads

(defn available-processors
  "Returns the number of available processors"
  []
  (.availableProcessors (Runtime/getRuntime)))

;; A global forkjoin pool
(def fj-pool
  (jsr166e.ForkJoinPool. (available-processors) jsr166e.ForkJoinPool/defaultForkJoinWorkerThreadFactory nil true))

(defn self
  "Returns the currently running lightweight-thread or nil if none"
  []
  (LightweightThread/currentLightweightThread))


;; ## Actors






package com.example.rxsample.repository

import io.reactivex.Maybe
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

object RxOperatorsRepository {

    private val arrayFirst = arrayOf("F1", "F2", "F3", "F4", "F5", "F6")
    private val arraySecond = arrayOf("S1", "S2", "S3", "S4", "S5", "S6")

    /**
     *  Modify the items emitted by an Observable by applying a action to each item
     *  : here concat the "map" string with every emitted item
     */
    fun getObservableWithMapOperator() : Observable<String>{
        return Observable.just("Rx","Sample" ,"Normal")
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .map { m -> "$m map" }
    }

    /**
     * Transforms the items emitted by an Observable into Observables.
     */
    fun getObservableWithFlatMapOperator() : Observable<String>{
        return Observable.just("Rx","Sample" ,"Normal")
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .flatMap { m ->
                Observable.just("$m map")
                    .subscribeOn(Schedulers.io())
            }
    }

    /**
     * Emits items only when a specified timespan is passed.
     * Here timespan in 500 ms , so will emit 2 & 4 only.
     */
    fun getObservableForDebounce(): Observable<Int>{
        return Observable.create {
            it.onNext(1)
            Thread.sleep(100)

            it.onNext(2)
            Thread.sleep(550)

            it.onNext(3)
            Thread.sleep(200)

            it.onNext(4)
            Thread.sleep(600)

            it.onComplete()
        }
    }

    /**
     * Observable for a given array.
     * @param array : given array
     */
    private fun getObservableForArray(array: Array<String>) : Observable<String> {
        return Observable.create {
            for (item in array) {
                Thread.sleep(1000)
                it.onNext(item)
            }
            if(!it.isDisposed)
                it.onComplete()
        }
    }


    /**
     * Emits the emissions from two or more Observables without interleaving them.
     * Maintain the order of the observables while emitting the items.
     */
    fun getObservableForConcatOperator(): Observable<String>{
        return Observable.concat(getObservableForArray(arrayFirst), getObservableForArray(arraySecond))
    }

    /**
     * Combines multiple Observables into one by merging their emissions.
     * It will not maintain the order while emitting the items
     */
    fun getObservableForMergeOperator(): Observable<String>{
        return Observable.merge(getObservableForArray(arrayFirst), getObservableForArray(arraySecond))
    }

    /**
     * Emits items which can pass the  given condition only.
     * Here: will emit only 2,4,6,8.
     */
    fun getObservableForFilterOperator(): Observable<Int>{
        return Observable.just(1,2,3,4,5,6,7,8)
                .filter { it % 2 == 0 }
    }

    /**
     *  Eliminates duplicate values.
     */
    fun getObservableForDistinctOperator(): Observable<Int>{
        return Observable.just(1, 2, 2, 4, 5, 5, 7, 8)
                .distinct()
    }

    /**
     *  Ignores the first n values
     */
    fun getObservableForSkipOperator(): Observable<Int>{
        return Observable.just(1, 2, 3, 4, 5)
                .skip(2)
    }

    /**
     *  Emits the item at given index only.
     */
    fun getObservableForElementAtOperator(): Maybe<Int> {
        return Observable.just(1, 2, 3, 4, 5)
                .elementAt(2)
    }

    /**
     * Passes the first n items emitted by the Observable.
     */
    fun getObservableForTakeOperator(): Observable<Int> {
        return Observable.just(1, 2, 3, 4, 5)
                .take(2)
    }
}
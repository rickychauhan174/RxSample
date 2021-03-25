package com.example.rxsample.repository

import io.reactivex.Maybe
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

object RxOperatorsRepository {

    private val arrayFirst = arrayOf("F1", "F2", "F3", "F4", "F5", "F6")
    private val arraySecond = arrayOf("S1", "S2", "S3", "S4", "S5", "S6")

    fun getObservableWithMapOperator() : Observable<String>{
        return Observable.just("Rx","Sample" ,"Normal")
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .map { m -> "$m map" }
    }

    fun getObservableWithFlatMapOperator() : Observable<String>{
        return Observable.just("Rx","Sample" ,"Normal")
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .flatMap { m ->
                Observable.just("$m map")
                    .subscribeOn(Schedulers.io())

            }
    }

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


    fun getObservableForConcatOperator(): Observable<String>{
        return Observable.concat(getObservableForArray(arrayFirst), getObservableForArray(arraySecond))
    }

    fun getObservableForMergeOperator(): Observable<String>{
        return Observable.merge(getObservableForArray(arrayFirst), getObservableForArray(arraySecond))
    }

    fun getObservableForFilterOperator(): Observable<Int>{
        return Observable.just(1,2,3,4,5,6,7,8)
                .filter { it % 2 == 0 }
    }

    fun getObservableForDistinctOperator(): Observable<Int>{
        return Observable.just(1, 2, 2, 4, 5, 5, 7, 8)
                .distinct()
    }

    fun getObservableForSkipOperator(): Observable<Int>{
        return Observable.just(1, 2, 3, 4, 5)
                .skip(2)
    }

    fun getObservableForElementAtOperator(): Maybe<Int> {
        return Observable.just(1, 2, 3, 4, 5)
                .elementAt(2)
    }

    fun getObservableForTakeOperator(): Observable<Int> {
        return Observable.just(1, 2, 3, 4, 5)
                .take(2)
    }
}
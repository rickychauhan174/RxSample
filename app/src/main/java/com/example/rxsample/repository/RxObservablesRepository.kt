package com.example.rxsample.repository

import io.reactivex.*
import java.util.concurrent.TimeUnit

object RxObservablesRepository {
    fun getNormalObservable() : Observable<String>{
        return Observable.just("Rx","Sample" ,"Normal")
    }

    fun getSingleObservable() : Single<String> {
        return Single.just("Rx Sample Single")
    }

    fun getFlowableObservable() : Flowable<Int> {
        return Flowable.create({ emitter ->
            for(i in 1..1000){
                emitter.onNext(i)
            }
        }, BackpressureStrategy.DROP)

    }

    fun getMaybeObservable() : Observable<Int> {
        return Observable.just(1, 2, 3, 4)
    }

    fun getCompletableObservable() : Completable {
        return Completable.timer(1000, TimeUnit.MILLISECONDS)
    }
}
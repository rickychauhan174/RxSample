package com.example.rxsample.repository

import io.reactivex.*
import java.util.concurrent.TimeUnit

object RxObservablesRepository {
    /**
     *  Emits each item once in onNext().
     */
    fun getNormalObservable() : Observable<String>{
        return Observable.just("Rx","Sample" ,"Normal")
    }

    /**
     *  Don't have onNext()
     *  Emits item only once in onSuccess().
     */
    fun getSingleObservable() : Single<String> {
        return Single.just("Rx Sample Single")
    }

    /**
     *  Work as normal/standard observale.
     *  Supports Backpressure (ref: https://github.com/ReactiveX/RxJava/wiki/Backpressure).
     */
    fun getFlowableObservable() : Flowable<Int> {
        return Flowable.create({ emitter ->
            for(i in 1..1000){
                emitter.onNext(i)
            }
        }, BackpressureStrategy.DROP)

    }

    /**
     *  Don't have onNext()
     *  Emits item in onSuccess().
     *  May or May not emit any item
     */
    fun getMaybeObservable() : Observable<Int> {
        return Observable.just(1, 2, 3, 4)
    }

    /**
     *  Don't have onNext() & onSuccess() to emit the values.
     *  onComplete() calls after completion.
     */
    fun getCompletableObservable() : Completable {
        return Completable.timer(1000, TimeUnit.MILLISECONDS)
    }
}
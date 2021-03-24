package com.example.rxsample.repository

import android.util.Log
import io.reactivex.*
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import java.util.concurrent.TimeUnit

object RxRepository {
    fun getNormalObservable() : Observable<String>{
        return Observable.just("Rx","Sample" ,"Normal")
    }

    fun getSingleObservable() : Single<String> {
        return Single.just("Rx Sample Single")
    }

    fun getFlowableObservable() : Flowable<Int> {
        return Flowable.create(object : FlowableOnSubscribe<Int>{
            override fun subscribe(emitter: FlowableEmitter<Int>) {
                for(i in 1..1000){
                    emitter.onNext(i)
                }
            } }, BackpressureStrategy.DROP)

    }

    fun getMaybeObservable() : Observable<Int> {
        return Observable.just(1, 2, 3, 4)
    }

    fun getCompletableObservable() : Completable {
        return Completable.timer(1000, TimeUnit.MILLISECONDS)
    }

    fun getObservableWithMapOperator() : Observable<String>{
        return Observable.just("Rx","Sample" ,"Normal")
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .map { m -> m + " map" }
    }

    fun getObservableWithFlatMapOperator() : Observable<String>{
        return Observable.just("Rx","Sample" ,"Normal")
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .flatMap { m ->
                Observable.just(m + " map")
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
}
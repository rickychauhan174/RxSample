package com.example.rxsample.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import com.example.rxsample.repository.RxRepository
import io.reactivex.*
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import io.reactivex.subscribers.ResourceSubscriber
import java.util.concurrent.TimeUnit


class RxViewModel: ViewModel() {
    private val tagNormalObservable = "NORMAL"
    private val tagSingleObservable = "SINGLE"
    private val tagMaybeObservable = "MAYBE"
    private val tagFlowableObservable = "FLOWABLE"
    private val tagCompletableObservable = "COMPLETABLE"
    private val tagMapOpr = "MAP"
    private val tagFlatMapOpr = "FLATMAP"
    private val tagDebounceOpr = "DEBOUNCE"

    fun subscribeNormalObservable(){
        RxRepository.getNormalObservable().subscribe(object : Observer<String> {
            override fun onSubscribe(d: Disposable) {}
            override fun onNext(t: String) {
                Log.i(tagNormalObservable, t)
            }

            override fun onError(e: Throwable) {
                Log.e(tagNormalObservable, e.toString())
            }

            override fun onComplete() {}
        })
    }

    fun subscribeSingleObservable(){
        RxRepository.getSingleObservable().subscribe(object : SingleObserver<String> {
            override fun onSubscribe(d: Disposable) {}
            override fun onSuccess(t: String) {
                Log.i(tagSingleObservable, t)
            }

            override fun onError(e: Throwable) {
                Log.e(tagSingleObservable, e.toString())
            }
        })
    }

    fun subscribeFlowableObservable(){
        RxRepository.getFlowableObservable().subscribe(object: ResourceSubscriber<Int>() {
            override fun onNext(t: Int?) {
                Log.i(tagFlowableObservable, t.toString())
            }
            override fun onError(t: Throwable?) {
                Log.e(tagFlowableObservable, t.toString())
            }
            override fun onComplete() {}
        })
    }

    fun subscribeMaybeObservable(){
        RxRepository.getMaybeObservable().reduce { t1, t2 -> t1 + t2 }.subscribe(object : MaybeObserver<Int>{
            override fun onSubscribe(d: Disposable) {}
            override fun onSuccess(t: Int) {
                Log.i(tagMaybeObservable, t.toString())
            }
            override fun onError(e: Throwable) {
                Log.e(tagMaybeObservable, e.toString())
            }
            override fun onComplete() {}
        })
    }

    fun subscribeCompletableObservable(){
        RxRepository.getCompletableObservable().subscribe(object : CompletableObserver {
            override fun onSubscribe(d: Disposable) {}

            override fun onComplete() {
                Log.e(tagCompletableObservable, "onComplete")
            }

            override fun onError(e: Throwable) {
                Log.e(tagCompletableObservable, e.toString())
            }
        })
    }

    fun subscribeObservableWithMapOperator(){
        RxRepository.getObservableWithMapOperator().subscribe(object : Observer<String> {
            override fun onSubscribe(d: Disposable) {}
            override fun onNext(t: String) {
                Log.i(tagMapOpr, t)
            }

            override fun onError(e: Throwable) {
                Log.e(tagMapOpr, e.toString())
            }

            override fun onComplete() {}
        })
    }

    fun subscribeObservableWithFlatMapOperator(){
        RxRepository.getObservableWithFlatMapOperator().subscribe(object : Observer<String> {
            override fun onSubscribe(d: Disposable) {}
            override fun onNext(t: String) {
                Log.i(tagFlatMapOpr, t)
            }

            override fun onError(e: Throwable) {
                Log.e(tagFlatMapOpr, e.toString())
            }

            override fun onComplete() {}
        })
    }

    fun subscribeObservableForDebounceOperator(){
        RxRepository.getObservableForDebounce().debounce(500, TimeUnit.MILLISECONDS)
            .subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
            .subscribe(object : Observer<Int>{
                override fun onSubscribe(d: Disposable) {}
                override fun onNext(t: Int) {
                    Log.i(tagDebounceOpr, t.toString())
                }

                override fun onError(e: Throwable) {
                    Log.e(tagDebounceOpr, e.toString())
                }

                override fun onComplete() {

                }

            })
    }
}
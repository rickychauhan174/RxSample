package com.example.rxsample.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import com.example.rxsample.repository.RxObservablesRepository
import io.reactivex.CompletableObserver
import io.reactivex.MaybeObserver
import io.reactivex.Observer
import io.reactivex.SingleObserver
import io.reactivex.disposables.Disposable
import io.reactivex.subscribers.ResourceSubscriber


class RxObservablesViewModel: ViewModel() {
    private val tagNormalObservable = "NORMAL"
    private val tagSingleObservable = "SINGLE"
    private val tagMaybeObservable = "MAYBE"
    private val tagFlowableObservable = "FLOWABLE"
    private val tagCompletableObservable = "COMPLETABLE"

    fun subscribeNormalObservable(){
        RxObservablesRepository.getNormalObservable().subscribe(object : Observer<String> {
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
        RxObservablesRepository.getSingleObservable().subscribe(object : SingleObserver<String> {
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
        RxObservablesRepository.getFlowableObservable().subscribe(object: ResourceSubscriber<Int>() {
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
        RxObservablesRepository.getMaybeObservable().reduce { t1, t2 -> t1 + t2 }.subscribe(object : MaybeObserver<Int>{
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
        RxObservablesRepository.getCompletableObservable().subscribe(object : CompletableObserver {
            override fun onSubscribe(d: Disposable) {}

            override fun onComplete() {
                Log.e(tagCompletableObservable, "onComplete")
            }

            override fun onError(e: Throwable) {
                Log.e(tagCompletableObservable, e.toString())
            }
        })
    }
}
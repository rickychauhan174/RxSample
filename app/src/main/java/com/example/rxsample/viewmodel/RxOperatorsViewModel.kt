package com.example.rxsample.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import com.example.rxsample.repository.RxOperatorsRepository
import io.reactivex.MaybeObserver
import io.reactivex.Observer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import java.util.concurrent.TimeUnit


class RxOperatorsViewModel: ViewModel() {
    private val tagMapOpr = "MAP"
    private val tagFlatMapOpr = "FLATMAP"
    private val tagDebounceOpr = "DEBOUNCE"
    private val tagConcatOpr = "CONCAT"
    private val tagMergeOpr = "MERGE"
    private val tagFilterOpr = "FILTER"
    private val tagDistinctOpr = "DISTINCT"
    private val tagSkipOpr = "SKIP"
    private val tagElementAtOpr = "ELEMENTAT"
    private val tagTakeOpr = "TAKE"

    fun subscribeObservableWithMapOperator(){
        RxOperatorsRepository.getObservableWithMapOperator().subscribe(object : Observer<String> {
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
        RxOperatorsRepository.getObservableWithFlatMapOperator().subscribe(object : Observer<String> {
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
        RxOperatorsRepository.getObservableForDebounce().debounce(500, TimeUnit.MILLISECONDS)
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

    fun subscribeObservableForConcatOperator(){
        RxOperatorsRepository.getObservableForConcatOperator()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(object : Observer<String>{
                    override fun onSubscribe(d: Disposable) {}
                    override fun onNext(t: String) {
                        Log.i(tagConcatOpr, t)
                    }
                    override fun onError(e: Throwable) {
                        Log.e(tagConcatOpr, e.toString())
                    }
                    override fun onComplete() {}

                })
    }

    fun subscribeObservableForMergeOperator(){
        RxOperatorsRepository.getObservableForMergeOperator()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(object : Observer<String>{
                    override fun onSubscribe(d: Disposable) {}
                    override fun onNext(t: String) {
                        Log.i(tagMergeOpr, t)
                    }
                    override fun onError(e: Throwable) {
                        Log.e(tagMergeOpr, e.toString())
                    }
                    override fun onComplete() {}

                })
    }

    fun subscribeObservableForFilterOperator(){
        RxOperatorsRepository.getObservableForFilterOperator()
                .subscribe(object : Observer<Int>{
                    override fun onSubscribe(d: Disposable) {}
                    override fun onNext(t: Int) {
                        Log.i(tagFilterOpr, t.toString())
                    }
                    override fun onError(e: Throwable) {
                        Log.e(tagFilterOpr, e.toString())
                    }
                    override fun onComplete() {}
                })
    }

    fun subscribeObservableForDistinctOperator(){
        RxOperatorsRepository.getObservableForDistinctOperator()
                .subscribe(object : Observer<Int>{
                    override fun onSubscribe(d: Disposable) {}
                    override fun onNext(t: Int) {
                        Log.i(tagDistinctOpr, t.toString())
                    }
                    override fun onError(e: Throwable) {
                        Log.e(tagDistinctOpr, e.toString())
                    }
                    override fun onComplete() {}
                })
    }

    fun subscribeObservableForSkipOperator(){
        RxOperatorsRepository.getObservableForSkipOperator()
                .subscribe(object : Observer<Int>{
                    override fun onSubscribe(d: Disposable) {}
                    override fun onNext(t: Int) {
                        Log.i(tagSkipOpr, t.toString())
                    }
                    override fun onError(e: Throwable) {
                        Log.e(tagSkipOpr, e.toString())
                    }
                    override fun onComplete() {}
                })
    }

    fun subscribeObservableForElementAtOperator(){
        RxOperatorsRepository.getObservableForElementAtOperator()
                .subscribe(object : MaybeObserver<Int>{
                    override fun onSubscribe(d: Disposable) {}
                    override fun onSuccess(t: Int) {
                        Log.i(tagElementAtOpr, t.toString())
                    }
                    override fun onError(e: Throwable) {
                        Log.e(tagElementAtOpr, e.toString())
                    }
                    override fun onComplete() { }
                })
    }

    fun subscribeObservableForTakeOperator(){
        RxOperatorsRepository.getObservableForTakeOperator()
                .subscribe(object : Observer<Int>{
                    override fun onSubscribe(d: Disposable) {}
                    override fun onNext(t: Int) {
                        Log.i(tagTakeOpr, t.toString())
                    }
                    override fun onError(e: Throwable) {
                        Log.e(tagTakeOpr, e.toString())
                    }
                    override fun onComplete() {}
                })
    }
}
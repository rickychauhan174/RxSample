package com.example.rxsample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.example.rxsample.viewmodel.RxViewModel

class MainActivity : AppCompatActivity() {
    private lateinit var rxViewModel: RxViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        rxViewModel = ViewModelProvider(this).get(RxViewModel::class.java)
        observeWithDebounceOperator()
    }

    private fun observeNormalObservable(){
        rxViewModel.subscribeNormalObservable()
    }

    private fun observeSingleObservable(){
        rxViewModel.subscribeSingleObservable()
    }

    private fun observeFlowableObservable(){
        rxViewModel.subscribeFlowableObservable()
    }

    private fun observeMaybeObservable(){
        rxViewModel.subscribeMaybeObservable()
    }

    private fun observeCompletableObservable(){
        rxViewModel.subscribeCompletableObservable()
    }

    private fun observeWithMapOperator(){
        rxViewModel.subscribeObservableWithMapOperator()
    }

    private fun observeWithFlatMapOperator(){
        rxViewModel.subscribeObservableWithFlatMapOperator()
    }

    private fun observeWithDebounceOperator(){
        rxViewModel.subscribeObservableForDebounceOperator()
    }
}
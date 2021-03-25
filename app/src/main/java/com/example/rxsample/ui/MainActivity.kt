package com.example.rxsample.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.example.rxsample.R
import com.example.rxsample.viewmodel.RxObservablesViewModel
import com.example.rxsample.viewmodel.RxOperatorsViewModel

class MainActivity : AppCompatActivity() {
    private lateinit var rxObservablesViewModel: RxObservablesViewModel
    private lateinit var rxOperatorsViewModel: RxOperatorsViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        rxObservablesViewModel = ViewModelProvider(this).get(RxObservablesViewModel::class.java)
        rxOperatorsViewModel = ViewModelProvider(this).get(RxOperatorsViewModel::class.java)

        //Call the specific methods for Observables and Operators
        observeWithTakeOperator()
    }

    //Observables
    private fun observeNormalObservable(){
        rxObservablesViewModel.subscribeNormalObservable()
    }

    private fun observeSingleObservable(){
        rxObservablesViewModel.subscribeSingleObservable()
    }

    private fun observeFlowableObservable(){
        rxObservablesViewModel.subscribeFlowableObservable()
    }

    private fun observeMaybeObservable(){
        rxObservablesViewModel.subscribeMaybeObservable()
    }

    private fun observeCompletableObservable(){
        rxObservablesViewModel.subscribeCompletableObservable()
    }


    // Operators
    private fun observeWithMapOperator(){
        rxOperatorsViewModel.subscribeObservableWithMapOperator()
    }

    private fun observeWithFlatMapOperator(){
        rxOperatorsViewModel.subscribeObservableWithFlatMapOperator()
    }

    private fun observeWithDebounceOperator(){
        rxOperatorsViewModel.subscribeObservableForDebounceOperator()
    }

    private fun observeWithConcatOperator(){
        rxOperatorsViewModel.subscribeObservableForConcatOperator()
    }

    private fun observeWithMergeOperator(){
        rxOperatorsViewModel.subscribeObservableForMergeOperator()
    }

    private fun observeWithFilterOperator(){
        rxOperatorsViewModel.subscribeObservableForFilterOperator()
    }

    private fun observeWithDistinctOperator(){
        rxOperatorsViewModel.subscribeObservableForDistinctOperator()
    }

    private fun observeWithSkipOperator(){
        rxOperatorsViewModel.subscribeObservableForSkipOperator()
    }

    private fun observeWithElementAtOperator(){
        rxOperatorsViewModel.subscribeObservableForElementAtOperator()
    }

    private fun observeWithTakeOperator(){
        rxOperatorsViewModel.subscribeObservableForTakeOperator()
    }
}
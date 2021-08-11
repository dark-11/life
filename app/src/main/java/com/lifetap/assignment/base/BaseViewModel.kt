package com.lifetap.assignment.base

import androidx.lifecycle.ViewModel
import io.reactivex.disposables.CompositeDisposable
/**
 * Following MVVM pattern, created the base classes
 */
abstract class BaseViewModel : ViewModel() {

    val mDisposables: CompositeDisposable = CompositeDisposable()

    override fun onCleared() {
        mDisposables.clear()
        super.onCleared()
    }

    fun cleared() = onCleared()
}
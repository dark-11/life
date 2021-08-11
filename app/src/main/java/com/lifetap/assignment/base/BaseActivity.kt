package com.lifetap.assignment.base

import android.os.Bundle
import dagger.android.AndroidInjection
import dagger.android.DaggerActivity

/**
 * Following MVVM pattern, created the base classes
 */
abstract class BaseActivity : DaggerActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
    }
}
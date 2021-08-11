package com.lifetap.assignment.base

import com.lifetap.assignment.di.component.DaggerApplicationComponent
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication

/**
 * Following MVVM pattern, created the base classes - base application class having DI
 */
class BaseApplication : DaggerApplication() {


    override fun onCreate() {
        super.onCreate()
        initDependencyGraph()
    }


    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        return DaggerApplicationComponent.builder().application(this).build()
    }

    open fun initDependencyGraph() {
        DaggerApplicationComponent.builder()
            .application(this)
            .build()
            .inject(this)
    }
}
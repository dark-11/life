package com.lifetap.assignment.di.builder

import com.lifetap.assignment.ui.bubble.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector
/**
 * Following MVVM pattern, created the DI module for activities
 */
@Module
abstract class ActivityBuilder {
    @ContributesAndroidInjector
    abstract fun bindMainActivity(): MainActivity
}
package com.lifetap.assignment.di.component

import com.lifetap.assignment.base.BaseApplication
import com.lifetap.assignment.di.builder.ActivityBuilder
import com.lifetap.assignment.di.module.ApplicationModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector
import javax.inject.Singleton

@Singleton
@Component(
    modules = arrayOf(
        AndroidInjectionModule::class,
        ActivityBuilder::class,
        ApplicationModule::class
    )
)
interface ApplicationComponent : AndroidInjector<BaseApplication> {

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun application(application: BaseApplication): Builder
        fun build(): ApplicationComponent
    }

    override fun inject(app: BaseApplication)
}
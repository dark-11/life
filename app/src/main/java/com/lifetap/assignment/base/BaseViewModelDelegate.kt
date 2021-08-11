package com.lifetap.assignment.base

import android.content.Context
/**
 * Following MVVM pattern, created the base classes
 */
interface BaseViewModelDelegate {
    val ctx: Context
    fun resources() = ctx.resources!!
}
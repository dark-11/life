package com.lifetap.assignment.ui.bubble.item

import com.lifetap.assignment.base.BaseViewModelDelegate
/**
 * Following MVVM pattern, Interface to communicate with UI & ViewModel
 *
 * **/
interface ItemViewModelDelegate: BaseViewModelDelegate {
    fun onImageClick()
}
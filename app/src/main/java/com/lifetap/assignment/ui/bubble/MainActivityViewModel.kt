package com.lifetap.assignment.ui.bubble

import android.util.Log
import androidx.databinding.ObservableArrayList
import androidx.databinding.ObservableList
import com.lifetap.assignment.BR
import com.lifetap.assignment.R
import com.lifetap.assignment.base.BaseViewModel
import com.lifetap.assignment.base.BaseViewModelDelegate
import com.lifetap.assignment.ui.bubble.item.ItemViewModelDelegate
import com.lifetap.assignment.ui.bubble.item.ManageBubbleItemViewModel
import me.tatarka.bindingcollectionadapter2.itembindings.OnItemBindClass
import javax.inject.Inject

class MainActivityViewModel @Inject constructor() : BaseViewModel() {
    var bubbleItemBinding = OnItemBindClass<Any>()
        .map(ManageBubbleItemViewModel::class.java, BR.viewModel, R.layout.row_item_image)!!
    var bubbleItemList: ObservableList<Any> = ObservableArrayList()
    private var bubbleItems = ArrayList<ManageBubbleItemViewModel>()
    lateinit var delegate: ItemViewModelDelegate

    fun setValues() {
        bubbleItems.clear()
        bubbleItemList.clear()
        for (i in 0..1000) {

            val itemViewModel = ManageBubbleItemViewModel()
            itemViewModel.delegate = delegate
            bubbleItems.add(itemViewModel)
        }
        bubbleItemList.addAll(bubbleItems)
    }


}
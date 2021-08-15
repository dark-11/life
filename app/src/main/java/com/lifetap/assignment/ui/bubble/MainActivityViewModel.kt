package com.lifetap.assignment.ui.bubble

import android.content.ClipData.Item
import androidx.databinding.ObservableArrayList
import androidx.databinding.ObservableList
import com.lifetap.assignment.BR
import com.lifetap.assignment.R
import com.lifetap.assignment.base.BaseViewModel
import com.lifetap.assignment.databinding.ActivityMainBinding
import com.lifetap.assignment.ui.bubble.item.ItemViewModelDelegate
import com.lifetap.assignment.ui.bubble.item.ManageBubbleItemViewModel
import me.tatarka.bindingcollectionadapter2.ItemBinding
import me.tatarka.bindingcollectionadapter2.itembindings.OnItemBindClass
import javax.inject.Inject


/**
 * ViewModel class handling the logic to inflate the UI
 */
class MainActivityViewModel @Inject constructor() : BaseViewModel() {
    var bubbleItemBinding = OnItemBindClass<Any>()
        .map(ManageBubbleItemViewModel::class.java, BR.viewModel, R.layout.row_item_image)!!
    var bubbleItemList: ObservableList<Any> = ObservableArrayList()
    private var bubbleItems = ArrayList<ManageBubbleItemViewModel>()
    lateinit var delegate: ItemViewModelDelegate

    fun setValues() {
        bubbleItems.clear()
        bubbleItemList.clear()

        for (i in 0..15) {
                       val itemViewModel = ManageBubbleItemViewModel()
            itemViewModel.delegate = delegate
            itemViewModel.init()

            if (!bubbleItems.contains(itemViewModel))
                bubbleItems.add(itemViewModel)

        }
        bubbleItemList.addAll(bubbleItems)
    }


}

interface OnItemClickListener {
    fun onItemClick(item: String?)
}
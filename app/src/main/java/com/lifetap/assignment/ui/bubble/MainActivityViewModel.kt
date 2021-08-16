package com.lifetap.assignment.ui.bubble

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.databinding.ObservableArrayList
import androidx.databinding.ObservableList
import androidx.databinding.ViewDataBinding
import com.lifetap.assignment.BR
import com.lifetap.assignment.R
import com.lifetap.assignment.base.BaseViewModel
import com.lifetap.assignment.ui.bubble.item.ItemViewModelDelegate
import com.lifetap.assignment.ui.bubble.item.ManageBubbleItemViewModel
import me.tatarka.bindingcollectionadapter2.BindingRecyclerViewAdapter
import me.tatarka.bindingcollectionadapter2.BindingRecyclerViewAdapters
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

    class LifeAdapter<T> : BindingRecyclerViewAdapter<T>() {
        override fun onCreateBinding(
            inflater: LayoutInflater?,
            @LayoutRes layoutId: Int,
            viewGroup: ViewGroup?
        ): ViewDataBinding? {
            val binding: ViewDataBinding = super.onCreateBinding(inflater, layoutId, viewGroup)
            Log.d("TAG", "created binding: $binding")
            return binding
        }

        override fun onBindBinding(
            binding: ViewDataBinding,
            bindingVariable: Int,
            @LayoutRes layoutId: Int,
            position: Int,
            item: T
        ) {
            super.onBindBinding(binding, bindingVariable, layoutId, position, item)
            Log.d("TAG", "bound binding: $binding at position: $position")
        }
    }

}


interface OnItemClickListener {
    fun onItemClick(item: String?)
}
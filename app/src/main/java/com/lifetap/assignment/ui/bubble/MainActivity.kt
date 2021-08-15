package com.lifetap.assignment.ui.bubble

import android.content.Context
import android.os.Bundle
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.lifetap.assignment.R
import com.lifetap.assignment.base.BaseActivity
import com.lifetap.assignment.databinding.ActivityMainBinding
import com.lifetap.assignment.ui.bubble.item.ItemViewModelDelegate
import javax.inject.Inject


/**
 * Entry point to the app.
 */
class MainActivity : BaseActivity(), ItemViewModelDelegate {
    private lateinit var binding: ActivityMainBinding
    @Inject
    lateinit var viewModel: MainActivityViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.viewModel = viewModel
        viewModel.delegate = this
        viewModel.setValues()

    }

    override fun onResume() {
        super.onResume()
            }
//Can be used to show some activity after click
    override fun onImageClick() {

    }

    override val ctx: Context
        get() = this@MainActivity


}

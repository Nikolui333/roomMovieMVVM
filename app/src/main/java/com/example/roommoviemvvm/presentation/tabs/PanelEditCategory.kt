package com.example.roommoviemvvm.presentation.tabs

import android.os.Bundle
import android.view.KeyEvent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.ViewModelProvider
import com.example.roommoviemvvm.R
import com.example.roommoviemvvm.data.db.MovieDatabase
import com.example.roommoviemvvm.databinding.FragmentPanelEditCategoryBinding
import com.example.roommoviemvvm.data.repositories.CategoryRepository
import com.example.roommoviemvvm.viewModels.CategoryFactory
import com.example.roommoviemvvm.viewModels.CategoryViewModel

import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import org.koin.androidx.viewmodel.ext.android.viewModel

class PanelEditCategory : BottomSheetDialogFragment(),View.OnKeyListener {

    private var binding: FragmentPanelEditCategoryBinding? = null
    private val categoriesViewModel: CategoryViewModel by viewModel()
    private var idCategory:Int? = null


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_panel_edit_category, container, false)

        idCategory = arguments?.getString("idCategory")?.toInt()
        binding?.editCategory?.setText(arguments?.getString("nameCategory").toString())
        binding?.editCategory?.setOnKeyListener(this)

        return binding?.root
    }

    override fun onKey(view: View, i: Int, keyEvent: KeyEvent): Boolean {
        when (view.id) {


            R.id.editCategory -> {
                if (keyEvent.action == KeyEvent.ACTION_DOWN && i == KeyEvent.KEYCODE_ENTER) {

                    categoriesViewModel?.startUpdateFilm(idCategory.toString().toInt(), binding?.editCategory?.text?.toString()!!)

                    binding?.editCategory?.setText("")

                    dismiss()

                    (context as FragmentActivity).supportFragmentManager.beginTransaction().replace(R.id.content, TabCategories()).commit()

                    return true
                }

            }
        }

        return false
    }

}
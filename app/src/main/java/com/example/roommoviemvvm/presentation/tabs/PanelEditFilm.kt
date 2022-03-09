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
import com.example.roommoviemvvm.databinding.FragmentPanelEditFilmBinding
import com.example.roommoviemvvm.data.repositories.FilmsRepository
import com.example.roommoviemvvm.viewModels.FilmsFactory
import com.example.roommoviemvvm.viewModels.FilmsViewModel
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import org.koin.androidx.viewmodel.ext.android.viewModel

class PanelEditFilm : BottomSheetDialogFragment(),View.OnKeyListener, View.OnClickListener {

    private var binding: FragmentPanelEditFilmBinding? = null
    private val filmsViewModel: FilmsViewModel by viewModel()
    private var idFilm:Int? = null


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_panel_edit_film, container, false)

        idFilm = arguments?.getString("idFilm")?.toInt()
        binding?.editNameFilm?.setText(arguments?.getString("nameFilm").toString())
        binding?.editCategoryFilm?.setText(arguments?.getString("categoryFilm").toString())
        binding?.editDurationFilm?.setText(arguments?.getString("priceFilm").toString())

      //  filmsViewModel = ViewModelProvider(this, factory!!).get(FilmsViewModel::class.java)

        binding?.editNameFilm?.setOnKeyListener(this)
        binding?.editCategoryFilm?.setOnKeyListener(this)
        binding?.editDurationFilm?.setOnKeyListener(this)

        binding?.buttonEditFilm?.setOnClickListener(this)


        return binding?.root
    }

    override fun onKey(view: View, i: Int, keyEvent: KeyEvent): Boolean {
        when (view.id) {


            R.id.editNameFilm -> {
                if (keyEvent.action == KeyEvent.ACTION_DOWN && i == KeyEvent.KEYCODE_ENTER) {

                    binding?.resEditNameFilm?.text = binding?.editNameFilm?.text
                    binding?.editNameFilm?.setText("")

                    return true
                }

            }

            R.id.editCategoryFilm -> {
                if (keyEvent.action == KeyEvent.ACTION_DOWN && i == KeyEvent.KEYCODE_ENTER) {

                    binding?.resEditCategoryFilm?.text = binding?.editCategoryFilm?.text
                    binding?.editCategoryFilm?.setText("")

                    return true
                }

            }

            R.id.editDurationFilm -> {
                if (keyEvent.action == KeyEvent.ACTION_DOWN && i == KeyEvent.KEYCODE_ENTER) {

                    binding?.resEditDurationFilm?.text = binding?.editDurationFilm?.text
                    binding?.editDurationFilm?.setText("")

                    return true
                }

            }
        }

        return false
    }

    override fun onClick(view: View) {
/*        filmsViewModel?.startUpdateFilm(idFilm.toString().toInt(), binding?.resEditNameFilm?.text?.toString()!!,
            binding?.resEditCategoryFilm?.text?.toString()!!, binding?.resEditDurationFilm?.text?.toString()!!)*/

        dismiss()

        (context as FragmentActivity).supportFragmentManager.beginTransaction().replace(R.id.content, TabCategories()).commit()
    }
}
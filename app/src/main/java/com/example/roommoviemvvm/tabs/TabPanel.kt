package com.example.roommoviemvvm.tabs

import android.os.Bundle
import android.view.KeyEvent
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.ViewModelProvider
import com.example.roommoviemvvm.R
import com.example.roommoviemvvm.data.db.MovieDatabase
import com.example.roommoviemvvm.databinding.FragmentTabPanelBinding
import com.example.roommoviemvvm.data.repositories.CategoryRepository
import com.example.roommoviemvvm.data.repositories.FilmsRepository
import com.example.roommoviemvvm.viewModels.CategoryFactory
import com.example.roommoviemvvm.viewModels.CategoryViewModel
import com.example.roommoviemvvm.viewModels.FilmsFactory
import com.example.roommoviemvvm.viewModels.FilmsViewModel

class TabPanel : Fragment() , View.OnClickListener, View.OnKeyListener {

    private var binding: FragmentTabPanelBinding? = null
    private var categoryRepository: CategoryRepository? = null
    private var categoryViewModel: CategoryViewModel? = null
    private var categoryFactory: CategoryFactory? = null

    private var filmRepository: FilmsRepository? = null
    private var filmViewModel: FilmsViewModel? = null
    private var filmFactory: FilmsFactory? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_tab_panel, container, false)

        val categoryDao = MovieDatabase.getInstance((context as FragmentActivity).application).categoryDAO
        categoryRepository = CategoryRepository(categoryDao)
        categoryFactory = CategoryFactory(categoryRepository!!)
        categoryViewModel = ViewModelProvider(this, categoryFactory!!).get(CategoryViewModel::class.java)

        val filmDao = MovieDatabase.getInstance((context as FragmentActivity).application).filmsDAO
        filmRepository = FilmsRepository(filmDao)
        filmFactory = FilmsFactory(filmRepository!!)
        filmViewModel = ViewModelProvider(this,filmFactory!!).get(FilmsViewModel::class.java)

        binding?.enterNameFilm?.setOnKeyListener(this)
        binding?.enterCategoryFilm?.setOnKeyListener(this)
        binding?.enterDurationFilm?.setOnKeyListener(this)

        binding?.buttonAddFilm?.setOnClickListener(this)

        binding?.buttonAddCategoryClothes?.setOnClickListener(this)
        binding?.buttonAddCategoryShoes?.setOnClickListener(this)
        binding?.buttonAddCategoryAccessories?.setOnClickListener(this)

        return binding?.root
    }


    override fun onKey(view: View, i: Int, keyEvent: KeyEvent): Boolean {
        when (view.id) {

            R.id.enterNameFilm -> {
                if (keyEvent.action == KeyEvent.ACTION_DOWN && i == KeyEvent.KEYCODE_ENTER) {
                    binding?.resEnterNameFilm?.text = binding?.enterNameFilm?.text
                    binding?.enterNameFilm?.setText("")
                    return true
                }

            }

            R.id.enterCategoryFilm -> {
                if (keyEvent.action == KeyEvent.ACTION_DOWN && i == KeyEvent.KEYCODE_ENTER) {
                    binding?.resEnterCategoryFilm?.text = binding?.enterCategoryFilm?.text
                    binding?.enterCategoryFilm?.setText("")
                    return true
                }

            }

            R.id.enterDurationFilm -> {
                if (keyEvent.action == KeyEvent.ACTION_DOWN && i == KeyEvent.KEYCODE_ENTER) {
                    binding?.resEnterDurationFilm?.text = binding?.enterDurationFilm?.text
                    binding?.enterDurationFilm?.setText("")
                    return true
                }

            }
        }

        return false
    }

    override fun onClick(view: View) {

        when(view.id) {

            R.id.buttonAddCategoryClothes -> {

                categoryViewModel?.startInsert(binding?.buttonAddCategoryClothes?.text?.toString()!!)

            }

            R.id.buttonAddCategoryShoes -> {

                categoryViewModel?.startInsert(binding?.buttonAddCategoryShoes?.text?.toString()!!)

            }

            R.id.buttonAddCategoryAccessories -> {

                categoryViewModel?.startInsert(binding?.buttonAddCategoryAccessories?.text?.toString()!!)

            }

            R.id.buttonAddFilm -> {

                filmViewModel?.startInsert(binding?.resEnterNameFilm?.text?.toString()!!,
                    binding?.resEnterCategoryFilm?.text?.toString()!!,
                    binding?.resEnterDurationFilm?.text?.toString()!!)

                clearResEnterFilm()

            }
        }

    }

    private fun clearResEnterFilm() {
        binding?.resEnterNameFilm?.setText("")
        binding?.resEnterCategoryFilm?.setText("")
        binding?.resEnterDurationFilm?.setText("")

    }
}
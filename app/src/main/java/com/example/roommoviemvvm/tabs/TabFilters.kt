package com.example.roommoviemvvm.tabs

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.roommoviemvvm.R
import com.example.roommoviemvvm.data.MovieDatabase
import com.example.roommoviemvvm.databinding.FragmentTabFiltersBinding
import com.example.roommoviemvvm.models.FilmsModel
import com.example.roommoviemvvm.repositories.FilmsRepository
import com.example.roommoviemvvm.viewModels.FilmsFactory
import com.example.roommoviemvvm.viewModels.FilmsViewModel
import androidx.lifecycle.Observer

class TabFilters : Fragment() {
    private var binding: FragmentTabFiltersBinding? = null
    private var filmRepository: FilmsRepository? = null
    private var filmViewModel: FilmsViewModel? = null
    private var filmFactory: FilmsFactory? = null
    private var filmAdapter: FilmsAdapter? = null


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_tab_filters, container, false)

        val filmsDao = MovieDatabase.getInstance((context as FragmentActivity).application).filmsDAO
        filmRepository = FilmsRepository(filmsDao)
        filmFactory = FilmsFactory(filmRepository!!)
        filmViewModel = ViewModelProvider(this, filmFactory!!).get(FilmsViewModel::class.java)
        initRecyclerFilterFilms()



        return binding?.root
    }

    private fun initRecyclerFilterFilms(){
        binding?.recyclerFilter?.layoutManager = LinearLayoutManager(context)
        filmAdapter = FilmsAdapter({filmModel: FilmsModel ->deleteFilm(filmModel)},
            {filmsModel: FilmsModel ->editFilm(filmsModel)})
        binding?.recyclerFilter?.adapter = filmAdapter

        displayFilterFilms()
    }

    private fun displayFilterFilms(){
        filmViewModel?.getFilter("боевик", "120")?.observe(viewLifecycleOwner, Observer {
            filmAdapter?.setList(it)
            filmAdapter?.notifyDataSetChanged()
        })
    }

    private fun deleteFilm(filmModel:FilmsModel) {
        filmViewModel?.deleteFilm(filmModel)
    }

    private fun editFilm(filmsModel:FilmsModel) {
        val panelEditFilm = PanelEditFilm()
        val parameters = Bundle()
        parameters.putString("idFilm", filmsModel.id.toString())
        parameters.putString("nameFilm", filmsModel.name)
        parameters.putString("categoryFilm", filmsModel.category)
        parameters.putString("priceFilm", filmsModel.duration)
        panelEditFilm.arguments = parameters

        panelEditFilm.show((context as FragmentActivity).supportFragmentManager, "editFilm")
    }
}
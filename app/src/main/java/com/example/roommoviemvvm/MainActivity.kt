package com.example.roommoviemvvm

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.databinding.DataBindingUtil
import com.example.roommoviemvvm.databinding.ActivityMainBinding
import com.example.roommoviemvvm.tabs.TabCategories
import com.example.roommoviemvvm.tabs.TabFilms
import com.example.roommoviemvvm.tabs.TabFilters
import com.example.roommoviemvvm.tabs.TabPanel
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity(), BottomNavigationView.OnNavigationItemSelectedListener {

    private var binding: ActivityMainBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)


        supportFragmentManager.beginTransaction().replace(R.id.content, TabPanel()).commit()

        binding?.bottomNav?.setOnNavigationItemSelectedListener(this)
        binding?.bottomNav?.selectedItemId = R.id.panelItemBottomNav

    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {

        when(item.itemId) {
            R.id.panelItemBottomNav -> supportFragmentManager.beginTransaction().replace(R.id.content, TabPanel()).commit()
            R.id.catalogProductsItemBottomNav -> supportFragmentManager.beginTransaction().replace(R.id.content, TabFilms()).commit()
            R.id.catalogClothesItemBottomNav -> supportFragmentManager.beginTransaction().replace(R.id.content, TabFilters()).commit()
            R.id.catalogCategoriesItemBottomNav -> supportFragmentManager.beginTransaction().replace(R.id.content, TabCategories()).commit()
        }

        return true
    }
}
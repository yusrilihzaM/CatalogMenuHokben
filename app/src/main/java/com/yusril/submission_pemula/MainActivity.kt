package com.yusril.submission_pemula

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.yusril.submission_pemula.adapter.CardMenuAdapter
import com.yusril.submission_pemula.adapter.GridMenuAdapter
import com.yusril.submission_pemula.adapter.ListMenuAdapter
import com.yusril.submission_pemula.adapter.adapterCardList
import com.yusril.submission_pemula.data.MenusData


class MainActivity : AppCompatActivity() {
    private lateinit var rvMenu: RecyclerView

    private var list: ArrayList<com.yusril.submission_pemula.model.Menu> = arrayListOf()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        rvMenu=findViewById(R.id.rv_menu)
        rvMenu.setHasFixedSize(true)

        list.addAll(MenusData.listData)
        showRvList()
    }

    private fun showRvList() {
        rvMenu.layoutManager = LinearLayoutManager(this)// set Layut rv secara vertical
        val listMenuAdapter = ListMenuAdapter(list)// inisisasi adapter
        rvMenu.adapter = listMenuAdapter// set rvHeroes dgn adapter
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        setMode(item.itemId)
        return super.onOptionsItemSelected(item)
    }

    private fun setMode(selectedMode: Int) {
        when (selectedMode) {
            R.id.action_list -> {
                showRvList()
            }
            R.id.action_grid -> {
                showRvGrid()
            }
            R.id.action_cardview_list -> {
                showRvCardList()
            }
            R.id.action_cardview -> {
                showRvCard()
            }
            R.id.action_profil -> {
                profil()
            }
        }
    }

    private fun profil() {
        startActivity(Intent(this, ProfilActivity::class.java))
    }

    private fun showRvCard() {
        rvMenu.layoutManager=LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        val cardMenuAdapter = CardMenuAdapter(list)// inisisasi adapter
        rvMenu.adapter = cardMenuAdapter// set rvHeroes dgn adapter
    }

    private fun showRvGrid() {
        rvMenu.layoutManager = GridLayoutManager(this,2)// set Layut rv secara vertical
        val gridMenuAdapter = GridMenuAdapter(list)// inisisasi adapter
        rvMenu.adapter = gridMenuAdapter// set rvHeroes dgn adapter
    }

    private fun showRvCardList() {
        rvMenu.layoutManager = LinearLayoutManager(this)// set Layut rv secara vertical
        val adapterCardList = adapterCardList(list)// inisisasi adapter
        rvMenu.adapter = adapterCardList// set rvHeroes dgn adapter
    }
}



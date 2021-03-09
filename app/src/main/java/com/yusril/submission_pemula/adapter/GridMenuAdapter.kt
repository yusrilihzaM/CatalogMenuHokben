package com.yusril.submission_pemula.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.yusril.submission_pemula.activity.DetailActivity
import com.yusril.submission_pemula.R
import com.yusril.submission_pemula.model.Menu

class GridMenuAdapter(private val listMenu: ArrayList<Menu>): RecyclerView.Adapter<GridMenuAdapter.GridViewHolder>() {
    inner class GridViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var imgPhoto: ImageView = itemView.findViewById(R.id.foto_menu)
        var itemList: LinearLayout =itemView.findViewById(R.id.grid)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GridViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.item_grid, parent, false)
        return GridViewHolder(view)
    }

    override fun onBindViewHolder(holder: GridViewHolder, position: Int) {
        val menu = listMenu[position]
        Glide.with(holder.itemView.context)
                .load(menu.foto)
                .apply(RequestOptions().override(350, 550))
                .into(holder.imgPhoto)
        val data = Menu(
            menu.nama,
            menu.harga,
            menu.komposisi,
            menu.foto
        )
        holder.itemList.setOnClickListener {
            Toast.makeText(holder.itemView.context, "Menu " + menu.nama, Toast.LENGTH_SHORT).show()
            val context=holder.imgPhoto.context
            val intent = Intent( context, DetailActivity::class.java)
            intent.putExtra(DetailActivity.EXTRA_DATA, data)
            context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return listMenu.size
    }
}
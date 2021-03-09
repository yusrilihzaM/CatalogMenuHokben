package com.yusril.submission_pemula.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.yusril.submission_pemula.activity.DetailActivity
import com.yusril.submission_pemula.R
import com.yusril.submission_pemula.model.Menu

class ListMenuAdapter(private val listMenu: ArrayList<Menu>): RecyclerView.Adapter<ListMenuAdapter.ListViewHolder>() {
    inner class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)  {
        var tvNamaMenu: TextView =itemView.findViewById(R.id.txt_nama_menu)
        var tvHarga: TextView =itemView.findViewById(R.id.txt_harga)
        var imgMenu: ImageView =itemView.findViewById(R.id.foto_menu)
        var itemList:LinearLayout=itemView.findViewById(R.id.item_list)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val view:View= LayoutInflater.from(parent.context).inflate(R.layout.item_list,parent,false)
        return ListViewHolder(view)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val menu=listMenu[position]
        val harga:String="Rp. "+menu.harga
        holder.tvNamaMenu.text=menu.nama
        holder.tvHarga.text=harga
        Glide.with(holder.itemView.context)
                .load(menu.foto)
                .apply(RequestOptions().override(350,350))
                .into(holder.imgMenu)
        val data = Menu(
            menu.nama,
            menu.harga,
            menu.komposisi,
            menu.foto
        )
        holder.itemList.setOnClickListener {
            Toast.makeText(holder.itemView.context, "Menu " + menu.nama, Toast.LENGTH_SHORT).show()
            val context=holder.tvNamaMenu.context
            val intent = Intent( context, DetailActivity::class.java)
            intent.putExtra(DetailActivity.EXTRA_DATA, data)
            context.startActivity(intent)
        }
//
    }

    override fun getItemCount(): Int {
        return listMenu.size
    }
}
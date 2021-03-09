package com.yusril.submission_pemula.adapter

import android.annotation.SuppressLint
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.yusril.submission_pemula.DetailActivity
import com.yusril.submission_pemula.R
import com.yusril.submission_pemula.model.Menu
import java.net.URLEncoder

class adapterCardList(private val listMenu: ArrayList<Menu>) : RecyclerView.Adapter<adapterCardList.adapterCardListViewHolder>(){
    inner class adapterCardListViewHolder(itemView: View) :RecyclerView.ViewHolder(itemView){
        var tvNamaMenu:TextView=itemView.findViewById(R.id.txt_nama_menu)
        var tvHarga:TextView=itemView.findViewById(R.id.txt_harga)
        var imgMenu:ImageView=itemView.findViewById(R.id.foto_menu)
        var itemList: CardView =itemView.findViewById(R.id.card_vertical)
        var btnPesan: ImageButton =itemView.findViewById(R.id.btn_pesan)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): adapterCardListViewHolder {
        val view:View=LayoutInflater.from(parent.context).inflate(R.layout.item_list_card,parent,false)
        return adapterCardListViewHolder(view)
    }

    @SuppressLint("SetTextI18n", "QueryPermissionsNeeded")
    override fun onBindViewHolder(holder: adapterCardListViewHolder, position: Int) {
       val menu=listMenu[position]
        holder.tvNamaMenu.text=menu.nama
        holder.tvHarga.text="Rp. "+menu.harga
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
        val context=holder.tvNamaMenu.context
        holder.itemList.setOnClickListener {
            Toast.makeText(holder.itemView.context, "Menu " + menu.nama, Toast.LENGTH_SHORT).show()

            val intent = Intent( context, DetailActivity::class.java)
            intent.putExtra(DetailActivity.EXTRA_DATA, data)
            context.startActivity(intent)

        }
        holder.btnPesan.setOnClickListener {
            val nama:String?=menu.nama
            val harga:String?=menu.harga
            val message:String="Saya Memesan " +
                    "$nama Rp. $harga"
            val packageManager: PackageManager = context.packageManager
            val i = Intent(Intent.ACTION_VIEW)

            try {
                val url =
                    "https://api.whatsapp.com/send?phone=" + "+6285155303939" + "&text=" + URLEncoder.encode(
                        message, "UTF-8"
                    )
                i.setPackage("com.whatsapp")
                i.data = Uri.parse(url)
                if (i.resolveActivity(packageManager) != null) {
                    context.startActivity(i)
                }
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }

    override fun getItemCount(): Int {
        return listMenu.size
    }
}
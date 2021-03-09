package com.yusril.submission_pemula.activity

import android.annotation.SuppressLint
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Bundle
import android.view.MenuItem
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.yusril.submission_pemula.R
import com.yusril.submission_pemula.model.Menu
import java.net.URLEncoder


class DetailActivity : AppCompatActivity() {
    companion object {
        const val EXTRA_DATA = "extra_data"
    }

    private lateinit var tvHarga: TextView
    private lateinit var imgMenu: ImageView
    private lateinit var tvKomposisi: TextView
    private lateinit var btnPesan: Button
    private var message:String=""
    private var share:String=""
    @SuppressLint("SetTextI18n", "QueryPermissionsNeeded")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        tvHarga=findViewById(R.id.txt_harga)
        imgMenu=findViewById(R.id.foto_menu)
        tvKomposisi=findViewById(R.id.txt_komposisi)
        btnPesan=findViewById(R.id.btn_pesan)

        val data=intent.getParcelableExtra<Menu>(EXTRA_DATA) as Menu
        supportActionBar?.title = data.nama
        tvHarga.text="Rp. "+data.harga
        tvKomposisi.text=data.komposisi
        Glide.with(this)
            .load(data.foto)
            .apply(RequestOptions().override(350, 350))
            .into(imgMenu)

        val nama:String?=data.nama
        val harga:String?=data.harga
        message="Saya Memesan " +
                "$nama Rp. $harga"
        share="Nama Makanan $nama\n" +
                "Harga Makanan $harga"
        btnPesan.setOnClickListener {
            val packageManager: PackageManager = this.packageManager
            val i = Intent(Intent.ACTION_VIEW)

            try {
                val url =
                    "https://api.whatsapp.com/send?phone=" + "+6285155303939" + "&text=" + URLEncoder.encode(
                        message, "UTF-8"
                    )
                i.setPackage("com.whatsapp")
                i.data = Uri.parse(url)
                if (i.resolveActivity(packageManager) != null) {
                    this.startActivity(i)
                }
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }

    override fun onCreateOptionsMenu(menu: android.view.Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_detail, menu)
        return super.onCreateOptionsMenu(menu)
    }


    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        setMode(item.itemId)
        return super.onOptionsItemSelected(item)
    }

    private fun setMode(itemId: Int) {
        when (itemId) {
            R.id.shareButton -> {
                val intent= Intent()
                intent.action=Intent.ACTION_SEND
                intent.putExtra(Intent.EXTRA_TEXT,share)
                intent.type="text/plain"
                startActivity(Intent.createChooser(intent,"Share To:"))
            }

        }
    }
}
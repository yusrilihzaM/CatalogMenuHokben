package com.yusril.submission_pemula.data

import com.yusril.submission_pemula.R
import com.yusril.submission_pemula.model.Menu

object MenusData {
    private val menuNama = arrayOf(
        "UNAGI KABAYAKI DON",
        "HOKA HEMAT 1",
        "HOKA HEMAT 2",
        "HOKA HEMAT 3",
        "Set Beef Yakiniku",
        "Set Chicken Teriyaki",
        "BENTO SPECIAL 1",
        "BENTO SPECIAL 2",
        "Premium Set Seafood",
        "KIDZU BENTO",
        "EBI MENTAI RICE",
        "SIMPLE SET TERIYAKI"
    )
    private val menuPrice = arrayOf(
        "65.000",
        "26.000",
        "26.000",
        "26.000",
        "61.000",
        "50.000",
        "55.000",
        "60.000",
        "59.000",
        "37.000",
        "45.000",
        "39.000"
    )

    private val menuKomposisi = arrayOf(
        "Set menu yang disajikan dalam 1 mangkok, lengkap dengan nasi dan unagi kabayaki yang dicampur saus teriyaki tare dengan taburan wijen",
        "Nasi spesial HokBen, Salad, Ekkado dan 3 Egg Chicken Roll *Salad hanya untuk makan di tempat",
        "Nasi spesial HokBen, Salad, 2 Tori Ball dan 2 Egg Chicken Roll *Salad hanya untuk makan di tempa",
        "Nasi spesial HokBen, Salad, 2 Egg Chicken Roll dan 2 Shrimp Roll",
        "Beef Yakiniku, Chicken Katsu, Nasi, Sup, Salad dan Ocha. *Salad dan sup hanya tersedia untuk makan di tempat.",
        "Shrimp Roll, Chicken Teriyaki, Tori Ball, Egg Chicken Roll, Nasi, Sup, Salad dan Ocha. *Salad &Sup hanya untuk makan di tempat.",
        "Nasi, Salad, Chicken Teriyaki, Tori No Teba dan Ebi Furai *salad hanya untuk makan di tempat",
        "Nasi, Salad, Beef Yakiniku, Tori no Teba dan Kani Roll *Salad hanya untuk makan di tempat",
        "Nasi, Beef Teriyaki / Yakiniku, Ebi Furai, Shrimp Roll, Ekkado, Clear Soup, Salad dan Ocha *Salad dan sup hanya tersedia untuk makan di tempat.",
        "Produk olahan daging ayam, digulung dengan telur dadar dan dimasak dengan metode Deep Frying Oil, telur orak-arik, tanpa tambahan perasa, dan nasi yang dimasak dengan beras spesial HokBen.",
        "Nasi, olahan Udang dengan saus special",
        "Nasi + Chicken Teriyaki + Egg Chicken Roll 2 pcs *Salad hanya untuk makan di tempat."
    )
    private val menuFoto = intArrayOf(
            R.drawable._1,
            R.drawable._2,
            R.drawable._3,
            R.drawable._4,
            R.drawable._5,
            R.drawable._6,
            R.drawable._7,
            R.drawable._8,
            R.drawable._9,
            R.drawable._10,
            R.drawable._11,
            R.drawable._12
    )
    val listData: ArrayList<Menu>get() {
        val list = arrayListOf<Menu>()

        for(position in menuNama.indices){
            val menu = Menu()// panggil model
            menu.nama = menuNama[position]// panggil nama sesuai index
            menu.harga = menuPrice[position]// panggil harga sesuai index
            menu.komposisi = menuKomposisi[position]// panggil komposisi sesuai index
            menu.foto = menuFoto[position]// panggil foto sesuai index
            list.add(menu)
        }
        return list
    }
}
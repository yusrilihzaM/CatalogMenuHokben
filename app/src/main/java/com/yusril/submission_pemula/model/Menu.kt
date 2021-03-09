package com.yusril.submission_pemula.model

import android.os.Parcel
import android.os.Parcelable

@Suppress("SpellCheckingInspection")
data class Menu(
    var nama: String? ="",
    var harga: String? ="",
    var komposisi: String? ="",
    var foto:Int? =0

):Parcelable {
    constructor(parcel: Parcel) : this(
            parcel.readString(),
            parcel.readString(),
            parcel.readString(),
            parcel.readValue(Int::class.java.classLoader) as? Int) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(nama)
        parcel.writeString(harga)
        parcel.writeString(komposisi)
        parcel.writeValue(foto)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Menu> {
        override fun createFromParcel(parcel: Parcel): Menu {
            return Menu(parcel)
        }

        override fun newArray(size: Int): Array<Menu?> {
            return arrayOfNulls(size)
        }
    }
}


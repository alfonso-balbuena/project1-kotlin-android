package com.udacity.shoestore.models

import android.os.Parcelable
import android.widget.EditText
import androidx.databinding.InverseMethod
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Shoe(
    var name: String, var size: Double, var company: String, var description: String,
    val images: List<String> = mutableListOf()
) : Parcelable

object Converter {
    @InverseMethod("stringToDouble")
    @JvmStatic
    fun doubleToString(
        value: Double
    ): String {
        return value.toString()
    }

    @JvmStatic
    fun stringToDouble(
        value: String
    ): Double {
        return if (value.isEmpty())  0.0 else value.toDouble()
    }
}

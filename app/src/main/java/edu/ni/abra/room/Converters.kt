package edu.ni.abra.room

import androidx.room.TypeConverter
import com.google.gson.Gson
import edu.ni.abra.model.Image

class Converters {
    @TypeConverter
    fun StringToImage(value: Image?): String = Gson().toJson(value)

    @TypeConverter
    fun ImagetoString(value: String): Image? = Gson().fromJson(value, Image::class.java)
}
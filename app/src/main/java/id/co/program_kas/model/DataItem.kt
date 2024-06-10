package id.co.program_kas.model

import com.google.gson.annotations.SerializedName

data class DataItem(
    @field:SerializedName("NIM")
    val NIM: String? = null,

    @field:SerializedName("Email")
    val Email: String? = null,

    @field:SerializedName("Nama")
    val Nama: String? = null,

//    @field:SerializedName("last_name")
//    val lastName: String? = null,

    @field:SerializedName("Foto")
    val Foto: String? = null,

    )


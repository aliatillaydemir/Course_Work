package com.ayd.avatarproject.data

import android.os.Parcelable
import com.ayd.avatarproject.util.Constants.Companion.AANG_DESC
import com.ayd.avatarproject.util.Constants.Companion.AANG_IMAGE_URL
import com.ayd.avatarproject.util.Constants.Companion.APPA_DESC
import com.ayd.avatarproject.util.Constants.Companion.APPA_IMAGE_URL
import com.ayd.avatarproject.util.Constants.Companion.AZULA_DESC
import com.ayd.avatarproject.util.Constants.Companion.AZULA_IMAGE_URL
import com.ayd.avatarproject.util.Constants.Companion.FENG_DESC
import com.ayd.avatarproject.util.Constants.Companion.FENG_IMAGE_URL
import com.ayd.avatarproject.util.Constants.Companion.IROH_DESC
import com.ayd.avatarproject.util.Constants.Companion.IROH_IMAGE_URL
import com.ayd.avatarproject.util.Constants.Companion.KATARA_DESC
import com.ayd.avatarproject.util.Constants.Companion.KATARA_IMAGE_URL
import com.ayd.avatarproject.util.Constants.Companion.MOMO_DESC
import com.ayd.avatarproject.util.Constants.Companion.MOMO_IMAGE_URL
import com.ayd.avatarproject.util.Constants.Companion.OZAI_DESC
import com.ayd.avatarproject.util.Constants.Companion.OZAI_IMAGE_URL
import com.ayd.avatarproject.util.Constants.Companion.SOKKA_DESC
import com.ayd.avatarproject.util.Constants.Companion.SOKKA_IMAGE_URL
import com.ayd.avatarproject.util.Constants.Companion.SUKI_DESC
import com.ayd.avatarproject.util.Constants.Companion.SUKI_IMAGE_URL
import com.ayd.avatarproject.util.Constants.Companion.TOPH_DESC
import com.ayd.avatarproject.util.Constants.Companion.TOPH_IMAGE_URL
import com.ayd.avatarproject.util.Constants.Companion.ZHAO_DESC
import com.ayd.avatarproject.util.Constants.Companion.ZHAO_IMAGE_URL
import com.ayd.avatarproject.util.Constants.Companion.ZUKO_DESC
import com.ayd.avatarproject.util.Constants.Companion.ZUKO_IMAGE_URL
import com.google.gson.Gson
import kotlinx.parcelize.Parcelize

@Parcelize
data class Avatar(val name: String, val nationality: String, val age: String, val imageUrl: String?, val desc: String?):Parcelable{

    fun toJson(): String{
        return Gson().toJson(this)
    }
    companion object {
        fun fromJson(jsonValue: String): Avatar {
            return Gson().fromJson(jsonValue, Avatar::class.java)
        }
    }
}

    val dataModels = mutableListOf<Avatar>(
        Avatar("AANG",
            "Southern Air Temple",
            "165",
            AANG_IMAGE_URL,
            AANG_DESC),

        Avatar("APPA",
            "Air Nomad",
            "420",
            APPA_IMAGE_URL,
            APPA_DESC),

        Avatar("MOMO",
            "Air Nomad",
            "12",
            MOMO_IMAGE_URL,
            MOMO_DESC),

        Avatar("KATARA",
            "Southern Water Tribe capital city, Southern Water Tribe",
            "21",
            KATARA_IMAGE_URL,
            KATARA_DESC),

        Avatar("SOKKA",
            "Southern Water Tribe capital city, Southern Water Tribe",
            "23",
            SOKKA_IMAGE_URL,
            SOKKA_DESC),

        Avatar("TOPH",
            "Gaoling, Earth Kingdom",
            "22",
            TOPH_IMAGE_URL,
            TOPH_DESC),

        Avatar("ZUKO",
            "Fire Nation Capital, Fire Nation",
            "25",
            ZUKO_IMAGE_URL,
            ZUKO_DESC),

        Avatar("SUKI",
            "Earth Kingdom",
            "120",
            SUKI_IMAGE_URL,
        SUKI_DESC),

        Avatar("IROH",
            "Fire Nation Capital, Fire Nation",
            "258",
            IROH_IMAGE_URL,
            IROH_DESC),

        Avatar("OZAI",
            "Fire Nation",
            "146",
            OZAI_IMAGE_URL,
            OZAI_DESC),

        Avatar("AZULA",
            "Fire Nation",
            "155",
            AZULA_IMAGE_URL,
            AZULA_DESC),

        Avatar("ZHAO",
            "Fire Nation",
            "170",
            ZHAO_IMAGE_URL,
            ZHAO_DESC),

        Avatar("FENG",
            "Earth Kingdom",
            "240",
            FENG_IMAGE_URL,
            FENG_DESC)

)



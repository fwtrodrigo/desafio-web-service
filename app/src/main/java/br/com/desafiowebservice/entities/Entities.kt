package br.com.desafiowebservice.entities

import java.io.Serializable

data class Quadrinho(
    val id: Int,
    val dates: List<Date>,
    val title: String,
    var description: String,
    val issueNumber: Int,
    val images: List<Image>,
    val pageCount: Int,
    val prices: List<Price>,
    val thumbnail: Thumbnail,
) : Serializable {
    fun getDate(): String {
        return dates[0].date
    }

    fun getPrice() = prices[0].price
    fun getImage() = images[0].getFullPath()
}


data class Thumbnail(val path: String, val extension: String) : Serializable {
    fun getFullPath(): String {
        return "$path.$extension".replace("http", "https")
    }

    override fun toString(): String {
        return "( fullpath ${getFullPath()}   -    $path      -    $extension)"
    }
}

data class Image(val extension: String, val path: String) : Serializable {
    fun getFullPath(): String {
        return "$path.$extension".replace("http", "https")
    }
}

data class Date(
    val date: String,
    val type: String
) : Serializable

data class Price(
    val price: Double,
    val type: String
) : Serializable
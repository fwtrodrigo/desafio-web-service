package br.com.desafiowebservice.entities


data class Quadrinho(val id: Int, val thumbnail: Thumbnail)

data class Thumbnail(val path: String, val extension: String) {

    fun getFullPath(): String {
        return "$path.$extension"
    }

    override fun toString(): String {
        return "( fullpath ${getFullPath()}   -    $path      -    $extension)"
    }
}
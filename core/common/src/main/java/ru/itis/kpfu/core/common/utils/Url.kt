package ru.itis.kpfu.core.common.utils

private fun extractPokemonNumber(url: String): Int? {
    val regex = """\d+(?=.png)""".toRegex()
    val matchResult = regex.find(url)
    return matchResult?.value?.toIntOrNull()
}

private fun formatPokemonNumber(number: Int?): String {
    return when(number) {
        in 1..9 -> "00"
        in 10..99 -> "0"
        else -> ""
    }
}

/**
 * Заменяет оригинальную ссылку на изображение покемона на другую ссылку.
 *
 * @param originalUrl Оригинальная ссылка на изображение покемона.
 * @return Ссылка на изображение покемона с замененным URL.
 */
fun replacePokemonImageUrl(originalUrl: String): String {
    val id = formatPokemonNumber(extractPokemonNumber(originalUrl))
    return if (originalUrl.startsWith("https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/")) {
        originalUrl.replace(
            "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/",
            "https://www.pokemon.com/static-assets/content-assets/cms2/img/pokedex/full/$id"
        )
    } else {
        originalUrl
    }
}

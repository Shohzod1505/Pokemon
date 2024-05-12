package ru.itis.kpfu.core.network.data.response

import com.google.gson.annotations.SerializedName

/**
 * Класс [PokemonListResponse], представляющий ответ с информацией о списке покемонов.
 *
 * @property count Количество покемонов.
 * @property next Ссылка на следующую страницу результатов.
 * @property previous Ссылка на предыдущую страницу результатов.
 * @property results Результаты списка покемонов.
 */
data class PokemonListResponse(
    @SerializedName("count")
    val count: Int?,
    @SerializedName("next")
    val next: String?,
    @SerializedName("previous")
    val previous: Any?,
    @SerializedName("results")
    val results: List<Result?>?
)

/**
 * Класс [Result], представляющий результат списка покемонов.
 *
 * @property name Имя покемона.
 * @property url URL-адрес покемона.
 */
data class Result(
    @SerializedName("name")
    val name: String?,
    @SerializedName("url")
    val url: String?
)

/**
 * Класс [PokemonResponse], представляющий ответ с информацией о покемоне.
 *
 * @property id Идентификатор покемона.
 * @property name Имя покемона.
 * @property height Высота покемона.
 * @property weight Вес покемона.
 * @property sprites Спрайты покемона.
 * @property abilities Способности покемона.
 * @property stats Характеристики покемона.
 * @property types Типы покемона.
 */
data class PokemonResponse(
    @SerializedName("id")
    val id: Int?,
    @SerializedName("name")
    val name: String?,
    @SerializedName("height")
    val height: Int?,
    @SerializedName("weight")
    val weight: Int?,
    @SerializedName("sprites")
    val sprites: Sprites?,
    @SerializedName("abilities")
    val abilities: List<Ability>?,
    @SerializedName("stats")
    val stats: List<Stat>?,
    @SerializedName("types")
    val types: List<Type>?,
)

package ru.maxgrachev.myrandomcontacts.network

import android.icu.text.IDNA

data class RandomUserProperty(
    val info: Info,
    val results: List<Result>
) {
    data class Info(
        val page: Int,
        val results: Int,
        val seed: String,
        val version: String
    )

    data class Result(
        val email: String
    )
}

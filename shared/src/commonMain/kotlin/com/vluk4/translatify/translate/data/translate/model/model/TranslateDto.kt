package com.vluk4.translatify.translate.data.translate.model.model


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class TranslateDto(
    @SerialName("data")
    val translation: Translation,
    @SerialName("status")
    val status: String
)
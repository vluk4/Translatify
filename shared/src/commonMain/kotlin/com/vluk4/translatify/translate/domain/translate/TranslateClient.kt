package com.vluk4.translatify.translate.domain.translate

import com.vluk4.translatify.core.domain.language.Language

interface TranslateClient {
    suspend fun translate(
        fromLanguage: Language,
        fromText: String,
        toLanguage: Language
    ): String
}
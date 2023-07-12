package com.vluk4.translatify.translate.domain.translate.history

import com.vluk4.translatify.core.domain.util.CommonFlow

interface HistoryDataSource {
    fun getHistory(): CommonFlow<List<HistoryItem>>
    suspend fun insertHistoryItem(item: HistoryItem)
}
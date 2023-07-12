package com.vluk4.translatify.translate.data.history

import com.squareup.sqldelight.runtime.coroutines.asFlow
import com.squareup.sqldelight.runtime.coroutines.mapToList
import com.vluk4.translatify.core.domain.util.CommonFlow
import com.vluk4.translatify.core.domain.util.toCommonFlow
import com.vluk4.translatify.database.TranslateDatabase
import com.vluk4.translatify.translate.domain.translate.history.HistoryDataSource
import com.vluk4.translatify.translate.domain.translate.history.HistoryItem
import kotlinx.coroutines.flow.map
import kotlinx.datetime.Clock

class HistoryDataSourceImpl(
    db: TranslateDatabase
) : HistoryDataSource {

    private val queries = db.translateQueries
    override fun getHistory(): CommonFlow<List<HistoryItem>> {
        return queries
            .getHistory()
            .asFlow()
            .mapToList()
            .map { history ->
                history.map { it.toHistoryItem() }
            }
            .toCommonFlow()
    }

    override suspend fun insertHistoryItem(item: HistoryItem) {
        with(item) {
            queries.insertHistoryEntity(
                id = id,
                fromLanguageCode = fromLanguageCode,
                fromText = fromText,
                toLanguageCode = toLanguageCode,
                toText = toText,
                timestamp = Clock.System.now().toEpochMilliseconds()
            )
        }
    }
}
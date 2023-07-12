package com.vluk4.translatify.android.di

import android.app.Application
import com.squareup.sqldelight.db.SqlDriver
import com.vluk4.translatify.database.TranslateDatabase
import com.vluk4.translatify.translate.data.history.HistoryDataSourceImpl
import com.vluk4.translatify.translate.data.local.DatabaseDriverFactory
import com.vluk4.translatify.translate.data.remote.HttpClientFactory
import com.vluk4.translatify.translate.data.translate.TranslateClientImpl
import com.vluk4.translatify.translate.domain.translate.TranslateClient
import com.vluk4.translatify.translate.domain.translate.history.HistoryDataSource
import com.vluk4.translatify.translate.domain.translate.usecases.TranslateUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import io.ktor.client.*
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    @Provides
    @Singleton
    fun provideHttpClient(): HttpClient {
        return HttpClientFactory().create()
    }

    @Provides
    @Singleton
    fun provideTranslateClient(httpClient: HttpClient): TranslateClient {
        return TranslateClientImpl(httpClient)
    }

    @Provides
    @Singleton
    fun provideDatabaseDriver(app: Application): SqlDriver {
        return DatabaseDriverFactory(app).create()
    }

    @Provides
    @Singleton
    fun provideHistoryDataSource(driver: SqlDriver): HistoryDataSource {
        return HistoryDataSourceImpl(TranslateDatabase(driver))
    }

    @Provides
    @Singleton
    fun provideTranslateUseCase(
        client: TranslateClient,
        dataSource: HistoryDataSource
    ): TranslateUseCase {
        return TranslateUseCase(client, dataSource)
    }
}
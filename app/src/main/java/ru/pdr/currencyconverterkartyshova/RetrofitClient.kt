package ru.pdr.currencyconverterkartyshova

import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

private const val CLIENT_TIMEOUT = 20L
private const val baseUrl = "https://www.cbr-xml-daily.ru/archive/"

object RetrofitClient {
    private var retrofit: Retrofit? = null

    fun getClient(): Retrofit {
        if (retrofit == null) {
            retrofit = Retrofit.Builder()
                .baseUrl(baseUrl)
                .client(
                    OkHttpClient.Builder().apply {
                        val interceptor = HttpLoggingInterceptor()
                        interceptor.level = HttpLoggingInterceptor.Level.BODY
                        addInterceptor(interceptor)
                        readTimeout(CLIENT_TIMEOUT, TimeUnit.SECONDS)
                        writeTimeout(CLIENT_TIMEOUT, TimeUnit.SECONDS)
                    }.build()
                )
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(CoroutineCallAdapterFactory())
                .build()
        }
        return retrofit!!
    }
}
package ru.itis.kpfu.core.network.data.interceptor

import okhttp3.Interceptor
import okhttp3.Response
import ru.itis.kpfu.core.network.BuildConfig

internal class ApiKeyInterceptor : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        val original = chain.request()
        val newURL = original.url.newBuilder()
            .addQueryParameter("apiKey", BuildConfig.API_KEY)
            .build()

        return chain.proceed(
            original.newBuilder()
                .url(newURL)
                .build()
        )
    }
}

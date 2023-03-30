package dev.nhason.lec18_finalproject.utils

import okhttp3.Interceptor
import okhttp3.Request
import okhttp3.Response

class TokenInterceptor(
    private val queryParam: String = "api_key",
    private val queryValue: String = "988026b98ab6570e6119b6ef67a559cf"
) : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {

        val original: Request = chain.request()

        val url =
            original
                .url.newBuilder()
                .addQueryParameter(queryParam, queryValue)
                .build()

        //modify the request url:
        val request = original.newBuilder().url(url).build()

        return chain.proceed(request)
    }
}
package com.ayd.weatherapp.data.intercepter

import com.ayd.weatherapp.BuildConfig
import okhttp3.Interceptor
import okhttp3.Response

class AuthInterceptor: Interceptor {    //intercepter'ımız

    override fun intercept(chain: Interceptor.Chain): Response{
        val originalRequest = chain.request()
        val apiKeyRequest = originalRequest
            .newBuilder()
            .header("X-Api-Key", BuildConfig.API_KEY)     //header'e saldık bilgiyi, okusun bakalım. Daha sonra model classlarda tuttuğumuz bilgielri response body'si olarak biz okuyacağız.
            .build()

        return chain.proceed(apiKeyRequest)
    }

}
package com.johndoe.mycv.repository.network


import com.google.gson.FieldNamingPolicy
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import com.johndoe.mycv.repository.model.Resume
import io.reactivex.Observable
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import java.util.concurrent.TimeUnit

interface IApi {

    @GET("resume")
    fun getResume(): Observable<Resume>


    companion object {

        fun createOkHttpClient(): OkHttpClient {

            val httpClient = OkHttpClient.Builder()

            httpClient.addInterceptor { chain ->
                val original = chain.request()
                val request = original.newBuilder().build()
                chain.proceed(request)
            }
                .connectTimeout(60, TimeUnit.SECONDS)
                .writeTimeout(60, TimeUnit.SECONDS)
                .readTimeout(120, TimeUnit.SECONDS)

            return httpClient.build()
        }

        fun createGson(): Gson {
            val builder = GsonBuilder().setFieldNamingPolicy(FieldNamingPolicy.IDENTITY)
            return builder.setLenient().create()
        }

        fun createBaseUrl(): String {
            return "http://private-f2508-tufancolak.apiary-mock.com/"
        }

        fun create(): IApi {

            val retrofit = Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create(createGson()))
                .baseUrl(createBaseUrl())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(createOkHttpClient())
                .build()

            return retrofit.create(IApi::class.java)
        }
    }
}
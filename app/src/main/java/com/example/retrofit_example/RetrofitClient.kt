package com.example.retrofit_example
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

    object RetrofitClient {

        private const val BASE_URL = "https://api.quotable.io/"

        private val retrofit: Retrofit = Retrofit.Builder()

            .baseUrl(BASE_URL)

            .addConverterFactory(GsonConverterFactory.create())

            .build()

        val quoteApiService: QuoteApiService = retrofit.create(QuoteApiService::class.java)

    }

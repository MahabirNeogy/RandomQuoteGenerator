package com.example.retrofit_example

import retrofit2.Call

import retrofit2.http.GET

interface QuoteApiService {

    @GET("quotes/random")

    fun getRandomQuote(): Call<List<Quote>>

}
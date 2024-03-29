package com.example.saydaliyati

import retrofit2.Retrofit.*
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitService {
    val endpoint :Endpoint by lazy {
        Builder().baseUrl("http://192.168.1.42:8082/").
            addConverterFactory(GsonConverterFactory.create()).
            build().create(Endpoint::class.java)
    }
}
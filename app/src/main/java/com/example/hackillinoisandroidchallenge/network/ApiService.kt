package com.example.hackillinoisandroidchallenge.network

//import com.example.hackillinoisandroidchallenge.model.Event
import com.example.hackillinoisandroidchallenge.model.EventResponse
import retrofit2.http.GET
import retrofit2.Call

interface ApiService {
    @GET("/event/")
    fun getEvents(): Call<EventResponse>
}

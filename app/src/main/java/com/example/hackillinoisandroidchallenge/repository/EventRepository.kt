package com.example.hackillinoisandroidchallenge.repository

import com.example.hackillinoisandroidchallenge.network.RetrofitClient

class EventRepository {
    private val apiService = RetrofitClient.apiService

    fun getEvents() = apiService.getEvents()
}

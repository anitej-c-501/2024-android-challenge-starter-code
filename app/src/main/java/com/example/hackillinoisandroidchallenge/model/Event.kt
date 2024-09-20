package com.example.hackillinoisandroidchallenge.model


data class Event(
    val eventId: String,
    val name: String,
    val description: String,
    val startTime: Long,
    val endTime: Long,
    val locations: List<Location>,
    val sponsor: String,
    val eventType: String,
    val points: Int,
    val isAsync: Boolean,
    val mapImageUrl: String,
    val isPro: Boolean
)

data class Location(
    val description: String,
    val tags: List<String>,
    val latitude: Double,
    val longitude: Double
)


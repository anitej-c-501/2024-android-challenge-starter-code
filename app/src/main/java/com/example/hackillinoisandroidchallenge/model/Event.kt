package model

data class Event(val name: String,
                 val description: String,
                 val startTime: String,
                 val endTime: String,
                 val eventType: String,
                 val location: String)

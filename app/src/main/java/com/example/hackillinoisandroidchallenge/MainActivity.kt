package com.example.hackillinoisandroidchallenge

import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
//import androidx.compose.runtime.livedata.observeAsState
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
//import com.example.hackillinoisandroidchallenge.model.Event
import com.example.hackillinoisandroidchallenge.model.EventResponse
import com.example.hackillinoisandroidchallenge.network.ApiService
import com.example.hackillinoisandroidchallenge.ui.EventAdapter
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/* Create a schedule page that displays all event details for the hackathon!
 * Make a GET API call to the HackIllinois API event endpoint
 * Recommended: use Retrofit to create HTTP requests
 * Remember to add the libraries you want to use to your build.gradle file!
*/
private const val BASE_URL = "https://adonix.hackillinois.org"
class MainActivity : ComponentActivity() {
    private lateinit var recyclerView: RecyclerView
    lateinit var eventAdapter: EventAdapter
    lateinit var linearLayoutManager: LinearLayoutManager
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.setHasFixedSize(true)
        linearLayoutManager = LinearLayoutManager(this)
        recyclerView.layoutManager = linearLayoutManager


        getMyData();
    }

    private fun getMyData() {
        val retrofitBuilder = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiService::class.java)

        val retrofitData = retrofitBuilder.getEvents()
        retrofitData.enqueue(object : Callback<EventResponse> {
            override fun onResponse(call: Call<EventResponse>, response: Response<EventResponse>) {
                val responseBody = response.body()
                if (responseBody != null) {
                    eventAdapter = EventAdapter(baseContext, responseBody.events)
                    recyclerView.adapter = eventAdapter
                }
            }

            override fun onFailure(call: Call<EventResponse>, t: Throwable) {
                Log.d("MainActivity", "OnFailure: " + t.message)
            }
        })
    }

}


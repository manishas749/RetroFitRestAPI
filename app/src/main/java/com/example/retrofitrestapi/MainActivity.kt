package com.example.retrofitrestapi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import org.w3c.dom.Text
import retrofit2.*
import retrofit2.converter.gson.GsonConverterFactory

const val BASE_URL = "https://jsonplaceholder.typicode.com/"

class MainActivity : AppCompatActivity() {
    lateinit var myAdapter: myAdapter
    lateinit var linearLayoutManager:LinearLayoutManager
    lateinit var recyclerView: RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        recyclerView=findViewById(R.id.recycl)
        recyclerView.setHasFixedSize(true)
       recyclerView.layoutManager = LinearLayoutManager(this)

        getmyData()
    }

    private fun getmyData() {
        val retrofitBuilder = Retrofit.Builder().addConverterFactory(GsonConverterFactory.create()).baseUrl(
                BASE_URL).build().create(ApiInterface::class.java)
        val retrofitData =retrofitBuilder.getData()
        retrofitData.enqueue(object : Callback<List<dataItem>?> {
            override fun onResponse(p0: Call<List<dataItem>?>, p1: Response<List<dataItem>?>) {
              val responseBody = p1.body()!!
             myAdapter= myAdapter(responseBody)
                myAdapter.notifyDataSetChanged()

                recyclerView.adapter = myAdapter

            }

            override fun onFailure(p0: Call<List<dataItem>?>, p1: Throwable) {
              Log.d("MainActivity", "onFailure : " +p1.message)
            }
        })

    }
}
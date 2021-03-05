package com.example.fetchrewardscodingexcercise

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.fetchrewardscodingexcercise.model.HiringData
import com.example.fetchrewardscodingexcercise.retrofit.HiringDataEndPoints
import com.example.fetchrewardscodingexcercise.retrofit.RetrofitServiceBuilder
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val request = RetrofitServiceBuilder.buildService(HiringDataEndPoints::class.java)
        val call = request.getHiringData()

        call.enqueue(object : Callback<List<HiringData>> {
            override fun onResponse(
                call: Call<List<HiringData>>,
                response: Response<List<HiringData>>
            ) {
                if (response.isSuccessful) {
                    if (response.body() != null) {
                        response.body()?.forEach {
                            Log.d("Response", it.toString())
                        }
                    }
                }
            }

            override fun onFailure(call: Call<List<HiringData>>, t: Throwable) {
                Toast.makeText(this@MainActivity, "${t.message}", Toast.LENGTH_LONG).show()
                Log.d("Failure", "onFailure: ${t.message}")
            }

        })
    }
}
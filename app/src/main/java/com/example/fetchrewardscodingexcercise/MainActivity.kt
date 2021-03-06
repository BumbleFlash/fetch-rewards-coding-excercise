package com.example.fetchrewardscodingexcercise

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.fetchrewardscodingexcercise.adapter.HiringDataAdapter
import com.example.fetchrewardscodingexcercise.model.HiringData
import com.example.fetchrewardscodingexcercise.retrofit.HiringDataEndPoints
import com.example.fetchrewardscodingexcercise.retrofit.RetrofitServiceBuilder
import com.example.fetchrewardscodingexcercise.utils.HiringDataUtils
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    private var recyclerView: RecyclerView? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        recyclerView = findViewById(R.id.recyclerView)
        val request = RetrofitServiceBuilder.buildService(HiringDataEndPoints::class.java)
        val call = request.getHiringData()

        call.enqueue(object : Callback<List<HiringData>> {
            override fun onResponse(
                call: Call<List<HiringData>>,
                response: Response<List<HiringData>>
            ) {
                if (response.isSuccessful) {
                    if (response.body() != null) {
                        val hiringDataList = response.body() as List<HiringData>
                        setData(hiringDataList)
                    }
                }
            }

            override fun onFailure(call: Call<List<HiringData>>, t: Throwable) {
                Toast.makeText(this@MainActivity, "${t.message}", Toast.LENGTH_LONG).show()
                Log.d("Failure", "onFailure: ${t.message}")
            }

        })
    }

    private fun setData(hiringDataList: List<HiringData>) {
        val filteredAndSortedData = HiringDataUtils.filterAndSortData(hiringDataList)
        recyclerView?.apply {
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = HiringDataAdapter(filteredAndSortedData)
        }
    }
}
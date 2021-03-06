package com.example.fetchrewardscodingexcercise.utils

import android.util.Log
import com.example.fetchrewardscodingexcercise.model.HiringData

object HiringDataUtils {
    private const val TAG = "HiringDataUtils"

    @JvmStatic
    fun filterAndSortData(hiringDataList: List<HiringData>): List<HiringData> {
        val filteredData: List<HiringData> = hiringDataList.filter { it.name !in listOf("", null) }
        val sortedData: List<HiringData> =
            filteredData.sortedWith(compareBy<HiringData> { it.listId }
                .thenBy { it.name })
        sortedData.forEach {
            Log.d(TAG, "filterAndSortData: $it")
        }
        return filteredData
    }
}
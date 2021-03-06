package com.example.fetchrewardscodingexcercise.utils

import com.example.fetchrewardscodingexcercise.model.HiringData

/**
 * Utils class that interacts with the list of HiringData objects.
 */

object HiringDataUtils {
    private const val TAG = "HiringDataUtils"

    /**
     * function that filters out the blank and null values and sorts the data by listId and Name.
     * @param hiringDataList Data fetched from the API
     * @return Filtered and sorted list of hiring data.
     */
    @JvmStatic
    fun filterAndSortData(hiringDataList: List<HiringData>): List<HiringData> {
        val filteredData: List<HiringData> = hiringDataList.filter { it.name !in listOf("", null) }
        return filteredData.sortedWith(compareBy<HiringData> { it.listId }
            .thenBy { it.name })
    }
}
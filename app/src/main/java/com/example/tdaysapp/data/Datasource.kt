package com.example.tdaysapp.data

import com.example.tdaysapp.R
import com.example.tdaysapp.model.TDays

class Datasource() {
    fun loadTDays(): List<TDays> {
        return listOf<TDays>(
            TDays(R.string.tc_1,R.string.tq_1,R.string.tdays1, R.drawable.photo_1),
            TDays(R.string.tc_1,R.string.tq_1,R.string.tdays1, R.drawable.photo_1),
            TDays(R.string.tc_1,R.string.tq_1,R.string.tdays1, R.drawable.photo_1),
            TDays(R.string.tc_1,R.string.tq_1,R.string.tdays1, R.drawable.photo_1),
            TDays(R.string.tc_1,R.string.tq_1,R.string.tdays1, R.drawable.photo_1))
    }
}
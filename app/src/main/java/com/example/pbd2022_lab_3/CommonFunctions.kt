package com.example.pbd2022_lab_3

import android.icu.util.Calendar

fun setDay(day:Int) : String {
    var daytext = "" + day + "."
    return daytext
}

// write months with their full name
fun setMonth(month: Int) : String {
    var monthText:String = ""
    when(month) {
        0 -> monthText = "Januar"
        1 -> monthText = "Februar"
        2 -> monthText = "Marec"
        3 -> monthText = "April"
        4 -> monthText = "May"
        5 -> monthText = "Junij"
        6 -> monthText = "Julij"
        7 -> monthText = "Avgust"
        8 -> monthText = "September"
        9 -> monthText = "Oktober"
        10 -> monthText = "November"
        11 -> monthText = "December"
    }
    return monthText
}

fun setLabel(calendar: Calendar):String {
    var format:String = ""
    val month = setMonth(calendar.get(Calendar.MONTH))
    val day = setDay(calendar.get(Calendar.DAY_OF_MONTH))
    format = day + " " + month + " " + calendar.get(Calendar.YEAR)
    return format
}

// return string of current date
fun getTodaysDate():String {
    val calendar = Calendar.getInstance()
    val year = calendar.get(java.util.Calendar.YEAR)
    val month = calendar.get(java.util.Calendar.MONTH)
    val day = calendar.get(java.util.Calendar.DAY_OF_MONTH)
    calendar.set(year, month, day)
    return setLabel(calendar)
}

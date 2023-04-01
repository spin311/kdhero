package com.example.pbd2022_lab_3

class Person (
    val username: String,
    val password: String,
    val age: Int,
    val email: String,
    val sex: String,
    val noOfCoins: Int,
    val bloodDon: Array<Activity>,
    val dentist: Array<Activity>,
    val svit: Array<Activity>,
    var achievements: Array<Int> // ids of achievements that the person has achieved
)  {
}
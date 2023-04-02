package com.example.pbd2022_lab_3

class Person(
    val username: String,
    val password: String,
    val age: Int,
    val email: String,
    val sex: String,
    val noOfCoins: Int,
    val bloodDon: ArrayList<Activity>,
    val dentist: ArrayList<Activity>,
    val svit: ArrayList<Activity>,
    val achievements: ArrayList<Int> // ids of achievements that the person has achieved
)  {
}
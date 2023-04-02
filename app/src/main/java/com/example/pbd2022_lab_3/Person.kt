package com.example.pbd2022_lab_3

class Person(
    val username: String? = null,
    val password: String? = null,
    val age: Int? = null,
    val email: String? = null,
    val sex: String? = null,
    val noOfCoins: Int? = null,
    val bloodDon: ArrayList<Activity>? = null,
    val dentist: ArrayList<Activity>? = null,
    val svit: ArrayList<Activity>? = null,
    val achievements: ArrayList<Int>? = null // ids of achievements that the person has achieved
)  {

}
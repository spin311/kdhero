package com.example.pbd2022_lab_3

object DataFile {
    val achievements = arrayListOf(Achievement("Zdravi Influencer", "Delil svoj prvi dogodek z ostalimi.", "", 1),
        Achievement("Raziskovalec", "Obiskal vse tri možne aktivnosti.","", 1),
        Achievement("Dokumentacija je pomembna", "Naredil sliko ob dogodku.", "", 2),
        Achievement("Determninacija", "Večkrat obiskal isti dogodek.", "", 1),
        Achievement("Krvni heroj", "V enem letu večkrat doniral kri.", "", 0),
        Achievement("Zlati donator", "Doniral kri petkrat.", "", 0),
        Achievement("Miljarder zdravja", "V top 10% donatorjev.", "", 1),
        Achievement("zobna miška", "Bil na rednem zobozdravniškem pregledu.", "", 2))
    val don1 = arrayListOf(Activity("2021-03-01", ""), Activity("2021-08-02", ""))
    val dent1 = arrayListOf(Activity("2022-09-01", ""), Activity("2021-09-02", ""))
    val svit1 = arrayListOf(Activity("2021-03-01", ""), Activity("2021-07-15", ""), Activity("2020-10-12", ""))
    val user1 = Person("jan33", "secret", 16, "jannovak@gmail.com",
    "m", 180, don1, dent1, svit1, arrayListOf(1,2,3,4,7,8))
    val don2 = arrayListOf(Activity("2022-12-02", ""), Activity("2021-09-02", ""))
    val dent2 = arrayListOf(Activity("2017-09-01", ""))
    val svit2 = arrayListOf(Activity("2018-03-01", ""), Activity("2021-07-15", ""), Activity("2020-10-12", ""))
    val user2 = Person("healthyMaja", "secret", 35, "majapajek@yahoo.com",
        "f", 180, don2, dent2, svit2, arrayListOf(4,5,8))
    val don3 = arrayListOf(Activity("2021-03-01", ""))
    val dent3 = arrayListOf(Activity("2021-09-01", ""), Activity("2022-09-02", ""), Activity("2020-09-02", ""))
    val svit3 = arrayListOf(Activity("2020-03-01", ""), Activity("2021-07-15", ""), Activity("2022-10-12", ""))
    val user3 = Person("mihaKing", "secret", 55, "mihakovac@gmail.com", "m", 180, don3, dent3, svit3, arrayListOf(8))
    val data = arrayOf(user1, user2, user3)
}

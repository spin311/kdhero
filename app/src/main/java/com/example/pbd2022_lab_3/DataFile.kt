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
    val don1 = arrayListOf(Activity("1. Marec 2021", ""), Activity("2. Avgust 2021", ""))
    val dent1 = arrayListOf(Activity("1. September 2020", ""), Activity("2. Julij 2022",""))
    val svit1 = arrayListOf(Activity("1. Marec 2020", ""), Activity("15. Junij 2022", ""), Activity("12. Oktober 2022", ""))
    val user1 = Person("jan33", "secret", 16, "jannovak@gmail.com",
    "m", 180, don1, dent1, svit1, arrayListOf(Activity("key", "1")))
    val don2 = arrayListOf(Activity("1. September 2020", ""), Activity("2. September 2021", ""))
    val dent2 = arrayListOf(Activity("15. Junij 2022", ""))
    val svit2 = arrayListOf(Activity("1. Marec 2018", ""), Activity("15. December 2020", ""), Activity("1. Marec 2021", ""))
    val user2 = Person("healthyMaja", "secret", 35, "majapajek@yahoo.com",
        "f", 180, don2, dent2, svit2, arrayListOf(Activity("key", "1")))
    val don3 = arrayListOf(Activity("1. Marec 2020", ""))
    val dent3 = arrayListOf(Activity("13. Februar 2019", ""), Activity("1. September 2020", ""), Activity("5. Oktober 2021", ""))
    val svit3 = arrayListOf(Activity("15. Junij 2022", ""), Activity("15. November 2022", ""), Activity("12. Januar 2023", ""))
    val user3 = Person("mihaKing", "secret", 55, "mihakovac@gmail.com", "m", 180, don3, dent3, svit3, arrayListOf(Activity("key", "1")))
    val data = arrayOf(user1, user2, user3)
}

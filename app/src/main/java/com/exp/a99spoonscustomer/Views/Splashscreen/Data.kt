package com.exp.a99spoonscustomer.Views.Splashscreen

import com.exp.a99spoonscustomer.R


data class screenData(var index: Int, var drawableImage: Int, var description: String)

val listOfPages: List<screenData> = listOf(
    screenData(
        0,
        R.drawable.ic_kosher_certified,
        "Produced in accordance with strict kosher dietary laws and standards."
    ),
    screenData(
        1,
        R.drawable.ic_non_gmo_logo,
        "Made with ingredients free from genetically modified organisms."
    ),
    screenData(
        2,
        R.drawable.ic_gluten_free,
        "Enjoy our products without worry for those with gluten sensitivities."
    ),
)

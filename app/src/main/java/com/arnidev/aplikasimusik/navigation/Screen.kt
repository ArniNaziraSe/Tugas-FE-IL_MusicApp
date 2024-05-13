package com.arnidev.aplikasimusik.navigation

sealed class Screen (val route: String, val title: String){
    object Home : Screen("home", "Music App")
    object Genre : Screen("genre", "Genre")
    object About : Screen("about", "About Me")
    object Detail1 : Screen("detail1", "Detail Kpop Song")
    object Detail2 : Screen("detail2", "Detail Indo Song")

    companion object {
        fun fromRoute(route: String?): Screen {
            return when (route) {
                Home.route -> Home
                Genre.route -> Genre
                About.route -> About
                Detail1.route -> Detail1
                Detail2.route -> Detail2
                else -> {
                    Detail1
                    Detail2
                }
            }
        }
    }
}
package fr.les_mega_bg.tp5

import retrofit2.Call
import retrofit2.http.Path
import retrofit2.http.Query
import retrofit2.http.GET

interface DriverService {

    companion object{
        val ENDPOINT : String= "https://busin.fr"
    }

    @GET("/drivers.json")
    fun listDrivers(): Call<List<ObjetDriver>>


}
package fr.les_mega_bg.tp5

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import retrofit2.*
import retrofit2.converter.gson.GsonConverterFactory
import android.widget.Toast

class MainActivity : AppCompatActivity() {//contact activity

    override fun onCreate(savedInstanceState: Bundle?) {
        // Code de base
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Instanciation du service Driver pour récupération des bonhommes
        val driverService = Retrofit.Builder()
            .baseUrl(DriverService.ENDPOINT)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create<DriverService>(
                DriverService::class.java
            )

        // Appel réseau
        driverService.listDrivers().enqueue(object : Callback<List<ObjetDriver>> {
            override fun onResponse(
                call: Call<List<ObjetDriver>>,
                response: Response<List<ObjetDriver>>
            ) {
                afficherDrivers(response.body()); //affichage grâce au recycler view
            }

            override fun onFailure(call: Call<List<ObjetDriver>>, t: Throwable) {
                System.out.println("ALED")
            }

        })

    } // end of on create

    // Fonction qui affiche les repos avec un recyclerview
    fun afficherDrivers(drivers: List<ObjetDriver>?) {
        if (drivers != null) {
            Toast.makeText(this, "Nombre de drivers : " + drivers.size, Toast.LENGTH_SHORT).show()
            var driverListe  :MutableList<ObjetDriver> = ArrayList<ObjetDriver>()
            val rvDriver : RecyclerView = findViewById(R.id.rvDrivers)
            for (driver in drivers){driverListe.add(driver)}

            //Création d'un adapter avec initialisation du constructeur avec notre liste de contacts
            val adapter :DriversAdapter= DriversAdapter(drivers)
            //On notifie au recyclerView notre adapter
            rvDriver.setAdapter(adapter)
            //On déclare quel type de LayoutMangare on désire
            rvDriver.setLayoutManager(LinearLayoutManager(this))


        }
    }
}
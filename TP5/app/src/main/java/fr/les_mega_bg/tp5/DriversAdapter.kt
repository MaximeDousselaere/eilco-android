package fr.les_mega_bg.tp5

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class DriversAdapter(drivers : List<ObjetDriver>): RecyclerView.Adapter<DriversAdapter.ViewHolder>() {

    val mDrivers: List<ObjetDriver> = drivers

    class ViewHolder(view :View) : RecyclerView.ViewHolder(view){
        val nomTextView: TextView=view.findViewById(R.id.nom)
        val equipeTextView : TextView=view.findViewById(R.id.equipe)
        val pointsImageView : TextView= view.findViewById(R.id.points)
    }

    // Déclaration de la vue d'un item pour le xml
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val context = parent.context
        val inflater = LayoutInflater.from(context)

        val driverView =inflater.inflate(R.layout.item_driver,parent,false)
        return ViewHolder(driverView)

    }

    // Utilisé pour afficher les données passées en paramètres de l'adapter
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val driver : ObjetDriver=mDrivers.get(position)
        var nomTextViewDriver= holder.nomTextView
        nomTextViewDriver.setText(driver.driver.name)

        var equipeTextViewDriver = holder.equipeTextView
        equipeTextViewDriver.setText(driver.team.name)

        var pointsTextViewDriver = holder.pointsImageView
        pointsTextViewDriver.setText(driver.points+" pts")

    }

    // Retourne le nombre d'éléments de la liste
    override fun getItemCount(): Int {
        return mDrivers.size
    }



}
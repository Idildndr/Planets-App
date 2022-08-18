package android.example.planetss
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView

class RecyclerAdapter: RecyclerView.Adapter<RecyclerAdapter.ViewHolder>(){



    private var names = arrayOf("Earth", "Jupiter" ,"Mars", "Saturn","Neptune","Mercury"
    )
    private var distances = arrayOf("150 Million KM", "778 Million KM","228 Million KM","5900 Million KM","32480 Million KM","3468 Million KM")
    private var surfaces = arrayOf("10 N/kg","26 N/kg","4 N/kg","1 N/kg","3 N/kg", "4 N/kg")
    private  var diameters = arrayOf("12750 KM","143000 KM", "6800 KM", "2320 KM", "4535 KM", "7450 KM")
    private var images = arrayOf(R.drawable.earth, R.drawable.jupiter, R.drawable.mars,R.drawable.saturn,R.drawable.neptune, R.drawable.mercury)


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerAdapter.ViewHolder {

        //to inflate our cardView to pass to view object to this constructor
        val v = LayoutInflater.from(parent.context).inflate(R.layout.card_layout,parent,false)
        return ViewHolder(v)




    }

    override fun onBindViewHolder(holder: RecyclerAdapter.ViewHolder, position: Int) {

        // our recyler adapter object : holder
        holder.PlanetName.text = names[position]
        holder.Distance.text = distances[position]
        holder.Diamater.text = diameters[position]
        holder.Surface.text = surfaces[position]
        holder.itemImage.setImageResource(images[position])

        holder.itemView.setOnClickListener {
            if (position == 1){
                val action = MainActivityDirections.actionMainActivity2ToEarthFragment()

            }
        }


    }

    override fun getItemCount(): Int {
        //we need to identify how many items we are passing to our view holder

        return names.size
    }





    inner class ViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){
        //handles the detail we passed to the card view

        var itemImage: ImageView
        var PlanetName: TextView
        var Surface: TextView
        var Diamater: TextView
        var Distance: TextView

        init {
            itemImage = itemView.findViewById(R.id.image)
            PlanetName = itemView.findViewById(R.id.planet_name)
            Surface = itemView.findViewById(R.id.surface)
            Diamater = itemView.findViewById(R.id.diameter)
            Distance = itemView.findViewById(R.id.distance)
        }



    }
}
package edu.ni.abra.util

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.NetworkPolicy
import com.squareup.picasso.Picasso
import edu.ni.abra.R
import edu.ni.abra.model.Cat
import kotlinx.android.synthetic.main.item_cat.view.*

class AdapterCats: RecyclerView.Adapter<AdapterCats.ViewHolder>() {

    lateinit var items:ArrayList<Cat>

    fun setCats(items:List<Cat>) {
        this.items = items as ArrayList<Cat>
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_cat, parent,false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val model = items[position]
        holder.catName.text = model.name
        holder.catTemperament.text = model.temperament
        holder.catOrigin.text = model.origin
        Picasso.get()
            .load(model.image?.url)
            //.networkPolicy(NetworkPolicy.OFFLINE)
            .resize(300,300)
            .into(holder.catImage)
    }

    override fun getItemCount(): Int {
        return if(::items.isInitialized) {
            items.size
        } else {
            0
        }
    }

    class ViewHolder(view: View):RecyclerView.ViewHolder(view) {
        val catName: TextView = view.tv_name
        val catTemperament: TextView = view.tv_temperament
        val catOrigin: TextView = view.tv_origin
        val catImage: ImageView = view.img_cat
    }
}
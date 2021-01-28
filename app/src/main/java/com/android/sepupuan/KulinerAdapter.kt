package com.android.sepupuan

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class KulinerAdapter(
    private val context: Context,
    private val images: List<Kuliner>,
    val listener: (Kuliner) -> Unit
) : RecyclerView.Adapter<KulinerAdapter.ImageViewHolder>() {
    class ImageViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val gambarSrc = view.findViewById<ImageView>(R.id._image)
        val gambarNama = view.findViewById<TextView>(R.id._title)
        fun bindView(image: Kuliner, listener: (Kuliner) -> Unit) {
            gambarSrc.setImageResource(image.gambarSrc)
            gambarNama.text = image.gambarNama
            itemView.setOnClickListener { listener(image) }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImageViewHolder =
        ImageViewHolder(LayoutInflater.from(context).inflate(R.layout.item_list, parent, false))

    override fun getItemCount(): Int = images.size

    override fun onBindViewHolder(holder: ImageViewHolder, position: Int) {
        holder.bindView(images[position], listener)
    }
}

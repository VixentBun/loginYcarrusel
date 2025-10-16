package com.example.login1

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView

class ImageCarouselAdapter(private val images: List<Int>) : RecyclerView.Adapter<ImageCarouselAdapter.ImageViewHolder>() {

    // This class holds the view for each item in the carousel
    class ImageViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imageView: ImageView = itemView.findViewById(R.id.carouselImageView)
    }

    // This creates a new view holder when the RecyclerView needs one
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImageViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.carousel_item, parent, false)
        return ImageViewHolder(view)
    }

    // This returns the total number of items in the list
    override fun getItemCount(): Int {
        return images.size
    }

    // This binds the data (the image) to the view holder at a specific position
    override fun onBindViewHolder(holder: ImageViewHolder, position: Int) {
        holder.imageView.setImageResource(images[position])
    }
}

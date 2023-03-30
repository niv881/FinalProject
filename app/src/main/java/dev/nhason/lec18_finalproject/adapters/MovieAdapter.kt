package dev.nhason.lec18_finalproject.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.squareup.picasso.Picasso
import dev.nhason.lec18_finalproject.data.models.Movie
import dev.nhason.lec18_finalproject.databinding.MovieItemBinding

class MovieAdapter(private val movies: List<Movie>) : Adapter<MovieAdapter.VH>(){

    class VH(val binding: MovieItemBinding) :ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH {
        val inflater = LayoutInflater.from(parent.context)
        val binding = MovieItemBinding.inflate(inflater,parent,false)
        return VH(binding)
    }

    override fun getItemCount(): Int {
        return movies.size
    }

    override fun onBindViewHolder(holder: VH, position: Int) {
        val movie = movies[position]

    with(holder.binding) {
            titleMovie.text = movie.title
            Picasso.get()
                .load(movie.backDropUrl)
                .into(imageView2)
        }
    }

}
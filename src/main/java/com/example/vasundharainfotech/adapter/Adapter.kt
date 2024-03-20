package com.example.vasundharainfotech.adapter


import android.content.Context
import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.RatingBar
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.vasundharainfotech.R
import com.example.vasundharainfotech.model.GetDataDetails
import com.example.vasundharainfotech.model.SubCategoryModel


class Adapter(
    private val context: Context,
    var arrayList: List<GetDataDetails.Data>,
    var arraySubCategoryModel: ArrayList<SubCategoryModel>,
)   :

    RecyclerView.Adapter<Adapter.ViewHolder>() {



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Adapter.ViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.item_list, parent, false)
        return ViewHolder(view)
    }


    override fun onBindViewHolder(holder: Adapter.ViewHolder, position: Int) {
        holder.tvName.text=arraySubCategoryModel.get(position).name
        holder.ratingBar.rating=arraySubCategoryModel.get(position).star.toFloat()
        holder.tvRange.text=arraySubCategoryModel.get(position).installed_range

        Glide
            .with(context)
            .load(arraySubCategoryModel.get(position).icon)
            .centerCrop()
            .placeholder(R.drawable.ic_launcher_background)
            .into(holder.image);

         holder.btnDownload.setOnClickListener {
             val appPackageName =arraySubCategoryModel.get(position).app_link // Replace this with your app's package name
             try {
                 context.startActivity(Intent(Intent.ACTION_VIEW, Uri.parse("market://details?id=$appPackageName")))
             } catch (e: android.content.ActivityNotFoundException) {
                 context.startActivity(Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/apps/details?id=$appPackageName")))
             }
         }
    }

    override fun getItemCount(): Int {
        return arraySubCategoryModel.size
    }


     class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val image: ImageView
         val tvName: TextView
         val ratingBar: RatingBar
         val tvRange: TextView
         val btnDownload: Button
      //  private val courseRatingTV: TextView

        init {
            image = itemView.findViewById<ImageView>(R.id.image)
            tvName = itemView.findViewById<TextView>(R.id.tvName)
            ratingBar = itemView.findViewById<RatingBar>(R.id.ratingBar)
            tvRange = itemView.findViewById<TextView>(R.id.tvAmount)
            btnDownload = itemView.findViewById<Button>(R.id.btnDownload)

        }
    }
}
package com.example.retrofitrestapi

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class myAdapter( val userlist:List<dataItem>) : RecyclerView.Adapter<myAdapter.ViewHolder>()
{

    class ViewHolder(itemView:View): RecyclerView.ViewHolder(itemView) {
        fun bind(list : dataItem)
        {
               val userID=itemView.findViewById<TextView>(R.id.userID)
               val  title=itemView.findViewById<TextView>(R.id.title)
               val img=itemView.findViewById<ImageView>(R.id.image)
            userID.text=list.id.toString()
            val imageload:String= list.thumbnailUrl
            val imageload1:String= imageload+ ".jpg"
            title.text=list.title
            Glide.with(itemView.context).load(imageload1).centerCrop().into(img)
        }
    }

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): ViewHolder {
        var view = LayoutInflater.from(p0.context).inflate(R.layout.rowdata_item,p0,false)
        return ViewHolder(view)

    }

    override fun onBindViewHolder(p0: ViewHolder, p1: Int) {
        p0.bind(userlist[p1])

    }
    override fun getItemCount(): Int {
      return   userlist.size
    }
}
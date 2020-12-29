package com.example.android4a.presentation.main

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.annotation.NonNull
import androidx.recyclerview.widget.RecyclerView
import com.example.android4a.R
import com.example.android4a.domain.entity.NierCharacter
import com.example.android4a.presentation.main.ListAdapter.ViewHolder
import com.squareup.picasso.Picasso

class ListAdapter(
    myDataset: List<NierCharacter>
) : RecyclerView.Adapter<ViewHolder>(){
    private val values = myDataset

    class ViewHolder(
        layout: View
    ): RecyclerView.ViewHolder(layout) {
        var txtHeader: TextView = layout.findViewById<View>(R.id.firstLine) as TextView
        var txtFooter: TextView = layout.findViewById<View>(R.id.secondLine) as TextView
        var imgChara = itemView.findViewById(R.id.icon) as ImageView

    }
    @NonNull
    @Override
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val v: View = inflater.inflate(R.layout.row_layout, parent, false)
        return ViewHolder(v)
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val currentCharacter: NierCharacter = values?.get(position)
        if (currentCharacter != null){
            holder.txtHeader.text = currentCharacter.name
            holder.txtFooter.text = "Faction" + currentCharacter.faction
            Picasso.get().load(currentCharacter.imgUrl).resize(175, 215).into(holder.imgChara)
        }
    }

    override fun getItemCount(): Int {
        return values.size
    }
}
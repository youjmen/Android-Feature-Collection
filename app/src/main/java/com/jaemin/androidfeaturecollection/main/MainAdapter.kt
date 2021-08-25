package com.jaemin.androidfeaturecollection.main

import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.jaemin.androidfeaturecollection.databinding.ItemMainBinding

class MainAdapter(private val featureList : MutableList<Pair<String, Class<*>>> = mutableListOf()) : RecyclerView.Adapter<MainViewHolder>(){
    override fun onAttachedToRecyclerView(recyclerView: RecyclerView) {
        super.onAttachedToRecyclerView(recyclerView)
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {
        val binding = ItemMainBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        Log.d("twonCreateViewHolder", "gg")

        return MainViewHolder(binding)

    }

    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
        holder.bind(featureList[position])
        Log.d("twonBindViewHolder", holder.toString())


    }

    override fun onViewAttachedToWindow(holder: MainViewHolder) {
        super.onViewAttachedToWindow(holder)
        Log.d("twonviewAttachedToWi", holder.adapterPosition.toString())

    }

    override fun onViewDetachedFromWindow(holder: MainViewHolder) {
        super.onViewDetachedFromWindow(holder)
        Log.d("twonViewDetachedFromWi", holder.hashCode().toString())

    }

    override fun onViewRecycled(holder: MainViewHolder) {
        super.onViewRecycled(holder)
        Log.d("twonViewRecycled", holder.hashCode().toString())

    }

    fun addItem(data : Pair<String, Class<*>>){
        featureList.add(data)
//        notifyDataSetChanged()
        notifyItemChanged(featureList.size)
    }
    fun addItems(data : List<Pair<String, Class<*>>>){
        val previousSize = featureList.size
        featureList.addAll(data)
        notifyItemRangeChanged(previousSize,featureList.size)
    }


    override fun getItemCount(): Int = featureList.size


}

class MainViewHolder(private val binding : ItemMainBinding) : RecyclerView.ViewHolder(binding.root){

    fun bind(data : Pair<String, Class<*>>){
        binding.tvContent.text = data.first
        binding.root.setOnClickListener {
            binding.root.context.startActivity(Intent(binding.root.context, data.second))
        }

    }

}
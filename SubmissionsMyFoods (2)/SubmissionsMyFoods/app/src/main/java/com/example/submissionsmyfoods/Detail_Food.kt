package com.example.submissionsmyfoods

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil.setContentView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.example.submissionsmyfoods.databinding.ActivityDetailItemBinding

class Detail_Food: AppCompatActivity(){
    private lateinit var binding: ActivityDetailItemBinding

    companion object {
        const val SET = "SET"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailItemBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val tujuan = intent.getParcelableExtra<Food>(SET)

        if (tujuan != null) {
            Log.i("TES", tujuan.toString())
            binding.tvName.text = tujuan.name
            binding.tvContext.text = tujuan.context
            binding.tvRecipe.text = tujuan.recipe
            Glide.with(this)
                .load(tujuan.photo)
                .transition(DrawableTransitionOptions.withCrossFade())
                .into(binding.imgPhoto)
        }
    }
}
package com.example.democleanmvvm

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.viewModels
import com.example.democleanmvvm.presentation.spacecraftlist.SpaceCraftListViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private val mSpaceCraftListViewModel by viewModels<SpaceCraftListViewModel>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val res = mSpaceCraftListViewModel.list.value
        if (res.isLoading){
            Toast.makeText(this, "isLoading", Toast.LENGTH_SHORT).show()
        }

        if(res.error.isNotBlank()){
            Toast.makeText(this, "iserror", Toast.LENGTH_SHORT).show()
        }

        res.data?.let {
            Toast.makeText(this, "hello", Toast.LENGTH_SHORT).show()
        }

    }
}
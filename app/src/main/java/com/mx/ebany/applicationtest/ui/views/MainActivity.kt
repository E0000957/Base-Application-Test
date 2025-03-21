package com.mx.ebany.applicationtest.ui.views

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.mx.ebany.applicationtest.data.local.entities.UsersEntity
import com.mx.ebany.applicationtest.databinding.ActivityMainBinding
import com.mx.ebany.applicationtest.ui.viewmodels.MainViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setInitialValues()
        setObservers()
    }

    private fun setInitialValues() {
        viewModel.loadUsers()
        viewModel.saveUser(
            UsersEntity(
                name = "John Doe",
            )
        )
    }

    private fun setObservers() {
        viewModel.userData.observe(this) { user ->
            Log.d("MainActivity", "User: $user")
        }
    }




}
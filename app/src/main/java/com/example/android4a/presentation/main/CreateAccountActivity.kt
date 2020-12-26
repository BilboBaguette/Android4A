package com.example.android4a.presentation.main

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.example.android4a.R
import com.example.android4a.presentation.status.*
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import kotlinx.android.synthetic.main.activity_create_account.*
import org.koin.android.ext.android.inject

class CreateAccountActivity : AppCompatActivity() {

    private val createAccountViewModel: CreateAccountViewModel by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_account)

        createAccountViewModel.createLiveData.observe(this, Observer {
            when(it){
                is CreateSuccess -> {
                    Toast.makeText(this, "Account Created", Toast.LENGTH_SHORT).show()
                    startLoginActivity()
                }
                NoEmail -> {
                    MaterialAlertDialogBuilder(this)
                        .setTitle("Email Error")
                        .setMessage("Please enter an email address")
                        .setPositiveButton("OK") { dialog, which ->
                            dialog.dismiss()
                        }
                        .show()
                }
                InvalidEmail -> {
                    MaterialAlertDialogBuilder(this)
                        .setTitle("Email Error")
                        .setMessage("email is invalid.\nPlease enter a valid email address")
                        .setPositiveButton("OK") { dialog, which ->
                            dialog.dismiss()
                        }
                        .show()
                }
                NoPassword -> {
                    MaterialAlertDialogBuilder(this)
                        .setTitle("Password Error")
                        .setMessage("Please enter a password")
                        .setPositiveButton("OK") { dialog, which ->
                            dialog.dismiss()
                        }
                        .show()
                }
                DifferentPasswords -> {
                    MaterialAlertDialogBuilder(this)
                        .setTitle("Password Error")
                        .setMessage("Passwords do not match")
                        .setPositiveButton("OK") { dialog, which ->
                            dialog.dismiss()
                        }
                        .show()
                }
                UnkownError -> {
                    MaterialAlertDialogBuilder(this)
                        .setTitle("Unknown Error")
                        .setMessage("Unknown Error occured.\n Please verify email and password and try again")
                        .setPositiveButton("OK") { dialog, which ->
                            dialog.dismiss()
                        }
                        .show()
                }
            }
        })
        create_account_button.setOnClickListener{
            createAccountViewModel.onClickedCreate(
                login_edit.text.toString().trim(),
                password_edit1.text.toString(),
                password_edit2.text.toString()
            )
        }
    }
    private fun startLoginActivity() {
        val intent = Intent(this, MainActivity::class.java)
        this.startActivity(intent)
    }
}
package com.example.tictactoeapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }


    /**
     * This is an Button event that is called when the single player button is pressed.
     *  This will change the activity into the TicTacToeBoard activity in the single player format.
     */
    fun singleBtnEvent(view: View) {
        var i = Intent(this, TicTacToeBoard::class.java)
        startActivity(i)
    }
}
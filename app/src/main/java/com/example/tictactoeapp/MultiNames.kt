package com.example.tictactoeapp

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

/**
 * Activity aims to take the name of each player to send to the next Activity.
 *
 */
class MultiNames : AppCompatActivity() {
    private lateinit var p1EditTxt: EditText
    private lateinit var p2EditText: EditText
    private lateinit var playBtn: Button
    private lateinit var homeBtn: Button
    private lateinit var errorTxt: TextView

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mulit_names)

        p1EditTxt = findViewById(R.id.name_player1EditTxt)
        p2EditText = findViewById(R.id.name_player2EditTxt)
        playBtn = findViewById(R.id.name_playBtn)
        homeBtn = findViewById(R.id.name_homeBtn)
        errorTxt = findViewById(R.id.error_txtv)
    }

    /**
     * On CLick event that sends users to the TicTacToe board
     */
    fun namePlayBtnEvent(view: View) {
        // if statement handles empty fields.
        if (p1EditTxt.text.toString().isEmpty() || p2EditText.text.toString().isEmpty()) {
            errorTxt.text = "Please ensure you inputted a name in both fields!!"
        } else{

            val i = Intent(this, MultiTicTacToeBoard::class.java)
            startActivity(i)
        }
    }

    /**
     * On click event that sends user to home screen
     */
    fun nameHomeBtnEvent (view: View) {
        val i = Intent(this, MultiTicTacToeBoard::class.java)
        startActivity(i)
    }
}
package com.example.tictactoeapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText

class MultiNames : AppCompatActivity() {
    private lateinit var p1EditTxt: EditText
    private lateinit var p2EditText: EditText
    private lateinit var playBtn: Button
    private lateinit var homeBtn: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mulit_names)

        p1EditTxt = findViewById(R.id.name_player1EditTxt)
        p2EditText = findViewById(R.id.name_player2EditTxt)
        playBtn = findViewById(R.id.name_playBtn)
        homeBtn = findViewById(R.id.name_homeBtn)
    }
    fun namePlayBtnEvent(view: View) {

    }
}
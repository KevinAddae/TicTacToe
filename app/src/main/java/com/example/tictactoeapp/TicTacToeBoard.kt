package com.example.tictactoeapp

import android.annotation.SuppressLint
import android.content.Intent
import android.media.Image
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView

lateinit var topL: ImageView
lateinit var topM: ImageView
lateinit var topR: ImageView
lateinit var midL: ImageView
lateinit var mid: ImageView
lateinit var midR: ImageView
lateinit var botL: ImageView
lateinit var botM: ImageView
lateinit var botR: ImageView

class TicTacToeBoard : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tic_tac_toe_board)
        topL = findViewById(R.id.board_topLeft)
        topM = findViewById(R.id.board_topMiddle)
        topR = findViewById(R.id.board_topRight)
        midL = findViewById(R.id.board_midLeft)
        mid = findViewById(R.id.board_mid)
        midR = findViewById(R.id.board_midRight)
        botL = findViewById(R.id.board_botLeft)
        botM = findViewById(R.id.board_botMid)
        botR = findViewById(R.id.board_botRight)

    }

    fun homeBtnEvent (view:View) {
        var i = Intent(this,MainActivity::class.java)
        startActivity(i)
    }

    fun placePosEvent(view:View) {

        var rand = (0..8).random()

        when (view.id) {
            R.id.board_topLeft -> topL.setImageResource(R.drawable.circle_player)
            R.id.board_topMiddle -> topM.setImageResource(R.drawable.circle_player)
            R.id.board_topRight -> topR.setImageResource(R.drawable.circle_player)
            R.id.board_midLeft -> midL.setImageResource(R.drawable.circle_player)
            R.id.board_mid -> mid.setImageResource(R.drawable.circle_player)
            R.id.board_midRight -> midR.setImageResource(R.drawable.circle_player)
            R.id.board_botLeft -> botL.setImageResource(R.drawable.circle_player)
            R.id.board_botMid -> botM.setImageResource(R.drawable.circle_player)
            R.id.board_botRight -> botR.setImageResource(R.drawable.circle_player)
        }
        var topl = findViewById<ImageView>(R.id.board_topLeft)
        topl.setImageResource(R.drawable.circle_player)
    }
}
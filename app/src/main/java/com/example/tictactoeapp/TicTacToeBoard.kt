package com.example.tictactoeapp

import android.annotation.SuppressLint
import android.content.Intent
import android.graphics.drawable.Drawable
import android.media.Image
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast

lateinit var topL: ImageView
lateinit var topM: ImageView
lateinit var topR: ImageView
lateinit var midL: ImageView
lateinit var mid: ImageView
lateinit var midR: ImageView
lateinit var botL: ImageView
lateinit var botM: ImageView
lateinit var botR: ImageView
lateinit var winner: TextView
lateinit var bgTopL: LinearLayout
var pos: ArrayList<ImageView> = ArrayList()

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

        //Sets up the linear layout
        bgTopL = findViewById(R.id.bg_topL)

        winner = findViewById(R.id.board_resultMsg)

        pos.add(topL)
        pos.add(topM)
        pos.add(topR)
        pos.add(midL)
        pos.add(mid)
        pos.add(midR)
        pos.add(botL)
        pos.add(botM)
        pos.add(botR)
    }

    fun homeBtnEvent (view:View) {
        var i = Intent(this,MainActivity::class.java)
        startActivity(i)
    }

    fun playAgainEvent (view: View) {

    }

    fun placePosEvent(view:View) {
        when (view.id) {
            R.id.board_topLeft -> {
                topL.setImageResource(R.drawable.circle_player)
                topL.setOnClickListener(null)
                pos.remove(topL)
                topL.tag = "p1"


            }
            R.id.board_topMiddle -> {
                topM.setImageResource(R.drawable.circle_player)
                topM.setOnClickListener(null)
                pos.remove(topM)
                topM.tag = "p1"
            }
            R.id.board_topRight -> {
                topR.setImageResource(R.drawable.circle_player)
                topR.setOnClickListener(null)
                pos.remove(topR)
                topR.tag = "p1"
            }
            R.id.board_midLeft -> {
                midL.setImageResource(R.drawable.circle_player)
                midL.setOnClickListener(null)
                pos.remove(midL)
            }
            R.id.board_mid -> {
                mid.setImageResource(R.drawable.circle_player)
                mid.setOnClickListener(null)
                pos.remove(mid)
            }
            R.id.board_midRight -> {
                midR.setImageResource(R.drawable.circle_player)
                midR.setOnClickListener(null)
                pos.remove(midR)
            }
            R.id.board_botLeft -> {
                botL.setImageResource(R.drawable.circle_player)
                botL.setOnClickListener(null)
                pos.remove(botL)
            }
            R.id.board_botMid -> {
                botM.setImageResource(R.drawable.circle_player)
                botM.setOnClickListener(null)
                pos.remove(botM)
            }
            R.id.board_botRight -> {
                botR.setImageResource(R.drawable.circle_player)
                botR.setOnClickListener(null)
                pos.remove(botR)
            }
        }
        checkWinner()

        cpuAction()

    }

    private fun cpuAction() {
        pos.shuffle()
        pos[0].setImageResource(R.drawable.ic_baseline_close_24)
        pos[0].setOnClickListener(null)

        pos[0].tag = "cpu"
        pos.removeAt(0)

    }
    private fun checkWinner(){
        if(topL.tag == "p1" && topM.tag == "p1" && topR.tag == "p1"){
            winner.text= "The Winner is "
        }
        else if (topL.tag == "p1" && midL.tag == "p1" && botL.tag == "p1"){
            winner
        }

    }
}
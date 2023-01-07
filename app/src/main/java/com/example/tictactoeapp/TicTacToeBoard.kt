package com.example.tictactoeapp

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CpuUsageInfo
import android.view.View
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView



class TicTacToeBoard : AppCompatActivity() {

    private lateinit var topL: ImageView
    private lateinit var topM: ImageView
    private lateinit var topR: ImageView
    private lateinit var midL: ImageView
    private lateinit var mid: ImageView
    private lateinit var midR: ImageView
    lateinit var botL: ImageView
    lateinit var botM: ImageView
    lateinit var botR: ImageView

    lateinit var winner: TextView

    private lateinit var bgTopL: LinearLayout
    private lateinit var bgTopM: LinearLayout
    private lateinit var bgTopR: LinearLayout
    private lateinit var bgMidL: LinearLayout
    private lateinit var bgMid: LinearLayout
    private lateinit var bgMidR: LinearLayout
    private lateinit var bgBotL: LinearLayout
    private lateinit var bgBotMid: LinearLayout
    private lateinit var bgBotR: LinearLayout
    var pos: ArrayList<ImageView> = ArrayList()


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
        bgTopM = findViewById(R.id.bg_topM)
        bgTopR = findViewById(R.id.bg_topR)
        bgMidL = findViewById(R.id.bg_midL)
        bgMid = findViewById(R.id.bg_mid)
        bgMidR = findViewById(R.id.bg_midR)
        bgBotL = findViewById(R.id.bg_botL)
        bgBotMid = findViewById(R.id.bg_botM)
        bgBotR = findViewById(R.id.bg_botR
        )
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
        val i = Intent(this,MainActivity::class.java)
        startActivity(i)
    }

    fun playAgainEvent (view: View) {
        val i = Intent(this,TicTacToeBoard::class.java)
        startActivity(i)
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
        //checks winner after user's turn
        checkWinner()
        // allows the cpu to act
        cpuAction()
        //checks winner after cpu's turn
        checkWinner()

    }

    private fun cpuAction() {
        pos.shuffle()
        pos[0].setImageResource(R.drawable.ic_baseline_close_24)
        pos[0].setOnClickListener(null)

        pos[0].tag = "cpu"
        pos.removeAt(0)

    }
    private fun checkWinner(){
        if(topL.tag == topM.tag && topL.tag == topR.tag && topL.tag != null) {
            bgTopL.setBackgroundColor(Color.GREEN)
            bgTopM.setBackgroundColor(Color.GREEN)
            bgTopR.setBackgroundColor(Color.GREEN)
            if (topL.tag == "p1")
            winner.text= "Player Wins "
            else
                winner.text = "Cpu Wins"
        }
        else if (topL.tag == midL.tag  && botL.tag == topL.tag) {
            bgTopL.setBackgroundColor(Color.GREEN)
            bgMidL.setBackgroundColor(Color.GREEN)
            bgBotL.setBackgroundColor(Color.GREEN)
            if (topL.tag == "p1")
                winner.text= "Player Wins "
            else
                winner.text = "Cpu Wins"
        }
        else if (topL.tag == mid.tag && topL.tag == botR.tag){
            bgTopL.setBackgroundColor(Color.GREEN)
            bgMid.setBackgroundColor(Color.GREEN)
            bgBotR.setBackgroundColor(Color.GREEN)
            if (topL.tag == "p1")
                winner.text= "Player Wins "
            else
                winner.text = "Cpu Wins"
        }
        else if (midL.tag == mid.tag && midL.tag == midR.tag){
            bgMidL.setBackgroundColor(Color.GREEN)
            bgMid.setBackgroundColor(Color.GREEN)
            bgMidR.setBackgroundColor(Color.GREEN)
            if (topL.tag == "p1")
                winner.text= "Player Wins "
            else
                winner.text = "Cpu Wins"
        }
        else if (botL.tag == botM.tag && botR.tag == botM.tag){
            bgBotL.setBackgroundColor(Color.GREEN)
            bgBotMid.setBackgroundColor(Color.GREEN)
            bgBotR.setBackgroundColor(Color.GREEN)
            if (topL.tag == "p1")
                winner.text= "Player Wins "
            else
                winner.text = "Cpu Wins"

        }
        else if(topR.tag == mid.tag && botL.tag == mid.tag){
            bgTopR.setBackgroundColor(Color.GREEN)
            bgMid.setBackgroundColor(Color.GREEN)
            bgBotL.setBackgroundColor(Color.GREEN)
            if (topL.tag == "p1")
                winner.text= "Player Wins "
            else
                winner.text = "Cpu Wins"

        }
        else if (topR.tag == midR.tag && midR.tag == botR.tag){
            bgTopR.setBackgroundColor(Color.GREEN)
            bgMidR.setBackgroundColor(Color.GREEN)
            bgBotR.setBackgroundColor(Color.GREEN)
            if (topL.tag == "p1")
                winner.text= "Player Wins "
            else
                winner.text = "Cpu Wins"
        }

    }


}
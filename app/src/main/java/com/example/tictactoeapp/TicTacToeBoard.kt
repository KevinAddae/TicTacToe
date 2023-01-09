package com.example.tictactoeapp

import android.annotation.SuppressLint
import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CpuUsageInfo
import android.view.View
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView


/**
 * The Activity aims to allow for the user to interact with the board allowing
 * them to play the game.
 */
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
        //sets up all the ImageViews.
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
        //sets up the text view
        winner = findViewById(R.id.board_resultMsg)
        // adds all the ImageViews to an ArrayList
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

    /**
     * sends the user back to the home page
     */
    fun homeBtnEvent (view:View) {
        val i = Intent(this,MainActivity::class.java)
        startActivity(i)
    }

    /**
     * connects to the play again button, reloads the page to initial state.
     */
    fun playAgainEvent (view: View) {
        val i = Intent(this,TicTacToeBoard::class.java)
        startActivity(i)
    }

    /**
     * Allows for the user to interact with the board and removes the ability for the
     * user to interact with the selected position.
     */
    fun placePosEvent(view:View) {
        when (view.id) {
            R.id.board_topLeft -> {
                topL.setImageResource(R.drawable.ic_outline_circle_24)
                topL.setOnClickListener(null)
                pos.remove(topL)
                topL.tag = "p1"

            }
            R.id.board_topMiddle -> {
                topM.setImageResource(R.drawable.ic_outline_circle_24)
                topM.setOnClickListener(null)
                pos.remove(topM)
                topM.tag = "p1"
            }
            R.id.board_topRight -> {
                topR.setImageResource(R.drawable.ic_outline_circle_24)
                topR.setOnClickListener(null)
                pos.remove(topR)
                topR.tag = "p1"
            }
            R.id.board_midLeft -> {
                midL.setImageResource(R.drawable.ic_outline_circle_24)
                midL.setOnClickListener(null)
                pos.remove(midL)
                midL.tag = "p1"
            }
            R.id.board_mid -> {
                mid.setImageResource(R.drawable.ic_outline_circle_24)
                mid.setOnClickListener(null)
                pos.remove(mid)
                mid.tag = "p1"
            }
            R.id.board_midRight -> {
                midR.setImageResource(R.drawable.ic_outline_circle_24)
                midR.setOnClickListener(null)
                pos.remove(midR)
                midR.tag = "p1"
            }
            R.id.board_botLeft -> {
                botL.setImageResource(R.drawable.ic_outline_circle_24)
                botL.setOnClickListener(null)
                pos.remove(botL)
                botL.tag = "p1"
            }
            R.id.board_botMid -> {
                botM.setImageResource(R.drawable.ic_outline_circle_24)
                botM.setOnClickListener(null)
                pos.remove(botM)
                botM.tag = "p1"
            }
            R.id.board_botRight -> {
                botR.setImageResource(R.drawable.ic_outline_circle_24)
                botR.setOnClickListener(null)
                pos.remove(botR)
                botR.tag = "p1"
            }
        }
        //checks winner after user's turn
        checkWinner()
        if (winner.text != "Player Wins ")
            cpuAction() // allows the cpu to act
        //checks winner after cpu's turn
        checkWinner()

    }

    /**
     * allows the cpu to act and removes the nullifies the users ability to interact
     * with its choices. CpuAction uses the random determine the cpu action.
     */
    private fun cpuAction() {
        if (pos.size != 0) {
            pos.shuffle()
            pos[0].setImageResource(R.drawable.ic_baseline_close_24)
            pos[0].setOnClickListener(null)

            pos[0].tag = "cpu"
            pos.removeAt(0)
        }
    }

    /**
     * Checks if there is a winner by comparing the current state of the board and
     * seeing if it matches the winning combinations.
     */
    @SuppressLint("SetTextI18n")
    private fun checkWinner(){
        // The condition for each win combination
        if(topL.tag == topM.tag && topL.tag == topR.tag && topL.tag != null) {
            bgTopL.setBackgroundColor(Color.GREEN)
            bgTopM.setBackgroundColor(Color.GREEN)
            bgTopR.setBackgroundColor(Color.GREEN)
            // checks the assigned tag to determine winner
            if (topL.tag == "p1")
            winner.text= "Player Wins "
            else
                winner.text = "Cpu Wins"
        }
        else if (topL.tag == midL.tag  && botL.tag == topL.tag && topL.tag != null) {
            bgTopL.setBackgroundColor(Color.GREEN)
            bgMidL.setBackgroundColor(Color.GREEN)
            bgBotL.setBackgroundColor(Color.GREEN)
            if (topL.tag == "p1")
                winner.text= "Player Wins "
            else
                winner.text = "Cpu Wins"
        }
        else if (topL.tag == mid.tag && topL.tag == botR.tag && topL.tag != null){
            bgTopL.setBackgroundColor(Color.GREEN)
            bgMid.setBackgroundColor(Color.GREEN)
            bgBotR.setBackgroundColor(Color.GREEN)
            if (topL.tag == "p1")
                winner.text= "Player Wins "
            else
                winner.text = "Cpu Wins"
        }
        else if (midL.tag == mid.tag && midL.tag == midR.tag && midL.tag != null){
            bgMidL.setBackgroundColor(Color.GREEN)
            bgMid.setBackgroundColor(Color.GREEN)
            bgMidR.setBackgroundColor(Color.GREEN)
            if (midL.tag == "p1")
                winner.text= "Player Wins "
            else
                winner.text = "Cpu Wins"
        }
        else if (botL.tag == botM.tag && botR.tag == botM.tag && botL.tag != null){
            bgBotL.setBackgroundColor(Color.GREEN)
            bgBotMid.setBackgroundColor(Color.GREEN)
            bgBotR.setBackgroundColor(Color.GREEN)
            if (botL.tag == "p1")
                winner.text= "Player Wins "
            else
                winner.text = "Cpu Wins"

        }
        else if(topR.tag == mid.tag && botL.tag == mid.tag && topR.tag != null){
            bgTopR.setBackgroundColor(Color.GREEN)
            bgMid.setBackgroundColor(Color.GREEN)
            bgBotL.setBackgroundColor(Color.GREEN)
            if (topR.tag == "p1")
                winner.text= "Player Wins "
            else
                winner.text = "Cpu Wins"

        }
        else if (topR.tag == midR.tag && midR.tag == botR.tag && topR.tag != null){
            bgTopR.setBackgroundColor(Color.GREEN)
            bgMidR.setBackgroundColor(Color.GREEN)
            bgBotR.setBackgroundColor(Color.GREEN)
            if (topR.tag == "p1")
                winner.text= "Player Wins "
            else
                winner.text = "Cpu Wins"
        }
        else if (topM.tag == mid.tag && mid.tag == botM.tag && topM.tag != null) {
            bgTopM.setBackgroundColor(Color.GREEN)
            bgMid.setBackgroundColor(Color.GREEN)
            bgBotMid.setBackgroundColor(Color.GREEN)
            if (topM.tag == "p1")
                winner.text= "Player Wins "
            else
                winner.text = "Cpu Wins"
        } else if (pos.size == 0) // The draw condition
            winner.text = "It's a tie"

    }


}
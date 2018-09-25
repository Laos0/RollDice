package com.example.android.rolldicescoreboard;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    // My variables
    Random r = new Random();
    int max = 6;
    int min = 0;
    int diceNum = min;
    int randNum = min;
    int aScore = 1;
    int bScore = 4;
    int aRiskScore = 1;
    int bRiskScore = 1;

    String textScore;
    String aTurn = "ALPHA'S TURN";
    String bTurn = "BETA'S TURN";
    String aWin = "ALPHA WIN";
    String bWin = "BETA WIN";



    // Who's turn is it?
    boolean isAlpha = true;
    boolean isBeta = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // my TextView implementations
        final TextView alphaScoreTxt = findViewById(R.id.alphaScore);
        final TextView betaScoreTxt = findViewById(R.id.betaScore);
        final TextView teamTurnTxt = findViewById(R.id.turn);
        final TextView aRiskTxt = findViewById(R.id.alphaRisk);
        final TextView bRiskTxt = findViewById(R.id.betaRisk);


        // my Button's Implementations
        final Button diceBtn = findViewById(R.id.dice);
        final Button addAlphaBtn = findViewById(R.id.alphaAddBtn);
        final Button addBetaBtn = findViewById(R.id.betaAddBtn);
        final Button subAlphaBtn = findViewById(R.id.alphaSubBtn);
        final Button subBetaBtn = findViewById(R.id.betaSubBtn);
        final Button resetBtn = findViewById(R.id.resetBtn);
        final Button aRiskBtn = findViewById(R.id.alphaRiskBtn);
        final Button bRiskBtn = findViewById(R.id.betaRiskBtn);

        diceBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Code here executes on main thread after user presses button
                diceNum = rollDice();
                diceBtn.setText("" + diceNum);

                // If it is alpha's turn add the dice roll to alpha's score or beta's score
                if(isAlpha){
                    aScore = aScore += diceNum;
                    textScore = Integer.toString(aScore);
                    alphaScoreTxt.setText(textScore);
                    if(aScore >= 20){
                        teamTurnTxt.setText(aWin);
                        isAlpha = false;
                        isBeta = false;
                    }else{
                        teamTurnTxt.setText(bTurn);
                        isAlpha = false;
                        isBeta = true;
                    }
                }else if(isBeta){
                    bScore = bScore += diceNum;
                    textScore = Integer.toString(bScore);
                    betaScoreTxt.setText(textScore);
                    if(bScore >= 20){
                        teamTurnTxt.setText(bWin);
                        isAlpha = false;
                        isBeta = false;
                    }else{
                        teamTurnTxt.setText(aTurn);
                        isBeta = false;
                        isAlpha = true;
                    }
                }
            }
        });

        addAlphaBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Code here executes on main thread after user presses button

                if(isAlpha){
                    aScore += 3;
                    textScore = Integer.toString(aScore);
                    alphaScoreTxt.setText(textScore);
                    if(aScore >= 20){
                        teamTurnTxt.setText(aWin);
                        isAlpha = false;
                        isBeta = false;
                    }else{
                        teamTurnTxt.setText(bTurn);
                        isAlpha = false;
                        isBeta = true;
                    }
                }
            }
        });

        addBetaBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Code here executes on main thread after user presses button
                if(isBeta){
                    bScore += 3;
                    textScore = Integer.toString(bScore);
                    betaScoreTxt.setText(textScore);
                    if(bScore >= 20){
                        teamTurnTxt.setText(bWin);
                        isAlpha = false;
                        isBeta = false;
                    }else{
                        teamTurnTxt.setText(aTurn);
                        isBeta = false;
                        isAlpha = true;
                    }

                }
            }
        });

        subAlphaBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Code here executes on main thread after user presses button
                if(isAlpha){
                    bScore -= 3;
                    textScore = Integer.toString(bScore);
                    betaScoreTxt.setText(textScore);
                    if(bScore <= 0){
                        teamTurnTxt.setText(aWin);
                        isAlpha = false;
                        isBeta = false;
                    }else{
                        teamTurnTxt.setText(bTurn);
                        isAlpha = false;
                        isBeta = true;
                    }

                }
            }
        });

        subBetaBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Code here executes on main thread after user presses button
                if(isBeta){
                    aScore -= 3;
                    textScore = Integer.toString(aScore);
                    alphaScoreTxt.setText(textScore);
                    if(aScore <= 0){
                        teamTurnTxt.setText(bWin);
                        isAlpha = false;
                        isBeta = false;
                    }else{
                        teamTurnTxt.setText(aTurn);
                        isAlpha = true;
                        isBeta = false;
                    }

                }
            }
        });

        resetBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Code here executes on main thread after user presses button
                aScore = 1;
                bScore = 4;
                textScore = Integer.toString(aScore);
                alphaScoreTxt.setText(textScore);
                textScore = Integer.toString(bScore);
                betaScoreTxt.setText(textScore);

                aRiskScore = 1;
                bRiskScore = 1;
                textScore = Integer.toString(aRiskScore);
                aRiskTxt.setText(textScore);
                textScore = Integer.toString(bRiskScore);
                bRiskTxt.setText(textScore);

                diceBtn.setText("" + 1);
                isAlpha = true;
                isBeta = false;
                teamTurnTxt.setText(aTurn);
            }
        });

        aRiskBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Code here executes on main thread after user presses button
                if(isAlpha){
                    aRiskScore = rollDice();
                    bRiskScore = rollDice();

                    textScore = Integer.toString(aRiskScore);
                    aRiskTxt.setText(textScore);

                    textScore = Integer.toString(bRiskScore);
                    bRiskTxt.setText(textScore);

                    if(aRiskScore > bRiskScore){
                        aScore += aRiskScore;
                        textScore = Integer.toString(aScore);
                        alphaScoreTxt.setText(textScore);
                        if(aScore >= 20){
                            teamTurnTxt.setText(aWin);
                            isAlpha = false;
                            isBeta = false;
                        }else{
                            teamTurnTxt.setText(bTurn);
                            isAlpha = false;
                            isBeta = true;
                        }
                    }else if(aRiskScore < bRiskScore){
                        bScore += bRiskScore;
                        textScore = Integer.toString(bScore);
                        betaScoreTxt.setText(textScore);
                        if(bScore >= 20){
                            teamTurnTxt.setText(bWin);
                            isAlpha = false;
                            isBeta = false;
                        }else{
                            teamTurnTxt.setText(bTurn);
                            isAlpha = false;
                            isBeta = true;
                        }

                    }else{
                        isAlpha = false;
                        isBeta = true;
                        teamTurnTxt.setText(bTurn);
                    }

                }
            }
        });

        bRiskBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Code here executes on main thread after user presses button

                if(isBeta){
                    aRiskScore = rollDice();
                    bRiskScore = rollDice();

                    textScore = Integer.toString(aRiskScore);
                    aRiskTxt.setText(textScore);

                    textScore = Integer.toString(bRiskScore);
                    bRiskTxt.setText(textScore);

                    if(aRiskScore > bRiskScore){
                        aScore += aRiskScore;
                        textScore = Integer.toString(aScore);
                        alphaScoreTxt.setText(textScore);
                        if(aScore >= 20){
                            teamTurnTxt.setText(aWin);
                            isAlpha = false;
                            isBeta = false;
                        }else{
                            teamTurnTxt.setText(aTurn);
                            isAlpha = true;
                            isBeta = false;
                        }
                    }else if(aRiskScore < bRiskScore){
                        bScore += bRiskScore;
                        textScore = Integer.toString(bScore);
                        betaScoreTxt.setText(textScore);
                        if(bScore >= 20){
                            teamTurnTxt.setText(bWin);
                            isAlpha = false;
                            isBeta = false;
                        }else{
                            teamTurnTxt.setText(aTurn);
                            isAlpha = true;
                            isBeta = false;
                        }

                    }else{
                        isAlpha = true;
                        isBeta = false;
                        teamTurnTxt.setText(aTurn);
                    }

                }
            }
        });


    }

    public int rollDice(){
        randNum = r.nextInt(max-min) + min + 1;
        return randNum;
    }

}

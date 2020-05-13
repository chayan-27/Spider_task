package com.example.spider_task;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Build;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class Game extends AppCompatActivity {

    TextView player1;
    TextView player2;
    TextView roundp1;
    TextView roundp2;
    TextView scorp1;
    TextView scorp2;
    TextView out1;
    TextView out2;
    TextView winner;
    TextView pp1;
    TextView pp2;
    boolean stone1;
    boolean paper1;
    boolean scissor1;
    boolean stone2;
    boolean paper2;
    boolean scissor2;
    String p1;
    String p2;
    int r = 1;
    int score1;
    int score2;
    LinearLayout linearLayout;
    LinearLayout linearLayout1;
    RelativeLayout relativeLayout;
    int rounds;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        if(savedInstanceState!=null){
            score1=savedInstanceState.getInt("score1");
            score2=savedInstanceState.getInt("score2");
            r=savedInstanceState.getInt("rounds");

        }
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        linearLayout = (LinearLayout) findViewById(R.id.player1);
        linearLayout1 = (LinearLayout) findViewById(R.id.player2);
        relativeLayout = (RelativeLayout) findViewById(R.id.decide);
        winner = (TextView) findViewById(R.id.winner);
        pp1 = (TextView) findViewById(R.id.pp1);
        pp2 = (TextView) findViewById(R.id.pp2);
        out1 = (TextView) findViewById(R.id.out1);
        out2 = (TextView) findViewById(R.id.out2);

        Intent intent = getIntent();
        p1 = intent.getStringExtra("player1");
        p2 = intent.getStringExtra("player2");
        String rn = intent.getStringExtra("rounds");
        rounds = Integer.parseInt(rn);
        System.out.println(p1);
        System.out.println(p2);
        System.out.println(rn);

        // int rounds=Integer.parseInt(rn);

        player1 = (TextView) findViewById(R.id.p1);
        player2 = (TextView) findViewById(R.id.p2);
        roundp1 = (TextView) findViewById(R.id.rnp1);
        roundp2 = (TextView) findViewById(R.id.rnp2);
        scorp1 = (TextView) findViewById(R.id.score1);
        scorp2 = (TextView) findViewById(R.id.score2);
        player1.setText(p1);
        player2.setText(p2);
        scorp1.setText("Score : " + score1);
        scorp2.setText("Score : " + score2);
        roundp1.setText("Round : " + r);
        roundp2.setText("Round : " + r);

    }

    public void stone1(View view) {
        stone1 = true;
        scorp1.setText("Score : " + score1);
        scorp2.setText("Score : " + score2);
        linearLayout1.setVisibility(View.VISIBLE);
        linearLayout.setVisibility(View.INVISIBLE);

    }

    public void paper1(View view) {
        paper1 = true;
        scorp1.setText("Score : " + score1);
        scorp2.setText("Score : " + score2);
        linearLayout1.setVisibility(View.VISIBLE);
        linearLayout.setVisibility(View.INVISIBLE);

    }

    public void scissor1(View view) {
        scissor1 = true;
        scorp1.setText("Score : " + score1);
        scorp2.setText("Score : " + score2);
        linearLayout1.setVisibility(View.VISIBLE);
        linearLayout.setVisibility(View.INVISIBLE);

    }

    public void stone2(View view) {
        stone2 = true;
        if (scissor1) {
            score2++;
            decider(p2, "Scissor", "Stone");
            scissor1 = false;
            stone2 = false;
        }
        if (paper1) {

            score1++;
            decider(p1, "Paper", "Stone");
            paper1 = false;
            stone2 = false;
        }
        if (stone1) {
            decider("no one", "Stone", "Stone");
            stone1 = false;
            stone2 = false;
        }
        scorp1.setText("Score : " + score1);
        scorp2.setText("Score : " + score2);
        r++;
        if (r > rounds)
            launch(score1, score2);
        roundp1.setText("Round : " + r);
        roundp2.setText("Round : " + r);
        linearLayout1.setVisibility(View.INVISIBLE);
        linearLayout.setVisibility(View.VISIBLE);


    }

    public void paper2(View view) {
        paper2 = true;
        if (scissor1) {

            score1++;
            decider(p1, "Scissor", "Paper");
            scissor1 = false;
            paper2 = false;
        }
        if (paper1) {
            decider("no one", "Paper", "Paper");

            paper1 = false;
            paper2 = false;
        }
        if (stone1) {
            score2++;
            decider(p2, "Stone", "Paper");
            stone1 = false;
            paper2 = false;
        }
        scorp1.setText("Score : " + score1);
        scorp2.setText("Score : " + score2);
        r++;
        if (r > rounds)
            launch(score1, score2);
        roundp1.setText("Round : " + r);
        roundp2.setText("Round : " + r);

        linearLayout1.setVisibility(View.INVISIBLE);
        linearLayout.setVisibility(View.VISIBLE);
    }

    public void scissor2(View view) {
        scissor2 = true;
        if (scissor1) {
            decider("no one", "Scissor", "Scissor");

            scissor1 = false;
            scissor2 = false;
        }
        if (paper1) {
            score2++;
            decider(p2, "Paper", "Scissor");

            paper1 = false;
            scissor2 = false;
        }
        if (stone1) {
            score1++;
            decider(p1, "Stone", "Scissor");
            stone1 = false;
            scissor2 = false;
        }
        scorp1.setText("Score : " + score1);
        scorp2.setText("Score : " + score2);
        r++;
        if (r > rounds)
            launch(score1, score2);
        roundp1.setText("Round : " + r);
        roundp2.setText("Round : " + r);
        linearLayout1.setVisibility(View.INVISIBLE);
        linearLayout.setVisibility(View.VISIBLE);

    }

    public void decider(String name, String out1, String out2) {
        winner.setText("This round is won by " + name);
        pp1.setText(p1 + " : " + score1);
        pp2.setText(p2 + " : " + score2);
        this.out1.setText(p1 + " : " + out1);
        this.out2.setText(p2 + " : " + out2);
        relativeLayout.setVisibility(View.VISIBLE);
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            public void run() {

                relativeLayout.setVisibility(View.INVISIBLE);

            }
        }, 3000);


    }

    public void launch(int score1, int score2) {
        String nm;
        if (score1 > score2) {
            nm = p1 + " Wins";
        } else if (score2 > score1) {
            nm = p2 + " Wins";
        } else {
            nm = "Its a Draw";
        }
        Intent intent = new Intent(this, Results.class);
        intent.putExtra("winner", nm);
        startActivity(intent);
        finish();


    }



  /*  @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        score1=savedInstanceState.getInt("score1");
        score2=savedInstanceState.getInt("score2");
        r=savedInstanceState.getInt("rounds");
    }*/

    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
       outState.putInt("score1", score1);
        outState.putInt("score2", score2);
        outState.putInt("rounds",r);
    }
}



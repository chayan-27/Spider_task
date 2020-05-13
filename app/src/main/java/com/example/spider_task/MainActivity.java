package com.example.spider_task;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText editText;
    EditText editText1;
    EditText editText2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button=(Button)findViewById(R.id.button);
      //  Button button1=(Button)findViewById(R.id.singlee);
         editText=(EditText)findViewById(R.id.one);
        editText1=(EditText)findViewById(R.id.two);
         editText2=(EditText)findViewById(R.id.editText);

        // final int rounds=Integer.parseInt(rn);

        try{

            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                     String p1=editText.getText().toString();
                    String p2=editText1.getText().toString();
                    String rn=editText2.getText().toString();
                    if( p1.equals("") || p2.equals("")||rn.equals("")){
                        Toast.makeText(MainActivity.this,"Enter valid information",Toast.LENGTH_SHORT).show();
                    }else {
                        if(Integer.parseInt(rn)>0) {
                            Intent intent = new Intent(MainActivity.this, Game.class);
                            intent.putExtra("player1", p1);
                            intent.putExtra("player2", p2);
                            intent.putExtra("rounds", rn);
                            startActivity(intent);

                        }else{
                            Toast.makeText(MainActivity.this,"Enter valid information",Toast.LENGTH_SHORT).show();
                        }
                    }
                }
            });


        }catch(Exception e){
            Toast.makeText(this,"Enter valid information",Toast.LENGTH_SHORT).show();
        }
    }

    public void single(View view) {
        try {
            String p1 = editText.getText().toString();
            String p2 = editText1.getText().toString();
            String rn = editText2.getText().toString();
            if(rn.equals("") || p1.equals("") || p2.equals("")){
                Toast.makeText(this,"Enter valid information",Toast.LENGTH_SHORT).show();
            }else {
                if(Integer.parseInt(rn)>0) {
                    Intent intent = new Intent(MainActivity.this, Single.class);
                    intent.putExtra("player1", p1);
                    intent.putExtra("player2", p2);
                    intent.putExtra("rounds", rn);
                    startActivity(intent);

                }else{
                    Toast.makeText(this,"Enter valid information",Toast.LENGTH_SHORT).show();
                }
            }
        }catch(Exception e){
            Toast.makeText(this,"Enter valid information",Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onStop(){
        super.onStop();
        finish();
    }


}

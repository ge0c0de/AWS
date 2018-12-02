package com.example.omar.gato;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import android.widget.TextView;
import android.widget.Toast;

import com.amazonaws.mobileconnectors.lambdainvoker.*;
import com.amazonaws.auth.CognitoCachingCredentialsProvider;
import com.amazonaws.regions.Regions;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private TextView txtUno;
    private TextView txtDos;
    private Button playButton;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        playButton = (Button)findViewById(R.id.Play);
        txtUno = (TextView) findViewById(R.id.playerUno);
        txtDos = (TextView) findViewById(R.id.player2);

        playButton.setOnClickListener(this);


    }

    private void gameScreen(){
        String g = txtUno.getText().toString();
        String h = txtDos.getText().toString();
        txtUno.setText(g);
        Intent myInt = new Intent(MainActivity.this, Main2Activity.class);
        myInt.putExtra("Parametros", g);
        myInt.putExtra("two",h);
        startActivity(myInt);

    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){

            case R.id.Play:
                if (txtUno.length()==0 || txtDos.length()==0)
                    Toast.makeText(this, "Ingresa Nombres",Toast.LENGTH_LONG).show();
                else{
                    gameScreen();
                }
                break;


        }
    }
}


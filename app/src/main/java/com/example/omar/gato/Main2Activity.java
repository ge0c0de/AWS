package com.example.omar.gato;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.os.Handler;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

public class Main2Activity extends AppCompatActivity implements View.OnClickListener {

    private Button Cero, Uno, Dos, Tres,Cuatro, Cinco, Seis, Siete, Ocho, Ajustes;
    private TextView txtUno, jugadorDos, jugadorUno, mensaje;
    //char ficha[] { 'X', 'O', 'X', 'O'};
    private String ficha[]={"X","O"};
    public static final String EXTRA_MESSAGE = "";

    //@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        //Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        //setSupportActionBar(toolbar);

        Cero = (Button) findViewById(R.id.botonCero);
        Uno = (Button) findViewById(R.id.botonUno);
        Dos = (Button) findViewById(R.id.botonDos);
        Tres = (Button) findViewById(R.id.botonTres);
        Cuatro = (Button) findViewById(R.id.botonCuatro);
        Cinco = (Button) findViewById(R.id.botonCinco);
        Seis = (Button) findViewById(R.id.botonSeis);
        Siete = (Button) findViewById(R.id.botonSiete);
        Ocho = (Button) findViewById(R.id.botonOcho);
        Ajustes = (Button) findViewById(R.id.Settings);
        jugadorUno = (TextView) findViewById(R.id.J1);
        jugadorDos = (TextView) findViewById(R.id.J2);
        txtUno = (TextView) findViewById(R.id.Uno);
        //mensaje = (TextView) findViewById(R.id.msg);
        Cero.setOnClickListener(this);
        Uno.setOnClickListener(this);
        Dos.setOnClickListener(this);
        Tres.setOnClickListener(this);
        Cuatro.setOnClickListener(this);
        Cinco.setOnClickListener(this);
        Seis.setOnClickListener(this);
        Siete.setOnClickListener(this);
        Ocho.setOnClickListener(this);
        Ajustes.setOnClickListener(this);

        String jug1 = getIntent().getExtras().getString("Parametros");
        jugadorUno.setText(jug1);
        String jug2 = getIntent().getExtras().getString("two");
        jugadorDos.setText(jug2);




    }

    public  void aws(){
        final String message="Jugador_UNO";

        String url = "https://1gaoqtbpn5.execute-api.us-east-1.amazonaws.com/prueba/demo";
        RequestQueue queue = Volley.newRequestQueue(this);

        //Clase definida en línea al instanciar StringRequest con un solo método getParams()
        StringRequest stringRequest = new StringRequest(Request.Method.POST, url,
                getPostResponseListener(), getPostErrorListener()) {
            protected Map<String, String> getParams() throws com.android.volley.AuthFailureError {
                //En este mapa se colocan todos los pares de valores de la "forma web" a postear
                Map<String, String> params = new HashMap<>();
                params.put("",message);
                //params.put("parametro", "valor");
                return params;
            };

        };

        //Se envía el StringRequest a la cola
        queue.add(stringRequest);
    }

    public void limpiaTablero(){
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Cero.setText("");
                Uno.setText("");
                Dos.setText("");
                Tres.setText("");
                Cuatro.setText("");
                Cinco.setText("");
                Seis.setText("");
                Siete.setText("");
                Ocho.setText("");
            }
        }, 2000); // Millisecond 1000 = 1 sec

    }


    public  void aws2(){
        final String message="Jugador_DOS";

        String url = "https://1gaoqtbpn5.execute-api.us-east-1.amazonaws.com/prueba/demo";

        //instancia de la cola por default de solicitudes web
        RequestQueue queue = Volley.newRequestQueue(this);

        //Clase definida en línea al instanciar StringRequest con un solo método getParams()
        StringRequest stringRequest = new StringRequest(Request.Method.POST, url,
                getPostResponseListener(), getPostErrorListener()) {
            protected Map<String, String> getParams() throws com.android.volley.AuthFailureError {
                //En este mapa se colocan todos los pares de valores de la "forma web" a postear
                Map<String, String> params = new HashMap<>();
                params.put("",message);
                //params.put("parametro", "valor");
                return params;
            };

        };

        //Se envía el StringRequest a la cola
        queue.add(stringRequest);
    }


    public void logicGame(){
        if (Cero.getText()=="X" && Uno.getText() == "X" && Dos.getText()=="X"){
            txtUno.setText("Cargando");
            aws();
            limpiaTablero();


        }
        else if(Cero.getText()=="O" && Uno.getText()=="O" && Dos.getText()=="O"){
            txtUno.setText("Cargando");
            aws2();
            limpiaTablero();
        }
        else if(Cero.getText()=="X" && Tres.getText()=="X" && Seis.getText()=="X"){
            txtUno.setText("Cargando");
            aws();
            limpiaTablero();
        }
        else if(Cero.getText()=="O" && Tres.getText()=="O" && Seis.getText()=="O"){
            txtUno.setText("Cargando");
            aws2();
            limpiaTablero();
        }
        else if(Cero.getText()=="X" && Cuatro.getText()=="X" && Ocho.getText()=="X"){
            txtUno.setText("Cargando");
            aws();
            limpiaTablero();
        }
        else if(Cero.getText()=="O" && Cuatro.getText()=="O" && Ocho.getText()=="O"){
            txtUno.setText("Cargando");
            aws2();
            limpiaTablero();
        }
        else if(Uno.getText()=="X" && Cuatro.getText()=="X" && Siete.getText()=="X"){
            txtUno.setText("Cargando");
            aws();
            limpiaTablero();
        }
        else if(Uno.getText()=="O" && Cuatro.getText()=="O" && Siete.getText()=="O"){
            txtUno.setText("Cargando");
            aws2();
            limpiaTablero();
        }
        else if(Dos.getText()=="X" && Cinco.getText()=="X" && Ocho.getText()=="X"){
            txtUno.setText("Cargando");
            aws();
            limpiaTablero();
        }
        else if(Dos.getText()=="O" && Cinco.getText()=="O" && Ocho.getText()=="O"){
            txtUno.setText("Cargando");
            aws2();
            limpiaTablero();
        }
        else if(Tres.getText()=="X" && Cuatro.getText()=="X" && Cinco.getText()=="X"){
            txtUno.setText("Cargando");
            aws();
            limpiaTablero();
        }
        else if(Tres.getText()=="O" && Cuatro.getText()=="O" && Cinco.getText()=="O"){
            txtUno.setText("Cargando");
            aws2();
            limpiaTablero();
        }
        else if(Seis.getText()=="X" && Siete.getText()=="X" && Ocho.getText()=="X"){
            txtUno.setText("Cargando");
            aws();
            limpiaTablero();
        }

        else if(Seis.getText()=="O" && Siete.getText()=="O" && Ocho.getText()=="O"){
            txtUno.setText("Cargando");
            aws2();
            limpiaTablero();
        }
        else if(Dos.getText()=="X" && Cuatro.getText()=="X" && Seis.getText()=="X"){
            txtUno.setText("Cargando");
            aws();
            limpiaTablero();
        }
        else if(Dos.getText()=="O" && Cuatro.getText()=="O" && Seis.getText()=="O"){
            txtUno.setText("Cargando");
            aws2();
            limpiaTablero();
        }else{
            txtUno.setText("No hay ganador");
        }
    }

    public void mostrarAjustes(){
        Intent myInt = new Intent(Main2Activity.this, SettingsActivity.class);
        startActivity(myInt);
    }


    int cont =9;
    @Override
    public void onClick(View v) {
        //txtDos.setText("");
        //while (true) {
            switch (v.getId()) {
                case R.id.botonCero:
                    if (cont % 2 == 0) {
                        String l = ficha[0];
                        Cero.setText(l);
                        //cont--;
                        String tam = Integer.toString(cont);
                        txtUno.setText(tam);
                        logicGame();

                    }else {
                        String m = ficha[1];
                        Cero.setText(m);
                        String tam = Integer.toString(cont);
                        txtUno.setText(tam);
                        logicGame();
                    }
                    cont=cont-1;

                    //txtUno.
                    // txtUno.setText(p);
                    //String a = Cero.getText().toString();
                    //logicGame(a);
                    break;

                case R.id.botonUno:
                    if (cont % 2 == 0) {
                        String l = ficha[0];
                        Uno.setText(l);
                        //cont--;
                        String tam = Integer.toString(cont);
                        txtUno.setText(tam);
                        logicGame();

                    }else {
                        String m = ficha[1];
                        Uno.setText(m);
                        String tam = Integer.toString(cont);
                        txtUno.setText(tam);
                        logicGame();
                    }
                    cont=cont-1;
                    break;

                case R.id.botonDos:
                    if (cont % 2 == 0) {
                        String l = ficha[0];
                        Dos.setText(l);
                        String tam = Integer.toString(cont);
                        txtUno.setText(tam);
                        //--;

                    }else {
                        String m = ficha[1];
                        Dos.setText(m);
                        String tam = Integer.toString(cont);
                        txtUno.setText(tam);
                    }
                    cont--;
                    logicGame();
                    break;

                case R.id.botonTres:
                    if (cont % 2 == 0) {
                        String l = ficha[0];
                        Tres.setText(l);
                        //cont--;
                        String tam = Integer.toString(cont);
                        txtUno.setText(tam);
                        logicGame();

                    }else {
                        String m = ficha[1];
                        Tres.setText(m);
                        String tam = Integer.toString(cont);
                        txtUno.setText(tam);
                        logicGame();
                    }
                    cont--;
                    break;

                case R.id.botonCuatro:
                    if (cont % 2 == 0) {
                        String l = ficha[0];
                        Cuatro.setText(l);
                        //cont--;
                        String tam = Integer.toString(cont);
                        txtUno.setText(tam);
                        logicGame();

                    }else {
                        String m = ficha[1];
                        Cuatro.setText(m);
                        String tam = Integer.toString(cont);
                        txtUno.setText(tam);
                        logicGame();
                    }
                    cont--;
                    break;

                case R.id.botonCinco:
                    if (cont % 2 == 0) {
                        String l = ficha[0];
                        Cinco.setText(l);
                       // cont--;
                        String tam = Integer.toString(cont);
                        txtUno.setText(tam);
                        logicGame();

                    }else {
                        String m = ficha[1];
                        Cinco.setText(m);
                        String tam = Integer.toString(cont);
                        txtUno.setText(tam);
                        logicGame();

                    }
                    cont--;
                    break;

                    case R.id.botonSeis:
                    if (cont % 2 == 0) {
                        String l = ficha[0];
                        Seis.setText(l);
                        //cont--;
                        String tam = Integer.toString(cont);
                        txtUno.setText(tam);
                        logicGame();

                    }else {
                        String m = ficha[1];
                        Seis.setText(m);
                        String tam = Integer.toString(cont);
                        txtUno.setText(tam);
                        logicGame();
                    }
                    cont--;
                    break;

                case R.id.botonSiete:
                    if (cont % 2 == 0) {
                        String l = ficha[0];
                        Siete.setText(l);
                        //cont--;
                        String tam = Integer.toString(cont);
                        txtUno.setText(tam);
                        logicGame();

                    }else {
                        String m = ficha[1];
                        Siete.setText(m);
                        String tam = Integer.toString(cont);
                        txtUno.setText(tam);
                        logicGame();
                    }
                    cont--;
                    break;


                case R.id.botonOcho:
                    if (cont % 2 == 0) {
                        String l = ficha[0];
                        Ocho.setText(l);
                        //cont--;
                        String tam = Integer.toString(cont);
                        txtUno.setText(tam);
                        logicGame();

                    }else {
                        String m = ficha[1];
                        Ocho.setText(m);
                        String tam = Integer.toString(cont);
                        txtUno.setText(tam);
                        logicGame();
                    }
                    cont--;
                    break;

                case R.id.Settings:
                    mostrarAjustes();
                    break;

            }
            //txtUno.setText("");
            //txtDos.setText("O");

    }


    private Response.Listener<String> getPostResponseListener(){
        return new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                //TextView textView = findViewById(R.id.msg);
                txtUno.setText(response);
            }
        };
    }
    private Response.ErrorListener getPostErrorListener(){
        return new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
               // TextView textView = findViewById(R.id.msg);
                txtUno.setText("Red no disponible");
            }
        };
    }
}




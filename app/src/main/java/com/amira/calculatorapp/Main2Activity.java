package com.amira.calculatorapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.mozilla.javascript.Context;
import org.mozilla.javascript.Scriptable;

public class Main2Activity extends AppCompatActivity {

    Button btn1,btn2,btn3,btn4,btn5,btn6,btn7,btn8,btn9,btn0,btnadd,btndiv,btnpercent,btnclear,btndot,btnsub,btnmulti
            ,btnequal,btnbracket;

    TextView tvInput,tvoutput;
    boolean checkBracket=false;
    String process;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_main2 );

        tvInput = findViewById( R.id.tvin );
        tvoutput = findViewById( R.id.tvout );

        btn0 = findViewById( R.id.btn0 );
        btn1 = findViewById( R.id.btn1 );
        btn2 = findViewById( R.id.btn2 );
        btn3 = findViewById( R.id.btn3 );
        btn4 = findViewById( R.id.btn4 );
        btn5 = findViewById( R.id.btn5 );
        btn6 = findViewById( R.id.btn6 );
        btn7 = findViewById( R.id.btn7 );
        btn8 = findViewById( R.id.btn8 );
        btn9 = findViewById( R.id.btn9 );

        btnadd = findViewById( R.id.btnadd );
        btndiv = findViewById( R.id.btndiv );
        btnmulti = findViewById( R.id.btnx );
        btnsub = findViewById( R.id.btnmins );

        btnclear = findViewById( R.id.btnClear );
        btnpercent = findViewById( R.id.btnpercent );
        btndot = findViewById( R.id.btndot );
        btnbracket = findViewById( R.id.btnbracket );

        btnequal = findViewById( R.id.btnequal );


        btnclear.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tvInput.setText( "" );
                tvoutput.setText( "" );
            }
        } );

        btn0.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                process = tvInput.getText().toString();
                tvInput.setText( process + "0" );
            }
        } );

        btn1.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                process = tvInput.getText().toString();
                tvInput.setText( process + "1" );
            }
        } );

        btn2.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                process = tvInput.getText().toString();
                tvInput.setText( process + "2" );
            }
        } );
        btn3.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                process = tvInput.getText().toString();
                tvInput.setText( process + "3" );
            }
        } );
        btn4.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                process = tvInput.getText().toString();
                tvInput.setText( process + "4" );
            }
        } );
        btn5.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                process = tvInput.getText().toString();
                tvInput.setText( process + "5" );
            }
        } );
        btn6.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                process = tvInput.getText().toString();
                tvInput.setText( process + "6" );
            }
        } );
        btn7.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                process = tvInput.getText().toString();
                tvInput.setText( process + "7" );
            }
        } );
        btn8.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                process = tvInput.getText().toString();
                tvInput.setText( process + "8" );
            }
        } );
        btn9.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                process = tvInput.getText().toString();
                tvInput.setText( process + "9" );
            }
        } );
        btnadd.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                process = tvInput.getText().toString();
                tvInput.setText( process + "+" );
            }
        } );
        btnmulti.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                process = tvInput.getText().toString();
                tvInput.setText( process + "x" );
            }
        } );
        btndiv.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                process = tvInput.getText().toString();
                tvInput.setText( process + "/" );
            }
        } );
        btnsub.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                process = tvInput.getText().toString();
                tvInput.setText( process + "-" );
            }
        } );


        btnpercent.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                process = tvInput.getText().toString();
                tvInput.setText( process + "%" );
            }
        } );
        btndot.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                process = tvInput.getText().toString();
                tvInput.setText( process + "." );
            }
        } );

        btnbracket.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (checkBracket) {
                    process = tvInput.getText().toString();
                    tvInput.setText( process + ")" );
                    checkBracket = false;
                } else {
                    process = tvInput.getText().toString();
                    tvInput.setText( process + "(" );
                    checkBracket = true;
                }
            }
        } );
        btnequal.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                process = tvInput.getText().toString();
                process = process.replaceAll( "x", "*" );
                process = process.replaceAll( "%", "/100" );
                process = process.replaceAll( "÷", "/" );

                org.mozilla.javascript.Context rhino = Context.enter();

                rhino.setOptimizationLevel( -1 );

                String finalResult = "";

                try {
                    Scriptable scriptable = rhino.initStandardObjects();
                    finalResult = rhino.evaluateString( scriptable, process, "javascript", 1, null ).toString();
                } catch (Exception e) {
                    finalResult = "0";
                }

                tvoutput.setText( finalResult );


            }

        } );


    }
}

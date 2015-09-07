package com.example.wanddoze.calcjurossimples;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText financiamento;
    private EditText meses;
    private EditText fee;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        financiamento = (EditText) findViewById(R.id.financiamento);
        meses = (EditText) findViewById(R.id.meses);
        fee = (EditText) findViewById(R.id.fee);

    }

    public void calcular(View v){
        Intent i = new Intent(this, ActivityRes.class);
        String resultado = ""+getResultado();
        i.putExtra("resultado", resultado);
        startActivity(i);
    }

    public Double getResultado(){
        double fin = Double.parseDouble(financiamento.getText().toString());
        double taxa = Double.parseDouble(fee.getText().toString());
        int mss = Integer.parseInt(meses.getText().toString());
        return mss * taxa * fin;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}

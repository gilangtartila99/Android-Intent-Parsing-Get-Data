package com.example.gilang.androiduas;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by GILANG on 15/06/2016.
 */
public class ParsingDataActivity extends ActionBarActivity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_parsing);

        Bundle bundle = getIntent().getExtras();

        TextView txtNIS = (TextView) findViewById(R.id.txtNIS);
        TextView txtNama = (TextView) findViewById(R.id.txtNama);
        TextView txtAlamat = (TextView) findViewById(R.id.txtAlamat);
        TextView txtJenkel = (TextView) findViewById(R.id.txtJK);
        TextView txtMatkul = (TextView) findViewById(R.id.txtMatkul);

        txtNIS.setText(bundle.getCharSequence("nis"));
        txtNama.setText(bundle.getCharSequence("nama"));
        txtAlamat.setText(bundle.getCharSequence("alamat"));
        txtJenkel.setText(bundle.getCharSequence("jk"));
        txtMatkul.setText(bundle.getCharSequence("matkul"));
    }

    public void hitungLuas (View v ) {
        EditText edAlas = (EditText) findViewById(R.id.etAlas);
        EditText edTinggi = (EditText) findViewById(R.id.etTinggi);

        String alas = " Alas : " + edAlas.getText();
        String tinggi = "\nTinggi : " + edTinggi.getText();

        if (edAlas.getText().toString().trim().length() == 0) {
            Toast.makeText(getApplicationContext(), "Alas Harus Diisi", Toast.LENGTH_LONG).show();
        } else if (edTinggi.getText().toString().trim().length() == 0) {
            Toast.makeText(getApplicationContext(), "Tinggi Harus Diisi", Toast.LENGTH_LONG).show();
        } else {
            Intent i = new Intent(ParsingDataActivity.this, GetDataActivity.class);
            Bundle bundle = new Bundle();
            bundle.putString("alas", alas);
            bundle.putString("tinggi", tinggi);
            bundle.putString("bilAlas", edAlas.getText().toString());
            bundle.putString("bilTinggi", edTinggi.getText().toString());
            Toast.makeText(getApplicationContext(), alas + tinggi, Toast.LENGTH_LONG).show();
            i.putExtras(bundle);
            finish();
            startActivity(i);
        }
    }


}

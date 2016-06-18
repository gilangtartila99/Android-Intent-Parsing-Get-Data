package com.example.gilang.androiduas;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.widget.TextView;

/**
 * Created by GILANG on 15/06/2016.
 */
public class GetDataActivity extends ActionBarActivity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_getdata);

        Bundle bundle = getIntent().getExtras();

        TextView txtAlas = (TextView) findViewById(R.id.txtAlas);
        TextView txtTinggi = (TextView) findViewById(R.id.txtTinggi);

        txtAlas.setText(bundle.getCharSequence("alas"));
        txtTinggi.setText(bundle.getCharSequence("tinggi"));

        TextView txtLuas = (TextView) findViewById(R.id.txtLuas);
        double bilAlas = Double.parseDouble(bundle.getString("bilAlas"));
        double bilTinggi = Double.parseDouble(bundle.getString("bilTinggi"));
        txtLuas.setText(String.valueOf("\nLuas : " + (bilAlas / 2) *bilTinggi));
    }
}

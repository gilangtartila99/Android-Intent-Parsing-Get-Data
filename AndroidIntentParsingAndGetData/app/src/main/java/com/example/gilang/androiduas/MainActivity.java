package com.example.gilang.androiduas;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void parsingData(View v) {
        EditText edNIS = (EditText) findViewById(R.id.nis);
        EditText edNama = (EditText) findViewById(R.id.etNama);
        EditText edAlamat = (EditText) findViewById(R.id.etAlamat);
        RadioGroup rgJenisKelamin = (RadioGroup) findViewById(R.id.radioGroup);
        CheckBox cbBI = (CheckBox) findViewById(R.id.cbBI);
        CheckBox cbMTK = (CheckBox) findViewById(R.id.cbMTK);
        CheckBox cbFIS = (CheckBox) findViewById(R.id.cbFIS);
        CheckBox cbKIM = (CheckBox) findViewById(R.id.cbKIM);
        CheckBox cbBIO = (CheckBox) findViewById(R.id.cbBIO);

        String nis = "NIS : " + edNIS.getText();
        String nama = "Nama : " + edNama.getText();
        String alamat = "Alamat : " + edAlamat.getText();
        String jk = "Jenis Kelamin : ";
        String matkul = "\nMata pelajaran yang diambil : ";

        switch (rgJenisKelamin.getCheckedRadioButtonId()) {
            case R.id.rbJKL:
                jk = jk + "Laki-laki";
                break;
            case R.id.rbJKP:
                jk = jk + "Perempuan";
                break;
        }

        if (cbBI.isChecked()){
            matkul = matkul + "\nBahasa Indonesia";
        } if (cbMTK.isChecked()){
            matkul = matkul + "\nMatematika";
        } if (cbFIS.isChecked()){
            matkul = matkul + "\nFisika";
        } if (cbKIM.isChecked()){
            matkul = matkul + "\nKimia";
        } if (cbBIO.isChecked()){
            matkul = matkul + "\nBiologi";
        }

        if (edNIS.getText().toString().trim().length() == 0) {
            Toast.makeText(getApplicationContext(), "NIS Harus Diisi", Toast.LENGTH_LONG).show();
        } else if (edNama.getText().toString().trim().length() == 0) {
            Toast.makeText(getApplicationContext(), "Nama Harus Diisi", Toast.LENGTH_LONG).show();
        } else if (edAlamat.getText().toString().trim().length() == 0) {
            Toast.makeText(getApplicationContext(), "Alamat Harus Diisi", Toast.LENGTH_LONG).show();
        } else {
            Intent i = new Intent(MainActivity.this, ParsingDataActivity.class);
            Bundle bundle = new Bundle();
            bundle.putString("nis", nis);
            bundle.putString("nama", nama);
            bundle.putString("alamat", alamat);
            bundle.putString("jk", jk);
            bundle.putString("matkul", matkul);
            Toast.makeText(getApplicationContext(), nis + nama + alamat + jk + matkul , Toast.LENGTH_LONG).show();
            i.putExtras(bundle);
            finish();
            startActivity(i);
        }
    }
}

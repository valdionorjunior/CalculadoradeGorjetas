package com.juniorrodrigues.calculadoradegorjetas;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.SeekBar;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity {

    private TextInputEditText edtValor;
    private TextView txtPercent;
    private TextView txtGorjeta;
    private TextView txtTotal;
    private SeekBar seekBar;

    private double porcentagem = 0; //porcentagem inicial de gorjeta.

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtValor = findViewById(R.id.edtValor);
        txtPercent = findViewById(R.id.txtPercent);
        txtGorjeta = findViewById(R.id.txtGorjeta);
        txtTotal = findViewById(R.id.txtTotal);
        seekBar = findViewById(R.id.seekBar);

        //Controlador Seekbar
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                porcentagem = seekBar.getProgress();
                txtPercent.setText(Math.round(porcentagem)+"%");//Math.round() arredondar
                calcularGorjeta();
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }

    private void calcularGorjeta() {
        //recuperando valor
        //Verifico se o campo está vario e paço 0, se não passa o valor que estiver
        double valorDigitado = Double.parseDouble(edtValor.getText().toString().equals("") ? "0" : edtValor.getText().toString());

        //calculo da gorjeta
        double gorjeta = valorDigitado * (porcentagem/100); //calculo da porcentagem sobre valor
        double total = gorjeta + valorDigitado;

        //exibindo valores
        txtGorjeta.setText("R$ "+Math.round(gorjeta));//Math.round arredonda o valor
        txtTotal.setText("R$ "+total);
    }
}

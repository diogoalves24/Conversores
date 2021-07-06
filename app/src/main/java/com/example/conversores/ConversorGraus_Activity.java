package com.example.conversores;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;


public class ConversorGraus_Activity extends AppCompatActivity implements AdapterView.OnItemSelectedListener{

    Spinner spinner;
    EditText et_paraConverter;
    Button btn_converter, btn_voltar;
    TextView tv_resultado;
    double formula, converter;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_conversor_graus);

        spinner = findViewById(R.id.spinner);
        et_paraConverter = findViewById(R.id.et_paraConverter);
        btn_converter = findViewById(R.id.btn_converter);
        btn_voltar = findViewById(R.id.btn_voltar);
        tv_resultado = findViewById(R.id.tv_resultado);

        ArrayAdapter<CharSequence> adapterTemperaturas = ArrayAdapter.createFromResource(this, R.array.array_temperaturas, android.R.layout.simple_spinner_dropdown_item);
        adapterTemperaturas.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapterTemperaturas);

        btn_converter.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if(spinner.getSelectedItemPosition() == 0){
                    converter = Double.parseDouble(et_paraConverter.getText().toString());
                    formula = 1.8 * converter + 32;
                    tv_resultado.setText("Resultado = " + formula);
                }
                else if(spinner.getSelectedItemPosition() == 1){
                    converter = Double.parseDouble(et_paraConverter.getText().toString());
                    formula = (converter - 32) / 1.8;
                    tv_resultado.setText("Resultado = " + formula);
                }
                else if(spinner.getSelectedItemPosition() == 2){
                    converter = Double.parseDouble(et_paraConverter.getText().toString());
                    formula = converter + 273;
                    tv_resultado.setText("Resultado = " + formula);
                }
                else if(spinner.getSelectedItemPosition() == 3){
                    converter = Double.parseDouble(et_paraConverter.getText().toString());
                    formula = converter - 273;
                    tv_resultado.setText("Resultado = " + formula);
                }
                else if(spinner.getSelectedItemPosition() == 4){
                    converter = Double.parseDouble(et_paraConverter.getText().toString());
                    formula = ((converter - 32) + 273) / 1.8;
                    tv_resultado.setText("Resultado = " + formula);
                }
                else{
                    converter = Double.parseDouble(et_paraConverter.getText().toString());
                    formula = 1.8 * (converter - 273) + 32;
                    tv_resultado.setText("Resultado = " + formula);
                }
            }
        });

        btn_voltar.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                finish();
            }
        });
    }

    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        if(position == 0){
            et_paraConverter.setHint("Temperatura em ºC");
        }
        else if(position == 1){
            et_paraConverter.setHint("Temperatura em ºF");
        }
        else if(position == 2){
            et_paraConverter.setHint("Temperatura em ºC");
        }
        else if(position == 3){
            et_paraConverter.setHint("Temperatura em ºK");
        }
        else if(position == 4){
            et_paraConverter.setHint("Temperatura em ºF");
        }
        else{
            et_paraConverter.setHint("Temperatura em ºK");
        }
    }

    public void onNothingSelected(AdapterView<?> parent) {

    }
}
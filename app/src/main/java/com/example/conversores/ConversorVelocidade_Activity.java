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

public class ConversorVelocidade_Activity extends AppCompatActivity implements  AdapterView.OnItemSelectedListener{

    Spinner spinner;
    EditText et_paraConverter, et_convertido;
    Button btn_converter, btn_voltar;
    TextView tv_resultado;
    double formula, converter;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_conversor_velocidade);

        spinner = findViewById(R.id.spinner);
        et_paraConverter = findViewById(R.id.et_paraConverter);
        btn_converter = findViewById(R.id.btn_converter);
        btn_voltar = findViewById(R.id.btn_voltar);
        tv_resultado = findViewById(R.id.tv_resultado);

        ArrayAdapter<CharSequence> adapterMoedas = ArrayAdapter.createFromResource(this, R.array.array_velocidade, android.R.layout.simple_spinner_dropdown_item);
        adapterMoedas.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapterMoedas);

        btn_converter.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (spinner.getSelectedItemPosition() == 0) {
                    converter = Double.parseDouble(et_paraConverter.getText().toString());
                    formula = 0.621371192 * converter;
                    tv_resultado.setText("Resultado = " + String.valueOf(formula));
                } else {
                    converter = Double.parseDouble(et_paraConverter.getText().toString());
                    formula = converter / 0.621371192;
                    tv_resultado.setText("Resultado = " + String.valueOf(formula));
                }
            }
        });

        btn_voltar.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                finish();
            }
        });
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
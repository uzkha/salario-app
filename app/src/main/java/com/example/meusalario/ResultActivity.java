package com.example.meusalario;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

public class ResultActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        Button btnFechar   = (Button)findViewById(R.id.btnFechar);

        btnFechar.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                finish();
            }

        });

        setValues();
    }

    private void setValues() {

        TextView txtSalarioBruto = (TextView) findViewById(R.id.txtSalarioBrutoResult);
        TextView txtInss = (TextView) findViewById(R.id.txtInssResult);
        TextView txtIrff = (TextView) findViewById(R.id.txtIRFFResult);
        TextView txtOutros = (TextView) findViewById(R.id.txtOutrosDescontosResult);
        TextView txtSalarioLiquido = (TextView) findViewById(R.id.txtSalLiqResult);
        TextView txtDecontos = (TextView) findViewById(R.id.txtDescTotalResult);

        Intent intent = getIntent();
        double salarioBruto = intent.getDoubleExtra("SALARIOBRUTO", 0);
        txtSalarioBruto.setText(String.valueOf(salarioBruto));

        double inss = intent.getDoubleExtra("INSS", 0);
        txtInss.setText(String.valueOf(inss));

        double irff = intent.getDoubleExtra("IRFF", 0);
        txtIrff.setText(String.valueOf(irff));

        double outros = intent.getDoubleExtra("OUTROSDESCONTOS", 0);
        txtOutros.setText(String.valueOf(outros));

        double salarioLiquido = intent.getDoubleExtra("SALARIOLIQUIDO", 0);
        txtSalarioLiquido.setText(String.valueOf(salarioLiquido));

        double percentDesc = intent.getDoubleExtra("DESCONTOPERCET", 0);
        txtDecontos.setText(String.valueOf(percentDesc));



    }
}
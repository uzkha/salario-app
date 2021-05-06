package com.example.meusalario;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.meusalario.model.Inss;
import com.example.meusalario.model.Irff;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnCalcular   = (Button)findViewById(R.id.btnCalcular);

        btnCalcular.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Log.i("BUTRON", "Button calc clicked!");
                calcular();
            }

        });

    }

    private void calcular() {

        EditText editSalarioBruto = (EditText) findViewById(R.id.editSalBruto);
        Double salarioBruto = Double.parseDouble(String.valueOf(editSalarioBruto.getText()));
        Log.i("SALARIOBRUTO", salarioBruto.toString());

        EditText editDependentes = (EditText) findViewById(R.id.editDependentes);
        int dependentes = Integer.parseInt(String.valueOf(editDependentes.getText()));
        Log.i("DEPENTENS", String.valueOf(dependentes));

        EditText editOutrosDesc = (EditText) findViewById(R.id.editOutrosDescontos);
        Double outrosDesc = Double.parseDouble(String.valueOf(editOutrosDesc.getText()));
        Log.i("OUTROSDESC", outrosDesc.toString());

        Inss inss = new Inss(salarioBruto);
        Log.i("INSS", inss.getAliquota() + " " + inss.getDeducao());

        //salario bruto - inss - dependentes x 189.59
        //salario result - irrf

        double contribInss;
        if(salarioBruto > 6101.06){
            contribInss = 713.10;
        }else{
            contribInss = ( (salarioBruto * inss.getAliquota() / 100) - inss.getDeducao() );
        }
        Log.i("CONTRIBINSS", String.valueOf(contribInss));

        double baseIrff = salarioBruto - contribInss - (dependentes * 189.59);
        Irff irrf = new Irff(baseIrff);
        Log.i("IRFF", irrf.getAliquota() + " " + irrf.getDeducao());

        double contribIrff = ((baseIrff * irrf.getAliquota() / 100) - irrf.getDeducao());
        Log.i("CONTRIBIRFF", String.valueOf(contribIrff));

        double salarioLiquido = salarioBruto - contribInss - contribIrff - outrosDesc;
        Log.i("SALLIQ", String.valueOf(salarioLiquido));

        double percenttotalDescontos =  (  100 - ((salarioLiquido * 100) / salarioBruto) );
        Log.i("DECTPERCET", String.valueOf(percenttotalDescontos));

        Intent intent = new Intent(this, ResultActivity.class);
        intent.putExtra("DESCONTOPERCET", percenttotalDescontos);
        intent.putExtra("SALARIOLIQUIDO", salarioLiquido);
        intent.putExtra("OUTROSDESCONTOS", outrosDesc);
        intent.putExtra("IRFF", contribIrff);
        intent.putExtra("INSS", contribInss);
        intent.putExtra("SALARIOBRUTO", salarioBruto);

        startActivity(intent);

    }





}
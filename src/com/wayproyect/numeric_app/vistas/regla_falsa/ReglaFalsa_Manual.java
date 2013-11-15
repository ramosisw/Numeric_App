package com.wayproyect.numeric_app.vistas.regla_falsa;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.*;
import com.wayproyect.numeric_app.R;
import com.wayproyect.numeric_app.algoritmos.EvalFunction;
import com.wayproyect.numeric_app.algoritmos.ReglaFalsa;

/**
 * Created with wayproyect
 * User: ADMIN
 * Date: 14/11/13
 * Time: 10:39 PM
 * To change this template use File | Settings | File Templates.
 */
public class ReglaFalsa_Manual extends Activity {
    private EditText function;
    private EditText a;
    private EditText b;
    private EditText er;
    private TextView txt_xr_r;
    private TextView txt_er_r;
    private Button btn_calcular;
    private LinearLayout l_r1;
    private LinearLayout l_r2;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        super.setContentView(R.layout.regla_falsa_manual);
        init();
    }

    private void init() {
        this.function = (EditText) findViewById(R.id.txt_fx);
        this.a = (EditText) findViewById(R.id.txt_a);
        this.b = (EditText) findViewById(R.id.txt_b);
        this.er = (EditText) findViewById(R.id.txt_er);
        this.txt_er_r = (TextView) findViewById(R.id.txt_er_r);
        this.txt_xr_r = (TextView) findViewById(R.id.txt_xr_r);
        this.btn_calcular = (Button) findViewById(R.id.btn_calcular);
        this.btn_calcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btn_calcularOnclic(view);
            }
        });
        l_r1 = (LinearLayout) findViewById(R.id.ly_result1);
        l_r2 = (LinearLayout) findViewById(R.id.ly_result2);
        l_r1.setVisibility(View.INVISIBLE);
        l_r2.setVisibility(View.INVISIBLE);
    }

    private void btn_calcularOnclic(View view) {
        try {
            int a = Integer.parseInt(this.a.getText().toString());
            int b = Integer.parseInt(this.b.getText().toString());
            double er = Double.parseDouble(this.er.getText().toString());
            String fx = this.function.getText().toString();
            if (fx.length() == 0) {
                return;
            }
            double a_e = new EvalFunction().eval(fx, a);
            double b_e = new EvalFunction().eval(fx, b);
            if (a_e * b_e < 0) {
                Toast.makeText(this, "Si Contiene Raiz", Toast.LENGTH_LONG).show();
                double xr = new ReglaFalsa().metodoDeReglaFalsa(fx, a, b, er);
                this.txt_xr_r.setText(xr + "");
                this.l_r1.setVisibility(View.VISIBLE);
            } else {
                Toast.makeText(this, "No Tiene Raiz", Toast.LENGTH_LONG).show();
            }
        } catch (Exception ex) {
            Toast.makeText(this, "ERROR!", Toast.LENGTH_LONG).show();
        }
    }

}
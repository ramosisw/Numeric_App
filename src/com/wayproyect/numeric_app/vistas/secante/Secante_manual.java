package com.wayproyect.numeric_app.vistas.secante;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.*;
import com.wayproyect.numeric_app.R;
import com.wayproyect.numeric_app.algoritmos.EvalFunction;
import com.wayproyect.numeric_app.algoritmos.encontrar_raiz.Secante;

/**
 * Created with Wayproyect.
 * User: ADMIN
 * Date: 20/11/13
 * Time: 12:28 AM
 * To change this template use File | Settings | File Templates.
 */
public class Secante_manual extends Activity {
    private EditText fx;
    private EditText xi;
    private EditText xi_1;
    private EditText er;
    private Button btn_calcular;
    private LinearLayout l_r1;
    private LinearLayout l_r2;
    private TextView xr;
    private TextView er_r;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        super.setContentView(R.layout.secante_manual);
        init();
    }

    private void init() {
        this.fx = (EditText) findViewById(R.id.txt_fx);
        this.xi = (EditText) findViewById(R.id.txt_xi);
        this.xi_1 = (EditText) findViewById(R.id.txt_xi_1);
        this.er = (EditText) findViewById(R.id.txt_er);
        this.btn_calcular = (Button) findViewById(R.id.btn_calcular);
        this.btn_calcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btn_calcularOnClick(view);
            }
        });
        this.xr = (TextView) findViewById(R.id.txt_xr_r);
        this.er_r = (TextView) findViewById(R.id.txt_er_r);
        this.l_r1 = (LinearLayout) findViewById(R.id.ly_result1);
        this.l_r2 = (LinearLayout) findViewById(R.id.ly_result2);
        l_r1.setVisibility(View.INVISIBLE);
        l_r2.setVisibility(View.INVISIBLE);
    }

    private void btn_calcularOnClick(View view) {
        try {
            String fx = this.fx.getText().toString();
            if (fx.length() == 0) {
                Toast.makeText(this, "Error No Escribiste una ecuacion", Toast.LENGTH_LONG).show();
                return;
            }
            int xi = Integer.parseInt(this.xi.getText().toString());
            int xi_1 = Integer.parseInt(this.xi_1.getText().toString());
            double er = Double.parseDouble(this.er.getText().toString()) / 100;
            if (er == 0) {
                Toast.makeText(this, "Error Relativo a 0 Puede Tardar Mucho.\nIntente otro Error Relativo", Toast.LENGTH_LONG).show();
                return;
            }
            new EvalFunction().eval(fx, xi);
            Secante secante = new Secante();
            double xr = secante.metodoDeSecante(fx, xi, xi_1, er);
            if (String.valueOf(xr).equals("NaN")) {
                Toast.makeText(this, "ERROR!\nEn el intervalo\nX: " + xr + "\nNo existe una Raiz \nó no se puedo obtener", Toast.LENGTH_LONG).show();
            } else {
                this.xr.setText(String.valueOf(xr));
                this.er_r.setText(secante.getER());
                this.l_r1.setVisibility(View.VISIBLE);
                this.l_r2.setVisibility(View.VISIBLE);
            }
        } catch (Exception ex) {
            Toast.makeText(this, "ERROR!\nTal vez tu ecuacion esta mal escrita,\no nosotros tubimos problemas.", Toast.LENGTH_LONG).show();
        }
    }
}
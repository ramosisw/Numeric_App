package com.wayproyect.numeric_app.vistas.regla_falsa;

import android.app.Activity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;
import com.wayproyect.numeric_app.R;

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
    }
}
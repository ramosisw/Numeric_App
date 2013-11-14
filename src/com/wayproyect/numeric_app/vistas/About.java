package com.wayproyect.numeric_app.vistas;

import android.app.Activity;
import android.os.Bundle;
import com.wayproyect.numeric_app.R;

/**
 * @author ramosisw
 *         Created with wayproyect
 *         User: Ramos.isw
 *         Date: 12/11/13
 *         Time: 11:40 AM
 *         To change this template use File | Settings | File Templates.
 */
public class About extends Activity {
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        super.setContentView(R.layout.about);
    }

    @Override
    public void onBackPressed() {
        finish();
        super.onBackPressed();
    }
}
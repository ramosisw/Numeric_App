package com.wayproyect.numeric_app.vistas;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import com.wayproyect.numeric_app.R;

/**
 * Created with wayproyect
 * User: Ramos.isw
 * Date: 12/11/13
 * Time: 11:38 AM
 * To change this template use File | Settings | File Templates.
 */
public class Menu extends Activity {
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        super.setContentView(R.layout.menu);
    }

    @Override
    public boolean onCreateOptionsMenu(android.view.Menu menu) {
        getMenuInflater().inflate(R.menu.menu_menu, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        boolean elemento = super.onOptionsItemSelected(item);
        if (item.getItemId() == R.id.menu_about) {
            Intent intent = new Intent(this, About.class);
            startActivity(intent);
            elemento = true;
        }
        return elemento;

    }

}
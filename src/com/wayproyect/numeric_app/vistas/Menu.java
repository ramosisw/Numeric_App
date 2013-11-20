package com.wayproyect.numeric_app.vistas;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.MenuItem;
import android.view.View;
import android.widget.ExpandableListView;
import android.widget.ExpandableListView.OnChildClickListener;
import android.widget.Toast;
import com.wayproyect.numeric_app.R;
import com.wayproyect.numeric_app.adapters.ExpandableListAdapter;
import com.wayproyect.numeric_app.vistas.biseccion.Biseccion_Manual;
import com.wayproyect.numeric_app.vistas.newton.Newton_Manual;
import com.wayproyect.numeric_app.vistas.regla_falsa.ReglaFalsa_Manual;
import com.wayproyect.numeric_app.vistas.secante.Secante_manual;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * Created with wayproyect
 * User: Ramos.isw
 * Date: 12/11/13
 * Time: 11:38 AM
 * To change this template use File | Settings | File Templates.
 */
public class Menu extends Activity {
    List<String> groupList;
    List<String> childList;
    Map<String, List<String>> encontrar_raiz;
    ExpandableListView expListView;
    Class[][] encontrarRaiz = {
            {null, Biseccion_Manual.class},
            {null, ReglaFalsa_Manual.class},
            {null, Newton_Manual.class},
            {null, Secante_manual.class}};

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        super.setContentView(R.layout.menu);

        createGroupList();
        createCollection();

        expListView = (ExpandableListView) findViewById(R.id.encontrar_raiz_list);
        final ExpandableListAdapter expListAdapter = new ExpandableListAdapter(this, groupList, encontrar_raiz);
        expListView.setAdapter(expListAdapter);


        setGroupIndicatorToRight();

        expListView.setOnChildClickListener(new OnChildClickListener() {
            public boolean onChildClick(ExpandableListView parent, View v, int groupPosition, int childPosition, long id) {
                Class clase = encontrarRaiz[groupPosition][childPosition];
                if (clase == null) {
                    Toast.makeText(Menu.this, "Estamos trabajando en Ello\nPronto quedara ;)", Toast.LENGTH_LONG).show();
                    return false;
                } else {
                    Intent intent = new Intent(Menu.this, clase);
                    startActivity(intent);
                    return true;
                }

            }
        });
    }

    private void createGroupList() {
        groupList = new ArrayList<String>();
        groupList.add("Bisección");
        groupList.add("Regla Falsa");
        groupList.add("Newton Raphson");
        //groupList.add("Secante");

    }

    private void createCollection() {
        encontrar_raiz = new LinkedHashMap<String, List<String>>();
        for (String group : groupList) {
            loadChild();
            encontrar_raiz.put(group, childList);
        }
    }

    private void loadChild() {
        childList = new ArrayList<String>();
        childList.add("Automatico");
        childList.add("Manual");
    }

    private void setGroupIndicatorToRight() {
        /* Get the screen width */
        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);
        int width = dm.widthPixels;
        expListView.setIndicatorBounds(width - getDipsFromPixel(50), width
                - getDipsFromPixel(10));
    }

    // Convert pixel to dip
    public int getDipsFromPixel(float pixels) {
        // Get the screen's density scale
        final float scale = getResources().getDisplayMetrics().density;
        // Convert the dps to pixels, based on density scale
        return (int) (pixels * scale + 0.5f);
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
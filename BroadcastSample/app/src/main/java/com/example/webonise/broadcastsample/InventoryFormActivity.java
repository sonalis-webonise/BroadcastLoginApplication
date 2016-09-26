package com.example.webonise.broadcastsample;

import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import io.realm.Realm;
import io.realm.RealmResults;

public class InventoryFormActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText editmodel;
    private Spinner spinnerCategory;
    private EditText editquantity;
    private Button btnSave;

    Realm realm;

    private int model, quantity;
    private String category;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inventory_form);
        realm = Realm.getDefaultInstance();
        initViews();

        // Creating adapter for spinner
        ArrayAdapter<CharSequence> dataAdapter = ArrayAdapter.createFromResource(this, R.array.spinner_category, android.R.layout.simple_spinner_item);
        // Drop down layout style - list view with radio button
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // attaching data adapter to spinner
        spinnerCategory.setAdapter(dataAdapter);
    }

    private void initViews() {
        editmodel = (EditText) findViewById(R.id.editmodel);
        editquantity = (EditText) findViewById(R.id.editquantity);

        spinnerCategory = (Spinner) findViewById(R.id.spinnerCategory);
        btnSave = (Button) findViewById(R.id.btnSave);


        btnSave.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        saveToDatabase(model = Integer.parseInt(editmodel.getText().toString().trim()),
                category = spinnerCategory.getSelectedItem().toString(),
                quantity = Integer.parseInt(editquantity.getText().toString().trim()));
        editmodel.setText("");
        editquantity.setText("");
    }

    private void saveToDatabase(final int model, final String category, final int quantity) {

        realm.executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(Realm bgRealm) {
                InventoryClass inventory = realm.createObject(InventoryClass.class);
                inventory.setModel(model);
                inventory.setCategory(category);
                inventory.setQuantity(quantity);
            }
        });
        AlertDialog.Builder builder = new AlertDialog.Builder(InventoryFormActivity.this);
        builder.setMessage("Data Saved")
                .setPositiveButton("OK",null);
        builder.show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        realm.close();
    }
}

package com.example.expserialiser2023;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {
    EditText txtNum,txtNom;
    ListView lv;
    Button btnAjouter,btnSerialiser;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtNom = findViewById(R.id.txtNom);
        txtNum = findViewById(R.id.txtNum);
        btnAjouter=findViewById(R.id.btnAjouter);
        btnSerialiser=findViewById(R.id.btnSerialiser);
        lv = findViewById(R.id.lv);
        Client.deSerialiser(getApplicationContext());
        ArrayAdapter<Client> AA = new ArrayAdapter<>(getApplicationContext(),
                android.R.layout.simple_list_item_1, Client.getLstClients());
        lv.setAdapter(AA);
        btnAjouter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Client C = new Client(Integer.parseInt(txtNum.getText().toString()), txtNom.getText().toString());
Client.ajouter(C);
AA.notifyDataSetChanged();
            }
        });
        btnSerialiser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Client.serialiser(getApplicationContext());
            }
        });
    }
}
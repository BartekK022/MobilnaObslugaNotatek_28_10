package com.example.myapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<String> arrayListNotatki = new ArrayList<>();
    ArrayAdapter<String> arrayAdapterNotatki;
    ListView listViewNotatki;
    EditText editTextNowaNotatka;
    Button buttonDodajNotatke;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        listViewNotatki = findViewById(R.id.listViewNotatki);
        editTextNowaNotatka = findViewById(R.id.editTextText);
        buttonDodajNotatke = findViewById(R.id.button);

        arrayListNotatki.add("Zakupy: chleb, masło, ser");
        arrayListNotatki.add("Do zrobienia: obiad, umyć podłogi");
        arrayListNotatki.add("Weekend: kino, spacer z psem");

        arrayAdapterNotatki = new ArrayAdapter<>(MainActivity.this,
                android.R.layout.simple_list_item_1,
                arrayListNotatki);
        listViewNotatki.setAdapter(arrayAdapterNotatki);

        buttonDodajNotatke.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        String stringNotatka = editTextNowaNotatka.getText().toString();
                        arrayListNotatki.add(stringNotatka);
                        arrayAdapterNotatki.notifyDataSetChanged();
                        editTextNowaNotatka.setText("");
                    }
                }
        );






    }
}
package com.example.sprawdzian;

import android.graphics.Paint;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    EditText editTextNazwaPrzepisu, editTextSkladniki;
    CheckBox checkBoxCzyGotowac;
    EditText editTextLiczbaGosci;
    Button buttonDodaj;
    ListView listViewPrzepisy;
    ArrayList<Przepisy> arrayListPrzepisy = new ArrayList<>();
    ArrayAdapter<Przepisy> arrayAdapterPrzepisy;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        editTextNazwaPrzepisu = findViewById(R.id.editTextText);
        editTextSkladniki = findViewById(R.id.editTextText2);
        checkBoxCzyGotowac = findViewById(R.id.checkBox);
        editTextLiczbaGosci = findViewById(R.id.editTextNumber);
        buttonDodaj = findViewById(R.id.button);
        listViewPrzepisy = findViewById(R.id.listView);

        arrayAdapterPrzepisy = new ArrayAdapter<>(MainActivity.this,
                android.R.layout.simple_list_item_1, arrayListPrzepisy);
        listViewPrzepisy.setAdapter(arrayAdapterPrzepisy);

        Przepisy przepisy = new Przepisy("Frytki", "Ziemniaki, sól", true, 4);
        przepisy.toString();
        Przepisy przepisy2 = new Przepisy("Rosół", "kurczak, marchewka, kosta rosolowa", true, 6);
        Przepisy przepisy3 = new Przepisy("sałatka grecka", "sałata, ser feta", false, 1);
        arrayListPrzepisy.add(przepisy);
        arrayListPrzepisy.add(przepisy2);
        arrayListPrzepisy.add(przepisy3);
        arrayAdapterPrzepisy.notifyDataSetChanged();

        buttonDodaj.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nazwaPrzepisu = editTextNazwaPrzepisu.getText().toString();
                String skladniki = editTextSkladniki.getText().toString();
                boolean czyGotowac = false;
                int liczbaGosci = Integer.parseInt(editTextLiczbaGosci.getText().toString());
                if(checkBoxCzyGotowac.isChecked()) {
                    czyGotowac = true;
                } else {
                    czyGotowac = false;
                }
                Przepisy przepisyDodaj = new Przepisy(nazwaPrzepisu, skladniki, czyGotowac, liczbaGosci);
                arrayListPrzepisy.add(przepisyDodaj);
                arrayAdapterPrzepisy.notifyDataSetChanged();
                editTextNazwaPrzepisu.setText("");
                editTextSkladniki.setText("");
                editTextLiczbaGosci.setText("");
                checkBoxCzyGotowac.setChecked(false);

            }
        });
        listViewPrzepisy.setOnItemClickListener(
                new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                        TextView textView = (TextView) view;
                        if(textView.getPaintFlags() == Paint.STRIKE_THRU_TEXT_FLAG) {
                            textView.setPaintFlags(Paint.CURSOR_AFTER);
                        } else {
                            textView.setPaintFlags(Paint.STRIKE_THRU_TEXT_FLAG);
                        }
                    }
                }
        );
        listViewPrzepisy.setOnItemLongClickListener(
                new AdapterView.OnItemLongClickListener() {
                    @Override
                    public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                        arrayListPrzepisy.remove(i);
                        arrayAdapterPrzepisy.notifyDataSetChanged();
                        return false;
                    }
                }
        );




    }
}
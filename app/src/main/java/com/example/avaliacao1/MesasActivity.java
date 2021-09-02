package com.example.avaliacao1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.avaliacao1.utils.Shared;

public class MesasActivity extends AppCompatActivity {

    Table tablesArray[] = new Table[9];
    private EditText tableNumberEditText;
    private Button freeTableButton;
    private Button saveOperationButton;
    private Button reserveAllButton;
    private Button settingsButton;
    private Shared shared = new Shared(MesasActivity.this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mesas_restaurante);

        tableNumberEditText = findViewById(R.id.editLiberar);
        freeTableButton = findViewById(R.id.btnLiberar);
        saveOperationButton = findViewById(R.id.btnSalvar);
        reserveAllButton = findViewById(R.id.btnReservarTudo);
//        settingsButton = findViewById(R.id.settingsButton);

        tablesArray[0] = new Table(findViewById(R.id.mesa1), findViewById(R.id.btnReservar1), shared.getBoolean("table0"));
        tablesArray[1] = new Table(findViewById(R.id.mesa2), findViewById(R.id.btnReservar2), shared.getBoolean("table1"));
        tablesArray[2] = new Table(findViewById(R.id.mesa3), findViewById(R.id.btnReservar3), shared.getBoolean("table2"));
        tablesArray[3] = new Table(findViewById(R.id.mesa4), findViewById(R.id.btnReservar4), shared.getBoolean("table3"));
        tablesArray[4] = new Table(findViewById(R.id.mesa5), findViewById(R.id.btnReservar5), shared.getBoolean("table4"));
        tablesArray[5] = new Table(findViewById(R.id.mesa6), findViewById(R.id.btnReservar6), shared.getBoolean("table5"));
        tablesArray[6] = new Table(findViewById(R.id.mesa7), findViewById(R.id.btnReservar7), shared.getBoolean("table6"));
        tablesArray[7] = new Table(findViewById(R.id.mesa8), findViewById(R.id.btnReservar8), shared.getBoolean("table7"));
        tablesArray[8] = new Table(findViewById(R.id.mesa9), findViewById(R.id.btnReservar9), shared.getBoolean("table8"));

        freeTableButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    final int tableNumber = Integer.parseInt(tableNumberEditText.getText().toString());

                    if (!tablesArray[tableNumber - 1].isReserved()) {
                        Toast.makeText(MesasActivity.this, getString(R.string.mesaJáLiberada).replace("{numeroDaMesa}", String.valueOf(tableNumber)), Toast.LENGTH_LONG).show();
                        return;
                    }

                    tablesArray[tableNumber - 1].setReserved(false);
                } catch (Exception e) {
                    Toast.makeText(MesasActivity.this, getString(R.string.mesaInexistente), Toast.LENGTH_LONG).show();
                }
            }
        });

        saveOperationButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                for (int i = 0; i < tablesArray.length; i++) {
                    shared.put("table" + String.valueOf(i), tablesArray[i].isReserved());
                }
            }
        });

        reserveAllButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean wasFree = false;

                for (int i = 0; i < tablesArray.length; i++) {
                    if (!wasFree) {
                        wasFree = !tablesArray[i].isReserved();
                    }

                    tablesArray[i].setReserved(true);
                }

                if (!wasFree) {
                    Toast.makeText(MesasActivity.this, getString(R.string.mesaOcupada), Toast.LENGTH_LONG).show();
                }
            }
        });

//        settingsButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                startActivity(new Intent(TablesActivity.this, SettingsActivity.class));
//            }
//        });
    }
}

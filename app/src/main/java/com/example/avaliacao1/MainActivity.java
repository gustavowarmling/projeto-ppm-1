package com.example.avaliacao1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText usernameEdit;
    private EditText passwordEdit;
    private Button loginButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        usernameEdit = findViewById(R.id.editarUsuario);
        passwordEdit = findViewById(R.id.editarSenha);
        loginButton = findViewById(R.id.botaoLogar);

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final String usernameString = usernameEdit.getText().toString();
                final String passwordString = passwordEdit.getText().toString();

                if (usernameString.isEmpty()) {
                    Toast.makeText(MainActivity.this, getString(R.string.usuarioFaltante), Toast.LENGTH_LONG).show();
                    return;
                }

                if (passwordString.isEmpty()) {
                    Toast.makeText(MainActivity.this, getString(R.string.senhaFaltante), Toast.LENGTH_LONG).show();
                    return;
                }

                if (
                        (usernameString.equals("Administrador") && passwordString.equals("Administrador")) ||
                        (usernameString.equals("Adm") && passwordString.equals("Adm123")) ||
                        (usernameString.equals("Administrator") && passwordString.equals("Que3B1eng4ElT0r0")) ||
                        (usernameString.equals("Root") && passwordString.equals("pr0m1uscu0"))
                ) {
                    startActivity(new Intent(MainActivity.this, MesasActivity.class));
                    return;
                }

                Toast.makeText(MainActivity.this, getString(R.string.loginErrado), Toast.LENGTH_LONG).show();
            }
        });
    }
}

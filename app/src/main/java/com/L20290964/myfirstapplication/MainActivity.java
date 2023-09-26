package com.L20290964.myfirstapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.L20290964.myfirstapplication.usuario.DashboardUsuario;
import com.L20290964.myfirstapplication.usuario.repository.UsuarioRepository;

import java.util.HashMap;

public class MainActivity extends AppCompatActivity {
    private UsuarioRepository ur;

    private HashMap<String, String> registredUsers = new HashMap<String, String>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ur = UsuarioRepository.getInstance();

        //registredUsers.put("Estanislao", "Ensamblador");
        //registredUsers.put("Alondra", "Medicina");

    }
    private AlertDialog createAlertDialog(String title, String message) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);


        //Los tipos de datos mutables, al acceder permiten modificar sus valores,
        //mientras que los inmutables no modifican el principal (String es inmutable)

        //Invocaciones de metodo anidados
        builder.setTitle(title)
                .setMessage(message);
        return builder.create();
    }
    public void onBtnIngresarTap(View view) {
         //Lo comentado hace lo mismo del metodo de arriba
        //AlertDialog.Builder builder = new AlertDialog.Builder(this);

        //AlertDialog dialog = builder.create();

        EditText etUsuario = findViewById(R.id.etUsuario);
        EditText etPass = findViewById(R.id.etPass);

        String user, pass;
        user = etUsuario.getText().toString();
        pass = etPass.getText().toString();

        if (ur.getRegisteredUsers().containsKey(user) == false) {
            //dialog.setTitle("Atencion");
            //dialog.setMessage("Usuario no registrado");
            //dialog.show();
            this.createAlertDialog("Atencion", "usuario no registrado").show();
            return;
        }

        if (!ur.getRegisteredUsers().get(user).containsKey(pass)) {
            //dialog.setTitle("Atencion");
            //dialog.setMessage("contraseña no coincide");
            //dialog.show();
            this.createAlertDialog("Atencion", "La contraseña no coincide").show();
            return;
        }
            //user = user.toUpperCase();
            //dialog.setTitle("Felicidades presionaste el boton");
            //dialog.setMessage(String.format("Datos ingresados:\nUsuario: %s\nPassword: %s",user,pass));
            //dialog.show();

            //Tostada
            String message = "Felicidades ha iniciado sesion con exito";
            Toast.makeText(this, message, Toast.LENGTH_LONG).show();

            //Sirve para elefir cual sera la siguiente pantalla que mostrara despues de que se cumpa lo anterior
            Intent i = new Intent(this, DashboardUsuario.class);
            i.putExtra("Usuario", user);
            i.putExtra("contraseña", pass);
            //Inicia la siguiente pantalla
            startActivity(i);

    }
}
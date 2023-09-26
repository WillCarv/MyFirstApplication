package com.L20290964.myfirstapplication.usuario;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.L20290964.myfirstapplication.R;
import com.L20290964.myfirstapplication.usuario.model.Usuario;
import com.L20290964.myfirstapplication.usuario.repository.UsuarioRepository;

public class DashboardUsuario extends AppCompatActivity {
    private UsuarioRepository ur;
    private Usuario userInfo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard_usuario);

        //Aqui creamos la instancia del usuario repository
        ur = UsuarioRepository.getInstance();

        //Esta es la manera en que recibimos informacion de otro activity
        String usuario = getIntent().getStringExtra("Usuario");
        String pass = getIntent().getStringExtra("contraseña");

        //Obtenemos informacion del usuario loqueado
        userInfo = ur.getRegisteredUsers().get(usuario).get(pass);


        //Tomamos la informacion que se dio de cada usuario y la
        //pasamos a los TextView de la segunda ventana

        //Usuario
        TextView tvUs  = findViewById(R.id.tvUsu);
        tvUs.setText(userInfo.getUsuario());

        //Contraseña
        TextView tvPas = findViewById(R.id.tvPa);
        tvPas.setText(userInfo.getPass());

        //Apodo
        TextView tvAp = findViewById(R.id.tvApo);
        tvAp.setText(userInfo.getNombre());

        //Edad
        TextView tvE = findViewById(R.id.tvEd);
        tvE.setText(userInfo.getEdad());

        //Email
        TextView tvEm = findViewById(R.id.tvEma);
        tvEm.setText(userInfo.getEmail());


    }
}
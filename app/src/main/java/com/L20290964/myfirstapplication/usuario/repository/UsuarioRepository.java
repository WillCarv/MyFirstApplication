package com.L20290964.myfirstapplication.usuario.repository;

import com.L20290964.myfirstapplication.usuario.model.Usuario;

import java.util.HashMap;

public class UsuarioRepository {
    private static UsuarioRepository repository = null;
    private HashMap<String, HashMap<String, Usuario>> registeredUsers;

    private UsuarioRepository(){
        Usuario u1 = new Usuario("Alondra", "Medicina", "Yedith", 21, "yereli16@hotmail.com");
        Usuario u2 = new Usuario("Sergio", "Ensamblador", "Check", 27, "check@hotmail.com");
        Usuario u3 = new Usuario("Nat", "Queso", "Nati", 30, "Nat@hotmail.com");

        this.registeredUsers = new HashMap<String, HashMap<String, Usuario>>();

        registeredUsers.put(u1.getUsuario(), new HashMap<String, Usuario>());
        registeredUsers.get(u1.getUsuario()).put(u1.getPass(), u1);
        registeredUsers.put(u2.getUsuario(), new HashMap<String, Usuario>());
        registeredUsers.get(u2.getUsuario()).put(u2.getPass(), u2);
        registeredUsers.put(u3.getUsuario(), new HashMap<String, Usuario>());
        registeredUsers.get(u3.getUsuario()).put(u3.getPass(), u3);

    }

    public static UsuarioRepository getInstance() {
        if (repository == null) {
            repository = new UsuarioRepository();

        }
        return repository;
    }

    public HashMap<String, HashMap<String, Usuario>>getRegisteredUsers(){

        return registeredUsers;
    }

}
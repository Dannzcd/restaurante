package com.restaurante.data.verifiers;

import com.restaurante.data.entities.Usuario;

public class UsuarioVerifier {
    public static boolean is_null(Usuario usuario){
        return usuario == null;
    }

    public static boolean has_null_fields(Usuario usuario){
        return (usuario.getEmail() == null ||
            usuario.getNome() == null) || (usuario.getSenha() == null);
    }
}

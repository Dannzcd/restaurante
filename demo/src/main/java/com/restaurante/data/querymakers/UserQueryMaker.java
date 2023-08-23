package com.restaurante.data.querymakers;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.postgresql.ds.PGSimpleDataSource;

import com.restaurante.data.entities.Usuario;
import com.restaurante.exceptions.ApiRequestException;

public class UserQueryMaker {
    private String url;
    private Connection connexaoBD;

    public void generateUser(Usuario usuario) throws SQLException{
        String previousQuery = "SELECT cadastrarUsuario(?, ?, ?)"; 

        PreparedStatement statement = this.connexaoBD.prepareStatement(previousQuery);
        if (verifyUserExists(usuario)){
            throw new SQLException("Endereço e-mail já utilizado!");
        }

        statement.setString(1, usuario.getEmail());
        statement.setString(2, usuario.getNome());
        statement.setString(3, usuario.getSenha());

        statement.executeQuery();
    }

    public DataSource getDataSource() throws SQLException{
        PGSimpleDataSource fonteDados = new PGSimpleDataSource();
        fonteDados.setUrl(this.url);
        return fonteDados;
    }

    public UserQueryMaker(String url){
        this.url = url;
        try {
            this.connexaoBD = getDataSource().getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Usuario> getAllUsersQuery() throws SQLException{
        List<Usuario> usuarios = new ArrayList<Usuario>();
        String query = "SELECT * FROM usuario";
        PreparedStatement statement = this.connexaoBD.prepareStatement(query);
        ResultSet resultado = statement.executeQuery();

        while(resultado.next()){
            usuarios.add(
                new Usuario(
                    resultado.getString("email"), 
                    resultado.getString("nome"), 
                    resultado.getString("senha"), 
                    resultado.getString("senha")
                )
            );
        }

        return usuarios;
    }

    public boolean verifyUserExists(Usuario usuario) throws SQLException{
        String InitialQuery = "SELECT FROM usuario WHERE usuario.email = ? AND usuario.senha = ?";
        PreparedStatement statement = this.connexaoBD.prepareStatement(InitialQuery);

        statement.setString(1, usuario.getEmail());
        statement.setString(2, usuario.getSenha());
        statement.execute();

        ResultSet resultado = statement.getResultSet();

        return resultado.next();
    }

    //UNSAFE METHOD
    public Usuario getUsuario(String email){
        Usuario usuario = null;

        try {
            String query = "SELECT * FROM usuario WHERE usuario.email = " + email;
            PreparedStatement statement = this.connexaoBD.prepareStatement(query);
            ResultSet resultado = statement.executeQuery();
            usuario = new Usuario(
                resultado.getString("email"),
                resultado.getString("nome"),
                resultado.getString("senha"),
                resultado.getString("senha")
            );
            
        } catch (ApiRequestException e) {
            System.out.println(e.getMessage());
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        
        return usuario;
    }

    public void deleteSpecificUsuario(String email){
        try {
            String initialQuery = "SELECT removerUsuario(?)";
            PreparedStatement statement = this.connexaoBD.prepareStatement(initialQuery);
            statement.setString(1, email);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}

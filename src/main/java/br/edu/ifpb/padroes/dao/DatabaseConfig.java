package br.edu.ifpb.padroes.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConfig {
    private final String arquivoBanco;

    public DatabaseConfig(String arquivoBanco) {
        this.arquivoBanco = arquivoBanco;
    }

    Connection openConnection() throws SQLException {
        return DriverManager.getConnection("jdbc:sqlite:"+arquivoBanco);
    }
}

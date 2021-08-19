package modelos;

import java.sql.*;

public class DataBase {
    private String url;
    private String driver;
    private Connection conexion;
    
    public DataBase(){
        this.driver = "jdbc:sqlite";
        this.url = "datos.db";
    }
    
    protected void conectar() throws SQLException{
        this.conexion = DriverManager.getConnection(this.driver+":"+this.url);
        if (!this.conexion.isClosed())
            System.out.println("Conectado");
    }
    
    protected void cerrar() throws SQLException {
        if (!this.conexion.isClosed())
            this.conexion.close();
    }

    protected Connection getConexion() {
        return conexion;
    }
}

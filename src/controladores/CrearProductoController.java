package controladores;

import java.sql.*;
import javax.swing.table.DefaultTableModel;
import modelos.DataManager;

public class CrearProductoController {
    
    public void crearProducto(String... datos) throws SQLException{
        DataManager manejador = new DataManager();
        String sql = String.format("INSERT INTO productos("
                + "codigo, nombre, precio_compra, precio_venta, cantidad_bodega, minima_requerida, maxima_permitida"
                + ") VALUES('%s', '%s', %s, %s, %s, %s, %s)", datos);
        manejador.ejecutarConsulta(sql);
    }
    
    public DefaultTableModel cargarProductos() throws SQLException {
        String [] columnas = {
            "Cod. Producto",
            "Nombre", 
            "$ Compra",
            "$ Venta",
            "Cant. en Bodega",
            "Cant. Min. Requerida",
            "Cant. Máx. Permitida"
        };
        DefaultTableModel modelo = new DefaultTableModel(null, columnas);
        DataManager manejador = new DataManager();
        ResultSet datos = manejador.obtenerDatos("SELECT * FROM productos");
        String[] registro = new String[7];
        while(datos.next()){
            registro[0] = datos.getString("codigo");
            registro[1] = datos.getString("nombre");
            registro[2] = String.valueOf(datos.getDouble("precio_compra"));
            registro[3] = String.valueOf(datos.getDouble("precio_venta"));
            registro[4] = String.valueOf(datos.getInt("cantidad_bodega"));
            registro[5] = String.valueOf(datos.getInt("minima_requerida"));
            registro[6] = String.valueOf(datos.getInt("maxima_permitida"));
            modelo.addRow(registro);
        }
        manejador.cerrar();
        return modelo;
    }
}

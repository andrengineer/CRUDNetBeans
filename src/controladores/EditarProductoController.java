package controladores;

import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.table.DefaultTableModel;
import modelos.DataManager;

public class EditarProductoController {
    
    public DefaultTableModel cargarProductos() throws SQLException {
        String [] columnas = {
            "Id",
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
        String[] registro = new String[8];
        while(datos.next()){
            registro[0] = String.valueOf(datos.getInt("id"));
            registro[1] = datos.getString("codigo");
            registro[2] = datos.getString("nombre");
            registro[3] = String.valueOf(datos.getDouble("precio_compra"));
            registro[4] = String.valueOf(datos.getDouble("precio_venta"));
            registro[5] = String.valueOf(datos.getInt("cantidad_bodega"));
            registro[6] = String.valueOf(datos.getInt("minima_requerida"));
            registro[7] = String.valueOf(datos.getInt("maxima_permitida"));
            modelo.addRow(registro);
        }
        manejador.cerrar();
        return modelo;
    }
    
    public void actualizarProducto(int id, String... datos) throws SQLException{
        DataManager manejador = new DataManager();
        String sql = "UPDATE productos SET "
                + "codigo='"+datos[0]+"', "
                + "nombre='"+datos[1]+"', "
                + "precio_compra="+datos[2]+", "
                + "precio_venta="+datos[3]+", "
                + "cantidad_bodega="+datos[4]+", "
                + "minima_requerida="+datos[5]+", "
                + "maxima_permitida="+datos[6]+""
                + " WHERE id="+id;
        manejador.ejecutarConsulta(sql);
    }
    
    public void eliminarProducto(int id) throws SQLException{
        DataManager manejador = new DataManager();
        String sql = "DELETE FROM productos WHERE id="+id;
        manejador.ejecutarConsulta(sql);
    }
}

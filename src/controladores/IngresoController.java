package controladores;

import java.sql.SQLException;
import java.util.*;
import modelos.DataManager;

public class IngresoController {
    
    private boolean valido;

    public boolean isValido() {
        return valido;
    }
    
    public boolean validarUsuario(String usuario, String clave) throws SQLException{
        DataManager manejador = new DataManager();
        List<Object> lista = new ArrayList<>();
        lista = manejador.resultado(String.format("SELECT * FROM usuarios WHERE usuario='%s' AND clave='%s'", usuario, clave));
        if (lista.size()>0)
            this.valido = true;
        return this.valido;
    }
    
}

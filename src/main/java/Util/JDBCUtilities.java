package Util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCUtilities {
    
    private static final String DATABASE_LOCATION = "C:\\Users\\PREDATOR\\OneDrive - Universidad del Magdalena\\Mision TIC 2022\\Ciclo 2\\Programacion basica\\Unidad 3\\ProyectosConstruccion.db";

    public static Connection getConnection() throws SQLException {
        String url = "jdbc:sqlite:"+DATABASE_LOCATION;

        return DriverManager.getConnection(url);
    }
}

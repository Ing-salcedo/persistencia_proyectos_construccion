package Vista;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import Controlador.ElControladorDeRequerimientos;

import java.awt.BorderLayout;
import Modelo.vo.Requerimiento_3;

public class Requerimiento3 extends JFrame{
    public Requerimiento3() throws SQLException{
        initUI();
    }

    private void initUI() throws SQLException{
        setTitle("Requerimiento 3");
        setLayout(new BorderLayout());
        String[] nombres = {"Proveedor","Pagado","Constructora"};
        JTable tabla = new JTable(mostrar(),nombres);
        JScrollPane panel = new JScrollPane(tabla);
        add(panel, BorderLayout.CENTER);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setSize(400, 150);
        setLocationRelativeTo(null);
        setVisible(true);
    }
    public String[][] mostrar() throws SQLException{
        ElControladorDeRequerimientos controlador = new ElControladorDeRequerimientos();
        ArrayList<Requerimiento_3> lista1 = new ArrayList<Requerimiento_3>();
        lista1 = controlador.consultarRequerimiento3();
        String matriz[][] = new String [lista1.size()][3];
        for(int i=0; i < lista1.size(); i++){
            matriz[i][0]=lista1.get(i).getProveedor();
            matriz[i][1]=lista1.get(i).getPagado();
            matriz[i][2]=lista1.get(i).getConstructora();
        }
        return matriz;
    }

}

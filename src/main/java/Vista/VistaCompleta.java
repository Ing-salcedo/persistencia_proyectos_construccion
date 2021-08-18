package Vista;

import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JOptionPane;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import Controlador.ElControladorDeRequerimientos;
import Modelo.vo.Requerimiento_1;
import Modelo.vo.Requerimiento_2;
import Modelo.vo.Requerimiento_3;

public class VistaCompleta{
    JScrollPane Panel = new JScrollPane();
    JTable tabla1, tabla2, tabla3 = new JTable();

    public VistaCompleta() throws SQLException{
        initUI();
    }

    private void initUI() throws SQLException{
        // Creo el Frame que contendra todos los componentes de la IU
        JFrame frame= new JFrame();
        JPanel panelbtns = new JPanel();

        frame.setTitle("Reto 5 - Grupo 34");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setSize(900, 700);
        frame.setLocationRelativeTo(null);
        
        panelbtns.setLayout(new FlowLayout(FlowLayout.CENTER));
        JLabel label1 = new JLabel("        ");
        JLabel label2 = new JLabel("        ");
        JLabel label3 = new JLabel("        ");
        JButton btnCons1 = new JButton("Consulta 1");
        JButton btnCons2 = new JButton("Consulta 2");
        JButton btnCons3 = new JButton("Consulta 3");
        JButton btnCreditos = new JButton("Creditos");

        //Agregamos los botones y etiquetas al panel
        panelbtns.add(btnCons1);
        panelbtns.add(label1);
        panelbtns.add(btnCons2);
        panelbtns.add(label2);
        panelbtns.add(btnCons3);
        panelbtns.add(label3);
        panelbtns.add(btnCreditos);

        // Creo las tablas que contendran las consultas y agrego sus respectivas etiquetas de columnas
        String[] EtiqTab1 = {"Ciudad","Acabados","Clasificacion","Banco_Vinculado","Constructora"};
        tabla1 = new JTable(consulta1(),EtiqTab1);

        String[] EtiqTab2 = {"Nombre","Primer_Apellido","Ciudad_Residencia","Cargo","Salario"};
        tabla2 = new JTable(consulta2(),EtiqTab2);

        String[] EtiqTab3 = {"Proveedor","Pagado","Constructora"};
        tabla3 = new JTable(consulta3(),EtiqTab3);


        frame.getContentPane().add(BorderLayout.SOUTH, panelbtns);
        frame.getContentPane().add(BorderLayout.CENTER, Panel);
        frame.setVisible(true);
        
        //Elaboro los eventos y se los asigno a los botones
        ActionListener actcons1 = new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                Panel.add(tabla1);
                Panel.setViewportView(tabla1);
            }
        };
        btnCons1.addActionListener(actcons1);

        ActionListener actcons2 = new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                Panel.add(tabla2);
                Panel.setViewportView(tabla2);
            }
        };
        btnCons2.addActionListener(actcons2);

        ActionListener actcons3 = new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                Panel.add(tabla3);
                Panel.setViewportView(tabla3);
            }
        };
        btnCons3.addActionListener(actcons3);


        ActionListener actCred = new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null,"Elaborado por: \n\nGerardo Salcedo Pereira \nGrupo 34","Creditos",JOptionPane.INFORMATION_MESSAGE);
            }
        };
        btnCreditos.addActionListener(actCred);
    }


    // Metodo para realizar la consulta 1
    public String[][] consulta1() throws SQLException{
        ElControladorDeRequerimientos controlador = new ElControladorDeRequerimientos();
        ArrayList<Requerimiento_1> lista1 = new ArrayList<Requerimiento_1>();
        lista1 = controlador.consultarRequerimiento1();
        String matriz[][] = new String [lista1.size()][5];
        for(int i=0; i < lista1.size(); i++){
            matriz[i][0]=String.valueOf(lista1.get(i).getCiudad());
            matriz[i][1]=lista1.get(i).getAcabados();
            matriz[i][2]=lista1.get(i).getClasificacion();
            matriz[i][3]=lista1.get(i).getBanco_Vinculado();
            matriz[i][4]=lista1.get(i).getConstructora();
        }return matriz;
    }

    // Metodo para realizar la consulta 2
    public String[][] consulta2() throws SQLException{
        ElControladorDeRequerimientos controlador = new ElControladorDeRequerimientos();
        ArrayList<Requerimiento_2> lista1 = new ArrayList<Requerimiento_2>();
        lista1 = controlador.consultarRequerimiento2();
        String matriz[][] = new String [lista1.size()][5];
        for(int i=0; i < lista1.size(); i++){
            matriz[i][0]=lista1.get(i).getNombre();
            matriz[i][1]=lista1.get(i).getPrimer_Apellido();
            matriz[i][2]=lista1.get(i).getCiudad_Residencia();
            matriz[i][3]=lista1.get(i).getCargo();
            matriz[i][4]=lista1.get(i).getSalario();
        }return matriz;
    }

    // Metodo para realizar la consulta 3
    public String[][] consulta3() throws SQLException{
        ElControladorDeRequerimientos controlador = new ElControladorDeRequerimientos();
        ArrayList<Requerimiento_3> lista1 = new ArrayList<Requerimiento_3>();
        lista1 = controlador.consultarRequerimiento3();
        String matriz[][] = new String [lista1.size()][3];
        for(int i=0; i < lista1.size(); i++){
            matriz[i][0]=lista1.get(i).getProveedor();
            matriz[i][1]=lista1.get(i).getPagado();
            matriz[i][2]=lista1.get(i).getConstructora();
        }return matriz;
    }
}

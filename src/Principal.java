import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class Principal {
    Statement st;
    PreparedStatement ps;
    public JPanel panelPrincipal;
    private JButton buscarButton;
    private JButton actualizarButton;
    private JFormattedTextField ftF_cedula;
    private JTextField tF_Nombre;
    private JTextField tF_Apellido;
    private JFormattedTextField ftF_telefono;
    private JFormattedTextField ftF_edad;
    private JTextField tF_email;

    public Principal() {
        buscarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                /*
                if (tF_Nombre.getText() != " "
                        || tF_Apellido.getText() != " "
                        || tF_email.getText() != " "
                        || ftF_edad.getText() != " "
                        || ftF_telefono.getText() != " ")
                    JOptionPane.showMessageDialog(null, "Ingrese unicamente la cedula");
                else
                {
                    Connection conexion;
                    try
                    {
                        conexion = getConection();
                        ResultSet resultado;
                        resultado = st.executeQuery("SELECT * FROM base_actualizable" +
                                "WHERE Cedula_Dt = " + ftF_cedula.getText());
                        tF_Nombre.setText(resultado.getString("Cedula_Dt"));
                    } catch (SQLException ex) {
                        throw new RuntimeException(ex);
                    }
                }

                 */
                Connection conexion;
                try
                {
                    conexion = getConection();
                    st = conexion.createStatement();
                    ResultSet rs; //rs.estandar
                    rs = st.executeQuery("SELECT * FROM base_actualizable.datos " +
                            "WHERE Cedula_Dt = " + ftF_cedula.getText() + ";");
                    while (rs.next())
                    {
                        tF_Nombre.setText(rs.getString("Nombre_Dt"));
                        tF_Apellido.setText(rs.getString("Apellido_Dt"));
                        ftF_telefono.setText(rs.getString("Telefono_Dt"));
                        tF_email.setText(rs.getString("Correo_Dt"));
                        ftF_edad.setText(rs.getString("Edad_Dt"));
                    }
                    conexion.close();
                    tF_Nombre.setEditable(true);
                    tF_Apellido.setEditable(true);
                    ftF_telefono.setEditable(true);
                    tF_email.setEditable(true);
                    ftF_edad.setEditable(true);
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });
        actualizarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Connection con;
                try
                {
                    con = getConection();
                    ps = con.prepareStatement("UPDATE `base_actualizable`.`datos` SET " +
                            "`Nombre_Dt` = ?" +
                            ", `Apellido_Dt` = ?" +
                            ", `Telefono_Dt` = ?" +
                            ", `Correo_Dt` = ?" +
                            ", `Edad_Dt`= ?" +
                            " WHERE (`Cedula_Dt` =" + ftF_cedula.getText() + ");");
                    ps.setString(1, tF_Nombre.getText());
                    ps.setString(2, tF_Apellido.getText());
                    ps.setString(3, ftF_telefono.getText());
                    ps.setString(4, tF_email.getText());
                    ps.setString(5, ftF_edad.getText());
                    System.out.println(ps);
                    int res = ps.executeUpdate();

                    if (res > 0)
                        JOptionPane.showMessageDialog(null, "Se Guardo correctamente!!", "Bien hecho", JOptionPane.INFORMATION_MESSAGE);
                    else
                        JOptionPane.showMessageDialog(null, "ERROR!!!", "ERROR", JOptionPane.ERROR_MESSAGE);

                    con.close();
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });
    }

    public static Connection getConection()
    {
        Connection conexion = null;
        String dataBase_name = "base_actualizable";
        String url = "jdbc:mysql://localhost/";
        String user = "root";
        String password = "esfot123";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conexion = DriverManager.getConnection(url,user,password);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return conexion;
    }

}

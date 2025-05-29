
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author Adm
 */
public class conectaDAO {

    Connection conn = null;

    public Connection getConn() {
        return conn;
    }
    
    public Connection connectDB() {
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost/uc11", "root", "Adryano_2205");
            System.out.println("Sucesso ao conectar com o BD");
        } catch (SQLException erro) {
            System.out.println("Erro ConectaDAO" + erro.getMessage());
        }
        return conn;
    }

    public void disconnectDB() {
        try {
            if (conn != null & !conn.isClosed()) {
                conn.close();
                System.out.println("Desconecto com sucess");
            }
        } catch (SQLException se) {
            System.out.println("Problema ao desconectar o banco: " + se);
        }
    }
}

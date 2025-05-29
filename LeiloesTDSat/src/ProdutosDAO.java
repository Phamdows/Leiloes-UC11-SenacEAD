/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Adm
 */
import java.sql.PreparedStatement;
import java.sql.Connection;
import javax.swing.JOptionPane;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ProdutosDAO {

    ArrayList<ProdutosDTO> listagem = new ArrayList<>();

    public static boolean cadastrarProduto(ProdutosDTO produto) {
        conectaDAO conn = new conectaDAO();
        conn.connectDB();

        //Variaveis do Produto
        String nome = produto.getNome();
        int valor = produto.getValor();
        String status = produto.getStatus();

        //Comandos SQL
        String sql = "INSERT INTO produtos (nome, valor, status) VALUES (?, ? ,?);";
        try {
            PreparedStatement ps = conn.getConn().prepareStatement(sql);
            ps.setString(1, nome);
            ps.setString(2, String.valueOf(valor));
            ps.setString(3, status);

            ps.executeUpdate();
            conn.disconnectDB();
            return true;
        } catch (SQLException se) {
            System.out.println("Erro ao cadastrar o filme: " + se.getMessage());
            return false;
        }
    }
    public ArrayList<ProdutosDTO> listarProdutos() {
        return listagem;
    }

}

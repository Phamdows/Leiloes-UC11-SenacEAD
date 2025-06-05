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
            System.out.println("Erro ao cadastrar o produto: " + se.getMessage());
            return false;
        }
    }

    public static boolean venderProduto(int id) {
        conectaDAO conn = new conectaDAO();
        conn.connectDB();

        //String SQL
        String sql = "UPDATE produtos SET status = \"Vendido\" WHERE id = ?;";

        try {
            PreparedStatement ps = conn.getConn().prepareStatement(sql);
            ps.setString(1, String.valueOf(id));

            ps.executeUpdate();
            conn.disconnectDB();
            return true;
        } catch (SQLException se) {
            System.out.println("Erro ao vender produto: " + se);
            return false;
        }
    }

    public static ArrayList<ProdutosDTO> listarProdutos() {
        ArrayList<ProdutosDTO> lista = new ArrayList<>();

        try {
            //Conexão com o banco de dados
            conectaDAO conn = new conectaDAO();
            conn.connectDB();

            //Query SQL
            String sql = "SELECT * FROM produtos;";

            PreparedStatement ps = conn.connectDB().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                ProdutosDTO p = new ProdutosDTO();

                p.setId(rs.getInt("id"));
                p.setNome(rs.getString("Nome"));
                p.setValor(rs.getInt("Valor"));
                p.setStatus(rs.getString("Status"));

                lista.add(p);
            }
            conn.disconnectDB();
        } catch (SQLException se) {
            System.out.println("Erro ao listar produtos: " + se);
        }
        return lista;
    }

    public static ArrayList<ProdutosDTO> listarProdutosVendidos() {
        ArrayList<ProdutosDTO> lista = new ArrayList<>();

        try {
            //Conexão com o banco de dados
            conectaDAO conn = new conectaDAO();
            conn.connectDB();

            //Query SQL
            String sql = "SELECT * FROM produtos WHERE status = \"Vendido\";";

            PreparedStatement ps = conn.connectDB().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                ProdutosDTO p = new ProdutosDTO();

                p.setId(rs.getInt("id"));
                p.setNome(rs.getString("Nome"));
                p.setValor(rs.getInt("Valor"));
                p.setStatus(rs.getString("Status"));

                lista.add(p);
            }
            conn.disconnectDB();
        } catch (SQLException se) {
            System.out.println("Erro ao listar produtos: " + se);
        }
        return lista;
    }

}

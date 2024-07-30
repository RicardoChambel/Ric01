package ric1;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Database {

    private static final String url = "jdbc:mysql://localhost:3306/funcionariosdb";
    private static final String username = "root";
    private static final String password = "rootroot";

    public static void addFuncionario(String sexo, String nome, String idade, String cidade, String cargo) {
        String query = "INSERT INTO funcionarios (sexo, nome, idade, cidade, cargo) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = DriverManager.getConnection(url, username, password);
             PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setString(1, sexo);
            pstmt.setString(2, nome);
            pstmt.setInt(3, Integer.parseInt(idade));
            pstmt.setString(4, cidade);
            pstmt.setString(5, cargo);
            pstmt.executeUpdate();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }


    public static List<Funcionario> getFuncionarios() {
        List<Funcionario> funcionarios = new ArrayList<>();
        String query = "SELECT sexo, nome, idade, cidade, cargo FROM funcionarios";
        try (Connection conn = DriverManager.getConnection(url, username, password);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            while (rs.next()) {
                String sexo = rs.getString("sexo");
                String nome = rs.getString("nome");
                int idade = rs.getInt("idade");
                String cidade = rs.getString("cidade");
                String cargo = rs.getString("cargo");
                funcionarios.add(new Funcionario(sexo, nome, idade, cidade, cargo));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return funcionarios;
    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package exemplo04java;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author shkna
 */
public class Aluno {
   
   private Connection conn;
   public Aluno() {
         // Conectar ao banco de dados
        conectarBD();


    }
   private void conectarBD() {
        try {
            String url = "jdbc:mysql://34.139.193.0/projeto";
            String usuario = "root";  // Substitua pelo seu usuário
            String senha = "Senac#26";        // Substitua pela sua senha

            conn = DriverManager.getConnection(url, usuario, senha);
            System.out.println("Conexao ao banco de dados estabelecida.");
     
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Erro ao conectar ao banco de dados: " + e.getMessage());
           
        }
   }
   
   
   
   //Inseria Alunos
    public void adicionarAluno(String nome, String email, String curso) {
        
        try {
           String sql = "INSERT INTO aluno (nome, email, curso) VALUES (?, ?, ?)";
           PreparedStatement stmt = conn.prepareStatement(sql);

            stmt.setString(1, nome);
            stmt.setString(2, email);
            stmt.setString(3, curso);

            stmt.executeUpdate();
            System.out.println("Aluno adicionado com sucesso!");

        } catch (SQLException e) {
            System.err.println("Erro ao adicionar aluno: " + e.getMessage());
        }
    }
    
     public void buscarAluno(int id) {
            
        try {
           String sql = "SELECT * FROM aluno WHERE id = ?";
           PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                System.out.println(rs.getString("nome"));
                System.out.println(rs.getString("email"));
                System.out.println(rs.getString("curso"));

            } else {
                 System.out.println(rs.getString("Aluno nao encontrado"));
            }
       
        } catch (SQLException e) {
            System.err.println("Erro ao buscar aluno: " + e.getMessage());
        }
    }
     
     public void atualizarAluno(String nome, String email, String curso,int id) {
            
        try {
           String sql = "UPDATE aluno SET nome = ?, email = ?, curso = ? WHERE id = ?";
           PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, nome);
            stmt.setString(2, email);
            stmt.setString(3, curso);
            stmt.setInt(4, id);
            stmt.executeUpdate();
            System.out.println("Aluno atualizado com sucesso!");
       
        } catch (SQLException e) {
            System.err.println("Erro ao atualizar aluno: " + e.getMessage());
        }
    }
     
    public void excluirAluno(int id) {
            
        try {
          String sql = "DELETE FROM aluno WHERE id = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);
            stmt.executeUpdate();
            stmt.executeUpdate();
            System.out.println("Aluno excluido com sucesso!");
       
        } catch (SQLException e) {
            System.err.println("Erro ao excluir aluno: " + e.getMessage());
        }
    }
    
}

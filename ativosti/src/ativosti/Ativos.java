/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package ativosti;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author emmanuel.7931
 */
public class Ativos extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(Ativos.class.getName());
    
    private Connection conn;
    
    private static final String TABELA = "ativos";

    /**
     * Creates new form Ativos
     */
    public Ativos() {
        initComponents();
        
        conectarBD();
    }
    
    private void conectarBD() {
        try {
            String url = "jdbc:mysql://34.139.193.0/manuel";
            String usuario = "root";  // Substitua pelo seu usuário
            String senha = "Senac#26";        // Substitua pela sua senha

            conn = DriverManager.getConnection(url, usuario, senha);
            JOptionPane.showMessageDialog(this, "Conexão ao banco de dados estabelecida.");
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Erro ao conectar ao banco de dados: " + e.getMessage());
        }
    }
    
    private void marcarSituacao(String situacao) {
        buttonGroup1.clearSelection();
        if ("Disponível".equals(situacao)) {
            disponivel.setSelected(true);
        } else if ("Em uso".equals(situacao)) {
            emuso.setSelected(true);
        } else if ("Manutenção".equals(situacao)) {
            manutencao.setSelected(true);
        }
    }
    
    private String lerSituacao() {
        if (disponivel.isSelected()) {
            return "Disponível";
        }
        if (emuso.isSelected()) {
            return "Em uso";
        }
        if (manutencao.isSelected()) {
            return "Manutenção";
        }
        return null;
    }
    
    private void limpar() {
        patrimonio.setText("");
        nomeEquipamento.setText("");
        setor.setText("");
        ativos.setSelectedIndex(0);
        buttonGroup1.clearSelection();
        sim.setSelected(false);
        nao.setSelected(false);
    }
    
    private void listar() {
        if (conn == null) {
            return;
        }
        try {
            String sql = "SELECT * FROM " + TABELA + " ORDER BY id";
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            StringBuilder texto = new StringBuilder("<html>");
            boolean vazio = true;
            while (rs.next()) {
                vazio = false;
                texto.append(rs.getString("patrimonio")).append(" | ")
                     .append(rs.getString("nome")).append(" | ")
                     .append(rs.getString("tipo")).append(" | ")
                     .append(rs.getString("setor")).append(" | ")
                     .append(rs.getString("situacao")).append(" | Garantia: ")
                     .append(rs.getBoolean("garantia") ? "Sim" : "Não")
                     .append("<br>");
            }
            if (vazio) {
                texto.append("Nenhum ativo cadastrado.");
            }
            texto.append("</html>");
            lista.setText(texto.toString());
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Erro ao listar ativos: " + e.getMessage());
        }
    }
    
    private boolean semConexao() {
        if (conn == null) {
            JOptionPane.showMessageDialog(this, "Sem conexão com o banco de dados.");
            return true;
        }
        return false;
    }

    // true = Sim, false = Não, null = nenhuma (ou as duas) marcada
    private Boolean lerGarantia() {
        if (sim.isSelected() && !nao.isSelected()) {
            return true;
        }
        if (nao.isSelected() && !sim.isSelected()) {
            return false;
        }
        return null;
    }

    private boolean validar() {
        if (patrimonio.getText().trim().isEmpty()
                || nomeEquipamento.getText().trim().isEmpty()
                || setor.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Preencha patrimônio, nome do equipamento e setor.");
            return false;
        }
        if (lerSituacao() == null) {
            JOptionPane.showMessageDialog(this, "Escolha a situação do equipamento.");
            return false;
        }
        if (lerGarantia() == null) {
            JOptionPane.showMessageDialog(this, "Marque apenas uma opção de garantia: sim ou não.");
            return false;
        }
        return true;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        patrimonio = new javax.swing.JTextField();
        nomeEquipamento = new javax.swing.JTextField();
        setor = new javax.swing.JTextField();
        sim = new javax.swing.JCheckBox();
        nao = new javax.swing.JCheckBox();
        disponivel = new javax.swing.JRadioButton();
        emuso = new javax.swing.JRadioButton();
        manutencao = new javax.swing.JRadioButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        ativos = new javax.swing.JComboBox<>();
        salvar = new javax.swing.JButton();
        cancelar = new javax.swing.JButton();
        editar = new javax.swing.JButton();
        excluir = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        patrimonio.setColumns(12);

        nomeEquipamento.setColumns(12);

        setor.setColumns(12);

        sim.setText("sim");
        sim.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                simMouseClicked(evt);
            }
        });

        nao.setText("não");
        nao.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                naoMouseClicked(evt);
            }
        });

        buttonGroup1.add(disponivel);
        disponivel.setText("disponivel");
        disponivel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                disponivelMouseClicked(evt);
            }
        });

        buttonGroup1.add(emuso);
        emuso.setText("em uso");
        emuso.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                emusoMouseClicked(evt);
            }
        });

        buttonGroup1.add(manutencao);
        manutencao.setText("manutenção");
        manutencao.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                manutencaoMouseClicked(evt);
            }
        });

        jLabel1.setText("Possui garantia");

        jLabel2.setText("patrimonio");

        jLabel3.setText("nome equipamento");

        jLabel4.setText("setor");

        ativos.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "notebook", "desktop", "monitor", "impressora" }));

        salvar.setText("salvar");
        salvar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                salvarMouseClicked(evt);
            }
        });

        cancelar.setText("cancelar");
        cancelar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cancelarMouseClicked(evt);
            }
        });

        editar.setText("editar");
        editar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                editarMouseClicked(evt);
            }
        });

        excluir.setText("excluir");
        excluir.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                excluirMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(disponivel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(emuso)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(manutencao))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(sim)
                                .addGap(18, 18, 18)
                                .addComponent(nao))
                            .addComponent(setor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(nomeEquipamento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(patrimonio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(salvar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(cancelar))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(editar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(excluir))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(142, 142, 142)
                        .addComponent(ativos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(42, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(ativos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(patrimonio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nomeEquipamento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(setor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(disponivel)
                    .addComponent(emuso)
                    .addComponent(manutencao))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(sim)
                    .addComponent(nao)
                    .addComponent(jLabel1))
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(salvar)
                    .addComponent(cancelar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(editar)
                    .addComponent(excluir))
                .addContainerGap(19, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void simMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_simMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_simMouseClicked

    private void naoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_naoMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_naoMouseClicked

    private void salvarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_salvarMouseClicked
        // TODO add your handling code here:
        
        if (semConexao() || !validar()) {
            return;
        }
        try {
            // 6 colunas = 6 interrogações = 6 stmt.set...
            String sql = "INSERT INTO " + TABELA
                    + " (patrimonio, nome, tipo, setor, situacao, garantia) VALUES (?, ?, ?, ?, ?, ?)";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, patrimonio.getText().trim());
            stmt.setString(2, nomeEquipamento.getText().trim());
            stmt.setString(3, String.valueOf(ativos.getSelectedItem()));
            stmt.setString(4, setor.getText().trim());
            stmt.setString(5, lerSituacao());
            stmt.setBoolean(6, lerGarantia());
            stmt.executeUpdate();
            JOptionPane.showMessageDialog(this, "Equipamento cadastrado com sucesso!");
            limpar();
            listar();
        } catch (java.sql.SQLIntegrityConstraintViolationException e) {
            JOptionPane.showMessageDialog(this, "Já existe um equipamento com esse patrimônio.");
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Erro ao cadastrar equipamento: " + e.getMessage());
        }    
    }//GEN-LAST:event_salvarMouseClicked

    private void editarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_editarMouseClicked
        // TODO add your handling code here:
        if (semConexao() || !validar()) {
            return;
        }
        try {
            // 5 campos no SET + 1 no WHERE = 6 interrogações
            String sql = "UPDATE " + TABELA
                    + " SET nome = ?, tipo = ?, setor = ?, situacao = ?, garantia = ? WHERE patrimonio = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, nomeEquipamento.getText().trim());
            stmt.setString(2, String.valueOf(ativos.getSelectedItem()));
            stmt.setString(3, setor.getText().trim());
            stmt.setString(4, lerSituacao());
            stmt.setBoolean(5, lerGarantia());
            stmt.setString(6, patrimonio.getText().trim());
            int linhas = stmt.executeUpdate();
 
            if (linhas == 0) {
                JOptionPane.showMessageDialog(this, "Nenhum equipamento com esse patrimônio.");
                return;
            }
            JOptionPane.showMessageDialog(this, "Equipamento atualizado com sucesso!");
            limpar();
            listar();
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Erro ao atualizar equipamento: " + e.getMessage());
        }    
    }//GEN-LAST:event_editarMouseClicked

    private void excluirMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_excluirMouseClicked
        // TODO add your handling code here:
        
        if (semConexao()) {
            return;
        }
        String pat = patrimonio.getText().trim();
        if (pat.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Digite o patrimônio do equipamento a excluir.");
            return;
        }
        int resposta = JOptionPane.showConfirmDialog(this,
                "Excluir o equipamento " + pat + "? Essa ação é permanente.",
                "Confirmar exclusão", JOptionPane.YES_NO_OPTION);
        if (resposta != JOptionPane.YES_OPTION) {
            return;
        }
        try {
            String sql = "DELETE FROM " + TABELA + " WHERE patrimonio = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, pat);
            int linhas = stmt.executeUpdate();
 
            if (linhas == 0) {
                JOptionPane.showMessageDialog(this, "Nenhum equipamento com esse patrimônio.");
                return;
            }
            JOptionPane.showMessageDialog(this, "Equipamento excluído com sucesso!");
            limpar();
            listar();
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Erro ao excluir equipamento: " + e.getMessage());
        }        
    }//GEN-LAST:event_excluirMouseClicked

    private void cancelarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cancelarMouseClicked
        // TODO add your handling code here:
    
        limpar();
    }//GEN-LAST:event_cancelarMouseClicked

    private void disponivelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_disponivelMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_disponivelMouseClicked

    private void emusoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_emusoMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_emusoMouseClicked

    private void manutencaoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_manutencaoMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_manutencaoMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ReflectiveOperationException | javax.swing.UnsupportedLookAndFeelException ex) {
            logger.log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> new Ativos().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> ativos;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton cancelar;
    private javax.swing.JRadioButton disponivel;
    private javax.swing.JButton editar;
    private javax.swing.JRadioButton emuso;
    private javax.swing.JButton excluir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JRadioButton manutencao;
    private javax.swing.JCheckBox nao;
    private javax.swing.JTextField nomeEquipamento;
    private javax.swing.JTextField patrimonio;
    private javax.swing.JButton salvar;
    private javax.swing.JTextField setor;
    private javax.swing.JCheckBox sim;
    // End of variables declaration//GEN-END:variables
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.AtualizarFuncionarioController;
import dao.Conexao;
import dao.FuncionarioDAO;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import model.Funcionario;

/**
 *
 * @author victo
 */
public class AtualizarFuncionarioView extends javax.swing.JFrame {
    private final AtualizarFuncionarioController controller;

    /**
     * Creates new form AtualizarFuncionarioView
     */
    public AtualizarFuncionarioView() throws SQLException {
        initComponents();
        controller = new AtualizarFuncionarioController(this);
        DefaultTableModel modelPadrao = (DefaultTableModel) this.jTablefuncionario.getModel();
        jTablefuncionario.setRowSorter(new TableRowSorter(modelPadrao));
        listarfuncionario();
    }
    
    public void listarfuncionario() throws SQLException{
        Connection conexao = new Conexao().getConnection();
       FuncionarioDAO funcionarioDao = new FuncionarioDAO(conexao);
            
        DefaultTableModel modelPadrao = (DefaultTableModel) this.jTablefuncionario.getModel();
        modelPadrao.setNumRows(0);
        
        ArrayList<Funcionario> funcionarios = funcionarioDao.selectAllfuncionario();
        
        for (Funcionario funcionario : funcionarios) {
                modelPadrao.addRow(new Object[]{
                funcionario.getId(),
                funcionario.getNome(),
                funcionario.getTelefone(),
                funcionario.getCpf(),
                funcionario.getCargo(),
                funcionario.getSalario(),
                funcionario.getEmail(),
                funcionario.getUsuario(),
                funcionario.getSenha()
            });
        }        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextField1 = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        jTextFieldnome = new javax.swing.JTextField();
        jTextFieldtelefone = new javax.swing.JTextField();
        jTextFieldcpf = new javax.swing.JTextField();
        jTextFieldcargo = new javax.swing.JTextField();
        jTextFieldsalario = new javax.swing.JTextField();
        jTextFieldemail = new javax.swing.JTextField();
        jTextFieldusuario = new javax.swing.JTextField();
        jTextFieldsenha = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jTextFieldid = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTablefuncionario = new javax.swing.JTable();

        jTextField1.setText("jTextField1");

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setText("Nome:");

        jLabel2.setText("Telefone:");

        jLabel3.setText("CPF:");

        jLabel4.setText("Cargo:");

        jLabel5.setText("Salario:");

        jLabel6.setText("Email:");

        jLabel7.setText("Usuario");

        jLabel8.setText("Senha:");

        jButton1.setText("Atualizar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel9.setText("Observação: Preencha todos os campos fazendo as alterações que desejar.");

        jTextFieldsenha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldsenhaActionPerformed(evt);
            }
        });

        jLabel10.setText("Digite o id do funcionario que deseja alterar:");

        jTablefuncionario.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Nome", "Telefone", "CPF", "Cargo", "Salario", "Email", "Usuario", "Senha"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(jTablefuncionario);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 557, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7)
                            .addComponent(jLabel8))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jTextFieldusuario, javax.swing.GroupLayout.DEFAULT_SIZE, 254, Short.MAX_VALUE)
                            .addComponent(jTextFieldemail)
                            .addComponent(jTextFieldsalario, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jTextFieldcargo, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jTextFieldcpf, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jTextFieldtelefone, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jTextFieldnome, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jTextFieldsenha))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel10)
                            .addComponent(jTextFieldid, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9)
                            .addComponent(jButton1))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jTextFieldnome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jTextFieldtelefone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jTextFieldcpf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jTextFieldcargo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jTextFieldsalario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jTextFieldemail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldusuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(jTextFieldsenha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextFieldsenhaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldsenhaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldsenhaActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try {
            controller.atualizarfuncionario();
            listarfuncionario();
        } catch (SQLException ex) {
            Logger.getLogger(AtualizarFuncionarioView.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

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
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(AtualizarFuncionarioView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AtualizarFuncionarioView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AtualizarFuncionarioView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AtualizarFuncionarioView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new AtualizarFuncionarioView().setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(AtualizarFuncionarioView.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    public JTextField getjTextFieldcargo() {
        return jTextFieldcargo;
    }

    public void setjTextFieldcargo(JTextField jTextFieldcargo) {
        this.jTextFieldcargo = jTextFieldcargo;
    }

    public JTextField getjTextFieldcpf() {
        return jTextFieldcpf;
    }

    public void setjTextFieldcpf(JTextField jTextFieldcpf) {
        this.jTextFieldcpf = jTextFieldcpf;
    }

    public JTextField getjTextFieldemail() {
        return jTextFieldemail;
    }

    public void setjTextFieldemail(JTextField jTextFieldemail) {
        this.jTextFieldemail = jTextFieldemail;
    }

    public JTextField getjTextFieldid() {
        return jTextFieldid;
    }

    public void setjTextFieldid(JTextField jTextFieldid) {
        this.jTextFieldid = jTextFieldid;
    }

    public JTextField getjTextFieldnome() {
        return jTextFieldnome;
    }

    public void setjTextFieldnome(JTextField jTextFieldnome) {
        this.jTextFieldnome = jTextFieldnome;
    }

    public JTextField getjTextFieldsalario() {
        return jTextFieldsalario;
    }

    public void setjTextFieldsalario(JTextField jTextFieldsalario) {
        this.jTextFieldsalario = jTextFieldsalario;
    }

    public JTextField getjTextFieldsenha() {
        return jTextFieldsenha;
    }

    public void setjTextFieldsenha(JTextField jTextFieldsenha) {
        this.jTextFieldsenha = jTextFieldsenha;
    }

    public JTextField getjTextFieldtelefone() {
        return jTextFieldtelefone;
    }

    public void setjTextFieldtelefone(JTextField jTextFieldtelefone) {
        this.jTextFieldtelefone = jTextFieldtelefone;
    }

    public JTextField getjTextFieldusuario() {
        return jTextFieldusuario;
    }

    public void setjTextFieldusuario(JTextField jTextFieldusuario) {
        this.jTextFieldusuario = jTextFieldusuario;
    }
    
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTablefuncionario;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextFieldcargo;
    private javax.swing.JTextField jTextFieldcpf;
    private javax.swing.JTextField jTextFieldemail;
    private javax.swing.JTextField jTextFieldid;
    private javax.swing.JTextField jTextFieldnome;
    private javax.swing.JTextField jTextFieldsalario;
    private javax.swing.JTextField jTextFieldsenha;
    private javax.swing.JTextField jTextFieldtelefone;
    private javax.swing.JTextField jTextFieldusuario;
    // End of variables declaration//GEN-END:variables
}

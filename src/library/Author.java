/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package library;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author sajid
 */
public class Author extends javax.swing.JFrame {

    /**
     * Creates new form login
     */
    public Author() {
        initComponents();
         connect();
         authTable_load();
    }
    
 
    
  Connection con=null;
  PreparedStatement pst=null;
  ResultSet rs=null;
  private void connect()
  {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/library","root","1234");
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(Author.class.getName()).log(Level.SEVERE, null, ex);
        }
  }
  
  private void authTable_load()
  {
        try {
            pst = con. prepareStatement("select * from author");
            rs= pst.executeQuery();
             ResultSetMetaData rsmd=rs.getMetaData(); 
             int col=rsmd.getColumnCount();
            DefaultTableModel dtm= (DefaultTableModel) authTable.getModel();
            dtm.setRowCount(0);
            
            while(rs.next())
            {
               Vector v =new Vector();
                
                for(int i=0;i<col;i++)
                  {
                     v.add(rs.getString("id"));
                     v.add(rs.getString("authName"));
                     v.add(rs.getString("address"));
                     v.add(rs.getString("phone"));
                  }
                dtm.addRow(v);
                
            }
            
            
        } catch (SQLException ex) {
            Logger.getLogger(Author.class.getName()).log(Level.SEVERE, null, ex);
        }
     
  }
  
  
  
  
    /**      * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        authTable = new javax.swing.JTable();
        authName = new javax.swing.JTextField();
        Addbutton = new javax.swing.JButton();
        Deletebutton = new javax.swing.JButton();
        Cancelbutton = new javax.swing.JButton();
        Update = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        address = new javax.swing.JTextArea();
        jLabel4 = new javax.swing.JLabel();
        phone = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(51, 51, 0));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 204, 0));
        jLabel1.setText("Address");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 204, 0));
        jLabel2.setText("Author Name");

        authTable.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        authTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Author Name", "Address", "Phone No"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        authTable.setGridColor(new java.awt.Color(0, 255, 102));
        authTable.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                authTableAncestorAdded(evt);
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        authTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                authTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(authTable);

        Addbutton.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        Addbutton.setText("Add");
        Addbutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddbuttonActionPerformed(evt);
            }
        });

        Deletebutton.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        Deletebutton.setText("Delete");
        Deletebutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DeletebuttonActionPerformed(evt);
            }
        });

        Cancelbutton.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        Cancelbutton.setText("Cancel");
        Cancelbutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CancelbuttonActionPerformed(evt);
            }
        });

        Update.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        Update.setText("Update");
        Update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UpdateActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Times New Roman", 1, 36)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 0));
        jLabel3.setText("Author");

        address.setColumns(20);
        address.setRows(5);
        jScrollPane2.setViewportView(address);

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 204, 0));
        jLabel4.setText("Phone No");

        phone.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                phoneActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addGap(32, 32, 32)
                                        .addComponent(jLabel4)
                                        .addGap(20, 20, 20)
                                        .addComponent(phone))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGap(40, 40, 40)
                                                .addComponent(jLabel1))
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGap(18, 18, 18)
                                                .addComponent(jLabel2)))
                                        .addGap(9, 9, 9)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(authName)
                                            .addComponent(jScrollPane2))))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(Addbutton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGap(18, 18, 18)
                                        .addComponent(Update))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(Deletebutton)
                                        .addGap(18, 18, 18)
                                        .addComponent(Cancelbutton)))
                                .addGap(70, 70, 70)))
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 538, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(335, 335, 335)
                        .addComponent(jLabel3)))
                .addGap(40, 40, 40))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(151, 151, 151)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2)
                    .addComponent(authName, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addComponent(jLabel1))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(27, 27, 27)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(phone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(61, 61, 61)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Addbutton, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Update, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(17, 17, 17)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(Deletebutton, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Cancelbutton, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(38, 127, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addGap(78, 78, 78)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 461, Short.MAX_VALUE)
                .addGap(22, 22, 22))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 20, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void DeletebuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DeletebuttonActionPerformed
        // TODO add your handling code here:
        
           try{    
               
               
             DefaultTableModel dtm= (DefaultTableModel) authTable.getModel();   
              int rowIdx = authTable.getSelectedRow();
              String auth = authName.getText();
              String addr = address.getText();
               String phoneNo = phone.getText();
              
                 if(!auth.equals("") && !addr.equals("") && !phoneNo.equals("") && rowIdx>=0)
                 {
                      String colFirst = (String) dtm.getValueAt(rowIdx, 0);
                     int id= Integer.parseInt(colFirst);
                     
                   pst= con.prepareStatement(" delete from author  where id=?");
                    pst.setInt(1, id);
                 
                int k = pst.executeUpdate();
                if(k>0)
                {
                    authTable_load();
                    JOptionPane.showMessageDialog(this," Reocrd no "+id+" Deleted succesfully!");
                    authName.setText("");
                   address.setText("");
                   phone.setText("");
                   authName.requestFocus();
                   Addbutton.setEnabled(true);
                    
                }
                else{
                    JOptionPane.showMessageDialog(this,"Error!");
                }
            }
            else{
                 if(rowIdx<0)
                JOptionPane.showMessageDialog(this,"please select the record to be deleted!");
                     else
                           JOptionPane.showMessageDialog(this,"one or more field are blank!");
                authName.requestFocus();
               }
            
        } catch (SQLException ex) {
            Logger.getLogger(Author.class.getName()).log(Level.SEVERE, null, ex);
        }    
    }//GEN-LAST:event_DeletebuttonActionPerformed

    private void AddbuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddbuttonActionPerformed
      
        try{
            
                String auth =   authName.getText();
                String addr =   address.getText();
               String phoneNo =    phone.getText();
              
               
               
            if(!auth.equals("") && !addr.equals("") && !phoneNo.equals(""))
              {
                  int phoneN= Integer.parseInt(phoneNo);
                pst= con.prepareStatement("insert into author(authName,address,phone)values(?,?,?)");
                pst.setString(1,auth);
                pst.setString(2, addr);
                pst.setInt(3, phoneN);
                
                int k = pst.executeUpdate();
                
                if(k>0)
                {
                    authTable_load();
                    JOptionPane.showMessageDialog(this,"New Author added succesfully!");
                    this.authName.setText("");
                    this.address.setText("");
                    this.phone.setText("");
                    this.authName.requestFocus();
                    
                }
                else{
                    JOptionPane.showMessageDialog(this,"Error!");
                }
            }
            else{
                JOptionPane.showMessageDialog(this,"one or more field blank!");
                authName.requestFocus();
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(Author.class.getName()).log(Level.SEVERE, null, ex);
        }
         catch (NumberFormatException ex) {
           JOptionPane.showMessageDialog(this,"please enter phone no  ");
        }
                         
    }//GEN-LAST:event_AddbuttonActionPerformed

    
    private void authTableAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_authTableAncestorAdded
        // TODO add your handling code here:
    }//GEN-LAST:event_authTableAncestorAdded

    private void authTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_authTableMouseClicked
                 // TODO add your handling code here:
           DefaultTableModel dtm= (DefaultTableModel) authTable.getModel();   
           int rowIdx = authTable.getSelectedRow();
           String colSecond = (String) dtm.getValueAt(rowIdx, 1);
           String colThird = (String) dtm.getValueAt(rowIdx, 2);
           String colFourth = (String) dtm.getValueAt(rowIdx, 3);
          
           
            authName.setText(colSecond);
            address.setText(colThird);
            phone.setText(colFourth);
       
          Addbutton.setEnabled(false);
          
          
          

    }//GEN-LAST:event_authTableMouseClicked

    private void UpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UpdateActionPerformed
             // TODO add your handling code here:
             
              try{
                   DefaultTableModel dtm= (DefaultTableModel) authTable.getModel();   
                 int rowIdx = authTable.getSelectedRow();
                 String auth = authName.getText();
                 String addr = address.getText();
                  String phoneNo = phone.getText();
                
              
                 if(!auth.equals("") && !addr.equals("") && !phoneNo.equals("") && rowIdx>=0)
                 {
                      int phoneN= Integer.parseInt(phoneNo);
                      String colFirst = (String) dtm.getValueAt(rowIdx, 0);
                      int id= Integer.parseInt(colFirst);
        
                pst= con.prepareStatement("update  author set authName=?,address=?,phone=? where id=?");
                pst.setString(1,auth);
                pst.setString(2, addr);
                pst.setInt(3, phoneN);
                pst.setInt(4, id);
                 
                int k = pst.executeUpdate();
                
                
                if(k>0)
                {
                    authTable_load();
                    JOptionPane.showMessageDialog(this," Record no" + id+ " Updated succesfully!");
                    this.authName.setText("");
                    this.address.setText("");
                    this.phone.setText("");
                    this.authName.requestFocus();
                     Addbutton.setEnabled(true);
                    
                }
                else{
                    JOptionPane.showMessageDialog(this,"Error!");
                }
            }
            else{
                     if(rowIdx<0)
                JOptionPane.showMessageDialog(this,"please select the record to be updated!");
                     else
                           JOptionPane.showMessageDialog(this,"one or more field are blank!");
                authName.requestFocus();
               }
            
        } catch (SQLException ex) {
            Logger.getLogger(Author.class.getName()).log(Level.SEVERE, null, ex);
              }
               catch (NumberFormatException ex) {
           JOptionPane.showMessageDialog(this,"please enter phone no  ");
        }
          
    }//GEN-LAST:event_UpdateActionPerformed

    private void CancelbuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CancelbuttonActionPerformed
        // TODO add your handling code here:
         this.setVisible(false);
         (new Main()).setVisible(true);
    }//GEN-LAST:event_CancelbuttonActionPerformed

    private void phoneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_phoneActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_phoneActionPerformed

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
            java.util.logging.Logger.getLogger(Author.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Author.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Author.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Author.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new Author().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Addbutton;
    private javax.swing.JButton Cancelbutton;
    private javax.swing.JButton Deletebutton;
    private javax.swing.JButton Update;
    private javax.swing.JTextArea address;
    private javax.swing.JTextField authName;
    private javax.swing.JTable authTable;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField phone;
    // End of variables declaration//GEN-END:variables
}
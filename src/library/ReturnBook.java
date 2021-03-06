/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package library;

import java.awt.event.KeyEvent;
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
public class ReturnBook extends javax.swing.JFrame {

    /**
     * Creates new form login
     */
    public ReturnBook() {
        initComponents();
         connect();
          Book_load();
          
         }
    
    
   
   
   
    
 private  Connection con=null;
 private  PreparedStatement pst=null;
 private  ResultSet rs=null;
  
  
  private void connect()
  {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/library","root","1234");
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(ReturnBook.class.getName()).log(Level.SEVERE, null, ex);
        }
  }
  

    
   private void Book_load()
  {
        try {
            pst = con. prepareStatement("select * from returnbook");
             
             rs= pst.executeQuery();
             ResultSetMetaData rsmd=rs.getMetaData(); 
             int col=rsmd.getColumnCount();
            DefaultTableModel dtm= (DefaultTableModel) BookTable.getModel();
            dtm.setRowCount(0);
            
            while(rs.next())
            {
               Vector v =new Vector();
                
                for(int i=0;i<col;i++)
                  {
                     v.add(rs.getString("memId"));
                     v.add(rs.getString("memName"));
                     v.add(rs.getString("bName"));
                     v.add(rs.getString("date"));
                     v.add(rs.getString("elaps"));
                      v.add(rs.getString("fine"));
                      
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

        returnDate = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        BookTable = new javax.swing.JTable();
        memId = new javax.swing.JTextField();
        Addbutton = new javax.swing.JButton();
        Cancelbutton = new javax.swing.JButton();
        Update = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        days = new javax.swing.JTextField();
        fine = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        memName = new javax.swing.JLabel();
        book = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        mem = new javax.swing.JLabel();
        date = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        returnDate.setBackground(new java.awt.Color(51, 51, 0));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 204, 0));
        jLabel1.setText("Membr Name");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 204, 0));
        jLabel2.setText(" Member Id");

        BookTable.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        BookTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Member ID", "Member Name", "Book", "Return Date", "Elaps", "Fine"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        BookTable.setGridColor(new java.awt.Color(0, 255, 102));
        BookTable.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                BookTableAncestorAdded(evt);
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        BookTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BookTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(BookTable);

        memId.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                memIdKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                memIdKeyReleased(evt);
            }
        });

        Addbutton.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        Addbutton.setText("Add");
        Addbutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddbuttonActionPerformed(evt);
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
        jLabel3.setText("Return Book");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 204, 0));
        jLabel5.setText("Book");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 204, 0));
        jLabel6.setText("Return Date");

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 204, 0));
        jLabel8.setText("Days Elaps");

        days.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                daysActionPerformed(evt);
            }
        });

        fine.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fineActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 204, 0));
        jLabel9.setText("Fine");

        memName.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        memName.setForeground(new java.awt.Color(204, 255, 204));

        book.setBackground(new java.awt.Color(255, 204, 204));
        book.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        book.setForeground(new java.awt.Color(255, 204, 204));
        book.setText("Book Name");

        jLabel4.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(204, 255, 204));

        mem.setBackground(new java.awt.Color(255, 204, 153));
        mem.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        mem.setForeground(new java.awt.Color(255, 204, 204));
        mem.setText("Member Name");

        date.setBackground(new java.awt.Color(255, 204, 204));
        date.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        date.setForeground(new java.awt.Color(204, 255, 204));
        date.setText("return date");

        javax.swing.GroupLayout returnDateLayout = new javax.swing.GroupLayout(returnDate);
        returnDate.setLayout(returnDateLayout);
        returnDateLayout.setHorizontalGroup(
            returnDateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(returnDateLayout.createSequentialGroup()
                .addGroup(returnDateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(returnDateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(returnDateLayout.createSequentialGroup()
                            .addContainerGap()
                            .addGroup(returnDateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(returnDateLayout.createSequentialGroup()
                                    .addGroup(returnDateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel6)
                                        .addComponent(jLabel8)
                                        .addComponent(jLabel9)
                                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel5))
                                    .addGap(26, 26, 26)
                                    .addGroup(returnDateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(memId, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE)
                                        .addComponent(days, javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(fine)
                                        .addGroup(returnDateLayout.createSequentialGroup()
                                            .addComponent(date, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                                .addGroup(returnDateLayout.createSequentialGroup()
                                    .addGap(110, 110, 110)
                                    .addComponent(memName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                        .addGroup(returnDateLayout.createSequentialGroup()
                            .addGap(29, 29, 29)
                            .addComponent(Addbutton, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(22, 22, 22)
                            .addComponent(Update))
                        .addGroup(returnDateLayout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(jLabel1)
                            .addGap(18, 18, 18)
                            .addGroup(returnDateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(mem, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(returnDateLayout.createSequentialGroup()
                                    .addComponent(book, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(0, 0, Short.MAX_VALUE)))))
                    .addGroup(returnDateLayout.createSequentialGroup()
                        .addGap(76, 76, 76)
                        .addComponent(Cancelbutton)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 541, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37))
            .addGroup(returnDateLayout.createSequentialGroup()
                .addGap(365, 365, 365)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        returnDateLayout.setVerticalGroup(
            returnDateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(returnDateLayout.createSequentialGroup()
                .addGap(151, 151, 151)
                .addGroup(returnDateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(memId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addComponent(memName)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(returnDateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(mem, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(19, 19, 19)
                .addGroup(returnDateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(book, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(25, 25, 25)
                .addGroup(returnDateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(date, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addGap(18, 18, 18)
                .addGroup(returnDateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(days, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 22, Short.MAX_VALUE)
                .addGroup(returnDateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(fine, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(52, 52, 52)
                .addGroup(returnDateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Update, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Addbutton, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addComponent(Cancelbutton, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(81, 81, 81))
            .addGroup(returnDateLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel3)
                .addGap(68, 68, 68)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 460, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(returnDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(returnDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void AddbuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddbuttonActionPerformed
      
        try {
            
                 String mid =   memId.getText();
                String bName =   book.getText();
                 String mName =   mem.getText();
                String rdate =   date.getText();
                String elap =   days.getText();
                String fines =   fine.getText();
               
    
                
                pst= con.prepareStatement("insert into returnbook(memId,memName,bName,date,elaps,fine)values(?,?,?,?,?,?)");
                 pst.setString(1,mid);
                 pst.setString(2, mName);
                pst.setString(3, bName);
                 pst.setString(4, rdate);
                   pst.setString(5, elap);
                 pst.setString(6, fines);
                 
                int k = pst.executeUpdate();
                 pst= con.prepareStatement("delete from issuebook where memId = ?");
                    pst.setString(1,mid);
                pst.executeUpdate();
                if(k>0)
                {
                    Book_load();
                    JOptionPane.showMessageDialog(this," Book returned!");
                     memId.setText("");
                      date.setText("");
                     mem.setText("");
                      book.setText("");
                     days.setText("");
                     fine.setText("");
                     
                     this.memId.requestFocus();
                    
                }
                else{
                    JOptionPane.showMessageDialog(this,"Error!");
                   }
                
            
        } catch (SQLException ex) {
            Logger.getLogger(ReturnBook.class.getName()).log(Level.SEVERE, null, ex);
        }
         catch (NumberFormatException ex) {
           JOptionPane.showMessageDialog(this,"please enter Number  ");
        }
                         
    }//GEN-LAST:event_AddbuttonActionPerformed

    
    private void BookTableAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_BookTableAncestorAdded
        // TODO add your handling code here:
    }//GEN-LAST:event_BookTableAncestorAdded

    private void BookTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BookTableMouseClicked
                 // TODO add your handling code here:
           DefaultTableModel dtm= (DefaultTableModel) BookTable.getModel();   
           int rowIdx = BookTable.getSelectedRow();
           String colfirst = (String) dtm.getValueAt(rowIdx, 0);
           String colSecond = (String) dtm.getValueAt(rowIdx, 1);
           String colThird = (String) dtm.getValueAt(rowIdx, 2);
            String colFourth = (String) dtm.getValueAt(rowIdx, 3);
            String colFive = (String) dtm.getValueAt(rowIdx, 4);
           String colSix= (String) dtm.getValueAt(rowIdx, 5);
          
            
            memId.setText(colfirst);
            mem.setText(colSecond);
            book.setText(colThird);
             date.setText(colFourth);
            days.setText(colFive);
            fine.setText(colSix);
       
          Addbutton.setEnabled(false);
            

    }//GEN-LAST:event_BookTableMouseClicked

    private void UpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UpdateActionPerformed
             // TODO add your handling code here:
             
               try{
                   String mid =   memId.getText();
                   String bName =   book.getText();
                   String mName =   mem.getText();
                   String rdate =   date.getText();
                   String elap =   days.getText();
                   String fines =   fine.getText();
               
       DefaultTableModel dtm= (DefaultTableModel) BookTable.getModel();   
           int rowIdx = BookTable.getSelectedRow();
           String colfirst = (String) dtm.getValueAt(rowIdx, 0);
                
                pst= con.prepareStatement("update  returnbook set memName=?,bName=?,date=?,elaps=?,fine=? where memId=?");
                 pst.setString(1, mName);
                pst.setString(2, bName);
                 pst.setString(3, rdate);
                   pst.setString(4, elap);
                 pst.setString(5, fines);
                   pst.setString(6,mid);
                int k = pst.executeUpdate();
                 pst= con.prepareStatement("delete from issuebook where memId = ?");
                    pst.setString(1,mid);
                pst.executeUpdate();
                if(k>0)
                {
                    Book_load();
                    JOptionPane.showMessageDialog(this," Updated!");
                     memId.setText("");
                      date.setText("");
                     mem.setText("");
                      book.setText("");
                     days.setText("");
                     fine.setText("");
                     
                     this.memId.requestFocus();
                     Addbutton.setEnabled(true);
                    
                }
                else{
                    JOptionPane.showMessageDialog(this,"Error!");
                   }
                
            
        } catch (SQLException ex) {
            Logger.getLogger(ReturnBook.class.getName()).log(Level.SEVERE, null, ex);
        }
         catch (NumberFormatException ex) {
           JOptionPane.showMessageDialog(this,"please enter Number  ");
        }
                         
          
    }//GEN-LAST:event_UpdateActionPerformed

    private void CancelbuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CancelbuttonActionPerformed
        // TODO add your handling code here:
         this.setVisible(false);
         (new Main()).setVisible(true);
    }//GEN-LAST:event_CancelbuttonActionPerformed

    private void memIdKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_memIdKeyPressed
        // TODO add your handling code here:i
        
          if(evt.getKeyCode()== KeyEvent.VK_ENTER)
            {
                try {
                    String mid= memId.getText();
                pst= con.prepareStatement("select m.name,b.name,ib.returnDate,DATEDIFF(now(),ib.returnDate) as elaps from issuebook as ib join "
                        + "member as m on m.id=ib.memId join booktable as b on b.id=ib.bookId where ib.memId=?");
                pst.setString(1, mid);
                rs= pst.executeQuery();
                if(rs.next())
                {
                     String mName= rs.getString("m.name");
                     String bName= rs.getString("b.name");
                     String return_date= rs.getString("ib.returnDate");
                      String elap= rs.getString("elaps");
                   
                 
                     mem.setText(mName.trim());
                     book.setText(bName.trim());
                     date.setText(return_date.trim());
                     int elapsed= Integer.parseInt(elap);
                     if(elapsed>0)
                     {
                         days.setText(elap);
                         int fines= 10*elapsed;
                         fine.setText(String.valueOf(fines));
                         
                         
                     }
                     else{
                           days.setText("0");
                         fine.setText("0");
                     }
                     
                            
                }
                else
                {
                  JOptionPane.showMessageDialog(this, "Member Id not found!");
                }
                
             
            } catch (SQLException ex) {
                Logger.getLogger(ReturnBook.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
      
        
        
    }//GEN-LAST:event_memIdKeyPressed

    private void memIdKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_memIdKeyReleased
        // TODO add your handling code here:
      
    }//GEN-LAST:event_memIdKeyReleased

    private void daysActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_daysActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_daysActionPerformed

    private void fineActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fineActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fineActionPerformed

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
            java.util.logging.Logger.getLogger(ReturnBook.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ReturnBook.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ReturnBook.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ReturnBook.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
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
            new ReturnBook().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Addbutton;
    private javax.swing.JTable BookTable;
    private javax.swing.JButton Cancelbutton;
    private javax.swing.JButton Update;
    private javax.swing.JLabel book;
    private javax.swing.JLabel date;
    private javax.swing.JTextField days;
    private javax.swing.JTextField fine;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel mem;
    private javax.swing.JTextField memId;
    private javax.swing.JLabel memName;
    private javax.swing.JPanel returnDate;
    // End of variables declaration//GEN-END:variables
}

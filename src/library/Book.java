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
public class Book extends javax.swing.JFrame {

    /**
     * Creates new form login
     */
    public Book() {
        initComponents();
         connect();
         category();
         author();
         publisher();
         Book_load();
         }
    
   private class CategoryItem
    {
       private final int id ;
       private final String name;
       CategoryItem(int id,String name)
       {
           this.id= id;
           this.name=name;
       }
       @Override
       public String toString(){
         return name;
       }
    }
 
     private class AuthorItem
     {
       private final int id ;
       private final String name;
       AuthorItem(int id,String name)
       {
           this.id= id;
           this.name=name;
       }
       @Override
       public String toString(){
         return name;
       }
    }
   private class PublisherItem
      {
       private final int id ;
       private final String name;
       PublisherItem(int id,String name)
       {
           this.id= id;
           this.name=name;
       }
       @Override
       public String toString(){
         return name;
       }
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
            Logger.getLogger(Book.class.getName()).log(Level.SEVERE, null, ex);
        }
  }
  
   private void Book_load()
  {
        try {
            pst = con. prepareStatement("select b.id,  b.name,a.authName,c.catName,p.pubName,b.content,b.pages,b.edition"
             + " from booktable as b join category as c "
                    + "On b.category = c.id join author as a "
                            + "on b.author= a.id join publisher as p on b.publisher=p.id ");
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
                     v.add(rs.getString("b.id"));
                     v.add(rs.getString("b.name"));
                      v.add(rs.getString("c.catName"));
                     v.add(rs.getString("a.authName"));
                     v.add(rs.getString("p.pubName"));
                     v.add(rs.getString("b.content"));
                     v.add(rs.getString("b.pages"));
                     v.add(rs.getString("b.edition"));
                      
                  }
                dtm.addRow(v);
                
            }
            
            
        } catch (SQLException ex) {
            Logger.getLogger(Author.class.getName()).log(Level.SEVERE, null, ex);
        }
     
  }
  
  
  
  private void category()
  {
        try {
             pst = con. prepareStatement("select * from  category");
             rs= pst.executeQuery();
            
                category.removeAllItems();
            while(rs.next())
            {
                category.addItem(new CategoryItem(rs.getInt(1),rs.getString(2)) );
                
            }
            
            
        } catch (SQLException ex) {
            Logger.getLogger(Book.class.getName()).log(Level.SEVERE, null, ex);
           }
     
  }
  private void author()
  {
        try {
             pst = con. prepareStatement("select * from  author");
             rs= pst.executeQuery();
            
              author.removeAllItems();
            while(rs.next())
            {
                author.addItem(new AuthorItem(rs.getInt(1),rs.getString(2)) );
                
            }
            
            
        } catch (SQLException ex) {
            Logger.getLogger(Book.class.getName()).log(Level.SEVERE, null, ex);
           }
     
  }
  
   private void publisher()
  {
        try {
             pst = con. prepareStatement("select * from  publisher");
             rs= pst.executeQuery();
            
                publisher.removeAllItems();
            while(rs.next())
            {
                publisher.addItem(new PublisherItem(rs.getInt(1),rs.getString(2)) );
                
            }
            
            
        } catch (SQLException ex) {
            Logger.getLogger(Book.class.getName()).log(Level.SEVERE, null, ex);
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
        BookTable = new javax.swing.JTable();
        name = new javax.swing.JTextField();
        Addbutton = new javax.swing.JButton();
        Deletebutton = new javax.swing.JButton();
        Cancelbutton = new javax.swing.JButton();
        Update = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        pages = new javax.swing.JTextField();
        category = new javax.swing.JComboBox();
        jLabel5 = new javax.swing.JLabel();
        author = new javax.swing.JComboBox();
        publisher = new javax.swing.JComboBox();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        edition = new javax.swing.JTextField();
        content = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(51, 51, 0));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 204, 0));
        jLabel1.setText("Category");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 204, 0));
        jLabel2.setText(" Book Name");

        BookTable.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        BookTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Book Name", "Category", "Author", "Publisher", "Contents", "No Of Pages", "Edition"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class
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
        if (BookTable.getColumnModel().getColumnCount() > 0) {
            BookTable.getColumnModel().getColumn(1).setResizable(false);
        }

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
        jLabel3.setText("Book");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 204, 0));
        jLabel4.setText("No of Pages");

        pages.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pagesActionPerformed(evt);
            }
        });

        category.setEditable(true);

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 204, 0));
        jLabel5.setText("Author");

        author.setEditable(true);

        publisher.setEditable(true);

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 204, 0));
        jLabel6.setText("Publisher");

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 204, 0));
        jLabel7.setText("Edition");

        edition.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editionActionPerformed(evt);
            }
        });

        content.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                contentActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 204, 0));
        jLabel8.setText("Contents");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel8)))
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addGap(24, 24, 24)
                                    .addComponent(jLabel7))))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(29, 29, 29)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(publisher, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(author, javax.swing.GroupLayout.Alignment.TRAILING, 0, 138, Short.MAX_VALUE)
                                        .addComponent(category, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(name, javax.swing.GroupLayout.Alignment.TRAILING))))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(28, 28, 28)
                                .addComponent(edition, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel4)
                        .addGap(20, 20, 20)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(pages, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(content, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(Addbutton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(18, 18, 18)
                                .addComponent(Update))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(Deletebutton)
                                .addGap(18, 18, 18)
                                .addComponent(Cancelbutton)))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 21, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 568, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(355, 355, 355))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(151, 151, 151)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(name, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addGap(29, 29, 29)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel1)
                            .addComponent(category, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(29, 29, 29)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel5)
                            .addComponent(author, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(29, 29, 29)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(publisher, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6))
                        .addGap(31, 31, 31)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(content, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(31, 31, 31)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(pages, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(31, 31, 31)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(edition, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Addbutton, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Update, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(17, 17, 17)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(Deletebutton, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Cancelbutton, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addComponent(jLabel3)
                        .addGap(53, 53, 53)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 460, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(67, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(13, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void DeletebuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DeletebuttonActionPerformed
        // TODO add your handling code here:
        
           try{
                   DefaultTableModel dtm= (DefaultTableModel) BookTable.getModel();   
                   int rowIdx = BookTable.getSelectedRow();
            
                String bName =   name.getText();
                int cIdx = category.getSelectedIndex();
                int pIdx = publisher.getSelectedIndex();
                int aIdx = author.getSelectedIndex();
                
               String page =       pages.getText();
               String contents =    content.getText();
               String editions =    edition.getText();
               
             // System.out.println(cIdx + " "+ pIdx +" "+ aIdx +" "+ rowIdx);
               
            if(!bName.equals("")&& rowIdx >= 0 && cIdx >= 0 && 
                    aIdx >= 0 && pIdx >= 0 
                    && !page.equals("") && !contents.equals("")
                    && !editions.equals(""))
                {
                    
               
                 CategoryItem  cItem =   (CategoryItem) category.getSelectedItem();
                 AuthorItem  aItem =    (AuthorItem) author.getSelectedItem();
                  PublisherItem  pItem  =   (PublisherItem) publisher.getSelectedItem();
                 String colFirst = (String) dtm.getValueAt(rowIdx, 0);
    
         
                pst= con.prepareStatement("delete  from booktable where id=?");
                 pst.setString(1,colFirst);

                int k = pst.executeUpdate();
             
                if(k>0)
                {
                    Book_load();
                    JOptionPane.showMessageDialog(this," Reocrd no "+colFirst+" Deleted succesfully!");
                     name.setText("");
                    author.setSelectedIndex(-1);
                    publisher.setSelectedIndex(-1);
                    category.setSelectedIndex(-1);
                    this.pages.setText("");
                     this.content.setText("");
                     this.edition.setText("");
                     this.name.requestFocus();
                     
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
                name.requestFocus();
               }
            
        } catch (SQLException ex) {
            Logger.getLogger(Book.class.getName()).log(Level.SEVERE, null, ex);
              }
               catch (NumberFormatException ex) {
           JOptionPane.showMessageDialog(this,"please enter  number  ");
        }
              catch(ClassCastException cce){}
          
    }//GEN-LAST:event_DeletebuttonActionPerformed

    private void AddbuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddbuttonActionPerformed
      
        try {
            
               String bName =   name.getText();
                int cIdx = category.getSelectedIndex();
                int pIdx = publisher.getSelectedIndex();
                int aIdx = author.getSelectedIndex();
                
               String page =       pages.getText();
                     Integer.parseInt(page);
               String contents =    content.getText();
               String editions =    edition.getText();
          
             if(!bName.equals("") && cIdx >= 0 && aIdx >= 0 && pIdx >= 0 && !page.equals("") && !contents.equals("") && !editions.equals(""))
                {
                 CategoryItem  cItem =   (CategoryItem) category.getSelectedItem();
                 AuthorItem  aItem =    (AuthorItem) author.getSelectedItem();
                  PublisherItem  pItem  =   (PublisherItem) publisher.getSelectedItem();
                pst= con.prepareStatement("insert into booktable(name,author,category,publisher,content,pages,edition)values(?,?,?,?,?,?,?)");
                pst.setString(1,bName);
                pst.setInt(2, aItem.id);
                pst.setInt(3, cItem.id);
                pst.setInt(4, pItem.id);
                pst.setString(5, contents);
                pst.setString(6, page);
                pst.setString(7, editions);   
              
                int k = pst.executeUpdate();
                
                if(k>0)
                {
                    Book_load();
                    JOptionPane.showMessageDialog(this,"New Book added!");
                    this.name.setText("");
                    author.setSelectedIndex(-1);
                    publisher.setSelectedIndex(-1);
                    category.setSelectedIndex(-1);
                    this.pages.setText("");
                     this.content.setText("");
                     this.edition.setText("");
                     this.name.requestFocus();
                    
                }
                else{
                    JOptionPane.showMessageDialog(this,"Error!");
                   }
                
               } 
        
                else{
                    JOptionPane.showMessageDialog(this,"one or more field are blank!");
                }
                
            
        } catch (SQLException ex) {
            Logger.getLogger(Book.class.getName()).log(Level.SEVERE, null, ex);
        }
         catch (NumberFormatException ex) {
           JOptionPane.showMessageDialog(this,"please enter correct format of page no  ");
        }
                         
    }//GEN-LAST:event_AddbuttonActionPerformed

    
    private void BookTableAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_BookTableAncestorAdded
        // TODO add your handling code here:
    }//GEN-LAST:event_BookTableAncestorAdded

    private void BookTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BookTableMouseClicked
                 // TODO add your handling code here:
           DefaultTableModel dtm= (DefaultTableModel) BookTable.getModel();   
           int rowIdx = BookTable.getSelectedRow();
           String colSecond = (String) dtm.getValueAt(rowIdx, 1);
           Object colThird =  dtm.getValueAt(rowIdx, 2);
           Object colFourth =  dtm.getValueAt(rowIdx, 3);
           Object colFifth =  dtm.getValueAt(rowIdx, 4);
            String colSixth = (String) dtm.getValueAt(rowIdx, 5);
           String colSeventh = (String) dtm.getValueAt(rowIdx, 6);
            String colEigth = (String) dtm.getValueAt(rowIdx, 7);
          
           
            name.setText(colSecond);
            category.setSelectedItem(colThird);
            author.setSelectedItem(colFourth);
            publisher.setSelectedItem(colFifth);
            
             content.setText(colSixth);
             pages.setText(colSeventh);
             edition.setText(colEigth);
       
          Addbutton.setEnabled(false);
          
          
          

    }//GEN-LAST:event_BookTableMouseClicked

    private void UpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UpdateActionPerformed
             // TODO add your handling code here:
             
              try{
                   DefaultTableModel dtm= (DefaultTableModel) BookTable.getModel();   
                   int rowIdx = BookTable.getSelectedRow();
            
                String bName =   name.getText();
                int cIdx = category.getSelectedIndex();
                int pIdx = publisher.getSelectedIndex();
                int aIdx = author.getSelectedIndex();
                
               String page =       pages.getText();
               String contents =    content.getText();
               String editions =    edition.getText();
               
             // System.out.println(cIdx + " "+ pIdx +" "+ aIdx +" "+ rowIdx);
               
            if(!bName.equals("")&& rowIdx >= 0 && cIdx >= 0 && 
                    aIdx >= 0 && pIdx >= 0 
                    && !page.equals("") && !contents.equals("")
                    && !editions.equals(""))
                {
                    
               
                 CategoryItem  cItem =   (CategoryItem) category.getSelectedItem();
                 AuthorItem  aItem =    (AuthorItem) author.getSelectedItem();
                  PublisherItem  pItem  =   (PublisherItem) publisher.getSelectedItem();
                 String colFirst = (String) dtm.getValueAt(rowIdx, 0);
    
         
                pst= con.prepareStatement("update  booktable set name=?,author=?,category=? ,publisher=?,content=?,pages=?,edition=? where id=?");
                 pst.setString(1,bName);
                pst.setInt(2, aItem.id);
                pst.setInt(3, cItem.id);
                pst.setInt(4, pItem.id);
                pst.setString(5, contents);
                pst.setString(6, page);
                pst.setString(7, editions);
                 pst.setString(8, colFirst);
                
                 
                int k = pst.executeUpdate();
                
                
                if(k>0)
                {
                    Book_load();
                    JOptionPane.showMessageDialog(this," Record no" + colFirst+ " Updated succesfully!");
                     name.setText("");
                    author.setSelectedIndex(-1);
                    publisher.setSelectedIndex(-1);
                    category.setSelectedIndex(-1);
                    this.pages.setText("");
                     this.content.setText("");
                     this.edition.setText("");
                     this.name.requestFocus();
                     
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
                name.requestFocus();
               }
            
        } catch (SQLException ex) {
            Logger.getLogger(Book.class.getName()).log(Level.SEVERE, null, ex);
              }
               catch (NumberFormatException ex) {
           JOptionPane.showMessageDialog(this,"please enter  number  ");
        }
              catch(ClassCastException cce){}
          
    }//GEN-LAST:event_UpdateActionPerformed

    private void CancelbuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CancelbuttonActionPerformed
        // TODO add your handling code here:
         this.setVisible(false);
         (new Main()).setVisible(true);
    }//GEN-LAST:event_CancelbuttonActionPerformed

    private void pagesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pagesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_pagesActionPerformed

    private void editionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_editionActionPerformed

    private void contentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_contentActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_contentActionPerformed

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
            java.util.logging.Logger.getLogger(Book.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Book.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Book.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Book.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new Book().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Addbutton;
    private javax.swing.JTable BookTable;
    private javax.swing.JButton Cancelbutton;
    private javax.swing.JButton Deletebutton;
    private javax.swing.JButton Update;
    private javax.swing.JComboBox author;
    private javax.swing.JComboBox category;
    private javax.swing.JTextField content;
    private javax.swing.JTextField edition;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField name;
    private javax.swing.JTextField pages;
    private javax.swing.JComboBox publisher;
    // End of variables declaration//GEN-END:variables
}

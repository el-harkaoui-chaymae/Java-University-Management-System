package pack_1;

import java.awt.*;
import java.awt.geom.RoundRectangle2D;
import java.awt.event.*;
import java.io.File;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Arrays;
import javax.imageio.ImageIO;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.*;
import javax.swing.border.Border;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.JTableHeader;
import java.util.Objects;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;

public class Professor_Module_Panel_22 extends JPanel {
   
    
    public Professor_Module_Panel_22() {
        
        

        //establish the connection
        
    	Connection connection = DatabaseConnection.getConnection();

        
        //--------------------------------------------------------------------------------------------
    	
    	
    	setLayout(null);
        setBackground(Color.WHITE);
        
         
        
        // new instance to take the entered ID
        
        
        Professor_Check_Panel_16 pan = new Professor_Check_Panel_16();
        String id = pan.getID();
        
        
  
  
   
       
        
        
        
        
        
        // define a variable to keep track of the currently selected button
        
        JButton btn = new JButton();
        btn.setHorizontalAlignment(SwingConstants.CENTER);
        btn.setFocusable(false);
        btn.setFocusTraversalKeysEnabled(false);
        btn.setFocusPainted(false);
        btn.setContentAreaFilled(false);
        btn.setOpaque(false);
        btn.setAlignmentX(Component.RIGHT_ALIGNMENT);
        btn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        btn.setFont(new Font("Century Gothic", Font.BOLD, 24));
        btn.setBorderPainted(true);
        btn.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, Color.BLACK)); 

        
        
 
     
        
        
        
        

        // adding a text -- adding a JLabel -- module
        
        JLabel label37 = new JLabel("Select a Module than Click on one of the Tabs Beside .");
        label37.setFont(new Font("Arial", Font.PLAIN, 18));
        label37.setForeground(Color.gray);
        label37.setBounds(40, 100, 600, 30);
        label37.setHorizontalAlignment(SwingConstants.LEFT);
        add(label37);
        
        
        
        // adding a text -- adding a JLabel -- module
        
        JLabel label7 = new JLabel("Module");
        label7.setFont(new Font("Arial", Font.BOLD, 20));
        label7.setForeground(Color.decode("#6495ED"));
        label7.setBounds(40, 10, 200, 30);
        label7.setHorizontalAlignment(SwingConstants.LEFT);
        add(label7);
        
        
        
        
        // adding the module text field
        
        JTextField module = new JTextField();
        module.setForeground(new Color(0, 0, 0));
        module.setFont(new Font("Arial", Font.PLAIN, 19));
        module.setBounds(40, 43, 450, 40);
        add(module);
  
        

        // get the modules from DB 
        
        try {
             
        	String query8 = "SELECT nom_module FROM module WHERE id_Prof = ?";
            PreparedStatement pstmt8 = connection.prepareStatement(query8);
            pstmt8.setString(1, id);
            ResultSet rs8 = pstmt8.executeQuery();

            // Create a list to store the modules options
            List<String> moduleOptionsList = new ArrayList<>();

            // Iterate through the result set and add the modules names to the list
            while (rs8.next()) {
                String moduleName = rs8.getString("nom_module");
                moduleOptionsList.add(moduleName);
            }

            // Convert the list to an array
            String[] moduleOptions = moduleOptionsList.toArray(new String[0]);

            // Create the module combo box with the options retrieved from the database
            JComboBox<String> moduleComboBox = new JComboBox<>(moduleOptions);
            moduleComboBox.setBounds(40, 81, 450, 40);
            moduleComboBox.setBackground(Color.decode("#F3FAFD"));
            moduleComboBox.setFont(new Font("Arial", Font.PLAIN, 18));
            moduleComboBox.setRenderer(new DefaultListCellRenderer() {
                public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
                    JLabel label = (JLabel) super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
                    label.setBackground(isSelected ? Color.decode("#C9E9F6") : Color.decode("#F3FAFD"));
                    return label;
                }
            });

            // Add a key listener to the text field to show/hide the combo box as needed
            module.addKeyListener(new KeyAdapter() {
                @Override
                public void keyTyped(KeyEvent e) {
                    if (module.getText().isEmpty()) {
                        remove(moduleComboBox);
                        revalidate();
                        repaint();
                    } else {
                        if (!Arrays.asList(getComponents()).contains(moduleComboBox)) {
                            add(moduleComboBox);
                            remove(label37);
                            
                            revalidate();
                            repaint();
                        }
                    }
                }
            });

            // Add a listener to the combo box to update the text field with the selected option
            moduleComboBox.addActionListener(e -> {
                String selectedOption = (String) moduleComboBox.getSelectedItem();
                module.setText(selectedOption);
                remove(moduleComboBox);
                add(label37);
                label37.setBounds(40, 100, 600, 30);
                revalidate();
                repaint();
            });

        } catch (Exception eee) {
            eee.printStackTrace();
        }

        
        
        
        
        
        
        
        
        
        // ====== Create a TABLE for students infos -marks- absence- -status-
        
        
        
        
        
        Object[][] data = new Object[52][6];
                
    	
    	
    	

        // Create the column names
        
        String[] columnNames = {"CNE", "FIRST NAME", "SECOND NAME", "MARK", "ABSENCE", "STATUS"};

        // Create the table model with the data and column names
        
        DefaultTableModel tableModel = new DefaultTableModel(data, columnNames) {
        	@Override
        	public Class<?> getColumnClass(int column) {
        	    if (data.length > 0 && data[0].length > column && data[0][column] != null) {
        	        return data[0][column].getClass();
        	    }
        	    return super.getColumnClass(column);
        	}

        };

        // Create the JTable with the custom table model
        
        JTable table = new JTable(tableModel);
        table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        table.setEnabled(false); // make the table non-editable

       

        
        // Set the preferred column widths
        
        table.getColumnModel().getColumn(0).setPreferredWidth(195);
        table.getColumnModel().getColumn(1).setPreferredWidth(250);
        table.getColumnModel().getColumn(2).setPreferredWidth(250);
        table.getColumnModel().getColumn(3).setPreferredWidth(100);
        table.getColumnModel().getColumn(4).setPreferredWidth(120);
        table.getColumnModel().getColumn(5).setPreferredWidth(200);

        // Set the row height to increase the cell size vertically
        
        table.setRowHeight(40); 

        // Align the text to the left with 2-space indentation
        DefaultTableCellRenderer leftRenderer = new DefaultTableCellRenderer() {
            private static final int INDENTATION = 16; // Adjust the indentation value as needed

            @Override
            public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected,boolean hasFocus, int row, int column) {
                Component cellComponent = super.getTableCellRendererComponent(table, value, isSelected, hasFocus,row, column);
                if (column >= 0 && column < table.getColumnCount()) {
                    setHorizontalAlignment(SwingConstants.LEFT);
                    setBorder(BorderFactory.createEmptyBorder(0, INDENTATION, 0, 0));
                }
                return cellComponent;
            }
        };
        
        
        // Set the custom renderer for the  table
        for (int j = 0; j < table.getColumnCount(); j++) {
            table.getColumnModel().getColumn(j).setCellRenderer(leftRenderer);
        }
        
        
        
      //------
        
        
        // Create the cell renderer for the specific columns
       
        DefaultTableCellRenderer marksRenderer2 = new DefaultTableCellRenderer() {
            {
                setHorizontalAlignment(SwingConstants.CENTER);
            }

            @Override
            public void setValue(Object value) {
                if (value != null) {
                    float mark = Float.parseFloat(value.toString());
                    setForeground(mark >= 12 ? Color.decode("#4C9A2A") : Color.RED);
  
                }
                super.setValue(value);
            }
        };

        // Apply the custom renderer to the specific columns
        table.getColumnModel().getColumn(3).setCellRenderer(marksRenderer2);
        
        
        //------
        
        
        
        
     // Create the cell renderer for the specific columns
        
        DefaultTableCellRenderer marksRenderer3 = new DefaultTableCellRenderer() {
            {
                setHorizontalAlignment(SwingConstants.CENTER);
            }

            @Override
            public void setValue(Object value) {
                if (value != null) {
                    String stat = value.toString();
                    setForeground(stat.equals("Valid") ? Color.decode("#4C9A2A") : Color.RED);
  
                }
                super.setValue(value);
            }
        };

        // Apply the custom renderer to the specific columns
        table.getColumnModel().getColumn(5).setCellRenderer(marksRenderer3);
        
        
        
        
        

        // Increase the font size for the table cells
        
        Font cellFont = table.getFont();
        table.setFont(cellFont.deriveFont(cellFont.getSize() + 7.0f)); 
        
      
        
        // Set the foreground color of the table header to blue
        
        JTableHeader tableHeader = table.getTableHeader();
        tableHeader.setForeground(Color.decode("#6495ED"));
        
        // Set the font size for the table header
        
        Font headerFont = tableHeader.getFont();
        Font newHeaderFont = new Font("Arial", Font.BOLD, headerFont.getSize() + 4); 
        tableHeader.setFont(newHeaderFont);

        // Set the selection background color to red
       
        table.setSelectionBackground(Color.decode("#DAF0F7"));
       
        // Apply the modified UI defaults to the table header
       
        UIManager.put("TableHeaderUI", "javax.swing.plaf.basic.BasicTableHeaderUI");
        tableHeader.updateUI();
        

        // Add the table to the panel
        
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(40, 200, 1134, 585); 
        add(scrollPane);

    	
 //------------------------------------------------------------------------------------------------------------------       
        
        
        
     // ====== Create a TABLE 2 for students marks 
        
 
        
        
        Object[][] data2 = new Object[52][6];
                
    	
    	
    	

        // Create the column names
        
        String[] columnNames2 = {"CNE", "FIRST NAME", "SECOND NAME", "C1", "C2", "TP" , "PROJECT"}; 

        // Create the table model with the data and column names
        
        DefaultTableModel tableModel2 = new DefaultTableModel(data2, columnNames2) {
        	@Override
        	public Class<?> getColumnClass(int column) {
        	    if (data2.length > 0 && data2[0].length > column && data2[0][column] != null) {
        	        return data2[0][column].getClass();
        	    }
        	    return super.getColumnClass(column); 
        	}

        };

        // Create the JTable with the custom table model 
        
        JTable table2 = new JTable(tableModel2);
        table2.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);

       

        
        // Set the preferred column widths
        
        table2.getColumnModel().getColumn(0).setPreferredWidth(195);
        table2.getColumnModel().getColumn(1).setPreferredWidth(250);
        table2.getColumnModel().getColumn(2).setPreferredWidth(250);
        table2.getColumnModel().getColumn(3).setPreferredWidth(100);
        table2.getColumnModel().getColumn(4).setPreferredWidth(100);
        table2.getColumnModel().getColumn(5).setPreferredWidth(105);
        table2.getColumnModel().getColumn(6).setPreferredWidth(115);


        // Set the row height to increase the cell size vertically
        
        table2.setRowHeight(40); 

        
        
        
 
        
        
        // Align the text to the left with 2-space indentation
        DefaultTableCellRenderer leftRenderer2 = new DefaultTableCellRenderer() {
            private static final int INDENTATION = 16; // Adjust the indentation value as needed

            @Override
            public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected,boolean hasFocus, int row, int column) {
                Component cellComponent = super.getTableCellRendererComponent(table, value, isSelected, hasFocus,row, column);
                if (column >= 0 && column < table2.getColumnCount()) {
                    setHorizontalAlignment(SwingConstants.LEFT);
                    setBorder(BorderFactory.createEmptyBorder(0, INDENTATION, 0, 0));
                }
                return cellComponent;
            }
        };
        
        
        // Set the custom renderer for the second table
        for (int j = 0; j < table2.getColumnCount(); j++) {
            table2.getColumnModel().getColumn(j).setCellRenderer(leftRenderer);
        }
        
        
        

        //------
       
       
       // Create the cell renderer for the specific columns
      
       DefaultTableCellRenderer marksRenderer = new DefaultTableCellRenderer() {
           {
               setHorizontalAlignment(SwingConstants.CENTER);
           }

           @Override
           public void setValue(Object value) {
               if (value != null) {
                   float mark = Float.parseFloat(value.toString());
                   setForeground(mark >= 12 ? Color.decode("#4C9A2A") : Color.RED);
               }
               super.setValue(value);
           }
       };

       // Apply the custom renderer to the specific columns
       table2.getColumnModel().getColumn(3).setCellRenderer(marksRenderer);
       table2.getColumnModel().getColumn(4).setCellRenderer(marksRenderer);
       table2.getColumnModel().getColumn(5).setCellRenderer(marksRenderer);
       table2.getColumnModel().getColumn(6).setCellRenderer(marksRenderer);

       
       //------
       

       
        
        
        
        // Increase the font size for the table cells 
        
        Font cellFont2 = table2.getFont();
        table2.setFont(cellFont2.deriveFont(cellFont2.getSize() + 7.0f)); 
        
       
        
        // Set the foreground color of the table header to blue
        
        JTableHeader tableHeader2 = table2.getTableHeader();
        tableHeader2.setForeground(Color.decode("#6495ED"));
        
        // Set the font size for the table header
        
        Font headerFont2 = tableHeader2.getFont();
        Font newHeaderFont2 = new Font("Arial", Font.BOLD, headerFont2.getSize() + 4); 
        tableHeader2.setFont(newHeaderFont2); 

        
        
        
       
        
        // Set the selection background color 
       
        table2.setSelectionBackground(Color.decode("#DAF0F7"));
       
        // Apply the modified UI defaults to the table header
       
        UIManager.put("TableHeaderUI", "javax.swing.plaf.basic.BasicTableHeaderUI");
        tableHeader2.updateUI();
        

        // Add the table to the panel
        
        JScrollPane scrollPane2 = new JScrollPane(table2);
        scrollPane2.setBounds(40, 200, 1134, 585); 
 
    	
//------------------------------------------------------------------------------------------------------------------       
        
   
        
        
     // ====== Create a TABLE 3 for students absences 
        
 
        
        
        Object[][] data3 = new Object[52][6];
                
    	
    	
    	

        // Create the column names
        
        String[] columnNames3 = { " CNE", "FIRST NAME","SECOND NAME"}; 

        // Create the table model with the data and column names
        
        DefaultTableModel tableModel3 = new DefaultTableModel(data3, columnNames3) {
        	@Override
        	public Class<?> getColumnClass(int column) {
        	    if (data3.length > 0 && data3[0].length > column && data3[0][column] != null) {
        	        return data3[0][column].getClass();
        	    }
        	    return super.getColumnClass(column); 
        	}

        };

        // Create the JTable with the custom table model 
        
        JTable table3 = new JTable(tableModel3);
        table3.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        
   
        
        // Set the preferred column widths
        

        table3.getColumnModel().getColumn(0).setPreferredWidth(195);
        table3.getColumnModel().getColumn(1).setPreferredWidth(250);
        table3.getColumnModel().getColumn(2).setPreferredWidth(250);


        // Set the row height to increase the cell size vertically
        
        table3.setRowHeight(40); 

      
        // Align the text to the left with 2-space indentation
        DefaultTableCellRenderer leftRenderer3 = new DefaultTableCellRenderer() {
            private static final int INDENTATION = 16; // Adjust the indentation value as needed

            @Override
            public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected,boolean hasFocus, int row, int column) {
                Component cellComponent = super.getTableCellRendererComponent(table, value, isSelected, hasFocus,row, column);
                if (column >= 0 && column < table3.getColumnCount()) {
                    setHorizontalAlignment(SwingConstants.LEFT);
                    setBorder(BorderFactory.createEmptyBorder(0, INDENTATION, 0, 0));
                }
                return cellComponent;
            }
        };
        
        
        // Set the custom renderer for the second table
        for (int j = 0; j < table3.getColumnCount(); j++) {
            table3.getColumnModel().getColumn(j).setCellRenderer(leftRenderer);
        }
        
        // Increase the font size for the table cells 
        
        table3.setFont(cellFont2.deriveFont(cellFont2.getSize() + 7.0f)); 
        
       
        
        // Set the foreground color of the table header to blue
        
        JTableHeader tableHeader3 = table3.getTableHeader();
        tableHeader3.setForeground(Color.decode("#6495ED"));
        
        // Set the font size for the table header
        
        tableHeader3.setFont(newHeaderFont2); 

     
        
        // Set the selection background color 
       
        table3.setSelectionBackground(Color.decode("#DAF0F7"));
       
        // Apply the modified UI defaults to the table header
       
        UIManager.put("TableHeaderUI", "javax.swing.plaf.basic.BasicTableHeaderUI");
        tableHeader3.updateUI();
        

        // Add the table to the panel
        
        JScrollPane scrollPane3 = new JScrollPane(table3);
        scrollPane3.setBounds(40, 200, 713, 585); 
 
    	
//------------------------------------------------------------------------------------------------------------------       
        
        
        
        
        
        
        
        // ====== Create a TABLE 3 for students absences 
           
    
           
           
           Object[][] data4 = new Object[52][6];
                   
       	
       	
       	

           // Create the column names
           
           String[] columnNames4 = { "ABSENCE DATE", "JUSTIFICATION"}; 

           // Create the table model with the data and column names
           
           DefaultTableModel tableModel4 = new DefaultTableModel(data4, columnNames4) {
           	@Override
           	public Class<?> getColumnClass(int column) {
           	    if (data4.length > 0 && data4[0].length > column && data4[0][column] != null) {
           	        return data4[0][column].getClass();
           	    }
           	    return super.getColumnClass(column); 
           	}

           };

           // Create the JTable with the custom table model 
           
           JTable table4 = new JTable(tableModel4);
           table4.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
           
      
           
           // Set the preferred column widths
           

           table4.getColumnModel().getColumn(0).setPreferredWidth(140);
           table4.getColumnModel().getColumn(1).setPreferredWidth(235);


           // Set the row height to increase the cell size vertically
           
           table4.setRowHeight(40); 

         
           // Align the text to the left with 2-space indentation
           DefaultTableCellRenderer leftRenderer4 = new DefaultTableCellRenderer() {
               private static final int INDENTATION = 16; // Adjust the indentation value as needed

               @Override
               public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected,boolean hasFocus, int row, int column) {
                   Component cellComponent = super.getTableCellRendererComponent(table, value, isSelected, hasFocus,row, column);
                   if (column >= 0 && column < table4.getColumnCount()) {
                       setHorizontalAlignment(SwingConstants.LEFT);
                       setBorder(BorderFactory.createEmptyBorder(0, INDENTATION, 0, 0));
                   }
                   return cellComponent;
               }
           };
           
           
           // Set the custom renderer for the second table
           for (int j = 0; j < table4.getColumnCount(); j++) {
               table4.getColumnModel().getColumn(j).setCellRenderer(leftRenderer);
           }
           
           // Increase the font size for the table cells 
           
           table4.setFont(cellFont2.deriveFont(cellFont2.getSize() + 7.0f)); 
           
          
           
           // Set the foreground color of the table header to blue
           
           JTableHeader tableHeader4 = table4.getTableHeader();
           tableHeader4.setForeground(Color.decode("#6495ED"));
           
           // Set the font size for the table header
           
           tableHeader4.setFont(newHeaderFont2); 

        
           
           // Set the selection background color 
          
           table4.setSelectionBackground(Color.decode("#DAF0F7"));
          
           // Apply the modified UI defaults to the table header
          
           UIManager.put("TableHeaderUI", "javax.swing.plaf.basic.BasicTableHeaderUI");
           tableHeader4.updateUI();
           

           // Add the table to the panel
           
           JScrollPane scrollPane4 = new JScrollPane(table4);
           scrollPane4.setBounds(780, 200, 393, 465); 
    
       	
   //------------------------------------------------------------------------------------------------------------------       
           
           
           
        

        
        
           
           // ====== Adding the show absences button
       	
           JButton show_absences = new JButton() { 
               @Override
               protected void paintComponent(Graphics g) {
                   Graphics2D g2 = (Graphics2D) g;
                   g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

                   // Define the rounded rectangle shape
                   Shape shape = new RoundRectangle2D.Float(0, 0, getWidth(), getHeight(), 50, 50);
                   
                   // Fill the shape with the gradient paint
                   GradientPaint gradient = new GradientPaint(0, 0, Color.blue, getWidth(), getHeight(), Color.green);
                   g2.setPaint(gradient);
                   g2.fill(shape);

                   super.paintComponent(g);
               } 
           };

           // Set the button text and style
           show_absences.setText("show absence");
           show_absences.setHorizontalTextPosition(SwingConstants.CENTER);
           show_absences.setForeground(new Color(255, 255, 255));
           show_absences.setFont(new Font("consolas", Font.BOLD, 30));

           // Remove the default button styles
           show_absences.setBorderPainted(false);
           show_absences.setFocusPainted(false);
           show_absences.setContentAreaFilled(false);
           show_absences.setOpaque(false);        
           show_absences.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR)); 
         

           // ===== Adding the add absence button
       	
           JButton add_absence = new JButton() { 
               @Override
               protected void paintComponent(Graphics g) {
                   Graphics2D g2 = (Graphics2D) g;
                   g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

                   // Define the rounded rectangle shape
                   Shape shape = new RoundRectangle2D.Float(0, 0, getWidth(), getHeight(), 50, 50);
                   
                   // Fill the shape with the gradient paint
                   GradientPaint gradient = new GradientPaint(0, 0, Color.blue, getWidth(), getHeight(), Color.green);
                   g2.setPaint(gradient);
                   g2.fill(shape);

                   super.paintComponent(g);
               }
           }; 

           // Set the button text and style
           add_absence.setText("add absence");
           add_absence.setHorizontalTextPosition(SwingConstants.CENTER);
           add_absence.setForeground(new Color(255, 255, 255));
           add_absence.setFont(new Font("consolas", Font.BOLD, 30));

           // Remove the default button styles
           add_absence.setBorderPainted(false);
           add_absence.setFocusPainted(false);
           add_absence.setContentAreaFilled(false);
           add_absence.setOpaque(false);        
           add_absence.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        
           
// ---------------------------------------------------------------------------------------------------------        
        
       
        
        // Adding the absences button
        
        JButton absences = new JButton("Absences");
        absences.setHorizontalAlignment(SwingConstants.CENTER);
        absences.setFocusable(false);
        absences.setFocusTraversalKeysEnabled(false);
        absences.setFocusPainted(false);
        absences.setContentAreaFilled(false);
        absences.setOpaque(false);
        absences.setAlignmentX(Component.RIGHT_ALIGNMENT);
        absences.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        absences.setFont(new Font("Century Gothic", Font.BOLD, 24));
        absences.setBorderPainted(false);
        add(absences);
        absences.setBounds(990, 35, 170, 41);
        
        
        absences.addMouseListener(new java.awt.event.MouseAdapter() {
            
        	public void mouseEntered(java.awt.event.MouseEvent evt) {
        		
        		absences.setBorderPainted(true);
                absences.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, Color.BLACK)); // Set bottom border

         }
            public void mouseExited(java.awt.event.MouseEvent evt) {
            	
            	absences.setBorderPainted(false);

           }
        }); 
 
        
        absences.addActionListener(new ActionListener() { 
            public void actionPerformed(ActionEvent e) {
               
            	// button sound effect
            	try {
                    File soundFile = new File("cursor1.wav");
                    Clip clip = AudioSystem.getClip();
                    clip.open(AudioSystem.getAudioInputStream(soundFile));
                    clip.start();
                    
                  
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            	
            	
            	
            	
            	add(btn);
            	btn.setBounds(990, 35, 170, 41);
            	
            	scrollPane.setVisible(false);
                scrollPane2.setVisible(false);
                scrollPane3.setVisible(true);
                scrollPane4.setVisible(true);
                add(scrollPane4);
                add(scrollPane3);
                
                add(show_absences);
                show_absences.setBounds(780,690,395,40); 
                
                add(add_absence);
                add_absence.setBounds(780,740,395,40); 
                
                
               
                

               
                // revalidate and repaint the panel
                revalidate();
                repaint();
                
                

               
                // revalidate and repaint the panel
                revalidate();
                repaint();
            	
              	
             }
         }); 
        
        
        
        
               	
       
     
        
        // Adding the save button
        
        JButton save = new JButton() { 
            @Override
            protected void paintComponent(Graphics g) {
                Graphics2D g2 = (Graphics2D) g;
                g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

                // Define the rounded rectangle shape
                Shape shape = new RoundRectangle2D.Float(0, 0, getWidth(), getHeight(), 50, 50);
                
                // Fill the shape with the gradient paint
                GradientPaint gradient = new GradientPaint(0, 0, Color.blue, getWidth(), getHeight(), Color.green);
                g2.setPaint(gradient);
                g2.fill(shape);

                super.paintComponent(g); 
            }
        };

        // Set the button text and style
        save.setText("save change");
        save.setHorizontalTextPosition(SwingConstants.CENTER);
        save.setForeground(new Color(255, 255, 255));
        save.setFont(new Font("consolas", Font.BOLD, 30));

        // Remove the default button styles
        save.setBorderPainted(false);
        save.setFocusPainted(false);
        save.setContentAreaFilled(false);
        save.setOpaque(false);        
        save.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        
        
        
        
        
        save.addActionListener(new ActionListener() { 
            public void actionPerformed(ActionEvent e) {
               
            	// button sound effect
            	try {
                    File soundFile = new File("cursor1.wav");
                    Clip clip = AudioSystem.getClip();
                    clip.open(AudioSystem.getAudioInputStream(soundFile));
                    clip.start();
                    
                  
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            	
            	
            	try {
            	    

            	    for (int i = 0; i < table2.getRowCount(); i++) {
            	        
            	    	String cne = (String) table2.getValueAt(i, 0);
            	        String c1String = (String) table2.getValueAt(i, 3);
            	        String c2String = (String) table2.getValueAt(i, 4);
            	        String tpString = (String) table2.getValueAt(i, 5);
            	        String projectString = (String) table2.getValueAt(i, 6);
            	        
            	        if (cne == null) { break;}
            	        
            	        

            	        Float c1 = null;
            	        Float c2 = null;
            	        Float tp = null;
            	        Float project = null;

            	        

            	        

            	        
            	        

            	        
                       
            	        //--------------------------- save c1 -----------------------------------
            	       
            	        
            	        if (c1String != null && !c1String.isEmpty()) {
            	            
            	        	c1 = Float.parseFloat(c1String);
            	        	
            	        	try {
            	                
            	            	
            	            	
            	            	//--- in MODULE table

                        	    String q1 = "SELECT id_module FROM MODULE WHERE nom_module = ? AND id_Prof = ?";
                        	    PreparedStatement ps1 = connection.prepareStatement(q1);
                        	    ps1.setString(1, module.getText());
                        	    ps1.setString(2, id);

                        	    ResultSet r1 = ps1.executeQuery();

                        	    // retrieve and store the id value
                        	    String idModule = null;
                        	    if (r1.next()) {
                        	        idModule = r1.getString("id_module");
                        	    }
            	            	
  	            	
            	            	// --- in NOTE table
            	            	
            	            	String sql = "SELECT COUNT(*) FROM NOTE WHERE CNE=? AND id_module=?";
                    	        PreparedStatement stmt = connection.prepareStatement(sql);
                    	        stmt.setString(1,cne ); 
                    	        stmt.setString(2, idModule); 
                    	        ResultSet rs = stmt.executeQuery();
                    	        rs.next();
                    	        int count = rs.getInt(1);
                    	        
                    	        if (count == 0) {
                    	            
                    	        	try {
                    	            	String q11 = "INSERT INTO note (CNE, valeur_note_c1, id_module) VALUES (?, ?, ?)";
                    	                PreparedStatement ps11 = connection.prepareStatement(q11);
                    	                ps11.setString(1, cne);
                    	                ps11.setFloat(2, c1);
                    	                ps11.setString(3, idModule);
                    	                int rowsUpdated = ps11.executeUpdate();
                    	            }
                    	            
                    	            catch(Exception ed) {ed.printStackTrace();}
                    	        
                    	        } else {
                    	            
                    	           
                    	            try {

                        	            String q111 = "UPDATE note SET valeur_note_c1 = ? WHERE CNE = ? AND id_module = ?";
                        	            PreparedStatement ps111 = connection.prepareStatement(q111);
                        	            ps111.setFloat(1, c1);
                        	            ps111.setString(2, cne);
                        	            ps111.setString(3, idModule);
                        	            int rowsUpdated = ps111.executeUpdate();
                    	            }
                    	            
                    	            catch(Exception eed) {eed.printStackTrace();}

                    	        
                    	        
                    	        
                    	        }
                    	        
  	            	
            	            	
            	            } catch (Exception ey) {
            	                ey.printStackTrace();
            	            }
            	        }
            	        
            	        
            	        
                       //--------------------- save c2 -----------------------------------------
            	       

            	        if (c2String != null && !c2String.isEmpty()) {
            	            c2 = Float.parseFloat(c2String);
            	        	
            	        	try {
            	                
            	            	
            	            	
            	            	//--- in MODULE table

                        	    String q11 = "SELECT id_module FROM MODULE WHERE nom_module = ? AND id_Prof = ?";
                        	    PreparedStatement ps11 = connection.prepareStatement(q11);
                        	    ps11.setString(1, module.getText());
                        	    ps11.setString(2, id);

                        	    ResultSet r11 = ps11.executeQuery();

                        	    // retrieve and store the id value
                        	    String idModule = null;
                        	    if (r11.next()) {
                        	        idModule = r11.getString("id_module");
                        	    }
            	            	
  	            	
            	            	// --- in NOTE table
            	            	
            	            	String sqll = "SELECT COUNT(*) FROM NOTE WHERE CNE=? AND id_module=?";
                    	        PreparedStatement stmtt = connection.prepareStatement(sqll);
                    	        stmtt.setString(1,cne ); 
                    	        stmtt.setString(2, idModule); 
                    	        ResultSet rss = stmtt.executeQuery();
                    	        rss.next();
                    	        int count = rss.getInt(1);
                    	        
                    	        if (count == 0) {
                    	            
                    	        	try {
                    	            	String q111 = "INSERT INTO NOTE (CNE, valeur_note_c2, id_module) VALUES (?, ?, ?)";
                    	                PreparedStatement ps111 = connection.prepareStatement(q111);
                    	                ps111.setString(1, cne);
                    	                ps111.setFloat(2, c2);
                    	                ps111.setString(3, idModule);
                    	                int rowsUpdated = ps111.executeUpdate();
                    	            }
                    	            
                    	            catch(Exception ed) {ed.printStackTrace();}
                    	        
                    	        } else {
                    	            
                    	           
                    	            try {

                        	            String q1111 = "UPDATE NOTE SET valeur_note_c2 = ? WHERE CNE = ? AND id_module = ?";
                        	            PreparedStatement ps1111 = connection.prepareStatement(q1111);
                        	            ps1111.setFloat(1, c2);
                        	            ps1111.setString(2, cne);
                        	            ps1111.setString(3, idModule);
                        	            int rowsUpdated = ps1111.executeUpdate();
                    	            }
                    	            
                    	            catch(Exception eed) {eed.printStackTrace();}

                    	        
                    	        
                    	        
                    	        } 
                    	        
  	            	
            	            	
            	            } catch (Exception ey) {
            	                ey.printStackTrace();
            	            }
            	        }
            	    
            	    
            	    
            	        // ---------------------- save tp -------------------------------------
            	        
            	        
            	        if (tpString != null && !tpString.isEmpty()) {
            	            tp = Float.parseFloat(tpString);
            	        	
            	        	try {
            	                
            	            	
            	            	
            	            	//--- in MODULE table

                        	    String q11 = "SELECT id_module FROM MODULE WHERE nom_module = ? AND id_Prof = ?";
                        	    PreparedStatement ps11 = connection.prepareStatement(q11);
                        	    ps11.setString(1, module.getText());
                        	    ps11.setString(2, id);

                        	    ResultSet r11 = ps11.executeQuery();

                        	    // retrieve and store the id value
                        	    String idModule = null;
                        	    if (r11.next()) {
                        	        idModule = r11.getString("id_module");
                        	    }
            	            	
  	            	
            	            	// --- in NOTE table
            	            	
            	            	String sqll = "SELECT COUNT(*) FROM NOTE WHERE CNE=? AND id_module=?";
                    	        PreparedStatement stmtt = connection.prepareStatement(sqll);
                    	        stmtt.setString(1,cne ); 
                    	        stmtt.setString(2, idModule); 
                    	        ResultSet rss = stmtt.executeQuery();
                    	        rss.next();
                    	        int count = rss.getInt(1);
                    	        
                    	        if (count == 0) {
                    	            
                    	        	try {
                    	            	String q111 = "INSERT INTO NOTE (CNE, valeur_note_tp, id_module) VALUES (?, ?, ?)";
                    	                PreparedStatement ps111 = connection.prepareStatement(q111);
                    	                ps111.setString(1, cne);
                    	                ps111.setFloat(2, tp);
                    	                ps111.setString(3, idModule);
                    	                int rowsUpdated = ps111.executeUpdate();
                    	            }
                    	            
                    	            catch(Exception ed) {ed.printStackTrace();}
                    	        
                    	        } else {
                    	            
                    	           
                    	            try {

                        	            String q1111 = "UPDATE NOTE SET valeur_note_tp = ? WHERE CNE = ? AND id_module = ?";
                        	            PreparedStatement ps1111 = connection.prepareStatement(q1111);
                        	            ps1111.setFloat(1, tp);
                        	            ps1111.setString(2, cne);
                        	            ps1111.setString(3, idModule);
                        	            int rowsUpdated = ps1111.executeUpdate();
                    	            }
                    	            
                    	            catch(Exception eed) {eed.printStackTrace();}

                    	        
                    	        
                    	        
                    	        } 
                    	        
  	            	
            	            	
            	            } catch (Exception ey) {
            	                ey.printStackTrace();
            	            }
            	        }
            	        
            	        
            	        
            	        
                       //--------------------------- save project -----------------------------------
            	       
            	        

            	        if (projectString != null && !projectString.isEmpty()) {
            	            project = Float.parseFloat(projectString);
            	        	
            	        	try {
            	                
            	            	
            	            	
            	            	//--- in MODULE table

                        	    String q1 = "SELECT id_module FROM MODULE WHERE nom_module = ? AND id_Prof = ?";
                        	    PreparedStatement ps1 = connection.prepareStatement(q1);
                        	    ps1.setString(1, module.getText());
                        	    ps1.setString(2, id);

                        	    ResultSet r1 = ps1.executeQuery();

                        	    // retrieve and store the id value
                        	    String idModule = null;
                        	    if (r1.next()) {
                        	        idModule = r1.getString("id_module");
                        	    }
            	            	
  	            	
            	            	// --- in NOTE table
            	            	
            	            	String sql = "SELECT COUNT(*) FROM NOTE WHERE CNE=? AND id_module=?";
                    	        PreparedStatement stmt = connection.prepareStatement(sql);
                    	        stmt.setString(1,cne ); 
                    	        stmt.setString(2, idModule); 
                    	        ResultSet rs = stmt.executeQuery();
                    	        rs.next();
                    	        int count = rs.getInt(1);
                    	        
                    	        if (count == 0) {
                    	            
                    	        	try {
                    	            	String q11 = "INSERT INTO note (CNE, valeur_note_projet, id_module) VALUES (?, ?, ?)";
                    	                PreparedStatement ps11 = connection.prepareStatement(q11);
                    	                ps11.setString(1, cne);
                    	                ps11.setFloat(2, project);
                    	                ps11.setString(3, idModule);
                    	                int rowsUpdated = ps11.executeUpdate();
                    	            }
                    	            
                    	            catch(Exception ed) {ed.printStackTrace();}
                    	        
                    	        } else {
                    	            
                    	           
                    	            try {

                        	            String q111 = "UPDATE note SET valeur_note_projet = ? WHERE CNE = ? AND id_module = ?";
                        	            PreparedStatement ps111 = connection.prepareStatement(q111);
                        	            ps111.setFloat(1, project);
                        	            ps111.setString(2, cne);
                        	            ps111.setString(3, idModule);
                        	            int rowsUpdated = ps111.executeUpdate();
                    	            }
                    	            
                    	            catch(Exception eed) {eed.printStackTrace();}

                    	        
                    	        
                    	        
                    	        }
                    	        
  	            	
            	            	
            	            } catch (Exception ey) {
            	                ey.printStackTrace();
            	            }
            	        }
            	        
            	        

           	    
            	    
  	    }
            	
            	} catch (Exception eq) {
            	    eq.printStackTrace();
            	}

            	
          	
            	
            }
        });
          

        
        
        
      
        
        // Adding the show button
        
        JButton show = new JButton("General");
        show.setHorizontalAlignment(SwingConstants.CENTER);
        show.setFocusable(false);
        show.setFocusTraversalKeysEnabled(false);
        show.setFocusPainted(false);
        show.setContentAreaFilled(false);
        show.setOpaque(false);
        show.setAlignmentX(Component.RIGHT_ALIGNMENT);
        show.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        show.setBorderPainted(false);
        show.setFont(new Font("Century Gothic", Font.BOLD, 24));
        add(show);
        show.setBounds(560, 35, 150, 41);
        
        show.addMouseListener(new java.awt.event.MouseAdapter() {
            
        	public void mouseEntered(java.awt.event.MouseEvent evt) {
        		show.setBorderPainted(true);
                show.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, Color.BLACK)); // Set bottom border

         }
            public void mouseExited(java.awt.event.MouseEvent evt) {
            	show.setBorderPainted(false);

           }
        }); 
      
        
        show.addActionListener(new ActionListener() { 
            public void actionPerformed(ActionEvent e) {
               
            	// button sound effect
            	try {
                    File soundFile = new File("cursor1.wav");
                    Clip clip = AudioSystem.getClip();
                    clip.open(AudioSystem.getAudioInputStream(soundFile));
                    clip.start();
                    
                  
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            	
            	
   	
            	add(btn);
            	btn.setBounds(560, 35, 150, 41);
            	
                scrollPane.setVisible(true);
                scrollPane2.setVisible(false);
                scrollPane4.setVisible(false);
                scrollPane3.setVisible(false);
                
                

                
                remove(add_absence);
                remove(show_absences);
            	remove(save);
               
                // revalidate and repaint the panel
                revalidate();
                repaint();

                
                
                
                


            	
                // ===== get infos  about student from DB
                
                
                
                try {
                	
                	
                	//--- in MODULE table

                	String q1 = "SELECT id_module FROM MODULE WHERE nom_module = ? AND id_Prof = ?";
                	PreparedStatement ps1 = connection.prepareStatement(q1);
                	ps1.setString(1, module.getText());
                	ps1.setString(2, id);

                	ResultSet r1 = ps1.executeQuery();

                	//  retrieve  and store the id value
                	String idModule = null;
                	if (r1.next()) {
                	    idModule = r1.getString("id_module");
                	}

                	
                	
                	
                	
                	
                	// --- in ENSEIGNEMENT table

                	String q2 = "SELECT annee_etude, nom_filliere FROM ENSEIGNEMENT WHERE id_Prof = ?  AND id_module = ?";
                	PreparedStatement ps2 = connection.prepareStatement(q2);
                	ps2.setString(1, id);
                	ps2.setString(2, idModule);

                	ResultSet r2 = ps2.executeQuery();

                	//  retrieve  and store the id value
                	String year = null;
                	String section = null;
                	if (r2.next()) {
                	    year = r2.getString("annee_etude");
                	    section = r2.getString("nom_filliere");
                	}

                	
                	
                	
                	//--- in ETUDIANT table

                	String q3 = "SELECT CNE, nom, prenom FROM ETUDIANT WHERE annee_etude = ? AND nom_filliere = ?";
                	PreparedStatement ps3 = connection.prepareStatement(q3);
                	ps3.setString(1, year);
                	ps3.setString(2, section);

                	ResultSet r3 = ps3.executeQuery();
                	
                	
                    

                	// Clear all existing rows
                	int rowCount3 = tableModel.getRowCount();
                	for (int i = rowCount3 - 1; i >= 0; i--) {
                		tableModel.setValueAt(null, i, 0);
                	    tableModel.setValueAt(null, i, 1);
                	    tableModel.setValueAt(null, i, 2);              
                	}
                	
                	 
                	
                	// update the cells
                	
                    int i = 0;
                	while (r3.next() && i < 20) {
                	    // Update the values in the table model
                	    tableModel.setValueAt(r3.getString("CNE"), i, 0);
                	    tableModel.setValueAt(r3.getString("nom"), i, 1);
                	    tableModel.setValueAt(r3.getString("prenom"), i, 2);
                	    i++;
                	}

               	
                	
                }
                
                
                catch(Exception e99) {
                	e99.printStackTrace();       	
               }
                
                
                
               // ------- set the mark value in table 1 

                try {
                	
                	
                   for (int i = 0; i < table.getRowCount(); i++) {
            	        
            	    	try {
            	    		
            	    		
            	    		String cne = (String) table.getValueAt(i, 0);
            	    		  
                        	//--- in MODULE table

                        	String q1 = "SELECT id_module FROM MODULE WHERE nom_module = ? AND id_Prof = ?";
                        	PreparedStatement ps1 = connection.prepareStatement(q1);
                        	ps1.setString(1, module.getText());
                        	ps1.setString(2, id);

                        	ResultSet r1 = ps1.executeQuery();

                        	//  retrieve  and store the id value
                        	String idModule = null;
                        	if (r1.next()) {
                        	    idModule = r1.getString("id_module");
                        	}
                        	
                        	// get marks values from DB
                        	
                        	
                        	String q11 = "SELECT COUNT(*) FROM NOTE WHERE CNE=? AND id_module=? AND valeur_note_c1 IS NOT NULL AND valeur_note_c2 IS NOT NULL AND valeur_note_tp IS NOT NULL AND valeur_note_projet IS NOT NULL";
                        	PreparedStatement ps11 = connection.prepareStatement(q11);
                        	ps11.setString(1, cne);
                        	ps11.setString(2, idModule);
                        	ResultSet rs = ps11.executeQuery();
                        	rs.next();
                        	int count = rs.getInt(1);
                        	
                        	if (count > 0) {
                        		
                        		String q112 = "SELECT valeur_note_c1, valeur_note_c2, valeur_note_tp, valeur_note_projet FROM NOTE WHERE CNE=? AND id_module=?";
                            	PreparedStatement ps112 = connection.prepareStatement(q112);
                            	ps112.setString(1, cne);
                            	ps112.setString(2, idModule);
                            	ResultSet rs2 = ps112.executeQuery();
                            	rs2.next();

                            	

                            	float floatValueC1 = rs2.getFloat("valeur_note_c1");
                            	float floatValueC2 = rs2.getFloat("valeur_note_c2");
                            	float floatValueTP = rs2.getFloat("valeur_note_tp");
                            	float floatValueProject = rs2.getFloat("valeur_note_projet");
                            	
                            	
                                float mark = (float) (0.5 * floatValueProject + 0.2 * (floatValueC1 + floatValueC2) + 0.1 * floatValueTP);
                        	    
                                table.setValueAt(mark, i, 3);
                                
                                if(mark<12) { table.setValueAt("Invalid", i, 5);}
                                
                                else {table.setValueAt("Valid", i, 5);}
                                
                                try {

                    	            String q111 = "UPDATE NOTE SET valeur_note_module = ? WHERE CNE = ? AND id_module = ?";
                    	            PreparedStatement ps111 = connection.prepareStatement(q111);
                    	            ps111.setFloat(1, mark);
                    	            ps111.setString(2, cne);
                    	            ps111.setString(3, idModule);
                    	            int rowsUpdated = ps111.executeUpdate();
                	            }
                	            
                	            catch(Exception eesd) {eesd.printStackTrace();}
                        		
                        		
                        		
                        	}
                        	
                        	
                            else {
                        		
                        		table.setValueAt(null, i, 3);
                        		table.setValueAt(null, i, 5);


                        	}
                        	
    	    		
            	    	}
            	    	
            	    	catch(Exception o) {o.printStackTrace();}
                    	
                    	
                    	
            	        

                   }
                
                
                
                
                
                
                }
                
                catch(Exception f) {f.printStackTrace();}
                
                
                
                
                
                
                
             
           	
            	
     	
          	
            	
            }
        });
         
        
        
        

 
        
        // Adding the mark button
        
        JButton marks = new JButton("Marks");
        marks.setHorizontalAlignment(SwingConstants.CENTER);
        marks.setFocusable(false);
        marks.setFocusTraversalKeysEnabled(false);
        marks.setFocusPainted(false);
        marks.setContentAreaFilled(false);
        marks.setOpaque(false);
        marks.setAlignmentX(Component.RIGHT_ALIGNMENT);
        marks.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        marks.setBorderPainted(false);
        marks.setFont(new Font("Century Gothic", Font.BOLD, 24));
        add(marks);
        marks.setBounds(790, 35, 130, 41);
        
        marks.addMouseListener(new java.awt.event.MouseAdapter() {
            
        	public void mouseEntered(java.awt.event.MouseEvent evt) {
        		marks.setBorderPainted(true);
                marks.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, Color.BLACK)); // Set bottom border
         }
            public void mouseExited(java.awt.event.MouseEvent evt) {
            	marks.setBorderPainted(false);
           }
        }); 
        
        
        
        marks.addActionListener(new ActionListener() { 
            public void actionPerformed(ActionEvent e) {
               
            	// button sound effect
            	try {
                    File soundFile = new File("cursor1.wav");
                    Clip clip = AudioSystem.getClip();
                    clip.open(AudioSystem.getAudioInputStream(soundFile));
                    clip.start();
                    
                  
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            	
            	
            	
                add(btn);
                btn.setBounds(790, 35, 130, 41);
            	
                scrollPane.setVisible(false);
                scrollPane2.setVisible(true);
                scrollPane4.setVisible(false);
                scrollPane3.setVisible(false);

                remove(add_absence);
                remove(show_absences);
            	               
                // revalidate and repaint the panel
                revalidate();
                repaint();

                add(save);
                save.setBounds(400, 805, 395, 40);
            	
            	
       	
            	
            	
            	// ===== get infos  about student from DB
                
                
                
                try {
                	
                	
                	//--- in MODULE table

                	String q1 = "SELECT id_module FROM MODULE WHERE nom_module = ? AND id_Prof = ?";
                	PreparedStatement ps1 = connection.prepareStatement(q1);
                	ps1.setString(1, module.getText());
                	ps1.setString(2, id);

                	ResultSet r1 = ps1.executeQuery();

                	//  retrieve  and store the id value
                	String idModule = null;
                	if (r1.next()) {
                	    idModule = r1.getString("id_module");
                	}

                	
                	
                	
                	
                	
                	// --- in ENSEIGNEMENT table

                	String q2 = "SELECT annee_etude, nom_filliere FROM ENSEIGNEMENT WHERE id_Prof = ?  AND id_module = ?";
                	PreparedStatement ps2 = connection.prepareStatement(q2);
                	ps2.setString(1, id);
                	ps2.setString(2, idModule);

                	ResultSet r2 = ps2.executeQuery();

                	//  retrieve  and store the id value
                	String year = null;
                	String section = null;
                	if (r2.next()) {
                	    year = r2.getString("annee_etude");
                	    section = r2.getString("nom_filliere");
                	}

                	
                	
                	
                	//--- in ETUDIANT table

                	String q3 = "SELECT CNE, nom, prenom FROM ETUDIANT WHERE annee_etude = ? AND nom_filliere = ?";
                	PreparedStatement ps3 = connection.prepareStatement(q3);
                	ps3.setString(1, year);
                	ps3.setString(2, section);

                	ResultSet r3 = ps3.executeQuery();
                	
                	add(scrollPane2);
                	
                	// hide the first table
                    
                	scrollPane.setVisible(false);
                	
                	

                	// Clear all existing rows
                	int rowCount3 = tableModel2.getRowCount();
                	for (int i = rowCount3 - 1; i >= 0; i--) {
                		tableModel2.setValueAt(null, i, 0);
                	    tableModel2.setValueAt(null, i, 1);
                	    tableModel2.setValueAt(null, i, 2);              
                	}
                	
                	 
                	
                	// update the cells
                	
                    int i = 0;
                	while (r3.next() && i < 20) {
                	    // Update the values in the table model
                	    tableModel2.setValueAt(r3.getString("CNE"), i, 0);
                	    tableModel2.setValueAt(r3.getString("nom"), i, 1);
                	    tableModel2.setValueAt(r3.getString("prenom"), i, 2);
                	    i++;
                	}
                	
          
               	
                	
                }
                
                
                catch(Exception e9) {
                	e9.printStackTrace();       	
               }
                
                
                
                
                //----------------------------  set the C1 value in table 2
                
                
                try {
                	
                	
                   for (int i = 0; i < table2.getRowCount(); i++) {
            	        
            	    	try {
            	    		
            	    		
            	    		String cne = (String) table2.getValueAt(i, 0);
            	    		  
                        	//--- in MODULE table

                        	String q1 = "SELECT id_module FROM MODULE WHERE nom_module = ? AND id_Prof = ?";
                        	PreparedStatement ps1 = connection.prepareStatement(q1);
                        	ps1.setString(1, module.getText());
                        	ps1.setString(2, id);

                        	ResultSet r1 = ps1.executeQuery();

                        	//  retrieve  and store the id value
                        	String idModule = null;
                        	if (r1.next()) {
                        	    idModule = r1.getString("id_module");
                        	}
                        	
                        	// check if there is any value for C1
                        	
                        	String q11 = "SELECT COUNT(*) FROM NOTE WHERE CNE=? AND id_module=? AND valeur_note_c1 IS NOT NULL";
                        	PreparedStatement ps11 = connection.prepareStatement(q11);
                        	ps11.setString(1, cne);
                        	ps11.setString(2, idModule);
                        	ResultSet rs = ps11.executeQuery();
                        	rs.next();
                        	int count = rs.getInt(1);
                        	if (count > 0) {
                        		
                        		
                        		// C1 value exists, retrieve and convert it
                                String q12 = "SELECT valeur_note_c1 FROM NOTE WHERE CNE=? AND id_module=?";
                                PreparedStatement ps12 = connection.prepareStatement(q12);
                                ps12.setString(1, cne);
                                ps12.setString(2, idModule);
                                ResultSet rs12 = ps12.executeQuery();
                                rs12.next();
                                
                                // Set the value of the corresponding cell in table2 to the converted value
                                table2.setValueAt(String.valueOf(rs12.getFloat("valeur_note_c1")), i, 3);

                        	} else {
                      
                        		table2.setValueAt(null, i, 3);

                        	}

                   
            	    	}
            	    	
            	    	catch(Exception o) {o.printStackTrace();}
                    	            	        

                   }
                
                           
                
                }
                
                catch(Exception f) {f.printStackTrace();}
                
                
                
               //----------------------------  set the C2 value in table 2
                
                
                try {
                	
                	
                   for (int i = 0; i < table2.getRowCount(); i++) {
            	        
            	    	try {
            	    		
            	    		
            	    		String cne = (String) table2.getValueAt(i, 0);
            	    		  
                        	//--- in MODULE table

                        	String q1 = "SELECT id_module FROM MODULE WHERE nom_module = ? AND id_Prof = ?";
                        	PreparedStatement ps1 = connection.prepareStatement(q1);
                        	ps1.setString(1, module.getText());
                        	ps1.setString(2, id);

                        	ResultSet r1 = ps1.executeQuery();

                        	//  retrieve  and store the id value
                        	String idModule = null;
                        	if (r1.next()) {
                        	    idModule = r1.getString("id_module");
                        	}
                        	
                        	// check if there is any value for C2
                        	
                        	String q11 = "SELECT COUNT(*) FROM NOTE WHERE CNE=? AND id_module=? AND valeur_note_c2 IS NOT NULL";
                        	PreparedStatement ps11 = connection.prepareStatement(q11);
                        	ps11.setString(1, cne);
                        	ps11.setString(2, idModule);
                        	ResultSet rs = ps11.executeQuery();
                        	rs.next();
                        	int count = rs.getInt(1);
                        	if (count > 0) {
                        		
                        		
                        		// C2 value exists, retrieve and convert it
                                String q12 = "SELECT valeur_note_c2 FROM NOTE WHERE CNE=? AND id_module=?";
                                PreparedStatement ps12 = connection.prepareStatement(q12);
                                ps12.setString(1, cne);
                                ps12.setString(2, idModule);
                                ResultSet rs12 = ps12.executeQuery();
                                rs12.next();
                                
                                // Set the value of the corresponding cell in table2 to the converted value
                                table2.setValueAt(String.valueOf(rs12.getFloat("valeur_note_c2")), i, 4);

                        	} else {
                        		
                        		
                        		table2.setValueAt(null, i, 4);

                            	

                        	}

                        	
            	    		
            	    		
            	    	}
            	    	
            	    	catch(Exception o) {o.printStackTrace();}
                    	
                    	
                    	
            	        

                   }
                
                
                
                
                
                
                }
                
                catch(Exception f) {f.printStackTrace();}
                
                
                
                
               //----------------------------  set the tp value in table 2
                
                
                try {
                	
                	
                   for (int i = 0; i < table2.getRowCount(); i++) {
            	        
            	    	try {
            	    		
            	    		
            	    		String cne = (String) table2.getValueAt(i, 0);
            	    		  
                        	//--- in MODULE table

                        	String q1 = "SELECT id_module FROM MODULE WHERE nom_module = ? AND id_Prof = ?";
                        	PreparedStatement ps1 = connection.prepareStatement(q1);
                        	ps1.setString(1, module.getText());
                        	ps1.setString(2, id);

                        	ResultSet r1 = ps1.executeQuery();

                        	//  retrieve  and store the id value
                        	String idModule = null;
                        	if (r1.next()) {
                        	    idModule = r1.getString("id_module");
                        	}
                        	
                        	// check if there is any value for tp
                        	
                        	String q11 = "SELECT COUNT(*) FROM NOTE WHERE CNE=? AND id_module=? AND valeur_note_tp IS NOT NULL";
                        	PreparedStatement ps11 = connection.prepareStatement(q11);
                        	ps11.setString(1, cne);
                        	ps11.setString(2, idModule);
                        	ResultSet rs = ps11.executeQuery();
                        	rs.next();
                        	int count = rs.getInt(1);
                        	if (count > 0) {
                        		
                        		
                        		// tp value exists, retrieve and convert it
                                String q12 = "SELECT valeur_note_tp FROM NOTE WHERE CNE=? AND id_module=?";
                                PreparedStatement ps12 = connection.prepareStatement(q12);
                                ps12.setString(1, cne);
                                ps12.setString(2, idModule);
                                ResultSet rs12 = ps12.executeQuery();
                                rs12.next();
                                
                                // Set the value of the corresponding cell in table2 to the converted value
                                table2.setValueAt(String.valueOf(rs12.getFloat("valeur_note_tp")), i, 5);

                        	} else {
                        		
                        		
                        		table2.setValueAt(null, i, 5);

                            	

                        	}

                        	
            	    		
            	    		
            	    	}
            	    	
            	    	catch(Exception o) {o.printStackTrace();}
                    	
                    	
                    	
            	        

                   }
                
                
                
                
                
                
                }
                
                catch(Exception f) {f.printStackTrace();}
                
                
                //----------------------------  set the project value in table 2
                
                
                try {
                	
                	
                   for (int i = 0; i < table2.getRowCount(); i++) {
            	        
            	    	try {
            	    		
            	    		
            	    		String cne = (String) table2.getValueAt(i, 0);
            	    		  
                        	//--- in MODULE table

                        	String q1 = "SELECT id_module FROM MODULE WHERE nom_module = ? AND id_Prof = ?";
                        	PreparedStatement ps1 = connection.prepareStatement(q1);
                        	ps1.setString(1, module.getText());
                        	ps1.setString(2, id);

                        	ResultSet r1 = ps1.executeQuery();

                        	//  retrieve  and store the id value
                        	String idModule = null;
                        	if (r1.next()) {
                        	    idModule = r1.getString("id_module");
                        	}
                        	
                        	// check if there is any value for project
                        	
                        	String q11 = "SELECT COUNT(*) FROM NOTE WHERE CNE=? AND id_module=? AND valeur_note_projet IS NOT NULL";
                        	PreparedStatement ps11 = connection.prepareStatement(q11);
                        	ps11.setString(1, cne);
                        	ps11.setString(2, idModule);
                        	ResultSet rs = ps11.executeQuery();
                        	rs.next();
                        	int count = rs.getInt(1);
                        	if (count > 0) {
                        		
                        		
                        		// project value exists, retrieve and convert it
                                String q12 = "SELECT valeur_note_projet FROM NOTE WHERE CNE=? AND id_module=?";
                                PreparedStatement ps12 = connection.prepareStatement(q12);
                                ps12.setString(1, cne);
                                ps12.setString(2, idModule);
                                ResultSet rs12 = ps12.executeQuery();
                                rs12.next();
                                
                                // Set the value of the corresponding cell in table2 to the converted value
                                table2.setValueAt(String.valueOf(rs12.getFloat("valeur_note_projet")), i, 6);

                        	} else {
                        		
                        		
                        		table2.setValueAt(null, i, 6);

                            	

                        	}

                        	
            	    		
            	    		
            	    	}
            	    	
            	    	catch(Exception o) {o.printStackTrace();}
                    	
                    	
                    	
            	        

                   }
                
                
                
                
                
                
                }
                
                catch(Exception f) {f.printStackTrace();}
                
                
                 
        	
            	
            }
        });
         
        

 
        
        
        
        // absences button action
        
        absences.addActionListener(new ActionListener() { 
            public void actionPerformed(ActionEvent e) {
               
            	
            	
            	
            	remove(save);
            	
            	// revalidate and repaint the panel
                revalidate();
                repaint();
                
              
            	
            }
        });
        
        
        
        
       
        
      
        
    
  
        
        
       

       
        
        
        
        
        
        
        
        
        
        
  
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
    }
    
    
    
 
}

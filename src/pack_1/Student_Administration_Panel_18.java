package pack_1;

import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.util.Arrays;
import java.awt.event.KeyEvent;
import java.awt.geom.RoundRectangle2D;
import java.io.File;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.awt.event.KeyAdapter;
import java.awt.*;
import javax.swing.border.Border;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Student_Administration_Panel_18 extends JPanel {

    private Image backgroundImage;

    public Student_Administration_Panel_18() {
        
    	
        
    	//establish the connection
        
    	Connection connection = DatabaseConnection.getConnection();

        
        //--------------------------------------------------------------------------------------------
    	
    	
    	
    	
    	
    	
    	setLayout(null);
        
    	//setBackground(Color.decode("#d0efff"));
    	
        // Setting the background image
        
    	setOpaque(false);
        ImageIcon icon = new ImageIcon("background2.png");
        backgroundImage = icon.getImage();
        
  
        
        // ------- Adding a Return  Button
        
        JButton btnReturn = new JButton("<<");
        
        btnReturn.setFocusable(false);
        btnReturn.setFocusTraversalKeysEnabled(false);
        btnReturn.setFocusPainted(false);
        btnReturn.setContentAreaFilled(false);
        btnReturn.setOpaque(false);
        btnReturn.setAlignmentX(Component.RIGHT_ALIGNMENT);
        btnReturn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        btnReturn.setBorderPainted(false);
        btnReturn.setFont(new Font("Century Gothic", Font.BOLD, 20));
        btnReturn.setBounds(19, 20, 60, 23);
        add(btnReturn);
        
        btnReturn.addActionListener(new ActionListener() {
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
            	
            	
            	
            	// open Administration_Panel_15
                SwingUtilities.invokeLater(new Runnable() {
                    public void run() {
                        // create an instance of Administration_Panel_15
                    	Administration_Panel_15 panel = new Administration_Panel_15();
                        
                        // add Administration_Panel_15 to the window
                        JFrame window = (JFrame)SwingUtilities.getWindowAncestor(Student_Administration_Panel_18.this);
                        window.add(panel);
                        
                        // remove Professor_Administration_Panel_14 from the window
                        window.remove(Student_Administration_Panel_18.this);
                        
                        // refresh the window
                        window.revalidate();
                        window.repaint();
                    }
                });
            }
        });
        
        
        
               
          
        
        // adding a text -- adding a JLabel -- first name
        
        JLabel label2 = new JLabel("First Name");
        label2.setFont(new Font("Century Gothic", Font.BOLD, 20));
        label2.setForeground(Color.decode("#6495ED"));
        label2.setBounds(210, 155, 200, 30);
        label2.setHorizontalAlignment(SwingConstants.LEFT);
        add(label2);
        
               
        // adding the first name text field
        
        JTextField first_student = new JTextField();
        first_student.setCursor(Cursor.getPredefinedCursor(Cursor.TEXT_CURSOR));
        first_student.setHorizontalAlignment(SwingConstants.LEFT);
        first_student.setForeground(new Color(0, 0, 0));
        first_student.setFont(new Font("Arial", Font.PLAIN, 19));
        first_student.setBounds(210, 188, 450, 40);
        first_student.setColumns(10);
        add(first_student);
        Border border = BorderFactory.createLineBorder(Color.decode("#BCD3E7"), 3);
        first_student.setBorder(border);

        
        
        
         
        // adding a text -- adding a JLabel -- second name
        
        JLabel label3 = new JLabel("Second Name");
        label3.setFont(new Font("Century Gothic", Font.BOLD, 20));
        label3.setForeground(Color.decode("#6495ED"));
        label3.setBounds(210, 229, 200, 30);
        label3.setHorizontalAlignment(SwingConstants.LEFT);
        add(label3);
        
               
        // adding the second name text field
        
        JTextField second_student = new JTextField();
        second_student.setCursor(Cursor.getPredefinedCursor(Cursor.TEXT_CURSOR));
        second_student.setHorizontalAlignment(SwingConstants.LEFT);
        second_student.setForeground(new Color(0, 0, 0));
        second_student.setFont(new Font("Arial", Font.PLAIN, 19));
        second_student.setBounds(210, 262, 450, 40);
        second_student.setColumns(10);
        add(second_student); 
        second_student.setBorder(border);

        
         
        
        
        // adding a text -- adding a JLabel -- Email adress
        
        JLabel label4 = new JLabel("E-mail Adress");
        label4.setFont(new Font("Century Gothic", Font.BOLD, 20));
        label4.setForeground(Color.decode("#6495ED"));
        label4.setBounds(210, 302, 200, 30);
        label4.setHorizontalAlignment(SwingConstants.LEFT);
        add(label4);
        
               
        // adding the email adress text field
        
        JTextField email_student = new JTextField();
        email_student.setCursor(Cursor.getPredefinedCursor(Cursor.TEXT_CURSOR));
        email_student.setHorizontalAlignment(SwingConstants.LEFT);
        email_student.setForeground(new Color(0, 0, 0));
        email_student.setFont(new Font("Arial", Font.PLAIN, 19));
        email_student.setBounds(210, 334, 450, 40);
        email_student.setColumns(10);
        add(email_student);
        email_student.setBorder(border);

         
        
        
      
        // adding a text -- adding a JLabel -- CNE
        
        JLabel label555 = new JLabel("CNE");
        label555.setFont(new Font("Century Gothic", Font.BOLD, 20));
        label555.setForeground(Color.decode("#6495ED"));
        label555.setBounds(210, 379, 200, 30);
        label555.setHorizontalAlignment(SwingConstants.LEFT);
        add(label555);
        
               
        // adding the professor CNE text field
        
        JTextField CNE = new JTextField();
        CNE.setCursor(Cursor.getPredefinedCursor(Cursor.TEXT_CURSOR));
        CNE.setHorizontalAlignment(SwingConstants.LEFT);
        CNE.setForeground(new Color(0, 0, 0));
        CNE.setFont(new Font("Arial", Font.PLAIN, 19));
        CNE.setBounds(210, 411, 450, 40);
        CNE.setColumns(10);
        add(CNE);
        CNE.setBorder(border);

        
        
        // adding a text -- adding a JLabel -- cin
        
        JLabel label66 = new JLabel("CIN");
        label66.setFont(new Font("Century Gothic", Font.BOLD, 20));
        label66.setForeground(Color.decode("#6495ED"));
        label66.setBounds(210, 455, 200, 30);
        label66.setHorizontalAlignment(SwingConstants.LEFT);
        add(label66);
        
               
        // adding the cin text field
        
        JTextField cin_student = new JTextField();
        cin_student.setCursor(Cursor.getPredefinedCursor(Cursor.TEXT_CURSOR));
        cin_student.setHorizontalAlignment(SwingConstants.LEFT);
        cin_student.setForeground(new Color(0, 0, 0));
        cin_student.setFont(new Font("Arial", Font.PLAIN, 19));
        cin_student.setBounds(210, 487, 450, 40);
        cin_student.setColumns(10);
        add(cin_student);
        cin_student.setBorder(border);

       
        
        // adding a text -- adding a JLabel -- number
        
        JLabel label888 = new JLabel("Phone Number");
        label888.setFont(new Font("Century Gothic", Font.BOLD, 20));
        label888.setForeground(Color.decode("#6495ED"));
        label888.setBounds(810, 155, 200, 30);
        label888.setHorizontalAlignment(SwingConstants.LEFT);
        add(label888);
       
     
        
        // adding number text field
        
        JTextField number_student = new JTextField();
        number_student.setForeground(new Color(0, 0, 0));
        number_student.setFont(new Font("Arial", Font.PLAIN, 19));
        number_student.setBounds(810, 188, 450, 40);
        add(number_student); 
        number_student.setBorder(border);


    
        
       
        
        // Adding the confirm button
        
        JButton confirm_student = new JButton() { 
            @Override
            protected void paintComponent(Graphics g) {
                Graphics2D g2 = (Graphics2D) g;
                g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

                // Define the rounded rectangle shape
                Shape shape = new RoundRectangle2D.Float(0, 0, getWidth(), getHeight(), 20, 20);
                
                // Fill the shape with the gradient paint
                GradientPaint gradient = new GradientPaint(0, 0, Color.BLUE, getWidth(), getHeight(), Color.GREEN);
                g2.setPaint(gradient);
                g2.fill(shape);

                super.paintComponent(g); 
            }
        };

        // Set the button text and style
        confirm_student.setText("confirm");
        confirm_student.setHorizontalTextPosition(SwingConstants.CENTER);
        confirm_student.setForeground(new Color(255, 255, 255));
        confirm_student.setFont(new Font("consolas", Font.BOLD, 30));
        confirm_student.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        // Remove the default button styles
        confirm_student.setBorderPainted(false);
        confirm_student.setFocusPainted(false);
        confirm_student.setContentAreaFilled(false);
        confirm_student.setOpaque(false);

        // Set the button size and position
        confirm_student.setBounds(810, 487,450,40);

        // Add the button to your container
        add(confirm_student);
		
   
  
        
        
        
        
        
        
        
        
        
        
        
        
        
        // adding a text -- adding a JLabel -- section
        
        JLabel label8 = new JLabel("Section");
        label8.setFont(new Font("Century Gothic", Font.BOLD, 20));
        label8.setForeground(Color.decode("#6495ED"));
        label8.setBounds(810, 302, 200, 30);
        label8.setHorizontalAlignment(SwingConstants.LEFT);
        add(label8);
         
               
        // adding the section text field
        
        JTextField section_student = new JTextField();
        section_student.setCursor(Cursor.getPredefinedCursor(Cursor.TEXT_CURSOR));
        section_student.setHorizontalAlignment(SwingConstants.LEFT);
        section_student.setForeground(new Color(0, 0, 0));
        section_student.setFont(new Font("Arial", Font.PLAIN, 19));
        section_student.setBounds(810, 334, 450, 40);
        section_student.setColumns(10);
        add(section_student);
        section_student.setBorder(border);

        
               
   
        
        // adding a text -- adding a JLabel -- department
        
        JLabel label7 = new JLabel("Department");
        label7.setFont(new Font("Century Gothic", Font.BOLD, 20));
        label7.setForeground(Color.decode("#6495ED"));
        label7.setBounds(810, 229, 200, 30);
        label7.setHorizontalAlignment(SwingConstants.LEFT);
        add(label7);
        
        
        // adding the department text field
        
        JTextField department_student = new JTextField();
        department_student.setForeground(new Color(0, 0, 0));
        department_student.setFont(new Font("Arial", Font.PLAIN, 19));
        department_student.setBounds(810, 262, 450, 40);
        add(department_student);
        department_student.setBorder(border);


        // Create a list of department options
        String[] departmentOptions = {"Mathématiques et Informatique", "Génie Electrique", "Réseaux et Télécommunications", "Génie des Procédés"};

        // Create the section combo box but don't add it to the panel yet
        JComboBox<String> departmentComboBox = new JComboBox<>(departmentOptions);
        departmentComboBox.setBounds(810, 300, 450, 40);
        departmentComboBox.setBackground(Color.decode("#F3FAFD"));
        departmentComboBox.setFont(new Font("Arial", Font.PLAIN, 18));
        departmentComboBox.setRenderer(new DefaultListCellRenderer() {
            public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
                JLabel label = (JLabel) super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
                label.setBackground(isSelected ? Color.decode("#C9E9F6") : Color.decode("#F3FAFD"));
                return label;
            }
        });

        
        
        
        
        
        
        
        
        
        
        
        
        // Add a key listener to the text field to show/hide the combo box as needed
        department_student.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                if (department_student.getText().isEmpty()) {
                    label8.setVisible(true);
                	remove(departmentComboBox);
                    revalidate();
                    repaint();
                } else {
                	
                    if (!Arrays.asList(getComponents()).contains(departmentComboBox)) {
                        label8.setVisible(false);
                    	add(departmentComboBox);
                        revalidate();
                        repaint();
                    }
                }
            }
        });

        // Add a listener to the combo box to update the text field with the selected option
        departmentComboBox.addActionListener(e -> {
            String selectedOption = (String) departmentComboBox.getSelectedItem();
            department_student.setText(selectedOption);
            remove(departmentComboBox);
            label8.setVisible(true);
            revalidate();
            repaint();
        });
        
        
        
        
        
        
        // adding a text -- adding a JLabel -- year
        
        JLabel label5 = new JLabel("Year");
        label5.setFont(new Font("Century Gothic", Font.BOLD, 20));
        label5.setForeground(Color.decode("#6495ED"));
        label5.setBounds(810, 379, 200, 30);
        label5.setHorizontalAlignment(SwingConstants.LEFT);
        add(label5);
        
        
        // ----------------- sections options
        
       

        // ===== Create a list of section options for Mathématiques et Informatique department
        
        
        
        String[] section1Options = {"Informatique et Ingénieurie des Données", "Génie Informatique"};

        // Create the section combo box but don't add it to the panel yet
        JComboBox<String> section1ComboBox = new JComboBox<>(section1Options);
        section1ComboBox.setBounds(810, 372, 450, 40);
        section1ComboBox.setBackground(Color.decode("#F3FAFD"));
        section1ComboBox.setFont(new Font("Arial", Font.PLAIN, 18));
        section1ComboBox.setRenderer(new DefaultListCellRenderer() {
            public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
                JLabel label = (JLabel) super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
                label.setBackground(isSelected ? Color.decode("#C9E9F6") : Color.decode("#F3FAFD"));
                return label;
            }
        });

 
        
        // Add a key listener to the text field to show/hide the combo box as needed
        section_student.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
            	
            	
            	String dep = department_student.getText();
            	
            	if (dep.equals("Mathématiques et Informatique")) {
            		
            		if (section_student.getText().isEmpty()) {
                        label5.setVisible(true);
                    	remove(section1ComboBox);
                        revalidate();
                        repaint();
                    } else {
                    	
                        if (!Arrays.asList(getComponents()).contains(section1ComboBox)) {
                            label5.setVisible(false);
                        	add(section1ComboBox);
                            revalidate();
                            repaint();
                        }
                    }
            		           		
            	}
 
            }
        });
        

        
        // Add a listener to the combo box to update the text field with the selected option
        section1ComboBox.addActionListener(e -> {
            String selectedOption = (String) section1ComboBox.getSelectedItem();
            section_student.setText(selectedOption);
            remove(section1ComboBox);
            label5.setVisible(true);
            revalidate();
            repaint();
        });
        
        

        
        
        
        // ===== Create a list of section options for Génie Electrique department
        
        
        String[] section2Options = {"Génie Electrique"};
        
        // Create the section combo box but don't add it to the panel yet
        JComboBox<String> section2ComboBox = new JComboBox<>(section2Options);
        section2ComboBox.setBounds(810, 372, 450, 40);
        section2ComboBox.setBackground(Color.decode("#F3FAFD"));
        section2ComboBox.setFont(new Font("Arial", Font.PLAIN, 18));
        section2ComboBox.setRenderer(new DefaultListCellRenderer() {
            public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
                JLabel label = (JLabel) super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
                label.setBackground(isSelected ? Color.decode("#C9E9F6") : Color.decode("#F3FAFD"));
                return label;
            }
        });
 
        
        // Add a key listener to the text field to show/hide the combo box as needed
        section_student.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
            	
            	
            	String dep2 = department_student.getText();
            	
            	if (dep2.equals("Génie Electrique")) {
            		
            		if (section_student.getText().isEmpty()) {
                        label5.setVisible(true);
                    	remove(section2ComboBox);
                        revalidate();
                        repaint();
                    } else {
                    	
                        if (!Arrays.asList(getComponents()).contains(section2ComboBox)) {
                            label5.setVisible(false);
                        	add(section2ComboBox);
                            revalidate();
                            repaint();
                        }
                    }
            		           		
            	}
 
            }
        });
        

        
        // Add a listener to the combo box to update the text field with the selected option
        section2ComboBox.addActionListener(e -> {
            String selectedOption = (String) section2ComboBox.getSelectedItem();
            section_student.setText(selectedOption);
            remove(section2ComboBox);
            label5.setVisible(true);
            revalidate();
            repaint();
        });
        
        

        

         // ===== Create a list of section options for Réseaux et Télécommunications department
        
        
        String[] section3Options = {"Ingénierie des Réseaux Intelligents et Cybersécurité","Génie Réseaux et Télécomunications"};

        // Create the section combo box but don't add it to the panel yet
        JComboBox<String> section3ComboBox = new JComboBox<>(section3Options);
        section3ComboBox.setBounds(810, 372, 450, 40);
        section3ComboBox.setBackground(Color.decode("#F3FAFD"));
        section3ComboBox.setFont(new Font("Arial", Font.PLAIN, 18));
        section3ComboBox.setRenderer(new DefaultListCellRenderer() {
            public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
                JLabel label = (JLabel) super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
                label.setBackground(isSelected ? Color.decode("#C9E9F6") : Color.decode("#F3FAFD"));
                return label;
            }
        });
        
        

        
        // Add a key listener to the text field to show/hide the combo box as needed
        section_student.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
            	
            	
            	String dep3 = department_student.getText();
            	
            	if (dep3.equals("Réseaux et Télécommunications")) {
            		
            		if (section_student.getText().isEmpty()) {
                        label5.setVisible(true);
                    	remove(section3ComboBox);
                        revalidate();
                        repaint();
                    } else {
                    	
                        if (!Arrays.asList(getComponents()).contains(section3ComboBox)) {
                            label5.setVisible(false);
                        	add(section3ComboBox);
                            revalidate();
                            repaint();
                        }
                    }
            		           		
            	}
 
            }
        });
        

        
        
        // Add a listener to the combo box to update the text field with the selected option
        section3ComboBox.addActionListener(e -> {
            String selectedOption = (String) section3ComboBox.getSelectedItem();
            section_student.setText(selectedOption);
            remove(section3ComboBox);
            label5.setVisible(true);
            revalidate();
            repaint();
        });
        
        
        
  
        
       // ===== Create a list of section options for Génie des Procédés department
        
        
        String[] section4Options = {"Génie des Procédés, de l'Energie et de l'Environnement"};

        // Create the section combo box but don't add it to the panel yet
        JComboBox<String> section4ComboBox = new JComboBox<>(section4Options);
        section4ComboBox.setBounds(810, 372, 450, 40);
        section4ComboBox.setBackground(Color.decode("#F3FAFD"));
        section4ComboBox.setFont(new Font("Arial", Font.PLAIN, 18));
        section4ComboBox.setRenderer(new DefaultListCellRenderer() {
            public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
                JLabel label = (JLabel) super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
                label.setBackground(isSelected ? Color.decode("#C9E9F6") : Color.decode("#F3FAFD"));
                return label;
            }
        });
        
        
      
        
        // Add a key listener to the text field to show/hide the combo box as needed
        section_student.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
            	
            	
            	String dep4 = department_student.getText();
            	
            	if (dep4.equals("Génie des Procédés")) {
            		
            		if (section_student.getText().isEmpty()) {
                        label5.setVisible(true);
                    	remove(section4ComboBox);
                        revalidate();
                        repaint();
                    } else {
                    	
                        if (!Arrays.asList(getComponents()).contains(section4ComboBox)) {
                            label5.setVisible(false);
                        	add(section4ComboBox);
                            revalidate();
                            repaint();
                        }
                    }
            		           		
            	}
 
            }
        });
        

        
        // Add a listener to the combo box to update the text field with the selected option
        section4ComboBox.addActionListener(e -> {
            String selectedOption = (String) section4ComboBox.getSelectedItem();
            section_student.setText(selectedOption);
            remove(section4ComboBox);
            label5.setVisible(true);
            revalidate();
            repaint();
        });
        
        
        
        
        
        
        
        // adding the year text field
        
        JTextField year_student = new JTextField();
        year_student.setCursor(Cursor.getPredefinedCursor(Cursor.TEXT_CURSOR));
        year_student.setHorizontalAlignment(SwingConstants.LEFT);
        year_student.setForeground(new Color(0, 0, 0)); 
        year_student.setFont(new Font("Arial", Font.PLAIN, 19));
        year_student.setBounds(810, 411, 450, 40);
        year_student.setColumns(10);
        add(year_student);
        year_student.setBorder(border);

         
        
        
        JLabel label6 = new JLabel() ;

        // Create a list of year options
        String[] year1Options = {"First", "Second", "Third"};

        // Create the section combo box but don't add it to the panel yet
        JComboBox<String> year1ComboBox = new JComboBox<>(year1Options);
        year1ComboBox.setBounds(810, 447, 450, 40);
        year1ComboBox.setBackground(Color.decode("#F3FAFD"));
        year1ComboBox.setFont(new Font("Arial", Font.PLAIN, 18));
        year1ComboBox.setRenderer(new DefaultListCellRenderer() {
            public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
                JLabel label = (JLabel) super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
                label.setBackground(isSelected ? Color.decode("#C9E9F6") : Color.decode("#F3FAFD"));
                return label;
            }
        });

        
      
        
        // Add a key listener to the text field to show/hide the combo box as needed
        year_student.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                if (year_student.getText().isEmpty()) {
                    label6.setVisible(true);
                	remove(year1ComboBox);
                    revalidate();
                    repaint();
                } else {
                	
                    if (!Arrays.asList(getComponents()).contains(year1ComboBox)) {
                        label6.setVisible(false);
                    	add(year1ComboBox);
                        revalidate();
                        repaint();
                    }
                }
            }
        });

        // Add a listener to the combo box to update the text field with the selected option
        year1ComboBox.addActionListener(e -> {
            String selectedOption = (String) year1ComboBox.getSelectedItem();
            year_student.setText(selectedOption);
            remove(year1ComboBox);
            label6.setVisible(true);
            revalidate();
            repaint();
        });
        
        
       
        
        // ----------  confirm button action
        
        
        
        confirm_student.addActionListener(new ActionListener() {
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
                	
                	

        	    	// ======Prepare the insert statement for student
            	    
            		String insertStudentQuery = "INSERT INTO ETUDIANT (CNE, nom, prenom, email, code_CIN, numero_telephone, departement,annee_etude,nom_filliere) "
            	            + "VALUES (?, ?, ?, ?, ?, ?, ?,?,?)";
            	    PreparedStatement insertStudentStatement = connection.prepareStatement(insertStudentQuery);

            	    // Set the parameter values for professor
            	    insertStudentStatement.setString(1, CNE.getText());
            	    insertStudentStatement.setString(2, first_student.getText());
            	    insertStudentStatement.setString(3, second_student.getText()); 
            	    insertStudentStatement.setString(4, email_student.getText());
            	    insertStudentStatement.setString(5, cin_student.getText());
            	    insertStudentStatement.setString(6, number_student.getText());
            	    insertStudentStatement.setString(7, department_student.getText());
            	    insertStudentStatement.setString(8, year_student.getText());
            	    insertStudentStatement.setString(9, section_student.getText());


            	    // Execute the insert statement for professor
            	    int rowsInserted1 = insertStudentStatement.executeUpdate();
                	
            	    
            	    CNE.setText("");
            	    first_student.setText("");
            	    second_student.setText("");
            	    email_student.setText("");
            	    cin_student.setText("");
            	    number_student.setText("");
            	    department_student.setText("");
            	    year_student.setText("");
            	    section_student.setText("");


            	    
                	
                }
            	
            	catch (Exception es){
            		
            		es.printStackTrace();
            	}
            	
            	
            	
            	
            	
                   	
            	
    	
            	
           	
            	
            }
        });
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        

 
    
    
    
    
    
    
    
    
    
    
    
    }
    
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);

    }

   
    
      

}

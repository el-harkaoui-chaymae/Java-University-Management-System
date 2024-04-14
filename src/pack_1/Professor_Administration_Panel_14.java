package pack_1;

import java.util.Arrays;
import java.awt.event.KeyEvent;
import java.awt.geom.RoundRectangle2D;
import java.io.File;
import java.awt.event.KeyAdapter;
import java.awt.*;
import javax.swing.border.Border;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.*;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.*;




public class Professor_Administration_Panel_14 extends JPanel {

    private Image backgroundImage;

    public Professor_Administration_Panel_14() {
        
    	
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
                        JFrame window = (JFrame)SwingUtilities.getWindowAncestor(Professor_Administration_Panel_14.this);
                        window.add(panel);
                        
                        // remove Professor_Administration_Panel_14 from the window
                        window.remove(Professor_Administration_Panel_14.this);
                        
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
        
        JTextField first = new JTextField();
        first.setCursor(Cursor.getPredefinedCursor(Cursor.TEXT_CURSOR));
        first.setHorizontalAlignment(SwingConstants.LEFT);
        first.setForeground(new Color(0, 0, 0));
        first.setFont(new Font("Arial", Font.PLAIN, 19));
        first.setBounds(210, 188, 450, 40);
        first.setColumns(10);
        add(first); 
       
        Border border = BorderFactory.createLineBorder(Color.decode("#BCD3E7"), 3);
        first.setBorder(border);
        
        
   
        
        
        
        
        // adding a text -- adding a JLabel -- second name
        
        JLabel label3 = new JLabel("Second Name");
        label3.setFont(new Font("Century Gothic", Font.BOLD, 20));
        label3.setForeground(Color.decode("#6495ED"));
        label3.setBounds(210, 229, 200, 30);
        label3.setHorizontalAlignment(SwingConstants.LEFT);
        add(label3);
        
               
        // adding the second name text field
        
        JTextField second = new JTextField();
        second.setCursor(Cursor.getPredefinedCursor(Cursor.TEXT_CURSOR));
        second.setHorizontalAlignment(SwingConstants.LEFT);
        second.setForeground(new Color(0, 0, 0));
        second.setFont(new Font("Arial", Font.PLAIN, 19));
        second.setBounds(210, 262, 450, 40);
        second.setColumns(10);
        add(second);
        second.setBorder(border);

        
        
        
        
        // adding a text -- adding a JLabel -- Email adress
        
        JLabel label4 = new JLabel("E-mail Adress");
        label4.setFont(new Font("Century Gothic", Font.BOLD, 20));
        label4.setForeground(Color.decode("#6495ED"));
        label4.setBounds(210, 302, 200, 30);
        label4.setHorizontalAlignment(SwingConstants.LEFT);
        add(label4);
        
               
        // adding the email adress text field
        
        JTextField email = new JTextField();
        email.setCursor(Cursor.getPredefinedCursor(Cursor.TEXT_CURSOR));
        email.setHorizontalAlignment(SwingConstants.LEFT);
        email.setForeground(new Color(0, 0, 0));
        email.setFont(new Font("Arial", Font.PLAIN, 19));
        email.setBounds(210, 334, 450, 40);
        email.setColumns(10);
        add(email);
        email.setBorder(border);

        
        
        
      
        // adding a text -- adding a JLabel -- professor identifier
        
        JLabel label555 = new JLabel("Professor Identifier");
        label555.setFont(new Font("Century Gothic", Font.BOLD, 20));
        label555.setForeground(Color.decode("#6495ED"));
        label555.setBounds(210, 379, 200, 30);
        label555.setHorizontalAlignment(SwingConstants.LEFT);
        add(label555);
        
               
        // adding the professor identifier text field
        
        JTextField prof_id = new JTextField();
        prof_id.setCursor(Cursor.getPredefinedCursor(Cursor.TEXT_CURSOR));
        prof_id.setHorizontalAlignment(SwingConstants.LEFT);
        prof_id.setForeground(new Color(0, 0, 0));
        prof_id.setFont(new Font("Arial", Font.PLAIN, 19));
        prof_id.setBounds(210, 411, 450, 40);
        prof_id.setColumns(10);
        add(prof_id);
        prof_id.setBorder(border);

        
        
        
        
        // adding a text -- adding a JLabel -- cin
        
        JLabel label66 = new JLabel("CIN");
        label66.setFont(new Font("Century Gothic", Font.BOLD, 20));
        label66.setForeground(Color.decode("#6495ED"));
        label66.setBounds(210, 455, 200, 30);
        label66.setHorizontalAlignment(SwingConstants.LEFT);
        add(label66);
        
               
        // adding the cin text field
        
        JTextField cin = new JTextField();
        cin.setCursor(Cursor.getPredefinedCursor(Cursor.TEXT_CURSOR));
        cin.setHorizontalAlignment(SwingConstants.LEFT);
        cin.setForeground(new Color(0, 0, 0));
        cin.setFont(new Font("Arial", Font.PLAIN, 19));
        cin.setBounds(210, 487, 450, 40);
        cin.setColumns(10);
        add(cin);
        cin.setBorder(border);

        
       
        
        // adding a text -- adding a JLabel -- number
        
        JLabel label888 = new JLabel("Phone Number");
        label888.setFont(new Font("Century Gothic", Font.BOLD, 20));
        label888.setForeground(Color.decode("#6495ED"));
        label888.setBounds(210, 531, 200, 30);
        label888.setHorizontalAlignment(SwingConstants.LEFT);
        add(label888);
       
     
        
        // adding number text field
        
        JTextField number = new JTextField();
        number.setForeground(new Color(0, 0, 0));
        number.setFont(new Font("Arial", Font.PLAIN, 19));
        number.setBounds(210, 563, 450, 40);
        add(number); 
        number.setBorder(border);


    
        
       
        
        // Adding the confirm button
        
        
        JButton confirm = new JButton() {
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
        confirm.setText("confirm");
        confirm.setHorizontalTextPosition(SwingConstants.CENTER);
        confirm.setForeground(new Color(255, 255, 255));
        confirm.setFont(new Font("consolas", Font.BOLD, 30));
        confirm.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        // Remove the default button styles
        confirm.setBorderPainted(false);
        confirm.setFocusPainted(false);
        confirm.setContentAreaFilled(false);
        confirm.setOpaque(false);

        // Set the button size and position
        confirm.setBounds(810, 563,450,40);

        // Add the button to your container
        add(confirm);

        
        confirm.addActionListener(new ActionListener() {
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
           	
            	
                
           	
            	
            }
        });
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        // adding a text -- adding a JLabel -- sections
        
        JLabel label8 = new JLabel("Section");
        label8.setFont(new Font("Century Gothic", Font.BOLD, 20));
        label8.setForeground(Color.decode("#6495ED"));
        label8.setBounds(810, 229, 200, 30);
        label8.setHorizontalAlignment(SwingConstants.LEFT);
        add(label8);
         
               
        // adding the section text field
        
        JTextField section = new JTextField();
        section.setCursor(Cursor.getPredefinedCursor(Cursor.TEXT_CURSOR));
        section.setHorizontalAlignment(SwingConstants.LEFT);
        section.setForeground(new Color(0, 0, 0));
        section.setFont(new Font("Arial", Font.PLAIN, 19));
        section.setBounds(810, 262, 450, 40);
        section.setColumns(10);
        add(section);
        section.setBorder(border);

        
               
  
        
        // adding a text -- adding a JLabel -- department
        
        JLabel label7 = new JLabel("Department");
        label7.setFont(new Font("Century Gothic", Font.BOLD, 20));
        label7.setForeground(Color.decode("#6495ED"));
        label7.setBounds(810, 155, 200, 30);
        label7.setHorizontalAlignment(SwingConstants.LEFT);
        add(label7);
        
        
        // adding the department text field
        
        JTextField department = new JTextField();
        department.setForeground(new Color(0, 0, 0));
        department.setFont(new Font("Arial", Font.PLAIN, 19));
        department.setBounds(810, 188, 450, 40);
        add(department);
        department.setBorder(border);
  
        

        // Create a list of department options
        String[] departmentOptions = {"Mathématiques et Informatique", "Génie Electrique", "Réseaux et Télécommunications", "Génie des Procédés"};

        // Create the section combo box but don't add it to the panel yet
        JComboBox<String> departmentComboBox = new JComboBox<>(departmentOptions);
        departmentComboBox.setBounds(810, 226, 450, 40);
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
        department.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                if (department.getText().isEmpty()) {
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
            department.setText(selectedOption);
            remove(departmentComboBox);
            label8.setVisible(true);
            revalidate();
            repaint();
        });
        
        
        
        
        
        
        // adding a text -- adding a JLabel -- year
        
        JLabel label5 = new JLabel("Year");
        label5.setFont(new Font("Century Gothic", Font.BOLD, 20));
        label5.setForeground(Color.decode("#6495ED"));
        label5.setBounds(810, 302, 200, 30);
        label5.setHorizontalAlignment(SwingConstants.LEFT);
        add(label5);
        
        
        // ----------------- sections options
        
       

        // ===== Create a list of section options for Mathématiques et Informatique department
        
        
        
        String[] section1Options = {"Informatique et Ingénieurie des Données", "Génie Informatique"};

        // Create the section combo box but don't add it to the panel yet
        JComboBox<String> section1ComboBox = new JComboBox<>(section1Options);
        section1ComboBox.setBounds(810, 300, 450, 40);
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
        section.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
            	
            	
            	String dep = department.getText();
            	
            	if (dep.equals("Mathématiques et Informatique")) {
            		
            		if (section.getText().isEmpty()) {
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
            section.setText(selectedOption);
            remove(section1ComboBox);
            label5.setVisible(true);
            revalidate();
            repaint();
        });
        
        

        
        
        
        // ===== Create a list of section options for Génie Electrique department
        
        
        String[] section2Options = {"Génie Electrique"};
        
        // Create the section combo box but don't add it to the panel yet
        JComboBox<String> section2ComboBox = new JComboBox<>(section2Options);
        section2ComboBox.setBounds(810, 300, 450, 40);
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
        section.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
            	
            	
            	String dep2 = department.getText();
            	
            	if (dep2.equals("Génie Electrique")) {
            		
            		if (section.getText().isEmpty()) {
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
            section.setText(selectedOption);
            remove(section2ComboBox);
            label5.setVisible(true);
            revalidate();
            repaint();
        });
        
        

        

        // ===== Create a list of section options for Réseaux et Télécommunications department
        
        
        String[] section3Options = {"Ingénierie des Réseaux Intelligents et Cybersécurité","Génie Réseaux et Télécomunications"};

     // Create the section combo box but don't add it to the panel yet
        JComboBox<String> section3ComboBox = new JComboBox<>(section3Options);
        section3ComboBox.setBounds(810, 300, 450, 40);
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
        section.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
            	
            	
            	String dep3 = department.getText();
            	
            	if (dep3.equals("Réseaux et Télécommunications")) {
            		
            		if (section.getText().isEmpty()) {
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
            section.setText(selectedOption);
            remove(section3ComboBox);
            label5.setVisible(true);
            revalidate();
            repaint();
        });
        
        
        
  
        
       // ===== Create a list of section options for Génie des Procédés department
        
        
        String[] section4Options = {"Génie des Procédés, de l'Energie et de l'Environnement"};

        // Create the section combo box but don't add it to the panel yet
        JComboBox<String> section4ComboBox = new JComboBox<>(section4Options);
        section4ComboBox.setBounds(810, 300, 450, 40);
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
        section.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
            	
            	
            	String dep4 = department.getText();
            	
            	if (dep4.equals("Génie des Procédés")) {
            		
            		if (section.getText().isEmpty()) {
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
            section.setText(selectedOption);
            remove(section4ComboBox);
            label5.setVisible(true);
            revalidate();
            repaint();
        });
        
        

        
        
        

        // adding a text -- adding a JLabel -- semester
        
        JLabel label6 = new JLabel("Semester");
        label6.setFont(new Font("Century Gothic", Font.BOLD, 20));
        label6.setForeground(Color.decode("#6495ED"));
        label6.setBounds(810, 379, 200, 30);
        label6.setHorizontalAlignment(SwingConstants.LEFT);
        add(label6);       
        
 
        
        
        // adding the year text field
        
        JTextField year = new JTextField();
        year.setCursor(Cursor.getPredefinedCursor(Cursor.TEXT_CURSOR));
        year.setHorizontalAlignment(SwingConstants.LEFT);
        year.setForeground(new Color(0, 0, 0)); 
        year.setFont(new Font("Arial", Font.PLAIN, 19));
        year.setBounds(810, 334, 450, 40);
        year.setColumns(10);
        add(year); 
        year.setBorder(border);

        
        
        
        

        // Create a list of year options
        String[] year1Options = {"First", "Second", "Third"};

        // Create the section combo box but don't add it to the panel yet
        JComboBox<String> year1ComboBox = new JComboBox<>(year1Options);
        year1ComboBox.setBounds(810, 372, 450, 40);
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
        year.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                if (year.getText().isEmpty()) {
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
            year.setText(selectedOption);
            remove(year1ComboBox);
            label6.setVisible(true);
            revalidate();
            repaint();
        });
        
        
        
        
        
        
        

        // adding a text -- adding a JLabel -- module
        
        JLabel label88 = new JLabel("Module");
        label88.setFont(new Font("Century Gothic", Font.BOLD, 20));
        label88.setForeground(Color.decode("#6495ED"));
        label88.setBounds(810, 455, 200, 30);
        label88.setHorizontalAlignment(SwingConstants.LEFT);
        add(label88);
        
        
        
    
        
               
        // adding the semester text field
        
        JTextField semester = new JTextField();
        semester.setCursor(Cursor.getPredefinedCursor(Cursor.TEXT_CURSOR));
        semester.setHorizontalAlignment(SwingConstants.LEFT);
        semester.setForeground(new Color(0, 0, 0));
        semester.setFont(new Font("Arial", Font.PLAIN, 19));
        semester.setBounds(810, 411, 450, 40);
        semester.setColumns(10);
        add(semester);
        semester.setBorder(border);

        
        
        // Create a list of year options
        String[] semesterOptions = {"First", "Second"};

        // Create the section combo box but don't add it to the panel yet
        JComboBox<String> semesterComboBox = new JComboBox<>(semesterOptions);
        semesterComboBox.setBounds(810, 447, 450, 40);
        semesterComboBox.setBackground(Color.decode("#F3FAFD"));
        semesterComboBox.setFont(new Font("Arial", Font.PLAIN, 18));
        semesterComboBox.setRenderer(new DefaultListCellRenderer() {
            public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
                JLabel label = (JLabel) super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
                label.setBackground(isSelected ? Color.decode("#C9E9F6") : Color.decode("#F3FAFD"));
                return label;
            }
        });
         

    
        // Add a key listener to the text field to show/hide the combo box as needed
        semester.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                if (semester.getText().isEmpty()) {
                    label88.setVisible(true);
                	remove(semesterComboBox);
                    revalidate();
                    repaint();
                } else {
                	
                    if (!Arrays.asList(getComponents()).contains(semesterComboBox)) {
                        label88.setVisible(false);
                    	add(semesterComboBox);
                        revalidate();
                        repaint();
                    }
                }
            }
        });

        // Add a listener to the combo box to update the text field with the selected option
        semesterComboBox.addActionListener(e -> {
            String selectedOption = (String) semesterComboBox.getSelectedItem();
            semester.setText(selectedOption);
            remove(semesterComboBox);
            label88.setVisible(true);
            revalidate();
            repaint();
        });
        
        
        
        

        
       
               
        // adding the module text field
        
        JTextField module = new JTextField();
        module.setCursor(Cursor.getPredefinedCursor(Cursor.TEXT_CURSOR));
        module.setHorizontalAlignment(SwingConstants.LEFT);
        module.setForeground(new Color(0, 0, 0));
        module.setFont(new Font("Arial", Font.PLAIN, 19));
        module.setBounds(810, 487, 450, 40);
        module.setColumns(10);
        add(module); 
        module.setBorder(border);

        
        

        // adding a text -- adding a JLabel 
        
        JLabel label777 = new JLabel("Please select an option from the list that will");
        label777.setFont(new Font("Century Gothic", Font.BOLD, 20));
        label777.setForeground(Color.BLACK);
        label777.setBounds(810, 640, 500, 30);
        label777.setHorizontalAlignment(SwingConstants.LEFT);
        add(label777);
        
        
        // adding a text -- adding a JLabel 
        
        JLabel label0 = new JLabel("be displayed as you start typing.");
        label0.setFont(new Font("Century Gothic", Font.BOLD, 20));
        label0.setForeground(Color.BLACK);
        label0.setBounds(810, 670, 500, 30);
        label0.setHorizontalAlignment(SwingConstants.LEFT);
        add(label0);
        
        
     
        
        
        
        
        
        
        
        
        
        // ===== Create a list of modules options for IID1 
             
        // ------ semester 1
         
        String[] iid11Options = {"Algorithmique avancée","Soft Skills","Analyse pour ingénieur","Unix et Administration système","Algèbre pour ingénieur","Probabilité","Python","Systeme d'info et bases de données"};
        
        // Create the section combo box but don't add it to the panel yet
        JComboBox<String> iid11ComboBox = new JComboBox<>(iid11Options);
        iid11ComboBox.setBounds(810, 525, 450, 40);
        iid11ComboBox.setBackground(Color.decode("#F3FAFD"));
        iid11ComboBox.setFont(new Font("Arial", Font.PLAIN, 18));
        iid11ComboBox.setRenderer(new DefaultListCellRenderer() {
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
            	
            	
            	String sec = section.getText();
            	String ye = year.getText();
            	String semes = semester.getText();


            	
            	if ((sec.equals("Informatique et Ingénieurie des Données")) && (ye.equals("First")) && (semes.equals("First"))) {
            		
            		if (module.getText().isEmpty()) {
                        label777.setVisible(true);
                    	remove(iid11ComboBox);
                        revalidate();
                        repaint();
                    } else {
                    	
                        if (!Arrays.asList(getComponents()).contains(iid11ComboBox)) {
                            label777.setVisible(false);
                        	add(iid11ComboBox);
                            revalidate();
                            repaint();
                        }
                    }
            		           		
            	}
 
            }
        });
        

        
        // Add a listener to the combo box to update the text field with the selected option
        iid11ComboBox.addActionListener(e -> {
            String iid11Option = (String) iid11ComboBox.getSelectedItem();
            module.setText(iid11Option);
            remove(iid11ComboBox);
            label777.setVisible(true);
            revalidate();
            repaint();
        });
        
   
        
        
        
        // ------ semester 2
        
        String[] iid12Options = {"Codage et Analyse d'Information","Statistiques","Soft Skils","Techniques d'Optimisation","Programmation Web","Gestion de Projet","Java","Introduction au JEE"};
        
        // Create the section combo box but don't add it to the panel yet
        JComboBox<String> iid12ComboBox = new JComboBox<>(iid12Options);
        iid12ComboBox.setBounds(810, 525, 450, 40);
        iid12ComboBox.setBackground(Color.decode("#F3FAFD"));
        iid12ComboBox.setFont(new Font("Arial", Font.PLAIN, 18));
        iid12ComboBox.setRenderer(new DefaultListCellRenderer() {
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
            	
            	
            	String sec = section.getText();
            	String ye = year.getText();
            	String semes = semester.getText();


            	
            	if ((sec.equals("Informatique et Ingénieurie des Données")) && (ye.equals("First")) && (semes.equals("Second"))) {
            		
            		if (module.getText().isEmpty()) {
                        label777.setVisible(true);
                    	remove(iid12ComboBox);
                        revalidate();
                        repaint();
                    } else {
                    	
                        if (!Arrays.asList(getComponents()).contains(iid12ComboBox)) {
                            label777.setVisible(false);
                        	add(iid12ComboBox);
                            revalidate();
                            repaint();
                        }
                    }
            		           		
            	}
 
            }
        });
        

        
        // Add a listener to the combo box to update the text field with the selected option
        iid12ComboBox.addActionListener(e -> {
            String iid12Option = (String) iid12ComboBox.getSelectedItem();
            module.setText(iid12Option);
            remove(iid12ComboBox);
            label777.setVisible(true);
            revalidate();
            repaint();
        });
        
        
     
        
        
        
        
        // ===== Create a list of modules options for IID2
        
        // ------ semester 1
         
        String[] iid21Options = {"Modélisation orienté objet","Soft Skills","Recherche opérationnelle","Analyse des données","Vision par ordinateur","Introduction au Big Data","Data Warehouse"};
        
        // Create the section combo box but don't add it to the panel yet
        JComboBox<String> iid21ComboBox = new JComboBox<>(iid21Options);
        iid21ComboBox.setBounds(810, 525, 450, 40);
        iid21ComboBox.setBackground(Color.decode("#F3FAFD"));
        iid21ComboBox.setFont(new Font("Arial", Font.PLAIN, 18));
        iid21ComboBox.setRenderer(new DefaultListCellRenderer() {
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
            	
            	
            	String sec = section.getText();
            	String ye = year.getText();
            	String semes = semester.getText();


            	
            	if ((sec.equals("Informatique et Ingénieurie des Données")) && (ye.equals("Second")) && (semes.equals("First"))) {
            		
            		if (module.getText().isEmpty()) {
                        label777.setVisible(true);
                    	remove(iid21ComboBox);
                        revalidate();
                        repaint();
                    } else {
                    	
                        if (!Arrays.asList(getComponents()).contains(iid21ComboBox)) {
                            label777.setVisible(false);
                        	add(iid21ComboBox);
                            revalidate();
                            repaint();
                        }
                    }
            		           		
            	}
 
            }
        });
        

        
        // Add a listener to the combo box to update the text field with the selected option
        iid21ComboBox.addActionListener(e -> {
            String iid21Option = (String) iid21ComboBox.getSelectedItem();
            module.setText(iid21Option);
            remove(iid21ComboBox);
            label777.setVisible(true);
            revalidate();
            repaint();
        });
        
        
   
        
        
        
        
        
        // ------ semester 2
        
        String[] iid22Options = {"Apprentissage Automatique","Soft Skills","Outils d'Aide à La Decision","Gestion de Production Industielle","Nettoyage et Visualisation des Données","Entrepreneuriat et Initiatives Personnelles","JEE/JS"};
        
        // Create the section combo box but don't add it to the panel yet
        JComboBox<String> iid22ComboBox = new JComboBox<>(iid22Options);
        iid22ComboBox.setBounds(810, 525, 450, 40);
        iid22ComboBox.setBackground(Color.decode("#F3FAFD"));
        iid22ComboBox.setFont(new Font("Arial", Font.PLAIN, 18));
        iid22ComboBox.setRenderer(new DefaultListCellRenderer() {
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
            	
            	
            	String sec = section.getText();
            	String ye = year.getText();
            	String semes = semester.getText();


            	
            	if ((sec.equals("Informatique et Ingénieurie des Données")) && (ye.equals("Second")) && (semes.equals("Second"))) {
            		
            		if (module.getText().isEmpty()) {
                        label777.setVisible(true);
                    	remove(iid22ComboBox);
                        revalidate();
                        repaint();
                    } else {
                    	
                        if (!Arrays.asList(getComponents()).contains(iid22ComboBox)) {
                            label777.setVisible(false);
                        	add(iid22ComboBox);
                            revalidate();
                            repaint();
                        }
                    }
            		           		
            	}
 
            }
        });
        

        
        // Add a listener to the combo box to update the text field with the selected option
        iid22ComboBox.addActionListener(e -> {
            String iid22Option = (String) iid22ComboBox.getSelectedItem();
            module.setText(iid22Option);
            remove(iid22ComboBox);
            label777.setVisible(true);
            revalidate();
            repaint();
        });
        
        
    
        
        
        
        // ===== Create a list of modules options for IID3
        
        // ------ semester 1
         
        String[] iid31Options = {"Innovation et Planification","Soft Skills","Technologie JS & Mobile","Apprentissage automatique 2","Intelligence artificielle","Calcul et architecture distribuée en Big Data","Génie logiciel"};
        
        // Create the section combo box but don't add it to the panel yet
        JComboBox<String> iid31ComboBox = new JComboBox<>(iid31Options);
        iid31ComboBox.setBounds(810, 525, 450, 40);
        iid31ComboBox.setBackground(Color.decode("#F3FAFD"));
        iid31ComboBox.setFont(new Font("Arial", Font.PLAIN, 18));
        iid31ComboBox.setRenderer(new DefaultListCellRenderer() {
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
            	
            	
            	String sec = section.getText();
            	String ye = year.getText();
            	String semes = semester.getText();


            	
            	if ((sec.equals("Informatique et Ingénieurie des Données")) && (ye.equals("Third")) && (semes.equals("First"))) {
            		
            		if (module.getText().isEmpty()) {
                        label777.setVisible(true);
                    	remove(iid31ComboBox);
                        revalidate();
                        repaint();
                    } else {
                    	
                        if (!Arrays.asList(getComponents()).contains(iid31ComboBox)) {
                            label777.setVisible(false);
                        	add(iid31ComboBox);
                            revalidate();
                            repaint();
                        }
                    }
            		           		
            	}
 
            }
        });
        

        
        // Add a listener to the combo box to update the text field with the selected option
        iid31ComboBox.addActionListener(e -> {
            String iid31Option = (String) iid31ComboBox.getSelectedItem();
            module.setText(iid31Option);
            remove(iid31ComboBox);
            label777.setVisible(true);
            revalidate();
            repaint();
        });
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        // ===== Create a list of modules options for GI1
        
        // ------ semester 1
         
        String[] gi11Options = {"Langage C avancé et structures de données","Soft Skills","Architecture des ordinateurs","Recherche opérationnelle et théorie des graphes","Systèmes d’Information et Bases de Données Relationnelles","Réseaux informatiques"};
        
        // Create the section combo box but don't add it to the panel yet
        JComboBox<String> gi11ComboBox = new JComboBox<>(gi11Options);
        gi11ComboBox.setBounds(810, 525, 450, 40);
        gi11ComboBox.setBackground(Color.decode("#F3FAFD"));
        gi11ComboBox.setFont(new Font("Arial", Font.PLAIN, 18));
        gi11ComboBox.setRenderer(new DefaultListCellRenderer() {
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
            	
            	
            	String sec = section.getText();
            	String ye = year.getText();
            	String semes = semester.getText();


            	
            	if ((sec.equals("Génie Informatique")) && (ye.equals("First")) && (semes.equals("First"))) {
            		
            		if (module.getText().isEmpty()) {
                        label777.setVisible(true);
                    	remove(gi11ComboBox);
                        revalidate();
                        repaint();
                    } else {
                    	
                        if (!Arrays.asList(getComponents()).contains(gi11ComboBox)) {
                            label777.setVisible(false);
                        	add(gi11ComboBox);
                            revalidate();
                            repaint();
                        }
                    }
            		           		
            	}
 
            }
        });
        

        
        // Add a listener to the combo box to update the text field with the selected option
        gi11ComboBox.addActionListener(e -> {
            String gi11Option = (String) gi11ComboBox.getSelectedItem();
            module.setText(gi11Option);
            remove(gi11ComboBox);
            label777.setVisible(true);
            revalidate();
            repaint();
        });
        
        
        
        
        
        // ------ semester 2
        
        String[] gi12Options = {"Mathématiques Pour Ingénieur","Soft Skills","Programmation Java","Systèmes D'exploitation & Unix","Programmation Web","Protocoles Et Réseaux"};
        
        // Create the section combo box but don't add it to the panel yet
        JComboBox<String> gi12ComboBox = new JComboBox<>(gi12Options);
        gi12ComboBox.setBounds(810, 525, 450, 40);
        gi12ComboBox.setBackground(Color.decode("#F3FAFD"));
        gi12ComboBox.setFont(new Font("Arial", Font.PLAIN, 18));
        gi12ComboBox.setRenderer(new DefaultListCellRenderer() {
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
            	
            	
            	String sec = section.getText();
            	String ye = year.getText();
            	String semes = semester.getText();


            	
            	if ((sec.equals("Génie Informatique")) && (ye.equals("First")) && (semes.equals("Second"))) {
            		
            		if (module.getText().isEmpty()) {
                        label777.setVisible(true);
                    	remove(gi12ComboBox);
                        revalidate();
                        repaint();
                    } else {
                    	
                        if (!Arrays.asList(getComponents()).contains(gi12ComboBox)) {
                            label777.setVisible(false);
                        	add(gi12ComboBox);
                            revalidate();
                            repaint();
                        }
                    }
            		           		
            	}
 
            }
        });
        

        
        // Add a listener to the combo box to update the text field with the selected option
        gi12ComboBox.addActionListener(e -> {
            String gi12Option = (String) gi12ComboBox.getSelectedItem();
            module.setText(gi12Option);
            remove(gi12ComboBox);
            label777.setVisible(true);
            revalidate();
            repaint();
        });
        
        
        
        
        
        
        
        // ===== Create a list of modules options for GI2
        
        // ------ semester 1
         
        String[] gi21Options = {"Python Pour Les Sciences Données","Soft Skills","Programmation Java Avancée","Linux Et Programmation Système","Administration Des Bases De Données Avancées","Administration Réseaux Et Systèmes"};
        
        // Create the section combo box but don't add it to the panel yet
        JComboBox<String> gi21ComboBox = new JComboBox<>(gi21Options);
        gi21ComboBox.setBounds(810, 525, 450, 40);
        gi21ComboBox.setBackground(Color.decode("#F3FAFD"));
        gi21ComboBox.setFont(new Font("Arial", Font.PLAIN, 18));
        gi21ComboBox.setRenderer(new DefaultListCellRenderer() {
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
            	
            	
            	String sec = section.getText();
            	String ye = year.getText();
            	String semes = semester.getText();


            	
            	if ((sec.equals("Génie Informatique")) && (ye.equals("Second")) && (semes.equals("First"))) {
            		
            		if (module.getText().isEmpty()) {
                        label777.setVisible(true);
                    	remove(gi21ComboBox);
                        revalidate();
                        repaint();
                    } else {
                    	
                        if (!Arrays.asList(getComponents()).contains(gi21ComboBox)) {
                            label777.setVisible(false);
                        	add(gi21ComboBox);
                            revalidate();
                            repaint();
                        }
                    }
            		           		
            	}
 
            }
        });
        

        
        // Add a listener to the combo box to update the text field with the selected option
        gi21ComboBox.addActionListener(e -> {
            String gi21Option = (String) gi21ComboBox.getSelectedItem();
            module.setText(gi21Option);
            remove(gi21ComboBox);
            label777.setVisible(true);
            revalidate();
            repaint();
        });
        
        
        
        
        
        // ------ semester 2
        
        String[] gi22Options = {"Base de Données NoSQL / Dase de Données Distribuées.","Soft Skills","Informatique Théorique","Environnement de Développement Mobile","Gestion de Production Industrielle",".NET / sécurité logicielle"};
        
        // Create the section combo box but don't add it to the panel yet
        JComboBox<String> gi22ComboBox = new JComboBox<>(gi22Options);
        gi22ComboBox.setBounds(810, 525, 450, 40);
        gi22ComboBox.setBackground(Color.decode("#F3FAFD"));
        gi22ComboBox.setFont(new Font("Arial", Font.PLAIN, 18));
        gi22ComboBox.setRenderer(new DefaultListCellRenderer() {
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
            	
            	
            	String sec = section.getText();
            	String ye = year.getText();
            	String semes = semester.getText();


            	
            	if ((sec.equals("Génie Informatique")) && (ye.equals("Second")) && (semes.equals("Second"))) {
            		
            		if (module.getText().isEmpty()) {
                        label777.setVisible(true);
                    	remove(gi22ComboBox);
                        revalidate();
                        repaint();
                    } else {
                    	
                        if (!Arrays.asList(getComponents()).contains(gi22ComboBox)) {
                            label777.setVisible(false);
                        	add(gi22ComboBox);
                            revalidate();
                            repaint();
                        }
                    }
            		           		
            	}
 
            }
        });
        

        
        // Add a listener to the combo box to update the text field with the selected option
        gi22ComboBox.addActionListener(e -> {
            String gi22Option = (String) gi22ComboBox.getSelectedItem();
            module.setText(gi22Option);
            remove(gi22ComboBox);
            label777.setVisible(true);
            revalidate();
            repaint();
        });
        
        
        
        
        
        // ===== Create a list of modules options for GI3
        
        // ------ semester 1
         
        String[] gi31Options = {"Développement des Applications Mobiles","Soft Skills","Virtualisation et Cloud Computing","Enterprise Resource Planning ERP","Ingénierie logicielle, Qualité, Test et Intégration","Système Embarqué et Temps Réel","Entreprenariat"};
        
        // Create the section combo box but don't add it to the panel yet
        JComboBox<String> gi31ComboBox = new JComboBox<>(gi31Options);
        gi31ComboBox.setBounds(810, 525, 450, 40);
        gi31ComboBox.setBackground(Color.decode("#F3FAFD"));
        gi31ComboBox.setFont(new Font("Arial", Font.PLAIN, 18));
        gi31ComboBox.setRenderer(new DefaultListCellRenderer() {
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
            	
            	
            	String sec = section.getText();
            	String ye = year.getText();
            	String semes = semester.getText();


            	
            	if ((sec.equals("Génie Informatique")) && (ye.equals("Third")) && (semes.equals("First"))) {
            		
            		if (module.getText().isEmpty()) {
                        label777.setVisible(true);
                    	remove(gi31ComboBox);
                        revalidate();
                        repaint();
                    } else {
                    	
                        if (!Arrays.asList(getComponents()).contains(gi31ComboBox)) {
                            label777.setVisible(false);
                        	add(gi31ComboBox);
                            revalidate();
                            repaint();
                        }
                    }
            		           		
            	}
 
            }
        });
        

        
        // Add a listener to the combo box to update the text field with the selected option
        gi31ComboBox.addActionListener(e -> {
            String gi31Option = (String) gi31ComboBox.getSelectedItem();
            module.setText(gi31Option);
            remove(gi31ComboBox);
            label777.setVisible(true);
            revalidate();
            repaint();
        });
        
        
        
        
        
        
        
        
        // ===== Create a list of modules options for GE1
        
        // ------ semester 1
         
        String[] ge11Options = {"Mathématiques pour l'Ingénieur ","Soft Skills","Ondes et Propagation","Composants Electroniques et Circuits","Traitement de Signal","Complexité algorithmique Structures des Données","Management"};
        
        // Create the section combo box but don't add it to the panel yet
        JComboBox<String> ge11ComboBox = new JComboBox<>(ge11Options);
        ge11ComboBox.setBounds(810, 525, 450, 40);
        ge11ComboBox.setBackground(Color.decode("#F3FAFD"));
        ge11ComboBox.setFont(new Font("Arial", Font.PLAIN, 18));
        ge11ComboBox.setRenderer(new DefaultListCellRenderer() {
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
            	
            	
            	String sec = section.getText();
            	String ye = year.getText();
            	String semes = semester.getText();


            	
            	if ((sec.equals("Génie Electrique")) && (ye.equals("First")) && (semes.equals("First"))) {
            		
            		if (module.getText().isEmpty()) {
                        label777.setVisible(true);
                    	remove(ge11ComboBox);
                        revalidate();
                        repaint();
                    } else {
                    	
                        if (!Arrays.asList(getComponents()).contains(ge11ComboBox)) {
                            label777.setVisible(false);
                        	add(ge11ComboBox);
                            revalidate();
                            repaint();
                        }
                    }
            		           		
            	}
 
            }
        });
        

        
        // Add a listener to the combo box to update the text field with the selected option
        ge11ComboBox.addActionListener(e -> {
            String ge11Option = (String) ge11ComboBox.getSelectedItem();
            module.setText(ge11Option);
            remove(ge11ComboBox);
            label777.setVisible(true);
            revalidate();
            repaint();
        });
        
        
        
       
        
        
        // ------ semester 2
        
        String[] ge12Options = {"Conversion Electromécanique et Machines à Courant Continu ","Soft Skills","Systèmes Mécatroniques","Informatique Industrielle","Automatique des Systèmes Continus et Discrets","Automatisme","Réseaux et Protocoles"};
        
        // Create the section combo box but don't add it to the panel yet
        JComboBox<String> ge12ComboBox = new JComboBox<>(ge12Options);
        ge12ComboBox.setBounds(810, 525, 450, 40);
        ge12ComboBox.setBackground(Color.decode("#F3FAFD"));
        ge12ComboBox.setFont(new Font("Arial", Font.PLAIN, 18));
        ge12ComboBox.setRenderer(new DefaultListCellRenderer() {
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
            	
            	
            	String sec = section.getText();
            	String ye = year.getText();
            	String semes = semester.getText();


            	
            	if ((sec.equals("Génie Electrique")) && (ye.equals("First")) && (semes.equals("Second"))) {
            		
            		if (module.getText().isEmpty()) {
                        label777.setVisible(true);
                    	remove(ge12ComboBox);
                        revalidate();
                        repaint();
                    } else {
                    	
                        if (!Arrays.asList(getComponents()).contains(ge12ComboBox)) {
                            label777.setVisible(false);
                        	add(ge12ComboBox);
                            revalidate();
                            repaint();
                        }
                    }
            		           		
            	}
 
            }
        });
        

        
        // Add a listener to the combo box to update the text field with the selected option
        ge12ComboBox.addActionListener(e -> {
            String ge12Option = (String) ge12ComboBox.getSelectedItem();
            module.setText(ge12Option);
            remove(ge12ComboBox);
            label777.setVisible(true);
            revalidate();
            repaint();
        });
        
        
        
        
        
        
        // ===== Create a list of modules options for GE2
        
        // ------ semester 1
         
        String[] ge21Options = {"Informatique Industrielle ","Soft Skills","","Transmission Analogique et Numérique","Circuits Micro-Ondes et Antennes","Régulation Industrielle et Capteurs","Marketing"};
        
        // Create the section combo box but don't add it to the panel yet
        JComboBox<String> ge21ComboBox = new JComboBox<>(ge21Options);
        ge21ComboBox.setBounds(810, 525, 450, 40);
        ge21ComboBox.setBackground(Color.decode("#F3FAFD"));
        ge21ComboBox.setFont(new Font("Arial", Font.PLAIN, 18));
        ge21ComboBox.setRenderer(new DefaultListCellRenderer() {
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
            	
            	
            	String sec = section.getText();
            	String ye = year.getText();
            	String semes = semester.getText();


            	
            	if ((sec.equals("Génie Electrique")) && (ye.equals("Second")) && (semes.equals("First"))) {
            		
            		if (module.getText().isEmpty()) {
                        label777.setVisible(true);
                    	remove(ge21ComboBox);
                        revalidate();
                        repaint();
                    } else {
                    	
                        if (!Arrays.asList(getComponents()).contains(ge21ComboBox)) {
                            label777.setVisible(false);
                        	add(ge21ComboBox);
                            revalidate();
                            repaint();
                        }
                    }
            		           		
            	}
 
            }
        });
        

        
        // Add a listener to the combo box to update the text field with the selected option
        ge21ComboBox.addActionListener(e -> {
            String ge21Option = (String) ge21ComboBox.getSelectedItem();
            module.setText(ge21Option);
            remove(ge21ComboBox);
            label777.setVisible(true);
            revalidate();
            repaint();
        });
        
        
        
        
        
        
        //-----------------------------------------------------------------------------------------------------------------
        
        // Create a new FocusListener
        FocusListener focusListener = new FocusListener() {
            public void focusGained(FocusEvent e) {
                // Do nothing when the text field gains focus
            }
            
            public void focusLost(FocusEvent e) {
                // When the text field loses focus, execute the code to retrieve data and fill fields
                try {
                    String query7 = "SELECT nom, prenom, email, code_CIN, numero_telephone, departement FROM PROFESSEUR WHERE id_Prof=?";
                    PreparedStatement pstmt7 = connection.prepareStatement(query7);
                    pstmt7.setString(1, prof_id.getText());
                    
                    // Execute the query and retrieve the result
                    ResultSet rs7 = pstmt7.executeQuery();
                    
                    // Check if the ResultSet contains any rows 
                    if (rs7.next()) {
                        first.setText(rs7.getString("nom"));
                        second.setText(rs7.getString("prenom"));
                        email.setText(rs7.getString("email"));
                        cin.setText(rs7.getString("code_CIN"));
                        number.setText(rs7.getString("numero_telephone"));
                        department.setText(rs7.getString("departement"));
                   
                    
                   
                    } else {
                        // If the ResultSet is empty, do nothing
                    }
                } catch (SQLException ee) {
                    ee.printStackTrace();
                }
            }
        };

        // Add the FocusListener to the prof_id text field
        prof_id.addFocusListener(focusListener);

    
 
        
        
        
        
        confirm.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	
            	try {
            	   
            		
          
                    
            		String queryy = "SELECT COUNT(*) FROM PROFESSEUR WHERE id_Prof=?";
            	    PreparedStatement pstmtt = connection.prepareStatement(queryy);
            	    pstmtt.setString(1, prof_id.getText());
            	    
            	    // Execute the query and retrieve the result
            	    ResultSet rss = pstmtt.executeQuery();
            	    rss.next();
            	    
            	    int count = rss.getInt(1);
            	    
            	    if (count == 0) {
            	        
            	    	
            	    	
            	    	
            	    	// ====== Prepare the insert statement for professor
                	    
                		String insertProfessorQuery = "INSERT INTO PROFESSEUR (id_Prof, nom, prenom, email, code_CIN, numero_telephone, departement) "
                	            + "VALUES (?, ?, ?, ?, ?, ?, ?)";
                	    PreparedStatement insertProfessorStatement = connection.prepareStatement(insertProfessorQuery);

                	    // Set the parameter values for professor
                	    insertProfessorStatement.setString(1, prof_id.getText());
                	    insertProfessorStatement.setString(2, second.getText());
                	    insertProfessorStatement.setString(3, first.getText());
                	    insertProfessorStatement.setString(4, email.getText());
                	    insertProfessorStatement.setString(5, cin.getText());
                	    insertProfessorStatement.setString(6, number.getText());
                	    insertProfessorStatement.setString(7, department.getText());

                	    // Execute the insert statement for professor
                	    int rowsInserted1 = insertProfessorStatement.executeUpdate();
            	   
            	    
            	    } 
            		
            		
    	
            		
            		
                    
                    
                    
            	    
        	         //----------------------------------------------------------------
            	    
            	    //===== Prepare the insert statement for module
            	    
            	    String insertModuleQuery = "INSERT INTO MODULE (nom_module, id_Prof) "
            	            + "VALUES (?, ?)";
            	    PreparedStatement insertModuleStatement = connection.prepareStatement(insertModuleQuery, Statement.RETURN_GENERATED_KEYS);

            	    // Set the parameter values for module
            	    insertModuleStatement.setString(1, module.getText());
            	    insertModuleStatement.setString(2, prof_id.getText());

            	    // Execute the insert statement for module
            	    int rowsInserted2 = insertModuleStatement.executeUpdate();
                    
            	    //---------------------------------------------------------------
            	    
            	    
            	    //===== get the id_module from the module inserted row
            	    
            	    
            	    
            	    
                    ResultSet generatedID = insertModuleStatement.getGeneratedKeys();

                    int iD = 0;
                    
                    if (generatedID.next()) {
                        iD = generatedID.getInt(1);
                    } 

            	    

            	    //-----------------------------------------------------------------------------
            	    
            	    // ===== Prepare the insert statement for enseignement
            	    
                    String insertEnseiQuery = "INSERT INTO ENSEIGNEMENT (annee_etude,semestre,id_Prof,nom_filliere,id_module) "
            	            + "VALUES (?,?,?,?,?)";
            	    
            	    PreparedStatement insertEnseiStatement = connection.prepareStatement(insertEnseiQuery);

            	    // Set the parameter values for enseignement
            	    insertEnseiStatement.setString(1, year.getText());
            	    insertEnseiStatement.setString(2, semester.getText());
            	    insertEnseiStatement.setString(3, prof_id.getText());
            	    insertEnseiStatement.setString(4, section.getText());
                    String id =  Integer.toString(iD);
            	    insertEnseiStatement.setString(5, id);

            	    // Execute the insert statement for ensignement
            	    int rowsInserted3 = insertEnseiStatement.executeUpdate();
            	    
            	    
      

            	    // Clear the text field inputs
            	    
            	    prof_id.setText(""); 
            	    second.setText("");
            	    first.setText("");
            	    email.setText("");
            	    cin.setText("");
            	    number.setText("");
            	    department.setText("");
            	    year.setText("");
            	    semester.setText("");
            	    section.setText("");
            	    module.setText("");
            	    section.setText("");
                    
            	    

            	} catch (SQLException ex) {
            	    ex.printStackTrace();
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

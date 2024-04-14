package pack_1;

import java.awt.*;
import java.awt.geom.RoundRectangle2D;
import java.awt.event.*;
import java.io.File;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.*;
import javax.swing.border.Border;
import java.io.FileInputStream;
import java.io.InputStream;

public class Professor_Profile_Panel_20 extends JPanel {
    
    JLabel photo;
    
    public Professor_Profile_Panel_20() {
        
        

        //establish the connection
        
    	Connection connection = DatabaseConnection.getConnection();

        
        //--------------------------------------------------------------------------------------------
    	
    	
    	setLayout(null);
        setBackground(Color.WHITE);
        
        
        
        // new instance to take the entered ID
        
        
        Professor_Check_Panel_16 pan = new Professor_Check_Panel_16();
        String id = pan.getID();
        
        
        
        
        
        
        
        
        // Adding the drop photo Button
        
        JButton drop = new JButton();
        drop.setHorizontalAlignment(SwingConstants.RIGHT);
        drop.setFocusable(false);
        drop.setFocusTraversalKeysEnabled(false);
        drop.setFocusPainted(false);
        drop.setContentAreaFilled(false);
        drop.setOpaque(false);
        drop.setAlignmentX(Component.RIGHT_ALIGNMENT);
        drop.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        drop.setBorderPainted(false);
        drop.setBounds(95, 100, 150, 30);
        drop.setBackground(Color.red);
        add(drop); 
        
        
        
        
        
        // Adding a JLabel for photo
        
        photo = new JLabel("Drop your photo");
        photo.setFont(new Font("Arial", Font.BOLD, 18));
        photo.setForeground(Color.decode("#9e9e9e"));
        photo.setBounds(70, 20, 200, 200);
        photo.setHorizontalAlignment(SwingConstants.CENTER);
        photo.setOpaque(true); 
        photo.setBackground(Color.WHITE);
        Border border = BorderFactory.createLineBorder(Color.decode("#BCD3E7"), 2);
        photo.setBorder(border);
        add(photo);  
        
        
    
        
         
        // Adding ActionListener to drop Button
        
        drop.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JFileChooser fileChooser = new JFileChooser();
                int result = fileChooser.showOpenDialog(null);
                if (result == JFileChooser.APPROVE_OPTION) {
                    File selectedFile = fileChooser.getSelectedFile();
                    try {
                        // Read the image file and set it to the JLabel
                        Image image = ImageIO.read(selectedFile);
                        photo.setIcon(new ImageIcon(image.getScaledInstance(215, photo.getHeight(), Image.SCALE_SMOOTH)));

                        
                        // Update the image in the database
                        String query = "UPDATE professeur SET photo = ? WHERE id_Prof = ?";
                        try (PreparedStatement statement = connection.prepareStatement(query)) {
                            statement.setBinaryStream(1, new FileInputStream(selectedFile));
                            statement.setString(2, id); 
                            statement.executeUpdate();
                        } catch (Exception exx) {
                            exx.printStackTrace();
                        }

                        
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                }
            }
        });

        
        
        
        
        
        
    
        
        
       
        
        
        // hello label
        
        JLabel hello2 = new JLabel("HELLO  Professor !!");
        hello2.setFont(new Font("Bahnschrift", Font.BOLD, 30));
        hello2.setForeground(Color.black);
        hello2.setBounds(330, 75, 600, 100);
        hello2.setHorizontalAlignment(SwingConstants.LEFT);
        hello2.setOpaque(true); 
        hello2.setBackground(Color.WHITE); 
        add(hello2); 
        

        
        
        
    
       
        
        
        
        // adding a text -- adding a JLabel -- first name
        
        JLabel label2 = new JLabel("First Name :");
        label2.setFont(new Font("Arial", Font.BOLD, 20));
        label2.setForeground(Color.decode("#6495ED"));
        label2.setBounds(70, 283, 200, 30);
        label2.setHorizontalAlignment(SwingConstants.LEFT);
        add(label2);
        
        
  
        
               
        // adding the first name text field
        
        JTextField first = new JTextField();
        first.setCursor(Cursor.getPredefinedCursor(Cursor.TEXT_CURSOR));
        first.setHorizontalAlignment(SwingConstants.LEFT);
        first.setForeground(new Color(0, 0, 0));
        first.setFont(new Font("Arial", Font.PLAIN, 20));
        first.setBounds(250, 277, 300, 40);
        first.setColumns(10);
        Border bordere = BorderFactory.createMatteBorder(0, 0, 0, 0, Color.BLACK);
        first.setBorder(bordere);
        add(first); 
        
        
        
        
        
        
        
        
        
        
        // adding a text -- adding a JLabel -- second name
        
        JLabel label3 = new JLabel("Second Name :");
        label3.setFont(new Font(" Arial", Font.BOLD, 20));
        label3.setForeground(Color.decode("#6495ED"));
        label3.setBounds(70, 349, 200, 30);
        label3.setHorizontalAlignment(SwingConstants.LEFT);
        add(label3);
        
               
        
        
        // adding the second name text field
        
        JTextField second = new JTextField();
        second.setCursor(Cursor.getPredefinedCursor(Cursor.TEXT_CURSOR));
        second.setHorizontalAlignment(SwingConstants.LEFT);
        second.setForeground(new Color(0, 0, 0));
        second.setFont(new Font("Arial", Font.PLAIN, 20));
        second.setBounds(250, 343, 300, 40);
        second.setColumns(10);
        second.setBorder(bordere);
        add(second);

        
        
        
        
        // adding a text -- adding a JLabel -- Email adress
        
        JLabel label4 = new JLabel("E-mail Adress :");
        label4.setFont(new Font("Century Gothic", Font.BOLD, 20));
        label4.setForeground(Color.decode("#6495ED"));
        label4.setBounds(70, 411, 200, 30);
        label4.setHorizontalAlignment(SwingConstants.LEFT);
        add(label4);
        
               
        // adding the email adress text field
        
        JTextField email = new JTextField();
        email.setCursor(Cursor.getPredefinedCursor(Cursor.TEXT_CURSOR));
        email.setHorizontalAlignment(SwingConstants.LEFT);
        email.setForeground(new Color(0, 0, 0));
        email.setFont(new Font("Arial", Font.PLAIN, 20));
        email.setBounds(250, 405, 350, 40);
        email.setColumns(10);
        email.setBorder(bordere);
        add(email);

        
        
        
      
        // adding a text -- adding a JLabel -- professor identifier
        
        JLabel label555 = new JLabel("Identifier :");
        label555.setFont(new Font("Arial", Font.BOLD, 20));
        label555.setForeground(Color.decode("#6495ED"));
        label555.setBounds(70, 471, 200, 30);
        label555.setHorizontalAlignment(SwingConstants.LEFT);
        add(label555);
        
               
        // adding the professor identifier text field
        
        JTextField prof_id = new JTextField();
        prof_id.setCursor(Cursor.getPredefinedCursor(Cursor.TEXT_CURSOR));
        prof_id.setHorizontalAlignment(SwingConstants.LEFT);
        prof_id.setForeground(new Color(0, 0, 0));
        prof_id.setFont(new Font("Arial", Font.PLAIN, 20));
        prof_id.setBounds(250, 465, 300, 40);
        prof_id.setColumns(10);
        prof_id.setBorder(bordere);
        add(prof_id);

        
         
        // adding a text -- adding a JLabel -- cin
        
        JLabel label66 = new JLabel("CIN code :");
        label66.setFont(new Font("Arial", Font.BOLD, 20));
        label66.setForeground(Color.decode("#6495ED"));
        label66.setBounds(70, 528, 200, 30);
        label66.setHorizontalAlignment(SwingConstants.LEFT);
        add(label66);
        
               
        // adding the cin text field
        
        JTextField cin = new JTextField();
        cin.setCursor(Cursor.getPredefinedCursor(Cursor.TEXT_CURSOR));
        cin.setHorizontalAlignment(SwingConstants.LEFT);
        cin.setForeground(new Color(0, 0, 0));
        cin.setFont(new Font("Arial", Font.PLAIN, 20));
        cin.setBounds(250, 522, 300, 40);
        cin.setColumns(10);
        cin.setBorder(bordere);
        add(cin);

        
       
        
        // adding a text -- adding a JLabel -- number
        
        JLabel label888 = new JLabel("Phone Number :");
        label888.setFont(new Font("Arial", Font.BOLD, 20));
        label888.setForeground(Color.decode("#6495ED"));
        label888.setBounds(70, 586, 300, 30);
        label888.setHorizontalAlignment(SwingConstants.LEFT);
        add(label888);
       
     
        
        // adding number text field
        
        JTextField number = new JTextField();
        number.setForeground(new Color(0, 0, 0));
        number.setFont(new Font("Arial", Font.PLAIN, 20));
        number.setBounds(250, 580, 300, 40);
        number.setBorder(bordere);
        add(number); 
        
        
  
        
        
        
        
        // adding a text -- adding a JLabel -- departement
        
        JLabel label22 = new JLabel("Department :");
        label22.setFont(new Font("Arial", Font.BOLD, 20));
        label22.setForeground(Color.decode("#6495ED"));
        label22.setBounds(650, 283, 200, 30);
        label22.setHorizontalAlignment(SwingConstants.LEFT);
        add(label22);
        
         
               
        // adding the department name text field
        
        JTextField department = new JTextField();
        department.setCursor(Cursor.getPredefinedCursor(Cursor.TEXT_CURSOR));
        department.setHorizontalAlignment(SwingConstants.LEFT);
        department.setForeground(new Color(0, 0, 0));
        department.setFont(new Font("Arial", Font.PLAIN, 20));
        department.setBounds(810, 277, 700, 40);
        department.setColumns(10);
        department.setBorder(bordere);
        add(department); 
       
        
        
        
        
        
        
        // adding a text -- adding a JLabel -- module 1
        
        JLabel label33 = new JLabel("Module 1 :");
        label33.setFont(new Font("Arial ", Font.BOLD, 20));
        label33.setForeground(Color.decode("#6495ED"));
        label33.setBounds(650, 349, 190, 30);
        label33.setHorizontalAlignment(SwingConstants.LEFT);
        add(label33);
        
               
        // adding the  module 1 text field
        
        JTextField module1 = new JTextField();
        module1.setCursor(Cursor.getPredefinedCursor(Cursor.TEXT_CURSOR));
        module1.setHorizontalAlignment(SwingConstants.LEFT);
        module1.setForeground(new Color(0, 0, 0));
        module1.setFont(new Font("Arial", Font.PLAIN, 20));
        module1.setBounds(810, 343, 800, 40);
        module1.setColumns(10);
        module1.setBorder(bordere);
        add(module1);

        
        
        
        
        // adding a text -- adding a JLabel --  module2
        
        JLabel label44 = new JLabel("Module 2 :");
        label44.setFont(new Font("Arial", Font.BOLD, 20));
        label44.setForeground(Color.decode("#6495ED"));
        label44.setBounds(650, 411, 200, 30);
        label44.setHorizontalAlignment(SwingConstants.LEFT);
        add(label44);
        
               
        // adding the module 2  text field
        
        JTextField module2 = new JTextField();
        module2.setCursor(Cursor.getPredefinedCursor(Cursor.TEXT_CURSOR));
        module2.setHorizontalAlignment(SwingConstants.LEFT);
        module2.setForeground(new Color(0, 0, 0));
        module2.setFont(new Font("Arial", Font.PLAIN, 20));
        module2.setBounds(810, 405, 700, 40);
        module2.setColumns(10);
        module2.setBorder(bordere);
        add(module2);

        
        
        
      
        // adding a text -- adding a JLabel -- module 3
        
        JLabel label55 = new JLabel("Module 3 :");
        label55.setFont(new Font("Arial ", Font.BOLD, 20));
        label55.setForeground(Color.decode("#6495ED"));
        label55.setBounds(650, 471, 200, 30);
        label55.setHorizontalAlignment(SwingConstants.LEFT);
        add(label55);
        
               
        // adding the module3 text field
        
        JTextField module3 = new JTextField();
        module3.setCursor(Cursor.getPredefinedCursor(Cursor.TEXT_CURSOR));
        module3.setHorizontalAlignment(SwingConstants.LEFT);
        module3.setForeground(new Color(0, 0, 0));
        module3.setFont(new Font("Arial", Font.PLAIN, 20));
        module3.setBounds(810, 465, 300, 40);
        module3.setColumns(10);
        module3.setBorder(bordere);
        add(module3); 

        
        
        // adding a text -- adding a JLabel -- module 4
        
        JLabel label6 = new JLabel("Module 4 :");
        label6.setFont(new Font("Arial", Font.BOLD, 20));
        label6.setForeground(Color.decode("#6495ED"));
        label6.setBounds(650, 528, 200, 30);
        label6.setHorizontalAlignment(SwingConstants.LEFT);
        add(label6);
        
               
        // adding the module 4 text field
        
        JTextField module4 = new JTextField();
        module4.setCursor(Cursor.getPredefinedCursor(Cursor.TEXT_CURSOR));
        module4.setHorizontalAlignment(SwingConstants.LEFT);
        module4.setForeground(new Color(0, 0, 0));
        module4.setFont(new Font("Arial", Font.PLAIN, 20));
        module4.setBounds(810, 522, 700, 40);
        module4.setColumns(10);
        module4.setBorder(bordere);
        add(module4);  

        
       
        
        // adding a text -- adding a JLabel -- password
        
        JLabel label88 = new JLabel("Password :");
        label88.setFont(new Font("Arial", Font.BOLD, 20));
        label88.setForeground(Color.decode("#6495ED"));
        label88.setBounds(650, 586, 300, 30);
        label88.setHorizontalAlignment(SwingConstants.LEFT);
        add(label88);
       
     
        
        // adding password text field
        
        JTextField password = new JTextField();
        password.setForeground(new Color(0, 0, 0));
        password.setFont(new Font("Arial", Font.PLAIN, 20));
        password.setBounds(810, 580, 300, 40);
        password.setBorder(bordere); 
        add(password);  
        
        
        
        
        
        // adding a text -- adding a JLabel -- Birth date
        
        JLabel label8 = new JLabel("Birth Date :");
        label8.setFont(new Font("Arial", Font.BOLD, 20));
        label8.setForeground(Color.decode("#6495ED"));
        label8.setBounds(70, 653, 300, 30);
        label8.setHorizontalAlignment(SwingConstants.LEFT);
        add(label8);
       
     
        
        // adding birth date text field
        
        JTextField date = new JTextField();
        date.setForeground(new Color(0, 0, 0));
        date.setFont(new Font("Arial", Font.PLAIN, 20));
        date.setBounds(250, 647, 300, 40);
        date.setBorder(bordere);
        add(date);  
        
        
        
       
        
        
        
        // adding a text -- adding a JLabel -- adress
        
        JLabel label0 = new JLabel("Adress :");
        label0.setFont(new Font("Arial", Font.BOLD, 20));
        label0.setForeground(Color.decode("#6495ED"));
        label0.setBounds(650, 653, 300, 30);
        label0.setHorizontalAlignment(SwingConstants.LEFT);
        add(label0);
       
      
        
        // adding the adress text field
        
        JTextField adress = new JTextField();
        adress.setForeground(new Color(0, 0, 0));
        adress.setFont(new Font("Arial", Font.PLAIN, 20));
        adress.setBounds(810, 647, 800, 40);
        adress.setBorder(bordere);
        add(adress);  
        
        
        
        
   
        
        
         
        // Adding the edit button
        
        
        JButton edit_prof = new JButton() { 
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
        edit_prof.setText("edit");
        edit_prof.setHorizontalTextPosition(SwingConstants.CENTER);
        edit_prof.setForeground(new Color(255, 255, 255));
        edit_prof.setFont(new Font("consolas", Font.BOLD, 30));

        // Remove the default button styles
        edit_prof.setBorderPainted(false);
        edit_prof.setFocusPainted(false);
        edit_prof.setContentAreaFilled(false);
        edit_prof.setOpaque(false);        
        edit_prof.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
      
        // Set the button size and position
        edit_prof.setBounds(90, 780, 395, 40);  

        // Add the button to the panel
        add(edit_prof);

        
        edit_prof.addActionListener(new ActionListener() {
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
           	

                date.setEditable(true);
                password.setEditable(true);
                adress.setEditable(true);
                number.setEditable(true);
                
                
                label8.setForeground(Color.decode("#6ACF65"));
                label88.setForeground(Color.decode("#6ACF65"));
                label0.setForeground(Color.decode("#6ACF65"));
                label888.setForeground(Color.decode("#6ACF65"));
                
           	
            	
            }
        });
        
        
       
      
        
        
        
        
        
        // Adding the save button
    	
        
        JButton save_prof = new JButton() { 
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
        save_prof.setText("save"); 
        save_prof.setHorizontalTextPosition(SwingConstants.CENTER);
        save_prof.setForeground(new Color(255, 255, 255));
        save_prof.setFont(new Font("consolas", Font.BOLD, 30));

        // Remove the default button styles
        save_prof.setBorderPainted(false);
        save_prof.setFocusPainted(false);
        save_prof.setContentAreaFilled(false);
        save_prof.setOpaque(false);        
        save_prof.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
      

        // Set the button size and position
        save_prof.setBounds(700, 780, 395, 40);

        // Add the button to the panel
        add(save_prof);

        
        save_prof.addActionListener(new ActionListener() { 
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
           	
            	
            	
            	date.setEditable(false);
                password.setEditable(false);
                adress.setEditable(false);
                number.setEditable(false);
                
                label8.setForeground(Color.decode("#6495ED"));
                label88.setForeground(Color.decode("#6495ED"));
                label0.setForeground(Color.decode("#6495ED"));
                label888.setForeground(Color.decode("#6495ED"));
            	
            	
            	
         	
            	
            	
            	try { 
            		
            		
            		// update the phone number
                    
                	String slt2 = "UPDATE PROFESSEUR SET numero_telephone = ? WHERE id_Prof = ?";
            	    PreparedStatement select2 = connection.prepareStatement(slt2);
            	    select2.setString(1, number.getText());
            	    select2.setString(2, id);
            	    select2.executeUpdate();
            	    
            	    
            	    // update the birth date
            	    
            	   
            	    
            	    String slt3 = "UPDATE PROFESSEUR SET date_de_naissance = ? WHERE id_Prof = ?";
            	    PreparedStatement select3 = connection.prepareStatement(slt3);
            	    
            	    
            	    

            	    if (date.getText().isEmpty()) {
                	    
            	    	select3.setString(1,null );
             	    }
            	    
            	    
            	    else {
                	    
            	    	select3.setString(1, date.getText());
            	    }
           	    
            	    select3.setString(2, id);
            	    select3.executeUpdate();
            	    
            	    
            	    // update the account password
            	    
            	    String slt4 = "UPDATE PROFESSEUR SET mot_de_passe = ? WHERE id_Prof = ?";
            	    PreparedStatement select4 = connection.prepareStatement(slt4);
            	    select4.setString(1, password.getText());
            	    select4.setString(2, id);
            	    select4.executeUpdate();
            	    
            	    
            	    // update the adress
            	    
            	    String slt5 = "UPDATE PROFESSEUR SET adress = ? WHERE id_Prof = ?";
            	    PreparedStatement select5 = connection.prepareStatement(slt5);
            	    select5.setString(1, adress.getText());
            	    select5.setString(2, id);
            	    select5.executeUpdate();
            	    
            	    
            	  
            	}
            	
            	catch (Exception ez){
            		
            		ez.printStackTrace();
            	}
            	
            	
          	
            	
            }
        });
         
        

        
        
        // ---------------- Queries --------------------------------

        
        
        
        
        
        
        
       // Retrieve the personal informations from the database
        
        
        
        
        try {
            
            
        	
        	
        	
           //-------------- get the photo  from DB
        	
        	String query11 = "SELECT photo FROM PROFESSEUR WHERE id_Prof=?";
            PreparedStatement pstmt1 = connection.prepareStatement(query11);
            pstmt1.setString(1, id);
            
            // Execute the query and retrieve the result
            ResultSet rs1 = pstmt1.executeQuery();
            
            if (rs1.next()) {
            	// Get the photo data from the result set
            	InputStream inputStream = rs1.getBinaryStream("photo");

            	if (inputStream != null) {
            	    try {
            	        // Read the photo data into an Image object
            	        Image image = ImageIO.read(inputStream);

            	        // Set the image in the photo label
            	        photo.setIcon(new ImageIcon(image.getScaledInstance(215, photo.getHeight(), Image.SCALE_SMOOTH)));
            	    } catch (Exception e) {
            	        e.printStackTrace();
            	    } finally {
            	        // Close the input stream to free up resources
            	        try {
            	            inputStream.close();
            	        } catch (Exception e) {
            	            e.printStackTrace();
            	        }
            	    }
            	} else {
            	    //System.out.println("No photo data found for professor with ID: " + id);
            	}

            }
            


	
        	
        	
        	
        	
        	
        	//-------------- get the first name from DB
        	
        	String query1 = "SELECT nom FROM PROFESSEUR WHERE id_Prof=?";
            PreparedStatement pstmt = connection.prepareStatement(query1);
            pstmt.setString(1, id);
            
            // Execute the query and retrieve the result
            ResultSet rs = pstmt.executeQuery();
            
            if (rs.next()) {
            	
                // Set the value first to the retrieved first name
            	first.setText( rs.getString("nom"));
            	
            	// Disable editing 
                first.setEditable(false);
                first.setBackground(Color.white);
                
            }
 
            
           
            
            //--------------- get the second name from DB

            String query2 = "SELECT prenom FROM PROFESSEUR WHERE id_Prof=?";
            PreparedStatement pstmt2 = connection.prepareStatement(query2);
            pstmt2.setString(1, id);
            
            // Execute the query and retrieve the result
            ResultSet rs2 = pstmt2.executeQuery();
            
            if (rs2.next()) {
            	
                // Set the value first to the retrieved first name
            	second.setText( rs2.getString("prenom"));
            	
            	// Disable editing 
                second.setEditable(false);
                second.setBackground(Color.white);
                
            	
            	
            }   
            
            
            
            

            //--------------- get the email name from DB

            String query3 = "SELECT email FROM PROFESSEUR WHERE id_Prof=?";
            PreparedStatement pstmt3 = connection.prepareStatement(query3);
            pstmt3.setString(1, id);
            
            // Execute the query and retrieve the result
            ResultSet rs3 = pstmt3.executeQuery();
            
            if (rs3.next()) {
            	
                // Set the value first to the retrieved email
            	email.setText( rs3.getString("email"));
            	
            	// Disable editing 
            	email.setEditable(false);
            	email.setBackground(Color.white);
                
            	
            	
            }   
            
            
            
            

            //--------------- get the prof_id from DB

              
            prof_id.setText(id);
            	
            // Disable editing 
            prof_id.setEditable(false);
            prof_id.setBackground(Color.white);
                
            	
           
            
            
            //--------------- get the cin  from DB

            String query5 = "SELECT code_CIN FROM PROFESSEUR WHERE id_Prof=?";
            PreparedStatement pstmt5 = connection.prepareStatement(query5);
            pstmt5.setString(1, id);
            
            // Execute the query and retrieve the result
            ResultSet rs5 = pstmt5.executeQuery();
            
            if (rs5.next()) {
            	
                // Set the value first to the retrieved email
            	cin.setText( rs5.getString("code_CIN"));
            	
            	// Disable editing 
            	cin.setEditable(false);
            	cin.setBackground(Color.white);
                
            	
            	
            }   
               
            
            
            
            

            //--------------- get the phone number from DB

            String query6 = "SELECT numero_telephone FROM PROFESSEUR WHERE id_Prof=?";
            PreparedStatement pstmt6 = connection.prepareStatement(query6);
            pstmt6.setString(1, id);
            
            // Execute the query and retrieve the result
            ResultSet rs6 = pstmt6.executeQuery();
            
            if (rs6.next()) {
            	
                // Set the value first to the retrieved email
            	number.setText( rs6.getString("numero_telephone"));
            	
            	// Disable editing 
            	number.setEditable(false);
            	number.setBackground(Color.white);
                
            	
            	
            }   
           
        
            
            
            
            //--- birth day
            
            String query66 = "SELECT date_de_naissance FROM PROFESSEUR WHERE id_Prof=?";
            PreparedStatement pstmt66 = connection.prepareStatement(query66);
            pstmt66.setString(1, id);
            
            // Execute the query and retrieve the result
            ResultSet rs66 = pstmt66.executeQuery();
            
            if (rs66.next()) {
            	
                // Set the value first to the retrieved email
            	date.setText( rs66.getString("date_de_naissance"));
            	
            	// Disable editing 
            	date.setEditable(false);
            	date.setBackground(Color.white);

            }
            
            
            
  
            
            
            //--------------- get the phone number from DB

            String query7 = "SELECT departement FROM PROFESSEUR WHERE id_Prof=?";
            PreparedStatement pstmt7 = connection.prepareStatement(query7);
            pstmt7.setString(1, id);
            
            // Execute the query and retrieve the result
            ResultSet rs7 = pstmt7.executeQuery();
            
            if (rs7.next()) {
            	
                // Set the value
            	department.setText( rs7.getString("departement"));
            	
            	// Disable editing 
            	department.setEditable(false);
            	department.setBackground(Color.white);
                
            	
            	
            } 
            
            
            
            
           
            // get the modules
            
            
            
            
            
            String query8 = "SELECT nom_module FROM module WHERE id_Prof = ?";
            PreparedStatement pstmt8 = connection.prepareStatement(query8);
            pstmt8.setString(1, id);
            
            // Execute the query and retrieve the result
            ResultSet rs8 = pstmt8.executeQuery();
            
            
            
        
            
            // Store the results in an ArrayList
            
            ArrayList<String> modules = new ArrayList<>();
            
            while (rs8.next()) {
                String name = rs8.getString("nom_module");
                modules.add(name);
            }
            
            // Display the modules in the appropriate text fields
            
            for (int i = 0; i < modules.size(); i++) {
                String moduleName = modules.get(i);
                switch (i) {
                    case 0:
                        module1.setText(moduleName);
                        module2.setText("- - - - - - -");
                        module3.setText("- - - - - - -");
                        module4.setText("- - - - - - -");


                        break;
                    case 1:
                        module2.setText(moduleName);
                        break;
                    case 2:
                        module3.setText(moduleName);
                        break;
                    case 3:
                        module4.setText(moduleName);
                        break;
                }
            }
        
        
        
        
            // Disable editing 
        	module1.setEditable(false);
        	module1.setBackground(Color.white);
        
        	// Disable editing 
        	module2.setEditable(false);
        	module2.setBackground(Color.white);
        
            
        	// Disable editing 
        	module3.setEditable(false);
        	module3.setBackground(Color.white);
            
            
        	// Disable editing 
        	module4.setEditable(false);
        	module4.setBackground(Color.white);
            
            
            
            
            
        	 
            //--------------- get the password  from DB

            String query9 = "SELECT mot_de_passe FROM PROFESSEUR WHERE id_Prof=?";
            PreparedStatement pstmt9 = connection.prepareStatement(query9);
            pstmt9.setString(1, id);
            
            // Execute the query and retrieve the result
            ResultSet rs9 = pstmt9.executeQuery();
            
            if (rs9.next()) {
            	
                // Set the value first to the retrieved email
            	password.setText( rs9.getString("mot_de_passe"));
            	
            	// Disable editing 
            	password.setEditable(false);
            	password.setBackground(Color.white);
                
            	
            	
            }   
               
            
            
            
            // ---- adress
            
            String query99 = "SELECT adress FROM PROFESSEUR WHERE id_Prof=?";
            PreparedStatement pstmt99 = connection.prepareStatement(query99);
            pstmt99.setString(1, id);
            
            // Execute the query and retrieve the result
            ResultSet rs99 = pstmt99.executeQuery();
            
            if (rs99.next()) {
            	
                // Set the value first to the retrieved email
            	adress.setText( rs99.getString("adress"));
            	
            	// Disable editing 
            	adress.setEditable(false);
            	adress.setBackground(Color.white);
                
            } 
            
            
            
            
  
        
        } 
        catch (Exception e) {
            e.printStackTrace();
        }

        


        




    
        
        
        
        
        
        
    
    
    
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
    }
    
      

}

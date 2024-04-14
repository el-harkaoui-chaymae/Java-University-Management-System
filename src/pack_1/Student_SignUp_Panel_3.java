package pack_1;

import java.awt.*;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.File;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;
import java.awt.event.ActionEvent;

public class Student_SignUp_Panel_3 extends JPanel {

    private Image backgroundImage;

    public Student_SignUp_Panel_3() {
    	

        //establish the connection
        
    	Connection connection = DatabaseConnection.getConnection();

        
        //--------------------------------------------------------------------------------------------
        

    	
    	setLayout(null);

    	
        // Setting the background image
        ImageIcon icon = new ImageIcon("signUp.png");
    	setOpaque(false);
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
            	 
     	
            	
            	// open Entry Panel
                SwingUtilities.invokeLater(new Runnable() {
                    public void run() {
                        // create an instance of Entry_Panel_1
                        Entry_Panel_1 panel = new Entry_Panel_1();
                        
                        // add Entry_Panel_1 to the window
                        JFrame window = (JFrame)SwingUtilities.getWindowAncestor(Student_SignUp_Panel_3.this);
                        window.add(panel);
                        
                        // remove Professor_Entry_Panel_1 from the window
                        window.remove(Student_SignUp_Panel_3.this);
                        
                        // refresh the window
                        window.revalidate();
                        window.repaint();
                    }
                });
            }
        });
        
        
        
        
        
        
        
        
        
      
        
        // adding a text -- adding a JLabel -- Email adress
        
        JLabel label4 = new JLabel("E-mail Adress");
        label4.setFont(new Font("Century Gothic", Font.BOLD, 20));
        label4.setForeground(Color.decode("#6495ED"));
        label4.setBounds(876, 320, 200, 30);
        label4.setHorizontalAlignment(SwingConstants.LEFT);
        add(label4);
        
               
        // adding the email adress text field
        
        JTextField email_student = new JTextField();
        email_student.setCursor(Cursor.getPredefinedCursor(Cursor.TEXT_CURSOR));
        email_student.setHorizontalAlignment(SwingConstants.LEFT);
        email_student.setForeground(new Color(0, 0, 0));
        email_student.setFont(new Font("Arial", Font.PLAIN, 19));
        email_student.setBounds(876, 372, 450, 40);
        email_student.setColumns(10);
        add(email_student);
         
        
       

        Student_Check_Panel_17 pan = new Student_Check_Panel_17();
        String id = pan.getID();
        
        
        // Retrieve the email from the database
        String email = "";
        
        try {
            
            // Prepare the SQL statement
            String query1 = "SELECT email FROM ETUDIANT WHERE CNE=?";
            PreparedStatement pstmt = connection.prepareStatement(query1);
            pstmt.setString(1, id);
            
            // Execute the query and retrieve the result
            ResultSet rs = pstmt.executeQuery();
            
            if (rs.next()) {
                email = rs.getString("email");
            }
 
            // Set the value of the emailTextField to the retrieved email
            email_student.setText(" " + email);
            
            // Disable editing on the emailTextField
            email_student.setEditable(false);
            email_student.setBackground(Color.white);
            email_student.setBorder(BorderFactory.createLineBorder(Color.GRAY));

            // Prevent the emailTextField from being selected
            email_student.setFocusable(false);
            
            
            
            
        } catch (Exception e) {
            e.printStackTrace();
        }


        
        
        
    
        
        
        
        
        
        
        
        
        
        
       
        
        // adding a text -- adding a JLabel -- password
        
        JLabel label7 = new JLabel("Password");
        label7.setFont(new Font("Century Gothic", Font.BOLD, 20));
        label7.setForeground(Color.decode("#6495ED"));
        label7.setBounds(876, 430, 200, 30);
        label7.setHorizontalAlignment(SwingConstants.LEFT);
        add(label7);
        
         
               
        
        
        // adding the password text field
        
        JTextField password_student = new JPasswordField();
        password_student.setCursor(Cursor.getPredefinedCursor(Cursor.TEXT_CURSOR));
        password_student.setHorizontalAlignment(SwingConstants.LEFT);
        password_student.setForeground(new Color(0, 0, 0));
        password_student.setFont(new Font("Arial", Font.PLAIN, 19));
        password_student.setBounds(876, 463, 450, 40);
        password_student.setColumns(10);
        add(password_student);
        
        
  
        
        
        // adding a text -- adding a JLabel -- confirm password
        
        JLabel label9 = new JLabel("Confirm Password");
        label9.setFont(new Font("Century Gothic", Font.BOLD, 20));
        label9.setForeground(Color.decode("#6495ED"));
        label9.setBounds(876, 521, 200, 30);
        label9.setHorizontalAlignment(SwingConstants.LEFT);
        add(label9);
        
               
        // adding the confirm password text field
        
        JTextField confirm_password_student = new JPasswordField();
        confirm_password_student.setCursor(Cursor.getPredefinedCursor(Cursor.TEXT_CURSOR));
        confirm_password_student.setHorizontalAlignment(SwingConstants.LEFT);
        confirm_password_student.setForeground(new Color(0, 0, 0));
        confirm_password_student.setFont(new Font("Arial", Font.PLAIN, 19));
        confirm_password_student.setBounds(876, 553, 450, 40);
        confirm_password_student.setColumns(10);
        add(confirm_password_student); 
        
        
         
       
        
        
        // Adding a Login button
        
        JButton btnLogin_student = new JButton("log in");
        btnLogin_student.setHorizontalAlignment(SwingConstants.LEFT);
        btnLogin_student.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        btnLogin_student.setFont(new Font("arial", Font.BOLD, 22));
        btnLogin_student.setFocusPainted(false);
        btnLogin_student.setContentAreaFilled(false);
        btnLogin_student.setForeground(Color.decode("#6495ED"));
        btnLogin_student.setBorderPainted(false);
        btnLogin_student.setBounds(1149, 672, 303, 41);
        add(btnLogin_student);
        
        
 
        
        
        
        // Adding the sign up button
        
        JButton btn_signUp_student = new JButton() { 
            
            protected void paintComponent(Graphics g) {
                Graphics2D g2 = (Graphics2D) g;
                GradientPaint gradient = new GradientPaint(0, 0, Color.BLUE, getWidth(), getHeight(), Color.GREEN);
                g2.setPaint(gradient);
                g2.fillRect(0, 0, getWidth(), getHeight());
                super.paintComponent(g);
            }
        };

        btn_signUp_student.setText("sign up");
        btn_signUp_student.setHorizontalTextPosition(SwingConstants.CENTER);
        btn_signUp_student.setVerticalTextPosition(SwingConstants.CENTER);

		btn_signUp_student.setContentAreaFilled(false);

        btn_signUp_student.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        btn_signUp_student.setFocusPainted(false);
        btn_signUp_student.setFocusTraversalKeysEnabled(false);
        btn_signUp_student.setFocusable(false);
        btn_signUp_student.setBorder(null);
        btn_signUp_student.setForeground(new Color(255, 255, 255));
        btn_signUp_student.setFont(new Font("consolas", Font.BOLD, 30));
		btn_signUp_student.setBounds(876, 621,450,40);
        add(btn_signUp_student); 
        
        btn_signUp_student.addActionListener(new ActionListener() {
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
            	    String slt = "SELECT mot_de_passe FROM ETUDIANT WHERE CNE = ?";
            	    PreparedStatement select = connection.prepareStatement(slt);
            	    select.setString(1, id);
            	    ResultSet rs2 = select.executeQuery();

            	    if (rs2.next()) { // Check if the ResultSet contains any rows
            	        String passwordValue = rs2.getString("mot_de_passe");

            	        if (passwordValue == null) {
            	            String pass1 = password_student.getText();
            	            String pass2 = confirm_password_student.getText();
            	            if (!pass1.equals(pass2)) {
            	                JOptionPane.showMessageDialog(null, "Passwords do not match. Please try again.");
            	                password_student.setText("");
            	                confirm_password_student.setText("");
            	            } 
            	            
            	            
            	            else {
            	            	
             	            	
            	            	try {
            	            	    String newPassword = password_student.getText();

            	            	    String slt2 = "UPDATE ETUDIANT SET mot_de_passe = ? WHERE CNE = ?";
            	            	    PreparedStatement select2 = connection.prepareStatement(slt2);
            	            	    select2.setString(1, newPassword);
            	            	    select2.setString(2, id);
            	            	    int rowsAffected = select2.executeUpdate();

            	            	    
            	            	} catch (SQLException e2) {
            	            	    e2.printStackTrace();
            	            	}

            	            	
  	            	
            	            	
            	            	// Open Student_Space_Panel_19 panel panel
            	                SwingUtilities.invokeLater(new Runnable() {
            	                    public void run() {
            	                    	Student_Space_Panel_19 login = new Student_Space_Panel_19();

            	                        // Add Student_Space_Panel_19 to the window
            	                        JFrame window = (JFrame)SwingUtilities.getWindowAncestor(Student_SignUp_Panel_3.this);
            	                        window.add(login);

            	                        // Remove student sign up panel from the window
            	                        window.remove(Student_SignUp_Panel_3.this);

            	                        // Refresh the window
            	                        window.revalidate();
            	                        window.repaint();
            	                    }
            	                });
            	            }
            	        } 
            	        
            	        
            	        
            	        
            	        
            	        else {
            	        	
   	        	            
            	        	btnLogin_student.setForeground(Color.RED);

            	        	
            	        }
            	    
            	    } else {
            	        // empty
            	    }
            	} catch (SQLException e1) {
            	    e1.printStackTrace();
            	}

            	
            	
 
                
           	
            	
            }
        });
        
		
		
        
		
        

		
		
		
		// adding a text -- adding a JLabel -- Already a member ?
        
        JLabel label = new JLabel("Already a member ?");
        label.setFont(new Font("calibri", Font.BOLD, 21));
        label.setForeground(Color.BLACK);
        label.setBounds(954, 681, 200, 30);
        label.setHorizontalAlignment(SwingConstants.RIGHT);
        add(label);
  
       
             
        
        
         
        btnLogin_student.addActionListener(new ActionListener() {
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
 
            	
            	
            	// open Login panel
                SwingUtilities.invokeLater(new Runnable() {
                    public void run() {
                        // create an instance of Login_Panel
                    	Student_Login_Panel_5 login = new Student_Login_Panel_5();
                        
                        // add Student_Login_Panel_5 to the window
                        JFrame window = (JFrame)SwingUtilities.getWindowAncestor(Student_SignUp_Panel_3.this);
                        window.add(login);
                        
                        // remove student sign up panel from the window
                        window.remove(Student_SignUp_Panel_3.this);
                        
                        // refresh the window
                        window.revalidate();
                        window.repaint();
                    }
                });
            }
        });
        
		
	
        
        
        
          
        
    
       
    
    
    
    }
    
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);

    }

    
      

}

package pack_1;

import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.util.Arrays;
import java.awt.event.KeyEvent;
import java.awt.geom.RoundRectangle2D;
import java.io.File;
import java.awt.event.KeyAdapter;
import java.awt.*;
import java.sql.*;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.*;
import javax.swing.border.Border;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.LineBorder;

public class Professor_SignUp_Panel_2 extends JPanel {

    private Image backgroundImage;


    public Professor_SignUp_Panel_2() {
        setLayout(null);

        
        
        //establish the connection
        
    	Connection connection = DatabaseConnection.getConnection();

        
        //--------------------------------------------------------------------------------------------
        

    	
    	
        // Setting the background image
        setOpaque(false);
    	ImageIcon icon = new ImageIcon("signUp.png");
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
                        JFrame window = (JFrame)SwingUtilities.getWindowAncestor(Professor_SignUp_Panel_2.this);
                        window.add(panel);
                        
                        // remove Professor_Entry_Panel_1 from the window
                        window.remove(Professor_SignUp_Panel_2.this);
                        
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
        label4.setBounds(876, 335, 200, 30);
        label4.setHorizontalAlignment(SwingConstants.LEFT);
        add(label4);
        
               
        // adding the email adress text field
        
        JTextField email_prof = new JTextField();
        email_prof.setCursor(Cursor.getPredefinedCursor(Cursor.TEXT_CURSOR));
        email_prof.setHorizontalAlignment(SwingConstants.LEFT);
        email_prof.setForeground(new Color(0, 0, 0));
        email_prof.setFont(new Font("Arial", Font.PLAIN, 19));
        email_prof.setBounds(876, 372, 450, 40);
        email_prof.setColumns(10);
        add(email_prof);
         
        
        
        
        
        
        // new instance
       
        Professor_Check_Panel_16 pan = new Professor_Check_Panel_16();
        String id = pan.getID();
        
        
        // Retrieve the email from the database
        String email = "";
        
        try { 
            
            // Prepare the SQL statement
            String query1 = "SELECT email FROM PROFESSEUR WHERE id_Prof=?";
            PreparedStatement pstmt = connection.prepareStatement(query1);
            pstmt.setString(1, id);
            
            // Execute the query and retrieve the result
            ResultSet rs = pstmt.executeQuery();
            
            if (rs.next()) {
                email = rs.getString("email");
            }
 
            // Set the value of the emailTextField to the retrieved email
            email_prof.setText(" " + email);
            
            // Disable editing on the emailTextField
            email_prof.setEditable(false);
            email_prof.setBackground(Color.white);
            email_prof.setBorder(BorderFactory.createLineBorder(Color.GRAY));

            // Prevent the emailTextField from being selected
            email_prof.setFocusable(false);
            
            
            
            
        } catch (Exception e) {
            e.printStackTrace();
        }




        
        
        
        
        
    
        
       
        
        // adding a text -- adding a JLabel -- password
        
        JLabel label7 = new JLabel("Password");
        label7.setFont(new Font("Century Gothic", Font.BOLD, 20));
        label7.setForeground(Color.decode("#6495ED"));
        label7.setBounds(876, 425, 200, 30);
        label7.setHorizontalAlignment(SwingConstants.LEFT);
        add(label7);
        
         
               
        
        
        // adding the password text field
        
        JTextField password_prof = new JPasswordField();
        password_prof.setCursor(Cursor.getPredefinedCursor(Cursor.TEXT_CURSOR));
        password_prof.setHorizontalAlignment(SwingConstants.LEFT);
        password_prof.setForeground(new Color(0, 0, 0));
        password_prof.setFont(new Font("Arial", Font.PLAIN, 19));
        password_prof.setBounds(876, 458, 450, 40);
        password_prof.setColumns(10);
        add(password_prof);
        
        
        
        
  
        
        
        // adding a text -- adding a JLabel -- confirm password
        
        JLabel label9 = new JLabel("Confirm Password");
        label9.setFont(new Font("Century Gothic", Font.BOLD, 20));
        label9.setForeground(Color.decode("#6495ED"));
        label9.setBounds(876, 511, 200, 30);
        label9.setHorizontalAlignment(SwingConstants.LEFT);
        add(label9);
        
               
        // adding the confirm password text field
        
        JTextField confirm_password_prof = new JPasswordField();
        confirm_password_prof.setCursor(Cursor.getPredefinedCursor(Cursor.TEXT_CURSOR));
        confirm_password_prof.setHorizontalAlignment(SwingConstants.LEFT);
        confirm_password_prof.setForeground(new Color(0, 0, 0));
        confirm_password_prof.setFont(new Font("Arial", Font.PLAIN, 19));
        confirm_password_prof.setBounds(876, 543, 450, 40);
        confirm_password_prof.setColumns(10);
        add(confirm_password_prof); 
        
        
        
        
        
        // adding a text -- adding a JLabel -- you are Already a member 
        
        JLabel label9999 = new JLabel("You are Already a member !");
        label9999.setFont(new Font("calibri", Font.BOLD, 21));
        label9999.setForeground(Color.RED);
        label9999.setHorizontalAlignment(SwingConstants.LEFT);
        
        
        
        
        
        
        
        
        // Adding a Login button
        
        JButton btnLogin = new JButton("log in");
        btnLogin.setHorizontalAlignment(SwingConstants.LEFT);
        btnLogin.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        btnLogin.setFont(new Font("arial", Font.BOLD, 22));
        btnLogin.setFocusPainted(false);
        btnLogin.setContentAreaFilled(false);
        btnLogin.setForeground(Color.decode("#6495ED"));
        btnLogin.setBorderPainted(false);
        btnLogin.setBounds(1149, 672, 303, 41);
        add(btnLogin);
        
        
        
        
        
        
        
        
        
       
        
        // Adding the sign up button
        
        JButton btn_signUp_prof = new JButton() {
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
        btn_signUp_prof.setText("sign up"); 
        btn_signUp_prof.setHorizontalTextPosition(SwingConstants.CENTER);
        btn_signUp_prof.setForeground(new Color(255, 255, 255));
        btn_signUp_prof.setFont(new Font("consolas", Font.BOLD, 30));

        // Remove the default button styles
        btn_signUp_prof.setBorderPainted(false);
        btn_signUp_prof.setFocusPainted(false);
        btn_signUp_prof.setContentAreaFilled(false);
        btn_signUp_prof.setOpaque(false);        
        btn_signUp_prof.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btn_signUp_prof.setBounds(876, 621,450,40);
        add(btn_signUp_prof); 
        
        btn_signUp_prof.addActionListener(new ActionListener() {
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
            	    String slt = "SELECT mot_de_passe FROM PROFESSEUR WHERE id_Prof = ?";
            	    PreparedStatement select = connection.prepareStatement(slt);
            	    select.setString(1, id);
            	    ResultSet rs2 = select.executeQuery();

            	    if (rs2.next()) { // Check if the ResultSet contains any rows
            	        String passwordValue = rs2.getString("mot_de_passe");

            	        if (passwordValue == null) {
            	            String pass1 = password_prof.getText();
            	            String pass2 = confirm_password_prof.getText();
            	            if (!pass1.equals(pass2)) {
            	                JOptionPane.showMessageDialog(null, "Passwords do not match. Please try again.");
            	                password_prof.setText("");
            	                confirm_password_prof.setText("");
            	            } 
            	            
            	            
            	            else {
            	            	
            	            	
            	            	try {
            	            	    String newPassword = password_prof.getText();

            	            	    String slt2 = "UPDATE PROFESSEUR SET mot_de_passe = ? WHERE id_Prof = ?";
            	            	    PreparedStatement select2 = connection.prepareStatement(slt2);
            	            	    select2.setString(1, newPassword);
            	            	    select2.setString(2, id);
            	            	    int rowsAffected = select2.executeUpdate();

            	            	    
            	            	} catch (SQLException e2) {
            	            	    e2.printStackTrace();
            	            	}

            	            	
  	            	
            	            	
            	            	// Open professor space panel panel
            	                SwingUtilities.invokeLater(new Runnable() {
            	                    public void run() {
            	                        Professor_Space_Panel_12 login = new Professor_Space_Panel_12();

            	                        // Add Professor_Space_Panel_12 to the window
            	                        JFrame window = (JFrame)SwingUtilities.getWindowAncestor(Professor_SignUp_Panel_2.this);
            	                        window.add(login);

            	                        // Remove professor sign up panel from the window
            	                        window.remove(Professor_SignUp_Panel_2.this);

            	                        // Refresh the window
            	                        window.revalidate();
            	                        window.repaint();
            	                    }
            	                });
            	            }
            	        } 
            	        
            	        
            	        
            	        
            	        
            	        else {
            	        	
   	        	            
            	            btnLogin.setForeground(Color.RED);

            	        	
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
  
       
             
        
        // log in btn
        
        btnLogin.addActionListener(new ActionListener() {
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
                        // create an instance of Login_Panel_4
                    	Professor_Login_Panel_4 login = new Professor_Login_Panel_4();
                        
                        // add Login_Panel_4 to the window
                        JFrame window = (JFrame)SwingUtilities.getWindowAncestor(Professor_SignUp_Panel_2.this);
                        window.add(login);
                        
                        // remove professor entry panel from the window
                        window.remove(Professor_SignUp_Panel_2.this);
                        
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

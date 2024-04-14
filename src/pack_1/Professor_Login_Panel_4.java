package pack_1;

import java.io.File;
import java.sql.Connection;
import java.awt.*;
import javax.sound.sampled.AudioSystem;
import java.sql.*;
import javax.sound.sampled.Clip;
import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.geom.RoundRectangle2D;
import java.awt.event.ActionEvent;

public class Professor_Login_Panel_4 extends JPanel {

    private Image backgroundImage;

    public Professor_Login_Panel_4() {
        
    	
    	
        //establish the connection
        
    	Connection connection = DatabaseConnection.getConnection();

        
        //--------------------------------------------------------------------------------------------
    	
    	
  	
    	setLayout(null);

    	
    	 
        // Setting the background image
        ImageIcon icon = new ImageIcon("login.png");
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
            	
            	// open Professor Entry Panel Panel
                SwingUtilities.invokeLater(new Runnable() {
                    public void run() {
                        // create an instance of Professor_Entry_Panel_2
                    	Professor_SignUp_Panel_2 panel = new Professor_SignUp_Panel_2();
                        
                        // add Professor_Entry_Panel_2 to the window
                        JFrame window = (JFrame)SwingUtilities.getWindowAncestor(Professor_Login_Panel_4.this);
                        window.add(panel);
                        
                        // remove Professor_Entry_Panel_1 from the window
                        window.remove(Professor_Login_Panel_4.this);
                        
                        // refresh the window
                        window.revalidate();
                        window.repaint();
                    }
                });
            }
        });
        
        
        
		
        
        
        
        // adding a text -- adding a JLabel -- not match
        
        JLabel label00 = new JLabel("Invalid email or password.");
        label00.setFont(new Font("Century Gothic", Font.BOLD, 20));
        label00.setForeground(Color.red);
        label00.setHorizontalAlignment(SwingConstants.LEFT);
        
        
        
        
        
        
        
        
        
		
		
        // adding a text -- adding a JLabel -- enter Email adress
        
        JLabel label4 = new JLabel("E-mail Adress");
        label4.setFont(new Font("Century Gothic", Font.BOLD, 20));
        label4.setForeground(Color.decode("#6495ED"));
        label4.setBounds(807, 410, 200, 30);
        label4.setHorizontalAlignment(SwingConstants.RIGHT);
        add(label4);
        
               
        // adding the email adress text field
        
        JTextField email = new JTextField();
        email.setCursor(Cursor.getPredefinedCursor(Cursor.TEXT_CURSOR));
        email.setHorizontalAlignment(SwingConstants.LEFT);
        email.setForeground(new Color(0, 0, 0));
        email.setFont(new Font("Arial", Font.PLAIN, 19));
        email.setBounds(876, 443, 450, 40);
        email.setColumns(10); 
        add(email);
        
        // adding a text -- adding a JLabel -- password
        
        JLabel label8 = new JLabel("Password");
        label8.setFont(new Font("Century Gothic", Font.BOLD, 20));
        label8.setForeground(Color.decode("#6495ED"));
        label8.setBounds(768, 501, 200, 30);
        label8.setHorizontalAlignment(SwingConstants.RIGHT);
        add(label8);
        
               
        // adding the password text field
        
        JTextField password2 = new JPasswordField();
        password2.setCursor(Cursor.getPredefinedCursor(Cursor.TEXT_CURSOR));
        password2.setHorizontalAlignment(SwingConstants.LEFT);
        password2.setForeground(new Color(0, 0, 0));
        password2.setFont(new Font("Arial", Font.PLAIN, 19));
        password2.setBounds(876, 533, 450, 40);
        password2.setColumns(10);
        add(password2);
        
       
		
		

		
        
         
        
        
        
        // new instance to take the entered ID
        
        
        Professor_Check_Panel_16 pan = new Professor_Check_Panel_16();
        String id = pan.getID();
        
        
        
        
        
        
        
        
        
        // Adding the sign in button 
		    	
        JButton signin = new JButton() {
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
        signin.setText("sign in"); 
        signin.setHorizontalTextPosition(SwingConstants.CENTER);
        signin.setForeground(new Color(255, 255, 255));
        signin.setFont(new Font("consolas", Font.BOLD, 30));

        // Remove the default button styles
        signin.setBorderPainted(false);
        signin.setFocusPainted(false);
        signin.setContentAreaFilled(false);
        signin.setOpaque(false);        
        signin.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        signin.setBounds(876, 621,450,40);
        add(signin);
        
        signin.addActionListener(new ActionListener() {
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
 
            	
            	
            	
            	
            	String emailAdress = email.getText();
                String password = password2.getText();
                
                try {
                    
                    // Prepare a SELECT statement with a WHERE clause that matches the email and password
                    String sql = "SELECT email, mot_de_passe FROM PROFESSEUR WHERE id_Prof = ? ";
                    PreparedStatement statement = connection.prepareStatement(sql);
                    statement.setString(1, id);
                    
                    // Execute the SELECT statement
                    ResultSet result = statement.executeQuery();
                    
                    // Check if a row was returned
                    if (result.next()) {
                        

                    	if (emailAdress.equals(result.getString("email")) &&  password.equals(result.getString("mot_de_passe") ) ) {
                    	
                    	
                    	  // The email and password match
                    
                          // open Professor space panel
                          SwingUtilities.invokeLater(new Runnable() {
                            public void run() {
                                // create an instance of professor space panel
                            	Professor_Space_Panel_12 login = new Professor_Space_Panel_12();
                                
                                // add professor space panel to the window
                                JFrame window = (JFrame)SwingUtilities.getWindowAncestor(Professor_Login_Panel_4.this);
                                window.add(login);
                                
                                // remove professor login panel from the window
                                window.remove(Professor_Login_Panel_4.this);
                                
                                // refresh the window
                                window.revalidate();
                                window.repaint();
                            }
                          });
                    
                    
                    
                    
                    	} 
                    
                        
                    
                    	else {
                            // The email and password do not match
                            
                            add(label00);
                            label00.setBounds(876, 730, 600, 30);
                    
                    	}
                    
                    
                 
                    
                    } 
                    
                     
                } catch (SQLException e3) {
                    e3.printStackTrace();
                }
  
            	
            	
            }
        });
        
        
        
        
        
     
        
        
        

        
        
        
        // adding a text -- adding a JLabel -- Forgot your Password ?
        
        JLabel label = new JLabel("Forgot your Password ?");
        label.setFont(new Font("calibri", Font.BOLD, 21));
        label.setForeground(Color.BLACK);
        label.setBounds(864, 676, 300, 30);
        label.setHorizontalAlignment(SwingConstants.RIGHT);
        add(label);
  
       
             
        
        // Adding a Reset button
        
        JButton btnReset = new JButton("Reset");
        btnReset.setHorizontalAlignment(SwingConstants.LEFT);
        btnReset.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        btnReset.setFont(new Font("arial", Font.BOLD, 22));
        btnReset.setFocusPainted(false);
        btnReset.setContentAreaFilled(false);
        btnReset.setForeground(Color.decode("#6495ED"));
        btnReset.setBorderPainted(false);
        btnReset.setBounds(1156, 667, 303, 41);
        add(btnReset);
        
        btnReset.addActionListener(new ActionListener() {
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
 
            	
            	
            	// open Professor reset email panel
                SwingUtilities.invokeLater(new Runnable() {
                    public void run() {
                        // create an instance of professor reset email panel
                    	Professor_Reset_Email_Panel_6 login = new Professor_Reset_Email_Panel_6();
                        
                        // add professor reset email panel to the window
                        JFrame window = (JFrame)SwingUtilities.getWindowAncestor(Professor_Login_Panel_4.this);
                        window.add(login);
                        
                        // remove professor login panel from the window
                        window.remove(Professor_Login_Panel_4.this);
                        
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

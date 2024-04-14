package pack_1;

import java.io.File;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.*;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Student_Login_Panel_5 extends JPanel {

    private Image backgroundImage;

    public Student_Login_Panel_5() {
    	
    	
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
                	   	
            	
            	// open Student sing up Panel Panel
                SwingUtilities.invokeLater(new Runnable() {
                    public void run() {
                        // create an instance of Student_SignUp_Panel_2
                    	Student_SignUp_Panel_3 panel = new Student_SignUp_Panel_3();
                        
                        // add Student_SignUp_Panel_2 to the window
                        JFrame window = (JFrame)SwingUtilities.getWindowAncestor(Student_Login_Panel_5.this);
                        window.add(panel);
                        
                        // remove Student_Login_Panel_5 from the window
                        window.remove(Student_Login_Panel_5.this);
                        
                        // refresh the window
                        window.revalidate();
                        window.repaint();
                    }
                });
            }
        });
        
        
        
		
		
		
        // adding a text -- adding a JLabel -- enter Email adress
        
        JLabel label4 = new JLabel("E-mail Adress");
        label4.setFont(new Font("Century Gothic", Font.BOLD, 20));
        label4.setForeground(Color.decode("#6495ED"));
        label4.setBounds(807, 410, 200, 30);
        label4.setHorizontalAlignment(SwingConstants.RIGHT);
        add(label4);
        
               
        // adding the email adress text field
        
        JTextField email_student_2 = new JTextField();
        email_student_2.setCursor(Cursor.getPredefinedCursor(Cursor.TEXT_CURSOR));
        email_student_2.setHorizontalAlignment(SwingConstants.LEFT);
        email_student_2.setForeground(new Color(0, 0, 0));
        email_student_2.setFont(new Font("Arial", Font.PLAIN, 19));
        email_student_2.setBounds(876, 443, 450, 40);
        email_student_2.setColumns(10);
        add(email_student_2);
        
        // adding a text -- adding a JLabel -- password
        
        JLabel label8 = new JLabel("Password");
        label8.setFont(new Font("Century Gothic", Font.BOLD, 20));
        label8.setForeground(Color.decode("#6495ED"));
        label8.setBounds(768, 501, 200, 30);
        label8.setHorizontalAlignment(SwingConstants.RIGHT);
        add(label8);
        
               
        // adding the password text field
        
        JTextField password3 = new JPasswordField();
        password3.setCursor(Cursor.getPredefinedCursor(Cursor.TEXT_CURSOR));
        password3.setHorizontalAlignment(SwingConstants.LEFT);
        password3.setForeground(new Color(0, 0, 0));
        password3.setFont(new Font("Arial", Font.PLAIN, 19));
        password3.setBounds(876, 533, 450, 40);
        password3.setColumns(10);
        add(password3);
        
       
        
        // adding a text -- adding a JLabel -- not match
        
        JLabel label00 = new JLabel("Invalid email or password.");
        label00.setFont(new Font("Century Gothic", Font.BOLD, 20));
        label00.setForeground(Color.red);
        label00.setHorizontalAlignment(SwingConstants.LEFT);
        
     
        
        
        // new instance for CNE
        
        Student_Check_Panel_17 pan = new Student_Check_Panel_17();
        String id = pan.getID();
        
        
        // Adding the sign in button 
    	
     	JButton signin_student = new JButton() {
                 @Override
                 protected void paintComponent(Graphics g) {
                     Graphics2D g2 = (Graphics2D) g;
                     GradientPaint gradient = new GradientPaint(0, 0, Color.BLUE, getWidth(), getHeight(), Color.GREEN);
                     g2.setPaint(gradient);
                     g2.fillRect(0, 0, getWidth(), getHeight());
                     super.paintComponent(g);
                 }
        };

        signin_student.setText("sign in");
        signin_student.setHorizontalTextPosition(SwingConstants.CENTER);
        signin_student.setContentAreaFilled(false);

        signin_student.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        signin_student.setFocusPainted(false);
        signin_student.setFocusTraversalKeysEnabled(false);
        signin_student.setFocusable(false);
        signin_student.setBorder(null);
        signin_student.setForeground(new Color(255, 255, 255));
        signin_student.setFont(new Font("consolas", Font.BOLD, 30));
        signin_student.setBounds(876, 621,450,40);
        add(signin_student);
       
        
        signin_student.addActionListener(new ActionListener() {
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
 
            	
            	
            	
            	
            	String emailAdress = email_student_2.getText();
                String password = password3.getText();
                
                try {
                    
                    // Prepare a SELECT statement with a WHERE clause that matches the email and password
                    String sql = "SELECT email, mot_de_passe FROM ETUDIANT WHERE CNE = ? ";
                    PreparedStatement statement = connection.prepareStatement(sql);
                    statement.setString(1, id);
                    
                    // Execute the SELECT statement
                    ResultSet result = statement.executeQuery();
                    
                    // Check if a row was returned
                    if (result.next()) {
                        

                    	if (emailAdress.equals(result.getString("email")) &&  password.equals(result.getString("mot_de_passe") ) ) {
                    	
                    	
                    	  // The email and password match
                    
                          // open Student_Space_Panel_19
                          SwingUtilities.invokeLater(new Runnable() {
                            public void run() {
                                // create an instance of professor space panel
                            	Student_Space_Panel_19 login = new Student_Space_Panel_19();
                                
                                // add Student_Space_Panel_19   to the window
                                JFrame window = (JFrame)SwingUtilities.getWindowAncestor(Student_Login_Panel_5.this);
                                window.add(login);
                                
                                // remove professor login panel from the window
                                window.remove(Student_Login_Panel_5.this);
                                
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
        label.setBounds(864, 681, 300, 30);
        label.setHorizontalAlignment(SwingConstants.RIGHT);
        add(label);
  
       
             
        
        // Adding a Reset button
        
        JButton btnReset2 = new JButton("Reset");
        btnReset2.setHorizontalAlignment(SwingConstants.LEFT);
        btnReset2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        btnReset2.setFont(new Font("arial", Font.BOLD, 22));
        btnReset2.setFocusPainted(false);
        btnReset2.setContentAreaFilled(false);
        btnReset2.setForeground(Color.decode("#6495ED"));
        btnReset2.setBorderPainted(false);
        btnReset2.setBounds(1156, 672, 303, 41);
        add(btnReset2);
        
        btnReset2.addActionListener(new ActionListener() {
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
 
            	
            	
            	// open student reset email panel
                SwingUtilities.invokeLater(new Runnable() {
                    public void run() {
                        // create an instance of student reset email panel
                    	Student_Reset_Email_Panel_9 login = new Student_Reset_Email_Panel_9();
                        
                        // add student reset email panel to the window
                        JFrame window = (JFrame)SwingUtilities.getWindowAncestor(Student_Login_Panel_5.this);
                        window.add(login);
                        
                        // remove professor login panel from the window
                        window.remove(Student_Login_Panel_5.this);
                        
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

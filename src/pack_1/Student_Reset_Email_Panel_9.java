package pack_1;

import java.io.File;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.*;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


import java.util.Properties;

import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Random;


import javax.mail.*;


	


public class Student_Reset_Email_Panel_9 extends JPanel {

    private Image backgroundImage;
    
    public static int student_verificationCode;
    
    static {
        
    	// Generate a random verification code once for all instances 
        
    	Random random = new Random();
        student_verificationCode = random.nextInt(9000) + 1000;
    }
    
  
     
    public Student_Reset_Email_Panel_9() {
        

        //establish the connection
        
    	Connection connection = DatabaseConnection.getConnection();

        
        //--------------------------------------------------------------------------------------------
    	
    	
    	
    	
        // new instance to take the entered CNE
        
        
        Professor_Check_Panel_16 pan = new Professor_Check_Panel_16();
        String id = pan.getID();
        
    	
    	
    	
    	
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
           	
            	// open student Login Panel
                SwingUtilities.invokeLater(new Runnable() {
                    public void run() {
                        // create an instance of Student_Login_Panel_5
                    	Student_Login_Panel_5 panel = new Student_Login_Panel_5();
                        
                        // add Student_Login_Panel_5 to the window
                        JFrame window = (JFrame)SwingUtilities.getWindowAncestor(Student_Reset_Email_Panel_9.this);
                        window.add(panel);
                        
                        // remove Professor_Entry_Panel_1 from the window
                        window.remove(Student_Reset_Email_Panel_9.this);
                        
                        // refresh the window
                        window.revalidate();
                        window.repaint();
                    }
                });
            }
        });
        
        
        
        
        // adding a text -- adding a JLabel -- enter invalid email
        
        JLabel label55 = new JLabel("Invalid E-mail Adress !");
        label55.setFont(new Font("Century Gothic", Font.BOLD, 20));
        label55.setForeground(Color.red);
        label55.setHorizontalAlignment(SwingConstants.LEFT);
        

        
        
        // adding a text -- adding a JLabel -- enter Email adress to verify
        
        JLabel label4 = new JLabel("Enter your Inscription E-mail Adress and we'll");
        label4.setFont(new Font("Century Gothic", Font.BOLD, 20));
        label4.setForeground(Color.BLACK);
        label4.setBounds(876, 629, 700, 30);
        label4.setHorizontalAlignment(SwingConstants.LEFT);
        add(label4);
        
        
        
        // adding a text -- adding a JLabel -- enter Email adress to verify
        
        JLabel label8 = new JLabel("Send you a Verification Code. ");
        label8.setFont(new Font("Arial", Font.BOLD, 20));
        label8.setForeground(Color.BLACK);
        label8.setBounds(876, 659, 700, 30);
        label8.setHorizontalAlignment(SwingConstants.LEFT);
        add(label8);
        
        
        
      
        
        
        
        // adding a text -- adding a JLabel -- enter Email adress
        
        JLabel label5 = new JLabel("E-mail Adress");
        label5.setFont(new Font("Century Gothic", Font.BOLD, 20));
        label5.setForeground(Color.decode("#6495ED"));
        label5.setBounds(808, 420, 200, 30);
        label5.setHorizontalAlignment(SwingConstants.RIGHT);
        add(label5);
        
               
        // adding the email adress text field
        
        JTextField student_email_verification = new JTextField();
        student_email_verification.setCursor(Cursor.getPredefinedCursor(Cursor.TEXT_CURSOR));
        student_email_verification.setHorizontalAlignment(SwingConstants.LEFT);
        student_email_verification.setForeground(new Color(0, 0, 0));
        student_email_verification.setFont(new Font("Arial", Font.PLAIN, 19));
        student_email_verification.setBounds(876, 453, 450, 40);
        student_email_verification.setColumns(10);
        add(student_email_verification);
        
        
        
     // Adding the send button 
    	
     		JButton student_send = new JButton() {
                 @Override
                 protected void paintComponent(Graphics g) {
                     Graphics2D g2 = (Graphics2D) g;
                     GradientPaint gradient = new GradientPaint(0, 0, Color.BLUE, getWidth(), getHeight(), Color.GREEN);
                     g2.setPaint(gradient);
                     g2.fillRect(0, 0, getWidth(), getHeight());
                     super.paintComponent(g);
                 }
             };

             student_send.setText("Send");
             student_send.setHorizontalTextPosition(SwingConstants.CENTER);
             student_send.setContentAreaFilled(false);

             student_send.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
             student_send.setFocusPainted(false);
             student_send.setFocusTraversalKeysEnabled(false);
             student_send.setFocusable(false);
             student_send.setBorder(null);
             student_send.setForeground(new Color(255, 255, 255));
             student_send.setFont(new Font("consolas", Font.BOLD, 30));
             student_send.setBounds(876, 530,450,40);
             add(student_send);
             
             
             
            
             
            
            

             student_send.addActionListener(new ActionListener() {
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
                  	  
                  	
                     
                  	
                  	

                	
                	String emailAdress = student_email_verification.getText();
                     
                    try {
                        
                        // Prepare a SELECT statement 
                        String sql = "SELECT email FROM PROFESSEUR WHERE id_Prof = ? ";
                        PreparedStatement statement = connection.prepareStatement(sql);
                        statement.setString(1, id);
                        
                        // Execute the SELECT statement
                        ResultSet result = statement.executeQuery();
                        
                        // Check if a row was returned
                        if (result.next()) {
                            

                        	if (emailAdress.equals(result.getString("email"))  ) {
                        	
                        	
                        	  // The emails match
                        
                              
                        	 // create the email message
                           	 String to = student_email_verification.getText();
                           	 String subject = "Verification Code";
                           	 String body = "You want to reset your Account password. Your verification code is: " + student_verificationCode;
                           	 String from = "ensakh.system@gmail.com";
                           	 String password = "Password198";
                           	 
                           	 // Email server properties
                             Properties props = new Properties();
                             props.put("mail.smtp.host", "smtp.gmail.com");
                             props.put("mail.smtp.port", "587");
                             props.put("mail.smtp.auth", "true");
                             props.put("mail.smtp.starttls.enable", "true");

                           	 Session session = Session.getInstance(props, new javax.mail.Authenticator() {
                           	     protected PasswordAuthentication getPasswordAuthentication() {
                           	         return new PasswordAuthentication(from, "bpjuynnwrclvkwgp");
                           	     }
                           	 });

                           	 try {
                           	     Message message = new MimeMessage(session);
                           	     message.setFrom(new InternetAddress(from));
                           	     message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));
                           	     message.setSubject(subject);
                           	     message.setText(body);

                           	     // send the email
                           	     Transport.send(message);
                           	     
                           	     
                           	     // open student reset verification panel
                                    SwingUtilities.invokeLater(new Runnable() {
                                        public void run() {
                                            // create an instance of studen reset verification panel
                                        	Student_Reset_Verification_Panel_10 login = new Student_Reset_Verification_Panel_10();
                                            
                                            // add student reset verification panel to the window
                                            JFrame window = (JFrame)SwingUtilities.getWindowAncestor(Student_Reset_Email_Panel_9.this);
                                            window.add(login);
                                            
                                            // remove professor reset email panel from the window
                                            window.remove(Student_Reset_Email_Panel_9.this);
                                            
                                            // refresh the window
                                            window.revalidate();
                                            window.repaint();
                                        }
                                    });
                           	     
                           	     
                           	     
                      	     

                           	 } catch (MessagingException e1) {
                           	     e1.printStackTrace();
                           	     JOptionPane.showMessageDialog(null, "Error sending email. Please try again.");
                           	 }
                           	 
                           	 
                        		
                        		
                        
                        
                        	} 
                        
                            
                        
                        	else {
                                // The emails do not match
                                
                                
                        		
                        		
                        		remove(label4);
                                remove(label8);
         
                                // revalidate and repaint the panel
                                revalidate();
                                repaint();
                        		
                        		
                        		
                        		add(label55);
                                label55.setBounds(876, 629, 700, 30);

                        	}
                        }
                	 
                    }
                  	
                    catch(Exception er) {
                    	er.printStackTrace();	
                    
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

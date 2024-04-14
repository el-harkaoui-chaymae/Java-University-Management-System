package pack_1;

import java.io.File;
import java.awt.*;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Student_Reset_Verification_Panel_10  extends JPanel {

    private Image backgroundImage;

    public Student_Reset_Verification_Panel_10() {
        
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
            	
            	// open Professor reset email Panel
                SwingUtilities.invokeLater(new Runnable() {
                    public void run() {
                        // create an instance of Student_Reset_Email_Panel_9
                    	Student_Reset_Email_Panel_9 panel = new Student_Reset_Email_Panel_9();
                        
                        // add Student_Reset_Email_Panel_9 to the window
                        JFrame window = (JFrame)SwingUtilities.getWindowAncestor(Student_Reset_Verification_Panel_10.this);
                        window.add(panel);
                        
                        // remove Professor_Reset_Verification_Panel_7 from the window
                        window.remove(Student_Reset_Verification_Panel_10.this);
                        
                        // refresh the window
                        window.revalidate();
                        window.repaint();
                    }
                });
            }
        });
        
        
        
        
        // adding a text -- adding a JLabel -- enter verification code to verify
        
        JLabel label4 = new JLabel("Check your E-mails and enter the verification");
        label4.setFont(new Font("Century Gothic", Font.BOLD, 20));
        label4.setForeground(Color.BLACK);
        label4.setBounds(876, 629, 700, 30);
        label4.setHorizontalAlignment(SwingConstants.LEFT);
        add(label4);
        
        
        // adding a text -- adding a JLabel -- enter verification code to verify
        
        JLabel label50 = new JLabel("code.");
        label50.setFont(new Font("Century Gothic", Font.BOLD, 20));
        label50.setForeground(Color.BLACK);
        label50.setBounds(876, 659, 700, 30);
        label50.setHorizontalAlignment(SwingConstants.LEFT);
        add(label50);
        
        
        

        
        
        // adding a text -- adding a JLabel -- enter verification code
        
        JLabel label5 = new JLabel("Verification Code");
        label5.setFont(new Font("Century Gothic", Font.BOLD, 20));
        label5.setForeground(Color.decode("#6495ED"));
        label5.setBounds(876, 420, 200, 30);
        label5.setHorizontalAlignment(SwingConstants.LEFT);
        add(label5);
        
    
        
        
        // adding the verification code text field
        
        JTextField student_verification_code = new JTextField();
        student_verification_code.setCursor(Cursor.getPredefinedCursor(Cursor.TEXT_CURSOR));
        student_verification_code.setHorizontalAlignment(SwingConstants.LEFT);
        student_verification_code.setForeground(new Color(0, 0, 0));
        student_verification_code.setFont(new Font("Arial", Font.PLAIN, 19));
        student_verification_code.setBounds(876, 453, 450, 40);
        student_verification_code.setColumns(10);
        add(student_verification_code);
        
        
        
        // Adding the verify button 
    	
     		JButton student_verify = new JButton() {
                 @Override
                 protected void paintComponent(Graphics g) {
                     Graphics2D g2 = (Graphics2D) g;
                     GradientPaint gradient = new GradientPaint(0, 0, Color.BLUE, getWidth(), getHeight(), Color.GREEN);
                     g2.setPaint(gradient);
                     g2.fillRect(0, 0, getWidth(), getHeight());
                     super.paintComponent(g);
                 }
             };

             student_verify.setText("Verify");
             student_verify.setHorizontalTextPosition(SwingConstants.CENTER);
             student_verify.setContentAreaFilled(false);

             student_verify.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
             student_verify.setFocusPainted(false);
             student_verify.setFocusTraversalKeysEnabled(false);
             student_verify.setFocusable(false);
             student_verify.setBorder(null);
             student_verify.setForeground(new Color(255, 255, 255));
             student_verify.setFont(new Font("consolas", Font.BOLD, 30));
             student_verify.setBounds(876, 530,450,40);
             add(student_verify);
             
             
             student_verify.addActionListener(new ActionListener() {
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
                	 
         	 
                   	Student_Reset_Email_Panel_9 pan = new Student_Reset_Email_Panel_9 ();
                     
                    String code =  Integer.toString(pan.student_verificationCode);
                   	
                   	if (code.equals(student_verification_code.getText() )) {
                  	 
                		 
                		
                      	// open Professor reset password panel
                          SwingUtilities.invokeLater(new Runnable() {
                              public void run() {
                                  // create an instance of student reset password panel
                              	Student_Reset_Password_Panel_11 login = new Student_Reset_Password_Panel_11();
                                  
                                  // add professor reset password panel to the window
                                  JFrame window = (JFrame)SwingUtilities.getWindowAncestor(Student_Reset_Verification_Panel_10.this);
                                  window.add(login);
                                  
                                  // remove student reset verification panel from the window
                                  window.remove(Student_Reset_Verification_Panel_10.this);
                                  
                                  // refresh the window
                                  window.revalidate();
                                  window.repaint();
                              }
                          });
                		 
                		 
                		 
                		 
                	 } else {
                		 
                		 JOptionPane.showMessageDialog(null, "Incorrect Verification Code. Please Check your E-mail again.");
                		 student_verification_code.setText("");
                		 
 
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

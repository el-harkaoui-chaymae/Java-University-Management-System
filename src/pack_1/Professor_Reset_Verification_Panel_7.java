package pack_1;

import java.io.File;
import java.awt.*;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.geom.RoundRectangle2D;
import java.awt.event.ActionEvent;

public class Professor_Reset_Verification_Panel_7  extends JPanel {

    private Image backgroundImage;

    public Professor_Reset_Verification_Panel_7() {
    	
    	
    	
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
                        // create an instance of Professor_Reset_Email_Panel_6
                    	Professor_Reset_Email_Panel_6 panel = new Professor_Reset_Email_Panel_6();
                        
                        // add Professor_Reset_Email_Panel_6 to the window
                        JFrame window = (JFrame)SwingUtilities.getWindowAncestor(Professor_Reset_Verification_Panel_7.this);
                        window.add(panel);
                        
                        // remove Professor_Reset_Verification_Panel_7 from the window
                        window.remove(Professor_Reset_Verification_Panel_7.this);
                        
                        // refresh the window
                        window.revalidate();
                        window.repaint();
                    }
                });
            }
        });
        
        
        
        
        // adding a text -- adding a JLabel -- enter verification code to verify
        
        JLabel label4 = new JLabel("Please check your E-mails and enter the code ");
        label4.setFont(new Font("Century Gothic", Font.BOLD, 20));
        label4.setForeground(Color.BLACK);
        label4.setBounds(876, 629, 700, 30);
        label4.setHorizontalAlignment(SwingConstants.LEFT);
        add(label4);
        
        
        // adding a text -- adding a JLabel -- enter verification code to verify
        
        JLabel label50 = new JLabel("we have just sent you .");
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
        
        JTextField verification_code = new JTextField();
        verification_code.setCursor(Cursor.getPredefinedCursor(Cursor.TEXT_CURSOR));
        verification_code.setHorizontalAlignment(SwingConstants.LEFT);
        verification_code.setForeground(new Color(0, 0, 0));
        verification_code.setFont(new Font("Arial", Font.PLAIN, 19));
        verification_code.setBounds(876, 453, 450, 40);
        verification_code.setColumns(10);
        add(verification_code);
        
        
        
        // Adding the verify button 
    	
        JButton verify = new JButton() {
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
        verify.setText("Verify");  
        verify.setHorizontalTextPosition(SwingConstants.CENTER);
        verify.setForeground(new Color(255, 255, 255));
        verify.setFont(new Font("consolas", Font.BOLD, 30));

        // Remove the default button styles
        verify.setBorderPainted(false);
        verify.setFocusPainted(false);
        verify.setContentAreaFilled(false);
        verify.setOpaque(false);        
        verify.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
             verify.setBounds(876, 530,450,40);
             add(verify);
             
             
             verify.addActionListener(new ActionListener() {
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
                	 
         	 
                   	Professor_Reset_Email_Panel_6 pan = new Professor_Reset_Email_Panel_6 ();
                     
                    String code =  Integer.toString(pan.verificationCode);
                   	
                   	if (code.equals(verification_code.getText() )) {
                  	 
                		 
                		
                      	// open Professor reset password panel
                          SwingUtilities.invokeLater(new Runnable() {
                              public void run() {
                                  // create an instance of professor reset password panel
                              	Professor_Reset_Password_Panel_8 login = new Professor_Reset_Password_Panel_8();
                                  
                                  // add professor reset password panel to the window
                                  JFrame window = (JFrame)SwingUtilities.getWindowAncestor(Professor_Reset_Verification_Panel_7.this);
                                  window.add(login);
                                  
                                  // remove professor reset verification panel from the window
                                  window.remove(Professor_Reset_Verification_Panel_7.this);
                                  
                                  // refresh the window
                                  window.revalidate();
                                  window.repaint();
                              }
                          });
                		 
               		 
                		 
                		 
                	 } else {
                		 
                		 JOptionPane.showMessageDialog(null, "Incorrect Verification Code. Please Check your E-mail again.");
                		 verification_code.setText("");
                		 
 
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

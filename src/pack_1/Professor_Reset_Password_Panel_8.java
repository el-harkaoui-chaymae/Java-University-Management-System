package pack_1;

import java.io.File;
import java.awt.*;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.geom.RoundRectangle2D;
import java.awt.event.ActionEvent;




public class Professor_Reset_Password_Panel_8 extends JPanel {

    private Image backgroundImage;

    public Professor_Reset_Password_Panel_8() {
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
            	
            	// open Professor reset verification Panel
                SwingUtilities.invokeLater(new Runnable() {
                    public void run() {
                        // create an instance of Professor_Reset_Verification_Panel_7
                    	Professor_Reset_Verification_Panel_7 panel = new Professor_Reset_Verification_Panel_7();
                        
                        // add professor reset verification panel to the window
                        JFrame window = (JFrame)SwingUtilities.getWindowAncestor(Professor_Reset_Password_Panel_8.this);
                        window.add(panel);
                        
                        // remove Professor_Reset_Password_Panel_8 from the window
                        window.remove(Professor_Reset_Password_Panel_8.this);
                        
                        // refresh the window
                        window.revalidate();
                        window.repaint();
                    }
                });
            }
        });
        
        
        
        
        
       
        // adding a text -- adding a JLabel -- New Password
        
        JLabel label5 = new JLabel("New Password");
        label5.setFont(new Font("Century Gothic", Font.BOLD, 20));
        label5.setForeground(Color.decode("#6495ED"));
        label5.setBounds(876, 420, 200, 30);
        label5.setHorizontalAlignment(SwingConstants.LEFT);
        add(label5);
        
               
        // adding the new password text field
        
        JTextField new_password = new JPasswordField();
        new_password.setCursor(Cursor.getPredefinedCursor(Cursor.TEXT_CURSOR));
        new_password.setHorizontalAlignment(SwingConstants.LEFT);
        new_password.setForeground(new Color(0, 0, 0));
        new_password.setFont(new Font("Arial", Font.PLAIN, 19));
        new_password.setBounds(876, 453, 450, 40);
        new_password.setColumns(10);
        add(new_password);
        
        
        // adding a text -- adding a JLabel -- Confirm New Password
        
        JLabel label56 = new JLabel("Confirm New Password");
        label56.setFont(new Font("Century Gothic", Font.BOLD, 20));
        label56.setForeground(Color.decode("#6495ED"));
        label56.setBounds(876, 520, 500, 30);
        label56.setHorizontalAlignment(SwingConstants.LEFT);
        add(label56);
        
               
        // adding the confirm new password text field
        
        JTextField confirm_new_password = new JPasswordField();
        confirm_new_password.setCursor(Cursor.getPredefinedCursor(Cursor.TEXT_CURSOR));
        confirm_new_password.setHorizontalAlignment(SwingConstants.LEFT);
        confirm_new_password.setForeground(new Color(0, 0, 0));
        confirm_new_password.setFont(new Font("Arial", Font.PLAIN, 19));
        confirm_new_password.setBounds(876, 553, 450, 40);
        confirm_new_password.setColumns(10);
        add(confirm_new_password);
        
        
       
    
 
        
        
       // Adding the Done button 
    	
        JButton done = new JButton() {
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
        done.setText("Done");   
        done.setHorizontalTextPosition(SwingConstants.CENTER);
        done.setForeground(new Color(255, 255, 255));
        done.setFont(new Font("consolas", Font.BOLD, 30));

        // Remove the default button styles
        done.setBorderPainted(false);
        done.setFocusPainted(false);
        done.setContentAreaFilled(false);
        done.setOpaque(false);        
        done.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        done.setBounds(876,633,450,40);
        add(done);
             
             
        done.addActionListener(new ActionListener() {
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
      
                 	
                 	
                   // check if passwords match
                 	
                 	String pass11 = new_password.getText();
                    String pass22 = confirm_new_password.getText();
                    
                    
                    if (!pass11.equals(pass22)) {
                        JOptionPane.showMessageDialog(null, "Passwords do not match. Please try again.");
                        new_password.setText("");
                        confirm_new_password.setText("");
                 	
                        
                    }
                 	
                    else {
                 	
                 	
                 	
                 	
                 	// open professor login panel 4 
                     
                 	SwingUtilities.invokeLater(new Runnable() {
                         public void run() {
                            // create an instance of Professor_Login_Panel_4
                         	Professor_Login_Panel_4 login = new Professor_Login_Panel_4();
                             
                             // add Login_Panel_4 to the window
                             JFrame window = (JFrame)SwingUtilities.getWindowAncestor(Professor_Reset_Password_Panel_8.this);
                             window.add(login);
                             
                             // remove professor reset password panel from the window
                             window.remove(Professor_Reset_Password_Panel_8.this);
                             
                             // refresh the window
                             window.revalidate();
                             window.repaint();
                   
                         }
                     });
                 }
                    
                 }   
                    
             });
             
     		
             
             
             
             
             
             
             

             
             
             // adding a text -- adding a JLabel -- Reset your password
             
             JLabel label4 = new JLabel("now you can Rest your password.");
             label4.setFont(new Font("Arial", Font.BOLD, 20));
             label4.setForeground(Color.BLACK);
             label4.setBounds(876, 700, 700, 30);
             label4.setHorizontalAlignment(SwingConstants.LEFT);
             add(label4);
             
             
             
             
        
        
 
             
 
 
       
    
    
    
    }
    
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);

    }

    
}

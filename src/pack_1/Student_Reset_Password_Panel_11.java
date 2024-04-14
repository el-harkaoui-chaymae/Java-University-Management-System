package pack_1;

import java.io.File;
import java.awt.*;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;




public class Student_Reset_Password_Panel_11 extends JPanel {

    private Image backgroundImage;

    public Student_Reset_Password_Panel_11() {
    	
    	
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
            	
            	// open Professor Login Panel
                SwingUtilities.invokeLater(new Runnable() {
                    public void run() {
                        // create an instance of Student_Reset_Verification_Panel_10
                    	Student_Reset_Verification_Panel_10 panel = new Student_Reset_Verification_Panel_10();
                        
                        // add student reset verification panel  to the window
                        JFrame window = (JFrame)SwingUtilities.getWindowAncestor(Student_Reset_Password_Panel_11.this);
                        window.add(panel);
                        
                        // remove student reset password panel from the window
                        window.remove(Student_Reset_Password_Panel_11.this);
                        
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
        
        JTextField student_new_password = new JPasswordField();
        student_new_password.setCursor(Cursor.getPredefinedCursor(Cursor.TEXT_CURSOR));
        student_new_password.setHorizontalAlignment(SwingConstants.LEFT);
        student_new_password.setForeground(new Color(0, 0, 0));
        student_new_password.setFont(new Font("Arial", Font.PLAIN, 19));
        student_new_password.setBounds(876, 453, 450, 40);
        student_new_password.setColumns(10);
        add(student_new_password);
        
        
        // adding a text -- adding a JLabel -- Confirm New Password
        
        JLabel label56 = new JLabel("Confirm New Password");
        label56.setFont(new Font("Century Gothic", Font.BOLD, 20));
        label56.setForeground(Color.decode("#6495ED"));
        label56.setBounds(876, 520, 500, 30);
        label56.setHorizontalAlignment(SwingConstants.LEFT);
        add(label56);
        
               
        // adding the confirm new password text field
        
        JTextField student_confirm_new_password = new JPasswordField();
        student_confirm_new_password.setCursor(Cursor.getPredefinedCursor(Cursor.TEXT_CURSOR));
        student_confirm_new_password.setHorizontalAlignment(SwingConstants.LEFT);
        student_confirm_new_password.setForeground(new Color(0, 0, 0));
        student_confirm_new_password.setFont(new Font("Arial", Font.PLAIN, 19));
        student_confirm_new_password.setBounds(876, 553, 450, 40);
        student_confirm_new_password.setColumns(10);
        add(student_confirm_new_password);
        
        
        
        
        
        
        
        

        
       // Adding the Done button 
    	
     		JButton student_done = new JButton() {
                 @Override
                 protected void paintComponent(Graphics g) {
                     Graphics2D g2 = (Graphics2D) g;
                     GradientPaint gradient = new GradientPaint(0, 0, Color.BLUE, getWidth(), getHeight(), Color.GREEN);
                     g2.setPaint(gradient);
                     g2.fillRect(0, 0, getWidth(), getHeight());
                     super.paintComponent(g);
                 }
             };

             student_done.setText("Done");
             student_done.setHorizontalTextPosition(SwingConstants.CENTER);
             student_done.setContentAreaFilled(false);

             student_done.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
             student_done.setFocusPainted(false);
             student_done.setFocusTraversalKeysEnabled(false);
             student_done.setFocusable(false);
             student_done.setBorder(null);
             student_done.setForeground(new Color(255, 255, 255));
             student_done.setFont(new Font("consolas", Font.BOLD, 30));
             student_done.setBounds(876,633,450,40);
             add(student_done);
             
             
             
             student_done.addActionListener(new ActionListener() {
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
                 	
                 	String pass11 = student_new_password.getText();
                    String pass22 = student_confirm_new_password.getText();
                    
                    
                    if (!pass11.equals(pass22)) {
                        JOptionPane.showMessageDialog(null, "Passwords do not match. Please try again.");
                        student_new_password.setText("");
                        student_confirm_new_password.setText("");
                 	
                        
                    }
                 	
                    else {
                 	
                 	
                 	
                 	
                 	// open student login panel 5 
                     
                 	SwingUtilities.invokeLater(new Runnable() {
                         public void run() {
                            // create an instance of Student_Login_Panel_5
                        	 Student_Login_Panel_5 login = new Student_Login_Panel_5();
                             
                             // add Login_Panel_4 to the window
                             JFrame window = (JFrame)SwingUtilities.getWindowAncestor(Student_Reset_Password_Panel_11.this);
                             window.add(login);
                             
                             // remove professor reset password panel from the window
                             window.remove(Student_Reset_Password_Panel_11.this);
                             
                             // refresh the window
                             window.revalidate();
                             window.repaint();
                   
                         }
                     });
                 }
                    
                 }   
                    
             });
             
     		
             
     
             
             
             
             
             
             
             
             
             
             
             
             
             
             
             
             
             
             
             
             
             
             
             
             
             
             
             
             
             
             
             
             
             
             
             
             
             
             
             
             
             
             
             
             
             
             // adding a text -- adding a JLabel -- Reset your password
             
             JLabel label4 = new JLabel("Now You Can Rest Your Password.");
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

package pack_1;

import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.geom.RoundRectangle2D;
import java.awt.event.ActionEvent;
import java.io.File;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class Administration_Password_Panel_21 extends JPanel {

    private Image backgroundImage;

    public Administration_Password_Panel_21() {
        
    	setLayout(null);

        // Setting the background image
        
    	setOpaque(false);
        ImageIcon icon = new ImageIcon("background3.png");
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
                        JFrame window = (JFrame)SwingUtilities.getWindowAncestor(Administration_Password_Panel_21.this);
                        window.add(panel);
                        
                        // remove Administration_Password_Panel_21 from the window
                        window.remove(Administration_Password_Panel_21.this);
                        
                        // refresh the window
                        window.revalidate();
                        window.repaint();
                    }
                });
            }
        });
        
        
        
        
        
        
        

        // adding a text -- adding a JLabel -- password
        
        JLabel label7 = new JLabel("System Password");
        label7.setFont(new Font("Century Gothic", Font.BOLD, 20));
        label7.setForeground(Color.decode("#6495ED"));
        label7.setBounds(856, 450, 200, 30);
        label7.setHorizontalAlignment(SwingConstants.LEFT);
        add(label7);
        
         
               
        
        
        // adding the password text field
        
        JTextField sys_password = new JPasswordField();
        sys_password.setCursor(Cursor.getPredefinedCursor(Cursor.TEXT_CURSOR));
        sys_password.setHorizontalAlignment(SwingConstants.LEFT);
        sys_password.setForeground(new Color(0, 0, 0));
        sys_password.setFont(new Font("Arial", Font.PLAIN, 19));
        sys_password.setBounds(856, 492, 450, 40);
        sys_password.setColumns(10);
        add(sys_password); 
         
        
        
        
        
        
        
        
        // adding a text -- adding a JLabel 
        
        JLabel label111 = new JLabel("Access Refused !");
        label111.setFont(new Font("calibri", Font.BOLD, 21));
        label111.setForeground(Color.RED);
        label111.setHorizontalAlignment(SwingConstants.LEFT);
        
    
        
        
        
        
        
        // Adding the enter button
        
        
        JButton enter = new JButton() { 
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
        enter.setText("enter"); 
        enter.setHorizontalTextPosition(SwingConstants.CENTER);
        enter.setForeground(new Color(255, 255, 255));
        enter.setFont(new Font("consolas", Font.BOLD, 30));

        // Remove the default button styles
        enter.setBorderPainted(false);
        enter.setFocusPainted(false);
        enter.setContentAreaFilled(false);
        enter.setOpaque(false);        
        enter.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		enter.setBounds(856, 560,450,40);
        add(enter); 
        
        
        enter.addActionListener(new ActionListener() {
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
               
                
                
                String enteredPassword = sys_password.getText();
                String correctPassword = "ENSAKh-197";
                if (enteredPassword.equals(correctPassword)) {
                	
                	
                    
                	// open Administartion_Panel_15
                    SwingUtilities.invokeLater(new Runnable() {
                        public void run() {
                            // create an instance of Administration_Panel_15
                        	Administration_Panel_15 administration_Connection = new Administration_Panel_15();
                            
                            // add Administration_Panel_15 to the window
                            JFrame window = (JFrame)SwingUtilities.getWindowAncestor(Administration_Password_Panel_21.this);
                            window.add(administration_Connection);
                            
                            // remove Administration_Password_Panel_21 from the window
                            window.remove(Administration_Password_Panel_21.this);
                            
                            // refresh the window
                            window.revalidate();
                            window.repaint();
                        }
                    });
                	
                }
                
                else {
                	
                	add(label111);
                    label111.setBounds(856, 620, 800, 30);
                    
                   	
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

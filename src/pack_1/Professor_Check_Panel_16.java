package pack_1;

import java.io.File;
import java.awt.*;
import java.sql.*;
import java.util.Random;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.geom.RoundRectangle2D;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.*;
import javax.swing.border.MatteBorder;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Professor_Check_Panel_16 extends JPanel {

    private Image backgroundImage;
    
    public static String ID = "";
    
    public JTextField Prof_id; 

    
   
   
    public Professor_Check_Panel_16() {
        
    	// establish the connection
        
    	Connection connection = DatabaseConnection.getConnection();
 
    	 
         
        //--------------------------------------------------------------------------------------------
    	
 	
    	
    	setLayout(null);

    	
    	
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
                        JFrame window = (JFrame)SwingUtilities.getWindowAncestor(Professor_Check_Panel_16.this);
                        window.add(panel);
                        
                        // remove Professor_Entry_Panel_1 from the window
                        window.remove(Professor_Check_Panel_16.this);
                        
                        // refresh the window
                        window.revalidate();
                        window.repaint();
                    }
                });
            }
        });
        
        
        
         
        
        
        
        // adding a text -- adding a JLabel 
        
        JLabel label = new JLabel("Please Enter your Indentifier to verify your status.");
        label.setFont(new Font("calibri", Font.BOLD, 21));
        label.setForeground(Color.BLACK);
        label.setBounds(876, 560, 800, 30);
        label.setHorizontalAlignment(SwingConstants.LEFT);
        add(label);
        
        
        
        
        
        
        // adding a text -- adding a JLabel 
        
        JLabel label111 = new JLabel("In the event of any issues , try to contact the ");
        label111.setFont(new Font("calibri", Font.BOLD, 21));
        label111.setForeground(Color.BLACK);
        label111.setBounds(876, 590, 800, 30);
        label111.setHorizontalAlignment(SwingConstants.LEFT);
        add(label111);
        
        
        
        
        // adding a text -- adding a JLabel 
        
        JLabel label1111 = new JLabel("administration team .");
        label1111.setFont(new Font("calibri", Font.BOLD, 21));
        label1111.setForeground(Color.BLACK);
        label1111.setBounds(876, 620, 800, 30);
        label1111.setHorizontalAlignment(SwingConstants.LEFT);
        add(label1111); 
        
        
        
   
        
        
       
        
        // adding a text -- adding a JLabel -- id
        
        JLabel label7 = new JLabel("Your Identifier");
        label7.setFont(new Font("Century Gothic", Font.BOLD, 20));
        label7.setForeground(Color.decode("#6495ED"));
        label7.setBounds(876, 340, 200, 30);
        label7.setHorizontalAlignment(SwingConstants.LEFT);
        add(label7);
        
         
               
        
        
        // adding the id text field
        
        Prof_id = new JTextField();
        Prof_id.setCursor(Cursor.getPredefinedCursor(Cursor.TEXT_CURSOR));
        Prof_id.setHorizontalAlignment(SwingConstants.LEFT);
        Prof_id.setForeground(new Color(0, 0, 0));
        Prof_id.setFont(new Font("Arial", Font.PLAIN, 19));
        Prof_id.setBounds(876, 382, 450, 40);
        Prof_id.setColumns(10);
        add(Prof_id); 
        
     
        
        // error 
        
        
        JLabel label0 = new JLabel("You'are not Registered in Our System !");
        label0.setFont(new Font("calibri", Font.BOLD, 21));
        label0.setForeground(Color.RED);
        label0.setHorizontalAlignment(SwingConstants.LEFT);
        
        
        
         
        
        
        
       
        
        // Adding the check button
        
        JButton btn_check_prof = new JButton() { 
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
        btn_check_prof.setText("Check");
        btn_check_prof.setHorizontalTextPosition(SwingConstants.CENTER);
        btn_check_prof.setForeground(new Color(255, 255, 255));
        btn_check_prof.setFont(new Font("consolas", Font.BOLD, 30));

        // Remove the default button styles
        btn_check_prof.setBorderPainted(false);
        btn_check_prof.setFocusPainted(false);
        btn_check_prof.setContentAreaFilled(false);
        btn_check_prof.setOpaque(false);        
        btn_check_prof.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btn_check_prof.setBounds(876, 470,450,40);
        add(btn_check_prof); 
        
        btn_check_prof.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    // Play button sound effect
                    File soundFile = new File("cursor1.wav");
                    Clip clip = AudioSystem.getClip();
                    clip.open(AudioSystem.getAudioInputStream(soundFile));
                    clip.start();

                } catch (Exception ex) {
                    ex.printStackTrace();
                }

                // ----------------------- Check professor id

                try {
                    String id = Prof_id.getText();
                    String query = "SELECT * FROM PROFESSEUR WHERE id_Prof = ?";
                    PreparedStatement statement = connection.prepareStatement(query);
                    statement.setString(1, id);
                    ResultSet result = statement.executeQuery();

                    if (result.next()) {

                        ID = Prof_id.getText();

                        

                        // Close the connection
                        connection.close();

                        // Open Professor_SignUp_Panel_2 panel
                        SwingUtilities.invokeLater(new Runnable() {
                            public void run() {
                                // Create an instance of Professor_SignUp_Panel_2 panel
                                Professor_SignUp_Panel_2 login = new Professor_SignUp_Panel_2();

                                // Add Professor_SignUp_Panel_2 to the window
                                JFrame window = (JFrame) SwingUtilities.getWindowAncestor(Professor_Check_Panel_16.this);
                                window.add(login);

                                // Remove professor check panel from the window
                                window.remove(Professor_Check_Panel_16.this);

                                // Refresh the window
                                window.revalidate();
                                window.repaint();
                            }
                        });

                    } else {
                        remove(label);
                        remove(label111);
                        remove(label1111);

                        // revalidate and repaint the panel
                        revalidate();
                        repaint();

                        add(label0);
                        label0.setBounds(876, 560, 800, 30);
                    }

                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        });

		
		
        

		
		
		
		
  
       
             
        
        
		
		
		
		
		
       
        
        
        
         
        

    
    
    
    }

    
     
    public String getID() {
        return ID;
    }
    
    
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);

    }
     
    

}

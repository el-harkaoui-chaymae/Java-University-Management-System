
package pack_1;

import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.util.Arrays;
import java.awt.event.KeyEvent;
import java.io.File;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.KeyAdapter;
import java.awt.*;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Student_Check_Panel_17 extends JPanel {

    private Image backgroundImage;
    public static String CNE = "";
    public JTextField student_id; 


    public Student_Check_Panel_17() {
    	
    	
    	
        // establish the connection
        
    	Connection connection = DatabaseConnection.getConnection();
 
    	 
        
        //--------------------------------------------------------------------------------------------
    	
    	
    	
   	
    	
    	
    	
    	
    	setLayout(null);

    	
        // Setting the background image
        ImageIcon icon = new ImageIcon("signUp.png");
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
            	
            	
            	
            	// open Entry Panel
                SwingUtilities.invokeLater(new Runnable() {
                    public void run() {
                        // create an instance of Entry_Panel_1
                        Entry_Panel_1 panel = new Entry_Panel_1();
                        
                        // add Entry_Panel_1 to the window
                        JFrame window = (JFrame)SwingUtilities.getWindowAncestor(Student_Check_Panel_17.this);
                        window.add(panel);
                        
                        // remove Student_Check_Panel_17 from the window
                        window.remove(Student_Check_Panel_17.this);
                        
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
        label.setBounds(876, 550, 800, 30);
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
        
        JLabel label7 = new JLabel("CNE");
        label7.setFont(new Font("Century Gothic", Font.BOLD, 20));
        label7.setForeground(Color.decode("#6495ED"));
        label7.setBounds(876, 340, 200, 30);
        label7.setHorizontalAlignment(SwingConstants.LEFT);
        add(label7);
        
         
               
        
        
        // adding the id text field
        
        JTextField student_id = new JTextField();
        student_id.setCursor(Cursor.getPredefinedCursor(Cursor.TEXT_CURSOR));
        student_id.setHorizontalAlignment(SwingConstants.LEFT);
        student_id.setForeground(new Color(0, 0, 0));
        student_id.setFont(new Font("Arial", Font.PLAIN, 19));
        student_id.setBounds(876, 382, 450, 40);
        student_id.setColumns(10);
        add(student_id);  
        
        
        
        // error 
        
        
        JLabel label0 = new JLabel("You'are not Registered in Our System !");
        label0.setFont(new Font("calibri", Font.BOLD, 21));
        label0.setForeground(Color.RED);
        label0.setHorizontalAlignment(SwingConstants.LEFT);
  
        
        
         
        
        
        
       
        
        // Adding the check button
        
        JButton btn_check_student = new JButton() {  
            
            protected void paintComponent(Graphics g) {
                Graphics2D g2 = (Graphics2D) g;
                GradientPaint gradient = new GradientPaint(0, 0, Color.BLUE, getWidth(), getHeight(), Color.GREEN);
                g2.setPaint(gradient);
                g2.fillRect(0, 0, getWidth(), getHeight());
                super.paintComponent(g);
            } 
        };

        btn_check_student.setText("Check");
        btn_check_student.setHorizontalTextPosition(SwingConstants.CENTER);
        btn_check_student.setVerticalTextPosition(SwingConstants.CENTER);

		btn_check_student.setContentAreaFilled(false);

        btn_check_student.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        btn_check_student.setFocusPainted(false);
        btn_check_student.setFocusTraversalKeysEnabled(false);
        btn_check_student.setFocusable(false);
        btn_check_student.setBorder(null);
        btn_check_student.setForeground(new Color(255, 255, 255));
        btn_check_student.setFont(new Font("consolas", Font.BOLD, 30));
		btn_check_student.setBounds(876, 470,450,40);
        add(btn_check_student); 
        
        btn_check_student.addActionListener(new ActionListener() {
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

                // ----------------------- Check Student id

                try {
                    String id = student_id.getText();
                    String query = "SELECT * FROM ETUDIANT WHERE CNE = ?";
                    PreparedStatement statement = connection.prepareStatement(query);
                    statement.setString(1, id);
                    ResultSet result = statement.executeQuery();

                    if (result.next()) {

                        CNE = student_id.getText();

                        

                        // Close the connection
                        connection.close();

                        // Open Student_SignUp_Panel_3 panel
                        SwingUtilities.invokeLater(new Runnable() {
                            public void run() {
                                // Create an instance of Student_SignUp_Panel_3 panel
                            	Student_SignUp_Panel_3 login = new Student_SignUp_Panel_3();

                                // Add Student_SignUp_Panel_3 to the window
                                JFrame window = (JFrame) SwingUtilities.getWindowAncestor(Student_Check_Panel_17.this);
                                window.add(login);

                                // Remove professor check panel from the window
                                window.remove(Student_Check_Panel_17.this);

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
        return CNE;
    }
    
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);

    }

     

}

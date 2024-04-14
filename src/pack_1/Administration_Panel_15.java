package pack_1;

import java.awt.*;
import java.awt.geom.RoundRectangle2D;
import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.File;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class Administration_Panel_15 extends JPanel {

    private Image backgroundImage;

    public Administration_Panel_15() {
        
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
                        JFrame window = (JFrame)SwingUtilities.getWindowAncestor(Administration_Panel_15.this);
                        window.add(panel);
                        
                        // remove Professor_Administration_Panel_14 from the window
                        window.remove(Administration_Panel_15.this);
                        
                        // refresh the window
                        window.revalidate();
                        window.repaint();
                    }
                });
            }
        });
        
        
        
        
        
        JButton prof = new JButton() { 
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
        prof.setText("add professor");
        prof.setHorizontalTextPosition(SwingConstants.CENTER);
        prof.setForeground(new Color(255, 255, 255));
        prof.setFont(new Font("consolas", Font.BOLD, 30));

        // Remove the default button styles
        prof.setBorderPainted(false);
        prof.setFocusPainted(false);
        prof.setContentAreaFilled(false);
        prof.setOpaque(false);        
        prof.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        // Set the button size and position
        prof.setBounds(850, 460,450,40);


        // Add the button 
        add(prof); 

        
  
        
        prof.addActionListener(new ActionListener() {
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
            	
            	

            	// open Professor_Administration_Panel_14
                SwingUtilities.invokeLater(new Runnable() {
                    public void run() {
                        // create an instance of Professor_Administration_Panel_14
                    	Professor_Administration_Panel_14 student_Connection = new Professor_Administration_Panel_14();
                        
                        // add Professor_Administration_Panel_14 to the window
                        JFrame window = (JFrame)SwingUtilities.getWindowAncestor(Administration_Panel_15.this);
                        window.add(student_Connection);
                        
                        // remove Administration panel from the window
                        window.remove(Administration_Panel_15.this);
                        
                        // refresh the window
                        window.revalidate();
                        window.repaint();
                    }
                });
           	
            	
                
           	
            	
            }
        });
        
        
        
        
        // Adding the student button
         
        
        JButton stud = new JButton() { 
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
        stud.setText("add student");
        stud.setHorizontalTextPosition(SwingConstants.CENTER);
        stud.setForeground(new Color(255, 255, 255));
        stud.setFont(new Font("consolas", Font.BOLD, 30));

        // Remove the default button styles
        stud.setBorderPainted(false);
        stud.setFocusPainted(false);
        stud.setContentAreaFilled(false);
        stud.setOpaque(false);        
        stud.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        // Set the button size and position
        stud.setBounds(850, 540,450,40);

        // Add the button to your container
        add(stud);

	
        
        stud.addActionListener(new ActionListener() {
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
            	
            	// open Student_Administration_Panel_18
                SwingUtilities.invokeLater(new Runnable() {
                    public void run() {
                        // create an instance of  Student_Administration_Panel_18
                    	Student_Administration_Panel_18 student_Connection = new Student_Administration_Panel_18();
                        
                        // add Student_Administration_Panel_18 to the window
                        JFrame window = (JFrame)SwingUtilities.getWindowAncestor(Administration_Panel_15.this);
                        window.add(student_Connection);
                        
                        // remove Administration panel from the window
                        window.remove(Administration_Panel_15.this);
                        
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

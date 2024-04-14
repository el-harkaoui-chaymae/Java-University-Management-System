package pack_1;

import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.File;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class Entry_Panel_1 extends JPanel {

    private Image backgroundImage;

    public Entry_Panel_1() {
        
    	setLayout(null);

        // Setting the background image
        
    	setOpaque(false);
        ImageIcon icon = new ImageIcon("background1.png");
        backgroundImage = icon.getImage();
        
       
        
        
        //------- Adding the Professor Button
        
        JButton btnEspaceEnseignant = new JButton("Professor Area");
        btnEspaceEnseignant.setHorizontalAlignment(SwingConstants.RIGHT);
        btnEspaceEnseignant.setFocusable(false);
        btnEspaceEnseignant.setFocusTraversalKeysEnabled(false);
        btnEspaceEnseignant.setFocusPainted(false);
        btnEspaceEnseignant.setContentAreaFilled(false);
        btnEspaceEnseignant.setOpaque(false);
        btnEspaceEnseignant.setAlignmentX(Component.RIGHT_ALIGNMENT);
        btnEspaceEnseignant.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        btnEspaceEnseignant.setBorderPainted(false);
        btnEspaceEnseignant.setFont(new Font("Century Gothic", Font.BOLD, 24));
        btnEspaceEnseignant.setBounds(400, 45, 303, 41);
        add(btnEspaceEnseignant);
        
        
        btnEspaceEnseignant.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                
            	btnEspaceEnseignant.setFont(new Font("Century Gothic", Font.BOLD, 29));
                btnEspaceEnseignant.setForeground(Color.decode("#3388FF"));
                
            }
            
            public void mouseExited(java.awt.event.MouseEvent evt) {
                
            	btnEspaceEnseignant.setFont(new Font("Century Gothic", Font.BOLD, 24));
                btnEspaceEnseignant.setForeground(Color.BLACK);

            }
        }); 
        
        
        

        btnEspaceEnseignant.addActionListener(new ActionListener() {
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
            	
            	
             	
    	
            	// open Professor_Check_Panel_16
          
            	SwingUtilities.invokeLater(new Runnable() {
                    public void run() {
                    	
                    	// create an instance of Professor_Check_Panel_16                    	
                    	Professor_Check_Panel_16 professor_Connection = new Professor_Check_Panel_16();                       
                        
                    	// add Professor_Check_Panel_16 to the window
                    	JFrame window = (JFrame)SwingUtilities.getWindowAncestor(Entry_Panel_1.this);
                        window.add(professor_Connection);
                        
                        // remove Entry_Panel_1 from the window
                        window.remove(Entry_Panel_1.this);
                        
                        // refresh the window
                        window.revalidate();
                        window.repaint();
                    }
                });
            }
        });
        
        
        
              
       
        
        //------- Adding the Student Button
        
        JButton btnEspaceEtudiant = new JButton("Student Area");
        btnEspaceEtudiant.setHorizontalAlignment(SwingConstants.LEFT);
        btnEspaceEtudiant.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        btnEspaceEtudiant.setFont(new Font("Century Gothic", Font.BOLD, 24));
        btnEspaceEtudiant.setFocusPainted(false);
        btnEspaceEtudiant.setContentAreaFilled(false);
        btnEspaceEtudiant.setBorderPainted(false);
        btnEspaceEtudiant.setBounds(800, 45, 303, 41);
        add(btnEspaceEtudiant);
        
        btnEspaceEtudiant.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnEspaceEtudiant.setFont(new Font("Century Gothic", Font.BOLD, 29));
                btnEspaceEtudiant.setForeground(Color.decode("#3388FF"));



                
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnEspaceEtudiant.setFont(new Font("Century Gothic", Font.BOLD, 24));
                btnEspaceEtudiant.setForeground(Color.BLACK);


                
            }
        }); 
        
        

        
        
        btnEspaceEtudiant.addActionListener(new ActionListener() {
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
            	
            	
            
            	
            	// open Student_Check_Panel_17
                SwingUtilities.invokeLater(new Runnable() {
                    public void run() {
                        // create an instance of Student_Check_Panel_17
                    	Student_Check_Panel_17 student_Connection = new Student_Check_Panel_17();
                        
                        // add Student_Check_Panel_17 to the window
                        JFrame window = (JFrame)SwingUtilities.getWindowAncestor(Entry_Panel_1.this);
                        window.add(student_Connection);
                        
                        // remove Entry_Panel_1 from the window
                        window.remove(Entry_Panel_1.this);
                        
                        // refresh the window
                        window.revalidate();
                        window.repaint();
                    }
                });
            }
        });
        
        
        
        
                        
        
        //------- Adding the Administration Button

        JButton btnAdministration = new JButton("Administration Area");
        btnAdministration.setHorizontalAlignment(SwingConstants.LEFT);
        btnAdministration.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        btnAdministration.setFont(new Font("Century Gothic", Font.BOLD, 24));
        btnAdministration.setFocusPainted(false);
        btnAdministration.setContentAreaFilled(false);
        btnAdministration.setBorderPainted(false);
        btnAdministration.setBounds(1110, 45, 333, 41);
        add(btnAdministration);
        
        
        btnAdministration.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnAdministration.setFont(new Font("Century Gothic", Font.BOLD, 29));
                btnAdministration.setForeground(Color.decode("#3388FF"));

                


                
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnAdministration.setFont(new Font("Century Gothic", Font.BOLD, 24));
                btnAdministration.setForeground(Color.BLACK);

                
            }
        }); 
        
        
        
        
        
        btnAdministration.addActionListener(new ActionListener() {
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
            	
            	
            
            	
            	// open Administration_Password_Panel_21
                SwingUtilities.invokeLater(new Runnable() {
                    public void run() {
                        // create an instance of Administration_Password_Panel_21
                    	Administration_Password_Panel_21 student_Connection = new Administration_Password_Panel_21();
                        
                        // add Administration_Panel_15 to the window
                        JFrame window = (JFrame)SwingUtilities.getWindowAncestor(Entry_Panel_1.this);
                        window.add(student_Connection);
                        
                        // remove Entry_Panel_1 from the window
                        window.remove(Entry_Panel_1.this);
                        
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

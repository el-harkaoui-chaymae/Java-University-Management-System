package pack_1;

import java.io.File;
import java.awt.*;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentAdapter;
import javax.swing.SwingConstants;
import javax.swing.Timer;

public class Student_Space_Panel_19 extends JPanel {

    private Image backgroundImage;

    public Student_Space_Panel_19() {
        
    	setLayout(null);
        setBackground(Color.WHITE);
        

            // Setting the background image
            setOpaque(false);
            ImageIcon icon = new ImageIcon("bar_background6.png");
            backgroundImage = icon.getImage();
        
        
        


        
         
        // adding the menu panel
        
        JPanel menu = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                Graphics2D g2d = (Graphics2D) g;
                int width = getWidth();
                int height = getHeight();
                Color color1 = Color.decode("#03254c");
                Color color2 = Color.decode("#03254c");
                GradientPaint gradient = new GradientPaint(0, 0, color1, 0, height, color2);
                g2d.setPaint(gradient);
                g2d.fillRect(0, 0, width, height);
            }
        };
        menu.setBounds(75, 0, 200, 880);
        add(menu);
        menu.setLayout(null);
        
        
        // adding the menu button
        JButton btnMenu = new JButton("");
        btnMenu.setHorizontalAlignment(SwingConstants.RIGHT);
        btnMenu.setFocusable(false);
        btnMenu.setFocusTraversalKeysEnabled(false);
        btnMenu.setFocusPainted(false);
        btnMenu.setContentAreaFilled(false);
        btnMenu.setOpaque(false);
        btnMenu.setAlignmentX(Component.RIGHT_ALIGNMENT);
        btnMenu.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        btnMenu.setBorderPainted(false);
        btnMenu.setFont(new Font("Century Gothic", Font.BOLD, 24));
        btnMenu.setBounds(10, 19, 303, 41);
        add(btnMenu);
        
        
        
        // ------ animation of the menu panel
  
        // declare a final boolean flag to keep track of menu panel state
        
        final boolean[] menuPanelOpen = {false};


        // add a component listener to detect when the frame is resized
        addComponentListener(new ComponentAdapter() {
            
            public void componentResized(ComponentEvent e) {

            	
            	// check if menu panel is open and adjust its position accordingly
                if (menuPanelOpen[0]) {
                    menu.setLocation(0, 0);
                } else {
                    menu.setLocation(280 - menu.getWidth(), 0);
                }
            }
        });

        // add an action listener to toggle the menu panel state when button is clicked
        
        btnMenu.addActionListener(new ActionListener() {
            
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
                
  
            	
            	// toggle the menu panel state
                menuPanelOpen[0] = !menuPanelOpen[0];

                // calculate the new position of the menu panel based on its state
                int x = menuPanelOpen[0] ? -menu.getWidth() : 280 - menu.getWidth();
                int y = 0;

                // animate the menu panel to its new position
                Timer timer = new Timer(10, new ActionListener() {
                    int deltaX = (x - menu.getX()) / 10;
                    int deltaY = (y - menu.getY()) / 10;
                    int count = 0;

                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if (count == 10) {
                            ((Timer) e.getSource()).stop();
                            
                        } else {
                            menu.setLocation(menu.getX() + deltaX, menu.getY() + deltaY);
                            count++;
                        }
                    }
                });
                timer.start();
            }
        });

        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
  

        // adding a text -- adding a JLabel -- Menu
        
        JLabel label5 = new JLabel("MENU");
        label5.setFont(new Font("Arial", Font.BOLD, 29));
        label5.setForeground(Color.decode("#03254c"));
        label5.setBounds(0, 24, 200, 50);
        label5.setHorizontalAlignment(SwingConstants.CENTER);
        label5.setOpaque(true); 
        label5.setBackground(Color.decode("#BDBDBD"));

        menu.add(label5);
        
        

        
        
        
        // adding the file button
        
        JButton file = new JButton("PRIVATE FILE");
        file.setHorizontalAlignment(SwingConstants.CENTER);
        file.setFocusable(false);
        file.setFocusTraversalKeysEnabled(false);
        file.setFocusPainted(false);
        file.setContentAreaFilled(false);
        file.setOpaque(false);
        file.setAlignmentX(Component.RIGHT_ALIGNMENT);
        file.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        file.setBorderPainted(false);
        file.setFont(new Font("Calibri", Font.BOLD, 23));
        file.setForeground(Color.WHITE);
        file.setBounds(0, 122, 200, 50);

        file.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                file.setForeground(Color.BLACK);
                file.setOpaque(true);
                file.setBackground(Color.decode("#BDBDBD"));

               
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                file.setForeground(Color.WHITE);
                file.setOpaque(false);

                
            }
        });

        menu.add(file);
        
        
        
        
        // adding the sections button
        
        JButton btnSection = new JButton("MY SECTIONS");
        btnSection.setHorizontalAlignment(SwingConstants.CENTER);
        btnSection.setFocusable(false);
        btnSection.setFocusTraversalKeysEnabled(false);
        btnSection.setFocusPainted(false);
        btnSection.setContentAreaFilled(false);
        btnSection.setOpaque(false);
        btnSection.setAlignmentX(Component.RIGHT_ALIGNMENT);
        btnSection.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        btnSection.setBorderPainted(false);
        btnSection.setFont(new Font("Calibri", Font.BOLD, 22));
        btnSection.setForeground(Color.WHITE);
        btnSection.setBounds(0, 230, 200, 50);

        btnSection.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnSection.setForeground(Color.BLACK);
                btnSection.setOpaque(true);
                btnSection.setBackground(Color.decode("#BDBDBD"));

                
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnSection.setForeground(Color.WHITE);
                btnSection.setOpaque(false);
 
                
            }
        });

        menu.add(btnSection);
        
        
        
        
        // adding the Planning button
        
        JButton btnPlanning = new JButton("MY PLANNING");
        btnPlanning.setHorizontalAlignment(SwingConstants.CENTER);
        btnPlanning.setFocusable(false);
        btnPlanning.setFocusTraversalKeysEnabled(false);
        btnPlanning.setFocusPainted(false);
        btnPlanning.setContentAreaFilled(false);
        btnPlanning.setOpaque(false);
        btnPlanning.setAlignmentX(Component.RIGHT_ALIGNMENT);
        btnPlanning.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        btnPlanning.setBorderPainted(false);
        btnPlanning.setFont(new Font("Calibri", Font.BOLD, 22));
        btnPlanning.setForeground(Color.WHITE);
        btnPlanning.setBounds(0, 345, 200, 50);

        btnPlanning.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnPlanning.setForeground(Color.BLACK);
                btnPlanning.setOpaque(true);
                btnPlanning.setBackground(Color.decode("#BDBDBD"));

                
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnPlanning.setForeground(Color.WHITE);
                btnPlanning.setOpaque(false);

                
            }
        });
 
        menu.add(btnPlanning);
        
        
        
        

        
        
        
		
		
		
        
        
        
        
        
        
        
        
      
    	
				
		
		
		
        
        
               
          
        
        
        
        
        
        
        
        
        
        
        
        
        
        
      
        
        
        
        
        
        
        
        
        
        
 
        
 
      
        
        
        
        
        
        
        
        
		
		
		
		
		
		
		
		      
        
    
       
    
    
    
    }
    
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);

    }
    
    
   
    
    

      

}

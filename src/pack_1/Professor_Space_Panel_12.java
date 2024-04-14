package pack_1;

import java.io.File;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.*;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentAdapter;

public class Professor_Space_Panel_12 extends JPanel {

    private Image backgroundImage;

    public Professor_Space_Panel_12() {
        
    	
    	
    	

        //establish the connection
        
    	Connection connection = DatabaseConnection.getConnection();

        
        //--------------------------------------------------------------------------------------------
    	
  	
    	
    	
    	setLayout(null);
        setBackground(Color.WHITE);
        

        // Setting the background image
        setOpaque(false);
        ImageIcon icon = new ImageIcon("bar_background6.png");
        backgroundImage = icon.getImage();
         
        
     
        
        
         // -------------- hello to account ------------------------------------
            
            
        // new instance to take the entered ID
            
            
        Professor_Check_Panel_16 pan = new Professor_Check_Panel_16();
        String id = pan.getID();
            
        
        
        
        // hello label
        
        
        JLabel hello = new JLabel();
        hello.setFont(new Font("Calibri", Font.BOLD, 38));
        hello.setForeground(Color.black);
        hello.setHorizontalAlignment(SwingConstants.LEFT);
        hello.setOpaque(true); 
        hello.setOpaque(false);
        hello.setBackground(new Color(0,0,0,0));
    	
   
        
        
            
        // Retrieve the personal informations from the database
            
            
            
            
        try {
                
                
            	//-------------- get the first and second  name from DB
            	
            	String query1 = "SELECT nom FROM PROFESSEUR WHERE id_Prof=?";
                PreparedStatement pstmt = connection.prepareStatement(query1);
                pstmt.setString(1, id);
                
                // Execute the query and retrieve the result
                ResultSet rs = pstmt.executeQuery();
                
                
                String query2 = "SELECT prenom FROM PROFESSEUR WHERE id_Prof=?";
                PreparedStatement pstmt2 = connection.prepareStatement(query2);
                pstmt2.setString(1, id);
                
                // Execute the query and retrieve the result
                ResultSet rs2 = pstmt2.executeQuery();
                
                
                
                if (rs.next() && rs2.next()) {
                	
                	
                	
                	// hello label
                    
                    
                    hello.setText(rs.getString("nom")+" "+rs2.getString("prenom"));
                    add(hello);
                    hello.setBounds(700, 330, 900, 100);
                    
                    
                   
                	
                	
                    
                }
     
                
               
                
                
            
        } 
        
        catch (Exception e) {
                e.printStackTrace();
        }

            

        //-----------------------------------------------------------------------------------
            


            
            
        
            
            
            
            
            
        // adding the menu panel
        
        JPanel menu = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                Graphics2D g2d = (Graphics2D) g;
                int width = getWidth();
                int height = getHeight();
                //Color color1 = Color.decode("#0276ab");
                //Color color2 = Color.decode("#0276ab");
                Color color2 = Color.decode("#495b7e");
                Color color1 = Color.decode("#495b7e");//65BA03
                GradientPaint gradient = new GradientPaint(0, 0, color1, 0, height, color2);
                g2d.setPaint(gradient);
                g2d.fillRect(0, 0, width, height);
            }
        };
        menu.setBounds(30, 0, 200, 880);
        add(menu);
        menu.setLayout(null);
        
        
        // adding the menu button
        JButton btnMenu = new JButton();
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
        
        
    
        
        
    	 Professor_Profile_Panel_20 panel = new Professor_Profile_Panel_20();
     	 Professor_Module_Panel_22 panel2 = new Professor_Module_Panel_22();

        
        
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
        	    int menuX = menuPanelOpen[0] ? -200 : 280 - menu.getWidth();
        	    int panelX = menuPanelOpen[0] ? 150 : 300;
        	    int panel2X = menuPanelOpen[0] ? 150 : 300;

        	    
        	    // animate the menu panel to its new position
        	    Timer timer = new Timer(10, new ActionListener() {
        	        int deltaXMenu = (menuX - menu.getX()) / 10;
        	        int deltaYMenu = 0;
        	        int deltaXPanel = (panelX - panel.getX()) / 10;
        	        int deltaYPanel = 0;
        	        
        	        int deltaXPanel2 = (panel2X - panel2.getX()) / 10;
        	        int deltaYPanel2 = 0;

        	        
        	        int count = 0;

        	        @Override
        	        public void actionPerformed(ActionEvent e) {
        	            if (count == 10) {
        	                ((Timer) e.getSource()).stop();

        	            } else {
        	                menu.setLocation(menu.getX() + deltaXMenu, menu.getY() + deltaYMenu);
        	                panel.setLocation(panel.getX() + deltaXPanel, panel.getY() + deltaYPanel);
        	                panel2.setLocation(panel2.getX() + deltaXPanel2, panel2.getY() + deltaYPanel2);

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
        label5.setForeground(Color.decode("#495b7e"));
        label5.setBounds(0, 24, 200, 50);
        label5.setHorizontalAlignment(SwingConstants.CENTER);
        label5.setOpaque(true); 
        label5.setBackground(Color.decode("#BDBDBD"));

        menu.add(label5);
        
        

        
        
        
        // define a variable to keep track of the currently selected button
        
        JButton btn = new JButton();
        btn.setHorizontalAlignment(SwingConstants.CENTER);
        btn.setFocusable(false);
        btn.setFocusTraversalKeysEnabled(false);
        btn.setFocusPainted(false);
        btn.setContentAreaFilled(false);
        btn.setOpaque(true);
        btn.setAlignmentX(Component.RIGHT_ALIGNMENT);
        btn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        btn.setBorderPainted(false);
        btn.setFont(new Font("Calibri", Font.BOLD, 23));
        btn.setForeground(Color.BLACK);
        btn.setBackground(Color.decode("#6d7c98"));
        
        
        
        
       
        
        
        
        
        
        
        
        // adding the profile button
        
        JButton profile = new JButton("MY PROFILE");
        profile.setHorizontalAlignment(SwingConstants.CENTER);
        profile.setFocusable(false);
        profile.setFocusTraversalKeysEnabled(false);
        profile.setFocusPainted(false);
        profile.setContentAreaFilled(false);
        profile.setOpaque(false);
        profile.setAlignmentX(Component.RIGHT_ALIGNMENT);
        profile.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        profile.setBorderPainted(false);
        profile.setFont(new Font("Calibri", Font.BOLD, 23));
        profile.setForeground(Color.WHITE);
        profile.setBounds(0, 122, 200, 50);

        profile.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                profile.setOpaque(true);
                profile.setBackground(Color.decode("#6d7c98"));

               
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                profile.setOpaque(false);

                
            }
        }); 

        menu.add(profile);
        
        
        profile.addActionListener(new ActionListener() {
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
            	
            	
            	
            	
            	// remove hello panels
            	
            	remove(hello);
                remove(panel2);
                // revalidate and repaint the panel
                revalidate();
                repaint();
            	
            	
       	
            	// add the professor profile panel
            	
           	   //Professor_Profile_Panel_20 panel = new Professor_Profile_Panel_20();
           	   add(panel);
               panel.setBounds(300,0,1400,1000);
               
               // add btn
               btn.setBounds(0, 122, 200, 50);
               menu.add(btn);

               
               
              
               
               

           	  
                                
            }
        });
        
 
        
        
        
        
        
        // adding the sections button
        
        JButton btnSection = new JButton("MY MODULES");
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
                btnSection.setOpaque(true);
                btnSection.setBackground(Color.decode("#6d7c98"));

                
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnSection.setOpaque(false);
 
                
            }
        });

        menu.add(btnSection);
        
        
        
        
        btnSection.addActionListener(new ActionListener() {
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
            	
            	
            	
            	
            	
                // remove hello panels
            	
            	remove(hello);
                remove(panel);
                // revalidate and repaint the panel
                revalidate();
                repaint();
            	
            	
       	
            	// add the professor module panel
            	
           	   //Professor_Module_Panel_22 panel2 = new Professor_Module_Panel_22();
           	   add(panel2);
               panel2.setBounds(300,0,1400,1000);
               
               
            	
            	
               // add btn
               
               btn.setBounds(0, 230, 200, 50);
               menu.add(btn);

               
               
              
               
               

           	  
                                
            }
        });
        
 
        
        
        
        
        
   
        
        
        
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
                btnPlanning.setOpaque(true);
                btnPlanning.setBackground(Color.decode("#6d7c98"));

                
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnPlanning.setOpaque(false);
                

                
            }
        });
 
        menu.add(btnPlanning);
        
        
        btnPlanning.addActionListener(new ActionListener() {
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
            	
            	
            	
               // add btn
               
               btn.setBounds(0, 345, 200, 50);
               menu.add(btn);

               
               
              
               
               

           	  
                                
            }
        });
        
        
        
        

        
        
        
         
        
        
       
        
        
        
        
        
        
        
        
        
        
        
        
		
		
		
        
        
        
        
        
        
        
        
      
    	
				
		
		
		
        
        
               
          
        
        
        
        
        
        
        
        
        
        
        
        
        
        
      
        
        
        
        
        
        
        
        
        
        
 
        
 
      
        
        
        
        
        
        
        
        
		
		
		
		
		
		
		
		      
        
    
       
    
    
    
    }
    
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);

    }
    
    
   
    
    

      

}

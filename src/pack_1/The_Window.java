
package pack_1;


import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class The_Window extends JFrame {
	
	public JPanel Entry_Panel_1 ;
	
	 
	    // constructor
	
		public The_Window() { 
			
			
			// maximizes the window to fit the screen size
			setExtendedState(JFrame.MAXIMIZED_BOTH); 
	        
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        // remove the title bar
			setUndecorated(true);
			
			
			
			// Adding the close button
			JButton btnClose = new JButton("X");
			btnClose.setFont(new Font("Arial", Font.BOLD, 16));
			btnClose.setForeground(Color.WHITE);
			btnClose.setBackground(Color.RED);
			btnClose.setBorderPainted(false);
			btnClose.setFocusPainted(false);
			btnClose.setContentAreaFilled(false);
			btnClose.setOpaque(true);
			btnClose.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

			// Add the button to a JLayeredPane with the highest layer
			JLayeredPane layeredPane = getLayeredPane();
			layeredPane.add(btnClose, JLayeredPane.POPUP_LAYER);

			// Set the button's position
			btnClose.setBounds(1485, 0, 52, 30);

			btnClose.addActionListener(new ActionListener() {
			    public void actionPerformed(ActionEvent e) {
			        // Closing the window
			        System.exit(0);                
			    }
			});

		
		}
		
		
	
	
		public static void main(String[] args) {		
				
	   The_Window window = new The_Window();	   
	   Entry_Panel_1 panel1 = new Entry_Panel_1();
	   
	   window.getContentPane().add(panel1);
	   window.setVisible(true);
	   
	   
	   
		
	}

	
		
	}



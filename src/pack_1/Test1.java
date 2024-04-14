package pack_1;

import javax.swing.JFrame;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;

import javax.swing.JButton;
import javax.swing.JMenuBar;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JScrollPane;
import javax.swing.JSlider;
import javax.swing.JSeparator;

public class Test1 extends JFrame {
	
	public JPanel Entry_Panel_1 ;
	
	
	    // constructor
	
		public Test1() {
			
			setBackground(Color.red);
			// maximizes the window to fit the screen size
			setExtendedState(JFrame.MAXIMIZED_BOTH); 
	        
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        // remove the title bar
			setUndecorated(true);
			getContentPane().setLayout(null);
			
			
			
			           /*/ Adding the close button
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
			
						*/
		}
		
	 	

	public static void main(String[] args) {		
				
	   The_Window window = new The_Window();	   
	   Professor_Space_Panel_12 panel1 = new Professor_Space_Panel_12();
	   window.getContentPane().add(panel1);
	   window.setVisible(true);
	   
	   
	   
		
	}
	}



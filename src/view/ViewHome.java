package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;

public class ViewHome {

	private JFrame frame;

	/**
	 * Create the application.
	 */
	public ViewHome() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 800, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(211, 211, 211));
		FlowLayout flowLayout = (FlowLayout) panel.getLayout();
		flowLayout.setVgap(10);
		frame.getContentPane().add(panel, BorderLayout.NORTH);
		
		JLabel lblGestionHotelV = new JLabel("Gestion Hotel v1.0");
		lblGestionHotelV.setFont(new Font("Dialog", Font.BOLD, 18));
		panel.add(lblGestionHotelV);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(230, 230, 250));
		FlowLayout flowLayout_1 = (FlowLayout) panel_1.getLayout();
		flowLayout_1.setHgap(80);
		frame.getContentPane().add(panel_1, BorderLayout.WEST);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(255, 255, 255));
		frame.getContentPane().add(panel_2, BorderLayout.CENTER);
	}
	
	public void show() {
		frame.setVisible(true);
	}

}

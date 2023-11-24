package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.BorderLayout;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JPanel;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;

import controller.CtrUser;
import model.User;

import com.jgoodies.forms.layout.FormSpecs;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ViewLogin {

	private JFrame frame;
	private JTextField textFieldUsername;
	private JPasswordField passwordFieldLogin;
	private CtrUser controller;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewLogin window = new ViewLogin();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ViewLogin() {
		controller = new CtrUser(this);
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JLabel lblGestionHotel = new JLabel("GESTION HOTEL");
		lblGestionHotel.setBackground(new Color(154, 153, 150));
		lblGestionHotel.setFont(new Font("Dialog", Font.BOLD, 18));
		lblGestionHotel.setHorizontalAlignment(SwingConstants.CENTER);
		frame.getContentPane().add(lblGestionHotel, BorderLayout.NORTH);
		
		JPanel panel = new JPanel();
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(new FormLayout(new ColumnSpec[] {
				FormSpecs.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("max(44dlu;default)"),
				FormSpecs.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("max(23dlu;default)"),
				ColumnSpec.decode("26dlu"),
				ColumnSpec.decode("max(97dlu;default):grow"),},
			new RowSpec[] {
				FormSpecs.RELATED_GAP_ROWSPEC,
				RowSpec.decode("max(19dlu;default)"),
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				RowSpec.decode("max(22dlu;default)"),
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,}));
		
		JLabel lblNewLabel = new JLabel("Username");
		panel.add(lblNewLabel, "4, 4, right, default");
		
		textFieldUsername = new JTextField();
		panel.add(textFieldUsername, "6, 4, left, default");
		textFieldUsername.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Password");
		panel.add(lblNewLabel_1, "4, 8, right, default");
		
		passwordFieldLogin = new JPasswordField();
		passwordFieldLogin.setColumns(10);
		panel.add(passwordFieldLogin, "6, 8, left, default");
		
		JButton btnNewButton = new JButton("LOGIN");
		btnNewButton.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent arg0) {
				controller.controlUserInfos(new User(0, textFieldUsername.getText(),
						passwordFieldLogin.getText()));
			}
		});
		panel.add(btnNewButton, "1, 12, 6, 1, center, default");
	}

	public void openHomeJFrame() {
		ViewHome home = new ViewHome();
		home.show();
		this.frame.dispose();
	}

	public void showErrorMessage() {
		JOptionPane.showMessageDialog(frame, "Username or password is invalid");
	}

}

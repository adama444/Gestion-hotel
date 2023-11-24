package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.layout.FormSpecs;
import java.awt.CardLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.BoxLayout;
import javax.swing.SwingConstants;
import javax.swing.JTable;
import javax.swing.JLayeredPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JTabbedPane;

public class ViewHome {

	private JFrame frame;
	private JPanel mainPanel = new JPanel();
	private JPanel dashboardPanel = new JPanel();
	private JPanel userPanel = new JPanel();
	private JPanel clientPanel = new JPanel();
	private JTable table;
	private JTextField textField;
	private JPasswordField passwordField;
	private JPasswordField passwordField_1;
	private JTextField textField_1;
	private JPasswordField passwordField_2;

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
		frame.getContentPane().add(panel, BorderLayout.NORTH);
		
		JLabel jlabelHomeAppTitle = new JLabel("Gestion Hotel v1.0");
		jlabelHomeAppTitle.setFont(new Font("Dialog", Font.BOLD, 20));
		panel.add(jlabelHomeAppTitle);
		
		JPanel sidePanel = new JPanel();
		sidePanel.setBackground(new Color(230, 230, 250));
		frame.getContentPane().add(sidePanel, BorderLayout.WEST);
		sidePanel.setLayout(new FormLayout(new ColumnSpec[] {
				ColumnSpec.decode("16px"),
				ColumnSpec.decode("100px"),
				ColumnSpec.decode("16px"),},
			new RowSpec[] {
				FormSpecs.LINE_GAP_ROWSPEC,
				RowSpec.decode("27px"),
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,}));
		
		JButton btnNewButton_1 = new JButton("Dashboard");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				((CardLayout)(mainPanel.getLayout())).show(mainPanel, "name_72052188820362");
			}
		});
		sidePanel.add(btnNewButton_1, "2, 2, left, top");
		
		JButton btnNewButton = new JButton("User");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				((CardLayout)(mainPanel.getLayout())).show(mainPanel, "name_72074691210271");
			}
		});
		sidePanel.add(btnNewButton, "2, 4, fill, top");
		
		JButton btnNewButton_2 = new JButton("Client");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				((CardLayout)(mainPanel.getLayout())).show(mainPanel, "name_72083669374496");
			}
		});
		sidePanel.add(btnNewButton_2, "2, 6, fill, top");
		
		mainPanel.setBackground(new Color(255, 255, 255));
		frame.getContentPane().add(mainPanel, BorderLayout.CENTER);
		mainPanel.setLayout(new CardLayout(0, 0));
		
		dashboardPanel.setBackground(new Color(255, 255, 255));
		mainPanel.add(dashboardPanel, "name_72052188820362");
		dashboardPanel.setLayout(new FormLayout(new ColumnSpec[] {
				FormSpecs.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("50dlu"),
				ColumnSpec.decode("16dlu"),
				ColumnSpec.decode("50dlu"),},
			new RowSpec[] {
				RowSpec.decode("16dlu"),
				RowSpec.decode("50dlu"),}));
		
		JPanel userBox = new JPanel();
		userBox.setBackground(new Color(248, 248, 255));
		dashboardPanel.add(userBox, "2, 2, fill, fill");
		userBox.setLayout(null);
		
		JLabel jlabelUserBoxTitle = new JLabel("Users");
		jlabelUserBoxTitle.setForeground(new Color(0, 0, 0));
		jlabelUserBoxTitle.setFont(new Font("Dialog", Font.BOLD, 18));
		jlabelUserBoxTitle.setBounds(0, 0, 94, 32);
		jlabelUserBoxTitle.setHorizontalAlignment(SwingConstants.CENTER);
		userBox.add(jlabelUserBoxTitle);
		
		JLabel jlabelUserBoxValue = new JLabel("1");
		jlabelUserBoxValue.setFont(new Font("Dialog", Font.BOLD, 16));
		jlabelUserBoxValue.setHorizontalAlignment(SwingConstants.CENTER);
		jlabelUserBoxValue.setBounds(0, 31, 94, 50);
		userBox.add(jlabelUserBoxValue);
		
		JPanel clientBox = new JPanel();
		clientBox.setBackground(new Color(248, 248, 255));
		clientBox.setLayout(null);
		dashboardPanel.add(clientBox, "4, 2, fill, fill");
		
		JLabel jlabelClientBoxTitle = new JLabel("Clients");
		jlabelClientBoxTitle.setHorizontalAlignment(SwingConstants.CENTER);
		jlabelClientBoxTitle.setForeground(Color.BLACK);
		jlabelClientBoxTitle.setFont(new Font("Dialog", Font.BOLD, 18));
		jlabelClientBoxTitle.setBounds(0, 0, 94, 32);
		clientBox.add(jlabelClientBoxTitle);
		
		JLabel jlabelClientBoxValue = new JLabel("5");
		jlabelClientBoxValue.setHorizontalAlignment(SwingConstants.CENTER);
		jlabelClientBoxValue.setFont(new Font("Dialog", Font.BOLD, 16));
		jlabelClientBoxValue.setBounds(0, 31, 94, 50);
		clientBox.add(jlabelClientBoxValue);
		
		userPanel.setBackground(new Color(255, 255, 255));
		mainPanel.add(userPanel, "name_72074691210271");
		userPanel.setLayout(new FormLayout(new ColumnSpec[] {
				ColumnSpec.decode("16dlu:grow"),
				ColumnSpec.decode("200dlu"),
				ColumnSpec.decode("16dlu"),
				ColumnSpec.decode("max(43dlu;default):grow"),},
			new RowSpec[] {
				RowSpec.decode("16dlu"),
				FormSpecs.DEFAULT_ROWSPEC,
				RowSpec.decode("8dlu"),
				RowSpec.decode("70dlu"),
				FormSpecs.RELATED_GAP_ROWSPEC,
				RowSpec.decode("8dlu"),
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				RowSpec.decode("150dlu:grow"),}));
		
		JLabel lblListOfUsers = new JLabel("List of users");
		lblListOfUsers.setFont(new Font("Dialog", Font.BOLD, 18));
		userPanel.add(lblListOfUsers, "2, 2");
		
		table = new JTable();
		table.setBackground(new Color(248, 248, 255));
		userPanel.add(table, "2, 4, 2, 1, fill, fill");
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		userPanel.add(tabbedPane, "2, 8, 2, 1, fill, fill");
		
		JLayeredPane layeredPane = new JLayeredPane();
		tabbedPane.addTab("Update user", null, layeredPane, null);
		layeredPane.setLayout(new FormLayout(new ColumnSpec[] {
				ColumnSpec.decode("8dlu"),
				FormSpecs.DEFAULT_COLSPEC,
				FormSpecs.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("default:grow"),},
			new RowSpec[] {
				RowSpec.decode("16dlu"),
				FormSpecs.DEFAULT_ROWSPEC,
				RowSpec.decode("8dlu"),
				FormSpecs.DEFAULT_ROWSPEC,
				RowSpec.decode("8dlu"),
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				RowSpec.decode("8dlu"),}));
		
		JLabel lblUsername = new JLabel("Username");
		layeredPane.add(lblUsername, "2, 2, center, default");
		
		textField = new JTextField();
		layeredPane.add(textField, "4, 2, center, default");
		textField.setColumns(10);
		
		JLabel lblPassword = new JLabel("Password");
		layeredPane.add(lblPassword, "2, 4, center, default");
		
		passwordField = new JPasswordField();
		passwordField.setColumns(10);
		layeredPane.add(passwordField, "4, 4, center, default");
		
		JLabel lblNewPassword = new JLabel("New Password");
		layeredPane.add(lblNewPassword, "2, 6, center, default");
		
		passwordField_1 = new JPasswordField();
		passwordField_1.setColumns(10);
		layeredPane.add(passwordField_1, "4, 6, center, default");
		
		JButton btnNewButton_3 = new JButton("Update");
		layeredPane.add(btnNewButton_3, "1, 10, 4, 1, center, default");
		
		JLayeredPane layeredPane_1 = new JLayeredPane();
		tabbedPane.addTab("Add user", null, layeredPane_1, null);
		layeredPane_1.setLayout(new FormLayout(new ColumnSpec[] {
				ColumnSpec.decode("16dlu"),
				FormSpecs.DEFAULT_COLSPEC,
				FormSpecs.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("default:grow"),},
			new RowSpec[] {
				RowSpec.decode("16dlu"),
				FormSpecs.DEFAULT_ROWSPEC,
				RowSpec.decode("8dlu"),
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,}));
		
		JLabel lblUsername_1 = new JLabel("Username");
		layeredPane_1.add(lblUsername_1, "2, 2, right, default");
		
		textField_1 = new JTextField();
		layeredPane_1.add(textField_1, "4, 2, center, default");
		textField_1.setColumns(10);
		
		JLabel lblPassword_1 = new JLabel("Password");
		layeredPane_1.add(lblPassword_1, "2, 4, right, default");
		
		passwordField_2 = new JPasswordField();
		passwordField_2.setColumns(10);
		layeredPane_1.add(passwordField_2, "4, 4, center, default");
		
		JButton btnNewButton_4 = new JButton("Add");
		layeredPane_1.add(btnNewButton_4, "1, 8, 4, 1, center, default");
		
		clientPanel.setBackground(new Color(34, 139, 34));
		mainPanel.add(clientPanel, "name_72083669374496");
	}
	
	public void show() {
		frame.setVisible(true);
	}
}

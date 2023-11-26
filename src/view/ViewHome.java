package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;

import controller.CtrUser;
import model.User;

import com.jgoodies.forms.layout.FormSpecs;
import java.awt.CardLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import javax.swing.JTable;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JTabbedPane;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ViewHome {

	private JFrame frame;
	private CtrUser controller;
	private JPanel mainPanel = new JPanel();
	private JPanel dashboardPanel = new JPanel();
	private JPanel userPanel = new JPanel();
	private JPanel clientPanel = new JPanel();
	private JTable userTable;
	private JTextField textFieldUpdateUsername;
	private JPasswordField passwordFieldUpdatePasswd;
	private JPasswordField passwordFieldUpdateNewPasswd;
	private JTextField textFieldAddUsername;
	private JPasswordField passwordFieldAddUser;
	public JLabel jlabelUserBoxValue;

	/**
	 * Create the application.
	 */
	public ViewHome() {
		controller = new CtrUser(this);
		initialize();
		controller.updateDashboard();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 800, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setMinimumSize(new Dimension(800, 600));
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(211, 211, 211));
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
				controller.updateDashboard();
			}
		});
		sidePanel.add(btnNewButton_1, "2, 2, left, top");
		
		JButton btnNewButton = new JButton("User");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				((CardLayout)(mainPanel.getLayout())).show(mainPanel, "name_72074691210271");
				controller.printAllUser(userTable);
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
		
		jlabelUserBoxValue = new JLabel("0");
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
		
		JLabel jlabelClientBoxValue = new JLabel("0");
		jlabelClientBoxValue.setHorizontalAlignment(SwingConstants.CENTER);
		jlabelClientBoxValue.setFont(new Font("Dialog", Font.BOLD, 16));
		jlabelClientBoxValue.setBounds(0, 31, 94, 50);
		clientBox.add(jlabelClientBoxValue);
		
		userPanel.setBackground(new Color(255, 255, 255));
		mainPanel.add(userPanel, "name_72074691210271");
		userPanel.setLayout(new FormLayout(new ColumnSpec[] {
				ColumnSpec.decode("default:grow"),
				ColumnSpec.decode("250dlu"),
				ColumnSpec.decode("default:grow"),},
			new RowSpec[] {
				RowSpec.decode("16dlu"),
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				RowSpec.decode("16dlu"),
				FormSpecs.DEFAULT_ROWSPEC,
				RowSpec.decode("16dlu"),}));
		
		JLabel jlabelUserPanelTitle = new JLabel("List of users");
		jlabelUserPanelTitle.setFont(new Font("Dialog", Font.BOLD, 18));
		userPanel.add(jlabelUserPanelTitle, "2, 2, fill, center");
		
		JScrollPane scrollPane = new JScrollPane();
		userPanel.add(scrollPane, "2, 4, fill, fill");
		
		userTable = new JTable();
		userTable.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int index = userTable.getSelectedRow();
				textFieldUpdateUsername.setText(userTable.getValueAt(index, 1).toString());
				passwordFieldUpdatePasswd.setText(userTable.getValueAt(index, 2).toString());
			}
		});
		scrollPane.setViewportView(userTable);
		userTable.setBackground(new Color(248, 248, 255));
		
		JTabbedPane tabbedPaneUserPanel = new JTabbedPane(JTabbedPane.TOP);
		userPanel.add(tabbedPaneUserPanel, "2, 6, fill, fill");
		
		JLayeredPane layeredPane = new JLayeredPane();
		tabbedPaneUserPanel.addTab("Update user", null, layeredPane, null);
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
		
		textFieldUpdateUsername = new JTextField();
		textFieldUpdateUsername.setEditable(false);
		layeredPane.add(textFieldUpdateUsername, "4, 2, center, default");
		textFieldUpdateUsername.setColumns(10);
		
		JLabel lblPassword = new JLabel("Password");
		layeredPane.add(lblPassword, "2, 4, center, default");
		
		passwordFieldUpdatePasswd = new JPasswordField();
		passwordFieldUpdatePasswd.setEditable(false);
		passwordFieldUpdatePasswd.setColumns(10);
		layeredPane.add(passwordFieldUpdatePasswd, "4, 4, center, default");
		
		JLabel lblNewPassword = new JLabel("New Password");
		layeredPane.add(lblNewPassword, "2, 6, center, default");
		
		passwordFieldUpdateNewPasswd = new JPasswordField();
		passwordFieldUpdateNewPasswd.setColumns(10);
		layeredPane.add(passwordFieldUpdateNewPasswd, "4, 6, center, default");
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int choice = JOptionPane.showConfirmDialog(frame, "Do you want to update this user ?");
				if (choice == 0)
					controller.updateUser(new User(textFieldUpdateUsername.getText(), String.valueOf(passwordFieldUpdateNewPasswd.getPassword())));
				controller.printAllUser(userTable);
			}
		});
		layeredPane.add(btnUpdate, "1, 10, 4, 1, center, default");
		
		JLayeredPane layeredPane_1 = new JLayeredPane();
		tabbedPaneUserPanel.addTab("Add user", null, layeredPane_1, null);
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
		
		textFieldAddUsername = new JTextField();
		layeredPane_1.add(textFieldAddUsername, "4, 2, center, default");
		textFieldAddUsername.setColumns(10);
		
		JLabel lblPassword_1 = new JLabel("Password");
		layeredPane_1.add(lblPassword_1, "2, 4, right, default");
		
		passwordFieldAddUser = new JPasswordField();
		passwordFieldAddUser.setColumns(10);
		layeredPane_1.add(passwordFieldAddUser, "4, 4, center, default");
		
		JButton btnAdd = new JButton("Add");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int choice = JOptionPane.showConfirmDialog(frame, "Do you want to add a new user ?");
				if (choice == 0)
					controller.addUser(new User(textFieldAddUsername.getText(), String.valueOf(passwordFieldAddUser.getPassword())));
				controller.printAllUser(userTable);
			}
		});
		layeredPane_1.add(btnAdd, "1, 8, 4, 1, center, default");
		
		clientPanel.setBackground(new Color(34, 139, 34));
		mainPanel.add(clientPanel, "name_72083669374496");
	}
	
	public void show() {
		frame.setVisible(true);
	}
	
	public void showErrorMessage(String message) {
		JOptionPane.showMessageDialog(frame, message, "Gestion Hotel", JOptionPane.ERROR_MESSAGE);
	}
	
	public void showSuccessMessage(String message) {
		JOptionPane.showMessageDialog(frame, message, "Gestion Hotel", JOptionPane.INFORMATION_MESSAGE);
	}
	
	public JFrame getFrame() {
		return frame;
	}
}

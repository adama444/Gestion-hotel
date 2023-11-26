package controller;

import java.awt.Component;
import java.util.List;

import javax.swing.DefaultCellEditor;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import dao.DaoUser;
import model.User;
import view.ViewHome;
import view.ViewLogin;

public class CtrUser {
	
	private ViewLogin view;
	
	private ViewHome viewHome;

	public CtrUser(ViewLogin view) {
		super();
		this.view = view;
	}
	
	public CtrUser(ViewHome viewHome) {
		super();
		this.viewHome = viewHome;
	}
	
	public void updateUser(User userToUpdate) {
		if (DaoUser.updateUser(userToUpdate))
			viewHome.showSuccessMessage("User successfully updated");
		else
			viewHome.showErrorMessage("Error when updating user");
	}

	public void controlUserInfos(User user) {
		if (DaoUser.findUser(user)) {
			view.openHomeJFrame();
		} else {
			view.showErrorMessage();
		}
	}
	
	public void updateDashboard() {
		viewHome.jlabelUserBoxValue.setText(getUserCount());
	}
	
	public void printAllUser(JTable table) {
		String[] columns = {"ID", "Username", "Password", "Action"};
		List<User> allUsers = DaoUser.getAllUser();
		Object[][] data = allUsers.stream()
                .map(user -> new Object[]{user.getId(), user.getUsername(), user.getPassword(), "Delete"})
                .toArray(Object[][]::new);
		
		DefaultTableModel tableModel = new DefaultTableModel(data, columns) {
			private static final long serialVersionUID = 1L;

			public boolean isCellEditable(int row, int column) {
				if (column == 3) return true;
				return false;
			};
		};
		table.setModel(tableModel);
	    table.setRowHeight(24);
	    table.getColumnModel().getColumn(3).setCellRenderer((arg0, arg1, arg2, arg3, arg4, arg5) -> new JButton(arg1.toString()));
	    table.getColumnModel().getColumn(3).setCellEditor(new DefaultCellEditor(new JTextField()) {
	    	private static final long serialVersionUID = 1L;

			public java.awt.Component getTableCellEditorComponent(JTable arg0, Object arg1, boolean arg2, int arg3, int arg4) {
	    		JButton button = new JButton("Delete");
	    		button.addActionListener(e -> {
	    			int choice = JOptionPane.showConfirmDialog(viewHome.getFrame(), "Do you want to delete this user ?");
					if (choice == 0)
						if (DaoUser.deleteUser(allUsers.get(table.getSelectedRow())))
							viewHome.showSuccessMessage("User successfully dropped");
						else
							viewHome.showErrorMessage("Error when deleting user");
	                printAllUser(table);
	            });
				return button;
	    	};
	    });
	}
	
	public String getUserCount() {
		String formattedString = new String("0");
		int count = DaoUser.getUserCount();
		String str = String.valueOf(count);
		if (str.length() == 1) {
			formattedString = String.format("0%s", str);
		} else {
			formattedString = String.format("%s", str);
		}
		
		return formattedString;
	}

	public void addUser(User user) {
		if (DaoUser.addUser(user))
			viewHome.showSuccessMessage("User successfully added");
		else
			viewHome.showErrorMessage("Error when adding user");
	}

	
}
package controller;

import dao.DaoUser;
import model.User;
import view.ViewHome;
import view.ViewLogin;

public class CtrUser {
	private ViewLogin view;
	@SuppressWarnings("unused")
	private ViewHome viewHome;

	public CtrUser(ViewLogin view) {
		super();
		this.view = view;
	}
	
	public CtrUser(ViewHome viewHome) {
		super();
		this.viewHome = viewHome;
	}

	public void controlUserInfos(User user) {
		if (DaoUser.findUser(user)) {
			view.openHomeJFrame();
		} else {
			view.showErrorMessage();
		}
	}
	
	/*public void printAllUser(JTable table) {
		//List<User> allUsers = DaoUser.getAllUser();
		
	}*/
	
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
}

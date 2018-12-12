package ButtonEvent;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import Model.LoginModel;
import OrderUtil.StringUtil;

public class LoginEvent implements ActionListener {
	private String username;
	private String password;
	
	public LoginEvent(LoginModel lm) {
		super();
		this.username = lm.getUsername();
		this.password = lm.getUsername();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(StringUtil.isEmpty(this.username)) {
			JOptionPane.showMessageDialog(null, "请输入用户名！");
			return;
		}
		if(StringUtil.less6(this.username)) {
			JOptionPane.showMessageDialog(null, "输入的用户名必须是6位或6位以上的字符！");
			return;
		}
		if(StringUtil.isEmpty(new String(this.password))) {
			JOptionPane.showMessageDialog(null, "请输入密码！");
			return;
		}
		if(StringUtil.less8(new String(this.password))) {
			JOptionPane.showMessageDialog(null, "输入的密码必须是8位或8位以上的字符！");
			return;
		}
		System.out.println(new String(this.password).length());
	}

}

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
			JOptionPane.showMessageDialog(null, "�������û�����");
			return;
		}
		if(StringUtil.less6(this.username)) {
			JOptionPane.showMessageDialog(null, "������û���������6λ��6λ���ϵ��ַ���");
			return;
		}
		if(StringUtil.isEmpty(new String(this.password))) {
			JOptionPane.showMessageDialog(null, "���������룡");
			return;
		}
		if(StringUtil.less8(new String(this.password))) {
			JOptionPane.showMessageDialog(null, "��������������8λ��8λ���ϵ��ַ���");
			return;
		}
		System.out.println(new String(this.password).length());
	}

}

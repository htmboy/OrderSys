package View;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import OrderUtil.StringUtil;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class LoginView extends JFrame {

	private JPanel contentPane;
	private JTextField user_name_field;
	private JPasswordField password_field;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					// 改变系统默认字体
					Font font = new Font("Dialog", Font.PLAIN, 12);
					java.util.Enumeration keys = UIManager.getDefaults().keys();
					while(keys.hasMoreElements()) {
						Object key = keys.nextElement();
						Object value = UIManager.get(key);
						if(value instanceof javax.swing.plaf.FontUIResource) {
							UIManager.put(key, font);
						}
					}
					LoginView frame = new LoginView();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public LoginView() {
		setTitle("\u8BA2\u5355\u7BA1\u7406\u7CFB\u7EDF-\u767B\u5F55\u7528\u6237");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(450, 300);
		setLocationRelativeTo(null);
//		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("\u7528\u6237\u540D\uFF1A");
		lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel.setBounds(109, 96, 58, 15);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("\u5BC6 \u7801\uFF1A");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1.setBounds(109, 143, 58, 15);
		contentPane.add(lblNewLabel_1);
		
		user_name_field = new JTextField();
		user_name_field.setBounds(187, 93, 140, 21);
		contentPane.add(user_name_field);
		user_name_field.setColumns(16);
		
		JButton login_Button = new JButton("\u767B \u5F55");
		login_Button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				String username = user_name_field.getText();
				char[] password = password_field.getPassword();
				if(StringUtil.isEmpty(username)) {
					JOptionPane.showMessageDialog(null, "请输入用户名！");
					return;
				}
				if(StringUtil.less6(username)) {
					JOptionPane.showMessageDialog(null, "输入的用户名必须是6位或6位以上的字符！");
					return;
				}
				if(StringUtil.isEmpty(new String(password))) {
					JOptionPane.showMessageDialog(null, "请输入密码！");
					return;
				}
				if(StringUtil.less8(new String(password))) {
					JOptionPane.showMessageDialog(null, "输入的密码必须是8位或8位以上的字符！");
					return;
				}
				System.out.println(StringUtil.XmlBuilder(username, new String(password)));
			}
		});
		login_Button.setBounds(155, 210, 97, 23);
		contentPane.add(login_Button);
		
		password_field = new JPasswordField();
		password_field.setBounds(187, 140, 140, 21);
		contentPane.add(password_field);
	}
}

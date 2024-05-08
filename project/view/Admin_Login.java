package project.view;

import java.awt.Container;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import project.controller.AdminDao;
import project.model.Admin_Model;

@SuppressWarnings("all")
public class Admin_Login extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	
	private JLabel titleL, title2L, idL, pwL;
	private JTextField idT;
	private JTextField pwT;
	private JButton loginBtn, cancelBtn;
	String id, password;
	

	public Admin_Login() {
		// 아이디 입력창
		titleL = new JLabel("수강신청 프로그램");
		titleL.setFont(new Font("굴림", Font.BOLD, 30));

		title2L = new JLabel("관리자 로그인");
		title2L.setFont(new Font("굴림", Font.BOLD, 20));

		idL = new JLabel("관리자 아이디");
		idL.setFont(new Font("굴림", Font.BOLD, 16));

		idT = new JTextField();
		idT.setFont(new Font("굴림", Font.BOLD, 16));

		// 비밀번호 입력창
		pwL = new JLabel("관리자 비밀번호");
		pwL.setFont(new Font("굴림", Font.BOLD, 16));

		pwT = new JPasswordField();
		pwT.setFont(new Font("굴림", Font.BOLD, 16));
		

		// 로그인 버튼
		loginBtn = new JButton("관리자 로그인");
		

		// 취소 버튼
		cancelBtn = new JButton("취소");
		

		// 위치
		titleL.setBounds(80, 80, 400, 50);
		title2L.setBounds(142, 128, 132, 50);
		idL.setBounds(50, 230, 150, 30);
		idT.setBounds(200, 230, 150, 30);
		pwL.setBounds(50, 290, 150, 30);
		pwT.setBounds(200, 290, 150, 30);

		cancelBtn.setBounds(40, 380, 132, 50);
		loginBtn.setBounds(170, 380, 132, 50);

		
		Container c = this.getContentPane();
		c.add(titleL);
		c.add(title2L);
		c.add(idL);
		c.add(idT);

		c.add(pwL);
		c.add(pwT);

		c.add(loginBtn);
		c.add(cancelBtn);
		
		
		
		
		getContentPane().setLayout(null);
		setBounds(700, 300, 510, 530);
		setVisible(true);
		setResizable(false);
		
		setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				setVisible(false);
				
			}
		});
		
		
		cancelBtn.addActionListener(this);
		loginBtn.addActionListener(this);
		
		
	}
	

	@Override
	public void actionPerformed (ActionEvent e) {
		if(e.getSource() == loginBtn) {
			login();
		} else if (e.getSource() == cancelBtn) {
			setVisible(false);
		}
		
	}
	
	private void login() {
		// 데이터
		String id = idT.getText();
		String password = pwT.getText();

		
		Admin_Model adm = new Admin_Model();
		adm.setId(id);
		adm.setPassword(password);

		// DB
		AdminDao adao = AdminDao.getInstance();

		int su = adao.loginArticle(adm);

		// setVisible(false);
		if ((idT.getText()).equals("") || (idT.getText()).equals(null) || (pwT.getText()).equals("")
				|| (pwT.getText()).equals(null)) { // 공백
			JOptionPane.showMessageDialog(this, "아이디 또는 비밀번호를 입력해주세요");
		} else if (su == 1) {
			setVisible(false);
			new Admin_Admin(idT.getText());
		} else if (su == 0) {
			JOptionPane.showMessageDialog(this, "아이디 또는 비밀번호가 올바르지 않습니다.");
		}
		
		
		
	}
}
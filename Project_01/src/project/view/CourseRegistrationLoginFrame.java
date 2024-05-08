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


import project.controller.*;
import project.model.*;
import project.view.*;

public class CourseRegistrationLoginFrame extends JFrame implements ActionListener{
	public CourseRegistrationLoginFrame() {
	}

	private static final long serialVersionUID = 1L;
	private JLabel titleLabel, idLabel, passwordLabel;
	private JTextField textField_Id;
	private JTextField textField_Password;
	private JButton btnLogin;
	private JPanel panel_Button;
	String id, password;
	private MyCourse_Me mcm;
	
	public void login() {
		titleLabel = new JLabel("수강신청 프로그램");
		
		titleLabel.setFont(new Font("굴림", Font.BOLD, 30));
		
		idLabel = new JLabel("학번");
		idLabel.setFont(new Font("굴림", Font.BOLD, 18));
		
		textField_Id = new JTextField();
		textField_Id.setFont(new Font("굴림", Font.BOLD, 18));
		
		passwordLabel = new JLabel("비밀번호");
		passwordLabel.setFont(new Font("굴림", Font.BOLD, 18));
		
		textField_Password = new JPasswordField();
		textField_Password.setFont(new Font("굴림", Font.BOLD, 18));
		
		btnLogin = new JButton("로그인");
		btnLogin.setFont(new Font("굴림", Font.BOLD, 14));
		panel_Button.add(btnLogin);
		btnLogin.addActionListener((e) -> {
			try {
				Login();
			} catch (Exception e1) {
				
				e1.printStackTrace();
			}
		});
		
		titleLabel.setBounds(380, 140, 250, 50);
		
		idLabel.setBounds(330, 230, 80, 30);
		textField_Id.setBounds(420, 230, 150, 30);
		passwordLabel.setBounds(330, 290, 80, 30);
		textField_Password.setBounds(420, 290, 150, 30);
		
		btnLogin.setBounds(460, 380, 132, 50);
		
		
		Container c = this.getContentPane();
		c.add(titleLabel);
		
		c.add(idLabel);
		c.add(textField_Id);
		
		c.add(passwordLabel);
		c.add(textField_Password);
		
		c.add(btnLogin);
		
		getContentPane().setLayout(null);
		setBounds(700, 300, 650, 530);
		setVisible(true);
		setResizable(false);

		setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				int exit = JOptionPane.showConfirmDialog(CourseRegistrationLoginFrame.this, "정말 종료 하시겠습니까?", "수강신청 프로그램 종료",
						JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
				if (exit == JOptionPane.YES_OPTION) {
					System.exit(0);
				}
			}
		});
		
	}
	
	
	private void Login() {
		String id = textField_Id.getText();
		String password = textField_Password.getText();
		
		
		CourseRegistrationMember crm = new CourseRegistrationMember();
		crm.setId(id);
		crm.setPassword(password);
		
		CourseRegistrationMemberDao mdao = CourseRegistrationMemberDao.getInstance();
		
		int lg = mdao.loginMember(crm);
		
		// setVisible(false)
		
		if(textField_Id.getText().equals("") || textField_Id.getText().equals(null) ||
			textField_Password.getText().equals("") || textField_Password.getText().equals(null)) {
			JOptionPane.showMessageDialog(this, "학번 또는 비밀번호를 입력해주세요.");
		} else if(lg == 1){
			try {
				new MyCourse_Me(id);
				MyCourse_Home mch = new MyCourse_Home(id, mcm);
				mch.setVisible(true);
				// dispose();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			 dispose();
		} else if(lg == 0) {
			JOptionPane.showMessageDialog(this, "학번 또는 비밀번호가 올바르지 않습니다.");
		}
	}






	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnLogin) { // 로그인
			Login();
		} 
		
	}

	

}

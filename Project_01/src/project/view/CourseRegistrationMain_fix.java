package project.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Container;

import javax.swing.JTextField;

import project.controller.AdminDao;
import project.controller.CourseRegistrationMemberDao;
import project.view.CourseRegisterationSignFrame.SignNotify;
import project.model.*;
import project.view.*;
import project.controller.*;


import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class CourseRegistrationMain_fix implements SignNotify {

	
	private CourseRegistrationMemberDao dao = CourseRegistrationMemberDao.getInstance();
	
	private static final String[] DISTINCT_TYPES = {
			"학부생" , "관리자"
	};
	
	private String id;
	private String password;
	private MyCourse_Me mcm;
	private Admin_Admin admin;
	
	
	private JFrame frame;
	private JPanel titlePanel;
	private JLabel titleLabel;
	private JPanel insertPanel;
	private JPanel buttonPanel;
	private JLabel distinctionLabel;
	private JLabel idLabel;
	private JLabel passwordLabel;
	private JComboBox<String> comboBox;
	private JTextField textField_Id;
	private JTextField textField_Password;
	private JButton btnsign;
	private JButton btnLogin;
	private JButton btnLogin_Admin;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CourseRegistrationMain_fix window = new CourseRegistrationMain_fix();
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
	public CourseRegistrationMain_fix() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("수강신청 프로그램");
		frame.setBounds(100, 100, 477, 566);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		titlePanel = new JPanel();
		titlePanel.setBounds(12, 102, 439, 34);
		frame.getContentPane().add(titlePanel);
		
		titleLabel = new JLabel("수강신청 프로그램");
		titleLabel.setFont(new Font("굴림", Font.BOLD, 20));
		titlePanel.add(titleLabel);
		
		insertPanel = new JPanel();
		insertPanel.setBounds(12, 172, 439, 275);
		frame.getContentPane().add(insertPanel);
		insertPanel.setLayout(null);
		
		distinctionLabel = new JLabel("구분");
		distinctionLabel.setFont(new Font("굴림", Font.PLAIN, 16));
		distinctionLabel.setBounds(37, 66, 89, 41);
		insertPanel.add(distinctionLabel);
		
		idLabel = new JLabel("학번");
		idLabel.setFont(new Font("굴림", Font.PLAIN, 16));
		idLabel.setBounds(37, 130, 89, 41);
		insertPanel.add(idLabel);
		
		passwordLabel = new JLabel("비밀번호");
		passwordLabel.setFont(new Font("굴림", Font.PLAIN, 16));
		passwordLabel.setBounds(37, 192, 89, 41);
		insertPanel.add(passwordLabel);
		
		comboBox = new JComboBox();
		final DefaultComboBoxModel<String> comboBoxModel =
				new DefaultComboBoxModel<>(DISTINCT_TYPES);
		comboBox.setModel(comboBoxModel);
		comboBox.setBounds(138, 66, 246, 31);
		insertPanel.add(comboBox);
		
		textField_Id = new JTextField();
		textField_Id.setBounds(138, 130, 246, 31);
		insertPanel.add(textField_Id);
		textField_Id.setColumns(10);
		
		textField_Password = new JTextField();
		textField_Password.setColumns(10);
		textField_Password.setBounds(138, 192, 246, 31);
		insertPanel.add(textField_Password);
		
		buttonPanel = new JPanel();
		buttonPanel.setBounds(12, 457, 439, 34);
		frame.getContentPane().add(buttonPanel);
		buttonPanel.setLayout(null);
		
		btnsign = new JButton("회원가입");
		btnsign.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CourseRegisterationSignFrame.showCourseRegisterationSignframe(frame, CourseRegistrationMain_fix.this);
			}
		});
		btnsign.setFont(new Font("굴림", Font.PLAIN, 10));
		btnsign.setBounds(12, 5, 100, 23);
		buttonPanel.add(btnsign);
		
		btnLogin = new JButton("로그인");
		btnLogin.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				
				
				try {
					Login();
					
				} catch (Exception e1) {

					e1.printStackTrace();
				}
			 
				
		}
			
			private void Login() throws Exception{
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
					JOptionPane.showMessageDialog(frame, "학번 또는 비밀번호를 입력해주세요.");
				} else if(lg == 1){
					try {
						new MyCourse_Me(id);
						MyCourse_Home mch = new MyCourse_Home(id, mcm);
						mch.setVisible(true);
						frame.dispose();						
					} catch (Exception e) {
						e.printStackTrace();
					}
					
				} else if(lg == 0) {
					JOptionPane.showMessageDialog(frame, "학번 또는 비밀번호가 올바르지 않습니다.");
				}
			}


		});
		btnLogin.setFont(new Font("굴림", Font.PLAIN, 10));
		btnLogin.setBounds(170, 5, 100, 23);
		buttonPanel.add(btnLogin);
		
		btnLogin_Admin = new JButton("관리자 로그인");
		btnLogin_Admin.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == btnLogin_Admin) {
					try {
						// frame.setVisible(false);
						new Admin_Login();
					} catch (Exception e1) {
						e1.printStackTrace();
					}
				}
			}
			
			
			

		});
		btnLogin_Admin.setFont(new Font("굴림", Font.PLAIN, 10));
		btnLogin_Admin.setBounds(327, 5, 100, 23);
		buttonPanel.add(btnLogin_Admin);
		
		
	}
}

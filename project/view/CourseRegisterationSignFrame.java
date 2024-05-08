package project.view;

import java.awt.Component;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import project.controller.CourseRegistrationMemberDao;
import project.model.CourseRegistrationMember;

import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;

import java.awt.Font;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;

import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.List;
import java.awt.event.ActionEvent;

public class CourseRegisterationSignFrame extends JFrame {
	public interface SignNotify {
		
	}

	private static final long serialVersionUID = 1L;
	
	private CourseRegistrationMemberDao dao = CourseRegistrationMemberDao.getInstance();
	private SignNotify app;
	private Component parent;
	
	private JPanel contentPane;
	private JPanel panel_Insert;
	private JPanel panel_Button;
	private JLabel insertIdLabel;
	private JLabel insertPhoneLable;
	private JLabel insertPasswordLabel;
	private JLabel insertNameLabel;
	private JLabel insertEmailLabel;
	private JLabel insertTitleLabel;
	private JPanel panel_InsertTitle;
	private JButton btnInsertSign;
	private JButton btnInsertCancel;
	private JTextField textField_InsertId;
	private JTextField textField_InsertName;
	private JTextField textField_InsertPassword;
	private JTextField textField_InsertPhone;
	private JTextField textField_InsertEmail;

	/**
	 * Launch the application.
	 */
	public static void showCourseRegisterationSignframe(Component parent, SignNotify app) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CourseRegisterationSignFrame frame = new CourseRegisterationSignFrame(parent, app);
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
	private CourseRegisterationSignFrame(Component parent, SignNotify app) {
		
		this.parent = parent;
		this.app = app;
		
		initialize();
		
	}
	private JList<CourseRegistrationMember> list;	
	private DefaultListModel<CourseRegistrationMember> model;

	
		public void initialize() {
		setTitle("회원가입");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		int x = 0;
		int y = 0;
		if(parent != null) {
			x = parent.getX();
			y= parent.getY();
		}
		
		setBounds(x, y, 477, 566);
		
		if(parent == null) {
			setLocationRelativeTo(null);
		}
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		panel_Insert = new JPanel();
		panel_Insert.setBounds(12, 69, 439, 369);
		contentPane.add(panel_Insert);
		panel_Insert.setLayout(null);
		
		insertIdLabel = new JLabel("학번");
		insertIdLabel.setFont(new Font("굴림", Font.BOLD, 16));
		insertIdLabel.setBounds(37, 49, 74, 36);
		panel_Insert.add(insertIdLabel);
		
		insertNameLabel = new JLabel("이름");
		insertNameLabel.setFont(new Font("굴림", Font.BOLD, 16));
		insertNameLabel.setBounds(37, 113, 74, 36);
		panel_Insert.add(insertNameLabel);
		
		insertPasswordLabel = new JLabel("비밀번호");
		insertPasswordLabel.setFont(new Font("굴림", Font.BOLD, 16));
		insertPasswordLabel.setBounds(37, 176, 74, 36);
		panel_Insert.add(insertPasswordLabel);
		
		insertPhoneLable = new JLabel("전화번호");
		insertPhoneLable.setFont(new Font("굴림", Font.BOLD, 16));
		insertPhoneLable.setBounds(37, 239, 74, 36);
		panel_Insert.add(insertPhoneLable);
		
		insertEmailLabel = new JLabel("이메일");
		insertEmailLabel.setFont(new Font("굴림", Font.BOLD, 16));
		insertEmailLabel.setBounds(37, 298, 74, 36);
		panel_Insert.add(insertEmailLabel);
		
		textField_InsertId = new JTextField();
		textField_InsertId.setBounds(127, 49, 282, 36);
		panel_Insert.add(textField_InsertId);
		textField_InsertId.setColumns(10);
		
		textField_InsertName = new JTextField();
		textField_InsertName.setColumns(10);
		textField_InsertName.setBounds(127, 113, 282, 36);
		panel_Insert.add(textField_InsertName);
		
		textField_InsertPassword = new JTextField();
		textField_InsertPassword.setColumns(10);
		textField_InsertPassword.setBounds(127, 176, 282, 36);
		panel_Insert.add(textField_InsertPassword);
		
		textField_InsertPhone = new JTextField();
		textField_InsertPhone.setColumns(10);
		textField_InsertPhone.setBounds(127, 239, 282, 36);
		panel_Insert.add(textField_InsertPhone);
		
		textField_InsertEmail = new JTextField();
		textField_InsertEmail.setColumns(10);
		textField_InsertEmail.setBounds(127, 298, 282, 36);
		panel_Insert.add(textField_InsertEmail);
		
		panel_Button = new JPanel();
		panel_Button.setBounds(12, 470, 439, 33);
		contentPane.add(panel_Button);
		
		btnInsertSign = new JButton("등록");
		
		model = new DefaultListModel<CourseRegistrationMember>();
		list = new JList<CourseRegistrationMember>(model);
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		
		btnInsertSign.addActionListener((e) -> {
			try {
				joinMember();
			} catch (Exception e1) {
				
				e1.printStackTrace();
			}
		});
		btnInsertSign.setFont(new Font("굴림", Font.BOLD, 14));
		panel_Button.add(btnInsertSign);
		
		btnInsertCancel = new JButton("취소");
		btnInsertCancel.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int exit = JOptionPane.showConfirmDialog(CourseRegisterationSignFrame.this, "취소 하시겠습니까?", "회원가입 취소"
							, JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
					if(exit == JOptionPane.YES_OPTION) {
						dispose();
					}
			}
		});
		
		btnInsertCancel.setFont(new Font("굴림", Font.BOLD, 14));
		panel_Button.add(btnInsertCancel);
		
		panel_InsertTitle = new JPanel();
		panel_InsertTitle.setBounds(12, 10, 439, 49);
		contentPane.add(panel_InsertTitle);
		panel_InsertTitle.setLayout(null);
		
		insertTitleLabel = new JLabel("회원정보 등록");
		insertTitleLabel.setFont(new Font("굴림", Font.BOLD, 16));
		insertTitleLabel.setBounds(162, 10, 112, 29);
		panel_InsertTitle.add(insertTitleLabel);
	} // initialize end
	
		
		// 가입 메서드
		private void joinMember() throws Exception{
			String id = textField_InsertId.getText();
			String name = textField_InsertName.getText();
			String password = textField_InsertPassword.getText();
			String phone = textField_InsertPhone.getText();
			String email = textField_InsertEmail.getText();
			
			CourseRegistrationMember crm = new CourseRegistrationMember();
			crm.setId(id);
			crm.setName(name);
			crm.setPassword(password);
			crm.setPhone(phone);
			crm.setEmail(email);
			
			CourseRegistrationMemberDao mdao = CourseRegistrationMemberDao.getInstance();
			mdao.insertMember(crm);
			model.addElement(crm);
			
			clear(); // 초기화
			JOptionPane.showMessageDialog(this, "가입이 완료되었습니다.");
			setVisible(false);
			
			
				
			}
		//초기화 메서드
		private void clear() {
			textField_InsertId.setText("");
			textField_InsertName.setText("");
			textField_InsertPassword.setText("");
			textField_InsertPhone.setText("");
			textField_InsertEmail.setText("");
		}
		
	}





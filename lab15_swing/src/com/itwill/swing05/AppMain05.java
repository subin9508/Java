package com.itwill.swing05;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;

public class AppMain05 {

	private JFrame frame;
	private JLabel lblName;
	private JLabel lblPhone;
	private JLabel lblEmail;
	private JTextField textName;
	private JTextField textPhone;
	private JTextField textEmail;
	private JButton btnInput;
	private JTextArea textArea;
	private JScrollPane scrollPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AppMain05 window = new AppMain05();
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
	public AppMain05() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setFont(new Font("D2Coding", Font.PLAIN, 12));
		frame.setBounds(100, 100, 561, 385);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		lblName = new JLabel("이름");
		lblName.setBounds(22, 13, 116, 43);
		lblName.setFont(new Font("D2Coding", Font.PLAIN, 12));
		frame.getContentPane().add(lblName);
		
		lblPhone = new JLabel("전화번호");
		lblPhone.setBounds(22, 66, 128, 43);
		lblPhone.setHorizontalAlignment(SwingConstants.LEFT);
		lblPhone.setFont(new Font("D2Coding", Font.PLAIN, 12));
		frame.getContentPane().add(lblPhone);
		
		lblEmail = new JLabel("이메일");
		lblEmail.setBounds(22, 119, 128, 49);
		lblEmail.setFont(new Font("D2Coding", Font.PLAIN, 12));
		frame.getContentPane().add(lblEmail);
		
		textName = new JTextField();
		textName.setBounds(120, 21, 264, 27);
		frame.getContentPane().add(textName);
		textName.setColumns(10);
		
		textPhone = new JTextField();
		textPhone.setBounds(120, 74, 264, 27);
		frame.getContentPane().add(textPhone);
		textPhone.setColumns(10);
		
		textEmail = new JTextField();
		textEmail.setBounds(120, 130, 264, 27);
		frame.getContentPane().add(textEmail);
		textEmail.setColumns(10);
		
		btnInput = new JButton("입력");
		btnInput.setFont(new Font("D2Coding", Font.PLAIN, 12));
		btnInput.addActionListener(new ActionListener() { // 익명 내부 클래스
			@Override
			public void actionPerformed(ActionEvent e) {
				handleInputButtonClick();
			}
		});
		btnInput.setBounds(397, 125, 116, 37);
		frame.getContentPane().add(btnInput);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(22, 201, 491, 121);
		frame.getContentPane().add(scrollPane);
		
		textArea = new JTextArea();
		textArea.setFont(new Font("D2Coding", Font.PLAIN, 13));
		scrollPane.setViewportView(textArea);
	}
	
	private void handleInputButtonClick() {
	
		String name = textName.getText();
		String phone = textPhone.getText();
		String email = textEmail.getText();
	
		String msg = String.format("이름: %s 전화번호: %s 이메일: %s\n", name, phone, email);
		
		
		// textArea.append(msg); // 이름, 전화번호, 이메일을 JTextArea에 씀.
		textArea.append(msg); // apppend() : 주어진 텍스트를 기존 내용 뒤에 추가한다. 
		
		
		
		//모든 JTextField의 입력된 내용을 지움.
		textName.setText("");
		textPhone.setText("");
		textEmail.setText("");
	}
}

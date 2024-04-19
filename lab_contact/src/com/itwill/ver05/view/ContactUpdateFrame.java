package com.itwill.ver05.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.itwill.ver05.controller.ContactDao;
import com.itwill.ver05.controller.ContactDaoImpl;
import com.itwill.ver05.model.Contact;

import java.awt.BorderLayout;
import java.awt.Component;

import javax.swing.JButton;
import java.awt.Font;
import java.util.List;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class ContactUpdateFrame extends JFrame {
	
	public interface UpdateNotify {
		public void notifyContactUpdated(); // public 생략 가능.
	}
	
	private UpdateNotify app; // 메인 쓰레드 주소를 저장하기 위한 객체

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JPanel contentPanel;
    private JPanel buttonPanel;
    private JButton btnSave;
    private JButton btnCancel;
    private JLabel lblName;
    private JTextField textName;
    private JTextField textPhone;
    private JTextField textEmail;
    private JLabel lblPhone;
    private JLabel lblEmail;

    
    private Component parentComponent; // 부모 컴포넌트를 저장하기 위해서(부모 컴포넌트의 주소)
    
    private ContactDao dao = ContactDaoImpl.getInstance(); // dao가 필드에 있으면 initializeTextFields()에서 사용 가능.
    
    private int index; // 업데이트할 연락처의 (리스트) 인덱스를 저장하기 위해서
    
    
    /**
     * Launch the application.
     */
    public static void showContactUpdateFrame(Component parentComponent, int index, UpdateNotify app) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    ContactUpdateFrame frame = new ContactUpdateFrame(parentComponent, index ,app);
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
    public ContactUpdateFrame(Component parentComponent, int index, UpdateNotify app ) { // 생성자
    	this.parentComponent = parentComponent;
    	this.index = index;
    	this.app = app;
        initialize();
        initializeTextFields();
    }
    
    private void initializeTextFields() {
    	// 3개의 텍스트필드에 해당 인덱스의 연락처 정보를 채움.
    	Contact contact = dao.read(index);
    	textName.setText(contact.getName());
    	textPhone.setText(contact.getPhone());
    	textEmail.setText(contact.getEmail());
    	
    	
    }
    
    public void initialize() {
        setTitle("연락처 업데이트");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        
        int x = 0;
		int y = 0;
		
		if(parentComponent != null) {
			//  부모 컴포넌트가 있으면 부모 컴포넌트와 같은 좌표(x, y)에 위치시킴.
			x = parentComponent.getX();
			y = parentComponent.getY();
		}
		setBounds(x, y, 665, 435);
		
		// 부모 컴포넌트가 없으면 화면 중앙에 위치시킴.
		if(parentComponent == null) {
			setLocationRelativeTo(null);
		} 
        
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(new BorderLayout(0, 0));
        
        contentPanel = new JPanel();
        contentPane.add(contentPanel, BorderLayout.CENTER);
        contentPanel.setLayout(null);
        
        lblName = new JLabel("이름");
        lblName.setFont(new Font("D2Coding", Font.PLAIN, 28));
        lblName.setBounds(12, 10, 121, 64);
        contentPanel.add(lblName);
        
        textName = new JTextField();
        textName.setFont(new Font("D2Coding", Font.PLAIN, 28));
        textName.setBounds(145, 10, 359, 64);
        contentPanel.add(textName);
        textName.setColumns(10);
        
        lblPhone = new JLabel("전화번호");
        lblPhone.setFont(new Font("D2Coding", Font.PLAIN, 28));
        lblPhone.setBounds(12, 84, 121, 64);
        contentPanel.add(lblPhone);
        
        textPhone = new JTextField();
        textPhone.setFont(new Font("D2Coding", Font.PLAIN, 28));
        textPhone.setColumns(10);
        textPhone.setBounds(145, 84, 359, 64);
        contentPanel.add(textPhone);
        
        lblEmail = new JLabel("이메일");
        lblEmail.setFont(new Font("D2Coding", Font.PLAIN, 28));
        lblEmail.setBounds(12, 158, 121, 64);
        contentPanel.add(lblEmail);
        
        textEmail = new JTextField();
        textEmail.setFont(new Font("D2Coding", Font.PLAIN, 28));
        textEmail.setColumns(10);
        textEmail.setBounds(145, 158, 359, 64);
        contentPanel.add(textEmail);
        
        buttonPanel = new JPanel();
        contentPane.add(buttonPanel, BorderLayout.SOUTH);
        
        btnSave = new JButton("저장");
        btnSave.addActionListener((e) -> updateContact());
        btnSave.setFont(new Font("D2Coding", Font.PLAIN, 28));
        buttonPanel.add(btnSave);
        
        btnCancel = new JButton("취소");
        btnCancel.addActionListener((e) -> dispose());
        btnCancel.setFont(new Font("D2Coding", Font.PLAIN, 28));
        buttonPanel.add(btnCancel);
    }

	private void updateContact() {
		// 업데이트할 내용을 읽음.
		String name = textName.getText();
		String phone = textPhone.getText();
		String email = textEmail.getText();
		
		Contact contact = new Contact(0, name, phone, email);
		
		int result = dao.update(index, contact);
		if(result == 1) {
			// 메인 쓰레드에게 업데이트 성공을 알려줌.
			app.notifyContactUpdated();
			// 현재 창 닫기
			dispose();
		} else {
			JOptionPane.showMessageDialog(parentComponent, "연락처 업데이트 실패");
		}

	}
    
    
//    private void updateContact() {
//    	String name = textName.getText();
//		String phone = textPhone.getText();
//		String email = textEmail.getText();
//		
//		Contact contact = new Contact(0, name, phone, email);
//		
//		int result = dao.update(index, contact);
//		if(result == 1) { 
//			
//			app.notifyContactUpdated();
//			dispose(); // 현재 창 닫기
//		} else { 
//			
//			JOptionPane.showMessageDialog(parentComponent, "연락처 수정 실패");
//		
//		}	
    }

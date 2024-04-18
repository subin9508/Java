package com.itwill.swing07;

import java.awt.Component;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

public class MyFrame extends JFrame {
	public interface Notifiable { // static 생략
		public void notifyMessage(String msg);
	} // Notifiable을 구현하려면 반드시 notifyMessage 메서드를 가지고 있어야 한다.

	private static final long serialVersionUID = 1L;
	private JPanel contentPanel = new JPanel();

	
	private Component parentComponent; // 부모 컴포넌트를 저장하기 위한 필드
	private Notifiable app; // notifyMessage(String msg) 메서드를 갖는 객체의 주소를 저장할 필드
	/**
	 * Launch the application.
	 */
	public static void showMyFrame(Component parentComponent, Notifiable app) {	
		/*
		 * Component
		 * |__ JFrame, JDialog
		 */
		
				try {
					MyFrame frame = new MyFrame(parentComponent, app);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			
		
	}

	/**
	 * Create the frame.
	 */
	
	
	public MyFrame(Component parentComponent,  Notifiable app) { // 아규먼트를 갖는 생성자.
		this.parentComponent = parentComponent;
		this.app = app;
		initialize();
	}
	
	
	
	public void initialize() {
		
		int x = 0;
		int y = 0;
		
		if(parentComponent != null) {
			x = parentComponent.getX(); // 부모 컴포넌트의 x좌표
			y = parentComponent.getY(); // 부모 컴포넌트의 y좌표
		}
		setBounds(x, y, 450, 300);
		
		if(parentComponent == null) { // 부모 컴포넌트 정보가 없을 때
			setLocationRelativeTo(null); // 화면 중앙에 위치시킴.
		} 
		
		
		contentPanel = new JPanel();
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		// setLocationRelativeTo(parentComponent);
		
		// JFrame의 닫기 버튼의 기본 동작을 설정:
		// EXIT_ON_CLOSE: 프로그램 종료(메인 쓰레드 종료)
		// DISPOSE_ON_CLOSE: 현재 JFrame만 닫음(메인 쓰레드는 계속 진행)
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

		setContentPane(contentPanel);
		
		JLabel lblNewLabel = new JLabel("Hello Java!");
		contentPanel.add(lblNewLabel);
	}

}

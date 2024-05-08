package project.view;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import project.model.CourseRegistrationMember;
import project.view.CourseRegistrationMain_fix;

@SuppressWarnings("all")

public class MyCourse_Teacher extends JPanel implements ActionListener {

	private static final long serialVersionUID = 1L;
	
	private String id;
	private JLabel idLabel, introduceLabel;
	private JButton logoutBtn;
	private MyCourse_Me mcm;
	private JTabbedPane jtab;

	/**
	 * Create the panel.
	 */
	public MyCourse_Teacher(String id, MyCourse_Me mcm) {
		this.id = id;
		this.mcm = mcm;
		
		idLabel = new JLabel(id + "님 환영합니다.");
		idLabel.setFont(new Font("굴림", Font.PLAIN, 15));
		 
		//버튼
		logoutBtn = new JButton("로그아웃");
		logoutBtn.setFont(new Font("굴림", Font.PLAIN, 12));
		
		
		// 위치
		idLabel.setBounds(475, 34, 176, 20);
		logoutBtn.setBounds(578, 463, 130, 27);
		
		// 추가
		add(idLabel);
		add(logoutBtn);
		
		// 버튼 이벤트
		logoutBtn.addActionListener(this);
		setLayout(null);
		
		introduceLabel = new JLabel("강사 소개");
		introduceLabel.setFont(new Font("굴림", Font.BOLD, 14));
		idLabel.setFont(new Font("굴림", Font.PLAIN,15));
		introduceLabel.setBounds(120, 74, 72, 40);
		add(introduceLabel);
		
		jtab = new JTabbedPane(); // JTabbedPane 객체 생성
		jtab.addTab("한국사", new Jpanel1011());
		jtab.addTab("음악사", new Jpanel1012());
		jtab.addTab("미술사", new Jpanel1013());
		jtab.addTab("체육학", new Jpanel1014());
		jtab.addTab("사회학", new Jpanel1015());
		jtab.addTab("영문학", new Jpanel1016());

		// jtab.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		jtab.setBounds(114, 124, 535, 250);
		add(jtab);
		
	}
	
	class Jpanel1011 extends JPanel {

		public Jpanel1011() {
			setLayout(null);

			introduceLabel = new JLabel("강석화");
			introduceLabel.setFont(new Font("굴림", Font.PLAIN, 15));
			introduceLabel.setBounds(10, 30, 60, 45);
			add(introduceLabel);
			
			introduceLabel = new JLabel("한국사 교수님");
			introduceLabel.setFont(new Font("굴림", Font.PLAIN, 12));
			introduceLabel.setBounds(10, 60, 100, 45);
			add(introduceLabel);

		}

	}

	class Jpanel1012 extends JPanel {

		public Jpanel1012() {
			setLayout(null);

			introduceLabel = new JLabel("이정빈");
			introduceLabel.setFont(new Font("굴림", Font.PLAIN, 15));
			introduceLabel.setBounds(10, 30, 60, 45);
			add(introduceLabel);
			
			introduceLabel = new JLabel("음악사 교수님");
			introduceLabel.setFont(new Font("굴림", Font.PLAIN, 12));
			introduceLabel.setBounds(10, 60, 100, 45);
			add(introduceLabel);

		}

	}

	class Jpanel1013 extends JPanel {

		public Jpanel1013() {
			setLayout(null);

			introduceLabel = new JLabel("김재운");
			introduceLabel.setFont(new Font("굴림", Font.PLAIN, 15));
			introduceLabel.setBounds(10, 30, 60, 45);
			add(introduceLabel);
			
			
			introduceLabel = new JLabel("미술사 교수님");
			introduceLabel.setFont(new Font("굴림", Font.PLAIN, 12));
			introduceLabel.setBounds(10, 60, 100, 45);
			add(introduceLabel);

		}

	}

	class Jpanel1014 extends JPanel {

		public Jpanel1014() {
			setLayout(null);

			introduceLabel = new JLabel("강미선");
			introduceLabel.setFont(new Font("굴림", Font.PLAIN, 15));
			introduceLabel.setBounds(10, 30, 60, 45);
			add(introduceLabel);
			
			
			introduceLabel = new JLabel("체육학 교수님");
			introduceLabel.setFont(new Font("굴림", Font.PLAIN, 12));
			introduceLabel.setBounds(10, 60, 100, 45);
			add(introduceLabel);

		}

	}

	class Jpanel1015 extends JPanel {

		public Jpanel1015() {
			setLayout(null);

			introduceLabel = new JLabel("송현순");
			introduceLabel.setFont(new Font("굴림", Font.PLAIN, 15));
			introduceLabel.setBounds(10, 30, 60, 45);
			add(introduceLabel);
			
			
			introduceLabel = new JLabel("사회학 교수님");
			introduceLabel.setFont(new Font("굴림", Font.PLAIN, 12));
			introduceLabel.setBounds(10, 60, 100, 45);
			add(introduceLabel);

		}

	}

	class Jpanel1016 extends JPanel {

		public Jpanel1016() {
			setLayout(null);

			introduceLabel = new JLabel("김수진");
			introduceLabel.setFont(new Font("굴림", Font.PLAIN, 15));
			introduceLabel.setBounds(10, 30, 60, 45);
			add(introduceLabel);
			
			introduceLabel = new JLabel("영문학 교수님");
			introduceLabel.setFont(new Font("굴림", Font.PLAIN, 12));
			introduceLabel.setBounds(10, 60, 100, 45);
			add(introduceLabel);

		}

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == logoutBtn) {
			mcm.setVisible(false);
			

		}

	}

}

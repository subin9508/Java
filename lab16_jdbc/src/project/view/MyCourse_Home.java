package project.view;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Vector;

import javax.security.auth.login.LoginContext;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import project.controller.CourseRegistrationCourseDao;
import project.model.CourseRegistrationCourse;
import project.view.*;

public class MyCourse_Home extends JPanel implements ActionListener {

	private static final long serialVersionUID = 1L;
	private String id;
	private JLabel idLabel, mainLabel;
	private JButton logoutBtn;
	private MyCourse_Me mcm;

	private JLabel mainLecture;
	private String name;
	private List<CourseRegistrationCourse> list;
	private Vector<String> vector;
	
	
	public MyCourse_Home(String id, MyCourse_Me mcm) throws Exception {
		this.id = id;
		this.mcm = mcm;
		
		
		mainLecture = new JLabel();
		mainLecture.setFont(new Font("굴림", Font.PLAIN, 20));
		
		CourseRegistrationCourseDao cdao = CourseRegistrationCourseDao.getInstance();
		name = cdao.getHomeLCourseList();
		
		idLabel = new JLabel(id + " 님 환영합니다.");
		idLabel.setFont(new Font("굴림", Font.PLAIN, 20));
		
		idLabel.setBounds(750, 10, 150, 20);
			logoutBtn = new JButton("로그아웃");
			logoutBtn.setBounds(900, 10, 67, 25);
			
			mainLecture.setBounds(650, 80, 400, 20);
			mainLecture.setText("새 강의" + name);
			
			add(idLabel);
			add(logoutBtn);
			add(mainLecture);
			
			logoutBtn.addActionListener(this);
			setLayout(null);
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == logoutBtn) {
			mcm.setVisible(false);
			
		}
		
	}

}

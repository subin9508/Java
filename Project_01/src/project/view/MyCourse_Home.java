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
import javax.swing.JTable;
import javax.swing.JScrollPane;

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
	private JTable table;
	private JScrollPane scrollPane;
	
	
	public MyCourse_Home(String id, MyCourse_Me mcm) throws Exception {
		this.id = id;
		this.mcm = mcm;
		
		
		mainLecture = new JLabel();
		mainLecture.setFont(new Font("굴림", Font.PLAIN, 20));
		
		CourseRegistrationCourseDao cdao = CourseRegistrationCourseDao.getInstance();
		name = cdao.getHomeLCourseList();
		
		idLabel = new JLabel(id + " 님 환영합니다.");
		idLabel.setFont(new Font("굴림", Font.PLAIN, 15));
		
		idLabel.setBounds(628, 15, 236, 43);
			logoutBtn = new JButton("로그아웃");
			logoutBtn.setBounds(793, 478, 130, 27);
			
			mainLecture.setBounds(29, 83, 254, 20);
			mainLecture.setText(" ** 새로 개강된 강의 ** ");
			
			add(idLabel);
			add(logoutBtn);
			add(mainLecture);
			
			logoutBtn.addActionListener(this);
			setLayout(null);
			
			table = new JTable();
			table.setBounds(29, 113, 236, 391);
			
			add(table);
			
			scrollPane = new JScrollPane();
			scrollPane.setBounds(29, 114, 236, 391);
			add(scrollPane);
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == logoutBtn) {
			mcm.setVisible(false);
			
		}
		
	}
}

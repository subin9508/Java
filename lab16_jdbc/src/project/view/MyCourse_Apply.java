package project.view;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.ScrollPaneConstants;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import project.controller.CourseRegistrationCourseDao;
import project.controller.CourseRegistrationMemberDao;
import project.controller.MyCourse_MappingDao;
import project.model.CourseRegistrationCourse;
import project.model.CourseRegistrationMember;
import project.model.MyCourse_Mapping;

public class MyCourse_Apply extends JPanel implements ActionListener {

	private static final long serialVersionUID = 1L;
	
	private String id, myName, teacher;
	private JLabel idLabel, courseNumberLabel, courseTitleLabel, teacherLabel, listLabel;
	private JLabel courseNumberT, courseTitleT, teacherT;
	private JButton logoutBtn, applyBtn;
	private MyCourse_Me mcm;
	private JList<CourseRegistrationCourse> list;
	private DefaultListModel<CourseRegistrationCourse> model;
	
	
	public MyCourse_Apply(String id, MyCourse_Me mcm) {
		this.id = id;
		this.mcm = mcm;
		
		// 내 이름 정보
		// CourseRegistrationMember
		CourseRegistrationMember crm = new CourseRegistrationMember();
		crm.setId(id);
		
		// DB
		CourseRegistrationMemberDao mdao = CourseRegistrationMemberDao.getInstance();
		
		crm = mdao.myInformation(crm);
		myName = crm.getName();
		
		// Jlist 생성
		model = new DefaultListModel<CourseRegistrationCourse>();
		list = new JList<CourseRegistrationCourse>(model);
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		list.setFont(new Font("굴림", Font.PLAIN, 15));
		
		JScrollPane list0 = new JScrollPane(list);
		list0.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		
		// DB
		CourseRegistrationCourseDao cdao = CourseRegistrationCourseDao.getInstance();
		
		//  모든 레코드를 꺼내서 JList에 넣기
		List<CourseRegistrationCourse> crcList = cdao.getCourseList();
		
		for(CourseRegistrationCourse crc : crcList) {
			model.addElement(crc);
		}
		
		idLabel = new JLabel(id + " 님 환영합니다.");
		idLabel.setFont(new Font("굴림", Font.PLAIN, 15));
		
		listLabel = new JLabel("전체 강의 목록");
		listLabel.setFont(new Font("굴림", Font.PLAIN, 20));
		
		courseNumberLabel = new JLabel("강의 번호 : ");
		courseNumberLabel.setFont(new Font("굴림", Font.PLAIN, 20));
		courseNumberT = new JLabel();
		courseNumberT.setFont(new Font("굴림", Font.PLAIN, 20));
		
		courseTitleLabel = new JLabel("강의명 : ");
		courseTitleLabel.setFont(new Font("굴림", Font.PLAIN, 20));
		courseTitleT = new JLabel();
		courseTitleT.setFont(new Font("굴림", Font.PLAIN, 20));
		
		teacherLabel = new JLabel("강사명 : ");
		teacherLabel.setFont(new Font("굴림", Font.PLAIN, 20));
		teacherT = new JLabel();
		teacherT.setFont(new Font("굴림", Font.PLAIN, 20));
		
		// 버튼
		logoutBtn = new JButton("로그아웃");
		logoutBtn.setFont(new Font("굴림", Font.PLAIN, 15));
		
		applyBtn = new JButton("수강신청");
		applyBtn.setFont(new Font("굴림", Font.PLAIN, 15));
		
		// 위치
		idLabel.setBounds(750, 10, 150, 20);
		logoutBtn.setBounds(900, 10, 67, 25);
		
		list0.setBounds(90, 110, 340, 460);
		listLabel.setBounds(90, 60, 180, 40);
		
		courseNumberLabel.setBounds(470, 200, 140, 40);
		courseNumberT.setBounds(605, 200, 200, 40);
		
		courseTitleLabel.setBounds(470, 250, 140, 40);
		courseTitleT.setBounds(605, 250, 300, 40);
		
		teacherLabel.setBounds(470, 400, 140, 40);
		teacherT.setBounds(605, 400, 200, 40);
		
		applyBtn.setBounds(720, 540, 205, 76);
		
		// 추가
		add(idLabel);
		add(logoutBtn);
		add(list0);
		add(listLabel);
		add(courseNumberLabel);
		add(courseNumberT);
		add(courseTitleLabel);
		add(courseTitleT);
		add(teacherLabel);
		add(teacherT);
		add(applyBtn);
		
		
		// 버튼 이벤트
		logoutBtn.addActionListener(this);
		applyBtn.addActionListener(this);
		
		
		
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == logoutBtn) {
			mcm.setVisible(false);
		} else if(e.getSource() == applyBtn) {
			if(courseNumberT.getText() == null || courseNumberT.getText().equals("")) {
				JOptionPane.showMessageDialog(this, "신청하실 강의를 선택해주세요.");
				
			} else {
				int apply = JOptionPane.showConfirmDialog(this, "수강 신청 하시겠습니까?", "수강 신청", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
				
				if (apply == JOptionPane.YES_OPTION) {
					applyCourse();
				}
			}
		}
		
	}
	
	
	// 수강신청 메소드
	private void applyCourse() {
		String id = this.id;
		String name = myName;
		int courseNumber2 = Integer.parseInt(courseNumberT.getText());
		String courseTitle = courseTitleT.getText();
		String teacher = this.teacher;
		
		// mapping 모델
		MyCourse_Mapping mcmap = new MyCourse_Mapping();
		mcmap.setId(id);
		mcmap.setName(name);
		mcmap.setCourseTitle(courseTitle);
		mcmap.setCourseNumber(courseNumber2);
		mcmap.setTeacher(teacher);
		
		MyCourse_MappingDao mcmapDao = MyCourse_MappingDao.getInstance();
		
		int ap = mcmapDao.applyConfirmCourse(mcmap);
		
		if (ap == 0) {
			// 신청하기
			mcmapDao.applyCourse(mcmap);
			JOptionPane.showConfirmDialog(this, "신청 완료 되었습니다.");
			
		} else if (ap == 1) {
			JOptionPane.showMessageDialog(this, "이미 신청하신 강의입니다.");
		}
		
		
	}

}

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
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.ScrollPaneConstants;
import javax.swing.event.AncestorEvent;
import javax.swing.event.AncestorListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import project.controller.CourseRegistrationCourseDao;
import project.controller.CourseRegistrationMemberDao;
import project.controller.MyCourse_MappingDao;
import project.model.CourseRegistrationCourse;
import project.model.CourseRegistrationMember;
import project.model.MyCourse_Mapping;

public class MyCourse_Apply extends JPanel implements ActionListener, AncestorListener {

	private static final long serialVersionUID = 1L;
	
	private String id, myName, teacher;
	private JLabel idLabel, courseNumberLabel, courseTitleLabel, teacherLabel, classroomLabel, listLabel;
	private JButton logoutBtn, applyBtn;
	private MyCourse_Me mcm;
	private JList<CourseRegistrationCourse> list;
	private DefaultListModel<CourseRegistrationCourse> model;
	private JTextField courseNumberT;
	private JTextField courseTitleT;
	private JTextField teacherT;
	private JTextField classroomT;
	
	
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
		
		for(CourseRegistrationCourse crcL : crcList) {
			model.addElement(crcL);
		}
		
		idLabel = new JLabel(id + " 님 환영합니다.");
		idLabel.setFont(new Font("굴림", Font.PLAIN, 15));
		
		listLabel = new JLabel("전체 강의 목록");
		listLabel.setFont(new Font("굴림", Font.BOLD, 20));
		
		courseNumberLabel = new JLabel("강의 번호 : ");
		courseNumberLabel.setFont(new Font("굴림", Font.PLAIN, 20));
		
		courseTitleLabel = new JLabel("강의명 : ");
		courseTitleLabel.setFont(new Font("굴림", Font.PLAIN, 20));
		
		teacherLabel = new JLabel("강사명 : ");
		teacherLabel.setFont(new Font("굴림", Font.PLAIN, 20));
		
		classroomLabel = new JLabel("강의실 : ");
		classroomLabel.setFont(new Font("굴림", Font.PLAIN, 20));
		
		
		applyBtn = new JButton("수강신청");
		applyBtn.setFont(new Font("굴림", Font.PLAIN, 15));
		
		// 위치
		idLabel.setBounds(96, 25, 174, 44);
		
		list0.setBounds(96, 106, 737, 222);
		listLabel.setBounds(376, 58, 145, 24);
		
		courseNumberLabel.setBounds(96, 354, 102, 24);
		
		courseTitleLabel.setBounds(96, 394, 77, 24);
		
		teacherLabel.setBounds(96, 437, 77, 24);
		
		classroomLabel.setBounds(96, 478, 77, 24);
		
		applyBtn.setBounds(703, 355, 130, 27);
		
		
		// 추가
		add(idLabel);
		
		// 버튼
		logoutBtn = new JButton("로그아웃");
		logoutBtn.setFont(new Font("굴림", Font.PLAIN, 15));
		logoutBtn.setBounds(703, 479, 130, 27);
		add(logoutBtn);
		add(list0);
		add(listLabel);
		add(courseNumberLabel);
		add(courseTitleLabel);
		add(teacherLabel);
		add(classroomLabel);
		add(applyBtn);
		
		
		// 버튼 이벤트
		logoutBtn.addActionListener(this);
		applyBtn.addActionListener(this);
	
		
		list.addAncestorListener(this);
		
		setLayout(null);
		
		courseNumberT = new JTextField();
		courseNumberT.setBounds(199, 355, 136, 27);
		add(courseNumberT);
		courseNumberT.setColumns(10);
		
		courseTitleT = new JTextField();
		courseTitleT.setColumns(10);
		courseTitleT.setBounds(174, 395, 136, 27);
		add(courseTitleT);
		
		teacherT = new JTextField();
		teacherT.setColumns(10);
		teacherT.setBounds(174, 438, 136, 27);
		add(teacherT);
		
		classroomT = new JTextField();
		classroomT.setColumns(10);
		classroomT.setBounds(174, 479, 136, 27);
		add(classroomT);
		
		
	}
		
		// valueChanged
		
		public void valueChanged(ListSelectionEvent ev) {
			CourseRegistrationCourse crc = list.getSelectedValue();
			
			if(list.getSelectedIndex() == -1) return;
			
			int number = crc.getCourseNumber();
			courseNumberT.setText(Integer.toString(number));
			// System.out.println(courseNumberT);
			courseTitleT.setText(crc.getCourseTitle());
			
			teacherT.setText(crc.getTeacher());
			classroomT.setText(crc.getClassroom());
		}
	


	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == logoutBtn) {
			mcm.setVisible(false);
		} else if(e.getSource() == applyBtn) {
			String courseNumberText = courseNumberT.getText().trim(); // 앞뒤 공백 제거
			if(courseNumberText.isEmpty()) {
				JOptionPane.showMessageDialog(this, "신청하실 강의를 선택해주세요.");
				System.out.println("값이 없음");
			} else {
				try {
					int courseNumber = Integer.parseInt(courseNumberText); // 숫자로 변환 시도
					int apply = JOptionPane.showConfirmDialog(this, "수강 신청 하시겠습니까?", "수강 신청", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
					if (apply == JOptionPane.YES_OPTION) {
						applyCourse();
						System.out.println("신청 성공");
						}
				
				} catch (NumberFormatException ex) {
	                JOptionPane.showMessageDialog(this, "강의 번호는 숫자로 입력해주세요.");
	                System.out.println("숫자가 아님");
	            }
	        }
	    }
	}
	
	
	// 수강신청 메소드
	private void applyCourse() {
		String id = this.id;
		String name = myName;
		String courseTitle = courseTitleT.getText();
		String teacher = teacherT.getText();
		String classroom = this.classroomT.getText();
		int courseNumber = Integer.parseInt(courseNumberT.getText());
		
		// mapping 모델
		MyCourse_Mapping mcmap = new MyCourse_Mapping();
		mcmap.setId(id);
		mcmap.setName(name);
		mcmap.setCourseTitle(courseTitle);
		mcmap.setTeacher(teacher);
		mcmap.setClassroom(classroom);
		mcmap.setCourseNumber(courseNumber);
		
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


	@Override
	public void ancestorAdded(AncestorEvent event) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void ancestorRemoved(AncestorEvent event) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void ancestorMoved(AncestorEvent event) {
		// TODO Auto-generated method stub
		
	}
}

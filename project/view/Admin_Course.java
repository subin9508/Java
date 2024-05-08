package project.view;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import project.controller.CourseRegistrationCourseDao;
import project.controller.MyCourse_MappingDao;
import project.model.CourseRegistrationCourse;
import project.model.MyCourse_Mapping;
import project.controller.*;
@SuppressWarnings("all")
public class Admin_Course extends JPanel implements ActionListener {
	private JLabel listL, lecInfoL, to1L, to2L;
	private JLabel deleteT, lecNameT, toT;
	private String id;
	private JLabel idLabel;
	private JButton logoutBtn, lecApplyBtn, lecDeleteBtn, refreshBtn;

	private static final long serialVersionUID = 1L;
	
	
	private List<CourseRegistrationCourse> listModelCourse;
	private Vector<String> vectorModelCourse;
	
	private List<MyCourse_Mapping> listModelMapping;
	private Vector<String> vectorModelMapping;
	private DefaultTableModel modelCourse, modelMapping;
	private JTable allList, mcmList;
	private Admin_Admin admin;
	

	public Admin_Course(String id, Admin_Admin admin) {
		this.id = id;
		this.admin = admin;
		setLayout(null);
		
		listModelCourse = new ArrayList<CourseRegistrationCourse>();
		
		vectorModelCourse = new Vector<String>();
		vectorModelCourse.add("강의 번호");
		vectorModelCourse.add("강의명");
		vectorModelCourse.add("강사명");
		vectorModelCourse.add("강의실");
		
		modelCourse = new DefaultTableModel(vectorModelCourse, 0) {
			public boolean isCellEditable(int r, int c) {
				return false;
			}
		};
		
		CourseRegistrationCourseDao crcDao = CourseRegistrationCourseDao.getInstance();
		listModelCourse = crcDao.getCourseList();
		
		for (CourseRegistrationCourse crc : listModelCourse) {
			Vector<String> v = new Vector<String>();
			v.add(Integer.toString(crc.getCourseNumber()));
			v.add(crc.getCourseTitle());
			v.add(crc.getTeacher());
			v.add(crc.getClassroom());
			
			modelCourse.addRow(v);
		}
		
		listModelMapping = new ArrayList<MyCourse_Mapping>();
		
		vectorModelMapping = new Vector<String>();
		vectorModelMapping.addElement("ID");
		vectorModelMapping.addElement("이름");
		
		modelMapping = new DefaultTableModel(vectorModelMapping, 0) {
			public boolean isCellEditabletable(int r, int c) {
				return false;
			}
		};
		
		
		// 테이블 생성
		allList = new JTable(modelCourse);
		allList.setRowHeight(20);
		allList.setFont(new Font("굴림", Font.PLAIN, 12));
		
		allList.getColumnModel().getColumn(0).setPreferredWidth(50);  
	    allList.getColumnModel().getColumn(1).setPreferredWidth(140);
	    allList.getColumnModel().getColumn(2).setPreferredWidth(100);
	    allList.getColumnModel().getColumn(3).setPreferredWidth(60);
	    
	    JScrollPane listModelCourse = new JScrollPane(allList);
	    
	    mcmList = new JTable(modelMapping);
	    JScrollPane listModelMapping = new JScrollPane(mcmList);
	    mcmList.setRowHeight(20);
	    mcmList.setFont(new Font("굴림", Font.PLAIN, 12));
	    
	    idLabel = new JLabel(id + " 관리자님");
	    idLabel.setFont(new Font("굴림", Font.PLAIN, 12));
	    
	    listL = new JLabel("전체 강의 목록");
	    listL.setFont(new Font("굴림", Font.BOLD, 16));
	    
	    lecNameT = new JLabel();
	    lecNameT.setFont(new Font("굴림", Font.PLAIN, 12));
	    
	    lecInfoL = new JLabel("강의 신청 회원 목록");
		lecInfoL.setFont(new Font("굴림", Font.PLAIN, 16));
	    
	    
	    // 버튼
	    logoutBtn = new JButton("로그아웃");
	    logoutBtn.setFont(new Font("굴림", Font.PLAIN, 12));
	    
	    
	    lecApplyBtn = new JButton("강의 등록");
	    lecApplyBtn.setFont(new Font("굴림", Font.PLAIN, 12));
	    
	    refreshBtn= new JButton("새로 고침");
	    refreshBtn.setFont(new Font("굴림", Font.PLAIN, 12));
	    
	    
	    idLabel.setBounds(733, 12, 150, 20);
	    
	    listL.setBounds(45, 80, 150, 30);
		listModelCourse.setBounds(45, 160, 560, 450);

		lecApplyBtn.setBounds(490, 100, 110, 41);
		refreshBtn.setBounds(490, 620, 110, 41);
		
		lecNameT.setBounds(650, 100, 150, 30);
		lecInfoL.setBounds(805, 105, 150, 30);
		listModelMapping.setBounds(650, 160, 230, 450);
		
		logoutBtn.setBounds(869, 10, 103, 25);
		
		add(idLabel);
		add(logoutBtn);
		add(listL);
		add(lecInfoL);
		add(lecNameT);
		add(lecApplyBtn);
		add(listModelCourse);
		add(listModelMapping);
		add(refreshBtn);
		
		logoutBtn.addActionListener(this);
		lecApplyBtn.addActionListener(this);
		refreshBtn.addActionListener(this);
		
		allList.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int allListRow = allList.getSelectedRow();
				String selectedName = (String) allList.getValueAt(allListRow, 1);
				lecNameT.setText(selectedName);
				String selectedCourseNumber = (String) allList.getValueAt(allListRow, 0);
				int castedCourseNumber = Integer.parseInt(selectedCourseNumber);
				MyCourse_MappingDao mcmapDao = MyCourse_MappingDao.getInstance();
				// listModelMapping = mcmapDao.getMyCourseList(castedCourseNumber);
				
				
				/*
				modelMapping.setRowCount(0);
				for (MyCourse_Mapping mcMap : listModelMapping) {
					Vector<String> v = new Vector<String>();
					v.add(mcMap.getId());
					v.add(mcMap.getName());
					modelMapping.addRow(v);
				}
				*/
			}
		});
	
	}
	
	

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == logoutBtn) { // 로그아웃 버튼
			admin.setVisible(false);
			
		} else if (e.getSource() == lecApplyBtn) {
			lecApply();
		} else if (e.getSource() == refreshBtn) { // 평가 보내기 버튼
			 refresh();	
		  }
		
	}
	
	private void refresh() {
		modelCourse.setRowCount(0);
		
		CourseRegistrationCourseDao crcDao = CourseRegistrationCourseDao.getInstance();
		listModelCourse = crcDao.getCourseList();
		
		for(CourseRegistrationCourse crc : listModelCourse) {
			Vector<String> v = new Vector<String>();
			v.add(Integer.toString(crc.getCourseNumber()));
			v.add(crc.getCourseTitle());
			v.add(crc.getTeacher());
			v.add(crc.getClassroom());
			
			modelCourse.addRow(v);
		}
	} // 새로고침 end
	
	private void lecApply() {
		String courseNumber = JOptionPane.showInputDialog(this, "강의 번호를 입력하세요");
		
		if (courseNumber == null) {
			return;
		}
		
		String courseTitle = JOptionPane.showInputDialog(this, "강의 명을 입력하세요");
		if (courseTitle == null) {
			return;
		}
		if (courseTitle.length() == 0) {
			JOptionPane.showMessageDialog(this, "강의명은 필수항목입니다");
			return;
		}
		String teacher = JOptionPane.showInputDialog(this, "담당 강사를 입력하세요");
		if (teacher == null) {
			return;
		}
		String classroom = JOptionPane.showInputDialog(this, "강의실 호수를 입력하세요.");
		if (classroom == null) {
			return;
		}
		
		CourseRegistrationCourseDao crcDao = CourseRegistrationCourseDao.getInstance();
		CourseRegistrationCourse crc = new CourseRegistrationCourse();
		
		crc.setCourseNumber(Integer.parseInt(courseNumber));
		crc.setCourseTitle(courseTitle);
		crc.setTeacher(teacher);
		crc.setClassroom(classroom);
		
		crcDao.insertCourse(crc);
		
		Vector<String> v = new Vector<String>();
		v.add(Integer.toString(crc.getCourseNumber()));
		v.add(courseTitle);
		v.add(teacher);
		v.add(classroom);
		modelCourse.addRow(v);
		
		JOptionPane.showMessageDialog(this, "강의를 추가했습니다.");

	} // 강의 등록 end
}

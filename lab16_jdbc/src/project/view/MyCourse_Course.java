package project.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import project.controller.CourseRegistrationCourseDao;
import project.controller.MyCourse_MappingDao;
import project.model.CourseRegistrationCourse;

public class MyCourse_Course extends JPanel implements ActionListener {

	private static final long serialVersionUID = 1L;
	
	private String id;
	private JLabel idLabel, titleLabel;
	private JTextField selectNumber;
	private JButton logoutBtn;
	private MyCourse_Me mcm;
	
	private List<CourseRegistrationCourse> listMcc;
	private List<Integer> listC;
	private Vector<String> vectorC;
	
	private DefaultTableModel modelC;
	private JTable mycourseList;

	private JButton refreshBtn;
	


	public MyCourse_Course(String id, MyCourse_Me mcm) {
		this.id = id;
		this.mcm = mcm;
		setLayout(null);
		
		// 나의 강의 목록 테이블
		// 데이터
		
		listC = new ArrayList<Integer>();
		listMcc = new ArrayList<CourseRegistrationCourse>();
		
		//타이틀
		vectorC = new Vector<String>();
		vectorC.addElement("강의명");
		vectorC.add("강의 번호");
		vectorC.addElement("강사명");
		vectorC.addElement("강의실");
		
		// 모델 생성
		modelC = new DefaultTableModel(vectorC, 0) {
			
		};
		
		MyCourse_MappingDao mcmapDao = MyCourse_MappingDao.getInstance();
		listC = mcmapDao.getMyCourseList(id);
		
		CourseRegistrationCourseDao crcDao = CourseRegistrationCourseDao.getInstance();
		listMcc = crcDao.getMyCourseList(listC);
		
		// 테이블 속에 데이터 붙이기
		for (CourseRegistrationCourse crc : listMcc) {
			Vector<String> v = new Vector<String>();
			v.add(crc.getCourseTitle());
			v.add(Integer.toString(crc.getCourseNumber()));
			v.add(crc.getTeacher());
			v.add(crc.getClassroom());
			
			
			modelC.addRow(v);
		} // for문 end
		
		
		mycourseList = new JTable(modelC);
		JScrollPane mycourse = new JScrollPane(mycourseList);
		mycourseList.setFont(new Font("굴림", Font.PLAIN, 17));
		mycourseList.setBackground(Color.white);
		mycourseList.getColumnModel().getColumn(0).setPreferredWidth(20);  
		mycourseList.getColumnModel().getColumn(1).setPreferredWidth(140);
		mycourseList.getColumnModel().getColumn(2).setPreferredWidth(120);
		mycourseList.getColumnModel().getColumn(3).setPreferredWidth(20);
		// mycourseList.getColumnModel().getColumn(4).setPreferredWidth(50);
		// mycourseList.getColumnModel().getColumn(5).setPreferredWidth(230);
		mycourseList.setRowHeight(30);
		
		titleLabel = new JLabel("나의 강의 목록");
		titleLabel.setFont(new Font("굴림", Font.PLAIN, 23));
		
		selectNumber = new JTextField("");
		
		idLabel = new JLabel(id + " 님 환영합니다.");
		idLabel.setFont(new Font("굴림", Font.PLAIN, 15));
		
		// 버튼
		logoutBtn = new JButton("로그아웃");
		logoutBtn.setFont(new Font("굴림", Font.PLAIN, 10));
		
		refreshBtn = new JButton("새로고침");
		refreshBtn.setContentAreaFilled(false);
		refreshBtn.setFont(new Font("굴림", Font.PLAIN, 10));
		
		titleLabel.setBounds(75, 65, 180, 50);
		idLabel.setBounds(750, 10, 150, 20);
		logoutBtn.setBounds(900, 10, 67, 25);
		
		mycourse.setBounds(75, 120, 780, 350);
		
		selectNumber.setBounds(75, 540, 780, 100);
		
		
		add(idLabel);
		add(logoutBtn);
		add(mycourse);
		add(titleLabel);
		add(selectNumber);
		add(refreshBtn);
		
		
		logoutBtn.addActionListener(this);
		refreshBtn.addActionListener(this);
		
		
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == logoutBtn) {
			mcm.setVisible(false);
		} else if (e.getSource() == refreshBtn) {
			refresh();
		}
		
	}
	
	private void refresh() {
		modelC.setRowCount(0);
		MyCourse_MappingDao mcmDao = MyCourse_MappingDao.getInstance();
		listC = mcmDao.getMyCourseList(id);
		
		CourseRegistrationCourseDao crcDao = CourseRegistrationCourseDao.getInstance();
		listMcc = crcDao.getMyCourseList(listC);
		
		for (CourseRegistrationCourse crc : listMcc) {
			Vector<String> v = new Vector<String>();
			v.add(crc.getCourseTitle());
			v.add(Integer.toString(crc.getCourseNumber()));
			v.add(crc.getTeacher());
			v.add(crc.getClassroom());
			
			modelC.addRow(v);
			
		}
	} // 새로고침 end

}

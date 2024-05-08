package project.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.border.EmptyBorder;

import project.model.*;
import project.view.*;
import project.controller.*;

@SuppressWarnings("all")
public class MyCourse_Me extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private CourseRegistrationMember crm;
	private String id;
	

	public MyCourse_Me(String id) throws Exception {
		this.id = id;
		
		JTabbedPane tab = new JTabbedPane();
		MyCourse_Home myCourse_Home = new MyCourse_Home(id, this);
		tab.add(" 홈 ", myCourse_Home);
		tab.add(" 나의 강의  ", new MyCourse_Course(id, this));
		tab.add(" 강사 소개  ", new MyCourse_Teacher(id, this));
		tab.add(" 수강 신청  ", new MyCourse_Apply(id, this));
		add(tab, BorderLayout.CENTER);
		
		// 확인
				setTitle("수강신청 프로그램");
				setBounds(300, 100, 1000, 800);

				setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
				this.addWindowListener(new WindowAdapter() {
					@Override
					public void windowClosing(WindowEvent e) {
						int exit = JOptionPane.showConfirmDialog(MyCourse_Me.this, "정말 종료 하시겠습니까?", "수강신청 프로그램 종료",
								JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
						if (exit == JOptionPane.YES_OPTION) {
							System.exit(0);
						}
					}
				});
				setResizable(false);
				setVisible(true);

			}


	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
		
	

	}
	



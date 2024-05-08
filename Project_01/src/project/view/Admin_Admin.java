package project.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.border.EmptyBorder;
import project.controller.*;
import project.model.*;
import project.view.*;

@SuppressWarnings("all")
public class Admin_Admin extends JFrame {

	private static final long serialVersionUID = 1L;
	private String id;

	public Admin_Admin(String id) {
		this.id = id;
		
		JTabbedPane tab = new JTabbedPane();
		Admin_Course admin_Course = new Admin_Course(id, this);
		tab.add(" 강의 관리 ", new Admin_Course(id, this));
		
		add(tab, BorderLayout.CENTER);

		setTitle("수강신청 프로그램(관리자)");
		setBounds(300, 100, 1000, 800);
		setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				int exit = JOptionPane.showConfirmDialog(Admin_Admin.this, "정말 종료 하시겠습니까?", "수강신청 프로그램 종료",
						JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
				if (exit == JOptionPane.YES_OPTION) {
					System.exit(0);
				}
			}
		});
		setResizable(false);
		setVisible(true);
	}

	
	

}

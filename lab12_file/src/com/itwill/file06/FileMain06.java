package com.itwill.file06;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Random;

import com.itwill.file04.Product;

public class FileMain06 {

	public static void main(String[] args) {
		// TODO Student 1,000,000개를 저장하는 더미 데이터를 만듦.
		// 더미 데이터를 파일에 씀. 파일에 쓰는 데 걸린 시간 측정.
		// 파일에서 데이터를 읽음. 읽는 데 걸린 시간 측정.
		
		
		ArrayList<Student> list = new ArrayList<>();
		
		Random rand = new Random(); // 점수 score를 난수로 생성하기 위해서.
		for(int i = 0; i < 1_000_000; i++) {
			Score score = new Score(rand.nextInt(101),
							rand.nextInt(101),
							rand.nextInt(101));
			Student student = new Student(i, "Name_" + i, score);
			list.add(student);
	
		}
		
		final String fileName = "data/student_list.dat";
		
		try(
				FileOutputStream out = new FileOutputStream(fileName);
				BufferedOutputStream bout = new BufferedOutputStream(out);
				ObjectOutputStream oos = new ObjectOutputStream(bout);
		) {
			
			long start = System.currentTimeMillis();
			oos.writeObject(list);
			
			long end = System.currentTimeMillis();
			System.out.println("파일 쓰기 시간: " + (end - start) + "ms");
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		try(
				FileInputStream in = new FileInputStream(fileName);
				BufferedInputStream bin = new BufferedInputStream(in);
				ObjectInputStream ois = new ObjectInputStream(bin);
			) {
			
			long start = System.currentTimeMillis();
			ArrayList<Student> data = (ArrayList<Student>) ois.readObject();
			long end = System.currentTimeMillis();
		
			System.out.println("파일 읽기 시간: " + (end - start) + "ms");
			System.out.println("size = " + data.size());
			System.out.println(data.getFirst()); // products.get(0)
			System.out.println(data.getLast()); // products.get(products.size() - 1)
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		

	}

}

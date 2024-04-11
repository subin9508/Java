package com.itwill.file05;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import com.itwill.file04.Product;

public class FileMain05 {

	public static void main(String[] args) {
		// 파일에 쓸(write) 더미 데이터
		ArrayList<Product> list = new ArrayList<>();
		for(int i = 0; i < 1_000_000; i++) {
			list.add(new Product(i, "name_" + i, i));
		}
			System.out.println("size = " + list.size());
			
		// ArrayList를 저장하는 파일 이름
			String fileName = "data/product_list.dat";
		// 1. Product 타입 객체 1,000,000개를 저장하는 ArrayList를 파일 쓰기
		try(
				FileOutputStream out = new FileOutputStream(fileName);
				BufferedOutputStream bout = new BufferedOutputStream(out);
				ObjectOutputStream oos = new ObjectOutputStream(bout);
		) {
			oos.writeObject(list);
			System.out.println("파일 작성 성공");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		// FOS, BOS, OOS를 이용. 	
			
			
		// 2. 파일에서 객체를 읽어서 ArrayList<Product>로 변환하기
		try(
				FileInputStream in = new FileInputStream(fileName);
				BufferedInputStream bin = new BufferedInputStream(in);
				ObjectInputStream ois = new ObjectInputStream(bin);
			) {
			list = (ArrayList<Product>) ois.readObject();
			System.out.println(list.get(10));
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		// FIS, BIS, OIS를 이용.	

	}

}

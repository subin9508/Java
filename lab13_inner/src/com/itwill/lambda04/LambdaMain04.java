package com.itwill.lambda04;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LambdaMain04 {

	public static void main(String[] args)  {
		// 사원(Employee)들의 리스트
		List<Employee> employees = Arrays.asList(
				new Employee(101, "김지현", "개발1팀", "과장", 700),
				new Employee(102, "이동준", "개발2팀", "부장", 800),
				new Employee(103, "이승행", "개발1팀", "대리", 500),
				new Employee(104, "정윤정", "개발2팀", "부장", 1000),
				new Employee(105, "김동환", "인사팀", "회장", 30_000),
				new Employee(106, "노형진", "인사팀", "차장", 900),
				new Employee(107, "오쌤", "총무팀", "대리", 300)
		);
		// Ex1. 모든 직원들의 정보를 한 줄에 한 명씩 출력
		employees.forEach(System.out::println);
		
		// Ex2. 개발(1, 2)팀에서 일하는 직원들의 급여 합계
		// Ex3. 개발팀에서 일하는 직원들의 급여 평균
		double sum = 0.0; // 급여 합계를 저장하기 위한 변수
		int count = 0; // 개발팀 직원수를 저장하기 위한 변수
		
		for(Employee e : employees) { // 리스트의 모든 직원들을 순서대로 반복
			if(e.getDept().contains("개발")) { // 직원의 부서 이름이 "개발"을 포함하면
			sum += e.getSalary(); // 개발팀 직원의 급여를 더함.
			count++; // 직원 수 증가
			}
		}	
		System.out.println("합계=" + sum);
		System.out.println("평균=" + (sum / count));
		
		
		// Ex4. 직급이 부장인 직원들의 급여 합계
		// Ex5. 직급이 부장은 직원들의 급여 평균
		
		sum = 0.0;
		double mean = 0.0;
		count = 0;
		for(Employee e : employees) {
			if(e.getJabTitle().equals("부장")) {
				sum += e.getSalary();
				count++;
			}
		}
		System.out.println("합계=" + sum);
		System.out.println("평균=" + (sum / count));
		
		sum = employees.stream().filter((x) -> x.getJabTitle().equals("부장")).mapToDouble((x) -> x.getSalary()).sum();
		System.out.println("합계=" + sum);
		System.out.println("평균=" + (sum / count));
		
		// Ex6. 급여가 1,000 이상인 직원들의 정보를 한 줄에 한 명씩 출력
		employees.stream().filter((e) -> e.getSalary() >= 1_000).forEach(System.out::println);
		
		// Ex7. 개발1팀 직원들의 급여를 10% 인상하고, 인상된 급여의 평균.
		sum = 0.0; // 개발1팀 직원들의 (10% 인상한) 급여 합계
		count = 0;
		for(Employee e : employees) {
			if(e.getDept().equals("개발1팀")) {
				sum += e.getSalary() * 1.1;
				count++;
			}
		}
		System.out.println("평균=" + (sum / count));
		
		// Ex8. 직원들 중 대리는 몇 명?
		count = 0;
		for(Employee e : employees) {
			if(e.getJabTitle().equals("대리")) {
				count++;
			}
		}
		System.out.println("대리 인원 수=" + count);
		
		long empCount = employees.stream()
				 .filter((e) -> e.getJabTitle().equals("대리"))
				 .count();
		
		System.out.println("대리 인원 수=" + empCount);
		
//		ArrayList<Employee> salary = new ArrayList<>();
//		for(Employee e : employees) {
//			if(e.getDept().equals("개발1팀")) {
//				
//				
//			}
//		}
//		System.out.println(salary);

	}

}

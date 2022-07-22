package ch01;

// 가장 중요한 팩토리 클래스를 만들어 보자
public class ComputerFactory {
	
	// 1. static 메서드를 활용합니다.
	// 2. type 값에 따라서 객체를 생성할 수 있게 설계합니다.
	
	public static Computer getComputer(String type, String ram, String hdd, String cpu) {
		
		if("PC".equals(type)) {
			return new PC(ram, hdd, cpu);
		} else if ("NoteBook".equalsIgnoreCase(type)) {
			return new NoteBook(ram, hdd, cpu);
		}
		
		return null;
		
	}
	
}

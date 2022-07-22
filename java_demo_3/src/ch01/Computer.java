package ch01;

/**
 * 
 * 팩토리 패턴에 사용되는 슈퍼 클래스는 인터페이스나, 추상 클래스나, 일반 클래스로 설계해도 상관없습니다.
 * 
 *
 */
public abstract class Computer {
	
	public abstract String getRAM();
	public abstract String getHDD();
	public abstract String getCPU();
	
	@Override
	public String toString() {
		return "Computer [getRAM()=" + getRAM() + ", getHDD()=" + getHDD() + ", getCPU()=" + getCPU() + "]";
	}
	
	
}

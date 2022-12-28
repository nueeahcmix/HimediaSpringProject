package spring;

import java.util.Collection;

public class MemberListPrinter {
	private MemberDao memberDao;
	private MemberPrinter printer;
	
	// 의존 객체를 생성자를 통해서 주입
	public MemberListPrinter(MemberDao memberDao, MemberPrinter printer) {
		this.memberDao = memberDao;
		this.printer = printer;
	}
	
	// 모든 멤버 정보를 출력하는 메서드를 정의
	public void printAll() {
		Collection<Member> members = memberDao.selecctAll();
	
		
		// members.forEach(m -> printer.print(m));
		
		for (Member member : members) {
			printer.print(member);
		}
		
	}

}

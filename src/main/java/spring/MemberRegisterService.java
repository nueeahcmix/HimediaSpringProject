package spring;

import java.time.LocalDateTime;

public class MemberRegisterService {

	// 회원 정보를 다루는 DAO 객체를 필드로 선언
	private MemberDao memberDao;

	// 생성자를 통해서 필드를 초기화
	public MemberRegisterService(MemberDao memberDao) {
		this.memberDao = memberDao;
	}
	
	// 회원 등록을 처리하는 메서드
	// RegisterRequest 타입을 매개변수로 받아서 등록에 성공하면 회원 ID를 반환
	public Long regist(RegisterRequest req) {
		Member member = memberDao.selcetByEmail(req.getEmail());
		//이메일 중복 여부를 확인
		if (member != null) {
			throw new DuplicateMemberException("이메일 중복" + req.getEmail());
		}
		// 회원 등록
		Member newMember = new Member(req.getEmail(), req.getPassword(), req.getName(), LocalDateTime.now());
		memberDao.insert(newMember);
		
		return newMember.getId();
		
	}
}

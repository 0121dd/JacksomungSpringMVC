package kr.co.jacksomung.member.service;

import kr.co.jacksomung.member.domain.Member;

public interface MemberService {
	
	/**
	 * 로그인 Service
	 * @param member
	 * @return member
	 */
	public Member selectCheckLogin(Member member);
	
	/**
	 * 회원 상세 조회 Service
	 * @param memberId
	 * @return member
	 */
	public Member selectOneById(String memberId);
	
	/**
	 * 회원 가입 Service
	 * @param member
	 * @return int
	 */
	public int insertMember(Member member);
	
	/**
	 * 회원 정보 수정 Service
	 * @param mOne
	 * @return int
	 */
	public int updateMember(Member mOne);

}

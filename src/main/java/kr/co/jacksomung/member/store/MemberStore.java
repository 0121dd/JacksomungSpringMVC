package kr.co.jacksomung.member.store;

import org.apache.ibatis.session.SqlSession;

import kr.co.jacksomung.member.domain.Member;

public interface MemberStore {
	
	/**
	 * 로그인 Store
	 * @param session
	 * @param member
	 * @return
	 */
	public Member selectCheckLogin(SqlSession session, Member member);

	/**
	 * 회원 상세 조회 Store
	 * @param session
	 * @param memberId
	 * @return
	 */
	public Member selectOneById(SqlSession session, String memberId);

	/**
	 * 회원가입 Store
	 * @param session
	 * @param member
	 * @return
	 */
	public int insertMember(SqlSession session, Member member);

	/**
	 * 회원 정보 수정 Store
	 * @param session
	 * @param mOne
	 * @return
	 */
	public int updateMember(SqlSession session, Member mOne);


}

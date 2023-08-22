package kr.co.jacksomung.board.store;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import kr.co.jacksomung.board.domain.Notice;
import kr.co.jacksomung.board.domain.PageInfo;
import kr.co.jacksomung.board.domain.QuestionBoard;

public interface NoticeStore {
	
	/**
	 * 공지사항 목록 조회 Store
	 * @return
	 */
	public List<Notice> selectNoticeList(SqlSession session, PageInfo pInfo);

	/**
	 * 상품문의사항 전체 갯수 Store
	 * @param session
	 * @param pInfo
	 * @return
	 */
	public List<Notice> selectQuestionList(SqlSession session, PageInfo pInfo);
	
	/**
	 * 공지사항 전체 갯수 Store
	 * @return
	 */
	public int selectListCount(SqlSession session, String getCount);

	/**
	 * 상품문의사항 상세 조회 Store
	 * @param session
	 * @param boardNo
	 * @return
	 */
	public QuestionBoard selectDetailBoard(SqlSession session, int boardNo);


}

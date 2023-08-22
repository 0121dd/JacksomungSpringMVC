package kr.co.jacksomung.board.service;

import java.util.List;

import kr.co.jacksomung.board.domain.Notice;
import kr.co.jacksomung.board.domain.PageInfo;
import kr.co.jacksomung.board.domain.QuestionBoard;

public interface NoticeService {
	
	/**
	 * 공지사항 목록 조회 Service
	 * @return
	 */
	public List<Notice> selectNoticeList(PageInfo pInfo);
	
	/**
	 * 상품문의사항 전체 갯수 Service
	 * @param pInfo
	 * @return
	 */
	public List<Notice> selectQuestionList(PageInfo pInfo);

	/**
	 * 공지사항 전체 갯수 Service
	 * @return
	 */
	public int getListCount(String getCount);

	/**
	 * 상품문의사항 상세 화면 조회 Service
	 * @param boardNo
	 * @return
	 */
	public QuestionBoard getDetailBoard(int boardNo);
}

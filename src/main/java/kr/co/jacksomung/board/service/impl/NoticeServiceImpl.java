package kr.co.jacksomung.board.service.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.jacksomung.board.domain.Notice;
import kr.co.jacksomung.board.domain.PageInfo;
import kr.co.jacksomung.board.domain.QuestionBoard;
import kr.co.jacksomung.board.service.NoticeService;
import kr.co.jacksomung.board.store.NoticeStore;

@Service
public class NoticeServiceImpl implements NoticeService{
	
	@Autowired
	private NoticeStore nStore;
	
	@Autowired
	private SqlSession session;

	@Override
	public List<Notice> selectNoticeList(PageInfo pInfo) {
		List<Notice> nList = nStore.selectNoticeList(session, pInfo);
		return nList;
	}

	@Override
	public List<Notice> selectQuestionList(PageInfo pInfo) {
		List<Notice> nList = nStore.selectQuestionList(session, pInfo);
		return nList;
	}

	@Override
	public int getListCount(String getCount) {
		int result = nStore.selectListCount(session, getCount);
		return result;
	}

	@Override
	public QuestionBoard getDetailBoard(int boardNo) {
		QuestionBoard qBoard = nStore.selectDetailBoard(session, boardNo);
		return qBoard;
	}


}

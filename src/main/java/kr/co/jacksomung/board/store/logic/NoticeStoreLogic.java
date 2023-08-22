package kr.co.jacksomung.board.store.logic;

import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import kr.co.jacksomung.board.domain.Notice;
import kr.co.jacksomung.board.domain.PageInfo;
import kr.co.jacksomung.board.domain.QuestionBoard;
import kr.co.jacksomung.board.store.NoticeStore;

@Repository
public class NoticeStoreLogic implements NoticeStore{

	@Override
	public List<Notice> selectNoticeList(SqlSession session, PageInfo pInfo) {
		int limit = pInfo.getRecordCountPerPage();
		int offset = (pInfo.getCurrentPage() -1)*limit;
		RowBounds rowBounds = new RowBounds(offset, limit);
		List<Notice> nList = session.selectList("NoticeMapper.selectNoticeList", null, rowBounds);
		return nList;
	}
	
	@Override
	public List<Notice> selectQuestionList(SqlSession session, PageInfo pInfo) {
		int limit = pInfo.getRecordCountPerPage();
		int offset = (pInfo.getCurrentPage() -1)*limit;
		RowBounds rowBounds = new RowBounds(offset, limit);
		List<Notice> nList = session.selectList("NoticeMapper.selectQuestionList", null, rowBounds);
		return nList;
	}

	@Override
	public int selectListCount(SqlSession session, String getCount) {
		int result = session.selectOne("NoticeMapper.selectListCount", getCount);
		return result;
	}

	@Override
	public QuestionBoard selectDetailBoard(SqlSession session, int boardNo) {
		QuestionBoard qBoard = session.selectOne("NoticeMapper.selectDetailBoard", boardNo);
		return qBoard;
	}

}

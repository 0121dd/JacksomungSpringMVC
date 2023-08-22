package kr.co.jacksomung.board.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import kr.co.jacksomung.board.domain.Notice;
import kr.co.jacksomung.board.domain.PageInfo;
import kr.co.jacksomung.board.domain.QuestionBoard;
import kr.co.jacksomung.board.service.NoticeService;

@Controller
public class BoardController {
	
	@Autowired
	private NoticeService service;

	private String getCount;

	@RequestMapping(value="/notice/list.do", method=RequestMethod.GET)
	public String noticeList(
					@RequestParam(value="page", required=false, defaultValue="1") Integer currentPage
					, Model model) {
		getCount = "notice";
		int totalCount = service.getListCount(getCount);
		PageInfo pInfo = this.getPageInfo(currentPage, totalCount);
		List<Notice> nList = service.selectNoticeList(pInfo);

		// List 데이터의 유효성 체크 방법 2가지
		// 1. isEmpty()
		// 2. size()		
		if(nList.size() > 0) {
			model.addAttribute("pInfo", pInfo);
			model.addAttribute("nList", nList);
			return "board/notice";
		}else {
			model.addAttribute("msg", "정보를 찾을 수 없습니다.");
			model.addAttribute("url", "/index.jsp");
			return "member/pop-upNotice";
		}
	}
	@RequestMapping(value="/board/questionList.do", method=RequestMethod.GET)
	public String questionList(
			@RequestParam(value="page", required=false, defaultValue="1") Integer currentPage
			, Model model) {
		getCount = "question";
		int totalCount = service.getListCount(getCount);
		PageInfo pInfo = this.getPageInfo(currentPage, totalCount);
		List<Notice> qList = service.selectQuestionList(pInfo);
		
		// List 데이터의 유효성 체크 방법 2가지
		// 1. isEmpty()
		// 2. size()		
		if(qList.size() > 0) {
			model.addAttribute("pInfo", pInfo);
			model.addAttribute("qList", qList);
			return "board/board";
		}else {
			model.addAttribute("msg", "정보를 찾을 수 없습니다.");
			model.addAttribute("url", "/index.jsp");
			return "member/pop-upNotice";
		}
	}
	
	@RequestMapping(value="/detailBoard.do", method=RequestMethod.GET)
	public String detailBoard(@RequestParam("boardNo") int boardNo
							, Model model) {
		QuestionBoard qBoard = service.getDetailBoard(boardNo);
		if(qBoard != null) {
			model.addAttribute("qBoard",qBoard);
			return "board/csDetail";
		}else {
			model.addAttribute("msg", "정보를 찾을 수 없습니다.");
			model.addAttribute("url", "/index.jsp");
			return "member/pop-upNotice";
		}
	}

	// 페이징 처리
	private PageInfo getPageInfo(int currentPage, int totalCount) {
		PageInfo pi = null;
		int recordCountPerPage = 12;
		int naviCountPerPage = 5;
		int naviTotalCount;
		int startNavi;
		int endNavi;
		
		// Math.ceil((double)totalCount/recordCountPerPage+0.9);
		naviTotalCount = (int)((double)totalCount/recordCountPerPage+0.9);
		startNavi = ((int)((double)currentPage/naviCountPerPage+0.9)-1)*naviCountPerPage +1;
		endNavi = startNavi + naviCountPerPage -1;
		if(endNavi > naviTotalCount) {
			endNavi = naviTotalCount;
		}
		pi = new PageInfo(currentPage, recordCountPerPage, naviCountPerPage, startNavi, endNavi, totalCount, naviTotalCount);
		
		return pi;
	}
}

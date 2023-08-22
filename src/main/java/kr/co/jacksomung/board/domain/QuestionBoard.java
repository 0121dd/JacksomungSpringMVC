package kr.co.jacksomung.board.domain;

import java.sql.Date;

public class QuestionBoard {
	private int boardNo;
	private String boardSubject;
	private String boardContent;
	private String boardWriter;
	private Date boardWriteDate;
	
	public QuestionBoard() {}
	
	
	public QuestionBoard(String boardSubject, String boardContent, String boardWriter) {
		super();
		this.boardSubject = boardSubject;
		this.boardContent = boardContent;
		this.boardWriter = boardWriter;
	}

	public QuestionBoard(int boardNo, String boardSubject, String boardContent, String boardWriter,
			Date boardWriteDate) {
		super();
		this.boardNo = boardNo;
		this.boardSubject = boardSubject;
		this.boardContent = boardContent;
		this.boardWriter = boardWriter;
		this.boardWriteDate = boardWriteDate;
	}

	public int getBoardNo() {
		return boardNo;
	}


	public void setBoardNo(int boardNo) {
		this.boardNo = boardNo;
	}


	public String getBoardSubject() {
		return boardSubject;
	}


	public void setBoardSubject(String boardSubject) {
		this.boardSubject = boardSubject;
	}


	public String getBoardContent() {
		return boardContent;
	}


	public void setBoardContent(String boardContent) {
		this.boardContent = boardContent;
	}


	public String getBoardWriter() {
		return boardWriter;
	}


	public void setBoardWriter(String boardWriter) {
		this.boardWriter = boardWriter;
	}


	public Date getBoardWriteDate() {
		return boardWriteDate;
	}


	public void setBoardWriteDate(Date boardWriteDate) {
		this.boardWriteDate = boardWriteDate;
	}


	@Override
	public String toString() {
		return "질문게시판 [번호=" + boardNo + ", 제목=" + boardSubject + ", 내용="
				+ boardContent + ", 작성자=" + boardWriter + ", 작성일=" + boardWriteDate + "]";
	}
	
}

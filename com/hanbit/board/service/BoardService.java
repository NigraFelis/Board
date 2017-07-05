package com.hanbit.board.service;

import com.hanbit.board.domain.BoardBean;

public interface BoardService {
	public void writeBoard(BoardBean board); //BoardBean
	public BoardBean[] listBoard(); //list arry return
	public int countSeq(); //count return
	public BoardBean findBySeq(int seq); // bean return
	public BoardBean[] findByWriter(String findByWriter); //bean return
	
	public void updateContent(BoardBean board); //noreturn excute
	public void delete(int seq); //noreturn excute

	
}

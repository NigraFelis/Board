package com.hanbit.board.serviceImpl;

import com.hanbit.board.domain.BoardBean;
import com.hanbit.board.service.BoardService;

public class BoardServiceImpl implements BoardService{
	int seq;
	int seqcount;
	
	BoardBean board;
	BoardBean[] boardList;
	
	public BoardServiceImpl(){
		seq=0;
		seqcount=0;
		board = new BoardBean();
		boardList = new BoardBean[seq];
	}
	
	@Override
	public void writeBoard(BoardBean board) {
		if (seq==boardList.length){
			BoardBean[] temp = new BoardBean[seq +1];
			board.setSeq(seqcount);
			System.arraycopy(boardList, 0, temp, 0, seq);
			boardList=temp;
		}
		boardList[seq++] = board;
		board.setSeq(seqcount);
		seqcount++;
	
	}

	@Override
	public int countSeq() {

		return seq;
	}
	
	@Override
	public BoardBean[] listBoard() {
		BoardBean[] result = new BoardBean[seq];
		if(seq==boardList.length){
			result = boardList;	
		}
		else{
			for(int i=0; i<seq;i++){
				result[i] = boardList[i];
			}
		}
		
		return result;
	}

	@Override
	public BoardBean findBySeq(int seq) {
		board=new BoardBean();
		for(int i=0;i<boardList.length;i++){
			if(seq==boardList[i].getSeq()){
				board=boardList[i];
			}
		}
		System.out.println(board.toString());
		return board;
	}

	@Override
	public BoardBean[] findByWriter(String findByWriter) {
		BoardBean findWriter[] = new BoardBean[seq];
		for(int i=0;i<boardList.length;i++){
			if(findByWriter .equals(boardList[i].getWriter())){
				findWriter[i]=boardList[i];
			}
		}
		return findWriter;
	}


	@Override
	public void updateContent(BoardBean board) {
		(findBySeq(board.getSeq())).setContent(board.getContent());;
	}

	@Override
	public void delete(int DeleteSeq) {
		for(int i=0;i<seq;i++){
			if(DeleteSeq==(boardList[i].getSeq())){
				boardList[i] = boardList[seq-1];
				boardList[seq-1]=null;
				seq --;
			}
		}
	}

	
	
	
}

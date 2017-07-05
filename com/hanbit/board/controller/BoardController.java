package com.hanbit.board.controller;

import javax.swing.JOptionPane;

import com.hanbit.board.domain.BoardBean;
import com.hanbit.board.service.BoardService;
import com.hanbit.board.serviceImpl.BoardServiceImpl;

public class BoardController {
	public static void main(String[] args) {
		BoardService service = new BoardServiceImpl();
		BoardBean board = null;
		while(true){
			switch(JOptionPane.showInputDialog("0.exit 1.write 2.seq 3.list 4.findSeq 5.findWrite 6.update 7.delete")){
				case"0":
					return;
				case"1":
					board = new BoardBean();
					String[] arr = JOptionPane.showInputDialog("작성일/작성자/제목/내용").split("/");
					board.setRegdate(arr[0]);
					board.setWriter(arr[1]);
					board.setTitle(arr[2]);
					board.setContent(arr[3]);
					service.writeBoard(board);
					break;
				case"2":
					JOptionPane.showMessageDialog(null, service.countSeq());
					break;
					
				case"3":
					BoardBean[] boardlist = service.listBoard();
					String slist="";
					
					
					
					
					
					String result[] = new String[boardlist.length];
					for(int i=0; i<result.length; i++){
						result[i] = "번호"+boardlist[i].getSeq()+"작성일:"+boardlist[i].getRegdate() + " 작성자:"+boardlist[i].getWriter() + " 제목:"+boardlist[i].getTitle() + " 내용" +boardlist[i].getContent();
					}
					JOptionPane.showMessageDialog(null, result);
					break;
				case"4":
					
					JOptionPane.showMessageDialog(null,(service.findBySeq(Integer.parseInt(JOptionPane.showInputDialog("insert find sqe"))).toString()));
					
					break;
				case"5":
					
					JOptionPane.showMessageDialog(null, service.findByWriter(JOptionPane.showInputDialog("insert findWrite").toString()));
					
					break;
				case"6":
					board = new BoardBean();
					board.setSeq(Integer.parseInt(JOptionPane.showInputDialog("insert find seq")));
					board.setContent(JOptionPane.showInputDialog("insert change content"));
					service.updateContent(board);
					JOptionPane.showMessageDialog(null, "update complete");
					break;
				case"7":
					board = new BoardBean();
					service.delete(Integer.parseInt(JOptionPane.showInputDialog("insert delete seq")));
					break;

			}
		}
	}
}

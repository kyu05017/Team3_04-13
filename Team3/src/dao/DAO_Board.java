package dao;

import dto.DTO_Board;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class DAO_Board extends Dao {
	
	public static DAO_Board bdao = new DAO_Board();
	
	//글작성
	public boolean write(DTO_Board dto_Board) {
		try {
			String sql = "insert into board(b_title, b_content, m_number)values(?,?,?,?)";
			ps = con.prepareStatement(sql);
			ps.setString(1, dto_Board.getB_title());
			ps.setString(2, dto_Board.getB_content());
			ps.setInt(3, dto_Board.getM_number());
			ps.setInt(4, dto_Board.getB_gr());
			ps.executeUpdate();
			return true;

		}catch(Exception e){
			System.out.println("DAO_Board 글작성 오류 " + e);
		}
		return false;
	}
	//자유게시판 글 호출 메소드
	public ObservableList<DTO_Board> list(int b_number){
		ObservableList<DTO_Board> boardlist = FXCollections.observableArrayList();
		try {
			String sql = "select * from board where b_gr= ? order by b_number";
			ps = con.prepareStatement(sql);
			ps.setInt(1, b_number);
			rs=ps.executeQuery();
			while(rs.next()) {
				DTO_Board board = new DTO_Board(rs.getInt(1),
						rs.getString(2),
						rs.getString(3),
						rs.getString(4),
						rs.getInt(5),
						rs.getInt(6),
						rs.getInt(7)
						);
				boardlist.add(board);
				
			}		
			return boardlist;
		}catch(Exception e) {
			System.out.println( "DAO_Board 글호출 오류 "+e  );
		}
		return null;
	}
//	//자유게시판 글 수정 메소드
//	public boolean update(int b_number, String b_title, String b_content) {
//		try {
//			String sql = "update board set b_title=? , b_content=? where b_number=?";
//			
//			ps=con.prepareStatement(sql);
//			ps.setString(1, b_title);
//			ps.setString(2, b_content);
//			ps.setInt(3, b_number);
//			ps.executeUpdate();
//			
//			return true;
//		}catch(Exception e) {
//			System.out.println( "DAO_Board 글수정 오류 "+e  );
//			return false;
//		}
//		
//	}
	
	//자유게시판 글 삭제 메소드
	public boolean delete(int b_number) {
		try {
			String sql = "delete from board where b_number=?";
			ps = con.prepareStatement(sql);
			ps.setInt(1, b_number);
			ps.executeUpdate();
			
			return true;
			
		}catch(Exception e) {
			System.out.println( "DAO_Board 글삭제 오류 "+e  );
			return false;
		}
		
	}
	
	
	
	
	
}
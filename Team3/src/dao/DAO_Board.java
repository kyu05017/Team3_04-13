package dao;




import dto.DTO_Board;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class DAO_Board extends Dao {
	
	

	public static DAO_Board bdao = new DAO_Board();
	
	//���ۼ�
	public boolean write(DTO_Board dto_Board) {
		try {
			String sql = "insert into board(b_number, b_title, b_content, m_number)values(?,?,?,?)";
			ps = con.prepareStatement(sql);
			ps.setInt(1, dto_Board.getB_number());
			ps.setString(2, dto_Board.getB_title());
			ps.setString(3, dto_Board.getB_content());
//			, m_number, b_gr, b_view
			ps.setInt(4, dto_Board.getM_number());
//			ps.setInt(5, dto_Board.getB_gr());
//			ps.setInt(6, dto_Board.getB_view());
			ps.executeUpdate();
			return true;
			
			
			
		}catch(Exception e){
			System.out.println("DAO_Board ���ۼ� ���� " + e);
		}
		return false;
	}
	//�����Խ��� �� ȣ�� �޼ҵ�
	public ObservableList<DTO_Board> list(){
		ObservableList<DTO_Board> boardlist = FXCollections.observableArrayList();
		try {
			String sql = "select * from board order by b_number asc";
			
			ps = con.prepareStatement(sql);
			
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
			System.out.println( "DAO_Board ��ȣ�� ���� "+e  );
			
		}
		return null;
	}
	
}

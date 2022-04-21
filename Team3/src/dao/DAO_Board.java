package dao;

import dto.DTO_Board;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class DAO_Board extends Dao {
	
	public static DAO_Board bdao = new DAO_Board();
	
	//���ۼ�
	public boolean write(DTO_Board dto_Board) {
		try {
			String sql = "insert into board(b_title, b_content, m_number, b_gr)values(?,?,?,?)";
			ps = con.prepareStatement(sql);
			ps.setString(1, dto_Board.getB_title());
			ps.setString(2, dto_Board.getB_content());
			ps.setInt(3, dto_Board.getM_number());
			ps.setInt(4, dto_Board.getB_gr());
			ps.executeUpdate();
			return true;

		}catch(Exception e){
			System.out.println("DAO_Board ���ۼ� ���� " + e);
		}
		return false;
	}
	//�����Խ��� �� ȣ�� �޼ҵ�
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
			System.out.println( "DAO_Board ��ȣ�� ���� "+e  );
		}
		return null;
	}

	
	//�����Խ��� �� ���� �޼ҵ�
	public boolean delete(int b_number) {
		try {
			String sql = "delete from board where b_number=?";
			ps = con.prepareStatement(sql);
			ps.setInt(1, b_number);
			ps.executeUpdate();
			
			return true;
			
		}catch(Exception e) {
			System.out.println( "DAO_Board �ۻ��� ���� "+e  );
			return false;
		}
		
	}
	
	//4.�ۼ��� **************
	
		public boolean update(int b_number, String b_content) {
			
			
			try {
				
				//1.sql �ۼ�
				String sql = "update board set b_content=? where b_number=?";
				
				//2.sql ����
				ps = con.prepareStatement(sql);
				ps.setString(1, b_content);
				ps.setInt(2, b_number);
				
				//3. ����
				ps.executeUpdate();
				
				//4. ���
				return true;
				
			} catch (Exception e) {	System.out.println( "DAO_Board �ۼ��� ���� "+ e); }
			
			return false;
		}
		//5. ��� �ۼ�
		
		public boolean boardreply(reply reply) {
			
			try {
				String sql = "insert into reply(r_content,r_date,b_number) values(?,?,?)";
				
				ps = con.prepareStatement(sql);
				ps.setString(1, reply.getR_content());
				ps.setString(2, reply.getR_date());
				ps.setInt(3, reply.getB_number());
				
				ps.executeQuery();
				
				return true; //������		

			} catch (Exception e) {	}
				
			return false;
		}
		
		
		
		
		//6. ��� ȣ��
		
		public ObservableList<reply> replylist (int b_number) {
			
			ObservableList<reply> replylist = FXCollections.observableArrayList();
				
			
			try {															// ��������
				String sql = "select * from reply where b_num=? order by b_number desc";
				
				ps = con.prepareStatement(sql);
				ps.setInt(1, b_number);
				rs = ps.executeQuery();
				
				//�޾ƿ� �͵�
					while(rs.next()) { reply reply = new reply
							(rs.getInt(1), rs.getInt(2), rs.getInt(3),
							rs.getString(4), rs.getString(5));
							replylist.add(reply);
					}
				
				
				return replylist; //������		

			} catch (Exception e) {	}
				
			return null; //������ ���
		}
	
	
}
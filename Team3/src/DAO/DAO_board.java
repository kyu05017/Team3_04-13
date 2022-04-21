package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import DTO.board;
import DTO.reply;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class DAO_board extends dao {
	

	//ȣ��
	public static DAO_board boarddao = new DAO_board();
	
	
	//������
	public DAO_board() {}	
	
	///////////////////////////////////////////
	//�޼ҵ�
	
	//1.�۾���
	
	public boolean write(board board) {
		
		//����ó��
		try {			//����, ����, �ۼ���(ȸ����ȣ)
			String sql = "insert into board(b_title,b_content,m_number) values(?,?,?)";
			
			ps = con.prepareStatement(sql);
			ps.setString(1, board.getB_title());
			ps.setString(2, board.getB_content());
			ps.setInt(3, board.getM_number());
			
			
			//����
			ps.executeQuery();
			
			return true; //������ ����			
			
		} catch (Exception e) {	}

		return false; //t f
	}
	
	
	//2.��ȣ��
	public ObservableList<board> blist() {
		ObservableList<board> boardlist = FXCollections.observableArrayList();
		
		try {
			
			String sql = "select * from board order by b_number desc";
			//����
			
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			
			//��� �ݺ���
			while(rs.next()) {
				
				//��üȭ
				board board = new board(rs.getInt(1),
						rs.getString(2), rs.getString(3), rs.getString(4),
						rs.getInt(5), rs.getInt(6), rs.getInt(7));
				
				//��ü ���
				boardlist.add(board);
								
			} //while end
			
			//������ ���
			return boardlist;
			
		} catch (Exception e) {	}
		
		return null; //������ ���
	}
	
	
	
	
	//3.�ۻ���
	
	public boolean delete(int b_number) {
		
		try {
			// ���� ���̺� �ȿ��� b_num�� ���� �� �����.
			String sql = "delete from board where b_num=?";
			
			//sql����
			ps = con.prepareStatement(sql);
			ps.setInt(1, b_number);
			ps.executeQuery();
			
			return true; //������			
			
		} catch (Exception e) {	}

		return false;
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
	
	
	////////////////reply
	
	
	
	
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
	
	
	
	
	
	
/////////////////////////////////
}

package dao;

import dto.DTO_Car;
import dto.DTO_Letter;
import dto.DTO_Member;
import dto.DTO_Reply;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class DAO_Letter extends Dao{

	public static DAO_Letter dao_Letter = new DAO_Letter();

	public boolean send(DTO_Letter letter) {
		try {
			String sql = "INSERT INTO letter(m_number,m_id,l_content,C_number) VALUES (?,?,?,?)";
			ps = con.prepareStatement(sql);
			ps.setInt(1,letter.getM_number());
			ps.setString(2,letter.getM_id());
			ps.setString(3,letter.getL_content());
			ps.setInt(4,letter.getC_number());
			ps.executeUpdate();
			return true;
		}
		catch (Exception e) {
			System.out.println("��� ���� ���� " + e);
		}
		return false;
	}
	
	public ObservableList<DTO_Letter> letters(int m_number){
		ObservableList<DTO_Letter> letterlist = FXCollections.observableArrayList();
		try {
			String sql = "select * from letter where m_number= ? order by l_number desc";
			ps = con.prepareStatement(sql);
			ps.setInt(1, m_number);
			rs = ps.executeQuery();
			while(rs.next()) {
				DTO_Letter letter = new DTO_Letter(
						rs.getInt(1),
						rs.getInt(2),
						rs.getString(3),
						rs.getString(4),
						rs.getString(5),
						rs.getInt(6)
						);
				letterlist.add(letter);
				
			}		
			return letterlist;
		}catch(Exception e) {
			System.out.println( "���� ���� "+ e  );
		}
		return null;
		
	}
	
	//����
	public void write(DTO_Letter dto_Letter, DTO_Member dto_Member, DTO_Car dto_Car) {
		try {
			String sql = "insert into letter( m_number, m_id, l_content, l_date, c_number)values(?,?,?,?,?)";
			ps = con.prepareStatement(sql);
			ps.setInt(1, dto_Member.getM_number());
			ps.setString(2, dto_Member.getM_id());
			ps.setString(3, dto_Letter.getL_content());
			ps.setString(4, dto_Letter.getL_date());
			ps.setInt(5, dto_Car.getC_number());
			ps.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
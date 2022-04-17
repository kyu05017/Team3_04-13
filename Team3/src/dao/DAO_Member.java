package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Date;
import dto.DTO_Member;

public class DAO_Member extends Dao{
	
	public DAO_Member() {}
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	
	public static DAO_Member mdao = new DAO_Member();
	// ȸ������
	public boolean registration (DTO_Member member) {
		try {
			String sql = "insert into member(m_id,m_pw,m_name,m_email,m_phone,m_address,m_today,m_gr) values(?,?,?,?,?,?,?,?)";
			ps = con.prepareStatement(sql);
			ps.setString(1, member.getM_id());
			ps.setString(2, member.getM_pw());
			ps.setString(3, member.getM_name());
			ps.setString(4, member.getM_email());
			ps.setString(5, member.getM_phone());
			ps.setString(6, member.getM_address());
			ps.setString(7, member.getM_today());
			ps.setInt(8, member.getM_gr());
			ps.executeUpdate();
			return true;
		}
		catch (Exception e) {
			System.out.println("DAO_Member ȸ������ ���� " + e);
		}
		return false;
	}
	// ���̵� �ߺ�üũ
	public boolean id_duplicat(String id) {
		try {
			String sql = "select * from member where m_id=?";
			ps = con.prepareStatement(sql);
			ps.setString(1, id);
			rs = ps.executeQuery();
			if(rs.next()) {
				return true;
			}
		}
		catch (Exception e) {
			System.out.println("DAO_Member ���̵� �ߺ� üũ ���� " + e);
		}
		return false;
	}
	// �α���
	public boolean login(String id, String pw) {
		try {
			String sql = "select * from member where m_id=? and m_pw=?";
			ps = con.prepareStatement(sql);
			ps.setString(1,id);
			ps.setString(2,pw);
			rs = ps.executeQuery();
			if(rs.next()) {
				String today = sdf.format(new Date());
				String sql2 = "UPDATE member SET m_today=? where m_id=?";
				ps = con.prepareStatement(sql2);
				ps.setString(1,today);
				ps.setString(2,id);
				ps.executeUpdate(); 
				return true;
			}
		}
		catch (Exception e) {
			System.out.println("DAO_Member �α��� ���� " + e);
		}
		return false;
	}
	// ȸ������ �ӽ����� 
	public DTO_Member get_member (String id) {
		try {
			String sql = "select * from member where m_id=?";
			ps = con.prepareStatement(sql);
			ps.setString(1, id);
			rs = ps.executeQuery();
			if(rs.next()) { 
				DTO_Member member = new DTO_Member(
				rs.getInt(1),
				rs.getString(2),
				null,
				rs.getString(4),
				rs.getString(5),
				rs.getString(6),
				rs.getString(7),
				rs.getString(8),
				rs.getString(9),
				rs.getInt(10)
				);
				return member;
			}
		}
		catch(Exception e ) {
			System.out.println("DAO_Member ȸ������ ȣ�� " + e);
		}
		return null;
	}
	// ���̵� ã��
	public String find_id(String name, String email) {
		try {
			String sql = "select * from member where m_name=? and m_email=?";
			ps = con.prepareStatement(sql);
			ps.setString(1,name);
			ps.setString(2,email);
			rs = ps.executeQuery();
			if(rs.next()) { 
				return rs.getString(3);
			}
		}
		catch (Exception e) {
			System.out.println("DAO_Member ���̵� ã�� ���� " + e);
		}
		return null;
	}
	// ��й�ȣ ã��
	public String find_pw(String id,String email) {
		try {
			String sql = "select * from member where m_id=? and m_email=?";
			ps = con.prepareStatement(sql);
			ps.setString(1, id);
			ps.setString(2, email);
			rs = ps.executeQuery();
			if(rs.next()) { return rs.getString(3);
			}
		}
		catch (Exception e) {
			System.out.println("DAO_Member ��й�ȣ ã�� ���� " + e);
		}
		return null;
	}
	// ��й�ȣ üũ
	public boolean check_pw(int num, String pw) {
		try {
			String sql = "select * from member where m_pw=?";
			ps = con.prepareStatement(sql);
			ps.setString(1, pw);
			rs = ps.executeQuery();
			if(rs.next()) {
				return true;
			}
		}
		catch (Exception e) {
			System.out.println("DAO_Member ��й�ȣ ���� ���� " + e);
		}
		return false;
	}
	// ��й�ȣ ���� [ ����� �ʿ� ]
	public boolean change_pw(int num, String pw) {
		try {
			String sql = "select * from member where m_pw=?";
			ps = con.prepareStatement(sql);
			ps.setString(1, pw);
			rs = ps.executeQuery();
			if(rs.next()) {
				Connection con2;
				PreparedStatement ps2;
				ResultSet rs2;

				String sql2 = "UPDATE member SET m_id=? where m_num=?";
				ps2 = con.prepareStatement(sql);
				ps2.setString(1, pw);
				ps2.setInt(2, num);
				return true;
			}
		}
		catch (Exception e) {
			System.out.println("DAO_Member ��й�ȣ ���� ���� " + e);
		}
		return false;
	}
	// ȸ�� Ż�� 
	public boolean signout(int num) {
		try {
			String sql = "delete from member where m_num=?";
			ps = con.prepareStatement(sql);
			ps.setInt(1, num);
			ps.executeUpdate();
			return true;
		}
		catch (Exception e) {
			System.out.println("DAO_Member ȸ��Ż�� ȣ�� ���� " + e);
		}
		return false;
	}
}

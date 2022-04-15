package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import dto.DTO_Member;

public class DAO_Member extends Dao{
	
	public DAO_Member() {}
	
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
				return true;
			}
		}
		catch (Exception e) {
			System.out.println("DAO_Member �α��� ���� " + e);
		}
		return false;
	}
	// ���̵� ã��
	public boolean find_id(String name, String emanil) {
		try {
			String sql = "select * from member where m_name=? and m_email=?";
			ps = con.prepareStatement(sql);
			ps.setString(1,name);
			ps.setString(2,emanil);
			rs = ps.executeQuery();
			if(rs.next()) {
				return true;
			}
		}
		catch (Exception e) {
			System.out.println("DAO_Member ���̵� ã�� ���� " + e);
		}
		return false;
	}
	// ��й�ȣ ã��
	public boolean find_pw(String id,String email) {
		try {
			String sql = "select * from member where m_id=? and m_email=?";
			ps = con.prepareStatement(sql);
			ps.setString(1, id);
			ps.setString(2, email);
			rs = ps.executeQuery();
			if(rs.next()) {
				return true;
			}
		}
		catch (Exception e) {
			System.out.println("DAO_Member ��й�ȣ ã�� ���� " + e);
		}
		return false;
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
	// ��й�ȣ ����
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
	// ȸ�� ���� ����
	public DAO_Member get_member () {
		try {
			
		}
		catch (Exception e) {
			System.out.println("DAO_Member ȸ������ ȣ�� ���� " + e);
		}
		return null;
	}
	// ȸ�� Ż�� 
	public boolean signout() {
		try {
			
		}
		catch (Exception e) {
			System.out.println("DAO_Member ȸ��Ż�� ȣ�� ���� " + e);
		}
		return false;
	}
}

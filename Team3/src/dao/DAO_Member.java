package dao;

import java.sql.DriverManager;

public class DAO_Member extends Dao{
	
	public DAO_Member() {}
	
	public boolean registration () {
		try {
			String sql = "insert into (�ʵ尪)values(?,?)";
			ps = con.prepareStatement(sql);
			
			return true;
		}
		catch (Exception e) {
			System.out.println("DAO_Member ȸ������ ���� " + e);
		}
		return false;
	}
	public boolean login() {
		try {
			return true;
		}
		catch (Exception e) {
			System.out.println("DAO_Member �α��� ���� " + e);
		}
		return false;
	}
	public boolean find_id() {
		try {
			return true;
		}
		catch (Exception e) {
			System.out.println("DAO_Member ���̵� ã�� ���� " + e);
		}
		return false;
	}
	public boolean find_pw() {
		try {
			return true;
		}
		catch (Exception e) {
			System.out.println("DAO_Member ��й�ȣ ã�� ���� " + e);
		}
		return false;
	}
	public boolean change_pw() {
		try {
			return true;
		}
		catch (Exception e) {
			System.out.println("DAO_Member ��й�ȣ ���� ���� " + e);
		}
		return false;
	}
}

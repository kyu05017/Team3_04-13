package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Dao {
	
	private Connection con;
	private PreparedStatement ps;
	private ResultSet rs;
	
	public Dao() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");// 1. DB ����̹� ��������
			con = DriverManager.getConnection("jdbc:mysql://�ּ�","admin","��й�ȣ"); // 2. DB �ּ� ����
			System.out.println("���� DB���� ����");
		} 
		catch (Exception e) {
			System.out.println("[SQL ��� ���� ���� ] "+ e);
		}
	}	
	
	
	
}


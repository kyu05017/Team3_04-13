package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Dao {
	
	protected Connection con;
	protected PreparedStatement ps;
	protected ResultSet rs;
	
	public Dao() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
//			con = DriverManager.getConnection("jdbc:mysql://�ּ�","admin","��й�ȣ");
			System.out.println("Main Dao DB ���� �Ϸ�");
		} 
		catch (Exception e) {
			System.out.println("Main Dao DB ���� ���� "+ e);
		}
	}	
}


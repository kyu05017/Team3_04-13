package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


public class dao {

	protected Connection con;
	protected PreparedStatement ps;
	protected ResultSet rs;
	
	public dao() {
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://�ּ�","admin","��й�ȣ");
			System.out.println("����Ǿ����ϴ�.");
		} catch (Exception e) { System.out.println("�������");	}
		
		
	}
	
}

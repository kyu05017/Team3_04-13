package DAO;

import DTO.member;

public class Dao_member extends dao {

	public Dao_member() {}
	//����
	
	public static Dao_member dmem = new Dao_member();
	//ȸ������
	
	public boolean re (member member) {
		try {
			
			String sql = "insert into member(m_id,m_pw,m_name,m_email,m_date,m_phone,m_address,m_today,m_gr)"
					+ "values(?,?,?,?,?,?,?,?)";
			//�� number�� ����?
			
			ps = con.prepareStatement(sql);
			
			ps.setString(1, member.getM_id());
			ps.setString(2, member.getM_pw());
			ps.setString(3, member.getM_name());
			ps.setString(4, member.getM_email());
			ps.setString(5, member.getM_date());
			ps.setString(6, member.getM_phone());
			ps.setString(7, member.getM_address());
			ps.setString(8, member.getM_today());
			ps.setString(9, member.getM_gr());
	
			return true;
		} catch (Exception e) {	}
		return false;
	}
	
	
	
	//�α���
	public boolean login(String id, String pw) {
		//�α��ο� id�� pw�� �޾ƿ� 
		
		try {
			String sql = "select * from member where m_id=? and m_pw=?";
						//sql���� id�� pw�� ���´�.
			ps = con.prepareStatement(sql);
			ps.setString(1, id);
			ps.setString(2, pw);
			rs = ps.executeQuery(); //�ǹ�?
			
			if(rs.next()) { //�ǹ�?
				return true;
			}
			
		} catch (Exception e) {	}
		
		return false;
	}
	
	
	
	//���̵� ã��
	public boolean findid(String name, String email) {
		
		try {
			String sql = "select * from member where m_name=? and m=email=?";
			ps = con.prepareStatement(sql);
			ps.setString(1, name);
			ps.setString(2, email); //�� m�� �� �ٰ� �׳� name?
			rs = ps.executeQuery();
			
			if(rs.next()) {return true;}
					
		} catch (Exception e) { System.out.println("���̵� ã�� ����");	}
	
		return false;
	}
	
	
	
	
	
	//��й�ȣ ã��
	
	public boolean findpw(String id, String email) {
		
		try {
			String sql = "select * from member where m_id=? and m=email=?";
			ps = con.prepareStatement(sql);
			ps.setString(1, id);
			ps.setString(2, email);
			rs = ps.executeQuery();
			
			if(rs.next()) {return true;}
					
		} catch (Exception e) { System.out.println("��й�ȣ ã�� ����");	}
	
		return false;
	}
	
	
	//��й�ȣ üũ
	
	
	//��й�ȣ ����
	
	
	//�ڵ� �б�???
	
	
	//ȸ������ ����

	//ȸ������ Ż��
	
	
	
	
	
	
}

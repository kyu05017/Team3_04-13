package dao;

public class DAO_Member extends Dao{
	
	public DAO_Member() {}
	
	// ȸ������
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
	// ���̵� �ߺ�üũ
	public boolean id_duplicat() {
		try {
			
		}
		catch (Exception e) {
			System.out.println("DAO_Member ���̵� �ߺ� üũ ���� " + e);
		}
		return false;
	}
	// �α���
	public boolean login() {
		try {
			return true;
		}
		catch (Exception e) {
			System.out.println("DAO_Member �α��� ���� " + e);
		}
		return false;
	}
	// ���̵� ã��
	public boolean find_id() {
		try {
			return true;
		}
		catch (Exception e) {
			System.out.println("DAO_Member ���̵� ã�� ���� " + e);
		}
		return false;
	}
	// ��й�ȣ ã��
	public boolean find_pw() {
		try {
			return true;
		}
		catch (Exception e) {
			System.out.println("DAO_Member ��й�ȣ ã�� ���� " + e);
		}
		return false;
	}
	// ��й�ȣ ����
	public boolean change_pw() {
		try {
			return true;
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

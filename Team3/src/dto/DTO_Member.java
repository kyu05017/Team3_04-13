package dto;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class DTO_Member { 
	
	
	private int m_number;
	private String m_id;
	private String m_pw;
	private String m_name;
	private String m_email;
	private String m_date;
	private String m_phone;
	private String m_address;
	private String m_today;
	private int m_gr;
	
	public static void sendmail(String email, String content) {
		//������ ��� ����
		String sendemail = "jin-bobae@naver.com";
		String sendpw = "��й�ȣ";
		// ȣ��Ʈ ����
		Properties properties = new Properties(); //�÷��� �����ӿ�ũ [map�÷���]
		properties.put("mail.smtp.host", "smtp.naver.com"); // ȣ��Ʈ �ּ�
		properties.put("mail.smtp.port", 587); //ȣ��Ʈ(���̹�) ��Ʈ��ȣ
		properties.put("mail.smtp.auth", "true"); //�����»���̸��� ����
		properties.put("mail.smtp.ssl.protocols", "TLSv1.2" ); // ���� ���� ����
		
		//����
		Session session = Session.getDefaultInstance(properties, new Authenticator() {
			
			@Override
			protected javax.mail.PasswordAuthentication getPasswordAuthentication() {
				return new javax.mail.PasswordAuthentication(sendemail, sendpw);
			}
		});
	
		//���Ϻ�����
		try {
			MimeMessage message = new MimeMessage(session);
			message.setFrom(new InternetAddress(sendemail));
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(email));
			
			message.setSubject("ȸ������ ��й�ȣ�� �ȳ��帳�ϴ�.");
			message.setText("ȸ������ ��й�ȣ : " + content);
			
			Transport.send(message);
		} catch (Exception e) {
			System.out.println("�������� ���� " + e);
		}
	
	
	}
	
	
	public DTO_Member() {}

	public DTO_Member(int m_number, String m_id, String m_pw, String m_name, String m_email, String m_date,
			String m_phone, String m_address, String m_today, int m_gr) {
		this.m_number = m_number;
		this.m_id = m_id;
		this.m_pw = m_pw;
		this.m_name = m_name;
		this.m_email = m_email;
		this.m_date = m_date;
		this.m_phone = m_phone;
		this.m_address = m_address;
		this.m_today = m_today;
		this.m_gr = m_gr;
	}

	public int getM_number() {
		return m_number;
	}

	public void setM_number(int m_number) {
		this.m_number = m_number;
	}

	public String getM_id() {
		return m_id;
	}

	public void setM_id(String m_id) {
		this.m_id = m_id;
	}

	public String getM_pw() {
		return m_pw;
	}

	public void setM_pw(String m_pw) {
		this.m_pw = m_pw;
	}

	public String getM_name() {
		return m_name;
	}

	public void setM_name(String m_name) {
		this.m_name = m_name;
	}

	public String getM_email() {
		return m_email;
	}

	public void setM_email(String m_email) {
		this.m_email = m_email;
	}

	public String getM_date() {
		return m_date;
	}

	public void setM_date(String m_date) {
		this.m_date = m_date;
	}

	public String getM_phone() {
		return m_phone;
	}

	public void setM_phone(String m_phone) {
		this.m_phone = m_phone;
	}

	public String getM_address() {
		return m_address;
	}

	public void setM_address(String m_address) {
		this.m_address = m_address;
	}

	public String getM_today() {
		return m_today;
	}

	public void setM_today(String m_today) {
		this.m_today = m_today;
	}

	public int getM_gr() {
		return m_gr;
	}

	public void setM_gr(int m_gr) {
		this.m_gr = m_gr;
	}
	
	
}
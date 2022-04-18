package control.login;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import dao.DAO_Member;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;

public class Change implements Initializable{
	@FXML
    private TextField txt_new_email;

    @FXML
    private TextField txt_new_phone;
    
    @FXML
    private Button btcom;

    @FXML
    void bt_com(ActionEvent event) {
    	
    	boolean pass = true;
    	Alert alert2 = new Alert(AlertType.INFORMATION);
    	String email = txt_new_email.getText();
    	String phone = txt_new_phone.getText();
    	Pattern pattern = Pattern.compile("\\d{3}-\\d{4}-\\d{4}");
		Matcher matcher = pattern.matcher(phone);
		
		if(phone.contains("-")) {
			if(phone.length() == 13) {}
			else {
				alert2.setTitle("���� ����");
	    		alert2.setHeaderText("�ùٸ��� ���� ��ȭ��ȣ �����Դϴ�.");
	    		alert2.setContentText("Ȯ��");
	    		alert2.showAndWait();
	    		pass = false;
	    		return;
			}
		}
		else {
			if(phone.length() == 11) {}
			else {
				alert2.setTitle("���� ����");
	    		alert2.setHeaderText("�ùٸ��� ���� ��ȭ��ȣ �����Դϴ�.");
	    		alert2.setContentText("Ȯ��");
	    		alert2.showAndWait();
	    		pass = false;
	    		return;
			}
		}
		if (matcher.matches()) {
	    } 
	    else if(!matcher.matches() &&  phone.length() == 11){
	    	String str1 = phone.substring(0, 3);
            String str2 = phone.substring(3, 7);
            String str3 = phone.substring(7, 11);
            phone = str1+"-"+str2+"-"+str3;
            txt_new_phone.setText(phone);
	    }
    	
		boolean p_result = DAO_Member.mdao.phone_duplicat(phone);
		if(p_result) {
			alert2.setTitle("ȸ������");
    		alert2.setHeaderText(" �̹� ��ϵ� ��ȭ��ȣ �Դϴ�.");
    		alert2.setContentText("Ȯ��");
    		alert2.showAndWait();
    		txt_new_phone.requestFocus();
    		pass = false;
    		return;
		}
		if(email.equals("")) {
			alert2.setTitle("ȸ������");
    		alert2.setHeaderText("�̸����� �Է����ּ���.");
    		alert2.setContentText("Ȯ��");
    		alert2.showAndWait();
    		txt_new_email.requestFocus();
    		pass = false;
    		return;
		}
		if(email.indexOf("@") == -1) {
			alert2.setTitle("ȸ������");
    		alert2.setHeaderText("�ùٸ��� �ʴ� �̸��� �����Դϴ�.");
    		alert2.setContentText("Ȯ��");
    		alert2.showAndWait();
    		txt_new_email.requestFocus();
    		pass = false;
    		return;
    	}
		boolean e_result = DAO_Member.mdao.email_duplicat(email);
		if(e_result) {
			alert2.setTitle("ȸ������");
    		alert2.setHeaderText(" �̹� ��ϵ� �̸��� �Դϴ�.");
    		alert2.setContentText("Ȯ��");
    		alert2.showAndWait();
    		txt_new_email.requestFocus();
    		pass = false;
    		return;
		}
		if(pass) {
			boolean result = DAO_Member.mdao.change_info(Login.member.getM_number(), email, phone);
			if(result) {
				alert2.setTitle("���� ����");
	    		alert2.setHeaderText("���� ������ �Ϸ� �Ǿ����ϴ�.");
	    		alert2.setContentText("Ȯ��");
	    		alert2.showAndWait();
	    		Login.member.setM_email(email);
	    		Login.member.setM_phone(phone);
	    		Mypage.mypage.loadpage("/view/login/info");
			}
		}
    }
    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
    	if (Login.member != null) {
			txt_new_email.setText(Login.member.getM_email());
			txt_new_phone.setText(Login.member.getM_phone());
		}
    }
}

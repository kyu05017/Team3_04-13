package control.login;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import DAO.DAO_Member;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.Alert.AlertType;

public class Pw_change implements Initializable{

	
	@FXML
	private Button btcom;
	
	@FXML
	private PasswordField pw;
	
	@FXML
	private PasswordField pw_check;
	
	@FXML
	void bt_com(ActionEvent event) {
		Alert alert2 = new Alert(AlertType.INFORMATION);
		
		String pw1 = pw.getText();
		String pw2 = pw_check.getText();
		
		Pattern passPattern1 = Pattern.compile("^(?=.*[a-zA-Z0-9])(?=.*\\d)(?=.*\\W).{8,20}$");
		Matcher passMatcher1 = passPattern1.matcher(pw1);
		Pattern passPattern2 = Pattern.compile("(\\w)\\1\\1\\1");
		Matcher passMatcher2 = passPattern2.matcher(pw1);

		if (pw1.equals("")) {
			alert2.setTitle("��й�ȣ ����");
    		alert2.setHeaderText("��й�ȣ�� �Է��ϼ���");
    		alert2.setContentText("Ȯ��");
    		alert2.showAndWait();
    		pw.requestFocus();
    		return;
		}
		if(!passMatcher1.find()){
			alert2.setTitle("��й�ȣ ����");
    		alert2.setHeaderText("��й�ȣ�� ������ Ư������ ���ڸ� �����ϸ� 8�� �̻��̾�� �մϴ�.");
    		alert2.setContentText("Ȯ��");
    		alert2.showAndWait();
    		pw.requestFocus();
			return;
		}
		if(passMatcher2.find()){
			alert2.setTitle("��й�ȣ ����");
    		alert2.setHeaderText("��й�ȣ�� ������ ���ڸ� �����ϰ� �����ؼ� ����� �� �����ϴ�.");
    		alert2.setContentText("Ȯ��");
    		alert2.showAndWait();
    		pw.requestFocus();
			return;
		}
		if(pw1.contains(Login.member.getM_id())){
		    alert2.setTitle("��й�ȣ ����");
    		alert2.setHeaderText("��й�ȣ�� ���̵� ���ԵǾ��ֽ��ϴ�.");
    		alert2.setContentText("Ȯ��");
    		alert2.showAndWait();
    		pw.requestFocus();
		    return;
		}
		if(pw1.contains(" ")){
		    alert2.setTitle("��й�ȣ ����");
    		alert2.setHeaderText("��й�ȣ�� ������ ���ԵǾ��ֽ��ϴ�.");
    		alert2.setContentText("Ȯ��");
    		alert2.showAndWait();
    		pw.requestFocus();
		    return;
		}
		
		if(pw2.equals("")) {
			alert2.setTitle("��й�ȣ ����");
    		alert2.setHeaderText("��й�ȣ�� ���Է����ּ���.");
    		alert2.setContentText("Ȯ��");
    		alert2.showAndWait();
    		pw_check.requestFocus();
		}
		if(!pw1.equals(pw2)) {
			alert2.setTitle("��й�ȣ ����");
    		alert2.setHeaderText("��й�ȣ�� �ٸ��ϴ�.");
    		alert2.setContentText("Ȯ��");
    		alert2.showAndWait();
    		pw_check.requestFocus();
		    return;
		}
		boolean result = DAO_Member.mdao.change_pw(Login.member.getM_number(),pw1);
		if(result) {
			alert2.setTitle("��й�ȣ ����");
    		alert2.setHeaderText("��й�ȣ ������ �Ϸ� �Ǿ����ϴ�.");
    		alert2.setContentText("Ȯ��");
    		alert2.showAndWait();
    		Mypage.mypage.loadpage("/view/login/info");
		}
	}
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
	}
}

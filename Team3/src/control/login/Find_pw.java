package control.login;

import java.net.URL;
import java.util.ResourceBundle;

import control.Main;
import dao.DAO_Member;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class Find_pw implements Initializable{
	
	@FXML
    private TextField txtid;

    @FXML
    private TextField txtemail;

    @FXML
    private Button btnfindpw;

    @FXML
    private Label lblalarm;

    @FXML
    private Button btnback;

    @FXML
    void back(ActionEvent event) {
    	Main.main.loadpage("/view/login/login");
    }

    @FXML
    void findpw(ActionEvent event) {
    	//1.�Էµ� ������ ��������
    	String m_id = txtid.getText();
    	String m_email = txtemail.getText();
    	//2. DB�޼ҵ� ȣ��
    	String m_pw = DAO_Member.mdao.find_pw(m_id, m_email);
    	//3.Ȯ��
    	if(m_pw != null) {
    		Alert alert = new Alert(AlertType.INFORMATION);
    		alert.setHeaderText("��й�ȣ��"+m_pw+"�Դϴ�");
    		alert.showAndWait();
    		
    	}else {
    		lblalarm.setText("�Է��� ������ Ʋ�Ƚ��ϴ�.");
    	}
    }
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
	}
}

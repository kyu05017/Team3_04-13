package Controller.login;

import java.net.URL;
import java.util.ResourceBundle;

import DAO.Dao_member;
import Controller.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;

public class findpw implements Initializable {
	
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

			//\\�Էµ� ������ Ȯ��
		String id = txtid.getText();
		String email = txtemail.getText();

		//db
		String pw = Dao_member.dmem.find_pw(id, email);

		//Ȯ��
		if(pw != null) {

			//1.�޽���(�˶�)
			Alert alert = new Alert(AlertType.INFORMATION); //�޽��� ��ü ����
				//���빰 ä���
				alert.setHeaderText("ȸ������ ��й�ȣ�� : "+ pw);
			alert.showAndWait(); //����

		} else { lblalarm.setText("��ġ�ϴ� ������ �����ϴ�."); }

	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {

	}

}

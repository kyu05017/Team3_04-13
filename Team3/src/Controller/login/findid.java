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

public class findid implements Initializable{
	
	@FXML
	private TextField txtname;

	@FXML
	private TextField txtemail;

	@FXML
	private Button btnfindid;

	@FXML
	private Label lblalarm;

	@FXML
	private Button btnback;

	@FXML
	void back(ActionEvent event) {
		Main.main.loadpage("/view/login/login");
	}

	@FXML
	void findid(ActionEvent event) { //1.���̵� ã�� ��ư Ŭ��
		String name = txtemail.getText();
		String email = txtemail.getText();

		//db���� ã�ƿ���
		String id = Dao_member.dmem.find_id(name, email);
				//DAO_Member.mdao.find_id(name, email);


		if(id != null) {

			//1.�޽���(�˶�)
			Alert alert = new Alert(AlertType.INFORMATION); //�޽��� ��ü ����
				//���빰 ä���
				alert.setHeaderText("ȸ������ ���̵�� : "+ id);
			alert.showAndWait(); //����

		} else { lblalarm.setText("��ġ�ϴ� ������ �����ϴ�."); }

	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {

	}

}


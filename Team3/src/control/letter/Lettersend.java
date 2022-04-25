package control.letter;


import java.net.URL;
import java.util.ResourceBundle;

import control.Main;
import control.car.Carlist;
import control.car.Carview;
import control.login.Login;
import dao.DAO_Letter;
import dao.DAO_Member;
import dto.DTO_Letter;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;

public class Lettersend implements Initializable {
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
	}

    @FXML
    private Button btnback;

    @FXML
    private Button btnsend;

    @FXML
    private Label content;

    @FXML
    private Label letter;

    @FXML
    private TextArea textsend;

    @FXML
    void accback(ActionEvent event) {
    	Stage thisForm = (Stage) btnback.getScene().getWindow();
		thisForm.close();
    	Main.main.loadpage("/view/home");
    }
    


    

    @FXML
    void accsend(ActionEvent event) { //������ ��ư�� ������ ��
    	String msg = textsend.getText();
    	Alert alert2 = new Alert(AlertType.INFORMATION);
    	
    	if(msg.equals("")) {
    		alert2.setTitle("�˸�â");
    		alert2.setHeaderText(" ������ �Է����ּ���. ");
    		alert2.setContentText("Ȯ��");
    		alert2.showAndWait();
    		textsend.requestFocus();
    	}
    	else {
    		String dealer_id = DAO_Member.mdao.get_id(Carlist.select.getM_number());
    		
    		DTO_Letter letter = new DTO_Letter(0,Login.member.getM_number(),dealer_id, msg,null,Carlist.select.getC_number());
    			
    		boolean result = DAO_Letter.dao_Letter.send(letter);
    		
    		if(result) {
	    		alert2.setTitle("�˸�â");
	    		alert2.setHeaderText(" �޼��� ������ �Ϸ� �Ǿ����ϴ�.");
	    		alert2.setContentText("�Ϸ�");
	    		alert2.showAndWait();
    			Stage thisForm = (Stage) btnsend.getScene().getWindow();
        		thisForm.close();
    		}
    	}
    }
}
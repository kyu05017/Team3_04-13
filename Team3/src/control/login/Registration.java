package control.login;

import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Optional;
import java.util.ResourceBundle;
import control.Main;
import dao.DAO_Member;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;

public class Registration implements Initializable{
	
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	String since = sdf.format(new Date());
	
	@FXML
    private TextField txtid;

    @FXML
    private TextField txtpw;

    @FXML
    private TextField txtpwconfirm;

    @FXML
    private TextField txtname;

    @FXML
    private TextField txtemail;

    @FXML
    private TextField txtphone;

    @FXML
    private TextField txtaddress;

    @FXML
    private Label lblconfirm;

    @FXML
    private Button btnsignup;

    @FXML
    private Button bt_back;
    
    @FXML
    private Button bt_check;

    @FXML
    void back(ActionEvent event) {
    	Main.main.loadpage("/view/home");
    }
    
    static boolean id_check = false;
    
    @FXML
    void id_check(ActionEvent event) {
    	String id = txtid.getText();
    	Boolean result1 = DAO_Member.mdao.id_duplicat(id);
    	if(result1) {
    		Alert alert2 = new Alert(AlertType.INFORMATION);
    		alert2.setTitle("���̵� �ߺ� üũ");
    		alert2.setHeaderText(" �ߺ��� ���̵� �Դϴ�.");
    		alert2.setContentText("Ȯ��");
    		alert2.showAndWait();
    		id_check = false;
    		return;
    	}
    	else {
    		Alert alert = new Alert(AlertType.CONFIRMATION); // Ȯ��,��� ��ư Ÿ��
    		alert.setHeaderText(txtid+" �� ����Ͻðڽ��ϴ�?");
    		// 2. ��ư Ȯ�� [ Optional Ŭ���� ]
    		Optional<ButtonType> optional = alert.showAndWait();
    		if(optional.get() == ButtonType.OK) { 
    			txtid.setText(id);
    			id_check = true;
    		}
    		else {
    			txtid.setText("");
    			id_check = false;
    			return;
    		}
    	}
    	
    }
    @FXML
    void signup(ActionEvent event) {
    	System.out.println("ȸ������");
    	String id = txtid.getText();
    	String pw = txtpw.getText();
    	String pwcheck = txtpwconfirm.getText();
    	String name = txtname.getText();
    	String email = txtemail.getText();
    	String phone = txtphone.getText();
    	
    	
    	
    }
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {	
		
	}
}

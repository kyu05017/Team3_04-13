package control.login;

import java.net.URL;
import java.util.ResourceBundle;

import control.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class Find_id implements Initializable{
	
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
    void findid(ActionEvent event) {

    }
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
	}
}

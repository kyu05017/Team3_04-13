package control;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;

public class Main implements Initializable{
	
	@FXML
    private Label lbl_login;

    @FXML
    void act_login(MouseEvent event) {
    	System.out.println("�α��� ������ �̵�");
    	
    }
    
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
	}
//	public void loadpage( String page ) { // loadpage ( ���ϰ�� )
//		
//		try {
//			// ������(fxml) ��üȭ 
//			Parent parent = FXMLLoader.load( getClass().getResource(page+".fxml") ); // ������ ����ó��
//			boarderPane.setCenter(parent); // �����̳�(fxml) ����� ������ �ֱ� 
//		}
//		catch( Exception e ) { // ������ �������� ���� ��� ����ó��
//			System.out.println("Ȩ ������ ���� ���� "+ e); 
//		}
//	}
}

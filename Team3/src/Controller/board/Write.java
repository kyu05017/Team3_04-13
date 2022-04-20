package Controller.board;

import java.net.URL;
import java.util.ResourceBundle;

import control.Home;
import control.login.Login;
import dao.DAO_board;
import dto.DTO_Board;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class Write implements Initializable{
	@FXML
    private Button btback;

    @FXML
    private TextArea txtcontents;

    @FXML
    private Button btwrite1;

    @FXML
    private TextField txttitle;
   
    @FXML
    private Label lbl_title;

    @FXML
    void accback(ActionEvent event) {
    	Main_board.main_board.loadpage("/view/board/board_view");
    }

    @FXML
    void addwrite(ActionEvent event) { //�Խù� ���
    		//1. �Էµ� ������ ��������
    	String title = txttitle.getText();
    	String content = txtcontents.getText();
    	
    	//�α��ο� �������� ��� ����� ��� ��ü�� ����
    	String write = Login.member.getM_id();
    	
    	
    		//2.�Է��� ������ dto�� �ִ� board�� �����Ѵ�
    	DTO_Board board = new DTO_Board(0, title, content, null, 0, 0, 0);
    	
    	
    	
    		//3.db�� �Խù��� �����Ѵ�.
    	boolean result = DAO_board.boarddao.write(board);
    	
    		if(result) { //�����ߴٸ�
    			Alert alert = new Alert(AlertType.INFORMATION);
    				alert.setHeaderText("�Խñ��� �ۼ��Ǿ����ϴ�.");
    			alert.showAndWait(); //������ ��ȯ
    			
    			Home.home.loadpage("/view/board/board_view");
    			
    		} else { //�����ߴٸ�
    			Alert alert = new Alert(AlertType.INFORMATION);
    				alert.setHeaderText("�ۼ��� �����Ͽ����ϴ�. [������ ����]");
    			alert.showAndWait();
    		}	
    }

    
    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
    	if(board.board_check == 1) {
    		lbl_title.setText("���� ����");
    	}
    	else if(board.board_check == 2){
    		lbl_title.setText("���� �Խ���");
    	}
    }
}

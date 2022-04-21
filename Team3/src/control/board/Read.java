package control.board;

import java.net.URL;

import java.util.Optional;
import java.util.ResourceBundle;

import control.login.Login;
import dao.DAO_Board;
import dao.DAO_Member;
import dao.DAO_Reply;
import dto.DTO_Board;
import dto.DTO_Reply;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.text.Text;

public class Read implements Initializable{
	
	@FXML
    private Text lbl_board_title;

    @FXML
    private Button bt_back;

    @FXML
    private TextArea txt_contents;

    @FXML
    private Button bt_rewrite1;

    @FXML
    private Text lbl_title;

    @FXML
    private Button bt_delete;

    @FXML
    private Button bt_update;

    @FXML
    private Label lbl_writer;

    @FXML
    private Label blb_date;

    @FXML
    private Label lbl_view;

    @FXML
    private TextArea txt_recontents;

    @FXML
    private TableView<DTO_Reply> re_talbe;

    @FXML
    private Button bt_redelete;

    @FXML
    private Button btreupdate;

    public static DTO_Reply reply;
    
    @FXML
    void back(ActionEvent event) {
    	if(board.board_check == 1) {
    		Admin_board.admin_board.loadpage("/view/board/board_view");
		}
		else if(board.board_check == 2){
			Main_board.main_board.loadpage("/view/board/board_view");
		}
    }

    @FXML
    void delete(ActionEvent event) {
    	Alert alert = new Alert(AlertType.CONFIRMATION);
    	alert.setHeaderText("�Խñ��� �����Ͻðڽ��ϱ�?");
    	Optional<ButtonType> optional = alert.showAndWait();
    	
    	if(optional.get() == ButtonType.OK) {
    		DAO_Board.bdao.delete(board.board.getB_number());
    		Main_board.main_board.loadpage("/view/board/board_view");
    	}
    			
    	
    }

    @FXML
    void re_del(ActionEvent event) {

    }

    @FXML
    void re_update(ActionEvent event) {
    	
    	String reply_contents = txt_recontents.getText();
    	
    	if(txt_recontents.getText().equals("")) {
    		Alert alert = new Alert(AlertType.INFORMATION);
    		alert.setHeaderText("������ �Է����ּ���.");
    		alert.showAndWait();
    	}
    	else {
    		if(Login.member == null) {
    			Alert alert = new Alert(AlertType.INFORMATION);
        		alert.setHeaderText("�α����� �̿밡�� �մϴ�.");
        		alert.showAndWait();
        		txt_recontents.setText("");	
        		return;
    		}
    		else {
    			
//	        	boolean result = DAO_Reply.rdao.re_update();
//	        	
//	        	if(result) {
//	        		Alert alert = new Alert(AlertType.INFORMATION);
//	        		alert.setHeaderText("��� �ۼ��� �Ϸ� �Ǿ����ϴ�.");
//	        		alert.showAndWait();
//	        		txt_recontents.setText("");	
//	        	}
    		}
    	}
    }

    @FXML
    void re_write(ActionEvent event) {
    	
    	String reply_contents = txt_recontents.getText();
    	
    	if(txt_recontents.getText().equals("")) {
    		Alert alert = new Alert(AlertType.INFORMATION);
    		alert.setHeaderText("������ �Է����ּ���.");
    		alert.showAndWait();
    	}
    	else {
    		if(Login.member == null) {
    			Alert alert = new Alert(AlertType.INFORMATION);
        		alert.setHeaderText("�α����� �̿밡�� �մϴ�.");
        		alert.showAndWait();
        		txt_recontents.setText("");	
        		return;
    		}
    		else {
    			DTO_Reply reply = new DTO_Reply(0,Login.member.getM_number(),board.board.getB_number(),reply_contents,null);
        	
	        	boolean result =DAO_Reply.rdao.re_write(reply);
	        	
	        	if(result) {
	        		Alert alert = new Alert(AlertType.INFORMATION);
	        		alert.setHeaderText("��� �ۼ��� �Ϸ� �Ǿ����ϴ�.");
	        		alert.showAndWait();
	        		txt_recontents.setText("");	
	        	}
    		}
    	}
    }

    boolean upcheck = true; //���� ����ġ ����
    @FXML
    void update(ActionEvent event) {
    	
    	Alert alert = new Alert(AlertType.INFORMATION);
    	//�޽��� �˸�
    	
    	if(upcheck) { //���� �ڵ�
    		alert.setHeaderText("�Խñ� ���� �� �Ϸ� ��ư�� �����ּ���.");
    		alert.showAndWait();
    		
// ���� ����	lbl_board_title.set(true);
    		txt_contents.setEditable(true);
    		bt_update.setText("���� �Ϸ�");
    		
    		upcheck = false;
    		
    	} else { //���� �Ϸ�
    		
    		//db�� ���� ����
    		DAO_Board.bdao.update(control.board.board.board.getB_number(),
    				txt_contents.getText());
   		
    		alert.setHeaderText("������ �Ϸ�Ǿ����ϴ�.");
    		alert.showAndWait();
    		
    		txt_contents.setEditable(false);
    		bt_update.setText("����");
    		upcheck = true;
    	}

    }
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		if(board.board_check == 1) {
			lbl_board_title.setText("��������");
		}
		else if(board.board_check == 2){
			lbl_board_title.setText("�����Խ���");
		}
		String writer = DAO_Member.mdao.get_id(board.board.getM_number());
		System.out.println(writer);
		if(writer == null) {
			writer = "Ż���� ȸ��";
		}
		
		lbl_title.setText(board.board.getB_title());
		lbl_writer.setText("�ۼ��� : " + writer);
		blb_date.setText("�ۼ��� : "+board.board.getB_date());
		lbl_view.setText("��ȸ�� : "+board.board.getB_view());
		txt_contents.setText(board.board.getB_content());
		bt_redelete.setVisible(false);
		btreupdate.setVisible(false);
		txt_contents.setEditable(false);
		re_talbe.setOnMouseClicked( e -> {
			try {
				reply = re_talbe.getSelectionModel().getSelectedItem();
				if(reply.getM_number() == Login.member.getM_number()) {
					bt_redelete.setVisible(true);
					btreupdate.setVisible(true);
					bt_rewrite1.setVisible(false);
				}
				else {
					btreupdate.setVisible(false);
					bt_redelete.setVisible(false);
					bt_rewrite1.setVisible(true);
				}
			}
			catch(Exception e2) {
				System.out.println("[�������� �ʴ� ���] ���� " + e);
			}
		});
		
		
//		if(writer.equals(DAO_Member.mdao.get_member(writer))) {
//			bt_delete.setVisible(true);//��ư���̱�
//			bt_update.setVisible(true);
//		}else{
//			bt_delete.setVisible(false);//��ư�����
//			bt_update.setVisible(false);
//		}
		if(board.board.getM_number()== Login.member.getM_number()) {
			bt_delete.setVisible(true);//��ư���̱�
			bt_update.setVisible(true);
		}else{
			bt_delete.setVisible(false);//��ư�����
			bt_update.setVisible(false);
		}
		
	}
	public void reply_show() {
		
		ObservableList<DTO_Reply> replyList =  DAO_Reply.rdao.list(board.board.getB_number());
		
		String writer = null;
		
		for(DTO_Reply reply : replyList) {
			
			writer = DAO_Member.mdao.get_id(reply.getM_number());
			
		}
		
		
		TableColumn<?, ?> tc = re_talbe.getColumns().get(0);
		tc.setCellValueFactory(new PropertyValueFactory<>("r_number"));
		
		tc= re_talbe.getColumns().get(1);
		tc.setCellValueFactory(new PropertyValueFactory<>("writer"));
		
		tc= re_talbe.getColumns().get(2);
		tc.setCellValueFactory(new PropertyValueFactory<>("r_content"));
		
		tc= re_talbe.getColumns().get(3);
		tc.setCellValueFactory(new PropertyValueFactory<>("r_date"));

		re_talbe.setItems(replyList);
	}
}
package Controller.letter;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import control.Main;
import control.car.Carlist;
import control.login.Login;
import dao.DAO_Member;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;

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
    	Main.main.loadpage("/view/home");
    }
    
    ////////////////////
    
    Socket socket; //����
    
    public Lettersend(Socket socket) { this.socket = socket; receive(); }
    //�ݺ������� �޽����� ���޹��� �� �ֵ��� receive �����
    
    public void receive() {
    	while(true) {
    		try {
    			InputStream in = socket.getInputStream(); //���� �ޱ�
    			byte[] bytes = new byte[1000];
    			in.read(bytes);
    			String msg = new String(bytes);
    			textsend.appendText(msg); //�޽��� â�� ����
    		} catch (Exception e) { }
    	}
    }
    
    public void send(String msg) { //�������� �޼��� ������
    	Thread thread = new Thread() {
    		@Override
    		public void run() {
    			try {
    				OutputStream outputStream = socket.getOutputStream(); //��� ��Ʈ��
    				outputStream.write(msg.getBytes()); //��������
    				outputStream.flush(); //�ʱ�ȭ(��Ʈ�� �� ����Ʈ ����)
    			} catch (Exception e) { }
    		}
    	}; //��Ƽ������ ���� ��
    	thread.start();
    }
    
    
    public static Carlist selectcar; //carlist���� ������ ��
  

    

    @FXML
    void accsend(ActionEvent event) { //������ ��ư�� ������ ��
    	String msg = Login.member.getM_id()+" : "+ textsend.getText()+"\n";
    	send(msg);
    	textsend.setText("");
    	textsend.requestFocus();
    	}

    
    
    
}

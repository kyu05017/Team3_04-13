package app;


import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Start extends Application {

	@Override
	public void start(Stage stage) throws Exception {
		Parent parent = FXMLLoader.load(getClass().getResource("/View/testmain.fxml"));
		
		Scene scene = new Scene(parent);
		stage.setScene(scene);
		
//		stage.setOnCloseRequest(e ->{
//			if(login.member != null) { 
//				roomDao.roomDao.roomlivedelete(login.member.getMid());
//											//�α��ε� ����� ���̵� ��������
//				
//				//2. �� ����
//				if(Chatting.selectroom != null) {
//					//���࿡ �濡 ���� �Ǿ� �ִ� �����̸�
//					roomDao.roomDao.roomdelete(Chatting.selectroom.getRonum());
//				}							//ä�ÿ� ���� ������ ���� �� ��ȣ �־��ֱ�
//				
//				//3. ���� �� �ʱ�ȭ
//				Chatting.selectroom = null;
//				
//			}
			
		//});
		
	}
	
	public static void main(String[] args) {
		launch(args);
	}
	
	
}

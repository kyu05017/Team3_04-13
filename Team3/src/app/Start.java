package app;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class Start extends Application{
	
	@Override
	public void start(Stage stage) throws Exception {
		// TODO Auto-generated method stub


	// 5. �����̳� �ҷ�����
			Parent parent = FXMLLoader.load(getClass().getResource("/view/testmain.fxml"));
			// 6. �� ��ü -> �����̳� ����
			Scene scene = new Scene(parent);
			// 7. �� -> ��������
			stage.setScene(scene);
			// �������� �ΰ� ������
				// 1. �̹��� �ҷ����� 
			//Image image2 = new Image("//C:\\Users\\504\\git\\JAVA_FX\\src\\img"); ������
				// ���� ��� VS ��� ���
				// ���� ��� : ��� ���
					// C:\Users\504\git\JAVA_FX\src\img
				// ��� ��� : ����ġ [ ������Ʈ ���� src ] ���� ���
					// ���� [ src�������� ] img/���ϸ�.Ȯ����
				// 2. �������� ���� 
			// �ܺ� ��Ʈ ����
			// 1. ��Ʈ ��������
//			Font.loadFont(getClass().getResourceAsStream("SuncheonB.ttf"), 15);
//			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
//			stage.setResizable(false);	// 3. �������� ũ�� ����
//			stage.setTitle("�䳢 �߰��� "); // 2. �������� â �̸�
			stage.show(); // �������� ����
		}
		public static void main(String[] args) {
			
			launch(args);
		}
	}
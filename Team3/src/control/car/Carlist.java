package control.car;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import dao.DAO_Car;
import dto.DTO_Car;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;


public class Carlist implements Initializable{
	
	public static DTO_Car select ;
	
	@FXML
    private ScrollPane scrollpane;

    @FXML
    private VBox vbox;
    
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		show();
	}
	
    void show() {
    	
    	ArrayList<DTO_Car> carlist = DAO_Car.dao_Car.list();
    	
    	if( vbox.getChildren().isEmpty() == false) { //isEmpty()  ������� ��츦 Ȯ�� [ vbox�� ����ִ��� Ȯ�� ]
    		// vbox �� ��ü�� ������� ������
    		vbox.getChildren().remove(0); // vbox
    	}
    	// 1. ��� ��ǰ ��������
		
		
		for(DTO_Car car : carlist) {
			System.out.println("�߰��� �ҷ�����");
			System.out.println(car.getC_title());
		}
		// 2. �׸��� Ŭ���� [ ��/�� ]
		GridPane gridPane = new GridPane();
			// * �׸��� ����
			gridPane.setPadding( new Insets(10) );
			// * �׸��峻 �� ���� 
			gridPane.setHgap(20); // ���ο��� 
			gridPane.setVgap(20); // ���ο���

		int i = 0 ; // �ε����� ����
		for( int row = 0 ; row < carlist.size(); row++ ) { // ��
				// 1. �̹���
				ImageView imageView = new ImageView( new Image( carlist.get(i).getC_img()) );
					// *�̹��� ������ 
					imageView.setFitWidth(100);		// �̹��� ���α��� 
					imageView.setFitHeight(100); 	// �̹��� ���α���
				// 2. ��ư ���� ( ��ư�� �̹��� �ֱ� )
				Button button = new Button( null , imageView );
					// *��ư ������� [ transparent : ����� ]
					button.setStyle("-fx-background-color:transparent");
					// *��ư id���ֱ� [ ��ǰ �ĺ� = index ]
					button.setId( i+"");
					// *��ư Ŭ���̺�Ʈ
						//	button.setOnAction( e -> { } ); // ���ٽ� : �μ� -> { �����ڵ� }
					button.setOnAction( e -> { 
						// 1. Ŭ���� ��ư�� id ��������
						int id = Integer.parseInt(e.toString().split(",")[0].split("=")[2] );
						// 2. Ŭ���� ��ǰ ��ȣ ���� 
						select = carlist.get(id);
					} );	
				gridPane.add( button  , 0, row); // �׸��峻  �ش� ����ȣ , ���ȣ �� ��ư �߰�
				i++; //�ε��� ����
		}
		// 4. vbox�� �׸��� �ֱ� 
		vbox.getChildren().add(gridPane);
    		
    }
    
}
package control.car;

import java.net.URL;
import java.text.DecimalFormat;
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
		GridPane gridPane = new GridPane();
			gridPane.setPadding( new Insets(10) );

			gridPane.setHgap(200); 
			gridPane.setVgap(20); 

		int i = 0 ;
		for( int row = 0 ; row < carlist.size(); row++ ) { // ��

				ImageView imageView = new ImageView( new Image( carlist.get(i).getC_img()) );

					imageView.setFitWidth(200);
					imageView.setFitHeight(100); 
					DecimalFormat df = new DecimalFormat("#,##0��");
					String new_price = df.format(carlist.get(i).getC_price());
				Button button = new Button("������ : "+ carlist.get(i).getC_title() + "                                                                                        ���� : "+ new_price + " | ����Ÿ� : " + carlist.get(i).getC_km() + "km |  ���� : "+ carlist.get(i).getC_year()+"��", imageView );
					
					button.setStyle("-fx-background-color:transparent");

					button.setId( i+"");
					
					button.setOnAction( e -> { 

						int id = Integer.parseInt(e.toString().split(",")[0].split("=")[2] );
				
						select = carlist.get(id);
					} );	
				gridPane.add( button  , 0, row); 
				i++;
		}
		vbox.getChildren().add(gridPane);
    		
    }
    
}
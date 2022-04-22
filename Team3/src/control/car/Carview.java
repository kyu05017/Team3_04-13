package control.car;

import java.net.URL;
import java.text.DecimalFormat;
import java.util.Optional;
import java.util.ResourceBundle;

import control.Main;
import dao.DAO_Car;
import dto.DTO_Car;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.ImageView;


public class Carview implements Initializable {
	
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {

		//���õ� ��ü ȣ��
		DTO_Car car = Carlist.select;
		
		//�� ��Ʈ�ѿ� �� �ֱ�
		img.setImage(new Image(car.getC_img())); //�ڵ��� �̹��� �����ͼ� �ֱ�
		txttitle.setText(car.getC_title()); //����� ���� ��������
		txtcontent.setText(car.getC_content()); //����� ���� ��������
		
		//�Է°� �ҷ�����
//		txtprice.setText(car.getC_price()); int�� ��������
//		txtkm.set(car.getC_km());

		txtcnumber.setText(car.getC_cnumber());
		txtcompany.setText(car.getC_com());
		txtcaryear.setText(car.getC_year());
		
		
		
		//���� ��ư ���� ���·� �����	
		if(optcarcate1.isSelected()) { //ù��° ��ư ���� �� �ش� �� ȣ��
			optcarcate1.setSelected(true);
			} else if(optcarcate2.isSelected()) { //�ι�° ��ư ���� �� �ش� �� ȣ��
				optcarcate2.setSelected(true);
			} else if(optcarcate3.isSelected()) { 
				optcarcate3.setSelected(true);
			} else if(optcarcate4.isSelected()) { 
				optcarcate4.setSelected(true);
			} else if(optcarcate5.isSelected()) { 
				optcarcate5.setSelected(true);
			} else if(optcarcate6.isSelected()) { 
				optcarcate6.setSelected(true);
			} else if(optcarcate7.isSelected()) { 
				optcarcate7.setSelected(true);
			} else { optcarcate8.setSelected(true);}
		//�� �ڵ尡 �´��� Ȯ���ʿ�
		//��۱׷�ȿ��ֱ�
		
	} //initialize end
	

    @FXML
    private TextField txtcnumber;

    @FXML
    private Button btnback;

    @FXML
    private ImageView img;

    @FXML
    private RadioButton optcarcate1;

    @FXML
    private ToggleGroup category;

    @FXML
    private RadioButton optcarcate2;

    @FXML
    private RadioButton optcarcate3;

    @FXML
    private RadioButton optcarcate4;

    @FXML
    private RadioButton optcarcate5;

    @FXML
    private RadioButton optcarcate6;

    @FXML
    private RadioButton optcarcate7;

    @FXML
    private RadioButton optcarcate8;

    @FXML
    private TextField txtcompany;

    @FXML
    private TextField txtcaryear;

    @FXML
    private TextField txtkm;

    @FXML
    private RadioButton optcondition1;

    @FXML
    private ToggleGroup condition;

    @FXML
    private RadioButton optcondition2;

    @FXML
    private RadioButton optmission1;

    @FXML
    private ToggleGroup mission;

    @FXML
    private RadioButton optmission2;

    @FXML
    private TextField txtprice;

    @FXML
    private RadioButton optfuel1;

    @FXML
    private ToggleGroup fuel;

    @FXML
    private RadioButton optfuel2;

    @FXML
    private RadioButton optfuel3;

    @FXML
    private RadioButton optfuel4;

    @FXML
    private RadioButton optfuel5;

    @FXML
    private TextField txttitle;

    @FXML
    private TextArea txtcontent;

    @FXML
    private Button btnupdate;

    @FXML
    private Button btndelete;

	    
	@FXML
	private Button btnsend;


	@FXML
	void accsend(ActionEvent event) { //����

	}


    @FXML
    void accback(ActionEvent event) {
    	Main.main.loadpage("/view/car/carlist");
    }
 
    
    @FXML
    void accdelete(ActionEvent event) { //����
    	Alert alert = new Alert(AlertType.CONFIRMATION);
    		alert.setHeaderText("��ǰ�� �����Ͻðڽ��ϱ�?");
    	Optional<ButtonType> optional = alert.showAndWait();
    	
    	if(optional.get() == ButtonType.OK) { //���� ok�� ������
    	}
    	
    }


    @FXML
    void accupdate(ActionEvent event) { //����

    }


}
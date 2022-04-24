package control.car;

import java.io.IOException;
import java.net.URL;
import java.text.DecimalFormat;
import java.util.Optional;
import java.util.ResourceBundle;

import control.Home;
import control.login.Login;
import dao.DAO_Car;
import dto.DTO_Car;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;



public class Carview implements Initializable {
	
	//���õ� ��ü ȣ��
	DTO_Car car = Carlist.select;
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {

		
		
		//�� ��Ʈ�ѿ� �� �ֱ�
		img.setImage(new Image(car.getC_img())); //�ڵ��� �̹��� �����ͼ� �ֱ�
		txttitle.setText(car.getC_title()); //����� ���� ��������
		txtcontent.setText(car.getC_content()); //����� ���� ��������
		
		//�Է°� �ҷ�����
		DecimalFormat df = new DecimalFormat("#,##0��");
		String new_price = df.format(car.getC_price());
		
		DecimalFormat df2 = new DecimalFormat("#,##0KM");
		String new_km = df2.format(car.getC_km());
		
		txtprice.setText(new_price);
		txtkm.setText(new_km);

		txtcnumber.setText(car.getC_cnumber());
		txtcompany.setText(car.getC_com());
		txtcaryear.setText(car.getC_year());
		
		int CC = car.getC_category();
		
		if(CC == 1) {
			optcarcate1.setSelected(true);
		}
		else if(CC == 2) {
			optcarcate2.setSelected(true);
		}
		else if(CC == 3) {
			optcarcate3.setSelected(true);
		}
		else if(CC == 4) {
			optcarcate4.setSelected(true);
		}
		else if(CC == 5) {
			optcarcate5.setSelected(true);
		}
		else if(CC == 6) {
			optcarcate6.setSelected(true);
		}
		else if(CC == 7) {
			optcarcate7.setSelected(true);
		}		
		else if(CC == 8) {
			optcarcate8.setSelected(true);
		}	
		
		
		int fuel = car.getC_fuel();
		
		if(fuel == 1) {
			optfuel1.setSelected(true);
		}
		else if(fuel == 2) {
			optfuel2.setSelected(true);
		}
		else if(fuel == 3) {
			optfuel3.setSelected(true);
		}
		else if(fuel == 4) {
			optfuel4.setSelected(true);
		}
		else if(fuel == 5) {
			optfuel5.setSelected(true);
		}
		
		int mission = car.getC_mission();

		if(mission == 1) {
			optmission1.setSelected(true);
		}
		else if(mission == 2) {
			optmission2.setSelected(true);
		}	
		
		int act = car.getC_condition();
		
		if(act == 1) {
			optcondition1.setSelected(true);
		}
		else if(act == 2) {
			optcondition2.setSelected(true);
		}	
		
		txttitle.setDisable(true);
		txtcnumber.setDisable(true);
		txtcompany.setDisable(true);
		optcarcate1.setDisable(true);
		optcarcate2.setDisable(true);
		optcarcate3.setDisable(true);
		optcarcate4.setDisable(true);
		optcarcate5.setDisable(true);
		optcarcate6.setDisable(true);
		optcarcate7.setDisable(true);
		optcarcate8.setDisable(true);
		txtcaryear.setDisable(true);
		txtkm.setDisable(true);
		optfuel1.setSelected(true);
		optfuel2.setSelected(true);
		optfuel3.setSelected(true);
		optfuel4.setSelected(true);
		optfuel5.setSelected(true);
		optmission1.setSelected(true);
		optmission2.setSelected(true);
		optcondition1.setSelected(true);
		optcondition2.setSelected(true);
		txtprice.setDisable(true);
		txtcontent.setDisable(true);
		
		btnupdate.setVisible(false);
		btndelete.setVisible(false);
		
		int a = 0;
		if(Login.member != null) {
			a = Login.member.getM_number();
		}
		int b = car.getM_number();

		if(a == b){
			btnupdate.setVisible(true);
			btndelete.setVisible(true);
		}

		
		
	} 
	

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
		if(Login.member != null){
    		try {
    			Stage stage = new Stage();
    			Parent parent = FXMLLoader.load(getClass().getResource("/view/letter/lettersend.fxml"));
    			Scene scene = new Scene(parent);
    			stage.setScene(scene);
    			stage.show();
    		} catch (IOException e) {
    			System.out.println("Main ����â ���� "+ e); 
    		}
    	}
    	else {
    		Alert alert2 = new Alert(AlertType.INFORMATION);
    		alert2.setTitle("�˸�â");
    		alert2.setHeaderText(" �α��� �� �̿� �����մϴ�. ");
    		alert2.setContentText("Ȯ��");
    		alert2.showAndWait();
    	}
	}


    @FXML
    void accback(ActionEvent event) {
    	Home.home.loadpage("/view/car/carlist");
    }
 
    
    @FXML
    void accdelete(ActionEvent event) { //����
    	
    	Alert alert = new Alert(AlertType.CONFIRMATION);
    	Alert alert2 = new Alert(AlertType.INFORMATION);
    		alert.setHeaderText("��ǰ�� �����Ͻðڽ��ϱ�?");
    	Optional<ButtonType> optional = alert.showAndWait();
    	
    	if(optional.get() == ButtonType.OK) { //���� ok�� ������
    		boolean result =  DAO_Car.dao_Car.delete(car.getC_number());
    		if(result == true) {
    			alert2.setTitle("�˸�â");
        		alert2.setHeaderText(" ������ �Ϸ� �Ǿ����ϴ�.");
        		alert2.setContentText("Ȯ��");
        		alert2.showAndWait();
    		}
    	}
    	
    }


    @FXML
    void accupdate(ActionEvent event) { //����

    }


}
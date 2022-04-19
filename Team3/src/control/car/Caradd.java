package control.car;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;

import com.mysql.cj.protocol.FullReadInputStream;

import javafx.fxml.Initializable;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.stage.Stage;


public class Caradd implements Initializable{
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
	}
	
    @FXML
    private TextField txtcnumber;

    @FXML
    private Button btnimg;

    @FXML
    private Button btnadd;

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
    private RadioButton optcarcate9;

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
    void accadd(ActionEvent event) {
    	
    }

    @FXML
    void accback(ActionEvent event) {
    	
    }

    @FXML
    void accimgadd(ActionEvent event) {
    	//���� ����
    	FileChooser chooser = new FileChooser();
    	
    	chooser.getExtensionFilters().add(new ExtensionFilter("�̹�������:image file", "*png", "*jpg", "*gif"));
    	//���ο� ��������
    	File file = chooser.showOpenDialog(new Stage());
    	
    	//�̹��� �̸�����
    	Image image = new Image(img);
    	img.setImage(image);
    	//������ ���� ���� ������Ʈ ������ �����ؿ���
    	
    }
	
}

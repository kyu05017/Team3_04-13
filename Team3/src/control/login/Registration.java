package control.login;

import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import control.Main;
import dao.DAO_Member;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;

public class Registration implements Initializable{
	
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	String since = sdf.format(new Date());
	
	@FXML
    private TextField txtid;

    @FXML
    private TextField txtpw;

    @FXML
    private TextField txtpwconfirm;

    @FXML
    private TextField txtname;

    @FXML
    private TextField txtemail;

    @FXML
    private TextField txtphone;

    @FXML
    private TextField txtaddress;

    @FXML
    private Label lblconfirm;

    @FXML
    private Button btnsignup;

    @FXML
    private Button bt_back;
    
    @FXML
    private Button bt_check;

    @FXML
    void back(ActionEvent event) {
    	Main.main.loadpage("/view/home");
    }
    
    static boolean id_check = false;
    
    @FXML
    void id_check(ActionEvent event) {
    	Alert alert2 = new Alert(AlertType.INFORMATION);
    	String id = txtid.getText();
    	if(txtid.getText().equals("")) {
    		alert2.setTitle("ȸ������");
    		alert2.setHeaderText(" ���̵� �Է��� �ּ���.");
    		alert2.setContentText("Ȯ��");
    		alert2.showAndWait();
    		return;
    	}
    	Boolean result1 = DAO_Member.mdao.id_duplicat(id);
    	if(result1) {
    		alert2.setTitle("���̵� �ߺ� üũ");
    		alert2.setHeaderText(" �ߺ��� ���̵� �Դϴ�.");
    		alert2.setContentText("Ȯ��");
    		alert2.showAndWait();
    		txtid.requestFocus();
    		id_check = false;
    		return;
    	}
    	else {
    		Alert alert = new Alert(AlertType.CONFIRMATION); // Ȯ��,��� ��ư Ÿ��
    		alert.setHeaderText(id+" �� ����Ͻðڽ��ϴ�?");
    		// 2. ��ư Ȯ�� [ Optional Ŭ���� ]
    		Optional<ButtonType> optional = alert.showAndWait();
    		if(optional.get() == ButtonType.OK) { 
    			txtid.setText(id);
    			id_check = true;
    			txtid.setDisable(true);
    		}
    		else {
    			txtid.setText("");
    			id_check = false;
    			txtid.setDisable(false);
    			return;
    		}
    	}
    }
    @FXML
    void signup(ActionEvent event) {
    	
    	Alert alert2 = new Alert(AlertType.INFORMATION);
    	
    	System.out.println("ȸ������");
    	String id = txtid.getText();
    	String pw = txtpw.getText();
    	String pwcheck = txtpwconfirm.getText();
    	String name = txtname.getText();
    	String email = txtemail.getText();
    	String phone = txtphone.getText();
    	String address = txtaddress.getText();
    	
    	Pattern passPattern1 = Pattern.compile("^(?=.*[a-zA-Z])(?=.*\\d)(?=.*\\W).{8,20}$");
		Matcher passMatcher1 = passPattern1.matcher(pw);
		Pattern passPattern2 = Pattern.compile("(\\w)\\1\\1\\1");
		Matcher passMatcher2 = passPattern2.matcher(pw);
		
		if(id_check == false) {
			alert2.setTitle("ȸ������");
    		alert2.setHeaderText("���̵� �ߺ�üũ�� �ϼ���.");
    		alert2.setContentText("Ȯ��");
    		alert2.showAndWait();
    		txtid.requestFocus();
    		return;
		}
		
		if (pw.equals("")) {
			alert2.setTitle("ȸ������");
    		alert2.setHeaderText("��й�ȣ�� �Է��ϼ���");
    		alert2.setContentText("Ȯ��");
    		alert2.showAndWait();
    		txtpw.requestFocus();
    		return;
		}
		if(!passMatcher1.find()){
			alert2.setTitle("ȸ������");
    		alert2.setHeaderText("��й�ȣ�� ������ Ư������ ���ڸ� �����ϸ� 8�� �̻��̾�� �մϴ�.");
    		alert2.setContentText("Ȯ��");
    		alert2.showAndWait();
    		txtpw.requestFocus();
			return;
		}
		if(passMatcher2.find()){
			alert2.setTitle("ȸ������");
    		alert2.setHeaderText("��й�ȣ�� ������ ���ڸ� �����ϰ� �����ؼ� ����� �� �����ϴ�.");
    		alert2.setContentText("Ȯ��");
    		alert2.showAndWait();
    		txtpw.requestFocus();
			return;
		}
		if(pw.contains(id)){
		    alert2.setTitle("ȸ������");
    		alert2.setHeaderText("��й�ȣ�� ���̵� ���ԵǾ��ֽ��ϴ�.");
    		alert2.setContentText("Ȯ��");
    		alert2.showAndWait();
    		txtpw.requestFocus();
		    return;
		}
		if(pw.contains(" ")){
		    alert2.setTitle("ȸ������");
    		alert2.setHeaderText("��й�ȣ�� ������ ���ԵǾ��ֽ��ϴ�.");
    		alert2.setContentText("Ȯ��");
    		alert2.showAndWait();
    		txtpw.requestFocus();
		    return;
		}
		
		if(pwcheck.equals("")) {
			alert2.setTitle("ȸ������");
    		alert2.setHeaderText("��й�ȣ�� ���Է����ּ���.");
    		alert2.setContentText("Ȯ��");
    		alert2.showAndWait();
    		txtpwconfirm.requestFocus();
		}
		if(!pw.equals(pwcheck)) {
			alert2.setTitle("ȸ������");
    		alert2.setHeaderText("��й�ȣ�� �ٸ��ϴ�.");
    		alert2.setContentText("Ȯ��");
    		alert2.showAndWait();
    		txtpw.requestFocus();
		    return;
		}
		
		String regExp_symbol = "(.*[!,@,#,^,&,*,(,)])|([!,@,#,^,&,*,(,)].*)";
		Pattern pattern_symbol = Pattern.compile(regExp_symbol);
		Matcher matcher_symbol = pattern_symbol.matcher(name);
		
		if(name.equals("")) {
			alert2.setTitle("ȸ������");
    		alert2.setHeaderText("�̸��� �Է����ּ���.");
    		alert2.setContentText("Ȯ��");
    		alert2.showAndWait();
    		txtname.requestFocus();
    		return;
		}
		if(matcher_symbol.find()){
			alert2.setTitle("ȸ������");
    		alert2.setHeaderText("�̸��� Ư�����ڸ� �����Ҽ� �����ϴ�.");
    		alert2.setContentText("Ȯ��");
    		alert2.showAndWait();
    		txtname.requestFocus();
    		return;
		}
		if(name.contains(" ")){
		    alert2.setTitle("ȸ������");
    		alert2.setHeaderText("�̸��� ������ ���ԵǾ��ֽ��ϴ�.");
    		alert2.setContentText("Ȯ��");
    		alert2.showAndWait();
    		txtname.requestFocus();
    		return;
		}
		
		Pattern pattern = Pattern.compile("\\d{3}-\\d{4}-\\d{4}");
		Matcher matcher = pattern.matcher(phone);
		
		if(phone.contains("-")) {
			if(phone.length() == 13) {}
			else {
				alert2.setTitle("ȸ������");
	    		alert2.setHeaderText("�ùٸ��� ���� ��ȭ��ȣ �����Դϴ�.");
	    		alert2.setContentText("Ȯ��");
	    		alert2.showAndWait();
	    		txtphone.requestFocus();
	    		return;
			}
		}
		else {
			if(phone.length() == 11) {}
			else {
				alert2.setTitle("ȸ������");
	    		alert2.setHeaderText("�ùٸ��� ���� ��ȭ��ȣ �����Դϴ�.");
	    		alert2.setContentText("Ȯ��");
	    		alert2.showAndWait();
	    		txtphone.requestFocus();
	    		return;
			}
		}
		if (matcher.matches()) {
	    } 
	    else if(!matcher.matches() &&  phone.length() == 11){
	    	String str1 = phone.substring(0, 3);
            String str2 = phone.substring(3, 7);
            String str3 = phone.substring(7, 11);
            phone = str1+"-"+str2+"-"+str3;
            txtphone.setText(phone);
	    }
    	
		if(email.equals("")) {
			alert2.setTitle("ȸ������");
    		alert2.setHeaderText("�̸����� �Է����ּ���.");
    		alert2.setContentText("Ȯ��");
    		alert2.showAndWait();
    		txtemail.requestFocus();
    		return;
		}
		if(email.indexOf("@") == -1) {
			alert2.setTitle("ȸ������");
    		alert2.setHeaderText("�ùٸ��� �ʴ� �̸��� �����Դϴ�.");
    		alert2.setContentText("Ȯ��");
    		alert2.showAndWait();
    		txtemail.requestFocus();
    		return;
    	}
		
		if(address.equals("")) {
			alert2.setTitle("ȸ������");
    		alert2.setHeaderText("�ּҸ� �Է����ּ���.");
    		alert2.setContentText("Ȯ��");
    		alert2.showAndWait();
    		txtaddress.requestFocus();
    		return;
		}
		if(!address.contains("��") && ( address.contains("��") || address.contains("��"))) {
			alert2.setTitle("ȸ������");
    		alert2.setHeaderText("�ÿ� ���� �Է����ּ��� ( ���θ��� \'��\'�� ���Խ����ּ���");
    		alert2.setContentText("Ȯ��");
    		alert2.showAndWait();
    		txtaddress.requestFocus();
    		return;
    	}
		
    }
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {	
		
	}
}

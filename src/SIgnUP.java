import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.event.ActionEvent;

import java.sql.Connection;
import java.util.List;

import com.sun.rowset.internal.InsertRow;

import database.DataSource;
import database.Database;
import javafx.application.Application;
import javafx.stage.Stage;
import struct.User;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
public class SIgnUP extends Application implements EventHandler<ActionEvent>{
     Button Submit;
     Stage window;
     Scene signupterface;
     TextField userName=new TextField();;
     TextField password=new TextField();;
     TextField confPassword=new TextField();
     DataSource db=new DataSource("com.mysql.jdbc.Driver", "jdbc:mysql://localhost:3306/compilerDB", "root", "abdel");
     Connection conn;
	 @Override
	 public void start(Stage primaryStage) throws Exception{
		 window =primaryStage;
		 window.setTitle("Sign Up");
		 Submit = new Button("Submit");
		 Submit.setOnAction(this);
		 userName.setPromptText("username");
		 password.setPromptText("password");
		 Label usr=new Label("User Name");
		 Label passrd=new Label("password");
		 Label confpassrd=new Label("Confirm password");
		 VBox layout = new VBox();
		 layout.setAlignment(Pos.CENTER); 
		 layout.getChildren().addAll(usr,userName,passrd,password,confpassrd,confPassword,Submit);
		 signupterface=new Scene(layout,500,500);
		 window.setScene(signupterface);
		 window.show();
		 
	 }
	 @Override
	 public void handle(ActionEvent event){
		if(event.getSource()==Submit){
			try{
				conn=db.getConnection();
		 }catch(Exception e){
				System.out.println(e);
			}
			
			User user=new User();
			Database data=new Database(db);
			data.setDb(conn);
			if ((password.getText().compareTo(confPassword.getText()))!=0)
				System.out.println("Error2");
			
			else {
			List<Object> list = data.selectAll(user);
			System.out.println(list);
			int id;
			if (list == null){
				id=0;
			}
			else {id=list.size();}
			System.out.println(id);
			user=new User(userName.getText(),password.getText(),id);
			data.insert(user);
			//window.show();
			}
		}
		
		 
	 }
}
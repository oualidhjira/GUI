
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.event.ActionEvent;
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
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.List;
public class Login extends Application implements EventHandler<ActionEvent>{
     Button login;
     Stage window;
     Button signup;
     Scene loginterface;
     TextField text=new TextField();
     TextField pass=new TextField();
     DataSource db=new DataSource("com.mysql.jdbc.Driver", "jdbc:mysql://localhost:3306/compilerDB", "root", "abdel");
	 Connection conn;	
	 public static void main(String[] args){
		 
		 launch(args);
	 }
	 @Override
	 public void start(Stage primaryStage) throws Exception{
		
		 window =primaryStage;
		 window.setTitle("test");
		 login = new Button("login");
		 login.setOnAction(this);
		 signup = new Button("sign up");
		 signup.setOnAction(this); 
		 text.setPromptText("username");
		 pass.setPromptText("password");
		 Label log=new Label("login");
		 Label passrd=new Label("password");
		 GridPane grid=new GridPane();
		 grid.setPadding(new Insets(100,10,100,10));
		 grid.setVgap(10);
		 grid.setHgap(10);
		 grid.setConstraints(log,0,6);
		 grid.setConstraints(passrd,0,7);
		 grid.setConstraints(text,1,6);
		 grid.setConstraints(pass,1,7);
		 grid.setConstraints(login,1,8);
		 grid.setConstraints(signup,2,8);
		 grid.getChildren().addAll(login,signup,log,passrd,text,pass);
		 loginterface=new Scene(grid,500,500);
		 window.setScene(loginterface);
		 window.show();
		 
	 }
	 @Override
	 public void handle(ActionEvent event){
		if(event.getSource()==login){
			try{
				conn=db.getConnection();
		 }catch(Exception e){
				System.out.println(e);
			}
			Database data=new Database(db);
			User user=new User(text.getText(),pass.getText(),0);
			System.out.println(user.toString());
			System.out.println(user.getIdUser());
			if (data.select(user)!=null){
			Tenant tenant=new Tenant();
			try {
				tenant.start(window);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			}
			else System.out.println("Error");
		}
		if(event.getSource()==signup){
			SIgnUP s=new SIgnUP();
			try {
				s.start(window);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		}
		 
	 }
}



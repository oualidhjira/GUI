
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.event.ActionEvent;
import com.sun.rowset.internal.InsertRow;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
public class Tenant extends Application implements EventHandler<ActionEvent>{
     Button Add;
     Button AddSwitch;
     Stage window;
     Scene Tenantterface;
     TextField controller;
     ListView<String> Switchs;
	 @Override
	 public void start(Stage primaryStage) throws Exception{
		 window =primaryStage;
		 window.setTitle("Tenant");
		 Add = new Button("Add");
		 Add.setOnAction(this);
		 AddSwitch = new Button("AddSwitch");
		 Add.setOnAction(this);
		 controller =new TextField();
		 controller.setPromptText("IPAddress:tcp");
		 Label cont=new Label("Controller IP:TCP");
		 GridPane grid=new GridPane();
		 grid.setPadding(new Insets(100,10,100,10));
		 grid.setVgap(10);
		 grid.setHgap(10);
		 grid.setConstraints(controller,1,0);
		 grid.setConstraints(cont,0,0);
		 grid.setConstraints(Add,10,5);
		 grid.setConstraints(AddSwitch,4,4);
		 grid.getChildren().addAll(controller,cont,Add,AddSwitch);

		 Tenantterface=new Scene(grid,500,500);
		 window.setScene(Tenantterface);
		 window.show();
		 
	 }
	 @Override
	 public void handle(ActionEvent event){
		if(event.getSource()==Add){
			
			
			//window.show();
			
		}
		
		 
	 }
}
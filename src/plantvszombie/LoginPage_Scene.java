/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package plantvszombie;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.Border;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

/**
 *
 * @author DELL
 */
public class LoginPage_Scene extends Scene {
    
    public LoginPage_Scene(StackPane root, double d, double d1) {
        super(root, d, d1);
        //////////////////////////////////////////////////////////////////////////////////////////////////////////
        Load_Images.LoginPage_Scene_Images();
        ImageView background = new ImageView(Load_Images.images.get(0)); 
        //////////////////////////////////////////////////////////////////////////////////////////////////////////       
        Rectangle rectangle = new Rectangle (350,300,Color.WHITE);
        rectangle.setArcHeight(30);  
        rectangle.setArcWidth(30);     
        rectangle.setOpacity(0.85);
        //////////////////////////////////////////////////////////////////////////////////////////////////////////             
        GridPane grid = new GridPane();
        grid.setHgap(10);
        grid.setVgap(20);
        grid.setAlignment(Pos.CENTER);      
        //////////////////////////////////////////////////////////////////////////////////////////////////////////       
        Label Login = new Label("Log in");
        Login.setFont(Font.font("Tahoma",FontWeight.BOLD,40));     
        root.setMargin(Login, new Insets(0,0,250,0));
        //////////////////////////////////////////////////////////////////////////////////////////////////////////       
        Label wrongUsernameOrPassword = new Label("Wrong Username Or Password");
        wrongUsernameOrPassword.setTextFill(Color.RED);
        wrongUsernameOrPassword.setVisible(false);
        grid.add(wrongUsernameOrPassword, 1, 0);
        //////////////////////////////////////////////////////////////////////////////////////////////////////////       
        Label userName = new Label("User Name:");
        grid.add(userName, 0, 1);
        //////////////////////////////////////////////////////////////////////////////////////////////////////////           
        TextField userNameField = new TextField();
        grid.add(userNameField,1,1);
        //////////////////////////////////////////////////////////////////////////////////////////////////////////           
        Label password = new Label("  Password:");
        grid.add(password ,0,2);
        //////////////////////////////////////////////////////////////////////////////////////////////////////////           
        TextField temp = new TextField();
        grid.add(temp,1,2);
        //////////////////////////////////////////////////////////////////////////////////////////////////////////           
        PasswordField passwordField = new PasswordField();
        grid.add(passwordField,1,2);
        //////////////////////////////////////////////////////////////////////////////////////////////////////////                   
        ImageView openEye = new ImageView(Load_Images.images.get(1));
        ImageView closeEye = new ImageView(Load_Images.images.get(2));
        Button eye = new Button("" ,openEye);
        eye.setBorder(Border.EMPTY);
        eye.setBackground(Background.EMPTY);
        eye.setOnMouseClicked((t) -> {
            if(eye.getGraphic() == openEye){
                temp.setText(passwordField.getText());
                passwordField.setVisible(false);
                eye.setGraphic(closeEye);
            }else{
                passwordField.setText(temp.getText());
                passwordField.setVisible(true);
                eye.setGraphic(openEye);
            }  
        });
        grid.add(eye,2,2);
        //////////////////////////////////////////////////////////////////////////////////////////////////////////                    
        Button login = new Button("Log in");
        login.setOnAction((t) -> {            
            boolean found = false;
            File file = new File("PlayersData.txt");
            ArrayList<Player> Players = new ArrayList<Player>() ;

            try{
                if(file.exists()){
                    ObjectInputStream ifstream = new ObjectInputStream(new FileInputStream(file));
                    Players = (ArrayList<Player>)ifstream.readObject();
                    ifstream.close();
                    for (Player p : Players) {
                        if(userNameField.getText().equals(p.getUserName()) && (passwordField.getText().equals(p.getPassword()) || temp.getText().equals(p.getPassword()))){
                            PlantVsZombie.stage.setScene(new MainMenu_Scene(new StackPane(), 1000,720,p));//nada
                            PlantVsZombie.stage.centerOnScreen();
                            found = true;
                        }
                    }
                }
                if(!found)
                    wrongUsernameOrPassword.setVisible(true);
            }catch(IOException | ClassNotFoundException ex){
                System.out.println(ex);    
            }
        });
        grid.add(login,2,3);
        //////////////////////////////////////////////////////////////////////////////////////////////////////////                   
        Label CreateAccount = new Label("Create Account"); 
        CreateAccount.setTextFill(Color.BLUE);
        CreateAccount.setUnderline(true);
        CreateAccount.setOnMouseEntered((t) -> {
            CreateAccount.setTextFill(Color.GRAY);
        });
        CreateAccount.setOnMouseExited((t) -> {
            CreateAccount.setTextFill(Color.BLUE);
        });
        CreateAccount.setOnMouseClicked((t) -> {
            PlantVsZombie.stage.setScene(new RegisterPage_Scene(new HBox(), 600,500));
        });
        //////////////////////////////////////////////////////////////////////////////////////////////////////////                      
        Label forgetPassword = new Label("Forget Password"); 
        forgetPassword.setTextFill(Color.BLUE);
        forgetPassword.setUnderline(true);
        forgetPassword.setOnMouseEntered((t) -> {
            forgetPassword.setTextFill(Color.GRAY);
        });
        forgetPassword.setOnMouseExited((t) -> {
            forgetPassword.setTextFill(Color.BLUE);
        });
        forgetPassword.setOnMouseClicked((t) -> {
            Stage forgetpassword = new Stage();
            forgetpassword.setTitle("Forget Password");
            forgetpassword.getIcons().add(new Image("C:\\Users\\DELL\\Documents\\NetBeansProjects\\PlantVsZombie\\images\\icon.png"));
            forgetpassword.setScene(new ForgetPassword_Part1_Scene(new VBox(), 320,200 ,forgetpassword));
            forgetpassword.setX(350);
            forgetpassword.setY(250);
            forgetpassword.setResizable(false);
            forgetpassword.show();
        });
        //////////////////////////////////////////////////////////////////////////////////////////////////////////                       
        HBox hbox = new HBox();
        hbox.setSpacing(140);
        hbox.getChildren().addAll(forgetPassword,CreateAccount);
        //////////////////////////////////////////////////////////////////////////////////////////////////////////                      
        grid.add(hbox,0,4,4,1);
        root.getChildren().addAll(background,rectangle,grid,Login);     
    }   
}

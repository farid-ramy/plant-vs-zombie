/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package plantvszombie;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.time.LocalDate;
import java.util.ArrayList;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.TextInputControl;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.util.Duration;

/**
 *
 * @author DELL
 */
public class RegisterPage_Scene extends Scene{
    
    private ImageView background = new ImageView();
    private TextField firstNameField ,middleNameField ,lastNameField ,emailField ,userNameField ,passwordField;
    private PasswordField cpasswordfield;
    private Button register , Cancel;
    private RadioButton male,female;
    private DatePicker datepicker;
    private Label error;
    private int index = 0;
    
    private void ImageTransition(){ 
        Load_Images.RegisterPage_Secene_Images();
        background.setImage(Load_Images.images.get(0));
           
        Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(2.5),e -> {
            index++;
            if(index == 10)
                index=0;
            background.setImage(Load_Images.images.get(index));
        }));
        timeline.setCycleCount(Animation.INDEFINITE);
        timeline.play();
    }
    
    private Label createStar(double x , double y){
        Label label = new Label("*");
        label.setFont(Font.font(18)); 
        label.setTextFill(Color.RED);
        label.setLayoutX(x);
        label.setLayoutY(y);
        return label ;
    }
    
    public RegisterPage_Scene(HBox hbox, double d, double d1) {
        super(hbox, d, d1);
        ImageTransition();                     
        //////////////////////////////////////////////////////////////////////////////////////////////////////////                      
        VBox vbox = new VBox();
        vbox.setPrefWidth(275);
        vbox.setSpacing(10);
        vbox.setPadding(new Insets(0,0,0,25));
        vbox.setAlignment(Pos.TOP_CENTER);
        //////////////////////////////////////////////////////////////////////////////////////////////////////////                      
        ///// Stars
        Pane pane = new Pane();
        Label L1 = createStar(100, 55);
        Label L2 = createStar(93, 272);
        Label L3 = createStar(88, 310);
        Label L4 = createStar(86, 352);
        pane.getChildren().addAll(L1,L2,L3,L4);
        
        StackPane stack = new StackPane();
        stack.getChildren().addAll(pane,vbox);
        hbox.getChildren().addAll(background,stack);
        //////////////////////////////////////////////////////////////////////////////////////////////////////////                       
        Label Register = new Label("Register");
        Register.setFont(Font.font("Tahoma",FontWeight.BOLD,40));     
        //////////////////////////////////////////////////////////////////////////////////////////////////////////                       
        HBox hbox1 = new HBox();
        hbox1.setSpacing(10);
        Label firstName = new Label("First name:");
        firstName.setFont(Font.font(16));  
        firstNameField = new TextField();
        hbox1.getChildren().addAll(firstName,firstNameField);
        //////////////////////////////////////////////////////////////////////////////////////////////////////////                       
        HBox hbox2 = new HBox();
        hbox2.setSpacing(10);
        Label middleName = new Label("Middle name:");
        middleName.setFont(Font.font(15)); 
        middleNameField = new TextField();
        middleNameField.setPrefWidth(135);
        hbox2.getChildren().addAll(middleName,middleNameField);
        //////////////////////////////////////////////////////////////////////////////////////////////////////////                       
        HBox hbox3 = new HBox();
        hbox3.setSpacing(17);
        Label lastName = new Label("Last name:");
        lastName.setFont(Font.font(15)); 
        lastNameField = new TextField();
        hbox3.getChildren().addAll(lastName,lastNameField);
        //////////////////////////////////////////////////////////////////////////////////////////////////////////                       
        HBox hbox4= new HBox();
        hbox4.setSpacing(32);
        Label Birthday = new Label("Birthday:");
        Birthday.setFont(Font.font(14)); 
        datepicker = new DatePicker(LocalDate.of(2003, 12, 22));  
        datepicker.setPrefWidth(150);
        hbox4.getChildren().addAll( Birthday,datepicker);
        //////////////////////////////////////////////////////////////////////////////////////////////////////////                       
        HBox hbox5= new HBox();
        hbox5.setPadding(new Insets(0,0,0,30));
        hbox5.setSpacing(50);
        male = new RadioButton("Male");
        male.setSelected(true);    
        female = new RadioButton("Female");   
        hbox5.getChildren().addAll(male,female);
        ToggleGroup gender = new ToggleGroup();
        gender.getToggles().addAll(male,female);
        //////////////////////////////////////////////////////////////////////////////////////////////////////////                       
        HBox hbox6= new HBox();
        hbox6.setSpacing(10);
        Label email = new Label("Email:");
        email.setFont(Font.font(14)); 
        emailField = new TextField();
        emailField.setPromptText("  example@miuegypt.edu.eg");    
        emailField.setPrefWidth(190);
        hbox6.getChildren().addAll( email,emailField);
        //////////////////////////////////////////////////////////////////////////////////////////////////////////                       
        HBox hbox7= new HBox();
        vbox.setMargin(hbox7,new Insets(10,0,0,0));
        hbox7.setSpacing(10);
        Label userName = new Label("UserName:");
        userName.setFont(Font.font(14)); 
        userNameField = new TextField();  
        hbox7.getChildren().addAll( userName,userNameField);
        //////////////////////////////////////////////////////////////////////////////////////////////////////////                       
        HBox hbox8= new HBox();
        hbox8.setSpacing(16);
        Label password = new Label("Password:");
        password.setFont(Font.font(14)); 
        passwordField = new PasswordField();   
        hbox8.getChildren().addAll( password,passwordField);
        //////////////////////////////////////////////////////////////////////////////////////////////////////////                       
        HBox hbox9= new HBox();
        vbox.setMargin(hbox9,new Insets(10,0,0,0));
        hbox9.setSpacing(15);
        Label cpassword = new Label("Confirm\nPassword:");
        cpassword.setTranslateY(-20);
        cpassword.setFont(Font.font(14)); 
        cpasswordfield = new PasswordField();   
        hbox9.getChildren().addAll( cpassword, cpasswordfield);
        //////////////////////////////////////////////////////////////////////////////////////////////////////////                       
        error = new Label("");
        error.setFont(Font.font(11)); 
        error.setTextFill(Color.RED);
        error.setVisible(false);
        //////////////////////////////////////////////////////////////////////////////////////////////////////////                       
        HBox hbox10= new HBox();
        hbox10.setPadding(new Insets(0,0,0,30));
        hbox10.setSpacing(50);
        register = new Button("Register");
        register.setOnAction(new actions());
        Cancel = new Button("Cancel");
        Cancel.setOnAction(new actions());
        hbox10.getChildren().addAll(register,Cancel);
        //////////////////////////////////////////////////////////////////////////////////////////////////////////                       
        Label AlreadyHaveAccount = new Label("Already have an account");
        AlreadyHaveAccount.setFont(Font.font(10)); 
        AlreadyHaveAccount.setTextFill(Color.BLUE);
        AlreadyHaveAccount.setUnderline(true);
        AlreadyHaveAccount.setOnMouseClicked((t) -> {
            PlantVsZombie.stage.setScene(new LoginPage_Scene(new StackPane(), 600,500));
        });
        AlreadyHaveAccount.setOnMouseEntered((t) -> {
            AlreadyHaveAccount.setTextFill(Color.GRAY);
        });
        AlreadyHaveAccount.setOnMouseExited((t) -> {
            AlreadyHaveAccount.setTextFill(Color.BLUE);
        });
        //////////////////////////////////////////////////////////////////////////////////////////////////////////                       
        vbox.getChildren().addAll(Register,hbox1,hbox2,
                                     hbox3,hbox4,hbox5,
                                     hbox6,hbox7,hbox8,
                                     hbox9,error, hbox10,
                                     AlreadyHaveAccount);  
    }
   
    class actions implements EventHandler<ActionEvent>{
        
        private boolean tmm;
        
        private void setBorderAndError(TextInputControl x){
            String style = "-fx-border-width: 1px;" + "-fx-border-color:transparent transparent red transparent";
            
            if(x == firstNameField)
                error.setText("Please enter a first name");
            else if(x == userNameField)
                error.setText("Please enter a user name");
            else if(x == passwordField)
                error.setText("Please enter a Password");
            else if(x == cpasswordfield)
                error.setText("Please enter a confirm password");
            else{
                error.setText("Passswords are not the same");
                passwordField.setStyle(style);
                cpasswordfield.setStyle(style);
            }
            
            tmm = false;
            x.setStyle(style);
            error.setVisible(true);
        }
        
        @Override
        public void handle(ActionEvent t) {
            tmm =true;
            if(t.getSource() == Cancel)
                System.exit(0);
            
            not_equal:{
                if(!passwordField.getText().equals(cpasswordfield.getText()) && cpasswordfield.getText() != "" && passwordField.getText() != ""){
                   setBorderAndError(new TextField());
                   break not_equal;
                }else{
                    passwordField.setStyle("-fx-border:none;");
                    cpasswordfield.setStyle("-fx-border:none;");
                }
                
                if(cpasswordfield.getText() == "")
                    setBorderAndError(cpasswordfield);
                else
                    cpasswordfield.setStyle("-fx-border:none;");
                
                if(passwordField.getText() == "")
                    setBorderAndError(passwordField);
                else
                    passwordField.setStyle("-fx-border:none;");
            }
            
            if(userNameField.getText() == "")
                setBorderAndError(userNameField);
            else
                userNameField.setStyle("-fx-border:none;");
            
            if(firstNameField.getText() == "")
                setBorderAndError(firstNameField);
            else
                firstNameField.setStyle("-fx-border:none;");
            
            if(tmm){
                boolean found =false;
                error.setText("");
                File file = new File("PlayersData.txt");
                ArrayList<Player> Players = new ArrayList<Player>() ; 
                try{
                    if(file.exists()){
                        ObjectInputStream ifstream = new ObjectInputStream(new FileInputStream(file));
                        Players = (ArrayList<Player>)ifstream.readObject();
                        ifstream.close();

                        for (Player p : Players) {
                            if(p.getUserName().equals(userNameField.getText())){
                                error.setText("User name is taken");
                                userNameField.setStyle("-fx-border-width: 1px;" + "-fx-border-color:transparent transparent red transparent");
                                error.setVisible(true);
                                found = true;
                            }
                            if(p.getEmail().equals(emailField.getText()) && !p.getEmail().equals("")){
                                error.setText("Email is taken");
                                emailField.setStyle("-fx-border-width: 1px;" + "-fx-border-color:transparent transparent red transparent");
                                error.setVisible(true);
                                found = true;
                            }
                        }
                    }
                    if(!found){
                        ObjectOutputStream ofstream = new ObjectOutputStream(new FileOutputStream(file));
                        Player p = new Player(firstNameField.getText(),middleNameField.getText(),lastNameField.getText(),datepicker.getValue(),male.isSelected(),emailField.getText(),userNameField.getText(),passwordField.getText());
                        Players.add(p);
                        ofstream.writeObject(Players);
                        System.out.println(p);
                        ofstream.close();  
                        PlantVsZombie.stage.setScene(new MainMenu_Scene(new StackPane(), 1000,720,p));
                        PlantVsZombie.stage.centerOnScreen();
                    } 
                }catch(IOException ex){
                    System.out.println(ex);
                }catch(ClassNotFoundException ex){
                    System.out.println(ex);
                }  
            }
        }
    } 
}




 
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
import java.util.Random;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;


/**
 *
 * @author DELL
 */
public class ForgetPassword_Part1_Scene extends Scene{
    
    private int securityCode ;
    private String userEmail;
    
    public ForgetPassword_Part1_Scene(VBox vbox, double d, double d1 ,Stage forgetpassword) {
        super(vbox, d, d1);
        vbox.setAlignment(Pos.CENTER);
        //////////////////////////////////////////////////////////////////////////////////////////////////////////                      
        Label error = new Label();
        error.setVisible(false);
        //////////////////////////////////////////////////////////////////////////////////////////////////////////                      
        TextField email = new TextField();
        email.setPrefWidth(215);
        email.setFocusTraversable(false);
        email.setPromptText("Enter your Email");
        //////////////////////////////////////////////////////////////////////////////////////////////////////////                      
        Button sendCode = new Button("Send Code");
        //////////////////////////////////////////////////////////////////////////////////////////////////////////                         
        HBox hbox1 = new HBox();
        hbox1.setSpacing(10);
        hbox1.setPadding(new Insets(10));
        hbox1.getChildren().addAll(email ,sendCode);
        //////////////////////////////////////////////////////////////////////////////////////////////////////////                     
        TextField number = new TextField();
        //////////////////////////////////////////////////////////////////////////////////////////////////////////                     
        Button submit = new Button("Submit");
        //////////////////////////////////////////////////////////////////////////////////////////////////////////                        
        HBox hbox2 = new HBox(); 
        hbox2.setSpacing(5);
        hbox2.setPadding(new Insets(10));
        hbox2.getChildren().addAll(number ,submit);
        hbox2.setVisible(false);
        //////////////////////////////////////////////////////////////////////////////////////////////////////////                        
        Label errorSubmit = new Label("incorrect");
        errorSubmit.setTextFill(Color.RED);
        errorSubmit.setVisible(false);
        //////////////////////////////////////////////////////////////////////////////////////////////////////////                        
        vbox.getChildren().addAll(error,hbox1 ,hbox2,errorSubmit);
        //////////////////////////////////////////////////////////////////////////////////////////////////////////                        
        sendCode.setOnMouseClicked((t) -> {
            boolean found =false;
                    File file = new File("PlayersData.txt");
                    ArrayList<Player> Players = new ArrayList<Player>() ; 
                    try{
                        if(file.exists()){
                            ObjectInputStream ifstream = new ObjectInputStream(new FileInputStream(file));
                            Players = (ArrayList<Player>)ifstream.readObject();
                            ifstream.close();

                            for (Player p : Players) {
                                if(p.getEmail().equals(email.getText()) && !p.getEmail().equals("")){
                                    error.setText("Sent Successfully");
                                    error.setTextFill(Color.GREEN);
                                    error.setVisible(true);
                                    userEmail = email.getText();
                                    hbox2.setVisible(true);
                                    Random rand = new Random();
                                    securityCode = rand.nextInt(9999999 - 1000000) + 1000000 ;
                                    SendEmail mail = new SendEmail(email.getText(), "Forget Password", " Dear dr wala , Best Dr ever , We love you so much Your security Code is " + securityCode + " for the best game project ever you have ever seen in your life . We wish get 100/15 . have a nice day");
                                    found = true;
                                }
                            }
                        }
                        if(!found){
                            error.setText("Email not found");
                            error.setTextFill(Color.RED);
                            error.setVisible(true);
                        }
                    }catch(IOException ex){
                        System.out.println(ex);
                    }catch(ClassNotFoundException ex){
                        System.out.println(ex);
                    }  
        });
        //////////////////////////////////////////////////////////////////////////////////////////////////////////                           
        submit.setOnMouseClicked((t) -> {
            if(number.getText().equals(Integer.toString(securityCode))){
                forgetpassword.setScene(new ForgetPassword_Part2_Scene(new GridPane(), 320,200 ,userEmail ,forgetpassword));
            }else{
                errorSubmit.setVisible(true);
            }
        });
        //////////////////////////////////////////////////////////////////////////////////////////////////////////                           
    }    
}

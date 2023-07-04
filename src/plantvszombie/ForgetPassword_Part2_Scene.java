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
import java.util.ArrayList;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
/**
 *
 * @author DELL
 */
public class ForgetPassword_Part2_Scene extends Scene{
    
    public ForgetPassword_Part2_Scene(GridPane root, double d, double d1 , String userEmail, Stage stage) {
        super(root, d, d1);
        
        root.setHgap(10);
        root.setVgap(20);
        root.setAlignment(Pos.CENTER);      
        //////////////////////////////////////////////////////////////////////////////////////////////////////////                       
        Label Passwordarenotsame = new Label("Password are not same");
        Passwordarenotsame.setTextFill(Color.RED);
        Passwordarenotsame.setVisible(false);
        root.add(Passwordarenotsame, 1, 0);
        //////////////////////////////////////////////////////////////////////////////////////////////////////////                              
        Label newPasssword = new Label("New Passsword: ");
        root.add(newPasssword, 0, 1);
        PasswordField newPassswordField = new PasswordField();
        root.add(newPassswordField,1,1);
        //////////////////////////////////////////////////////////////////////////////////////////////////////////                       
        Label ConfirmnewPassword = new Label("Confirm \nnew Password:");
        root.add(ConfirmnewPassword ,0,2);
        PasswordField ConfirmnewPasswordField = new PasswordField();
        root.add(ConfirmnewPasswordField,1,2);
        //////////////////////////////////////////////////////////////////////////////////////////////////////////                              
        Button Update = new Button("Update");
        Update.setOnAction((t) -> { 
            if(ConfirmnewPasswordField.getText().equals(newPassswordField.getText())){
                Passwordarenotsame.setText("Done");
                Passwordarenotsame.setTextFill(Color.GREEN);
                Passwordarenotsame.setVisible(true);
                
                try{
                    File file = new File("PlayersData.txt");
                    ArrayList<Player> Players = new ArrayList<Player>() ;
                    ObjectInputStream ifstream = new ObjectInputStream(new FileInputStream(file));
                    Players = (ArrayList<Player>)ifstream.readObject();
                    ifstream.close();
                    for (Player p : Players ) {
                        if(p.getEmail().equals(userEmail)){
                            Players.remove(p);
                            p.setPassword(newPassswordField.getText());
                            Players.add(p);
                            ObjectOutputStream ofstream = new ObjectOutputStream(new FileOutputStream(file));
                            ofstream.writeObject(Players);
                            ofstream.close();
                            stage.close();
                            break;
                        }
                    }
                }catch(IOException ex){
                    System.out.println(ex);
                }catch(ClassNotFoundException ex){
                    System.out.println(ex);
                } 
            }else{
                Passwordarenotsame.setText("Password are not same");
                Passwordarenotsame.setTextFill(Color.RED);
                Passwordarenotsame.setVisible(true);
            }      
        });      
        root.add(Update,1,3);
    }
    
}

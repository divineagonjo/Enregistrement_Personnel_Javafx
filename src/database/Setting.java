/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 *
 * @author User
 */
public class Setting {

    String color1 = "#3497fc";
public static String id="";
public static String table="";
    public Setting() {
    }

    public  void gotoScene(String path, Node node) {
        try {
            AnchorPane loader = FXMLLoader.load(getClass().getResource("/vue/" + path + ".fxml"));

            Scene scene = new Scene(loader);
            Stage s = new Stage();
            s.setScene(scene);
            s.show();
            Stage stage = (Stage) node.getScene().getWindow();
            stage.close();
        } catch (Exception e) {
            System.out.println("error scene" + e);
        }
    }

    public void goto2(String path) {
        try {
            AnchorPane loader = FXMLLoader.load(getClass().getResource("/vue/" + path + ".fxml"));

            Scene scene = new Scene(loader);
            Stage s = new Stage();
            s.setScene(scene);
            s.show();

        } catch (Exception e) {
            System.out.println("error " + e);
        }
    }

    public void gotos(StackPane root, String path) {
        try {

            FXMLLoader fXMLLoader = new FXMLLoader();
            fXMLLoader.load(getClass().getResource("/vue/" + path + ".fxml").openStream());

            AnchorPane anchorPane = fXMLLoader.getRoot();
            root.getChildren().clear();

            root.getChildren().add(anchorPane);
        } catch (IOException ex) {
            System.err.println("error occured " + ex);
        }
    }

  
}

package com.internshala.Javafx;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import javax.swing.*;
import java.util.Optional;

public class MyMain extends Application {
	public static void main(String[] args){
		launch(args);
	}
	@Override
	public void start(Stage primaryStage) throws Exception {
		FXMLLoader loader = new
				FXMLLoader(getClass().getResource("app_layout.fxml"));
		VBox rootNode = loader.load();

		MenuBar menuBar=createMenu();
		rootNode.getChildren().add(0,menuBar);

		Scene scene = new Scene(rootNode);

		primaryStage.setScene(scene);
		primaryStage.setTitle("TEMPERATURE CONVERTER");
		primaryStage.show();
	}
	public MenuBar createMenu(){
		//File Menu
		Menu filemenu=new Menu("File");
		MenuItem newItem=new MenuItem("New");
		newItem.setOnAction(event -> System.out.println("New Clciked"));
		SeparatorMenuItem separatorMenuItem=new SeparatorMenuItem();
		MenuItem quitItem=new MenuItem("Quit");
		quitItem.setOnAction(event -> {
			Platform.exit();
			System.exit(0);
		});
		filemenu.getItems().addAll(newItem,separatorMenuItem,quitItem);
		//Help Menu
		Menu helpmenu=new Menu("Help");
		MenuItem aboutItem=new MenuItem("About");
		aboutItem.setOnAction(event -> aboutApp());
		helpmenu.getItems().addAll(aboutItem);
		MenuBar menuBar=new MenuBar();
		menuBar.getMenus().addAll(filemenu,helpmenu);
		return menuBar;
	}

	private void aboutApp() {
		Alert alertDialogue=new Alert(Alert.AlertType.INFORMATION);
		alertDialogue.setTitle("ABOUT");
		alertDialogue.setHeaderText("Learning");
		alertDialogue.setContentText("I am Developing Windows Java Apps");
		ButtonType yesbtn=new ButtonType("Yes");
		ButtonType nobtn=new ButtonType("No");
		alertDialogue.getButtonTypes().setAll(yesbtn,nobtn);
		Optional<ButtonType> clickedbtn=alertDialogue.showAndWait();
		if (clickedbtn.get() == yesbtn)
			System.out.println("Yes Button Clicked");
		else
			System.out.println("No Button Clicked");
	}
}

package com.borikov.laba5_2.app;

import com.borikov.laba5_2.service.QuestionnaireService;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class QuestionnaireApplication extends Application {
    private Button buttonAccept;
    private TextField nameField;
    private TextField surnameField;
    private RadioButton radioButton1;
    private RadioButton radioButton2;
    private RadioButton radioButton3;
    private ToggleGroup toggleGroup;
    private Label label1;
    private Label label2;
    private ListView<String> listView;

    @Override
    public void start(Stage stage) throws Exception {
        componentsInit();
        configureFont();
        buttonsAddListeners();
        configureAnchorPane();
        AnchorPane root = new AnchorPane(nameField, surnameField,
                label1, radioButton1, radioButton2,
                radioButton3, label2, listView, buttonAccept);
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("Questionnaire");
        stage.setWidth(300);
        stage.setHeight(280);
        stage.setResizable(false);
        stage.show();
    }

    private void componentsInit() {
        buttonAccept = new Button("Submit");
        nameField = new TextField();
        surnameField = new TextField();
        radioButton1 = new RadioButton("0-18");
        radioButton2 = new RadioButton("18-40");
        radioButton3 = new RadioButton("40-99");
        toggleGroup = new ToggleGroup();
        radioButton1.setToggleGroup(toggleGroup);
        radioButton2.setToggleGroup(toggleGroup);
        radioButton3.setToggleGroup(toggleGroup);
        label1 = new Label("Age");
        label2 = new Label("City");
        ObservableList<String> sites = FXCollections.observableArrayList(
                "Minsk", "Gomel", "Grodno", "Brest");
        listView = new ListView<>(sites);
    }

    private void configureFont() {
        Font font = new Font(15);
        buttonAccept.setFont(font);
        nameField.setFont(font);
        surnameField.setFont(font);
        radioButton1.setFont(font);
        radioButton2.setFont(font);
        radioButton3.setFont(font);
        label1.setFont(font);
        label2.setFont(font);
    }

    private void configureAnchorPane() {
        AnchorPane.setBottomAnchor(buttonAccept, 10.0);
        AnchorPane.setLeftAnchor(buttonAccept, 80.0);
        AnchorPane.setRightAnchor(buttonAccept, 80.0);
        AnchorPane.setTopAnchor(nameField, 10.0);
        AnchorPane.setLeftAnchor(nameField, 10.0);
        AnchorPane.setRightAnchor(nameField, 150.0);
        AnchorPane.setTopAnchor(surnameField, 10.0);
        AnchorPane.setLeftAnchor(surnameField, 150.0);
        AnchorPane.setRightAnchor(surnameField, 10.0);
        AnchorPane.setTopAnchor(label1, 60.0);
        AnchorPane.setLeftAnchor(label1, 10.0);
        AnchorPane.setRightAnchor(label1, 150.0);
        AnchorPane.setTopAnchor(radioButton1, 60.0);
        AnchorPane.setLeftAnchor(radioButton1, 50.0);
        AnchorPane.setTopAnchor(radioButton2, 60.0);
        AnchorPane.setLeftAnchor(radioButton2, 120.0);
        AnchorPane.setTopAnchor(radioButton3, 60.0);
        AnchorPane.setLeftAnchor(radioButton3, 195.0);
        AnchorPane.setTopAnchor(label2, 95.0);
        AnchorPane.setLeftAnchor(label2, 125.0);
        AnchorPane.setTopAnchor(listView, 120.0);
        AnchorPane.setBottomAnchor(listView, 60.0);
        AnchorPane.setLeftAnchor(listView, 60.0);
        AnchorPane.setRightAnchor(listView, 60.0);
    }

    private void buttonsAddListeners() {
        buttonAccept.setOnAction(actionEvent -> {
            Text text = new Text("Error");
            String name = String.valueOf(nameField.getCharacters());
            String surname = String.valueOf(surnameField.getCharacters());
            RadioButton currentRadioButton = (RadioButton) toggleGroup.getSelectedToggle();
            if (currentRadioButton != null) {
                String age = currentRadioButton.getText();
                String city = listView.getSelectionModel().getSelectedItem();
                QuestionnaireService questionnaireService = new QuestionnaireService();
                if (questionnaireService.saveQuestionnaire(name, surname, age, city)) {
                    text = new Text("Successfully");
                }
            }
            Stage stage = new Stage();
            text.setLayoutY(50);
            text.setLayoutX(70);
            Group group = new Group(text);
            Scene scene = new Scene(group);
            stage.setWidth(200);
            stage.setHeight(150);
            stage.setResizable(false);
            stage.show();
            stage.setScene(scene);
        });
    }
}

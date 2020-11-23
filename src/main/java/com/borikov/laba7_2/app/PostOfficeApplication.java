package com.borikov.laba7_2.app;

import com.borikov.laba7_2.entity.User;
import com.borikov.laba7_2.exception.ServiceException;
import com.borikov.laba7_2.service.LetterService;
import com.borikov.laba7_2.service.UserService;
import com.borikov.laba7_2.service.impl.LetterServiceImpl;
import com.borikov.laba7_2.service.impl.UserServiceImpl;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class PostOfficeApplication extends Application {
    private static final String USER_TEMPLATE = "id: %d, name: %s, surname: %s, patronymic: %s, birthday: %s";
    private static final String USER_LETTER_TEMPLATE = "id: %d, name: %s, surname: %s, patronymic: %s, birthday: %s, "
            + "amount of sent letters: %d,  amount of received letters: %d";
    private final Logger LOGGER = LogManager.getLogger();
    private final UserService userService = new UserServiceImpl();
    private final LetterService letterService = new LetterServiceImpl();
    private Button button1;
    private Button button2;
    private Button button3;
    private Button button4;
    private Button button5;
    private Label themeLabel;
    private TextField themeTextField;

    @Override
    public void start(Stage stage) {
        componentsInit();
        addButtonsListeners();
        VBox root = new VBox(button1, button2, themeLabel, themeTextField, button3, button4, button5);
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("Post office");
        stage.setWidth(500);
        stage.setHeight(210);
        stage.setResizable(false);
        stage.show();
    }

    private void componentsInit() {
        button1 = new Button("Пользователь, длина писем которого наименьшая");
        button2 = new Button("Информация о пользователях и количестве их писем");
        button3 = new Button("Информация о пользователях, которые получили письмо с заданной темой");
        button4 = new Button("Информацию о пользователях, которые не получали письмо с заданной темой");
        button5 = new Button("Отправить письмо заданного человека с заданной темой всем адресатам");
        themeLabel = new Label("Заданная тема:");
        themeTextField = new TextField();
        button1.setMaxWidth(500);
        button2.setMaxWidth(500);
        button3.setMaxWidth(500);
        button4.setMaxWidth(500);
        button5.setMaxWidth(500);
    }

    private void addButtonsListeners() {
        button1.setOnAction(actionEvent -> button1Action());
        button2.setOnAction(actionEvent -> button2Action());
        button3.setOnAction(actionEvent -> button3Action());
        button4.setOnAction(actionEvent -> button4Action());
        button5.setOnAction(actionEvent -> button5Action());
    }

    private void button1Action() {
        try {
            Optional<User> userOptional = userService.findUserByMinimumLetterSize();
            if (userOptional.isPresent()) {
                User user = userOptional.get();
                Stage stage = new Stage();
                Label idLabel = new Label("Id: " + user.getUserId());
                Label nameLabel = new Label("Name: " + user.getName());
                Label surnameLabel = new Label("Surname: " + user.getSurname());
                Label patronymicLabel = new Label("Patronymic: " + user.getPatronymic());
                Label birthdayLabel = new Label("Birthday: " + user.getBirthday());
                VBox root = new VBox(idLabel, nameLabel, surnameLabel, patronymicLabel, birthdayLabel);
                Scene scene = new Scene(root);
                stage.setWidth(200);
                stage.setHeight(250);
                stage.setResizable(false);
                stage.show();
                stage.setScene(scene);
            }
        } catch (ServiceException e) {
            LOGGER.log(Level.ERROR, "Error while finding user", e);
        }
    }

    private void button2Action() {
        try {
            List<User> users = userService.findAllUsers();
            ObservableList<String> userObservableList =
                    FXCollections.observableArrayList(makeRepresentationUserWithLetter(users));
            ListView<String> listViewUser = new ListView<>(userObservableList);
            Stage stage = new Stage();
            VBox root = new VBox(listViewUser);
            Scene scene = new Scene(root);
            stage.setWidth(800);
            stage.setHeight(300);
            stage.setResizable(false);
            stage.show();
            stage.setScene(scene);
        } catch (ServiceException e) {
            LOGGER.log(Level.ERROR, "Error while finding users or letters", e);
        }
    }

    private void button3Action() {
        try {
            String theme = themeTextField.getText();
            List<User> users = userService.findUsersByLetterTheme(theme);
            ObservableList<String> userObservableList =
                    FXCollections.observableArrayList(makeRepresentationUser(users));
            ListView<String> listViewUser = new ListView<>(userObservableList);
            Stage stage = new Stage();
            VBox root = new VBox(listViewUser);
            Scene scene = new Scene(root);
            stage.setWidth(500);
            stage.setHeight(400);
            stage.setResizable(false);
            stage.show();
            stage.setScene(scene);
        } catch (ServiceException e) {
            LOGGER.log(Level.ERROR, "Error while finding users", e);
        }
    }

    private void button4Action() {
        try {
            String theme = themeTextField.getText();
            List<User> users = userService.findUsersByLetterThemeAbsence(theme);
            ObservableList<String> userObservableList =
                    FXCollections.observableArrayList(makeRepresentationUser(users));
            ListView<String> listViewUser = new ListView<>(userObservableList);
            Stage stage = new Stage();
            VBox root = new VBox(listViewUser);
            Scene scene = new Scene(root);
            stage.setWidth(500);
            stage.setHeight(400);
            stage.setResizable(false);
            stage.show();
            stage.setScene(scene);
        } catch (ServiceException e) {
            LOGGER.log(Level.ERROR, "Error while finding users", e);
        }
    }

    private void button5Action() {
        Stage stage = new Stage();
        Label senderIdLabel = new Label("Sender id: ");
        Label receiversIdLabel = new Label("Receivers id: ");
        Label themeLabel = new Label("Theme: ");
        Label textLabel = new Label("Text: ");
        TextField senderIdField = new TextField();
        TextField receiversIdField = new TextField();
        TextField themeField = new TextField();
        TextField textField = new TextField();
        Button sendButton = new Button("Send");
        sendButton.setOnAction(actionEvent -> {
            String senderId = senderIdField.getText();
            String theme = themeField.getText();
            String text = textField.getText();
            String receiversIdString = receiversIdField.getText();
            if (receiversIdString != null) {
                String[] receiversId = receiversIdString.split(", ");
                for (String receiverId : receiversId) {
                    try {
                        letterService.sendLetter(theme, text, senderId, receiverId);
                    } catch (ServiceException e) {
                        LOGGER.log(Level.ERROR, "Error while sending letter", e);
                    }
                }
            }
            stage.close();
        });
        VBox root = new VBox(senderIdLabel, senderIdField, receiversIdLabel,
                receiversIdField, themeLabel, themeField, textLabel, textField, sendButton);
        Scene scene = new Scene(root);
        stage.setWidth(500);
        stage.setHeight(240);
        stage.setResizable(false);
        stage.show();
        stage.setScene(scene);
    }

    private List<String> makeRepresentationUser(List<User> electricalProducts) {
        return electricalProducts.stream()
                .map(u -> String.format(USER_TEMPLATE, u.getUserId(),
                        u.getName(), u.getSurname(), u.getPatronymic(), u.getBirthday()))
                .collect(Collectors.toList());
    }

    private List<String> makeRepresentationUserWithLetter(List<User> electricalProducts) {
        return electricalProducts.stream()
                .map(u -> {
                    String representation;
                    try {
                        representation = String.format(USER_LETTER_TEMPLATE, u.getUserId(), u.getName(), u.getSurname(),
                                u.getPatronymic(), u.getBirthday(),
                                letterService.findAmountOfSentLettersByUserId(u.getUserId()),
                                letterService.findAmountOfReceivedLettersByUserId(u.getUserId()));
                    } catch (ServiceException e) {
                        representation = "";
                        LOGGER.log(Level.ERROR, "Error while finding letters by id", e);
                    }
                    return representation;
                })
                .collect(Collectors.toList());
    }
}

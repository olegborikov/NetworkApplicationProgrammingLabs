package com.borikov.laba5_1.app;

import com.github.bgora.rpnlibrary.Calculator;
import com.github.bgora.rpnlibrary.exceptions.WrongArgumentException;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.util.NoSuchElementException;

public class CalculatorApplication extends Application {
    private TextField inputField;
    private Label outputLabel;
    private Button buttonDelete;
    private Button buttonClear;
    private Button buttonLeftBracket;
    private Button buttonRightBracket;
    private Button button1;
    private Button button2;
    private Button button3;
    private Button button4;
    private Button button5;
    private Button button6;
    private Button button7;
    private Button button8;
    private Button button9;
    private Button button0;
    private Button buttonDivide;
    private Button buttonMultiply;
    private Button buttonSum;
    private Button buttonDifference;
    private Button buttonEqually;
    private Button buttonDot;

    @Override
    public void start(Stage stage) {
        componentsInit();
        configureSize();
        buttonsAddListeners();
        configureFont();
        FlowPane root = new FlowPane(inputField, buttonDelete, outputLabel,
                buttonLeftBracket, buttonRightBracket, buttonClear,
                button7, button8, button9, buttonDivide, button4, button5, button6,
                buttonMultiply, button1, button2, button3, buttonDifference,
                button0, buttonDot, buttonEqually, buttonSum);
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("Calculator");
        stage.setWidth(238);
        stage.setHeight(350);
        stage.setResizable(false);
        stage.show();
    }

    private void componentsInit() {
        outputLabel = new Label();
        inputField = new TextField();
        buttonDelete = new Button("<-");
        buttonClear = new Button("Clear");
        buttonLeftBracket = new Button("(");
        buttonRightBracket = new Button(")");
        button1 = new Button("1");
        button2 = new Button("2");
        button3 = new Button("3");
        button4 = new Button("4");
        button5 = new Button("5");
        button6 = new Button("6");
        button7 = new Button("7");
        button8 = new Button("8");
        button9 = new Button("9");
        button0 = new Button("0");
        buttonDivide = new Button("/");
        buttonMultiply = new Button("*");
        buttonSum = new Button("+");
        buttonDifference = new Button("-");
        buttonEqually = new Button("=");
        buttonDot = new Button(".");

    }

    private void configureSize() {
        inputField.setPrefWidth(165);
        outputLabel.setPrefWidth(220);
        outputLabel.setPrefHeight(45);
        outputLabel.disableProperty();
        buttonDelete.setPrefWidth(55);
        buttonClear.setPrefWidth(110);
        buttonLeftBracket.setPrefWidth(55);
        buttonRightBracket.setPrefWidth(55);
        button1.setPrefWidth(55);
        button2.setPrefWidth(55);
        button3.setPrefWidth(55);
        button4.setPrefWidth(55);
        button5.setPrefWidth(55);
        button6.setPrefWidth(55);
        button7.setPrefWidth(55);
        button8.setPrefWidth(55);
        button9.setPrefWidth(55);
        button0.setPrefWidth(55);
        buttonDivide.setPrefWidth(55);
        buttonMultiply.setPrefWidth(55);
        buttonSum.setPrefWidth(55);
        buttonDifference.setPrefWidth(55);
        buttonEqually.setPrefWidth(55);
        buttonDot.setPrefWidth(55);
    }

    private void configureFont() {
        Font font = new Font(20);
        inputField.setFont(font);
        outputLabel.setFont(font);
        buttonDelete.setFont(font);
        buttonClear.setFont(font);
        buttonLeftBracket.setFont(font);
        buttonRightBracket.setFont(font);
        button1.setFont(font);
        button2.setFont(font);
        button3.setFont(font);
        button4.setFont(font);
        button5.setFont(font);
        button6.setFont(font);
        button7.setFont(font);
        button8.setFont(font);
        button9.setFont(font);
        button0.setFont(font);
        buttonDivide.setFont(font);
        buttonMultiply.setFont(font);
        buttonSum.setFont(font);
        buttonDifference.setFont(font);
        buttonEqually.setFont(font);
        buttonDot.setFont(font);
    }

    private void buttonsAddListeners() {
        buttonDelete.setOnAction(actionEvent -> {
            String line = inputField.getCharacters().toString();
            if (line.length() > 0) {
                inputField.setText(line.substring(0, line.length() - 1));
            }
        });
        buttonClear.setOnAction(actionEvent -> {
            inputField.setText("");
            outputLabel.setText("");
        });
        buttonLeftBracket.setOnAction(actionEvent -> inputField.setText(inputField.getCharacters() + "("));
        buttonRightBracket.setOnAction(actionEvent -> inputField.setText(inputField.getCharacters() + ")"));
        button1.setOnAction(actionEvent -> inputField.setText(inputField.getCharacters() + "1"));
        button2.setOnAction(actionEvent -> inputField.setText(inputField.getCharacters() + "2"));
        button3.setOnAction(actionEvent -> inputField.setText(inputField.getCharacters() + "3"));
        button4.setOnAction(actionEvent -> inputField.setText(inputField.getCharacters() + "4"));
        button5.setOnAction(actionEvent -> inputField.setText(inputField.getCharacters() + "5"));
        button6.setOnAction(actionEvent -> inputField.setText(inputField.getCharacters() + "6"));
        button7.setOnAction(actionEvent -> inputField.setText(inputField.getCharacters() + "7"));
        button8.setOnAction(actionEvent -> inputField.setText(inputField.getCharacters() + "8"));
        button9.setOnAction(actionEvent -> inputField.setText(inputField.getCharacters() + "9"));
        button0.setOnAction(actionEvent -> inputField.setText(inputField.getCharacters() + "0"));
        buttonDivide.setOnAction(actionEvent -> inputField.setText(inputField.getCharacters() + "/"));
        buttonMultiply.setOnAction(actionEvent -> inputField.setText(inputField.getCharacters() + "*"));
        buttonSum.setOnAction(actionEvent -> inputField.setText(inputField.getCharacters() + "+"));
        buttonDifference.setOnAction(actionEvent -> inputField.setText(inputField.getCharacters() + "-"));
        buttonEqually.setOnAction(actionEvent -> {
            String line = inputField.getCharacters().toString();
            Calculator calculator = Calculator.createCalculator();
            String answer;
            try {
                answer = String.valueOf(calculator.calculate(line));
            } catch (WrongArgumentException | NoSuchElementException e) {
                answer = "error";
            }
            outputLabel.setText("  " + answer);
        });
        buttonDot.setOnAction(actionEvent -> inputField.setText(inputField.getCharacters() + "."));
    }
}

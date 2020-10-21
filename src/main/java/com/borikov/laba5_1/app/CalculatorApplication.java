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
    @Override
    public void start(Stage stage) {
        TextField inputField = new TextField();
        Label outputField = new Label();
        Button buttonDelete = new Button("<-");
        Button buttonClear = new Button("Clear");
        Button buttonLeftBracket = new Button("(");
        Button buttonRightBracket = new Button(")");
        Button button1 = new Button("1");
        Button button2 = new Button("2");
        Button button3 = new Button("3");
        Button button4 = new Button("4");
        Button button5 = new Button("5");
        Button button6 = new Button("6");
        Button button7 = new Button("7");
        Button button8 = new Button("8");
        Button button9 = new Button("9");
        Button button0 = new Button("0");
        Button buttonDivide = new Button("/");
        Button buttonMultiply = new Button("*");
        Button buttonSum = new Button("+");
        Button buttonDifference = new Button("-");
        Button buttonEqually = new Button("=");
        Button buttonDot = new Button(".");
        inputField.setPrefWidth(165);
        outputField.setPrefWidth(220);
        outputField.setPrefHeight(45);
        outputField.disableProperty();
        buttonDelete.setPrefWidth(55);
        buttonDelete.setOnAction(actionEvent -> {
            String line = inputField.getCharacters().toString();
            if (line.length() > 0) {
                inputField.setText(line.substring(0, line.length() - 1));
            }
        });
        buttonClear.setPrefWidth(110);
        buttonClear.setOnAction(actionEvent -> {
            inputField.setText("");
            outputField.setText("");
        });
        buttonLeftBracket.setPrefWidth(55);
        buttonLeftBracket.setOnAction(actionEvent -> inputField.setText(inputField.getCharacters() + "("));
        buttonRightBracket.setPrefWidth(55);
        buttonRightBracket.setOnAction(actionEvent -> inputField.setText(inputField.getCharacters() + ")"));
        button1.setPrefWidth(55);
        button1.setOnAction(actionEvent -> inputField.setText(inputField.getCharacters() + "1"));
        button2.setPrefWidth(55);
        button2.setOnAction(actionEvent -> inputField.setText(inputField.getCharacters() + "2"));
        button3.setPrefWidth(55);
        button3.setOnAction(actionEvent -> inputField.setText(inputField.getCharacters() + "3"));
        button4.setPrefWidth(55);
        button4.setOnAction(actionEvent -> inputField.setText(inputField.getCharacters() + "4"));
        button5.setPrefWidth(55);
        button5.setOnAction(actionEvent -> inputField.setText(inputField.getCharacters() + "5"));
        button6.setPrefWidth(55);
        button6.setOnAction(actionEvent -> inputField.setText(inputField.getCharacters() + "6"));
        button7.setPrefWidth(55);
        button7.setOnAction(actionEvent -> inputField.setText(inputField.getCharacters() + "7"));
        button8.setPrefWidth(55);
        button8.setOnAction(actionEvent -> inputField.setText(inputField.getCharacters() + "8"));
        button9.setPrefWidth(55);
        button9.setOnAction(actionEvent -> inputField.setText(inputField.getCharacters() + "9"));
        button0.setPrefWidth(55);
        button0.setOnAction(actionEvent -> inputField.setText(inputField.getCharacters() + "0"));
        buttonDivide.setPrefWidth(55);
        buttonDivide.setOnAction(actionEvent -> inputField.setText(inputField.getCharacters() + "/"));
        buttonMultiply.setPrefWidth(55);
        buttonMultiply.setOnAction(actionEvent -> inputField.setText(inputField.getCharacters() + "*"));
        buttonSum.setPrefWidth(55);
        buttonSum.setOnAction(actionEvent -> inputField.setText(inputField.getCharacters() + "+"));
        buttonDifference.setPrefWidth(55);
        buttonDifference.setOnAction(actionEvent -> inputField.setText(inputField.getCharacters() + "-"));
        buttonEqually.setPrefWidth(55);
        buttonEqually.setOnAction(actionEvent -> {
            String line = inputField.getCharacters().toString();
            Calculator calculator = Calculator.createCalculator();
            String answer;
            try {
                answer = String.valueOf(calculator.calculate(line));
            } catch (WrongArgumentException | NoSuchElementException e) {
                answer = "error";
            }
            outputField.setText(answer);
        });
        buttonDot.setPrefWidth(55);
        buttonDot.setOnAction(actionEvent -> inputField.setText(inputField.getCharacters() + "."));
        FlowPane root = new FlowPane(inputField, buttonDelete, outputField,
                buttonLeftBracket, buttonRightBracket, buttonClear,
                button7, button8, button9, buttonDivide, button4, button5, button6,
                buttonMultiply, button1, button2, button3, buttonDifference,
                button0, buttonDot, buttonEqually, buttonSum);
        Font font = new Font(20);
        inputField.setFont(font);
        outputField.setFont(font);
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
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("Calculator");
        stage.setWidth(238);
        stage.setHeight(350);
        stage.setResizable(false);
        stage.show();
    }
}

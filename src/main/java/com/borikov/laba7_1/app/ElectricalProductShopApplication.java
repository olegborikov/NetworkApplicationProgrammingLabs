package com.borikov.laba7_1.app;

import com.borikov.laba7_1.entity.ElectricalProduct;
import com.borikov.laba7_1.exception.ServiceException;
import com.borikov.laba7_1.service.ElectricalProductService;
import com.borikov.laba7_1.service.impl.ElectricalProductServiceImpl;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ElectricalProductShopApplication extends Application {
    private static final String VIEW_TEMPLATE = "id: %d, name: %s, price: %.2f, quantity: %d, issue year: %d";
    private final ElectricalProductService electricalProductService = new ElectricalProductServiceImpl();
    private ListView<String> listView;
    private Button buttonShow;
    private Button buttonAdd;
    private Button buttonEdit;
    private Button buttonDelete;

    @Override
    public void start(Stage stage) {
        componentsInit();
        addButtonsListeners();
        configureAnchorPane();
        AnchorPane root = new AnchorPane(listView, buttonShow, buttonAdd, buttonEdit, buttonDelete);
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("Electrical product shop");
        stage.setWidth(400);
        stage.setHeight(500);
        stage.setResizable(false);
        stage.show();
    }

    private void componentsInit() {
        buttonShow = new Button("Show");
        buttonAdd = new Button("Add");
        buttonEdit = new Button("Edit");
        buttonDelete = new Button("Delete");
        List<ElectricalProduct> electricalProducts = new ArrayList<>();
        try {
            electricalProducts = electricalProductService.findAllElectricalProducts();
        } catch (ServiceException e) {
            System.err.println(e);
        }
        ObservableList<String> observableList =
                FXCollections.observableArrayList(makeRepresentation(electricalProducts));
        listView = new ListView<>(observableList);
    }

    private void configureAnchorPane() {
        AnchorPane.setLeftAnchor(listView, 0.0);
        AnchorPane.setRightAnchor(listView, 0.0);
        AnchorPane.setBottomAnchor(buttonShow, 15.0);
        AnchorPane.setLeftAnchor(buttonShow, 10.0);
        AnchorPane.setBottomAnchor(buttonAdd, 15.0);
        AnchorPane.setLeftAnchor(buttonAdd, 125.0);
        AnchorPane.setBottomAnchor(buttonEdit, 15.0);
        AnchorPane.setRightAnchor(buttonEdit, 125.0);
        AnchorPane.setBottomAnchor(buttonDelete, 15.0);
        AnchorPane.setRightAnchor(buttonDelete, 10.0);
    }

    private void addButtonsListeners() {
        buttonShow.setOnAction(actionEvent -> showButtonAction());
        buttonAdd.setOnAction(actionEvent -> addButtonAction());
        buttonEdit.setOnAction(actionEvent -> editButtonAction());
        buttonDelete.setOnAction(actionEvent -> {
            deleteButtonAction();
            showButtonAction();
        });
    }

    private List<String> makeRepresentation(List<ElectricalProduct> electricalProducts) {
        return electricalProducts.stream()
                .map(e -> String.format(VIEW_TEMPLATE, e.getElectricalProductId(),
                        e.getName(), e.getPrice(), e.getQuantity(), e.getIssueYear()))
                .collect(Collectors.toList());
    }

    private void showButtonAction() {
        List<ElectricalProduct> electricalProducts = new ArrayList<>();
        try {
            electricalProducts = electricalProductService.findAllElectricalProducts();
        } catch (ServiceException e) {
            System.err.println(e);
        }
        ObservableList<String> observableList =
                FXCollections.observableArrayList(makeRepresentation(electricalProducts));
        listView.setItems(observableList);
    }

    private void addButtonAction() {
        Stage stage = new Stage();
        Button submitButton = new Button("Add");
        TextField nameField = new TextField();
        TextField priceField = new TextField();
        TextField quantityField = new TextField();
        TextField issueYearField = new TextField();
        Label nameLabel = new Label("Name:");
        Label priceLabel = new Label("Price:");
        Label quantityLabel = new Label("Quantity:");
        Label issueYearLabel = new Label("Issue year:");
        VBox root = new VBox(nameLabel, nameField, priceLabel, priceField, quantityLabel, quantityField,
                issueYearLabel, issueYearField, submitButton);
        submitButton.setOnAction(actionEvent -> {
            String name = nameField.getText();
            String price = priceField.getText();
            String quantity = quantityField.getText();
            String issueYear = issueYearField.getText();
            try {
                electricalProductService.addElectricalProduct(name, price, quantity, issueYear);
            } catch (ServiceException e) {
                System.err.println(e);
            }
            stage.close();
            showButtonAction();
        });
        Scene scene = new Scene(root);
        stage.setWidth(200);
        stage.setHeight(250);
        stage.setResizable(false);
        stage.setTitle("Add electrical product");
        stage.show();
        stage.setScene(scene);
    }

    private void editButtonAction() {
        String selectedString = listView.getSelectionModel().getSelectedItem();
        if (selectedString != null) {
            String id = selectedString.substring(selectedString.indexOf("id: ")
                    + 4, selectedString.indexOf(", name:"));
            String name = selectedString.substring(selectedString.indexOf(", name: ")
                    + 8, selectedString.indexOf(", price:"));
            String price = selectedString.substring(selectedString.indexOf(", price: ")
                    + 9, selectedString.indexOf(", quantity:"));
            String quantity = selectedString.substring(selectedString.indexOf(", quantity: ")
                    + 12, selectedString.indexOf(", issue year:"));
            String issueYear = selectedString.substring(selectedString.indexOf(", issue year: ") + 14);
            Stage stage = new Stage();
            Button editButton = new Button("Edit");
            TextField nameField = new TextField();
            nameField.setText(name);
            TextField priceField = new TextField();
            priceField.setText(price.replace(',', '.'));
            TextField quantityField = new TextField();
            quantityField.setText(quantity);
            TextField issueYearField = new TextField();
            issueYearField.setText(issueYear);
            Label nameLabel = new Label("Name:");
            Label priceLabel = new Label("Price:");
            Label quantityLabel = new Label("Quantity:");
            Label issueYearLabel = new Label("Issue year:");
            VBox root = new VBox(nameLabel, nameField, priceLabel, priceField, quantityLabel, quantityField,
                    issueYearLabel, issueYearField, editButton);
            editButton.setOnAction(actionEvent -> {
                String inputName = nameField.getText();
                String inputPrice = priceField.getText();
                String inputQuantity = quantityField.getText();
                String inputIssueYear = issueYearField.getText();
                try {
                    electricalProductService.updateElectricalProduct(id, inputName,
                            inputPrice, inputQuantity, inputIssueYear);
                } catch (ServiceException e) {
                    System.err.println(e);
                }
                stage.close();
                showButtonAction();
            });
            Scene scene = new Scene(root);
            stage.setWidth(200);
            stage.setHeight(250);
            stage.setResizable(false);
            stage.setTitle("Edit electrical product");
            stage.show();
            stage.setScene(scene);
        }
    }

    private void deleteButtonAction() {
        String selectedString = listView.getSelectionModel().getSelectedItem();
        if (selectedString != null) {
            String id = selectedString.substring(selectedString.indexOf("id: ") + 4, selectedString.indexOf(", name:"));
            try {
                electricalProductService.removeElectricalProduct(id);
            } catch (ServiceException e) {
                System.err.println(e);
            }
        }
    }
}

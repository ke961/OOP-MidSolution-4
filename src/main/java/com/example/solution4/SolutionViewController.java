package com.example.solution4;

import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.time.LocalDate;
import java.util.ArrayList;

public class SolutionViewController
{
    @javafx.fxml.FXML
    private ComboBox<String> availabilityComboBox;
    @javafx.fxml.FXML
    private TextField packageNameTextField;
    @javafx.fxml.FXML
    private TextField filteredPriceTextField;
    @javafx.fxml.FXML
    private Label bestValueInfoLable;
    @javafx.fxml.FXML
    private TableColumn<DataPackage,String> availabilityTableColumn;
    @javafx.fxml.FXML
    private TableColumn<DataPackage,String> packageNameTableColumn;
    @javafx.fxml.FXML
    private TableColumn<DataPackage,String> validityTableColumn;
    @javafx.fxml.FXML
    private Label infoLable;
    @javafx.fxml.FXML
    private TableColumn<DataPackage, LocalDate> offerEndsTableColumn;
    @javafx.fxml.FXML
    private TableView<DataPackage> dataPackageTableView;
    @javafx.fxml.FXML
    private TextField dataAmountTextField;
    @javafx.fxml.FXML
    private TableColumn<DataPackage,Float> priceTableColumn;
    @javafx.fxml.FXML
    private ComboBox<String> validityComboBox;
    @javafx.fxml.FXML
    private ComboBox<String > filteredValidityComboBox;
    @javafx.fxml.FXML
    private TextField priceTextField;
    @javafx.fxml.FXML
    private TableColumn<DataPackage,Float> dataAmountTableColumn;
    @javafx.fxml.FXML
    private DatePicker offerEndsDatePicker;

    private ArrayList<DataPackage>dataPackageList;


    @javafx.fxml.FXML
    public void initialize() {
        dataPackageList=new ArrayList<>();

        availabilityComboBox.getItems().addAll("App only","Recharge Only","App and Recharge");
        validityComboBox.getItems().addAll("3 days","7 days","15 days","30 days","Unlimited");

        packageNameTableColumn.setCellValueFactory(new PropertyValueFactory<DataPackage,String>("packageName"));
        priceTableColumn.setCellValueFactory(new PropertyValueFactory<DataPackage,Float>("price"));
        availabilityTableColumn.setCellValueFactory(new PropertyValueFactory<DataPackage,String>("availability"));
       validityTableColumn.setCellValueFactory(new PropertyValueFactory<DataPackage,String>("validity"));
        dataAmountTableColumn.setCellValueFactory(new PropertyValueFactory<DataPackage,Float>("dataAmount"));
        offerEndsTableColumn.setCellValueFactory(new PropertyValueFactory<DataPackage,LocalDate>("offerEnds"));

    }

    @javafx.fxml.FXML
    public void filterBTOnAction(ActionEvent actionEvent) {
        String filter_validity=filteredValidityComboBox.getValue();
        if(filteredValidityComboBox.getValue().isEmpty()){
            infoLable.setText("please fill all the requirements");
            return;
        }
        float filter_price=Float.parseFloat(filteredPriceTextField.getText());
        if(filteredPriceTextField.getText().isEmpty()){
            infoLable.setText("please fill all the requirements");
            return;
        }

        for(DataPackage dataPackage:dataPackageList){
            if(dataPackage.getValidity().equals(filter_validity)&& dataPackage.getPrice()==filter_price);
            dataPackageTableView.getItems().add(dataPackage);
            return;
        }
    }

    @javafx.fxml.FXML
    public void bestValueBTOnAction(ActionEvent actionEvent) {
        if(dataPackageList.isEmpty()){
            bestValueInfoLable.setText("No data Packages!");
            return;
        }
        float best_value=dataPackageList.getFirst().getDataAmount()/dataPackageList.getFirst().getPrice();
        DataPackage best_package =dataPackageList.getFirst();
        for(DataPackage dataPackage:dataPackageList){
            if(dataPackage.getPrice()/dataPackage.getDataAmount()>best_value);{
            best_value= dataPackage.getPrice()/dataPackage.getDataAmount();
            best_package=dataPackage;

            }
        }
        bestValueInfoLable.setText(best_package.toString());
    }

    @javafx.fxml.FXML
    public void resetFilterBTOnAction(ActionEvent actionEvent) {
        dataPackageTableView.getItems().clear();
        String packageName= packageNameTextField.getText();
        String validity = validityComboBox.getValue();
        float price= Float.parseFloat(priceTextField.getText());
        float dataAmount= Float.parseFloat(dataAmountTextField.getText());
        LocalDate offerEnds= offerEndsDatePicker.getValue();
        String availability= availabilityComboBox.getValue();
        DataPackage new_data=new DataPackage( packageName,availability,validity,price,dataAmount,offerEnds);
        dataPackageList.add(new_data);
        dataPackageTableView.getItems().add(new_data);

    }

    @javafx.fxml.FXML
    public void creatPackageBTOnAction(ActionEvent actionEvent) {
        String packageName= packageNameTextField.getText();
        System.out.println(packageName);
        String availability= availabilityComboBox.getValue();
        if(availabilityComboBox.getValue().isEmpty()){
            infoLable.setText("please fill all the requirements");
            return;
        }

        String validity = validityComboBox.getValue();
        if(validityComboBox.getValue().isEmpty()){
            infoLable.setText("please fill all the requirements");
            return;
        }
        float price= Float.parseFloat(priceTextField.getText());
        if(priceTextField.getText().isEmpty()){
            infoLable.setText("please fill all the requirements");
            return;
        }
        float dataAmount= Float.parseFloat(dataAmountTextField.getText());
        if(dataAmountTextField.getText().isEmpty()){
            infoLable.setText("please fill all the requirements");
            return;}
        LocalDate offerEnds= offerEndsDatePicker.getValue();
        if(offerEndsDatePicker.getValue()==null){
            infoLable.setText("please fill all the requirements");
            return;}
        boolean has_unique_name=true;
        for(DataPackage dataPackage:dataPackageList){
            if(dataPackage.getPackageName().equals(packageName)){
                has_unique_name=false;
                break;
            }
        }
        if(!has_unique_name ) {
            infoLable.setText("Package Name Must be Unique!");
            return;
        }
        if(packageNameTextField.getText().isEmpty()){
            infoLable.setText("please fill all the requirements");
            return;
        }
        DataPackage new_data=new DataPackage( packageName,availability,validity,price,dataAmount,offerEnds);
        dataPackageList.add(new_data);
        infoLable.setText("You successfully creat!");
        filteredValidityComboBox.getItems().add(validity);
    }
}
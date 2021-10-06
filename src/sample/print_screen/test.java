package sample.print_screen;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javax.print.*;
import java.awt.event.ActionListener;
import java.awt.print.PrinterException;
import java.net.URL;
import java.util.ResourceBundle;

public class test implements Initializable, ActionListener {


    @FXML
    public Button print;
    public Label printLabel;
    public AnchorPane mainPanel;
    public Button scan;
    public AnchorPane sidePanel;
    public Button add;
    public Button remove;
    public Button preview;
    public ComboBox printerCombo1;
    public ComboBox printerCombo2;
    public ComboBox printerCombo3;
    public Button back;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        System.out.println("opened");


    }
//
    public void onPrinting (ActionEvent e) throws PrinterException {
      //TODO : print throw specified printer....
        printerObject printerObject = new printerObject("my text to be printed");
        printerObject.actionPerformed(printerCombo1.getValue().toString());
        System.out.println("printing");

    }


    public void checkCompo() {
        System.out.println(printerCombo1.getValue());
        printLabel.setText(printerCombo1.getValue().toString());


    }
    // get the printer names in the combo box
    public void onScaning() {
        PrintService[] printServices ;
        ObservableList<String> comboList = FXCollections.observableArrayList();
        System.out.println("hi");
        printServices = PrintServiceLookup.lookupPrintServices(null,null);


        for (PrintService i : printServices) {
            comboList.add(i.getName());
            System.out.println(i.getName());
        }
        printerCombo1.setItems(comboList);
        printerCombo2.setItems(comboList);
        printerCombo3.setItems(comboList);

    }

    public void onPeview(ActionEvent actionEvent) {
    }

    public void onRemoving(ActionEvent actionEvent) {
    }

    public void onAdding(ActionEvent actionEvent) {

    }

    @Override
    public void actionPerformed(java.awt.event.ActionEvent e) {

    }
}

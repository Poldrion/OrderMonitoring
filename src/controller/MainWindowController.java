package controller;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.util.Properties;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class MainWindowController {
    private static final ObservableList<Integer> YEARS_LIST = FXCollections.observableArrayList();

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TableColumn<?, ?> commentTblCol;

    @FXML
    private TableColumn<?, ?> costWithTaxTblCol;

    @FXML
    private TableColumn<?, ?> costWithoutTaxTblCol;

    @FXML
    private TableColumn<?, ?> countTblCol;

    @FXML
    private Button dataBaseOLTTBtn;

    @FXML
    private Button exportToExcelBtn;

    @FXML
    private TableColumn<?, ?> nameTblCol;

    @FXML
    private TableColumn<?, ?> orderTblCol;

    @FXML
    private TableView<?> reportTbl;

    @FXML
    private ComboBox<?> reportTypeCB;

    @FXML
    private Button statisticsBtn;

    @FXML
    private TableColumn<?, ?> unitTblCol;

    @FXML
    private ComboBox<Integer> yearChB;

    @FXML
    void handleDataBaseBtn(ActionEvent event) {

    }

    @FXML
    void handleExportToExcelBtn(ActionEvent event) {

    }

    @FXML
    void handleStatisticsBtn(ActionEvent event) {

    }

    @FXML
    void initialize() {
        // заполнение списка годов
        setValueYearChB();
    }

    private void setValueYearChB() {
        FileInputStream fis;
        Properties property = new Properties();
        try {
            // оставить до реазлизации в исполняемый jar
            // fis = new FileInputStream(System.getProperty("user.dir") + File.separator + "resources" + File.separator + "config.properties");
            fis = new FileInputStream("src/resources/properties/config.properties");
            property.load(fis);
            fis.close();
        } catch (IOException e) {
            System.err.println("ОШИБКА: Файл свойств отсуствует!");
        }

        for (int i = 0; i < 20; i++) {
            YEARS_LIST.add(Integer.parseInt(property.getProperty("firstYear")) + i);
        }
        yearChB.setItems(YEARS_LIST);
        yearChB.setValue(YEARS_LIST.get(0));
    }

}

package org.example.demo.controller;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import org.example.demo.model.Avto;
import org.example.demo.Main;

public class MainController {
    @FXML
    private TableView<Avto> avtoTable;
    @FXML
    private TableColumn<Avto, String> modelColumn;

    @FXML
    private Label nameLabel;
    @FXML
    private Label priceLabel;
    @FXML
    private Label enginePowerLabel;
    @FXML
    private Label engineCapacityLabel;
    @FXML
    private Label accelerationLabel;
    @FXML
    private Label fuelConsumptionLabel;

    // Ссылка на главное приложение:
    private Main main;

    //Конструктор вызывается раньше метода initialize().
    public MainController() {
    }

    //Инициализация класса-контроллера. Этот метод вызывается автоматически после того, как fxml-файл будет загружен.
    @FXML
    private void initialize() {
        // Инициализация таблицы c моделями авто:
        modelColumn.setCellValueFactory(cellData -> cellData.getValue().nameProperty());

        // Очистка дополнительной информации об авто!!!!с этим методом прилага не запускается:
        //showAvtoDetails(null);

        // Слушает изменения выбора, и при изменении отображает дополнительную информацию об авто.
        avtoTable.getSelectionModel().selectedItemProperty().addListener(
                (observable, oldValue, newValue) -> showAvtoDetails(newValue));

    }

        //Вызывается главным приложением, которое даёт на себя ссылку.
        public void setMain(Main main) {
        this.main = main;

        // Добавление в таблицу данных из наблюдаемого списка
        avtoTable.setItems(main.getAvtoData());
    }

    //Заполняет все поля, отображая подробности об авто:
    private void showAvtoDetails(Avto avto) {
        if (avto != null) {
            // Заполняем метки информацией из объекта avto:
            nameLabel.setText(avto.getName());
            priceLabel.setText(String.valueOf(avto.getPrice()));
            enginePowerLabel.setText(String.valueOf(avto.getEnginePower()));
            engineCapacityLabel.setText(String.valueOf(avto.getEngineCapacity()));
            accelerationLabel.setText(String.valueOf(avto.getAcceleration()));
            fuelConsumptionLabel.setText(String.valueOf(avto.getFuelConsumption()));
        } else {
            // Если Avto = null, то убираем весь текст.
            nameLabel.setText("");
            priceLabel.setText("");
            enginePowerLabel.setText("");
            engineCapacityLabel.setText("");
            accelerationLabel.setText("");
            fuelConsumptionLabel.setText("");
        }
    }

    //Вызывается, когда пользователь кликает по кнопке удаления
    @FXML
    private void handleDeleteAvto() {
        int selectedIndex = avtoTable.getSelectionModel().getSelectedIndex();
        if (selectedIndex >= 0) {
            avtoTable.getItems().remove(selectedIndex);
        } else {
            // Ничего не выбрано.
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.initOwner(main.getStage());
            alert.setTitle("Нет выбора");
            alert.setHeaderText("Ничего не выбрано");
            alert.setContentText("Пожалуйта, выберите модель для удаления");

            alert.showAndWait();
        }
    }

    //Вызывается, когда пользователь кликает по кнопке New...
    //Открывает диалоговое окно с дополнительной информацией об автомобиле.
    @FXML
    private void handleNewAvto() {
        Avto tempAvto = new Avto();
        boolean okClicked = main.showAvtoEditDialog(tempAvto);
        if (okClicked) {
            main.getAvtoData().add(tempAvto);
        }
    }

    //Вызывается, когда пользователь кликает по кнопка Edit...
    //Открывает диалоговое окно для изменения выбранного адресата.
    @FXML
    private void handleEditAvto() {
        Avto selectedAvto = avtoTable.getSelectionModel().getSelectedItem();
        if (selectedAvto != null) {
            boolean okClicked = main.showAvtoEditDialog(selectedAvto);
            if (okClicked) {
                showAvtoDetails(selectedAvto);
            }

        } else {
            // Ничего не выбрано.
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.initOwner(main.getStage());
            alert.setTitle("Ничего не выбрано");
            alert.setHeaderText("Модель не выбрана");
            alert.setContentText("Пожалуйста, выберите модель автомобиля");

            alert.showAndWait();
        }
    }
}
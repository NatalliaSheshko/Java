package org.example.demo.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.example.demo.model.Avto;

//Окно для изменения информации об авто

public class AvtoEditDialogController {

    @FXML
    private TextField nameField;
    @FXML
    private TextField priceField;
    @FXML
    private TextField enginePowerField;
    @FXML
    private TextField engineCapacityField;
    @FXML
    private TextField accelerationField;
    @FXML
    private TextField fuelConsumptionField;

    private Stage dialogStage;
    private Avto avto;
    private boolean okClicked = false;

    //Инициализирует класс-контроллер. Этот метод вызывается автоматически после того, как fxml-файл будет загружен.
    @FXML
    private void initialize() {
    }

    //Устанавливает сцену для окна.
    public void setDialogStage(Stage dialogStage) {
        this.dialogStage = dialogStage;
    }

    //Задаёт модель, информацию о которой будем менять.
    public void setAvto(Avto avto) {
        this.avto = avto;

        nameField.setText(avto.getName());
        priceField.setText(String.valueOf(avto.getPrice()));
        enginePowerField.setText(String.valueOf(avto.getEnginePower()));
        engineCapacityField.setText(String.valueOf(avto.getEngineCapacity()));
        accelerationField.setText(String.valueOf(avto.getAcceleration()));
        fuelConsumptionField.setText(String.valueOf((avto.getFuelConsumption())));
    }

    //Возвращает true, если пользователь кликнул OK, в другом случае false.
    public boolean isOkClicked() {
        return okClicked;
    }

    //Вызывается, когда пользователь кликнул по кнопке OK.
    @FXML
    private void handleOk() {
        if (isInputValid()) {
            avto.setName(nameField.getText());
            avto.setPrice(Integer.valueOf(priceField.getText()));
            avto.setEnginePower(Integer.valueOf(enginePowerField.getText()));
            avto.setEngineCapacity(Float.valueOf(engineCapacityField.getText()));
            avto.setAcceleration(Float.valueOf(accelerationField.getText()));
            avto.setFuelConsumption(Float.valueOf(fuelConsumptionField.getText()));

            okClicked = true;
            dialogStage.close();
        }
    }

    //Вызывается, когда пользователь кликнул по кнопке Cancel.
    @FXML
    private void handleCancel() {
        dialogStage.close();
    }

    //Проверяет пользовательский ввод в текстовых полях. Возвращает true, если пользовательский ввод корректен
    private boolean isInputValid() {
        String errorMessage = "";

        if (nameField.getText() == null || nameField.getText().isEmpty()) {
            errorMessage += "Не введена Модель!\n";
        }
        if (priceField.getText() == null || priceField.getText().isEmpty()) {
            errorMessage += "Не введена цена!\n";
        }else {
            // пытается преобразовать в int:
            try {
                Integer.parseInt(priceField.getText());
            } catch (NumberFormatException e) {
                errorMessage += "Необходимо ввести целое число!\n";
            }
        }

        if (enginePowerField.getText() == null || enginePowerField.getText().isEmpty()) {
            errorMessage += "Не введена мощность двигателя!\n";
        }else {
            // пытается преобразовать в int:
            try {
                Integer.parseInt(enginePowerField.getText());
            } catch (NumberFormatException e) {
                errorMessage += "Необходимо ввести целое число!\n";
            }
        }

        if (engineCapacityField.getText() == null || engineCapacityField.getText().isEmpty()) {
            errorMessage += "Не введен объем двигателя!\n";
        } else {
            // пытается преобразовать в float:
            try {
                Float.parseFloat(engineCapacityField.getText());
            } catch (NumberFormatException e) {
                errorMessage += "Необходимо ввести дробное число!\n";
            }
        }

        if (accelerationField.getText() == null || accelerationField.getText().isEmpty()) {
            errorMessage += "Не введен разгон!\n";
        } else {
            // пытается преобразовать в float:
            try {
                Float.parseFloat(accelerationField.getText());
            } catch (NumberFormatException e) {
                errorMessage += "Необходимо ввести дробное число!\n";
            }
        }

        if (fuelConsumptionField.getText() == null || fuelConsumptionField.getText().isEmpty()) {
            errorMessage += "Не введен расход топлива!\n";
        } else {
            // пытается преобразовать в float:
            try {
                Float.parseFloat(fuelConsumptionField.getText());
            } catch (NumberFormatException e) {
                errorMessage += "Необходимо ввести дробное число!\n";
            }
        }

        if (errorMessage.isEmpty()) {
            return true;
        } else {
            // Показывает сообщение об ошибке.
            Alert alert = new Alert(AlertType.ERROR);
            alert.initOwner(dialogStage);
            alert.setTitle("Данные не введены");
            alert.setHeaderText("Пожалуйста, введите корректные данные");
            alert.setContentText(errorMessage);

            alert.showAndWait();

            return false;
        }
    }
}

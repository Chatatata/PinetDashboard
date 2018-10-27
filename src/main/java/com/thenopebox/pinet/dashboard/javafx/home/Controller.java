package com.thenopebox.pinet.dashboard.javafx.home;

import javafx.application.Platform;
import javafx.beans.InvalidationListener;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.PasswordField;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.control.TextField;

import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class Controller {
    @FXML
    private TextField usernameField;

    @FXML
    private PasswordField passwordField;

    @FXML
    private ProgressIndicator progressIndicator;

    @FXML
    private Button signInButton;

    @FXML
    private void initialize() {
        progressIndicator.setVisible(false);

        signInButton.setOnAction(event -> {
            submit();
        });

        passwordField.focusedProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                if (oldValue != newValue && !oldValue) {
                    passwordField.setText("");
                }
            }
        });
    }

    @FXML
    private void onSubmit(ActionEvent actionEvent) {
        submit();
    }

    private void setDisable(boolean value) {
        usernameField.setDisable(value);
        passwordField.setDisable(value);
        signInButton.setDisable(value);
    }

    private void setActivityStatus(boolean value) {
        setDisable(value);
        progressIndicator.setVisible(value);
    }

    private void showActivityError() {
        final Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText("Invalid Credentials");
        alert.setContentText("Your password should be longer than six characters.");

        alert.show();
    }

    private void submit() {
        if (passwordField.getText().length() < 6) {
            showActivityError();
        } else {
            setActivityStatus(true);
        }
    }
}
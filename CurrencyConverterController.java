package com.example.dijatou;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.io.IOException;

public class CurrencyConverterController {

    @FXML
    private TextField amountField;

    @FXML
    private ComboBox<String> fromCurrencyComboBox;

    @FXML
    private ComboBox<String> toCurrencyComboBox;

    @FXML
    private Label resultLabel;

    public void initialize() {
        // Initialize currency options
        fromCurrencyComboBox.getItems().addAll();
        toCurrencyComboBox.getItems().addAll();

        // Set default values

    }

    @FXML
    private void convert() {
        try {
            double amount = Double.parseDouble(amountField.getText());

            // Perform the conversion (using fixed rates for simplicity)
            double conversionRate = getConversionRate(fromCurrencyComboBox.getValue(), toCurrencyComboBox.getValue());
            double result = amount * conversionRate;

            // Display the result
            resultLabel.setText(String.format("%.2f %s = %.2f %s",
                    amount, fromCurrencyComboBox.getValue(), result, toCurrencyComboBox.getValue()));
        } catch (NumberFormatException e) {
            resultLabel.setText("Invalid input. Please enter a valid number.");
        }
    }
    @FXML
    private void reset() {
        amountField.clear();
        fromCurrencyComboBox.getSelectionModel().clearSelection();
        toCurrencyComboBox.getSelectionModel().clearSelection();
        resultLabel.setText("");

    }

    private double getConversionRate(String fromCurrency, String toCurrency) {

        if (fromCurrency.equals("USD") && toCurrency.equals("GMD")) {
            return 65 ;
        } else if (fromCurrency.equals("USD") && toCurrency.equals("EUR")) {
            return 0.65;
        }else if (fromCurrency.equals("USD") && toCurrency.equals("GBP")) {
            return 1.31;
        } else if (fromCurrency.equals("GMD") && toCurrency.equals("USD")) {
            return 1.18;
        } else if (fromCurrency.equals("GMD") && toCurrency.equals("GBP")) {
            return 0.88;
        } else if (fromCurrency.equals("GMD") && toCurrency.equals("EUR")) {
            return 1.33;
        }else if (fromCurrency.equals("EUR") && toCurrency.equals("GMD")) {
            return 1.31;
        } else if (fromCurrency.equals("EUR") && toCurrency.equals("USD")) {
            return 0.75;
        }else if (fromCurrency.equals("EUR") && toCurrency.equals("GBP")) {
            return 1.31;
        }else if (fromCurrency.equals("GBP") && toCurrency.equals("EUR")) {
            return 1.31;
        } else if (fromCurrency.equals("GBP") && toCurrency.equals("USD")) {
            return 0.75;
        }else if (fromCurrency.equals("GBP") && toCurrency.equals("GMD")) {
            return 1.31;

        }
        return 1.0; // Default to 1:1 conversion rate if no specific rate is defined
    }
}


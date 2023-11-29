package org.openjfx;


import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class MainController {

    @FXML
    private TextField amountInput;

    @FXML
    private ComboBox<String> sourceCurrency;

    @FXML
    private ComboBox<String> targetCurrency;

    @FXML
    private Label resultLabel;

    private static final double USD_TO_EUR_RATE = 0.91;
    private static final double USD_TO_GBP_RATE = 0.79;
    private static final double USD_TO_DALASI_RATE = 67.30;
    private static final double GBP_TO_DALASI_RATE = 85.45;
    private static final double EUR_TO_DALASI_RATE = 73.87;
    @FXML
    public void convert() {
        try {
            double amount = Double.parseDouble(amountInput.getText());
            String source = sourceCurrency.getValue();
            String target = targetCurrency.getValue();

            double result = convertCurrency(amount, source, target);

            resultLabel.setText(String.format("%.2f %s = %.2f %s", amount, source, result, target));
        } catch (NumberFormatException e) {
            resultLabel.setText("Invalid input. Please enter a numeric amount.");
        }
    }

    @FXML
    public void reset()
    {
        amountInput.setText("");
        sourceCurrency.setValue("USD");
        targetCurrency.setValue("EUR");
        resultLabel.setText("0.00");
    }

    private double convertCurrency(double amount, String source, String target) {
        // Implement the conversion logic based on fixed rates
        if ("USD".equals(source) && "EUR".equals(target)) {
            return amount * USD_TO_EUR_RATE;
        } else if ("USD".equals(source) && "GBP".equals(target)) {
            return amount * USD_TO_GBP_RATE;
        }
        else if ("EUR".equals(source) && "USD".equals(target)) {
            return amount / USD_TO_EUR_RATE;
        }
        else if ("EUR".equals(source) && "GBP".equals(target)) {
            return amount * (USD_TO_GBP_RATE / USD_TO_EUR_RATE);
        }
        else if ("GBP".equals(source) && "USD".equals(target)) {
            return amount / USD_TO_GBP_RATE;
        }
        else if ("GBP".equals(source) && "EUR".equals(target)) {
            return amount * (USD_TO_EUR_RATE / USD_TO_GBP_RATE);
        }
        else if ("USD".equals(source) && "DALASI".equals(target)) {
            return amount * USD_TO_DALASI_RATE;
        }
        else if ("DALASI".equals(source) && "USD".equals(target)) {
            return amount / USD_TO_DALASI_RATE;
        }
        else if ("DALASI".equals(source) && "GBP".equals(target))
        {
            return  amount / GBP_TO_DALASI_RATE;
        }
        else if ("GBP".equals(source) && "DALASI".equals(target))
        {
            return  amount * GBP_TO_DALASI_RATE;
        }
        else if ("DALASI".equals(source) && "EUR".equals(target))
        {
            return  amount / EUR_TO_DALASI_RATE;
        }
        else if ("EUR".equals(source) && "DALASI".equals(target))
        {
            return  amount * EUR_TO_DALASI_RATE;
        }
        
        else {
            return amount; 
        }
    }
}

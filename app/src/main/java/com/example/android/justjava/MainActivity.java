package com.example.android.justjava;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.text.NumberFormat;

/*
 * This app displays an order form to order coffee */
public class MainActivity extends AppCompatActivity {

    int quantityCoffee;
    double priceOneCoffee;

    {
        quantityCoffee = 0;
        priceOneCoffee = 5;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        displayInitial(quantityCoffee, priceOneCoffee);
    }

    /*
     * This method is called when the order button is clicked*/
    public void submitOrder(View view) {
        if (quantityCoffee > 0) {
            displayPrice(quantityCoffee * priceOneCoffee);
        } else {
            displayPrice(priceOneCoffee);
        }
    }

    /*
     * This method is called when to arrive the moment of the show at information for the user */
    private void display(int quantity) {
        TextView quantityTextView = findViewById(R.id.quantity_text_view);
        quantityTextView.setText(String.valueOf(quantity));
    }

    /*
     * This method is called when to arrive the moment of the show the value of the coffee for user */
    private void displayPrice(double price) {
        TextView valuePriceTextView = findViewById(R.id.value_price_text_view);
        valuePriceTextView.setText(NumberFormat.getCurrencyInstance().format(price));
    }

    /* Method that is used for clear the fields in the program */
    public void clearOrder(View view) {
        if (quantityCoffee > 0) {
            quantityCoffee = 0;

            displayInitial(quantityCoffee, priceOneCoffee);

            Toast.makeText(this, "Limpeza realizada com sucesso", Toast.LENGTH_SHORT).show();
        }
    }

    /*
     * This method is called when the plus button is clicked */
    public void increment(View view) {
        display(++quantityCoffee);
    }

    /*
     * This method is called when the minus button is clicked */
    public void decrement(View view) {
        if (quantityCoffee > 0) {
            display(--quantityCoffee);
        }
    }

    /*
    * This method initialize the fields of the screen with data initial, after screen clear */
    private void displayInitial(int quantityCoffeeInitial, double priceCoffeeInitial) {
        display(quantityCoffeeInitial);
        displayPrice(priceCoffeeInitial);
    }
}

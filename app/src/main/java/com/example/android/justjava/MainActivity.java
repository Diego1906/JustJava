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

    private int quantityCoffee = 2;
    private int priceOneCoffee = 10;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        displayInitial(quantityCoffee, priceOneCoffee);
    }

    /*
     * This method is called when the order button is clicked*/
    public void submitOrder(View view) {
        display(quantityCoffee);
        displayPrice(quantityCoffee * priceOneCoffee);
    }

    /*
     * This method is called when to arrive the moment of the show at information for the user */
    private void display(int quantity) {
        TextView quantityTextView = findViewById(R.id.quantity_text_view);
        quantityTextView.setText(String.valueOf(quantity));
    }

    /*
     * This method is called when to arrive the moment of the show the value of the coffee for user */
    private void displayPrice(int price) {
        TextView valuePriceTextView = findViewById(R.id.value_price_text_view);
        valuePriceTextView.setText(NumberFormat.getCurrencyInstance().format(price));
    }

    /* Method that is used for clear the fields in the program */
    public void clearOrder(View view) {
        if (quantityCoffee != 0) {
            quantityCoffee = 0;

            TextView quantityTextView = findViewById(R.id.quantity_text_view);
            quantityTextView.setText(String.valueOf(quantityCoffee));

            TextView valuePrice = findViewById(R.id.value_price_text_view);
            valuePrice.setText(NumberFormat.getCurrencyInstance().format(quantityCoffee));

            Toast.makeText(this, "Limpeza realizada com sucesso", Toast.LENGTH_SHORT).show();
        }
    }

    /*
     * This method is called when the plus button is clicked */
    public void increment(View view) {
        // int quantity = 3;
        // display(quantity);
        display(++quantityCoffee);
    }

    /*
     * This method is called when the minus button is clicked */
    public void decrement(View view) {
        //int quantity = 1;
        //display(quantity);
        if (quantityCoffee > 0) {
            quantityCoffee--;
        }
        display(quantityCoffee);
    }

    private void displayInitial(int quantityCoffeeInitial, int priceCoffeeInitial) {
        display(quantityCoffeeInitial);
        displayPrice(priceCoffeeInitial);
    }
}

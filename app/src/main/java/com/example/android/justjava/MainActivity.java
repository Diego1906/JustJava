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

    private int quantityCoffee = 0;
    private int priceOneCoffee = 5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /*
     * This method is called when the order button is clicked*/
    public void submitOrder(View view) {
        quantityCoffee++;
        display(quantityCoffee);
        displayPrice(quantityCoffee * priceOneCoffee);
    }

    /*
    * This method is called when to arrive the moment of the show at information for the user */
    private void display(int number) {
        TextView quantityTextView = findViewById(R.id.quantity_text_view);
        quantityTextView.setText(String.valueOf(number));
    }

    /*
    * This method is called when to arrive the moment of the show the value of the coffee for user */
    private void displayPrice(int number) {
        TextView valuePriceTextView = findViewById(R.id.value_price_text_view);
        valuePriceTextView.setText(NumberFormat.getCurrencyInstance().format(number));
    }

    /* Method that is used for clear the fields in the program */
    public void clearOrder(View view) {
        if (quantityCoffee != 0) {
            quantityCoffee = 0;

            TextView quantityTextView = findViewById(R.id.quantity_text_view);
            quantityTextView.setText(String.valueOf(quantityCoffee));

            TextView valuePrice = findViewById(R.id.value_price_text_view);
            valuePrice.setText(String.valueOf("R$" + quantityCoffee));

            Toast.makeText(this, "Limpeza realizada com sucesso", Toast.LENGTH_SHORT).show();
        }
    }
}

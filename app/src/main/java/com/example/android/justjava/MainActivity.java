package com.example.android.justjava;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.text.NumberFormat;

/*
 * This app displays an order form to order coffee
 * */
public class MainActivity extends AppCompatActivity {

    private int number = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /*
     * This method is called when the order button is clicked*/
    public void submitOrder(View view) {
        number++;
        display(number);
    }

    private void display(int number) {
        TextView quantityTextView = findViewById(R.id.quantity_text_view);
        quantityTextView.setText(String.valueOf(number));
    }

    private void displayPrice(int number) {
        TextView priceTextView = findViewById(R.id.price_text_view);
        priceTextView.setText(NumberFormat.getCurrencyInstance().format(number));
    }

    public void clearOrder(View view) {
        if (number != 0) {
            number = 0;
            TextView quantityTextView = findViewById(R.id.quantity_text_view);
            quantityTextView.setText(String.valueOf(number));
            Toast.makeText(this, "Limpeza realizada com sucesso", Toast.LENGTH_SHORT).show();
        }
    }
}

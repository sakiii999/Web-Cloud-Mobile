package com.example.karthik.myorder;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private static final String MAIN_ACTIVITY_TAG = "MainActivity";
//    final int COFFEE_PRICE = 5;
//    final int WHIPPED_CREAM_PRICE = 1;
//    final int CHOCOLATE_PRICE = 2;
    int quantity = 2;

    final int PIZZA_PRICE = 10;
    final double TOPPING_PRICE_REG = .5;
    final int TOPPING_PRICE_PREM = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    /**
     * This method is called when the order button is clicked.
     */
    public void submitOrder(View view) {

//        get user input
        EditText userInputNameView = (EditText) findViewById(R.id.user_input);
        String userInputName = userInputNameView.getText().toString();

        CheckBox onions = (CheckBox) findViewById(R.id.onions_checked);
        boolean hasOnions = onions.isChecked();
        CheckBox peppers = (CheckBox) findViewById(R.id.peppers_checked);
        boolean hasPeppers = peppers.isChecked();
        CheckBox sausage = (CheckBox) findViewById(R.id.sausage_checked);
        boolean hasSausage = sausage.isChecked();
        CheckBox pepperoni = (CheckBox) findViewById(R.id.pepperoni_checked);
        boolean hasPepperoni = pepperoni.isChecked();
//        calculate and store the total price
        float totalPrice = calculatePrice(hasOnions, hasPeppers, hasSausage, hasPepperoni);
//        create and store the order summary
        String orderSummaryMessage = createOrderSummary(userInputName, hasOnions, hasPeppers, hasSausage, hasPepperoni, totalPrice);
// Write the relevant code for making the buttons work(i.e impelement the implicit and explicit intents
        Intent emailIntent = new Intent(Intent.ACTION_SEND);
        emailIntent.setType("message/rfc822");
        emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Pizza Order");
        emailIntent.putExtra(Intent.EXTRA_TEXT, orderSummaryMessage);
        startActivity(emailIntent);
    }
    private String boolToString(boolean bool){
        return bool?(getString(R.string.yes)):(getString(R.string.no));

    }

    private String createOrderSummary(String userInputName, boolean hasOnions, boolean hasPeppers, boolean hasSausage, boolean hasPepperoni, float price) {
        String orderSummaryMessage = getString(R.string.order_summary_name,userInputName) +"\n"+
                getString(R.string.order_summary_onions,boolToString(hasOnions))+"\n"+
                getString(R.string.order_summary_peppers,boolToString(hasPeppers)) +"\n"+
                getString(R.string.order_summary_sausage,boolToString(hasSausage)) + "\n"+
                getString(R.string.order_summary_pepperoni,boolToString(hasPepperoni)) + "\n"+
                getString(R.string.order_summary_quantity,quantity)+"\n"+
                getString(R.string.order_summary_total_price,price) +"\n"+
                getString(R.string.thank_you);
        return orderSummaryMessage;

    }

    public void reviewOrder(View view) {
        EditText userInputNameView = (EditText) findViewById(R.id.user_input);
        String userInputName = userInputNameView.getText().toString();
        CheckBox onions = (CheckBox) findViewById(R.id.onions_checked);
        boolean hasOnions = onions.isChecked();
        CheckBox peppers = (CheckBox) findViewById(R.id.peppers_checked);
        boolean hasPeppers = peppers.isChecked();
        CheckBox sausage = (CheckBox) findViewById(R.id.sausage_checked);
        boolean hasSausage = sausage.isChecked();
        CheckBox pepperoni = (CheckBox) findViewById(R.id.pepperoni_checked);
        boolean hasPepperoni = pepperoni.isChecked();
//        calculate and store the total price
        float totalPrice = calculatePrice(hasOnions, hasPeppers, hasSausage, hasPepperoni);

        String summary = createOrderSummary(userInputName, hasOnions, hasPeppers, hasSausage, hasPepperoni, totalPrice);
        Intent intent = new Intent(getBaseContext(), ReviewActivity.class);
        intent.putExtra("SUMMARY", summary);
        startActivity(intent);
    }


    /**
     * Method to calculate the total price
     *
     * @return total Price
     */
    private float calculatePrice(boolean hasOnions, boolean hasPeppers, boolean hasSausage, boolean hasPepperoni) {
        int basePrice = PIZZA_PRICE;
        if (hasOnions) {
            basePrice += TOPPING_PRICE_REG;
        }
        if (hasPeppers) {
            basePrice += TOPPING_PRICE_REG;
        }
        if (hasSausage) {
            basePrice += TOPPING_PRICE_PREM;
        }
        if (hasPepperoni) {
            basePrice += TOPPING_PRICE_PREM;
        }
        return quantity * basePrice;

    }

    /**
     * This method displays the given quantity value on the screen.
     */
    private void display(int number) {
        TextView quantityTextView = (TextView) findViewById(R.id.quantity_text_view);
        quantityTextView.setText("" + number);

    }


    /**
     * This method increments the quantity of coffee cups by one
     *
     * @param view on passes the view that we are working with to the method
     */

    public void increment(View view) {
        if (quantity < 100) {
            quantity = quantity + 1;
            display(quantity);
        } else {

            Log.i("MainActivity", "Please select less than one hundred pizzas");
            Context context = getApplicationContext();
            String lowerLimitToast = getString(R.string.too_much_pizza);
            int duration = Toast.LENGTH_SHORT;
            Toast toast = Toast.makeText(context, lowerLimitToast, duration);
            toast.show();
            return;

        }
    }

    /**
     * This method decrements the quantity of coffee cups by one
     *
     * @param view passes on the view that we are working with to the method
     */
    public void decrement(View view) {
        if (quantity > 1) {
            quantity = quantity - 1;
            display(quantity);
        } else {

            Log.i("MainActivity", "Please select at least one Pizza");
            Context context = getApplicationContext();
            String upperLimitToast = getString(R.string.too_little_pizza);
            int duration = Toast.LENGTH_SHORT;
            Toast toast = Toast.makeText(context, upperLimitToast, duration);
            toast.show();
            return;


        }
    }
}

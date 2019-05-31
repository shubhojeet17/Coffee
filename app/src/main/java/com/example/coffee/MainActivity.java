package com.example.coffee;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    int quntity = 1;
    int price;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void increment(View view) {
        quntity = quntity + 1;
        updatequantity(quntity);
    }

    private void updatequantity(int n) {
        TextView textView = (TextView) findViewById(R.id.qunatityview);
        textView.setText(String.valueOf(n));
    }

    public void decrement(View view) {
        TextView textView = (TextView) findViewById(R.id.qunatityview);
        if(quntity == 1){
            Toast.makeText(this,"Minimum no of cup of coffee is one",Toast.LENGTH_SHORT).show();
        }else{
            quntity = quntity - 1;
            updatequantity(quntity);

        }
    }

    public void orderbutton(View view) {
        price = 10 * quntity;
        CheckBox chocolatecheckbox = (CheckBox) findViewById(R.id.addedchocolate);
        CheckBox whippedcreamcheckbox = (CheckBox) findViewById(R.id.addedwhippedcream);
        TextView textView = (TextView) findViewById(R.id.ordersummary);
        EditText editText = (EditText) findViewById(R.id.name);
        String name = editText.getText().toString();
        String chocolate = "Add Chocolate? "+chocolatecheckbox.isChecked();;
        String whippedcream = "Add Whipped Cream? "+whippedcreamcheckbox.isChecked();;
        String summary;
        if(chocolatecheckbox.isChecked()){
            price = price + 5;
        }if(whippedcreamcheckbox.isChecked()){
            price = price + 3;
        }
        summary = "\nName: "+name+"\n"+chocolate+"\n"+whippedcream+"\nQuantity: "+quntity+"\nTotal Price: "+"$"+price+"\nThank You!";
        textView.setText(summary);

    }
}

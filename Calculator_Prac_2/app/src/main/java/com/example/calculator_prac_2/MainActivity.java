package com.example.calculator_prac_2;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.calculator_prac_2.databinding.ActivityMainBinding;
import com.google.android.material.button.MaterialButton;

import org.mozilla.javascript.Context;
import org.mozilla.javascript.Scriptable;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    TextView solution_text, result_text;
    MaterialButton buttonC, buttonOpen, buttonClose, buttonDivide;
    MaterialButton button7, button8, button9, buttonMultiply;
    MaterialButton button4, button5, button6, buttonSubtract;
    MaterialButton button1, button2, button3, buttonAdd;
    MaterialButton buttonAC, button0, buttonDot, buttonEquals;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        result_text = findViewById(R.id.result_text);
        solution_text = findViewById(R.id.solution_text);

        assignId(buttonC, R.id.button_c);
        assignId(buttonAC, R.id.button_ac);

        assignId(button0, R.id.button_0);
        assignId(button1, R.id.button_1);
        assignId(button2, R.id.button_2);
        assignId(button3, R.id.button_3);
        assignId(button4, R.id.button_4);
        assignId(button5, R.id.button_5);
        assignId(button6, R.id.button_6);
        assignId(button7, R.id.button_7);
        assignId(button8, R.id.button_8);
        assignId(button9, R.id.button_9);

        assignId(buttonOpen, R.id.button_open);
        assignId(buttonClose, R.id.button_close);

        assignId(buttonDivide, R.id.button_divide);
        assignId(buttonDot, R.id.button_decimal);
        assignId(buttonAdd, R.id.button_add);
        assignId(buttonSubtract, R.id.button_subtract);
        assignId(buttonMultiply, R.id.button_multiply);
        assignId(buttonEquals, R.id.button_equals);

    }

    void assignId(MaterialButton btn, int id){
        btn = findViewById(id);
        btn.setOnClickListener(this);
    }


    @Override
    public void onClick(View view) {
        MaterialButton btn = (MaterialButton) view;
        String btnText = btn.getText().toString();
        String dataToCalculate = solution_text.getText().toString();

        if(btnText.equals("AC")){
            solution_text.setText("");
            result_text.setText("0");
            return;
        }

        if(btnText.equals("=")){
            solution_text.setText(result_text.getText());
            return;
        }

        if(btnText.equals("C")){
            if(dataToCalculate.length()>1) dataToCalculate = dataToCalculate.substring(0, dataToCalculate.length()-1);
            else dataToCalculate = "0";
        }else{
            dataToCalculate += btnText;
        }

        if(dataToCalculate.endsWith("/0")){
            Toast.makeText(view.getContext(), "Cannont divide by 0.", Toast.LENGTH_LONG).show();
            return;
        }

        solution_text.setText(dataToCalculate);
        String result = getResult(dataToCalculate);

        if(!result.equals("Error"))
            result_text.setText(result);
    }

    String getResult(String data){
        try{
            Context context  = Context.enter();
            context.setOptimizationLevel(-1);
            Scriptable scriptable = context.initStandardObjects();

            DecimalFormat df = new DecimalFormat("#.###");

            String finalResult =  context.evaluateString(scriptable,data,"Javascript",1,null).toString();

            double temp = Double.valueOf(finalResult);
//            df.format(temp);
            temp = Math.round(temp*1000.0)/1000.0;
            finalResult = String.valueOf(temp);

            if(finalResult.endsWith(".0")){
                finalResult = finalResult.replace(".0","");
            }
            return finalResult;
        }catch (Exception e){
            return "Error";
        }
    }
}
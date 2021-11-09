package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    //declare screen text view
    private TextView Screen;
    //Declare all keyboard buttons 
    private Button AC,Power,Back,Div,One,Two,Three,Four,Five,Six,Seven,Eight,Nine,Zero,Ans,Equal,Addition,Sub,Multiplication,Point; 
    // declare String to get input and answer string is for taking the solution
    private String input,Answer;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //assigning the variables to specific id's
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Screen=findViewById(R.id.screen);
        AC=findViewById(R.id.ac);
        Power=findViewById(R.id.power);
        Back=findViewById(R.id.back);
        Div=findViewById(R.id.div);
        One=findViewById(R.id.one);
        Two=findViewById(R.id.two);
        Three=findViewById(R.id.three);
        Four=findViewById(R.id.four);
        Five=findViewById(R.id.five);
        Six=findViewById(R.id.six);
        Seven=findViewById(R.id.seven);
        Eight=findViewById(R.id.eight);
        Nine=findViewById(R.id.nine);
        Zero=findViewById(R.id.zero);
        Ans=findViewById(R.id.ans);
        Equal=findViewById(R.id.equal);
        Addition=findViewById(R.id.addition);
        Sub=findViewById(R.id.sub);
        Multiplication=findViewById(R.id.multiplication);
        Point=findViewById(R.id.point);
    }
    // create button click method 
    public void ButtonClick(View view){
        Button button=(Button) view;
        // declare data string for getting the button text 
        String data=button.getText().toString();
        // using switch case data define for each buttons
        switch (data){
            case"AC":
                input="";
                break;
            case"Ans":
                input+=Answer;
                break;
            case "*":
                Solve();
                input+="*";
                break;
            case  "^":
                Solve();
                input+="^";
                break;
            case "=":
                Solve();
                Answer=input;
                break;
            case "C":
                String newText=input.substring(0,input.length()-1);
                input=newText;
                break;
            default:
                if(input==null){
                    input="";
                }
                if(data.equals("+") || data.equals("-") || data.equals("/")){
                    Solve();
                }
                input+=data;
        }
        // to display on the screen 
        Screen.setText(input);
    }

    private void Solve(){
        // using split method to identify between numbers and operators
        if(input.split("\\*").length==2){
            String number[]=input.split("\\*");
            try {
                double mul = Double.parseDouble(number[0]) * Double.parseDouble(number[1]);
                input = mul+"";
            }
            catch (Exception e){
                //Toggle error
            }


        }
        else if(input.split("/").length==2){
            String number[]=input.split("/");
            try {
                double div = Double.parseDouble(number[0]) / Double.parseDouble(number[1]);
                input = div+"";
            }
            catch (Exception e){
                //Toggle error
            }


        }
        else if(input.split("\\^").length==2){
            String number[]=input.split("\\^");
            try {
                double pow  = Math.pow(Double.parseDouble(number[0]),Double.parseDouble(number[1]));
                input = pow+"";
            }
            catch (Exception e){
                //Toggle error
            }


        }
        else if(input.split("\\+").length==2){
            String number[]=input.split("\\+");
            try {
                double sum = Double.parseDouble(number[0]) + Double.parseDouble(number[1]);
                input = sum+"";
            }
            catch (Exception e){
                //Toggle error
            }


        }
        else if(input.split("-").length>1){
            String number[]=input.split("-");
            //to substract from negative numbers like -1-2
            if(number[0]=="" && number.length==2){
                number[0]=0+"";

            }
            try {
                double sub = 0;
                if(number.length==2){
                    sub = Double.parseDouble(number[0]) - Double.parseDouble(number[1]);
                }
                else if(number.length==3){
                    sub = -Double.parseDouble(number[1]) - Double.parseDouble(number[2]);
                }
                input = sub+"";
            }
            catch (Exception e){
                //Toggle error
            }


        }
        // to remove last digit from .0 from integer result like 5 instead of 5.0
        String n[]=input.split("\\.");
        if(n.length>1){
            if(n[1].equals("0")){
                input=n[0];

            }
        }
        Screen.setText(input );


    }
}

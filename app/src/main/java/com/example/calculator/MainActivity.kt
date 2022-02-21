package com.example.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.InputFilter
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
    var flagForDot=true;
    fun checkRepid(value:String){
        val elem:TextView=findViewById(R.id.tvInput);
        val content=elem.text.toString();
        if (value!="."){
            if("+" in content||"-" in content|| "*" in content|| "/" in content){
                return
            }
        }
        if(content.length>0&& !(value in content)){
            elem.append(value);
        }
    }
    fun toDoForResult(value:String){
        val elem:TextView=findViewById(R.id.tvInput);
        val content=elem.text.toString();
        val array= mutableListOf<String>("+","-","*","/");
       val forSecondNum=content;
        var i =0;
        for(i in 0..content.length){
            if(content[i].toString()==value){
                val first=content.substring(0,i).toInt();
                val second=forSecondNum.substring(i+1,forSecondNum.length).toInt();
                val elem:TextView=findViewById(R.id.tvInput);
                if(value=="+"){
                    elem.setText("${first+second}");
                }
                if(value=="-"){
                    elem.setText("${first-second}");
                }
                if(value=="*"){
                    elem.setText("${first*second}");
                }
                if(value=="/"){
                    elem.setText("${first.toFloat()/second.toFloat()}");
                }
                return
            }
        }
    }
    fun onDigit(view:View){
        val elem:TextView=findViewById(R.id.tvInput);
        elem.append((view as Button).text);
    }
    fun onCLR(view:View){
        val elem:TextView=findViewById(R.id.tvInput);
        elem.text="";
    }
    fun onCheckButtonOne(view: View){
        this.checkRepid((view as Button).text.toString());
    }
    fun onResult(view: View){
        val elem:TextView=findViewById(R.id.tvInput);
        val content=elem.text.toString();
        for(n in content){
            Toast.makeText(this,n.toString(),Toast.LENGTH_SHORT);
            if(n.toString().toIntOrNull()==null&&n!='.'){
                Log.d("TAG",n.toString());
                this.toDoForResult(n.toString());
                break;
            }
        }
    }
}

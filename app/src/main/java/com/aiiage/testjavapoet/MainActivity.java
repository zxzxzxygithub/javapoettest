package com.aiiage.testjavapoet;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.aiiage.libannotation.HelloAnnotation;

@HelloAnnotation
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView tv=findViewById(R.id.tv);
        String str1="";
        str1+=HelloWorld.hello1()+" ";
        str1+=HelloWorld.hello2()+" ";
        str1+=HelloWorld.hello3();
        tv.setText(str1);
    }
}

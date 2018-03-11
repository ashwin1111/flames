package com.example.ashwin.flames;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Environment;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.File;
import java.io.IOException;


public class MainActivity extends AppCompatActivity {
    Button f;
    EditText d,d1,d2;
    int n,n1,z,q;
    StringBuffer s,s1;
    ConstraintLayout mealLayout;
    char num[]={'0','1','2','3','4','5','6','7','8','9'};



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        f=(Button)findViewById(R.id.button2);
        d=(EditText) findViewById(R.id.editText4);
        d1=(EditText) findViewById(R.id.editText5);
        d2=(EditText) findViewById(R.id.editText6);
        //z=n+n1;
        mealLayout=(ConstraintLayout) findViewById(R.id.mealLayout);
        f.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View view)
            {
                char result;
                int flag=0,flag1=0;
                final String a1=String.valueOf(d.getText());
                final String a2=String.valueOf(d1.getText());
                int a1len=a1.length();
                int a2len=a2.length();
                for(int i=0;i<a1len;i++)
                {
                    for(int j=0;j<=9;j++)
                    {
                        if(a1.charAt(i)==num[j])
                        {
                            flag=1;
                        }

                    }

                }
                for(int i=0;i<a2len;i++)
                {
                    for(int j=0;j<=9;j++)
                    {
                        if((a2.charAt(i)==num[j]))
                        {
                            flag1=1;
                        }
                    }

                }
                if((flag==0) && (flag1==0))
                {
                    s = new StringBuffer(a1.toLowerCase());
                    s1 = new StringBuffer(a2.toLowerCase());
                    n = s.length();
                    n1 = s1.length();
                    final String aa = String.valueOf(d1.getText());
                    for (int i = 0; i < n; i++) {
                        char c = s.charAt(i);
                        for (int j = 0; j < n1; j++) {
                            char d = s1.charAt(j);
                            if (c == d) {

                                s.deleteCharAt(i);
                                s1.deleteCharAt(j);
                                n = s.length();
                                n1 = s1.length();
                                //z=z-2;
                                i = 0;
                                j = 0;

                            }
                        }
                    }
                    int n2 = n + n1;
                    //int l=6;
                    int z1;
                    StringBuffer s2 = new StringBuffer("flames");
                    String s3 = new String();
                    for (int i = 0; i < 5; i++) {
                        int q = -1, l = 0, p = 0;
                        for (int j = 1; j <= n2; j++) {
                            q++;
                            l++;
                            if (q > s2.length() - 1) {
                                char e = s2.charAt(p);
                                if (l == n2) {
                                    s2.deleteCharAt(p);
                                    s3 = s2.substring(p, s2.length());
                                    s2.delete(p, s2.length());
                                    s2.insert(0, s3);
                                    break;
                                } else {
                                    p++;
                                    if (p == s2.length()) {
                                        p = 0;
                                    }
                                }
                            } else {
                                char e = s2.charAt(q);
                                if (l == n2) {
                                    s2.deleteCharAt(n);
                                    s3 = s2.substring(n, s2.length());
                                    s2.delete(n, s2.length());
                                    s2.insert(0, s3);
                                    break;
                                }

                            }
                        }
                    }
                    result=s2.charAt(0);

                switch(result)
                {
                    case 'f':
                        mealLayout.setBackgroundColor(Color.rgb(204,214,255));
                        d2.setText(aa+" is your Friend!!!");
                        InputMethodManager obj2 = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
                        obj2.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(),InputMethodManager.HIDE_NOT_ALWAYS);
                        break;
                    case 'l':
                        mealLayout.setBackgroundColor(Color.RED);
                        d2.setText(aa+" is your Love!!!");

                        InputMethodManager obj3 = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
                        obj3.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(),InputMethodManager.HIDE_NOT_ALWAYS);
                        break;
                    case 'a':
                        mealLayout.setBackgroundColor(Color.CYAN);
                        d2.setText(aa+" is your Affection!!!");

                        InputMethodManager obj4 = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
                        obj4.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(),InputMethodManager.HIDE_NOT_ALWAYS);
                        break;
                    case 'm':
                        mealLayout.setBackgroundColor(Color.GREEN);
                        d2.setText(aa+" gonna Marry You!!!");

                        InputMethodManager obj5 = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
                        obj5.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(),InputMethodManager.HIDE_NOT_ALWAYS);
                        break;
                    case 'e':
                        mealLayout.setBackgroundColor(Color.blue(2));
                        d2.setText(aa+ " is your Enemy!!!");

                        InputMethodManager obj6 = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
                        obj6.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(),InputMethodManager.HIDE_NOT_ALWAYS);
                        break;
                    case 's':
                        mealLayout.setBackgroundColor(Color.GRAY);
                        d2.setText(aa +" is your Sister!!!");

                        InputMethodManager obj7 = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
                        obj7.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(),InputMethodManager.HIDE_NOT_ALWAYS);
                        break;
                }
                }
                else
                {

                   if(flag==1)
                   {
                       d.setError("Only Enter alphabets");
                   }
                   if(flag1==1)
                   {
                       d1.setError("only Enter alphabets");
                   }
                   flag=0;
                   flag1=1;

                }

                //d2.setText("result");
            }
});
    }

    }

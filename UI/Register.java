package com.madroid.myapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Register extends AppCompatActivity {
    private EditText ename,eid,contact,pwd,pwd1;
    private String name,id1,phone,password,cpassword;
    Button sbtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        ename=(EditText)findViewById(R.id.ename);
        eid=(EditText)findViewById(R.id.eid);
        contact=(EditText)findViewById(R.id.contact);
        pwd=(EditText)findViewById(R.id.pwd);
        pwd1=(EditText)findViewById(R.id.pwd1);
        sbtn=(Button)findViewById(R.id.sbtn);
        sbtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view)
            {
                submit();
            }
        });
        sbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                Intent i = new Intent(Register.this,Verify.class);
                startActivity(i);

            }
        });


    }
    public void submit()
    {
        initialize();
        if(!validate())
        {
            Toast.makeText(this, "signup has failed",Toast.LENGTH_SHORT).show();
        }
        else{
            Toast.makeText(this, "SUCCESSFULLY REGISTERED",Toast.LENGTH_SHORT).show();
        }
    }

    public boolean validate(){
        boolean valid = true;
        if(name.isEmpty()||name.length()>32){
            ename.setError("please enter valid name");
            valid = false;
        }
        if(id1.isEmpty())
        {
            eid.setError("Please enter valid Eid");
            valid = false;
        }
        if(phone.isEmpty())
        {
            contact.setError("Please enter valid contact");
            valid = false;
        }
        if(password.isEmpty())
        {
            pwd.setError("Please enter valid password");
            valid = false;
        }
        if(!cpassword.equals(password))
        {
            pwd1.setError("Password dosen't match");
            valid = false;
        }
        return valid;
    }
    public void initialize()
    {
        name=ename.getText().toString().trim();
        id1=eid.getText().toString().trim();
        phone=contact.getText().toString().trim();
        password=pwd.getText().toString().trim();
        cpassword=pwd1.getText().toString().trim();
    }


}


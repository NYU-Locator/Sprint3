package com.example.mylocator;

import android.os.Bundle;  
import android.support.v4.app.Fragment;  
import android.view.LayoutInflater;  
import android.view.View;  
import android.view.ViewGroup;  
import android.widget.Button;  
import android.widget.TextView;
import android.widget.Toast;  
  
public class ButtonFragment extends Fragment{  
    Button myButton;  
    Button myButton2;
    TextView myTextView;
    @Override  
    public View onCreateView(LayoutInflater inflater, ViewGroup container,  
            Bundle savedInstanceState) {  
        View rootView = inflater.inflate(R.layout.guide_1, container, false);//get the layout file  
          
        myButton = (Button)rootView.findViewById(R.id.mybutton);//get the button from rootView  
        myButton2 = (Button)rootView.findViewById(R.id.mybutton2);// 
        myTextView=(TextView) rootView.findViewById(R.id.mytextview);  
        //  
        myButton.setOnClickListener(new View.OnClickListener() {  
              
            @Override  
            public void onClick(View v) {  
                // TODO Auto-generated method stub  
            	myTextView.setText("haha");
                Toast.makeText(ButtonFragment.this.getActivity(), "button is click!", Toast.LENGTH_SHORT).show();  
            }  
        });  
        myButton2.setOnClickListener(new View.OnClickListener() {  
            
            @Override  
            public void onClick(View v) {  
                // TODO Auto-generated method stub
            	myTextView.setText("hehe");
                Toast.makeText(ButtonFragment.this.getActivity(), "button2 is click!", Toast.LENGTH_SHORT).show();  
            }  
        }); 
          
          
        return rootView;  
    }  
}  

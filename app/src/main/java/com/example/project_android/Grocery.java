package com.example.project_android;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Grocery#} factory method to
 * create an instance of this fragment.
 */
public class Grocery extends Activity {
    SearchView searchView;
    String[] items={"Apple", "Banana ", "Brinjal  ", "India Gate Basmati Rice ", "Kidney Beans", "Mango ", "Orange "};
    String[] items1={"$ 2.99 (1 lbs)","$ 0.99 (1 lbs)","$ 1.99 (1 lbs) ","$ 16.99(10 lbs)", "$ 8.99 (4 lbs)", " $ 2 (1 pc)", "$ 5 (1 lbs) "};
    Integer[] imageid = {
            R.drawable.apple,
            R.drawable.banana,
            R.drawable.brinjal,
            R.drawable.rice,
            R.drawable.kidney,
            R.drawable.mango,
            R.drawable.orange

    };
    Context context;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        searchView = (SearchView) findViewById(R.id.searchView);
        context=this;
        ListView lstview=findViewById(R.id.list);

        lstview.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            public void onItemClick(AdapterView<?> parent, View view, int i, long id){

                // Getting listview click value into String variable.
                ArrayList<String> text = new ArrayList<>();

                text.add(items[i]);

                Intent intent = new Intent(Grocery.this, MyList.class);

                // Sending value to another activity using intent.
                intent.putExtra("key", text);

                startActivity(intent);
                Toast.makeText(context, "An item of the ListView is clicked.", Toast.LENGTH_LONG).show();
            }
        });



        /*public void onItemClick(AdapterView < ? > adapterView, View view, int i, long l)
   {
    Toast.makeText(getBaseConext(), "You selected : " + countries[i], Toast.LENGTH_SHORT).show();
   }
  });

  Button button = findViewById(R.id.button);
      button.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View v) {
            String value = editText.getText().toString().trim();
            Bundle bundle = new Bundle();
            bundle.putString("value",value);
            Intent intent = new Intent(MainActivity.this, SecondActivity.class);
            intent.putExtras(bundle);
            startActivity(intent);
         }
      });


      protected void onCreate(Bundle savedInstanceState) {
      super.onCreate(savedInstanceState);
      setContentView(R.layout.activity_second);
      Bundle bundle = getIntent().getExtras();
      if (bundle ! = null) {
         String value = bundle.getString("value");
         TextView textView = findViewById(R.id.text_view);
         textView.setText(value);
      }
  */


        LstViewAdapter adapter=new LstViewAdapter(this,R.layout.list_item,R.id.txt,items, items1, imageid);
        // Bind data to the ListView
        lstview.setAdapter(adapter);




    }
    /*public void clickMe(View view){
        Button bt=(Button)view;
        Toast.makeText(this, "Button "+bt.getText().toString(),Toast.LENGTH_LONG).show();
    }*/

}

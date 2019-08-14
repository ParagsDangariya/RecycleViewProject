package com.example.recycleviewproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

public class MainActivity extends AppCompatActivity {


    ArrayList<Pokemon> pro;
    Recycleadapter adpt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        String ls = getResources().getString(R.string.link);
        pro =  new ArrayList<>();

        try {
            String mysts =  new Asycdata().execute(ls).get();

            System.out.println("This is from MainActivity:"+mysts);

            JSONObject mainobj =  new JSONObject(mysts);

            JSONArray proarray = mainobj.getJSONArray("Pokemon");

            for (int i=0;i<proarray.length();i++ )
            {
                JSONObject childobj = proarray.getJSONObject(i);

                String pname = childobj.getString("name");
                String pimg = childobj.getString("image");
                String type = childobj.getString("type");
                String description = childobj.getString("description");
                String ability = childobj.getString("ability");
                String weight = childobj.getString("weight");
                String height = childobj.getString("height");

                pro.add(new Pokemon(pimg,pname,type,description,ability,weight,height));

                //System.out.println("Bag names : "+childobj.getString("title"));
            }

            adpt = new Recycleadapter(pro,getApplication());
            initview();




        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public void initview(){
        @SuppressLint("WrongConstant") LinearLayoutManager manager = new LinearLayoutManager(getApplicationContext(),LinearLayoutManager.VERTICAL,false);

        RecyclerView recyclerView = findViewById(R.id.recycle_poke);
        recyclerView.setLayoutManager(manager);
        recyclerView.setAdapter(adpt);

        adpt.setOnClickListner(onClickListener);

    }
    public View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {

            RecyclerView.ViewHolder vh = (RecyclerView.ViewHolder) view.getTag();

            int position = vh.getAdapterPosition();
            Toast.makeText(getApplicationContext(),pro.get(position).getPname(),Toast.LENGTH_SHORT).show();

        }
    };

}

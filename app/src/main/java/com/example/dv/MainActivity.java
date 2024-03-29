package com.example.dv;

import static com.example.dv.R.*;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.dv.Adapters.MainAdapter;
import com.example.dv.Models.MainModel;
import com.example.dv.databinding.ActivityMainBinding;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding= ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        ArrayList<MainModel>list=new ArrayList<>();

        list.add(new MainModel(drawable.burger,"Cheese Burger","60","A huge burger with all the fixings, cheese, lettuce, tomato, onions and special sauce or mayonnaise!"));
        list.add(new MainModel(drawable.pizza,"Pizza","100","Pizza: making bad days better since forever"));
        list.add(new MainModel(drawable.vadapav,"Vada pav","20","A popular Indian street food consisting of a spicy potato fritter served in a bun"));
        list.add(new MainModel(drawable.samosa,"Samosa","100"," Crispy triangular pastry filled with savory spiced potatoes and peas"));
        list.add(new MainModel(drawable.sandwich,"Cheese Sandwich","50"," A layered snack made with bread slices enclosing various fillings like vegetables, cheese, or meat"));
        list.add(new MainModel(drawable.panipuri1,"Pani puri","50","Small crispy hollow balls filled with spicy tangy water, potatoes, chickpeas, and chutney"));
        list.add(new MainModel(drawable.manchurian,"Manchurian","40"," Indo-Chinese dish featuring fried vegetable or meatballs tossed in a tangy sauce"));
        list.add(new MainModel(drawable.frankie,"Frankie","80","Indian street food wrap filled with spicy marinated meats or vegetables"));
        list.add(new MainModel(drawable.french,"French Fries","100"," Deep-fried potato sticks, crispy on the outside and fluffy on the inside, served as a popular snack or side dish"));

        MainAdapter adapter=new MainAdapter(list,this);
        binding.recyclerview.setAdapter(adapter);

        LinearLayoutManager layoutManager=new LinearLayoutManager(this);
        binding.recyclerview.setLayoutManager(layoutManager);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == id.orders) {
            startActivity(new Intent(MainActivity.this, OrdersActivity.class));
        }
        return super.onOptionsItemSelected(item);
    }
}
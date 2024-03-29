package com.example.dv;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.dv.Adapters.OrdersAdapter;
import com.example.dv.Models.OrdersModel;
import com.example.dv.Models.address;
import com.example.dv.databinding.ActivityOrdersBinding;

import java.util.ArrayList;

public class OrdersActivity extends AppCompatActivity {

    ActivityOrdersBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityOrdersBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        DBHelper helper=new DBHelper(this);
        ArrayList<OrdersModel> list= helper.getOrders();
//        list.add(new OrdersModel(R.drawable.burger,"Cheese Burger","60","1134651101"));
//        list.add(new OrdersModel(R.drawable.manchurian,"Manchurian","40","1134651102"));
//        list.add(new OrdersModel(R.drawable.pizza,"Pizza","100","1134651103"));
//        list.add(new OrdersModel(R.drawable.panipuri1,"Pani puri","50","1134651104"));
//        list.add(new OrdersModel(R.drawable.frankie,"Frankie","80","1134651105"));
//        list.add(new OrdersModel(R.drawable.vadapav,"Vada pav","20","1134651106"));
//        list.add(new OrdersModel(R.drawable.samosa,"Samosa","100","1134651107"));
//        list.add(new OrdersModel(R.drawable.sandwich," Cheese Sandwich","50","1134651108"));
//        list.add(new OrdersModel(R.drawable.french,"French Fries","100","1134651109"));


        OrdersAdapter adapter=new OrdersAdapter(list,this);
        binding.orderRecyclerView.setAdapter(adapter);

        LinearLayoutManager layoutManager=new LinearLayoutManager(this);
        binding.orderRecyclerView.setLayoutManager(layoutManager);

        findViewById(R.id.placeOderbtn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent addressintent=new Intent(OrdersActivity.this, address.class);
                startActivity(addressintent);
                finish();
            }
        });
    }
}
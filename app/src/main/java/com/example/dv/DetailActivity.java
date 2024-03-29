package com.example.dv;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.util.Consumer;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.dv.databinding.ActivityDetailBinding;

public class DetailActivity extends AppCompatActivity {

    private int quantity = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {



        ActivityDetailBinding binding;

        super.onCreate(savedInstanceState);
        binding=ActivityDetailBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        DBHelper helper = new DBHelper(this);

        if(getIntent().getIntExtra("type",0)==1) {

            final int image = getIntent().getIntExtra("image", 4);
            final int price = Integer.parseInt(getIntent().getStringExtra("price"));
            final String detailName = getIntent().getStringExtra("name");
            final String description = getIntent().getStringExtra("desc");

            binding.detailImage.setImageResource(image);
            binding.priceLbl.setText(String.format("%d", price));
            binding.detailName.setText(detailName);
            binding.detailDescription.getText().toString();

            binding.add.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    quantity++; // Increment quantity
                    updateQuantityUI(binding);
                }
            });

            // Add functionality for subtracting quantity
            binding.subtract.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (quantity > 1) {
                        quantity--; // Decrement quantity if it's greater than 1
                        updateQuantityUI(binding);
                    } else {
                        Toast.makeText(DetailActivity.this, "Quantity cannot be less than 1", Toast.LENGTH_SHORT).show();
                    }
                }
            });


            binding.insertBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    boolean isInserted = helper.insertOrder(
                            binding.nameBox.getText().toString(),
                            binding.phoneBox.getText().toString(),
                            price,
                            image,
                            detailName,
                            description,
                            Integer.parseInt(binding.quantity.getText().toString())
                    );




                    if (isInserted)
                        Toast.makeText(DetailActivity.this, "Data Success.", Toast.LENGTH_SHORT).show();
                    else
                        Toast.makeText(DetailActivity.this, "Error.", Toast.LENGTH_SHORT).show();

                }
            });
        }else{
            int id=getIntent().getIntExtra("id",0);
            Cursor cursor=helper.getOrderById(id);
            final int image=cursor.getInt(4);
            binding.detailImage.setImageResource(image);
            binding.priceLbl.setText(String.format("%d", cursor.getInt(3)));
            binding.detailName.setText( cursor.getString(6));
            binding.detailDescription.setText( cursor.getString(5));

            binding.nameBox.setText( cursor.getString(1));
            binding.phoneBox.setText( cursor.getString(2));
            binding.insertBtn.setText("Update Now");

            binding.add.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    quantity++; // Increment quantity
                    updateQuantityUI(binding);
                }
            });

            // Add functionality for subtracting quantity
            binding.subtract.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (quantity > 1) {
                        quantity--; // Decrement quantity if it's greater than 1
                        updateQuantityUI(binding);
                    } else {
                        Toast.makeText(DetailActivity.this, "Quantity cannot be less than 1", Toast.LENGTH_SHORT).show();
                    }
                }
            });

            binding.insertBtn.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {
                   boolean isUpdated= helper.updateOrder(
                            binding.nameBox.getText().toString(),
                            binding.phoneBox.getText().toString(),
                            Integer.parseInt(binding.priceLbl.getText().toString()),
                            image,
                            binding.detailDescription.getText().toString(),
                            binding.detailName.getText().toString(),
                            1,
                            id
                    );

                   if(isUpdated)
                       Toast.makeText(DetailActivity.this,"Updated.",Toast.LENGTH_SHORT).show();
                   else
                       Toast.makeText(DetailActivity.this,"Failed.",Toast.LENGTH_SHORT).show();

                }
            });

        }
    }
    private void updateQuantityUI(ActivityDetailBinding binding) {
        binding.quantity.setText(String.valueOf(quantity));
    }
}
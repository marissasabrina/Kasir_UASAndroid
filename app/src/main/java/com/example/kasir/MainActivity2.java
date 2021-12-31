package com.example.kasir;

import android.os.Bundle;
import android.view.View;;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;


public class MainActivity2 extends AppCompatActivity {
    String[] menu = {"Choose", "Shampoo", "Deodorant","Sabun Mandi","Sikat Gigi", "Pasta Gigi"};
    Spinner s1;
    EditText harga;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        s1 = (Spinner) findViewById(R.id.spinner);
        harga = (EditText) findViewById(R.id.tvTotalPrice);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, menu);
        s1.setAdapter(adapter);
        Button btnAdd = (Button) findViewById(R.id.btnAdd);
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View v) {
                int index = s1.getSelectedItemPosition();
                if (menu[index] == "Shampoo") {
                    int hrg=38000;
                    harga.setText(hrg+"");
                    Toast.makeText(getBaseContext(), "You've chosen: Shampoo - Rp. 38.000", Toast.LENGTH_SHORT).show();
                } else if (menu[index] == "Deodorant") {
                    int hrg=16500;
                    harga.setText(hrg+"");
                } else if (menu[index] == "Sabun Mandi") {
                    int hrg=26800;
                    harga.setText(hrg+"");
                }else if (menu[index] == "Sikat Gigi") {
                    int hrg=8900;
                    harga.setText(hrg+"");
                } else if (menu[index] == "Pasta Gigi") {
                    int hrg = 9800;
                    harga.setText(hrg + "");
                }
                else {
                    Toast.makeText(getBaseContext(), "Silahkan pilih menu..", Toast.LENGTH_SHORT).show();
                    harga.setText("");
                }
            }
        });
    }
}
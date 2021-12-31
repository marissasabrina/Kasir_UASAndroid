package com.example.kasir;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    public static final String DATA_TITLE = "TITLE";
    int hargaShampoo = 38000, hargaDeodorant = 16500, hargaSabunMnd = 26800, hargaSikatGigi = 8900, hargaPastaGigi = 9800;
    int itemCount1 = 0, itemCount2 = 0, itemCount3 = 0, itemCount4 = 0, itemCount5 = 0;
    int countShampoo, countDeodorant, countSabunMnd, countSikatGigi, countPastaGigi, totalItems, totalPrice;
    String strTitle;
    Button btnCheckout;
    ImageView imageAdd1, imageAdd2, imageAdd3, imageAdd4, imageAdd5,
            imageMinus1, imageMinus2, imageMinus3, imageMinus4, imageMinus5;
    TextView tvTitle, tvInfo, tvJumlahBarang, tvTotalPrice, tvShampoo, tvDeodorant, tvSabunMandi, tvSikatGigi, tvPastaGigi,
            tvPriceShampoo, tvPriceDeodorant, tvPriceSabunMandi, tvPriceSikatGigi, tvPricePastaGigi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setInitLayout();
        setDataShampoo();
        setDataDeodorant();
        setDataSabunMandi();
        setDataSikatGigi();
        setDataPastaGigi();
        setInputData();
    }

    private void setInitLayout() {
        tvTitle = findViewById(R.id.tvTitle);

        tvJumlahBarang = findViewById(R.id.tvJumlahBarang);
        tvTotalPrice = findViewById(R.id.tvTotalPrice);

        tvShampoo = findViewById(R.id.tvShampoo);
        tvDeodorant = findViewById(R.id.tvDeodorant);
        tvSabunMandi = findViewById(R.id.tvSabunMandi);
        tvSikatGigi = findViewById(R.id.tvSikatGigi);
        tvPastaGigi = findViewById(R.id.tvPastaGigi);
        tvPriceShampoo = findViewById(R.id.tvPriceShampoo);
        tvPriceDeodorant = findViewById(R.id.tvPriceDeodorant);
        tvPriceSabunMandi = findViewById(R.id.tvPriceSabunMnd);
        tvPriceSikatGigi = findViewById(R.id.tvPriceSikatGigi);
        tvPricePastaGigi = findViewById(R.id.tvPricePastaGigi);

        imageAdd1 = findViewById(R.id.imageAdd1);
        imageAdd2 = findViewById(R.id.imageAdd2);
        imageAdd3 = findViewById(R.id.imageAdd3);
        imageAdd4 = findViewById(R.id.imageAdd4);
        imageAdd5 = findViewById(R.id.imageAdd5);
        imageMinus1 = findViewById(R.id.imageMinus1);
        imageMinus2 = findViewById(R.id.imageMinus2);
        imageMinus3 = findViewById(R.id.imageMinus3);
        imageMinus4 = findViewById(R.id.imageMinus4);
        imageMinus5 = findViewById(R.id.imageMinus5);

        btnCheckout = findViewById(R.id.btnCheckout);
        tvJumlahBarang.setText("0 items");
        tvTotalPrice.setText("Rp 0");

    }

    private void setDataShampoo() {
        tvShampoo.setText(FunctionHelper.rupiahFormat(hargaShampoo));
        imageAdd1.setOnClickListener(v -> {
            itemCount1 = itemCount1 + 1;
            tvPriceShampoo.setText(itemCount1);
            countShampoo = hargaShampoo * itemCount1;
            setTotalPrice();
        });

        imageMinus1.setOnClickListener(v -> {
            if (itemCount1 > 0) {
                itemCount1 = itemCount1 - 1;
                tvPriceShampoo.setText(itemCount1);
            }
            countShampoo = hargaShampoo * itemCount1;
            setTotalPrice();
        });
    }

    private void setDataDeodorant() {
        tvDeodorant.setText(FunctionHelper.rupiahFormat(hargaDeodorant));
        imageAdd2.setOnClickListener(v -> {
            itemCount2 = itemCount2 + 1;
            tvPriceDeodorant.setText(itemCount2);
            countDeodorant = hargaDeodorant * itemCount2;
            setTotalPrice();
        });

        imageMinus2.setOnClickListener(v -> {
            if (itemCount2 > 0) {
                itemCount2 = itemCount2 - 1;
                tvPriceDeodorant.setText(itemCount2);
            }
            countDeodorant = hargaDeodorant * itemCount2;
            setTotalPrice();
        });
    }

    private void setDataSabunMandi() {
        tvSabunMandi.setText(FunctionHelper.rupiahFormat(hargaSabunMnd));
        imageAdd3.setOnClickListener(v -> {
            itemCount3 = itemCount3 + 1;
            tvPriceSabunMandi.setText(itemCount3);
            countSabunMnd = hargaSabunMnd * itemCount3;
            setTotalPrice();
        });

        imageMinus3.setOnClickListener(v -> {
            if (itemCount3 > 0) {
                itemCount3 = itemCount3 - 1;
                tvPriceSabunMandi.setText(itemCount3);
            }
            countSabunMnd = hargaSabunMnd * itemCount3;
            setTotalPrice();
        });
    }

    private void setDataSikatGigi() {
        tvSikatGigi.setText(FunctionHelper.rupiahFormat(hargaSikatGigi));
        imageAdd4.setOnClickListener(v -> {
            itemCount4 = itemCount4 + 1;
            tvPriceSikatGigi.setText(itemCount4);
            countSikatGigi = hargaSikatGigi * itemCount4;
            setTotalPrice();
        });

        imageMinus4.setOnClickListener(v -> {
            if (itemCount4 > 0) {
                itemCount4 = itemCount4 - 1;
                tvPriceSikatGigi.setText(itemCount4);
            }
            countSikatGigi = hargaSikatGigi * itemCount4;
            setTotalPrice();
        });
    }

    private void setDataPastaGigi() {
        tvPastaGigi.setText(FunctionHelper.rupiahFormat(hargaPastaGigi));
        imageAdd5.setOnClickListener(v -> {
            itemCount5 = itemCount5 + 1;
            tvPricePastaGigi.setText(itemCount5);
            countPastaGigi = hargaPastaGigi * itemCount5;
            setTotalPrice();
        });

        imageMinus5.setOnClickListener(v -> {
            if (itemCount5 > 0) {
                itemCount5 = itemCount5 - 1;
                tvPricePastaGigi.setText(itemCount5);
            }
            countPastaGigi = hargaPastaGigi * itemCount5;
            setTotalPrice();
        });
    }

    private void setTotalPrice() {
        totalItems = itemCount1 + itemCount2 + itemCount3 + itemCount4 + itemCount5;
        totalPrice = countShampoo + countDeodorant + countSabunMnd + countSikatGigi + countPastaGigi;

        tvJumlahBarang.setText(totalItems + " items");
        tvTotalPrice.setText(FunctionHelper.rupiahFormat(totalPrice));
    }


    private void setInputData() {
        btnCheckout.setOnClickListener(v -> {
            if (totalItems == 0 || totalPrice == 0) {
                Toast.makeText(MainActivity.this, "Pilih jenis barang!", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(MainActivity.this, "Order on proses", Toast.LENGTH_SHORT).show();
                finish();
            }
        });
    }

    public void Move (View view) {
        Intent intent = new Intent(MainActivity.this, MainActivity2.class);
        startActivity(intent);
    }
}

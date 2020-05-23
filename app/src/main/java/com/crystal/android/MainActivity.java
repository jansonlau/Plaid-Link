package com.crystal.android;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.plaid.link.Plaid;
import com.plaid.linkbase.models.configuration.LinkConfiguration;
import com.plaid.linkbase.models.configuration.PlaidProduct;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private static final int LINK_REQUEST_CODE = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        View button = findViewById(R.id.open_link);
        button.setOnClickListener(view -> {
            openLink();
        });
    }

    private void openLink() {
        ArrayList<PlaidProduct> products = new ArrayList<>();
        products.add(PlaidProduct.TRANSACTIONS);
        Plaid.openLink(
                this,
                new LinkConfiguration.Builder("Crystal", products).build(), // Defaults to plaid options value if set or SANDBOX
                LINK_REQUEST_CODE);
    }
}

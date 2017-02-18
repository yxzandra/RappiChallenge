package com.rappi.challenge.Activities;

import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.rappi.challenge.DataBase.DataBaseTransaction;
import com.rappi.challenge.DataBase.ProductTable;
import com.rappi.challenge.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.realm.RealmResults;

public class DetailsActivity extends BaseActivity {
    DataBaseTransaction dataBaseTransaction;
    static ProductTable productTable;

    @BindView(R.id.imageProductDetails)
    ImageView imageProductDetails;
    @BindView(R.id.textCategoryDetails)
    TextView textCategoryDetails;
    @BindView(R.id.textPriceDetails)
    TextView textPriceDetails;
    @BindView(R.id.textTitleDetails)
    TextView textTitleDetails;
    @BindView(R.id.textBodyDetails)
    TextView textBodyDetails;

    public static DetailsActivity newInstance(ProductTable productTable) {

        DetailsActivity fragment = new DetailsActivity();
        DetailsActivity.productTable = productTable;
        return fragment;
    }

    @Override
    public int getLayout() {
        return R.layout.activity_details;
    }

    @Override
    public void onCreateView(Bundle savedInstanceState) {
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        invalidateOptionsMenu();
        loadDetails();
    }

    private void loadDetails() {
        dataBaseTransaction = new DataBaseTransaction();
        dataBaseTransaction.InitializeDatabase(this);
        textTitleDetails.setText(productTable.getNameProduct());
        textBodyDetails.setText(productTable.getBodyProduct());
        textBodyDetails.setMovementMethod(new ScrollingMovementMethod());
        textPriceDetails.setText(productTable.getPriceProduct());
        textCategoryDetails.setText(productTable.getCategory());

        Glide.with(this).load(productTable.getImageProduct()).into(imageProductDetails);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if (item.getItemId() == android.R.id.home) {
            this.onBackPressed();
        }

        return super.onOptionsItemSelected(item);
    }
}

package com.rappi.challenge.Activities;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.rappi.challenge.API.response.Entry;
import com.rappi.challenge.API.response.PrincipalResponse;
import com.rappi.challenge.API.retrofit.RetrofitMagnament;
import com.rappi.challenge.DataBase.DataBaseTransaction;
import com.rappi.challenge.Interface.OnResponseInterface;
import com.rappi.challenge.R;
import com.splunk.mint.Mint;

import java.util.ArrayList;

import butterknife.BindView;

public class SplashActivity extends BaseActivity implements OnResponseInterface {
    DataBaseTransaction dataBaseTransaction;

    @BindView(R.id.imageMostach)
    ImageView imageMostach;
    @BindView(R.id.textNotLoadDatabase)
    TextView textNotLoadDatabase;

    @Override
    public int getLayout() {
        return R.layout.activity_splash;
    }

    @Override
    public void onCreateView(Bundle savedInstanceState) {
        Mint.initAndStartSession(this.getApplication(), "9461d83b");
        initAnimation(imageMostach);
        textNotLoadDatabase.setVisibility(View.GONE);
        dataBaseTransaction = new DataBaseTransaction();
        dataBaseTransaction.InitializeDatabase(this);

        if (savedInstanceState == null) {

            if (isOnline()) {
                getService();
            } else {
                if (dataBaseTransaction.sizeAllProduct() != 0) {
                    newActivity(new MainActivity());
                } else {
                    textNotLoadDatabase.setVisibility(View.VISIBLE);
                }
            }
        }
    }


    public void getService() {
        RetrofitMagnament controller = new RetrofitMagnament(this);
        controller.start(this);
    }


    @Override
    public void onResponseMethod(PrincipalResponse principalResponse) {
        loadDataBase(principalResponse.getFeed().getEntry());
        newActivity(new MainActivity());
    }

    private void loadDataBase(ArrayList<Entry> entry) {
        float price;
        String typePrice;

        for (Entry object : entry) {
            if (!dataBaseTransaction.searchProduct(object.getImName().getLabel())) {
                price = Float.parseFloat(object.getImPrice().getAttributes().getAmount());

                if (price <= 0) {
                    typePrice = getString(R.string.StringFreePriceDatabaBase);
                } else {
                    typePrice = String.valueOf(price);
                }

                dataBaseTransaction.addProduct(object.getImName().getLabel(),
                        object.getSummary().getLabel(),
                        object.getImImage().get(2).getLabel(),
                        typePrice,
                        object.getCategory().getAttributes().getLabel());
            }
        }

    }
}

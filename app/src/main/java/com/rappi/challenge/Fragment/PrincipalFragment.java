package com.rappi.challenge.Fragment;

import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.rappi.challenge.Activities.DetailsActivity;
import com.rappi.challenge.Adapters.RecyclerProductAdapter;
import com.rappi.challenge.DataBase.DataBaseTransaction;
import com.rappi.challenge.DataBase.ProductTable;
import com.rappi.challenge.Interface.OnClickRecyclerViewInterface;
import com.rappi.challenge.R;

import butterknife.BindView;

public class PrincipalFragment extends BaseFragment implements OnClickRecyclerViewInterface {

    static String typeCategories = "null";
    DataBaseTransaction dataBaseTransaction;

    @BindView(R.id.recyclerProduct)
    RecyclerView recyclerProduct;
    @BindView(R.id.imageMostachNotCategory)
    ImageView imageMostachNotCategory;
    @BindView(R.id.linearNotCategory)
    LinearLayout linearNotCategory;
    @BindView(R.id.content_main)
    FrameLayout contentMain;

    @Override
    public int getLayout() {
        return R.layout.fragment_principal;
    }

    @Override
    public void onViewReady() {
        linearNotCategory.setVisibility(View.GONE);

        if(!typeCategories.equals(getString(R.string.instanceCategoryNull))){
            dataBaseTransaction = new DataBaseTransaction();
            dataBaseTransaction.InitializeDatabase(getContext());

            if (dataBaseTransaction.searchCategory(typeCategories).size() ==0){
                linearNotCategory.setVisibility(View.VISIBLE);
                initAnimation(imageMostachNotCategory);
            }
        }

        if (isTablet(getContext())) {
            loadRecyclerTablet();
        } else {
            loadRecyclerPhone();
        }
    }

    public static PrincipalFragment newInstance(String typeCategories) {

        PrincipalFragment fragment = new PrincipalFragment();
        PrincipalFragment.typeCategories = typeCategories;
        return fragment;
    }

    private void loadRecyclerTablet() {
        recyclerProduct.setHasFixedSize(true);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getActivity(), 2);
        gridLayoutManager.setOrientation(GridLayoutManager.HORIZONTAL);
        recyclerProduct.setLayoutManager(gridLayoutManager);
        recyclerProduct.setAdapter(new RecyclerProductAdapter(typeCategories, this, getContext()));
    }

    private void loadRecyclerPhone() {
        recyclerProduct.setHasFixedSize(true);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        recyclerProduct.setLayoutManager(linearLayoutManager);
        recyclerProduct.setAdapter(new RecyclerProductAdapter(typeCategories, this, getContext()));
    }

    @Override
    public void onItemClicked(ProductTable ProductItem) {
        newActivity(DetailsActivity.newInstance(ProductItem));
    }

}

package com.rappi.challenge.Adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.rappi.challenge.DataBase.DataBaseTransaction;
import com.rappi.challenge.DataBase.ProductTable;
import com.rappi.challenge.Interface.OnClickRecyclerViewInterface;
import com.rappi.challenge.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.realm.RealmResults;


/**
 * Created by yxzan on 07/02/2017.
 */

public class RecyclerProductAdapter extends RecyclerView.Adapter<RecyclerProductAdapter.ViewHolder> {
    private DataBaseTransaction dataBaseTransaction;
    private RealmResults<ProductTable> productTable;


    private OnClickRecyclerViewInterface onClickRecyclerViewInterface;
    private Context context;
    private String typeCategories;

    public RecyclerProductAdapter(String typeCategories, OnClickRecyclerViewInterface onClickRecyclerViewInterface, Context context) {
        dataBaseTransaction = new DataBaseTransaction();
        dataBaseTransaction.InitializeDatabase(context);
        this.onClickRecyclerViewInterface = onClickRecyclerViewInterface;
        this.context = context;
        this.typeCategories = typeCategories;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_view_item_product, parent, false);

        return new ViewHolder(v, new ViewHolder.ViewHolderClickListener() {
            @Override
            public void onItemClick(View caller, int position) {
                onClickRecyclerViewInterface.onItemClicked(productTable.get(position));
            }
        });
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {

        if (typeCategories.equals(context.getString(R.string.instanceCategoryNull))) {
            productTable = dataBaseTransaction.getAll();
        }else {
            productTable = dataBaseTransaction.searchCategory(typeCategories);
        }
        holder.titleProductPhone.setText(productTable.get(position).getNameProduct());
        holder.shortDescriptionPhone.setText(productTable.get(position).getCategory());
        Glide.with(context).load(productTable.get(position).getImageProduct()).into(holder.imageProductPhone);
        holder.priceProductPhone.setText(productTable.get(position).getPriceProduct());

    }


    @Override
    public int getItemCount() {
        if (typeCategories.equals(context.getString(R.string.instanceCategoryNull))) {
            return dataBaseTransaction.sizeAllProduct();
        }else {
            productTable = dataBaseTransaction.searchCategory(typeCategories);
            return productTable.size();
        }

    }


    static class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        @BindView(R.id.imageProductPhone)
        ImageView imageProductPhone;
        @BindView(R.id.titleProductPhone)
        TextView titleProductPhone;
        @BindView(R.id.shortDescriptionPhone)
        TextView shortDescriptionPhone;
        @BindView(R.id.priceProductPhone)
        TextView priceProductPhone;

        interface ViewHolderClickListener {
            void onItemClick(View caller, int position);
        }

        ViewHolderClickListener mListener;

        ViewHolder(View itemView, ViewHolderClickListener listener) {
            super(itemView);
            mListener = listener;
            ButterKnife.bind(this, itemView);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            mListener.onItemClick(view, getPosition());
        }
    }

}
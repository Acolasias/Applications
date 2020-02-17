package com.bawei.applications.view.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bawei.applications.R;
import com.bawei.applications.model.bean.OrderformBean;

import java.text.SimpleDateFormat;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Time:2020/2/14 0014下午 04:40202002
 * 邮箱:2094158527@qq.com
 * 作者:李庆瑶
 * 类功能:
 */
public class OrderformAdapter extends RecyclerView.Adapter<OrderformAdapter.OrderformViewHolder> {

    private List<OrderformBean.OrderListBean> list;
    private int orderStatus;

    public OrderformAdapter(List<OrderformBean.OrderListBean> list) {

        this.list = list;
    }

    @NonNull
    @Override
    public OrderformViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_order_from, parent, false);
        return new OrderformViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull OrderformViewHolder holder, int position) {
        OrderformBean.OrderListBean orderListBean = list.get(position);
        holder.tv_Commodity.setText("订单号:" + orderListBean.getOrderId());
        long orderTime = orderListBean.getOrderTime();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd  HH:mm");
        String format = simpleDateFormat.format(orderTime);
        holder.tv_Time.setText(format);
        orderStatus = orderListBean.getOrderStatus();
        if (orderStatus == 1) {
            holder.btn.setVisibility(View.VISIBLE);
            holder.btn.setText("去支付");
        } else if (orderStatus == 2) {
            holder.btn.setVisibility(View.VISIBLE);
            holder.btn.setText("确认收货");
        } else {
            holder.btn.setVisibility(View.GONE);
        }
        List<OrderformBean.OrderListBean.DetailListBean> detailList = orderListBean.getDetailList();
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(holder.itemView.getContext());
        linearLayoutManager.setOrientation(RecyclerView.VERTICAL);
        holder.rv.setLayoutManager(linearLayoutManager);
        OrderformCommodityAdapter orderformCommodityAdapter = new OrderformCommodityAdapter(detailList,orderStatus);
        holder.rv.setAdapter(orderformCommodityAdapter);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class OrderformViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.tv_commodity)
        TextView tv_Commodity;
        @BindView(R.id.rv)
        RecyclerView rv;
        @BindView(R.id.tv_time)
        TextView tv_Time;
        @BindView(R.id.btn)
        Button btn;

        public OrderformViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);

        }
    }
}

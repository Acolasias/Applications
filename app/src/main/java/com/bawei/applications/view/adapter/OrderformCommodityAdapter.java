package com.bawei.applications.view.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bawei.applications.R;
import com.bawei.applications.model.bean.OrderformBean;
import com.bawei.applications.utile.NetUtile;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Time:2020/2/15 0015下午 10:17202002
 * 邮箱:2094158527@qq.com
 * 作者:李庆瑶
 * 类功能:
 */
public class OrderformCommodityAdapter extends RecyclerView.Adapter<OrderformCommodityAdapter.OrderformCommodityViewHolder> {
    private List<OrderformBean.OrderListBean.DetailListBean> detailList;
    private int orderStatus;

    public OrderformCommodityAdapter(List<OrderformBean.OrderListBean.DetailListBean> detailList,int orderStatus) {

        this.detailList = detailList;
        this.orderStatus = orderStatus;
    }
    @NonNull
    @Override
    public OrderformCommodityViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_order_form_commodity, parent, false);
        return new OrderformCommodityViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull OrderformCommodityViewHolder holder, int position) {
        OrderformBean.OrderListBean.DetailListBean detailListBean = detailList.get(position);
        holder.it_Name.setText(detailListBean.getCommodityName());
        holder.it_Price.setText("$"+detailListBean.getCommodityPrice());
        String commodityPic = detailListBean.getCommodityPic();
        String[] split = commodityPic.split(",");
        NetUtile.getInstance().getPhoto(split[0],holder.it_Img);
        if(orderStatus==3){
            holder.btn.setVisibility(View.VISIBLE);
            holder.btn.setText("去评价");
        }else {
            holder.btn.setVisibility(View.GONE);
        }
    }

    @Override
    public int getItemCount() {
        return detailList.size();
    }

    class OrderformCommodityViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.it_img)
        ImageView it_Img;
        @BindView(R.id.it_name)
        TextView it_Name;
        @BindView(R.id.it_price)
        TextView it_Price;
        @BindView(R.id.btn)
        Button btn;
        public OrderformCommodityViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);

        }
    }
}

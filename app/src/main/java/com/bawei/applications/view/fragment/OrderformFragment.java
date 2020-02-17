package com.bawei.applications.view.fragment;


import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bawei.applications.R;
import com.bawei.applications.base.BaseFragment;
import com.bawei.applications.contract.OrderformContract;
import com.bawei.applications.model.bean.OrderformBean;
import com.bawei.applications.presenter.OrderformPresenter;
import com.bawei.applications.view.adapter.OrderformAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * A simple {@link Fragment} subclass.
 */
public class OrderformFragment extends BaseFragment<OrderformPresenter> implements OrderformContract.IView {

    @BindView(R.id.rv)
    RecyclerView rv;
    private int status = 0;
    private int page = 1;

    List<OrderformBean.OrderListBean> list=new ArrayList<>();
    @Override
    protected void initView(View inflate) {

    }

    @Override
    protected OrderformPresenter providerPresenter() {
        return new OrderformPresenter();
    }

    @Override
    protected int LayoutId() {
        return R.layout.fragment_orderform;
    }

    @Override
    protected void initData() {
        Bundle arguments = getArguments();
        if (arguments != null) {
            status = arguments.getInt("key");
        }
        mPresenter.onOrderformData(28237, "158166535789828237", status, page, 10);
    }

    public static OrderformFragment getInstance(int value) {
        OrderformFragment orderformFragment = new OrderformFragment();
        Bundle bundle = new Bundle();
        bundle.putInt("key", value);
        orderformFragment.setArguments(bundle);
        return orderformFragment;
    }

    @Override
    public void onOrderformSueccess(OrderformBean bean) {
        list.addAll(bean.getOrderList());
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        linearLayoutManager.setOrientation(RecyclerView.VERTICAL);
        rv.setLayoutManager(linearLayoutManager);

        OrderformAdapter orderformAdapter = new OrderformAdapter(list);
        rv.setAdapter(orderformAdapter);
       // Toast.makeText(getActivity(), "请求成功", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onOrderformFailure(Throwable throwable) {
        Toast.makeText(getActivity(), ""+throwable.getMessage(), Toast.LENGTH_SHORT).show();
    }
}

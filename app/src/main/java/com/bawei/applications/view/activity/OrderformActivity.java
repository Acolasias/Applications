package com.bawei.applications.view.activity;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.bawei.applications.R;
import com.bawei.applications.base.BaseActivity;
import com.bawei.applications.base.BasePresenter;
import com.bawei.applications.view.fragment.OrderformFragment;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class OrderformActivity extends BaseActivity {

    @BindView(R.id.or_tb)
    TabLayout or_Tb;
    @BindView(R.id.or_vp)
    ViewPager or_Vp;

    List<Fragment> list = new ArrayList<>();
    List<String> stringList= new ArrayList<>();
    @Override
    protected void initData() {
        OrderformFragment fragment0 = OrderformFragment.getInstance(0);
        OrderformFragment fragment1 = OrderformFragment.getInstance(1);
        OrderformFragment fragment2= OrderformFragment.getInstance(2);
        OrderformFragment fragment3 = OrderformFragment.getInstance(3);
        OrderformFragment fragment9 = OrderformFragment.getInstance(9);
        list.add(fragment0);
        list.add(fragment1);
        list.add(fragment2);
        list.add(fragment3);
        list.add(fragment9);
        stringList.add("全部订单");
        stringList.add("代付款");
        stringList.add("待收货");
        stringList.add("待评价");
        stringList.add("已完成");
        or_Vp.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
            @NonNull
            @Override
            public Fragment getItem(int position) {
                return list.get(position);
            }

            @Override
            public int getCount() {
                return list.size();
            }

            @Nullable
            @Override
            public CharSequence getPageTitle(int position) {
                return stringList.get(position);
            }
        });

        or_Tb.setupWithViewPager(or_Vp);
    }

    @Override
    protected void initView() {

    }

    @Override
    protected BasePresenter providerPresenter() {
        return null;
    }

    @Override
    protected int LayoutId() {
        return R.layout.activity_orderform;
    }

}

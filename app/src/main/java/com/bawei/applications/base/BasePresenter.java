package com.bawei.applications.base;

/**
 * Time:2020/2/13 0013下午 02:11202002
 * 邮箱:2094158527@qq.com
 * 作者:李庆瑶
 * 类功能:
 */
public abstract class BasePresenter<V> {
    protected V view;

    public void detach() {
        view=null;
    }

    public void attach(V view) {
        this.view = view;
    }

    public BasePresenter() {
        initModel();
    }

    protected abstract void initModel();
}

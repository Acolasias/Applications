package com.bawei.applications.presenter;

import com.bawei.applications.base.BasePresenter;
import com.bawei.applications.contract.IRegisterAndLoginContract;
import com.bawei.applications.contract.OrderformContract;
import com.bawei.applications.model.OrderformModel;
import com.bawei.applications.model.bean.OrderformBean;

/**
 * Time:2020/2/14 0014下午 03:48202002
 * 邮箱:2094158527@qq.com
 * 作者:李庆瑶
 * 类功能:
 */
public class OrderformPresenter extends BasePresenter<OrderformContract.IView> implements OrderformContract.IPresenter {

    private OrderformModel orderformModel;

    @Override
    protected void initModel() {
        orderformModel = new OrderformModel();
    }

    @Override
    public void onOrderformData(int userId, String sessionId, int status, int page, int count) {

        orderformModel.onOrderformData(userId, sessionId, status, page, count, new OrderformContract.IModel.IModelCallback() {
            @Override
            public void onOrderformSueccess(OrderformBean bean) {
                view.onOrderformSueccess(bean);
            }

            @Override
            public void onOrderformFailure(Throwable throwable) {
                view.onOrderformFailure(throwable);
            }
        });
    }
}

package com.bawei.applications.contract;

import com.bawei.applications.model.bean.OrderformBean;

/**
 * Time:2020/2/14 0014下午 03:33202002
 * 邮箱:2094158527@qq.com
 * 作者:李庆瑶
 * 类功能:
 */
public interface OrderformContract {

    interface IView{
        void onOrderformSueccess(OrderformBean bean);
        void onOrderformFailure(Throwable throwable);
    }

    interface IPresenter{
        void onOrderformData(int userId,String sessionId,int status,int page,int count);
    }

    interface IModel{
        void onOrderformData(int userId,String sessionId,int status,int page,int count,IModelCallback iModelCallback);
        interface IModelCallback{
            void onOrderformSueccess(OrderformBean bean);
            void onOrderformFailure(Throwable throwable);
        }
    }
}

package com.bawei.applications.model;

import com.bawei.applications.contract.OrderformContract;
import com.bawei.applications.model.bean.OrderformBean;
import com.bawei.applications.utile.NetUtile;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * Time:2020/2/14 0014下午 03:38202002
 * 邮箱:2094158527@qq.com
 * 作者:李庆瑶
 * 类功能:
 */
public class OrderformModel implements OrderformContract.IModel {
    @Override
    public void onOrderformData(int userId, String sessionId, int status, int page, int count, IModelCallback iModelCallback) {
        NetUtile.getInstance().getApi()
                .getOrderformData(userId,sessionId,status,page,count)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<OrderformBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(OrderformBean bean) {
                        if("0000".equals(bean.getStatus())){
                            iModelCallback.onOrderformSueccess(bean);
                        }else {
                            iModelCallback.onOrderformFailure(new Exception(bean.getMessage()));
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        iModelCallback.onOrderformFailure(e);
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}

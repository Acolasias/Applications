package com.bawei.applications.model;

import com.bawei.applications.contract.IRegisterAndLoginContract;
import com.bawei.applications.model.bean.LoginBean;
import com.bawei.applications.model.bean.RegisterBean;
import com.bawei.applications.utile.NetUtile;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * Time:2020/2/13 0013下午 03:54202002
 * 邮箱:2094158527@qq.com
 * 作者:李庆瑶
 * 类功能:
 */
public class RegisterAndLoginModel implements IRegisterAndLoginContract.IModel {
    @Override
    public void onRegisterData(String phone, String pwd, IModelCallback iModelCallback) {
        NetUtile.getInstance().getApi()
                .getRegisterData(phone,pwd)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<RegisterBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(RegisterBean bean) {
                        if("0000".equals(bean.getStatus())){
                            iModelCallback.onRegisterSueccess(bean);
                        }else {
                            iModelCallback.onRegisterFailure(new Exception(bean.getMessage()));
                        }
                    }

                    @Override
                    public void onError(Throwable e) {

                        iModelCallback.onRegisterFailure(e);
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    @Override
    public void onLoginData(String phone, String pwd, IModelCallback iModelCallback) {
        NetUtile.getInstance().getApi()
                .getLoginData(phone,pwd)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<LoginBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(LoginBean bean) {
                        if("0000".equals(bean.getStatus())){
                            iModelCallback.onLoginSueccess(bean);
                        }else {
                            iModelCallback.onLoginFailure(new Exception(bean.getMessage()));
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        iModelCallback.onLoginFailure(e);
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}

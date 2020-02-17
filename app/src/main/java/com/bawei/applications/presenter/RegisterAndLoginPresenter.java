package com.bawei.applications.presenter;

import com.bawei.applications.base.BasePresenter;
import com.bawei.applications.contract.IRegisterAndLoginContract;
import com.bawei.applications.model.RegisterAndLoginModel;
import com.bawei.applications.model.bean.LoginBean;
import com.bawei.applications.model.bean.RegisterBean;

/**
 * Time:2020/2/13 0013下午 03:55202002
 * 邮箱:2094158527@qq.com
 * 作者:李庆瑶
 * 类功能:
 */
public class RegisterAndLoginPresenter extends BasePresenter<IRegisterAndLoginContract.IView> implements IRegisterAndLoginContract.IPresenter {

    private RegisterAndLoginModel registerAndLoginModel;

    @Override
    protected void initModel() {
        registerAndLoginModel = new RegisterAndLoginModel();
    }

    @Override
    public void onRegisterData(String phone, String pwd) {
        registerAndLoginModel.onRegisterData(phone, pwd, new IRegisterAndLoginContract.IModel.IModelCallback() {
            @Override
            public void onRegisterSueccess(RegisterBean bean) {
                view.onRegisterSueccess(bean);
            }

            @Override
            public void onRegisterFailure(Throwable throwable) {
                view.onRegisterFailure(throwable);
            }

            @Override
            public void onLoginSueccess(LoginBean bean) {

                view.onLoginSueccess(bean);
            }

            @Override
            public void onLoginFailure(Throwable throwable) {

                view.onLoginFailure(throwable);
            }
        });
    }

    @Override
    public void onLoginData(String phone, String pwd) {
        registerAndLoginModel.onLoginData(phone, pwd, new IRegisterAndLoginContract.IModel.IModelCallback() {
            @Override
            public void onRegisterSueccess(RegisterBean bean) {
                view.onRegisterSueccess(bean);
            }

            @Override
            public void onRegisterFailure(Throwable throwable) {
                view.onRegisterFailure(throwable);
            }

            @Override
            public void onLoginSueccess(LoginBean bean) {

                view.onLoginSueccess(bean);
            }

            @Override
            public void onLoginFailure(Throwable throwable) {

                view.onLoginFailure(throwable);
            }
        });
    }
}

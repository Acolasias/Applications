package com.bawei.applications.contract;

import com.bawei.applications.model.bean.LoginBean;
import com.bawei.applications.model.bean.RegisterBean;

/**
 * Time:2020/2/13 0013下午 03:32202002
 * 邮箱:2094158527@qq.com
 * 作者:李庆瑶
 * 类功能:
 */
public interface IRegisterAndLoginContract {

    interface IView{
        void onRegisterSueccess(RegisterBean bean);
        void onRegisterFailure(Throwable throwable);
        void onLoginSueccess(LoginBean bean);
        void onLoginFailure(Throwable throwable);
    }

    interface IPresenter{

        void onRegisterData(String phone,String pwd);
        void onLoginData(String phone,String pwd);
    }

    interface IModel{
        void onRegisterData(String phone,String pwd,IModelCallback iModelCallback);
        void onLoginData(String phone,String pwd,IModelCallback iModelCallback);
        interface IModelCallback{
            void onRegisterSueccess(RegisterBean bean);
            void onRegisterFailure(Throwable throwable);
            void onLoginSueccess(LoginBean bean);
            void onLoginFailure(Throwable throwable);
        }
    }
}

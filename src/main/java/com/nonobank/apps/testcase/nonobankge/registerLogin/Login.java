package com.nonobank.apps.testcase.nonobankge.registerLogin;

import org.testng.annotations.Test;
import com.nonobank.apps.business.nonobankge.Biz_login;
import com.nonobank.apps.business.nonobankge.Biz_register;
import com.nonobank.apps.business.nonobankge.Var_login;
import com.nonobank.apps.business.nonobankge.Var_register;


public class Login {
	Biz_register biz_register;
	Biz_login biz_login;
	@Test(dataProvider="dataSource")
	public void test(String mobile,String pictureVerification,String smsCode,String password){
		biz_register.register(mobile, pictureVerification, smsCode, password,"");
		biz_login.login(mobile, password,"");
			
	}
}
	

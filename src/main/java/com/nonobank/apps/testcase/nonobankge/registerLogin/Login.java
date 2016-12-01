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
	public void test(Var_register var_register,Var_login var_login){
		biz_register.register(var_register);
		biz_login.login(var_login);
			
	}
}
	

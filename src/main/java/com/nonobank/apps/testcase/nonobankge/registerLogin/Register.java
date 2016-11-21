package com.nonobank.apps.testcase.nonobankge.registerLogin;

import org.testng.annotations.Test;

import com.nonobank.apps.business.nonobankge.Biz_register;
import com.nonobank.apps.business.nonobankge.Var_register;
import com.nonobank.apps.testcase.base.BaseCase;

public class Register extends BaseCase{
	Biz_register biz_register;
	
	@Test(dataProvider="dataSource")
	public void test(Var_register var_register){
		biz_register.register(var_register);	
	}
	
}

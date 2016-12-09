package com.nonobank.apps.testcase.nonobankge.bankCard;

import org.testng.annotations.Test;

import com.nonobank.apps.business.nonobankge.Biz_bindingBankcard;
import com.nonobank.apps.business.nonobankge.Biz_common;
import com.nonobank.apps.business.nonobankge.Biz_me;
import com.nonobank.apps.business.nonobankge.Biz_register;
import com.nonobank.apps.business.nonobankge.Biz_setting;
import com.nonobank.apps.business.nonobankge.Var_bindingBankcard;
import com.nonobank.apps.business.nonobankge.Var_register;
import com.nonobank.apps.testcase.base.BaseCase;

public class BankCard extends BaseCase{
	Biz_register biz_register;
	Biz_common biz_common;
	Biz_me biz_me;
	Biz_bindingBankcard biz_bindingBankcard;
	Biz_setting biz_setting;
	
	@Test(dataProvider="dataSource")
	public void test(Var_register var_register,Var_bindingBankcard var_bindingBankcard){
		//注册
		biz_register.register(var_register);
		//实名认证
		
		//点击我的
		biz_common.click_me();
		//点击银行卡管理
		biz_me.click_bankcard();
		//绑定银行卡
		biz_bindingBankcard.bindingBankcard(var_bindingBankcard);
		
		
	}
	
	
	
	
}

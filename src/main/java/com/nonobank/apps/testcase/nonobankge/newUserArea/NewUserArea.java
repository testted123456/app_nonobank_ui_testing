package com.nonobank.apps.testcase.nonobankge.newUserArea;

import org.testng.annotations.Test;

import com.nonobank.apps.business.nonobankge.Biz_common;
import com.nonobank.apps.business.nonobankge.Biz_me;
import com.nonobank.apps.business.nonobankge.Biz_product;
import com.nonobank.apps.business.nonobankge.Biz_productInvest;
import com.nonobank.apps.business.nonobankge.Biz_productList;
import com.nonobank.apps.business.nonobankge.Biz_register;
import com.nonobank.apps.business.nonobankge.Var_productInvest;
import com.nonobank.apps.business.nonobankge.Var_productList;
import com.nonobank.apps.business.nonobankge.Var_register;
import com.nonobank.apps.testcase.base.BaseCase;

public class NewUserArea extends BaseCase{
	
	Biz_register biz_register;
	Biz_common biz_common;
	Biz_me biz_me;
	Biz_product biz_product;
	Biz_productList biz_productList;
	Biz_productInvest biz_productInvest;
	
	@Test(dataProvider="dataSource")
	public void test(Var_register var_register,Var_productList var_productList,
			Var_productInvest var_productInvest){
		//注册---注册
		biz_register.register(var_register);
		//接口---实名认证
		
		//接口---绑卡
		
		//接口---设置支付密码
		
		//接口---账户余额充值
		
		//点击产品
		biz_common.click_product();
		//产品---点击新客专区
		biz_product.click_txjh();
		//新客专区---点击计划
		biz_productList.click_byProductName(var_productList);
		//产品购买
		biz_productInvest.productInvest(var_productInvest);
		
		
	}
	
	
	
	
	
}

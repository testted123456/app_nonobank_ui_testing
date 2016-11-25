package com.nonobank.apps.business.nonobankge;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;

import com.nonobank.apps.page.nonobankge.Page_bindingBankcard;

public class Biz_bindingBankcard {
	public static Logger logger = LogManager.getLogger(Biz_bindingBankcard.class);
	Page_bindingBankcard page_bindingBankcard=new Page_bindingBankcard();
	
	public void bindingBankcard(Var_bindingBankcard var_bindingBankcard){
		logger.info("[Biz_绑定银行卡]");
		page_bindingBankcard.click_selectBank();
		page_bindingBankcard.select_bank(var_bindingBankcard.getBankName());
		page_bindingBankcard.input_bankCardNum(var_bindingBankcard.getBankCardNum());
		page_bindingBankcard.input_bankMobile(var_bindingBankcard.getBankMobile());
		page_bindingBankcard.click_getSmsCode();
		page_bindingBankcard.input_bankSmsCode(var_bindingBankcard.getBankSmsCode());
		String prompt=page_bindingBankcard.getText_prompt();
		Assert.assertEquals(prompt,var_bindingBankcard.getBankLimitPrompt());
		page_bindingBankcard.click_enter();
	}
	
}

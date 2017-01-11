package com.nonobank.apps.business.nonobankge;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;

import com.nonobank.apps.page.nonobankge.Page_bindingBankcard;

public class Biz_bindingBankcard {
	public static Logger logger = LogManager.getLogger(Biz_bindingBankcard.class);
	Page_bindingBankcard page_bindingBankcard=new Page_bindingBankcard();
	
	public void bindingBankcard(String bankName,String bankCardNum,String bankMobile,
			String bankSmsCode,String bankLimitPrompt){
		logger.info("[Biz_绑定银行卡]");
		System.out.println("-------------------------------------------------");
		page_bindingBankcard.click_selectBank();
		page_bindingBankcard.select_bank(bankName);
		page_bindingBankcard.input_bankCardNum(bankCardNum);
		page_bindingBankcard.input_bankMobile(bankMobile);
		page_bindingBankcard.click_getSmsCode();
		page_bindingBankcard.input_bankSmsCode(bankSmsCode);
		String prompt=page_bindingBankcard.getText_prompt();
		Assert.assertEquals(prompt,bankLimitPrompt);
		page_bindingBankcard.click_enter();
		System.out.println("-------------------------------------------------");
	}
	
}

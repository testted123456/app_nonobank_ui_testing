package com.nonobank.apps.business.nonobankge;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.nonobank.apps.page.nonobankge.Page_common;
import com.nonobank.apps.page.nonobankge.Page_gesturePassword;
import com.nonobank.apps.utils.data.Assertion;

public class Biz_gesturePwd {
	public static Logger logger = LogManager.getLogger(Biz_gesturePwd.class);
	
	Page_gesturePassword page_gesturePassword=new Page_gesturePassword();
	Page_common page_common=new Page_common();
	
	public void set_gesturePwd(String gesturePwd,String gesturePwd_again,String expectMessage){
		logger.info("【BIZ】设置手势密码");
		String prompt=page_gesturePassword.getText_prompt();
		Assertion.assertEquals("为了您的账户安全，请设置手势密码", prompt, Biz_gesturePwd.class, "手势密码设置-1");
		page_gesturePassword.set_gesturePwd(gesturePwd);
		page_gesturePassword.sleep(3000);
		prompt=page_gesturePassword.getText_prompt();
		Assertion.assertEquals("再次绘制解锁图案", prompt, Biz_gesturePwd.class, "手势密码设置-2");
		page_gesturePassword.set_gesturePwd(gesturePwd_again);
		handleResult(expectMessage);
	}
	public void click_judge(){
		logger.info("【BIZ】点击跳过");
		page_gesturePassword.click_judge();
	}
	private void handleResult(String expectMessage) {
		switch (expectMessage) {
		case "success":
			boolean isExist_me=page_common.isExist_me();
			Assertion.assertEquals(true, isExist_me, Biz_gesturePwd.class, "手势密码设置成功");
			break;
		default:
		
			break;
		}
	}
	
}

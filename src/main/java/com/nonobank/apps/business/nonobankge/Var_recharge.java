package com.nonobank.apps.business.nonobankge;

public class Var_recharge {
	private static String payPassword;
	private static String payPassword_second;
	private static String rechargeSum;
	private static String bankSmsCode;
	
	public static String getBankSmsCode() {
		return bankSmsCode;
	}
	public static void setBankSmsCode(String bankSmsCode) {
		Var_recharge.bankSmsCode = bankSmsCode;
	}
	public static String getPayPassword() {
		return payPassword;
	}
	public static void setPayPassword(String payPassword) {
		Var_recharge.payPassword = payPassword;
	}
	public static String getPayPassword_second() {
		return payPassword_second;
	}
	public static void setPayPassword_second(String payPassword_second) {
		Var_recharge.payPassword_second = payPassword_second;
	}
	public static String getRechargeSum() {
		return rechargeSum;
	}
	public static void setRechargeSum(String rechargeSum) {
		Var_recharge.rechargeSum = rechargeSum;
	}
	
}

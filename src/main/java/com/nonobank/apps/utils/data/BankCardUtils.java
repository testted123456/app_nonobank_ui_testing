package com.nonobank.apps.utils.data;

import java.sql.Connection;
import java.util.Random;
import com.nonobank.apps.utils.db.DBUtils;

public class BankCardUtils {
	// 436742121737-建设银行---------------CCB
	// 622696779515-中信银行---------------CITIC
	// 622632349194-华夏银行---------------HXB
	// 622568683546-广发银行 --------------GDB
	// 622298316429-平安银行---------------PAB

	// 622827469345-农业银行---------------ABC
	// 620061511669-中国银行---------------BOC
	// 621485021040-招商银行---------------CMB
	// 622660633366-光大银行---------------CEB
	// 622262406933-交通银行---------------BCOM

	// 621691506392-民生银行---------------CMBC
	// 622521071652-浦发银行---------------SPDB
	// 622202100112-工商银行---------------ICBC
	// 622908192090-兴业银行---------------CIB
	// 621799417365-邮政储蓄---------------PSBC
	private static String[] prefix = { "436742121737", "622696779515", "622632349194", "622568683546", "622298316429",
			"622827469345", "620061511669", "621485021040", "622660633366", "622660633366", "622262406933",
			"621691506392", "622521071652", "622202100112", "622908192090", "621799417365" };

	public static void main(String[] args) {

	}

	public static int getOSum(int oSum) {
		oSum = oSum * 2;

		if (oSum < 10) {
			return oSum;
		} else {
			return oSum - 9;
		}
	}

	public static String getBankCard(String prefix) {
		Random random = new Random();
		String str = prefix;

		for (int i = 0; i < 6; i++) {
			str += String.valueOf(random.nextInt(10));
		}

		int sum = 0;
		for (int i = 1; i < 19; i++) {
			int v = Character.getNumericValue(str.charAt(i - 1));

			if (i % 2 == 0) {
				sum += getOSum(v);
			} else {
				sum += v;
			}
		}

		if (sum % 10 == 0) {
			str = str + "0";
		} else {
			str += String.valueOf(10 - sum % 10);
		}
		return str;
	}

	public static String getBankCard() {
		Random random = new Random();
		String str = prefix[random.nextInt(2)];

		for (int i = 0; i < 6; i++) {
			str += String.valueOf(random.nextInt(10));
		}

		int sum = 0;

		for (int i = 1; i < 19; i++) {
			int v = Character.getNumericValue(str.charAt(i - 1));

			if (i % 2 == 0) {
				sum += getOSum(v);
			} else {
				sum += v;
			}
		}

		if (sum % 10 == 0) {
			str = str + "0";
		} else {
			str += String.valueOf(10 - sum % 10);
		}

		return str;
	}

	public static boolean validate(String cardno) {
		int len = cardno.length();
		int sum = 0;

		for (int i = len; i > 0; i--) {
			int v = Character.getNumericValue(cardno.charAt(i - 1));

			if (i % 2 == 0) {
				sum += getOSum(v);
			} else {
				sum += v;
			}
		}

		int res = sum % 10;
		return res == 0;
	}

	public static String getUnUsedBankCard(String prefix) {
		Connection con = DBUtils.getConnection("nono","nono");

		while (true) {
			String bankCard = getBankCard(prefix);
			String sql = "select count(*) from user_bankcard_info WHERE bank_card_no='" + bankCard + "'";
			String count = DBUtils.getOneObject(con, sql).toString();

			if (count.equals("0")) {
				return bankCard;
			}
		}
	}
}
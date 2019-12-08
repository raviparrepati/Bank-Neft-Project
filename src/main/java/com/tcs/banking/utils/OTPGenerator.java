package com.tcs.banking.utils;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;

@Repository
public class OTPGenerator {
	
	public static Map<Integer,String> otpMap;
	static {
		otpMap = new HashMap<>();
	}

	// declaring a of return type String
	// which on calling provides the otp
	public String generateOTP(int custId) {
		// int randomPin declared to store the otp
		// since we using Math.random() hence we have to type cast it int
		// because Math.random() returns decimal value
		int randomPin = (int) (Math.random() * 9000) + 1000;
		String otp = String.valueOf(randomPin);
		System.out.println(" OTP ------- "+otp);
		otpMap.put(custId, otp);
		return otp;
		// returning value of otp
	}
	public String getOTP(int custId) {
		return otpMap.get(custId);
	}
	public String removeOTP(int custId) {
		return otpMap.remove(custId);
	}
}

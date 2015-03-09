package com.yaxuansheng.leetcode.online;

import java.lang.Integer;

public class ReverseBits {

    // you need treat n as an unsigned value
	public static int reverseBits(int n) {
        String numStr = Integer.toUnsignedString(n, 2);
        
        StringBuilder builder = new StringBuilder();
        // append 0s for 32bit integer
        for (int i = numStr.length(); i < 32; i++)
        {
            builder.append("0");
        }
        
        builder.append(numStr);
        
        return Integer.parseUnsignedInt(builder.reverse().toString(), 2);
    }
	
	public static void main(String[] args) {
		int num = 43261596;
		
		int reverse = reverseBits(num);
		
		System.out.println(reverse);
	}

}

package com.sourav.leetcode.easy.easy;

public class DefangingAnIpAddress {
    public static String defangIPaddr(String address) {
        StringBuilder addressBuilder = new StringBuilder();
        for (int i=0; i<address.length(); i++){
            if (address.charAt(i) ==  '.'){
                addressBuilder.append("[.]");
            } else {
                addressBuilder.append(address.charAt(i));
            }
        }
        return addressBuilder.toString();
    }

    public static String defangIPaddr2(String address) {
        StringBuilder addressBuilder = new StringBuilder();
        for (char c : address.toCharArray()){
            if (c ==  '.'){
                addressBuilder.append("[.]");
            } else {
                addressBuilder.append(c);
            }
        }
        return addressBuilder.toString();
    }
}

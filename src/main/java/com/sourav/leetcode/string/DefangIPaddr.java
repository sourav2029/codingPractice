package com.sourav.leetcode.string;

public class DefangIPaddr {
    public static String defangIPaddr(String address) {
        String[] addresses = address.split("\\.", -1);
        return String.join("[.]" , addresses);
    }

    public static String defangIPaddr2(String address) {
        return address.replace(".", "[.]");
    }

    public String defangIPaddr3(String address) {
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
    public static void main(String[] args) {
        System.out.println(defangIPaddr("1.1.1.1"));
    }
}

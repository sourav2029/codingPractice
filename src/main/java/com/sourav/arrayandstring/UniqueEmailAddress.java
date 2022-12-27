package com.sourav.arrayandstring;

import java.util.HashSet;
import java.util.Set;

public class UniqueEmailAddress {
    public static int numUniqueEmails(String[] emails) {
        Set<String> uniqueEmails = new HashSet<>();
        for (int i=0; i<emails.length; i++){
            String processedEmail = processEmail(emails[i]);
            uniqueEmails.add(processedEmail);
        }
        return uniqueEmails.size();
    }

    public static String processEmail(String email){
        String[] strs = email.split("@");
        StringBuilder builder = new StringBuilder();
        for(char c: strs[0].toCharArray()){
            if(c == '.'){
                continue;
            }
            if(c == '+'){
                break;
            }
            builder.append(c);
        }
        builder.append("@");
        builder.append(strs[1]);
        return builder.toString();
    }

    public static int numUniqueEmailsV2(String[] emails) {
        Set<String> uniqueEmails = new HashSet<>();
        for (int i=0; i<emails.length; i++){
            String processedEmail = processEmailV2(emails[i]);
            uniqueEmails.add(processedEmail);
        }
        return uniqueEmails.size();
    }

    public static String processEmailV2(String email){
        int index = email.indexOf("@");
        String first = email.substring(0, index);
        String last = email.substring(index);
        StringBuilder builder = new StringBuilder();
        for(char c: first.toCharArray()){
            if(c == '.'){
                continue;
            }
            if(c == '+'){
                break;
            }
            builder.append(c);
        }
        builder.append(last);
        return builder.toString();
    }


    public static void main(String[] args) {
        System.out.println(numUniqueEmailsV2(new String[]{"test.email+alex@leetcode.com","test.email.leet+alex@code.com"}));
    }
}

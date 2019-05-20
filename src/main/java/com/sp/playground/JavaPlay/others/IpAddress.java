package com.sp.playground.JavaPlay.others;

public class IpAddress {
    public static boolean isIpaddress(String ip){
        boolean isIp = false;
        if(!ip.contains(":")){
            isIp = ip.matches("^\\d{1,3}\\.\\d{1,3}\\.\\d{1,3}\\.\\d{1,3}$");
        }else {
            isIp = ip.matches("^[0-9a-f]{1,4}:[0-9a-f]{1,4}:[0-9a-f]{1,4}:[0-9a-f]{1,4}:[0-9a-f]{1,4}:[0-9a-f]{1,4}:[0-9a-f]{1,4}:[0-9a-f]{1,4}$");
        }

        return isIp;
    }

    public static void main(String[] args) {
        System.out.println(isIpaddress("125.1.23.344"));
        System.out.println(isIpaddress("2001:0db8:0000:0000:0000:ff00:0042:8329"));
    }
}

package com.ye.user.utiles;



import java.util.UUID;

public final class UserUUID {

    public static String getUUID(){
        String s = UUID.randomUUID().toString().replaceAll("-", "");
        return s;
    }
}

package com.cg.tms.service;

import java.util.UUID;

public class BaseService {

    public String generateId(){
        String uid=UUID.randomUUID().toString();
        return uid;
        /*
        StringBuilder builder = new StringBuilder();
        for (int i=0;i<10;i++){
            builder.append(i);
        }
        return builder.toString();
        */
    }

}

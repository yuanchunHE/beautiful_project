package com.cqut.beautiful.entity;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class Tokens {
    //private queue
    private static final Tokens tokens = new Tokens();
    private Tokens() {}
    private static final int MAX_LENTH = 10;
    private Queue<String> queue = new LinkedList<String>();

    /* 超出队列就将第一个删除 */
    public void addToToken(String token){
        if (queue.size() >= MAX_LENTH) {
            queue.remove();
        }
        queue.add(token);
    }


    public boolean checkToken(String token){
        Iterator<String> iter = queue.iterator();
        Boolean flag = false;
        while (iter.hasNext())
        {
            String str = iter.next();
            if (str.equals(token))
                flag = true;
        }
        return !flag;
    }


    public static Tokens getInstance(){
        return tokens;
    }
}

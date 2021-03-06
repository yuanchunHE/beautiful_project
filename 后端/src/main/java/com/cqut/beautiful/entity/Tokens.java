package com.cqut.beautiful.entity;

import com.cqut.beautiful.controller.UserController;
import com.cqut.beautiful.service.UserService;
import com.cqut.beautiful.service.impl.UserServiceImpl;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

public class Tokens {
    //private queue
    private static final Tokens tokens = new Tokens();
    private static final long randomseed = 114514L;
    private static final int MAX_LENTH = 1191;
    private final Random random = new Random();
    public final Queue<Long> queue = new LinkedList<Long>();
    private final UserService userService;

    private Tokens() {
        userService = new UserServiceImpl();
        random.setSeed(randomseed);
    }

    /* 超出队列就将第一个删除 */
    public Long generate(){
        if (queue.size() >= MAX_LENTH) {
            queue.remove();
        }
        long ln;
        ln = random.nextLong();
        while (checkToken(String.valueOf(ln))) {
            ln = random.nextLong();
        }

        return ln;
    }

    public void add(Long Tk){
        queue.add(Tk);
    }

    public String addToToken(){

        if (queue.size() >= MAX_LENTH) {
            queue.remove();
        }
        long ln;
        ln = random.nextLong();
        while (checkToken(String.valueOf(ln))) {
            ln = random.nextLong();
        }

        queue.add(ln);
        return String.valueOf(ln);
    }

    public boolean checkToken(String token){
        long ln = Long.parseLong(token);
        for (long q : queue) {
            if (q==ln)
                return true;
        }
        return false;
    }

    public static Tokens getInstance(){
        return tokens;
    }
}

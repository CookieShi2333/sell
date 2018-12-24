package com.wece.utils;

import java.util.Random;

/**
 * sell
 * com.wece.utils
 * Created by liaowj on 2018/12/20.
 * Description:
 *
 * @version 1.0
 */
public class KeyUtil {

    private KeyUtil() {

    }

    public static synchronized String genUniqueKey() {

        Random random = new Random();

        Integer randomNumber = random.nextInt(900000) + 100000;
        String key = System.currentTimeMillis() + String.valueOf(randomNumber);

        return key;
    }
}

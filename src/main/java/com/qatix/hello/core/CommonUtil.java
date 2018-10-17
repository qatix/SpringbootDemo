package com.qatix.hello.core;

import org.apache.commons.lang3.time.DateUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;


/**
 * 共通方法
 *
 * @author zenghualu
 */
public class CommonUtil {

    public static Map cache = new HashMap<>();

    /**
     * 创建指定数量的随机字符串
     *
     * @param numberFlag 是否是数字
     * @param length
     * @return
     */
    public static String createRandom(boolean numberFlag, int length) {

        String retStr = "";
        String strTable = numberFlag ? "1234567890" : "1234567890abcdefghijkmnpqrstuvwxyz";
        int len = strTable.length();
        boolean bDone = true;
        do {
            retStr = "";
            int count = 0;
            for (int i = 0; i < length; i++) {
                double dblR = Math.random() * len;
                int intR = (int) Math.floor(dblR);
                char c = strTable.charAt(intR);
                if (('0' <= c) && (c <= '9')) {
                    count++;
                }
                retStr += strTable.charAt(intR);
            }
            if (count >= 2) {
                bDone = false;
            }
        } while (bDone);

        return retStr;
    }

    /**
     * 设置到session
     *
     * @param key
     * @return
     */
    public static void set(String key, Object obj) {
        Map session = (Map) MythreadLocal.get("session");
        session.put(key, obj);
    }

    /**
     * 从session取值
     *
     * @param key
     * @return
     */
    public static Object get(String key) {
        Map session = (Map) MythreadLocal.get("session");
        System.out.println("mysession:"+session);
        if (null == session) {
            return null;
        }
        return session.get(key);
    }

    /**
     * 将字符串转化为Date类型的数据
     *
     * @param str
     * @return
     */
    public static String transformStringToTimeStamp(String str) {
        Date date = null;
        String target = null;
        try {
            date = DateUtils.parseDate(str, "yyyy-MM-dd", "yyyy/MM/dd");
            SimpleDateFormat fmt = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
            target = fmt.format(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return target;
    }
}

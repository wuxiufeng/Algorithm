package 剑指Offer;
/**
 * @program: EveryDay
 * @ClassName 替换空格.java
 * @description: TODO
 * @author: Mr. jun
 * @version: 1.0.0
 * @create: 2019-10-01 12:25
 */
public class 替换空格 {
    /**
     * @title replaceSpace
     * @description
     * @author Mr. jun
     * @param str 目标字符串
     * @return java.lang.String
     * @throws
     * @updateTime 2019/10/1 9:18
     */
    public String replaceSpace(StringBuffer str) {
        return str.toString().replaceAll(" ","%20");
    }
}

package com.wsh.servlet;
import org.apache.commons.codec.binary.Base64;
/**
 * Created by MrDou
 * Time: 2019\4\19 0019 17:13
 */
public class BaseToString {
        //base64字符串转byte[]
        public static byte[] base64String2ByteFun(String base64Str){
            base64Str = base64Str.replaceAll(" ","+");
            return Base64.decodeBase64(base64Str);
        }
        //byte[]转base64
        public static String byte2Base64StringFun(byte[] b){
            String returnString = Base64.encodeBase64String(b);
            if (returnString == null || returnString.length() == 0) {
                return "";
            }
            StringBuffer stringBuffer= new StringBuffer(returnString);
            stringBuffer.insert(4,":");
            stringBuffer.insert(15,";");
            stringBuffer.insert(22,",");
            String newImg = new String(stringBuffer);
            return newImg;
        }
}
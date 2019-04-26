package com.wsh.servlet;

import com.wsh.entity.QuestionWithBLOBs;
import com.wsh.entity.UserWithBLOBs;
import net.sf.json.JSONObject;

/**
 * Created by MrDou
 * Time: 2019\4\20 0020 14:20
 */
public class ByteEntityToStringEntity {

    public static JSONObject dateToStamp(UserWithBLOBs user) {
        JSONObject returnJson = new JSONObject();

        returnJson.put("id",user.getId());

        returnJson.put("userId",user.getUserId());

        returnJson.put("userName",user.getUserName());

        returnJson.put("userPhone",user.getUserPhone());

        returnJson.put("userPass",user.getUserPass());

        returnJson.put("userDepartment",user.getUserDepartment());

        returnJson.put("userMajor",user.getUserMajor());

        if (user.getHeadImg() != null) {
            if (user.getHeadImg().length > 0) {
                returnJson.put("headImg",BaseToString.byte2Base64StringFun(user.getHeadImg()));
            } else {
                returnJson.put("headImg","");
            }
        } else {
            returnJson.put("headImg", "");
        }


        returnJson.put("nickname",user.getNickname());

        returnJson.put("autograph",user.getAutograph());

        returnJson.put("userType",user.getUserType());

        return returnJson;
    }

    public static JSONObject questionDate(QuestionWithBLOBs question) {
        JSONObject returnJson = new JSONObject();

        returnJson.put("queId",question.getQueId());

        returnJson.put("queTitle",question.getQueTitle());

        returnJson.put("queSummary",question.getQueSummary());

        returnJson.put("clickCount",question.getClickCount());

        returnJson.put("createTime",question.getCreateTime());

        returnJson.put("praiseCount",question.getPraiseCount());

        returnJson.put("queCourse",question.getQueCourse());

        if (question.getQueImg() != null) {
            if (question.getQueImg().length > 0) {
                returnJson.put("queImg",BaseToString.byte2Base64StringFun(question.getQueImg()));
            }
        } else {
            returnJson.put("queImg", "");
        }


        returnJson.put("queDetail",question.getQueDetail());

        returnJson.put("replyCount",question.getReplyCount());

        returnJson.put("userId",question.getUserId());

        returnJson.put("unread",question.getUnread());

        return returnJson;
    }
}
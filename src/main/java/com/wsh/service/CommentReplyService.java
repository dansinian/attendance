package com.wsh.service;

import net.sf.json.JSONObject;

public interface CommentReplyService {
    JSONObject deleteConmmentReply(JSONObject jsonObject);
    JSONObject createConmmentReply(JSONObject jsonObject);
    JSONObject selectConmmentReply(JSONObject jsonObject);
    JSONObject selectReplyed(JSONObject jsonObject);
}

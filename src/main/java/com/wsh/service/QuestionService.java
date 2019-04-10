package com.wsh.service;

import net.sf.json.JSONObject;

import java.text.ParseException;

public interface QuestionService {
    JSONObject deleteQuestion(JSONObject jsonObject);
    JSONObject createQuestion(JSONObject jsonObject);
    JSONObject updateQuestion(JSONObject jsonObject);
    JSONObject selectQuestion(JSONObject jsonObject);
    JSONObject selectAllQuestion();

    JSONObject questionDetail(JSONObject jsonObject);

    JSONObject recommendQuestion() throws ParseException;

    JSONObject adminList();

    JSONObject navigationList(JSONObject jsonObject);
}

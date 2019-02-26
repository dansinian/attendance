package com.wsh.servlet;

import com.wsh.entity.Question;
import java.util.List;
import java.awt.*;
import java.util.Collections;
import java.util.Comparator;

public class SortList {
    /*
    * 降序排序
    * */
    public static List sort(List<Question> list){
        Collections.sort( list,new Comparator<Question>() {
            @Override
            public int compare(Question Q1, Question Q2) {
                return Q2.getPraiseCount().compareTo(Q1.getPraiseCount());
            }
        });
        return list;
    }
}


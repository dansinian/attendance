package com.wsh.servlet;

import com.wsh.entity.Question;

import java.util.List;
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
                return Q2.getClickCount().compareTo(Q1.getClickCount());
            }
        });
        return list;
    }

    public static List sortTime(List<Question> list){
        Collections.sort( list,new Comparator<Question>() {
            @Override
            public int compare(Question Q1, Question Q2) {
                return Q2.getQueId().compareTo(Q1.getQueId());
            }
        });
        return list;
    }

    public   static   List  removeDuplicate(List list)  {
        for  ( int  i  =   0 ; i  <  list.size()  -   1 ; i ++ )  {
            for  ( int  j  =  list.size()  -   1 ; j  >  i; j -- )  {
                if  (list.get(j).equals(list.get(i)))  {
                    list.remove(j);
                }
            }
        }
        return list;
    }
}


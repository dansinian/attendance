package com.wsh.entity;

import java.util.ArrayList;
import java.util.List;

public class QuestionExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public QuestionExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andQueIdIsNull() {
            addCriterion("que_id is null");
            return (Criteria) this;
        }

        public Criteria andQueIdIsNotNull() {
            addCriterion("que_id is not null");
            return (Criteria) this;
        }

        public Criteria andQueIdEqualTo(String value) {
            addCriterion("que_id =", value, "queId");
            return (Criteria) this;
        }

        public Criteria andQueIdNotEqualTo(String value) {
            addCriterion("que_id <>", value, "queId");
            return (Criteria) this;
        }

        public Criteria andQueIdGreaterThan(String value) {
            addCriterion("que_id >", value, "queId");
            return (Criteria) this;
        }

        public Criteria andQueIdGreaterThanOrEqualTo(String value) {
            addCriterion("que_id >=", value, "queId");
            return (Criteria) this;
        }

        public Criteria andQueIdLessThan(String value) {
            addCriterion("que_id <", value, "queId");
            return (Criteria) this;
        }

        public Criteria andQueIdLessThanOrEqualTo(String value) {
            addCriterion("que_id <=", value, "queId");
            return (Criteria) this;
        }

        public Criteria andQueIdLike(String value) {
            addCriterion("que_id like", value, "queId");
            return (Criteria) this;
        }

        public Criteria andQueIdNotLike(String value) {
            addCriterion("que_id not like", value, "queId");
            return (Criteria) this;
        }

        public Criteria andQueIdIn(List<String> values) {
            addCriterion("que_id in", values, "queId");
            return (Criteria) this;
        }

        public Criteria andQueIdNotIn(List<String> values) {
            addCriterion("que_id not in", values, "queId");
            return (Criteria) this;
        }

        public Criteria andQueIdBetween(String value1, String value2) {
            addCriterion("que_id between", value1, value2, "queId");
            return (Criteria) this;
        }

        public Criteria andQueIdNotBetween(String value1, String value2) {
            addCriterion("que_id not between", value1, value2, "queId");
            return (Criteria) this;
        }

        public Criteria andQueTitleIsNull() {
            addCriterion("que_title is null");
            return (Criteria) this;
        }

        public Criteria andQueTitleIsNotNull() {
            addCriterion("que_title is not null");
            return (Criteria) this;
        }

        public Criteria andQueTitleEqualTo(String value) {
            addCriterion("que_title =", value, "queTitle");
            return (Criteria) this;
        }

        public Criteria andQueTitleNotEqualTo(String value) {
            addCriterion("que_title <>", value, "queTitle");
            return (Criteria) this;
        }

        public Criteria andQueTitleGreaterThan(String value) {
            addCriterion("que_title >", value, "queTitle");
            return (Criteria) this;
        }

        public Criteria andQueTitleGreaterThanOrEqualTo(String value) {
            addCriterion("que_title >=", value, "queTitle");
            return (Criteria) this;
        }

        public Criteria andQueTitleLessThan(String value) {
            addCriterion("que_title <", value, "queTitle");
            return (Criteria) this;
        }

        public Criteria andQueTitleLessThanOrEqualTo(String value) {
            addCriterion("que_title <=", value, "queTitle");
            return (Criteria) this;
        }

        public Criteria andQueTitleLike(String value) {
            addCriterion("que_title like", value, "queTitle");
            return (Criteria) this;
        }

        public Criteria andQueTitleNotLike(String value) {
            addCriterion("que_title not like", value, "queTitle");
            return (Criteria) this;
        }

        public Criteria andQueTitleIn(List<String> values) {
            addCriterion("que_title in", values, "queTitle");
            return (Criteria) this;
        }

        public Criteria andQueTitleNotIn(List<String> values) {
            addCriterion("que_title not in", values, "queTitle");
            return (Criteria) this;
        }

        public Criteria andQueTitleBetween(String value1, String value2) {
            addCriterion("que_title between", value1, value2, "queTitle");
            return (Criteria) this;
        }

        public Criteria andQueTitleNotBetween(String value1, String value2) {
            addCriterion("que_title not between", value1, value2, "queTitle");
            return (Criteria) this;
        }

        public Criteria andQueSummaryIsNull() {
            addCriterion("que_summary is null");
            return (Criteria) this;
        }

        public Criteria andQueSummaryIsNotNull() {
            addCriterion("que_summary is not null");
            return (Criteria) this;
        }

        public Criteria andQueSummaryEqualTo(String value) {
            addCriterion("que_summary =", value, "queSummary");
            return (Criteria) this;
        }

        public Criteria andQueSummaryNotEqualTo(String value) {
            addCriterion("que_summary <>", value, "queSummary");
            return (Criteria) this;
        }

        public Criteria andQueSummaryGreaterThan(String value) {
            addCriterion("que_summary >", value, "queSummary");
            return (Criteria) this;
        }

        public Criteria andQueSummaryGreaterThanOrEqualTo(String value) {
            addCriterion("que_summary >=", value, "queSummary");
            return (Criteria) this;
        }

        public Criteria andQueSummaryLessThan(String value) {
            addCriterion("que_summary <", value, "queSummary");
            return (Criteria) this;
        }

        public Criteria andQueSummaryLessThanOrEqualTo(String value) {
            addCriterion("que_summary <=", value, "queSummary");
            return (Criteria) this;
        }

        public Criteria andQueSummaryLike(String value) {
            addCriterion("que_summary like", value, "queSummary");
            return (Criteria) this;
        }

        public Criteria andQueSummaryNotLike(String value) {
            addCriterion("que_summary not like", value, "queSummary");
            return (Criteria) this;
        }

        public Criteria andQueSummaryIn(List<String> values) {
            addCriterion("que_summary in", values, "queSummary");
            return (Criteria) this;
        }

        public Criteria andQueSummaryNotIn(List<String> values) {
            addCriterion("que_summary not in", values, "queSummary");
            return (Criteria) this;
        }

        public Criteria andQueSummaryBetween(String value1, String value2) {
            addCriterion("que_summary between", value1, value2, "queSummary");
            return (Criteria) this;
        }

        public Criteria andQueSummaryNotBetween(String value1, String value2) {
            addCriterion("que_summary not between", value1, value2, "queSummary");
            return (Criteria) this;
        }

        public Criteria andQueDetailIsNull() {
            addCriterion("que_detail is null");
            return (Criteria) this;
        }

        public Criteria andQueDetailIsNotNull() {
            addCriterion("que_detail is not null");
            return (Criteria) this;
        }

        public Criteria andQueDetailEqualTo(String value) {
            addCriterion("que_detail =", value, "queDetail");
            return (Criteria) this;
        }

        public Criteria andQueDetailNotEqualTo(String value) {
            addCriterion("que_detail <>", value, "queDetail");
            return (Criteria) this;
        }

        public Criteria andQueDetailGreaterThan(String value) {
            addCriterion("que_detail >", value, "queDetail");
            return (Criteria) this;
        }

        public Criteria andQueDetailGreaterThanOrEqualTo(String value) {
            addCriterion("que_detail >=", value, "queDetail");
            return (Criteria) this;
        }

        public Criteria andQueDetailLessThan(String value) {
            addCriterion("que_detail <", value, "queDetail");
            return (Criteria) this;
        }

        public Criteria andQueDetailLessThanOrEqualTo(String value) {
            addCriterion("que_detail <=", value, "queDetail");
            return (Criteria) this;
        }

        public Criteria andQueDetailLike(String value) {
            addCriterion("que_detail like", value, "queDetail");
            return (Criteria) this;
        }

        public Criteria andQueDetailNotLike(String value) {
            addCriterion("que_detail not like", value, "queDetail");
            return (Criteria) this;
        }

        public Criteria andQueDetailIn(List<String> values) {
            addCriterion("que_detail in", values, "queDetail");
            return (Criteria) this;
        }

        public Criteria andQueDetailNotIn(List<String> values) {
            addCriterion("que_detail not in", values, "queDetail");
            return (Criteria) this;
        }

        public Criteria andQueDetailBetween(String value1, String value2) {
            addCriterion("que_detail between", value1, value2, "queDetail");
            return (Criteria) this;
        }

        public Criteria andQueDetailNotBetween(String value1, String value2) {
            addCriterion("que_detail not between", value1, value2, "queDetail");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNull() {
            addCriterion("user_id is null");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNotNull() {
            addCriterion("user_id is not null");
            return (Criteria) this;
        }

        public Criteria andUserIdEqualTo(String value) {
            addCriterion("user_id =", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotEqualTo(String value) {
            addCriterion("user_id <>", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThan(String value) {
            addCriterion("user_id >", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThanOrEqualTo(String value) {
            addCriterion("user_id >=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThan(String value) {
            addCriterion("user_id <", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThanOrEqualTo(String value) {
            addCriterion("user_id <=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLike(String value) {
            addCriterion("user_id like", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotLike(String value) {
            addCriterion("user_id not like", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdIn(List<String> values) {
            addCriterion("user_id in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotIn(List<String> values) {
            addCriterion("user_id not in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdBetween(String value1, String value2) {
            addCriterion("user_id between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotBetween(String value1, String value2) {
            addCriterion("user_id not between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNull() {
            addCriterion("create_time is null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNotNull() {
            addCriterion("create_time is not null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeEqualTo(String value) {
            addCriterion("create_time =", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotEqualTo(String value) {
            addCriterion("create_time <>", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThan(String value) {
            addCriterion("create_time >", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThanOrEqualTo(String value) {
            addCriterion("create_time >=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThan(String value) {
            addCriterion("create_time <", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThanOrEqualTo(String value) {
            addCriterion("create_time <=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLike(String value) {
            addCriterion("create_time like", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotLike(String value) {
            addCriterion("create_time not like", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIn(List<String> values) {
            addCriterion("create_time in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotIn(List<String> values) {
            addCriterion("create_time not in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeBetween(String value1, String value2) {
            addCriterion("create_time between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotBetween(String value1, String value2) {
            addCriterion("create_time not between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andClickCountIsNull() {
            addCriterion("click_count is null");
            return (Criteria) this;
        }

        public Criteria andClickCountIsNotNull() {
            addCriterion("click_count is not null");
            return (Criteria) this;
        }

        public Criteria andClickCountEqualTo(Integer value) {
            addCriterion("click_count =", value, "clickCount");
            return (Criteria) this;
        }

        public Criteria andClickCountNotEqualTo(Integer value) {
            addCriterion("click_count <>", value, "clickCount");
            return (Criteria) this;
        }

        public Criteria andClickCountGreaterThan(Integer value) {
            addCriterion("click_count >", value, "clickCount");
            return (Criteria) this;
        }

        public Criteria andClickCountGreaterThanOrEqualTo(Integer value) {
            addCriterion("click_count >=", value, "clickCount");
            return (Criteria) this;
        }

        public Criteria andClickCountLessThan(Integer value) {
            addCriterion("click_count <", value, "clickCount");
            return (Criteria) this;
        }

        public Criteria andClickCountLessThanOrEqualTo(Integer value) {
            addCriterion("click_count <=", value, "clickCount");
            return (Criteria) this;
        }

        public Criteria andClickCountIn(List<Integer> values) {
            addCriterion("click_count in", values, "clickCount");
            return (Criteria) this;
        }

        public Criteria andClickCountNotIn(List<Integer> values) {
            addCriterion("click_count not in", values, "clickCount");
            return (Criteria) this;
        }

        public Criteria andClickCountBetween(Integer value1, Integer value2) {
            addCriterion("click_count between", value1, value2, "clickCount");
            return (Criteria) this;
        }

        public Criteria andClickCountNotBetween(Integer value1, Integer value2) {
            addCriterion("click_count not between", value1, value2, "clickCount");
            return (Criteria) this;
        }

        public Criteria andPraiseCountIsNull() {
            addCriterion("praise_count is null");
            return (Criteria) this;
        }

        public Criteria andPraiseCountIsNotNull() {
            addCriterion("praise_count is not null");
            return (Criteria) this;
        }

        public Criteria andPraiseCountEqualTo(Integer value) {
            addCriterion("praise_count =", value, "praiseCount");
            return (Criteria) this;
        }

        public Criteria andPraiseCountNotEqualTo(Integer value) {
            addCriterion("praise_count <>", value, "praiseCount");
            return (Criteria) this;
        }

        public Criteria andPraiseCountGreaterThan(Integer value) {
            addCriterion("praise_count >", value, "praiseCount");
            return (Criteria) this;
        }

        public Criteria andPraiseCountGreaterThanOrEqualTo(Integer value) {
            addCriterion("praise_count >=", value, "praiseCount");
            return (Criteria) this;
        }

        public Criteria andPraiseCountLessThan(Integer value) {
            addCriterion("praise_count <", value, "praiseCount");
            return (Criteria) this;
        }

        public Criteria andPraiseCountLessThanOrEqualTo(Integer value) {
            addCriterion("praise_count <=", value, "praiseCount");
            return (Criteria) this;
        }

        public Criteria andPraiseCountIn(List<Integer> values) {
            addCriterion("praise_count in", values, "praiseCount");
            return (Criteria) this;
        }

        public Criteria andPraiseCountNotIn(List<Integer> values) {
            addCriterion("praise_count not in", values, "praiseCount");
            return (Criteria) this;
        }

        public Criteria andPraiseCountBetween(Integer value1, Integer value2) {
            addCriterion("praise_count between", value1, value2, "praiseCount");
            return (Criteria) this;
        }

        public Criteria andPraiseCountNotBetween(Integer value1, Integer value2) {
            addCriterion("praise_count not between", value1, value2, "praiseCount");
            return (Criteria) this;
        }

        public Criteria andReplyCountIsNull() {
            addCriterion("reply_count is null");
            return (Criteria) this;
        }

        public Criteria andReplyCountIsNotNull() {
            addCriterion("reply_count is not null");
            return (Criteria) this;
        }

        public Criteria andReplyCountEqualTo(Integer value) {
            addCriterion("reply_count =", value, "replyCount");
            return (Criteria) this;
        }

        public Criteria andReplyCountNotEqualTo(Integer value) {
            addCriterion("reply_count <>", value, "replyCount");
            return (Criteria) this;
        }

        public Criteria andReplyCountGreaterThan(Integer value) {
            addCriterion("reply_count >", value, "replyCount");
            return (Criteria) this;
        }

        public Criteria andReplyCountGreaterThanOrEqualTo(Integer value) {
            addCriterion("reply_count >=", value, "replyCount");
            return (Criteria) this;
        }

        public Criteria andReplyCountLessThan(Integer value) {
            addCriterion("reply_count <", value, "replyCount");
            return (Criteria) this;
        }

        public Criteria andReplyCountLessThanOrEqualTo(Integer value) {
            addCriterion("reply_count <=", value, "replyCount");
            return (Criteria) this;
        }

        public Criteria andReplyCountIn(List<Integer> values) {
            addCriterion("reply_count in", values, "replyCount");
            return (Criteria) this;
        }

        public Criteria andReplyCountNotIn(List<Integer> values) {
            addCriterion("reply_count not in", values, "replyCount");
            return (Criteria) this;
        }

        public Criteria andReplyCountBetween(Integer value1, Integer value2) {
            addCriterion("reply_count between", value1, value2, "replyCount");
            return (Criteria) this;
        }

        public Criteria andReplyCountNotBetween(Integer value1, Integer value2) {
            addCriterion("reply_count not between", value1, value2, "replyCount");
            return (Criteria) this;
        }

        public Criteria andQueCourseIsNull() {
            addCriterion("que_course is null");
            return (Criteria) this;
        }

        public Criteria andQueCourseIsNotNull() {
            addCriterion("que_course is not null");
            return (Criteria) this;
        }

        public Criteria andQueCourseEqualTo(String value) {
            addCriterion("que_course =", value, "queCourse");
            return (Criteria) this;
        }

        public Criteria andQueCourseNotEqualTo(String value) {
            addCriterion("que_course <>", value, "queCourse");
            return (Criteria) this;
        }

        public Criteria andQueCourseGreaterThan(String value) {
            addCriterion("que_course >", value, "queCourse");
            return (Criteria) this;
        }

        public Criteria andQueCourseGreaterThanOrEqualTo(String value) {
            addCriterion("que_course >=", value, "queCourse");
            return (Criteria) this;
        }

        public Criteria andQueCourseLessThan(String value) {
            addCriterion("que_course <", value, "queCourse");
            return (Criteria) this;
        }

        public Criteria andQueCourseLessThanOrEqualTo(String value) {
            addCriterion("que_course <=", value, "queCourse");
            return (Criteria) this;
        }

        public Criteria andQueCourseLike(String value) {
            addCriterion("que_course like", value, "queCourse");
            return (Criteria) this;
        }

        public Criteria andQueCourseNotLike(String value) {
            addCriterion("que_course not like", value, "queCourse");
            return (Criteria) this;
        }

        public Criteria andQueCourseIn(List<String> values) {
            addCriterion("que_course in", values, "queCourse");
            return (Criteria) this;
        }

        public Criteria andQueCourseNotIn(List<String> values) {
            addCriterion("que_course not in", values, "queCourse");
            return (Criteria) this;
        }

        public Criteria andQueCourseBetween(String value1, String value2) {
            addCriterion("que_course between", value1, value2, "queCourse");
            return (Criteria) this;
        }

        public Criteria andQueCourseNotBetween(String value1, String value2) {
            addCriterion("que_course not between", value1, value2, "queCourse");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}

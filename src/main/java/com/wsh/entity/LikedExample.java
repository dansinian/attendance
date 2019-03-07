package com.wsh.entity;

import java.util.ArrayList;
import java.util.List;

public class LikedExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public LikedExample() {
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

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andLikeUserIsNull() {
            addCriterion("like_user is null");
            return (Criteria) this;
        }

        public Criteria andLikeUserIsNotNull() {
            addCriterion("like_user is not null");
            return (Criteria) this;
        }

        public Criteria andLikeUserEqualTo(String value) {
            addCriterion("like_user =", value, "likeUser");
            return (Criteria) this;
        }

        public Criteria andLikeUserNotEqualTo(String value) {
            addCriterion("like_user <>", value, "likeUser");
            return (Criteria) this;
        }

        public Criteria andLikeUserGreaterThan(String value) {
            addCriterion("like_user >", value, "likeUser");
            return (Criteria) this;
        }

        public Criteria andLikeUserGreaterThanOrEqualTo(String value) {
            addCriterion("like_user >=", value, "likeUser");
            return (Criteria) this;
        }

        public Criteria andLikeUserLessThan(String value) {
            addCriterion("like_user <", value, "likeUser");
            return (Criteria) this;
        }

        public Criteria andLikeUserLessThanOrEqualTo(String value) {
            addCriterion("like_user <=", value, "likeUser");
            return (Criteria) this;
        }

        public Criteria andLikeUserLike(String value) {
            addCriterion("like_user like", value, "likeUser");
            return (Criteria) this;
        }

        public Criteria andLikeUserNotLike(String value) {
            addCriterion("like_user not like", value, "likeUser");
            return (Criteria) this;
        }

        public Criteria andLikeUserIn(List<String> values) {
            addCriterion("like_user in", values, "likeUser");
            return (Criteria) this;
        }

        public Criteria andLikeUserNotIn(List<String> values) {
            addCriterion("like_user not in", values, "likeUser");
            return (Criteria) this;
        }

        public Criteria andLikeUserBetween(String value1, String value2) {
            addCriterion("like_user between", value1, value2, "likeUser");
            return (Criteria) this;
        }

        public Criteria andLikeUserNotBetween(String value1, String value2) {
            addCriterion("like_user not between", value1, value2, "likeUser");
            return (Criteria) this;
        }

        public Criteria andLikedQuestionIsNull() {
            addCriterion("liked_question is null");
            return (Criteria) this;
        }

        public Criteria andLikedQuestionIsNotNull() {
            addCriterion("liked_question is not null");
            return (Criteria) this;
        }

        public Criteria andLikedQuestionEqualTo(String value) {
            addCriterion("liked_question =", value, "likedQuestion");
            return (Criteria) this;
        }

        public Criteria andLikedQuestionNotEqualTo(String value) {
            addCriterion("liked_question <>", value, "likedQuestion");
            return (Criteria) this;
        }

        public Criteria andLikedQuestionGreaterThan(String value) {
            addCriterion("liked_question >", value, "likedQuestion");
            return (Criteria) this;
        }

        public Criteria andLikedQuestionGreaterThanOrEqualTo(String value) {
            addCriterion("liked_question >=", value, "likedQuestion");
            return (Criteria) this;
        }

        public Criteria andLikedQuestionLessThan(String value) {
            addCriterion("liked_question <", value, "likedQuestion");
            return (Criteria) this;
        }

        public Criteria andLikedQuestionLessThanOrEqualTo(String value) {
            addCriterion("liked_question <=", value, "likedQuestion");
            return (Criteria) this;
        }

        public Criteria andLikedQuestionLike(String value) {
            addCriterion("liked_question like", value, "likedQuestion");
            return (Criteria) this;
        }

        public Criteria andLikedQuestionNotLike(String value) {
            addCriterion("liked_question not like", value, "likedQuestion");
            return (Criteria) this;
        }

        public Criteria andLikedQuestionIn(List<String> values) {
            addCriterion("liked_question in", values, "likedQuestion");
            return (Criteria) this;
        }

        public Criteria andLikedQuestionNotIn(List<String> values) {
            addCriterion("liked_question not in", values, "likedQuestion");
            return (Criteria) this;
        }

        public Criteria andLikedQuestionBetween(String value1, String value2) {
            addCriterion("liked_question between", value1, value2, "likedQuestion");
            return (Criteria) this;
        }

        public Criteria andLikedQuestionNotBetween(String value1, String value2) {
            addCriterion("liked_question not between", value1, value2, "likedQuestion");
            return (Criteria) this;
        }

        public Criteria andLikedCommentIsNull() {
            addCriterion("liked_comment is null");
            return (Criteria) this;
        }

        public Criteria andLikedCommentIsNotNull() {
            addCriterion("liked_comment is not null");
            return (Criteria) this;
        }

        public Criteria andLikedCommentEqualTo(String value) {
            addCriterion("liked_comment =", value, "likedComment");
            return (Criteria) this;
        }

        public Criteria andLikedCommentNotEqualTo(String value) {
            addCriterion("liked_comment <>", value, "likedComment");
            return (Criteria) this;
        }

        public Criteria andLikedCommentGreaterThan(String value) {
            addCriterion("liked_comment >", value, "likedComment");
            return (Criteria) this;
        }

        public Criteria andLikedCommentGreaterThanOrEqualTo(String value) {
            addCriterion("liked_comment >=", value, "likedComment");
            return (Criteria) this;
        }

        public Criteria andLikedCommentLessThan(String value) {
            addCriterion("liked_comment <", value, "likedComment");
            return (Criteria) this;
        }

        public Criteria andLikedCommentLessThanOrEqualTo(String value) {
            addCriterion("liked_comment <=", value, "likedComment");
            return (Criteria) this;
        }

        public Criteria andLikedCommentLike(String value) {
            addCriterion("liked_comment like", value, "likedComment");
            return (Criteria) this;
        }

        public Criteria andLikedCommentNotLike(String value) {
            addCriterion("liked_comment not like", value, "likedComment");
            return (Criteria) this;
        }

        public Criteria andLikedCommentIn(List<String> values) {
            addCriterion("liked_comment in", values, "likedComment");
            return (Criteria) this;
        }

        public Criteria andLikedCommentNotIn(List<String> values) {
            addCriterion("liked_comment not in", values, "likedComment");
            return (Criteria) this;
        }

        public Criteria andLikedCommentBetween(String value1, String value2) {
            addCriterion("liked_comment between", value1, value2, "likedComment");
            return (Criteria) this;
        }

        public Criteria andLikedCommentNotBetween(String value1, String value2) {
            addCriterion("liked_comment not between", value1, value2, "likedComment");
            return (Criteria) this;
        }

        public Criteria andLikedReplyIsNull() {
            addCriterion("liked_reply is null");
            return (Criteria) this;
        }

        public Criteria andLikedReplyIsNotNull() {
            addCriterion("liked_reply is not null");
            return (Criteria) this;
        }

        public Criteria andLikedReplyEqualTo(String value) {
            addCriterion("liked_reply =", value, "likedReply");
            return (Criteria) this;
        }

        public Criteria andLikedReplyNotEqualTo(String value) {
            addCriterion("liked_reply <>", value, "likedReply");
            return (Criteria) this;
        }

        public Criteria andLikedReplyGreaterThan(String value) {
            addCriterion("liked_reply >", value, "likedReply");
            return (Criteria) this;
        }

        public Criteria andLikedReplyGreaterThanOrEqualTo(String value) {
            addCriterion("liked_reply >=", value, "likedReply");
            return (Criteria) this;
        }

        public Criteria andLikedReplyLessThan(String value) {
            addCriterion("liked_reply <", value, "likedReply");
            return (Criteria) this;
        }

        public Criteria andLikedReplyLessThanOrEqualTo(String value) {
            addCriterion("liked_reply <=", value, "likedReply");
            return (Criteria) this;
        }

        public Criteria andLikedReplyLike(String value) {
            addCriterion("liked_reply like", value, "likedReply");
            return (Criteria) this;
        }

        public Criteria andLikedReplyNotLike(String value) {
            addCriterion("liked_reply not like", value, "likedReply");
            return (Criteria) this;
        }

        public Criteria andLikedReplyIn(List<String> values) {
            addCriterion("liked_reply in", values, "likedReply");
            return (Criteria) this;
        }

        public Criteria andLikedReplyNotIn(List<String> values) {
            addCriterion("liked_reply not in", values, "likedReply");
            return (Criteria) this;
        }

        public Criteria andLikedReplyBetween(String value1, String value2) {
            addCriterion("liked_reply between", value1, value2, "likedReply");
            return (Criteria) this;
        }

        public Criteria andLikedReplyNotBetween(String value1, String value2) {
            addCriterion("liked_reply not between", value1, value2, "likedReply");
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
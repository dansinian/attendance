package com.wsh.entity;

import java.util.ArrayList;
import java.util.List;

public class CourseArrangementExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public CourseArrangementExample() {
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

        public Criteria andCarmIdIsNull() {
            addCriterion("carm_id is null");
            return (Criteria) this;
        }

        public Criteria andCarmIdIsNotNull() {
            addCriterion("carm_id is not null");
            return (Criteria) this;
        }

        public Criteria andCarmIdEqualTo(String value) {
            addCriterion("carm_id =", value, "carmId");
            return (Criteria) this;
        }

        public Criteria andCarmIdNotEqualTo(String value) {
            addCriterion("carm_id <>", value, "carmId");
            return (Criteria) this;
        }

        public Criteria andCarmIdGreaterThan(String value) {
            addCriterion("carm_id >", value, "carmId");
            return (Criteria) this;
        }

        public Criteria andCarmIdGreaterThanOrEqualTo(String value) {
            addCriterion("carm_id >=", value, "carmId");
            return (Criteria) this;
        }

        public Criteria andCarmIdLessThan(String value) {
            addCriterion("carm_id <", value, "carmId");
            return (Criteria) this;
        }

        public Criteria andCarmIdLessThanOrEqualTo(String value) {
            addCriterion("carm_id <=", value, "carmId");
            return (Criteria) this;
        }

        public Criteria andCarmIdLike(String value) {
            addCriterion("carm_id like", value, "carmId");
            return (Criteria) this;
        }

        public Criteria andCarmIdNotLike(String value) {
            addCriterion("carm_id not like", value, "carmId");
            return (Criteria) this;
        }

        public Criteria andCarmIdIn(List<String> values) {
            addCriterion("carm_id in", values, "carmId");
            return (Criteria) this;
        }

        public Criteria andCarmIdNotIn(List<String> values) {
            addCriterion("carm_id not in", values, "carmId");
            return (Criteria) this;
        }

        public Criteria andCarmIdBetween(String value1, String value2) {
            addCriterion("carm_id between", value1, value2, "carmId");
            return (Criteria) this;
        }

        public Criteria andCarmIdNotBetween(String value1, String value2) {
            addCriterion("carm_id not between", value1, value2, "carmId");
            return (Criteria) this;
        }

        public Criteria andCourseIdIsNull() {
            addCriterion("course_id is null");
            return (Criteria) this;
        }

        public Criteria andCourseIdIsNotNull() {
            addCriterion("course_id is not null");
            return (Criteria) this;
        }

        public Criteria andCourseIdEqualTo(String value) {
            addCriterion("course_id =", value, "courseId");
            return (Criteria) this;
        }

        public Criteria andCourseIdNotEqualTo(String value) {
            addCriterion("course_id <>", value, "courseId");
            return (Criteria) this;
        }

        public Criteria andCourseIdGreaterThan(String value) {
            addCriterion("course_id >", value, "courseId");
            return (Criteria) this;
        }

        public Criteria andCourseIdGreaterThanOrEqualTo(String value) {
            addCriterion("course_id >=", value, "courseId");
            return (Criteria) this;
        }

        public Criteria andCourseIdLessThan(String value) {
            addCriterion("course_id <", value, "courseId");
            return (Criteria) this;
        }

        public Criteria andCourseIdLessThanOrEqualTo(String value) {
            addCriterion("course_id <=", value, "courseId");
            return (Criteria) this;
        }

        public Criteria andCourseIdLike(String value) {
            addCriterion("course_id like", value, "courseId");
            return (Criteria) this;
        }

        public Criteria andCourseIdNotLike(String value) {
            addCriterion("course_id not like", value, "courseId");
            return (Criteria) this;
        }

        public Criteria andCourseIdIn(List<String> values) {
            addCriterion("course_id in", values, "courseId");
            return (Criteria) this;
        }

        public Criteria andCourseIdNotIn(List<String> values) {
            addCriterion("course_id not in", values, "courseId");
            return (Criteria) this;
        }

        public Criteria andCourseIdBetween(String value1, String value2) {
            addCriterion("course_id between", value1, value2, "courseId");
            return (Criteria) this;
        }

        public Criteria andCourseIdNotBetween(String value1, String value2) {
            addCriterion("course_id not between", value1, value2, "courseId");
            return (Criteria) this;
        }

        public Criteria andCourseNameIsNull() {
            addCriterion("course_name is null");
            return (Criteria) this;
        }

        public Criteria andCourseNameIsNotNull() {
            addCriterion("course_name is not null");
            return (Criteria) this;
        }

        public Criteria andCourseNameEqualTo(String value) {
            addCriterion("course_name =", value, "courseName");
            return (Criteria) this;
        }

        public Criteria andCourseNameNotEqualTo(String value) {
            addCriterion("course_name <>", value, "courseName");
            return (Criteria) this;
        }

        public Criteria andCourseNameGreaterThan(String value) {
            addCriterion("course_name >", value, "courseName");
            return (Criteria) this;
        }

        public Criteria andCourseNameGreaterThanOrEqualTo(String value) {
            addCriterion("course_name >=", value, "courseName");
            return (Criteria) this;
        }

        public Criteria andCourseNameLessThan(String value) {
            addCriterion("course_name <", value, "courseName");
            return (Criteria) this;
        }

        public Criteria andCourseNameLessThanOrEqualTo(String value) {
            addCriterion("course_name <=", value, "courseName");
            return (Criteria) this;
        }

        public Criteria andCourseNameLike(String value) {
            addCriterion("course_name like", value, "courseName");
            return (Criteria) this;
        }

        public Criteria andCourseNameNotLike(String value) {
            addCriterion("course_name not like", value, "courseName");
            return (Criteria) this;
        }

        public Criteria andCourseNameIn(List<String> values) {
            addCriterion("course_name in", values, "courseName");
            return (Criteria) this;
        }

        public Criteria andCourseNameNotIn(List<String> values) {
            addCriterion("course_name not in", values, "courseName");
            return (Criteria) this;
        }

        public Criteria andCourseNameBetween(String value1, String value2) {
            addCriterion("course_name between", value1, value2, "courseName");
            return (Criteria) this;
        }

        public Criteria andCourseNameNotBetween(String value1, String value2) {
            addCriterion("course_name not between", value1, value2, "courseName");
            return (Criteria) this;
        }

        public Criteria andCourseWeekIsNull() {
            addCriterion("course_week is null");
            return (Criteria) this;
        }

        public Criteria andCourseWeekIsNotNull() {
            addCriterion("course_week is not null");
            return (Criteria) this;
        }

        public Criteria andCourseWeekEqualTo(String value) {
            addCriterion("course_week =", value, "courseWeek");
            return (Criteria) this;
        }

        public Criteria andCourseWeekNotEqualTo(String value) {
            addCriterion("course_week <>", value, "courseWeek");
            return (Criteria) this;
        }

        public Criteria andCourseWeekGreaterThan(String value) {
            addCriterion("course_week >", value, "courseWeek");
            return (Criteria) this;
        }

        public Criteria andCourseWeekGreaterThanOrEqualTo(String value) {
            addCriterion("course_week >=", value, "courseWeek");
            return (Criteria) this;
        }

        public Criteria andCourseWeekLessThan(String value) {
            addCriterion("course_week <", value, "courseWeek");
            return (Criteria) this;
        }

        public Criteria andCourseWeekLessThanOrEqualTo(String value) {
            addCriterion("course_week <=", value, "courseWeek");
            return (Criteria) this;
        }

        public Criteria andCourseWeekLike(String value) {
            addCriterion("course_week like", value, "courseWeek");
            return (Criteria) this;
        }

        public Criteria andCourseWeekNotLike(String value) {
            addCriterion("course_week not like", value, "courseWeek");
            return (Criteria) this;
        }

        public Criteria andCourseWeekIn(List<String> values) {
            addCriterion("course_week in", values, "courseWeek");
            return (Criteria) this;
        }

        public Criteria andCourseWeekNotIn(List<String> values) {
            addCriterion("course_week not in", values, "courseWeek");
            return (Criteria) this;
        }

        public Criteria andCourseWeekBetween(String value1, String value2) {
            addCriterion("course_week between", value1, value2, "courseWeek");
            return (Criteria) this;
        }

        public Criteria andCourseWeekNotBetween(String value1, String value2) {
            addCriterion("course_week not between", value1, value2, "courseWeek");
            return (Criteria) this;
        }

        public Criteria andCourseTimeIsNull() {
            addCriterion("course_time is null");
            return (Criteria) this;
        }

        public Criteria andCourseTimeIsNotNull() {
            addCriterion("course_time is not null");
            return (Criteria) this;
        }

        public Criteria andCourseTimeEqualTo(String value) {
            addCriterion("course_time =", value, "courseTime");
            return (Criteria) this;
        }

        public Criteria andCourseTimeNotEqualTo(String value) {
            addCriterion("course_time <>", value, "courseTime");
            return (Criteria) this;
        }

        public Criteria andCourseTimeGreaterThan(String value) {
            addCriterion("course_time >", value, "courseTime");
            return (Criteria) this;
        }

        public Criteria andCourseTimeGreaterThanOrEqualTo(String value) {
            addCriterion("course_time >=", value, "courseTime");
            return (Criteria) this;
        }

        public Criteria andCourseTimeLessThan(String value) {
            addCriterion("course_time <", value, "courseTime");
            return (Criteria) this;
        }

        public Criteria andCourseTimeLessThanOrEqualTo(String value) {
            addCriterion("course_time <=", value, "courseTime");
            return (Criteria) this;
        }

        public Criteria andCourseTimeLike(String value) {
            addCriterion("course_time like", value, "courseTime");
            return (Criteria) this;
        }

        public Criteria andCourseTimeNotLike(String value) {
            addCriterion("course_time not like", value, "courseTime");
            return (Criteria) this;
        }

        public Criteria andCourseTimeIn(List<String> values) {
            addCriterion("course_time in", values, "courseTime");
            return (Criteria) this;
        }

        public Criteria andCourseTimeNotIn(List<String> values) {
            addCriterion("course_time not in", values, "courseTime");
            return (Criteria) this;
        }

        public Criteria andCourseTimeBetween(String value1, String value2) {
            addCriterion("course_time between", value1, value2, "courseTime");
            return (Criteria) this;
        }

        public Criteria andCourseTimeNotBetween(String value1, String value2) {
            addCriterion("course_time not between", value1, value2, "courseTime");
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
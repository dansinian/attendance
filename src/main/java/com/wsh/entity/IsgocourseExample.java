package com.wsh.entity;

import java.util.ArrayList;
import java.util.List;

public class IsgocourseExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public IsgocourseExample() {
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

        public Criteria andStuIdIsNull() {
            addCriterion("stu_id is null");
            return (Criteria) this;
        }

        public Criteria andStuIdIsNotNull() {
            addCriterion("stu_id is not null");
            return (Criteria) this;
        }

        public Criteria andStuIdEqualTo(String value) {
            addCriterion("stu_id =", value, "stuId");
            return (Criteria) this;
        }

        public Criteria andStuIdNotEqualTo(String value) {
            addCriterion("stu_id <>", value, "stuId");
            return (Criteria) this;
        }

        public Criteria andStuIdGreaterThan(String value) {
            addCriterion("stu_id >", value, "stuId");
            return (Criteria) this;
        }

        public Criteria andStuIdGreaterThanOrEqualTo(String value) {
            addCriterion("stu_id >=", value, "stuId");
            return (Criteria) this;
        }

        public Criteria andStuIdLessThan(String value) {
            addCriterion("stu_id <", value, "stuId");
            return (Criteria) this;
        }

        public Criteria andStuIdLessThanOrEqualTo(String value) {
            addCriterion("stu_id <=", value, "stuId");
            return (Criteria) this;
        }

        public Criteria andStuIdLike(String value) {
            addCriterion("stu_id like", value, "stuId");
            return (Criteria) this;
        }

        public Criteria andStuIdNotLike(String value) {
            addCriterion("stu_id not like", value, "stuId");
            return (Criteria) this;
        }

        public Criteria andStuIdIn(List<String> values) {
            addCriterion("stu_id in", values, "stuId");
            return (Criteria) this;
        }

        public Criteria andStuIdNotIn(List<String> values) {
            addCriterion("stu_id not in", values, "stuId");
            return (Criteria) this;
        }

        public Criteria andStuIdBetween(String value1, String value2) {
            addCriterion("stu_id between", value1, value2, "stuId");
            return (Criteria) this;
        }

        public Criteria andStuIdNotBetween(String value1, String value2) {
            addCriterion("stu_id not between", value1, value2, "stuId");
            return (Criteria) this;
        }

        public Criteria andCourseTeacherIsNull() {
            addCriterion("course_teacher is null");
            return (Criteria) this;
        }

        public Criteria andCourseTeacherIsNotNull() {
            addCriterion("course_teacher is not null");
            return (Criteria) this;
        }

        public Criteria andCourseTeacherEqualTo(String value) {
            addCriterion("course_teacher =", value, "courseTeacher");
            return (Criteria) this;
        }

        public Criteria andCourseTeacherNotEqualTo(String value) {
            addCriterion("course_teacher <>", value, "courseTeacher");
            return (Criteria) this;
        }

        public Criteria andCourseTeacherGreaterThan(String value) {
            addCriterion("course_teacher >", value, "courseTeacher");
            return (Criteria) this;
        }

        public Criteria andCourseTeacherGreaterThanOrEqualTo(String value) {
            addCriterion("course_teacher >=", value, "courseTeacher");
            return (Criteria) this;
        }

        public Criteria andCourseTeacherLessThan(String value) {
            addCriterion("course_teacher <", value, "courseTeacher");
            return (Criteria) this;
        }

        public Criteria andCourseTeacherLessThanOrEqualTo(String value) {
            addCriterion("course_teacher <=", value, "courseTeacher");
            return (Criteria) this;
        }

        public Criteria andCourseTeacherLike(String value) {
            addCriterion("course_teacher like", value, "courseTeacher");
            return (Criteria) this;
        }

        public Criteria andCourseTeacherNotLike(String value) {
            addCriterion("course_teacher not like", value, "courseTeacher");
            return (Criteria) this;
        }

        public Criteria andCourseTeacherIn(List<String> values) {
            addCriterion("course_teacher in", values, "courseTeacher");
            return (Criteria) this;
        }

        public Criteria andCourseTeacherNotIn(List<String> values) {
            addCriterion("course_teacher not in", values, "courseTeacher");
            return (Criteria) this;
        }

        public Criteria andCourseTeacherBetween(String value1, String value2) {
            addCriterion("course_teacher between", value1, value2, "courseTeacher");
            return (Criteria) this;
        }

        public Criteria andCourseTeacherNotBetween(String value1, String value2) {
            addCriterion("course_teacher not between", value1, value2, "courseTeacher");
            return (Criteria) this;
        }

        public Criteria andIsTruancyIsNull() {
            addCriterion("is_truancy is null");
            return (Criteria) this;
        }

        public Criteria andIsTruancyIsNotNull() {
            addCriterion("is_truancy is not null");
            return (Criteria) this;
        }

        public Criteria andIsTruancyEqualTo(String value) {
            addCriterion("is_truancy =", value, "isTruancy");
            return (Criteria) this;
        }

        public Criteria andIsTruancyNotEqualTo(String value) {
            addCriterion("is_truancy <>", value, "isTruancy");
            return (Criteria) this;
        }

        public Criteria andIsTruancyGreaterThan(String value) {
            addCriterion("is_truancy >", value, "isTruancy");
            return (Criteria) this;
        }

        public Criteria andIsTruancyGreaterThanOrEqualTo(String value) {
            addCriterion("is_truancy >=", value, "isTruancy");
            return (Criteria) this;
        }

        public Criteria andIsTruancyLessThan(String value) {
            addCriterion("is_truancy <", value, "isTruancy");
            return (Criteria) this;
        }

        public Criteria andIsTruancyLessThanOrEqualTo(String value) {
            addCriterion("is_truancy <=", value, "isTruancy");
            return (Criteria) this;
        }

        public Criteria andIsTruancyLike(String value) {
            addCriterion("is_truancy like", value, "isTruancy");
            return (Criteria) this;
        }

        public Criteria andIsTruancyNotLike(String value) {
            addCriterion("is_truancy not like", value, "isTruancy");
            return (Criteria) this;
        }

        public Criteria andIsTruancyIn(List<String> values) {
            addCriterion("is_truancy in", values, "isTruancy");
            return (Criteria) this;
        }

        public Criteria andIsTruancyNotIn(List<String> values) {
            addCriterion("is_truancy not in", values, "isTruancy");
            return (Criteria) this;
        }

        public Criteria andIsTruancyBetween(String value1, String value2) {
            addCriterion("is_truancy between", value1, value2, "isTruancy");
            return (Criteria) this;
        }

        public Criteria andIsTruancyNotBetween(String value1, String value2) {
            addCriterion("is_truancy not between", value1, value2, "isTruancy");
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

        public Criteria andStuClassIsNull() {
            addCriterion("stu_class is null");
            return (Criteria) this;
        }

        public Criteria andStuClassIsNotNull() {
            addCriterion("stu_class is not null");
            return (Criteria) this;
        }

        public Criteria andStuClassEqualTo(String value) {
            addCriterion("stu_class =", value, "stuClass");
            return (Criteria) this;
        }

        public Criteria andStuClassNotEqualTo(String value) {
            addCriterion("stu_class <>", value, "stuClass");
            return (Criteria) this;
        }

        public Criteria andStuClassGreaterThan(String value) {
            addCriterion("stu_class >", value, "stuClass");
            return (Criteria) this;
        }

        public Criteria andStuClassGreaterThanOrEqualTo(String value) {
            addCriterion("stu_class >=", value, "stuClass");
            return (Criteria) this;
        }

        public Criteria andStuClassLessThan(String value) {
            addCriterion("stu_class <", value, "stuClass");
            return (Criteria) this;
        }

        public Criteria andStuClassLessThanOrEqualTo(String value) {
            addCriterion("stu_class <=", value, "stuClass");
            return (Criteria) this;
        }

        public Criteria andStuClassLike(String value) {
            addCriterion("stu_class like", value, "stuClass");
            return (Criteria) this;
        }

        public Criteria andStuClassNotLike(String value) {
            addCriterion("stu_class not like", value, "stuClass");
            return (Criteria) this;
        }

        public Criteria andStuClassIn(List<String> values) {
            addCriterion("stu_class in", values, "stuClass");
            return (Criteria) this;
        }

        public Criteria andStuClassNotIn(List<String> values) {
            addCriterion("stu_class not in", values, "stuClass");
            return (Criteria) this;
        }

        public Criteria andStuClassBetween(String value1, String value2) {
            addCriterion("stu_class between", value1, value2, "stuClass");
            return (Criteria) this;
        }

        public Criteria andStuClassNotBetween(String value1, String value2) {
            addCriterion("stu_class not between", value1, value2, "stuClass");
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
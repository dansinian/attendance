package com.wsh.entity;

import java.util.ArrayList;
import java.util.List;

public class CourseExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public CourseExample() {
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
            addCriterion("course_ID is null");
            return (Criteria) this;
        }

        public Criteria andCourseIdIsNotNull() {
            addCriterion("course_ID is not null");
            return (Criteria) this;
        }

        public Criteria andCourseIdEqualTo(String value) {
            addCriterion("course_ID =", value, "courseId");
            return (Criteria) this;
        }

        public Criteria andCourseIdNotEqualTo(String value) {
            addCriterion("course_ID <>", value, "courseId");
            return (Criteria) this;
        }

        public Criteria andCourseIdGreaterThan(String value) {
            addCriterion("course_ID >", value, "courseId");
            return (Criteria) this;
        }

        public Criteria andCourseIdGreaterThanOrEqualTo(String value) {
            addCriterion("course_ID >=", value, "courseId");
            return (Criteria) this;
        }

        public Criteria andCourseIdLessThan(String value) {
            addCriterion("course_ID <", value, "courseId");
            return (Criteria) this;
        }

        public Criteria andCourseIdLessThanOrEqualTo(String value) {
            addCriterion("course_ID <=", value, "courseId");
            return (Criteria) this;
        }

        public Criteria andCourseIdLike(String value) {
            addCriterion("course_ID like", value, "courseId");
            return (Criteria) this;
        }

        public Criteria andCourseIdNotLike(String value) {
            addCriterion("course_ID not like", value, "courseId");
            return (Criteria) this;
        }

        public Criteria andCourseIdIn(List<String> values) {
            addCriterion("course_ID in", values, "courseId");
            return (Criteria) this;
        }

        public Criteria andCourseIdNotIn(List<String> values) {
            addCriterion("course_ID not in", values, "courseId");
            return (Criteria) this;
        }

        public Criteria andCourseIdBetween(String value1, String value2) {
            addCriterion("course_ID between", value1, value2, "courseId");
            return (Criteria) this;
        }

        public Criteria andCourseIdNotBetween(String value1, String value2) {
            addCriterion("course_ID not between", value1, value2, "courseId");
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

        public Criteria andTeaNameIsNull() {
            addCriterion("tea_name is null");
            return (Criteria) this;
        }

        public Criteria andTeaNameIsNotNull() {
            addCriterion("tea_name is not null");
            return (Criteria) this;
        }

        public Criteria andTeaNameEqualTo(String value) {
            addCriterion("tea_name =", value, "teaName");
            return (Criteria) this;
        }

        public Criteria andTeaNameNotEqualTo(String value) {
            addCriterion("tea_name <>", value, "teaName");
            return (Criteria) this;
        }

        public Criteria andTeaNameGreaterThan(String value) {
            addCriterion("tea_name >", value, "teaName");
            return (Criteria) this;
        }

        public Criteria andTeaNameGreaterThanOrEqualTo(String value) {
            addCriterion("tea_name >=", value, "teaName");
            return (Criteria) this;
        }

        public Criteria andTeaNameLessThan(String value) {
            addCriterion("tea_name <", value, "teaName");
            return (Criteria) this;
        }

        public Criteria andTeaNameLessThanOrEqualTo(String value) {
            addCriterion("tea_name <=", value, "teaName");
            return (Criteria) this;
        }

        public Criteria andTeaNameLike(String value) {
            addCriterion("tea_name like", value, "teaName");
            return (Criteria) this;
        }

        public Criteria andTeaNameNotLike(String value) {
            addCriterion("tea_name not like", value, "teaName");
            return (Criteria) this;
        }

        public Criteria andTeaNameIn(List<String> values) {
            addCriterion("tea_name in", values, "teaName");
            return (Criteria) this;
        }

        public Criteria andTeaNameNotIn(List<String> values) {
            addCriterion("tea_name not in", values, "teaName");
            return (Criteria) this;
        }

        public Criteria andTeaNameBetween(String value1, String value2) {
            addCriterion("tea_name between", value1, value2, "teaName");
            return (Criteria) this;
        }

        public Criteria andTeaNameNotBetween(String value1, String value2) {
            addCriterion("tea_name not between", value1, value2, "teaName");
            return (Criteria) this;
        }

        public Criteria andCourseClassIsNull() {
            addCriterion("course_class is null");
            return (Criteria) this;
        }

        public Criteria andCourseClassIsNotNull() {
            addCriterion("course_class is not null");
            return (Criteria) this;
        }

        public Criteria andCourseClassEqualTo(String value) {
            addCriterion("course_class =", value, "courseClass");
            return (Criteria) this;
        }

        public Criteria andCourseClassNotEqualTo(String value) {
            addCriterion("course_class <>", value, "courseClass");
            return (Criteria) this;
        }

        public Criteria andCourseClassGreaterThan(String value) {
            addCriterion("course_class >", value, "courseClass");
            return (Criteria) this;
        }

        public Criteria andCourseClassGreaterThanOrEqualTo(String value) {
            addCriterion("course_class >=", value, "courseClass");
            return (Criteria) this;
        }

        public Criteria andCourseClassLessThan(String value) {
            addCriterion("course_class <", value, "courseClass");
            return (Criteria) this;
        }

        public Criteria andCourseClassLessThanOrEqualTo(String value) {
            addCriterion("course_class <=", value, "courseClass");
            return (Criteria) this;
        }

        public Criteria andCourseClassLike(String value) {
            addCriterion("course_class like", value, "courseClass");
            return (Criteria) this;
        }

        public Criteria andCourseClassNotLike(String value) {
            addCriterion("course_class not like", value, "courseClass");
            return (Criteria) this;
        }

        public Criteria andCourseClassIn(List<String> values) {
            addCriterion("course_class in", values, "courseClass");
            return (Criteria) this;
        }

        public Criteria andCourseClassNotIn(List<String> values) {
            addCriterion("course_class not in", values, "courseClass");
            return (Criteria) this;
        }

        public Criteria andCourseClassBetween(String value1, String value2) {
            addCriterion("course_class between", value1, value2, "courseClass");
            return (Criteria) this;
        }

        public Criteria andCourseClassNotBetween(String value1, String value2) {
            addCriterion("course_class not between", value1, value2, "courseClass");
            return (Criteria) this;
        }

        public Criteria andCourseMajorIsNull() {
            addCriterion("course_major is null");
            return (Criteria) this;
        }

        public Criteria andCourseMajorIsNotNull() {
            addCriterion("course_major is not null");
            return (Criteria) this;
        }

        public Criteria andCourseMajorEqualTo(String value) {
            addCriterion("course_major =", value, "courseMajor");
            return (Criteria) this;
        }

        public Criteria andCourseMajorNotEqualTo(String value) {
            addCriterion("course_major <>", value, "courseMajor");
            return (Criteria) this;
        }

        public Criteria andCourseMajorGreaterThan(String value) {
            addCriterion("course_major >", value, "courseMajor");
            return (Criteria) this;
        }

        public Criteria andCourseMajorGreaterThanOrEqualTo(String value) {
            addCriterion("course_major >=", value, "courseMajor");
            return (Criteria) this;
        }

        public Criteria andCourseMajorLessThan(String value) {
            addCriterion("course_major <", value, "courseMajor");
            return (Criteria) this;
        }

        public Criteria andCourseMajorLessThanOrEqualTo(String value) {
            addCriterion("course_major <=", value, "courseMajor");
            return (Criteria) this;
        }

        public Criteria andCourseMajorLike(String value) {
            addCriterion("course_major like", value, "courseMajor");
            return (Criteria) this;
        }

        public Criteria andCourseMajorNotLike(String value) {
            addCriterion("course_major not like", value, "courseMajor");
            return (Criteria) this;
        }

        public Criteria andCourseMajorIn(List<String> values) {
            addCriterion("course_major in", values, "courseMajor");
            return (Criteria) this;
        }

        public Criteria andCourseMajorNotIn(List<String> values) {
            addCriterion("course_major not in", values, "courseMajor");
            return (Criteria) this;
        }

        public Criteria andCourseMajorBetween(String value1, String value2) {
            addCriterion("course_major between", value1, value2, "courseMajor");
            return (Criteria) this;
        }

        public Criteria andCourseMajorNotBetween(String value1, String value2) {
            addCriterion("course_major not between", value1, value2, "courseMajor");
            return (Criteria) this;
        }

        public Criteria andCourseDepartmentIsNull() {
            addCriterion("course_department is null");
            return (Criteria) this;
        }

        public Criteria andCourseDepartmentIsNotNull() {
            addCriterion("course_department is not null");
            return (Criteria) this;
        }

        public Criteria andCourseDepartmentEqualTo(String value) {
            addCriterion("course_department =", value, "courseDepartment");
            return (Criteria) this;
        }

        public Criteria andCourseDepartmentNotEqualTo(String value) {
            addCriterion("course_department <>", value, "courseDepartment");
            return (Criteria) this;
        }

        public Criteria andCourseDepartmentGreaterThan(String value) {
            addCriterion("course_department >", value, "courseDepartment");
            return (Criteria) this;
        }

        public Criteria andCourseDepartmentGreaterThanOrEqualTo(String value) {
            addCriterion("course_department >=", value, "courseDepartment");
            return (Criteria) this;
        }

        public Criteria andCourseDepartmentLessThan(String value) {
            addCriterion("course_department <", value, "courseDepartment");
            return (Criteria) this;
        }

        public Criteria andCourseDepartmentLessThanOrEqualTo(String value) {
            addCriterion("course_department <=", value, "courseDepartment");
            return (Criteria) this;
        }

        public Criteria andCourseDepartmentLike(String value) {
            addCriterion("course_department like", value, "courseDepartment");
            return (Criteria) this;
        }

        public Criteria andCourseDepartmentNotLike(String value) {
            addCriterion("course_department not like", value, "courseDepartment");
            return (Criteria) this;
        }

        public Criteria andCourseDepartmentIn(List<String> values) {
            addCriterion("course_department in", values, "courseDepartment");
            return (Criteria) this;
        }

        public Criteria andCourseDepartmentNotIn(List<String> values) {
            addCriterion("course_department not in", values, "courseDepartment");
            return (Criteria) this;
        }

        public Criteria andCourseDepartmentBetween(String value1, String value2) {
            addCriterion("course_department between", value1, value2, "courseDepartment");
            return (Criteria) this;
        }

        public Criteria andCourseDepartmentNotBetween(String value1, String value2) {
            addCriterion("course_department not between", value1, value2, "courseDepartment");
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
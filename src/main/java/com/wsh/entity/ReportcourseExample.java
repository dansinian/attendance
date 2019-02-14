package com.wsh.entity;

import java.util.ArrayList;
import java.util.List;

public class ReportcourseExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ReportcourseExample() {
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

        public Criteria andReportCourseIsNull() {
            addCriterion("report_course is null");
            return (Criteria) this;
        }

        public Criteria andReportCourseIsNotNull() {
            addCriterion("report_course is not null");
            return (Criteria) this;
        }

        public Criteria andReportCourseEqualTo(String value) {
            addCriterion("report_course =", value, "reportCourse");
            return (Criteria) this;
        }

        public Criteria andReportCourseNotEqualTo(String value) {
            addCriterion("report_course <>", value, "reportCourse");
            return (Criteria) this;
        }

        public Criteria andReportCourseGreaterThan(String value) {
            addCriterion("report_course >", value, "reportCourse");
            return (Criteria) this;
        }

        public Criteria andReportCourseGreaterThanOrEqualTo(String value) {
            addCriterion("report_course >=", value, "reportCourse");
            return (Criteria) this;
        }

        public Criteria andReportCourseLessThan(String value) {
            addCriterion("report_course <", value, "reportCourse");
            return (Criteria) this;
        }

        public Criteria andReportCourseLessThanOrEqualTo(String value) {
            addCriterion("report_course <=", value, "reportCourse");
            return (Criteria) this;
        }

        public Criteria andReportCourseLike(String value) {
            addCriterion("report_course like", value, "reportCourse");
            return (Criteria) this;
        }

        public Criteria andReportCourseNotLike(String value) {
            addCriterion("report_course not like", value, "reportCourse");
            return (Criteria) this;
        }

        public Criteria andReportCourseIn(List<String> values) {
            addCriterion("report_course in", values, "reportCourse");
            return (Criteria) this;
        }

        public Criteria andReportCourseNotIn(List<String> values) {
            addCriterion("report_course not in", values, "reportCourse");
            return (Criteria) this;
        }

        public Criteria andReportCourseBetween(String value1, String value2) {
            addCriterion("report_course between", value1, value2, "reportCourse");
            return (Criteria) this;
        }

        public Criteria andReportCourseNotBetween(String value1, String value2) {
            addCriterion("report_course not between", value1, value2, "reportCourse");
            return (Criteria) this;
        }

        public Criteria andReportWeekIsNull() {
            addCriterion("report_week is null");
            return (Criteria) this;
        }

        public Criteria andReportWeekIsNotNull() {
            addCriterion("report_week is not null");
            return (Criteria) this;
        }

        public Criteria andReportWeekEqualTo(String value) {
            addCriterion("report_week =", value, "reportWeek");
            return (Criteria) this;
        }

        public Criteria andReportWeekNotEqualTo(String value) {
            addCriterion("report_week <>", value, "reportWeek");
            return (Criteria) this;
        }

        public Criteria andReportWeekGreaterThan(String value) {
            addCriterion("report_week >", value, "reportWeek");
            return (Criteria) this;
        }

        public Criteria andReportWeekGreaterThanOrEqualTo(String value) {
            addCriterion("report_week >=", value, "reportWeek");
            return (Criteria) this;
        }

        public Criteria andReportWeekLessThan(String value) {
            addCriterion("report_week <", value, "reportWeek");
            return (Criteria) this;
        }

        public Criteria andReportWeekLessThanOrEqualTo(String value) {
            addCriterion("report_week <=", value, "reportWeek");
            return (Criteria) this;
        }

        public Criteria andReportWeekLike(String value) {
            addCriterion("report_week like", value, "reportWeek");
            return (Criteria) this;
        }

        public Criteria andReportWeekNotLike(String value) {
            addCriterion("report_week not like", value, "reportWeek");
            return (Criteria) this;
        }

        public Criteria andReportWeekIn(List<String> values) {
            addCriterion("report_week in", values, "reportWeek");
            return (Criteria) this;
        }

        public Criteria andReportWeekNotIn(List<String> values) {
            addCriterion("report_week not in", values, "reportWeek");
            return (Criteria) this;
        }

        public Criteria andReportWeekBetween(String value1, String value2) {
            addCriterion("report_week between", value1, value2, "reportWeek");
            return (Criteria) this;
        }

        public Criteria andReportWeekNotBetween(String value1, String value2) {
            addCriterion("report_week not between", value1, value2, "reportWeek");
            return (Criteria) this;
        }

        public Criteria andReportTimeIsNull() {
            addCriterion("report_time is null");
            return (Criteria) this;
        }

        public Criteria andReportTimeIsNotNull() {
            addCriterion("report_time is not null");
            return (Criteria) this;
        }

        public Criteria andReportTimeEqualTo(String value) {
            addCriterion("report_time =", value, "reportTime");
            return (Criteria) this;
        }

        public Criteria andReportTimeNotEqualTo(String value) {
            addCriterion("report_time <>", value, "reportTime");
            return (Criteria) this;
        }

        public Criteria andReportTimeGreaterThan(String value) {
            addCriterion("report_time >", value, "reportTime");
            return (Criteria) this;
        }

        public Criteria andReportTimeGreaterThanOrEqualTo(String value) {
            addCriterion("report_time >=", value, "reportTime");
            return (Criteria) this;
        }

        public Criteria andReportTimeLessThan(String value) {
            addCriterion("report_time <", value, "reportTime");
            return (Criteria) this;
        }

        public Criteria andReportTimeLessThanOrEqualTo(String value) {
            addCriterion("report_time <=", value, "reportTime");
            return (Criteria) this;
        }

        public Criteria andReportTimeLike(String value) {
            addCriterion("report_time like", value, "reportTime");
            return (Criteria) this;
        }

        public Criteria andReportTimeNotLike(String value) {
            addCriterion("report_time not like", value, "reportTime");
            return (Criteria) this;
        }

        public Criteria andReportTimeIn(List<String> values) {
            addCriterion("report_time in", values, "reportTime");
            return (Criteria) this;
        }

        public Criteria andReportTimeNotIn(List<String> values) {
            addCriterion("report_time not in", values, "reportTime");
            return (Criteria) this;
        }

        public Criteria andReportTimeBetween(String value1, String value2) {
            addCriterion("report_time between", value1, value2, "reportTime");
            return (Criteria) this;
        }

        public Criteria andReportTimeNotBetween(String value1, String value2) {
            addCriterion("report_time not between", value1, value2, "reportTime");
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

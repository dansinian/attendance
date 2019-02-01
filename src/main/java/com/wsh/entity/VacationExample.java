package com.wsh.entity;

import java.util.ArrayList;
import java.util.List;

public class VacationExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public VacationExample() {
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

        public Criteria andLeaveIdIsNull() {
            addCriterion("leave_ID is null");
            return (Criteria) this;
        }

        public Criteria andLeaveIdIsNotNull() {
            addCriterion("leave_ID is not null");
            return (Criteria) this;
        }

        public Criteria andLeaveIdEqualTo(String value) {
            addCriterion("leave_ID =", value, "leaveId");
            return (Criteria) this;
        }

        public Criteria andLeaveIdNotEqualTo(String value) {
            addCriterion("leave_ID <>", value, "leaveId");
            return (Criteria) this;
        }

        public Criteria andLeaveIdGreaterThan(String value) {
            addCriterion("leave_ID >", value, "leaveId");
            return (Criteria) this;
        }

        public Criteria andLeaveIdGreaterThanOrEqualTo(String value) {
            addCriterion("leave_ID >=", value, "leaveId");
            return (Criteria) this;
        }

        public Criteria andLeaveIdLessThan(String value) {
            addCriterion("leave_ID <", value, "leaveId");
            return (Criteria) this;
        }

        public Criteria andLeaveIdLessThanOrEqualTo(String value) {
            addCriterion("leave_ID <=", value, "leaveId");
            return (Criteria) this;
        }

        public Criteria andLeaveIdLike(String value) {
            addCriterion("leave_ID like", value, "leaveId");
            return (Criteria) this;
        }

        public Criteria andLeaveIdNotLike(String value) {
            addCriterion("leave_ID not like", value, "leaveId");
            return (Criteria) this;
        }

        public Criteria andLeaveIdIn(List<String> values) {
            addCriterion("leave_ID in", values, "leaveId");
            return (Criteria) this;
        }

        public Criteria andLeaveIdNotIn(List<String> values) {
            addCriterion("leave_ID not in", values, "leaveId");
            return (Criteria) this;
        }

        public Criteria andLeaveIdBetween(String value1, String value2) {
            addCriterion("leave_ID between", value1, value2, "leaveId");
            return (Criteria) this;
        }

        public Criteria andLeaveIdNotBetween(String value1, String value2) {
            addCriterion("leave_ID not between", value1, value2, "leaveId");
            return (Criteria) this;
        }

        public Criteria andStuIdIsNull() {
            addCriterion("stu_ID is null");
            return (Criteria) this;
        }

        public Criteria andStuIdIsNotNull() {
            addCriterion("stu_ID is not null");
            return (Criteria) this;
        }

        public Criteria andStuIdEqualTo(String value) {
            addCriterion("stu_ID =", value, "stuId");
            return (Criteria) this;
        }

        public Criteria andStuIdNotEqualTo(String value) {
            addCriterion("stu_ID <>", value, "stuId");
            return (Criteria) this;
        }

        public Criteria andStuIdGreaterThan(String value) {
            addCriterion("stu_ID >", value, "stuId");
            return (Criteria) this;
        }

        public Criteria andStuIdGreaterThanOrEqualTo(String value) {
            addCriterion("stu_ID >=", value, "stuId");
            return (Criteria) this;
        }

        public Criteria andStuIdLessThan(String value) {
            addCriterion("stu_ID <", value, "stuId");
            return (Criteria) this;
        }

        public Criteria andStuIdLessThanOrEqualTo(String value) {
            addCriterion("stu_ID <=", value, "stuId");
            return (Criteria) this;
        }

        public Criteria andStuIdLike(String value) {
            addCriterion("stu_ID like", value, "stuId");
            return (Criteria) this;
        }

        public Criteria andStuIdNotLike(String value) {
            addCriterion("stu_ID not like", value, "stuId");
            return (Criteria) this;
        }

        public Criteria andStuIdIn(List<String> values) {
            addCriterion("stu_ID in", values, "stuId");
            return (Criteria) this;
        }

        public Criteria andStuIdNotIn(List<String> values) {
            addCriterion("stu_ID not in", values, "stuId");
            return (Criteria) this;
        }

        public Criteria andStuIdBetween(String value1, String value2) {
            addCriterion("stu_ID between", value1, value2, "stuId");
            return (Criteria) this;
        }

        public Criteria andStuIdNotBetween(String value1, String value2) {
            addCriterion("stu_ID not between", value1, value2, "stuId");
            return (Criteria) this;
        }

        public Criteria andStuNameIsNull() {
            addCriterion("stu_name is null");
            return (Criteria) this;
        }

        public Criteria andStuNameIsNotNull() {
            addCriterion("stu_name is not null");
            return (Criteria) this;
        }

        public Criteria andStuNameEqualTo(String value) {
            addCriterion("stu_name =", value, "stuName");
            return (Criteria) this;
        }

        public Criteria andStuNameNotEqualTo(String value) {
            addCriterion("stu_name <>", value, "stuName");
            return (Criteria) this;
        }

        public Criteria andStuNameGreaterThan(String value) {
            addCriterion("stu_name >", value, "stuName");
            return (Criteria) this;
        }

        public Criteria andStuNameGreaterThanOrEqualTo(String value) {
            addCriterion("stu_name >=", value, "stuName");
            return (Criteria) this;
        }

        public Criteria andStuNameLessThan(String value) {
            addCriterion("stu_name <", value, "stuName");
            return (Criteria) this;
        }

        public Criteria andStuNameLessThanOrEqualTo(String value) {
            addCriterion("stu_name <=", value, "stuName");
            return (Criteria) this;
        }

        public Criteria andStuNameLike(String value) {
            addCriterion("stu_name like", value, "stuName");
            return (Criteria) this;
        }

        public Criteria andStuNameNotLike(String value) {
            addCriterion("stu_name not like", value, "stuName");
            return (Criteria) this;
        }

        public Criteria andStuNameIn(List<String> values) {
            addCriterion("stu_name in", values, "stuName");
            return (Criteria) this;
        }

        public Criteria andStuNameNotIn(List<String> values) {
            addCriterion("stu_name not in", values, "stuName");
            return (Criteria) this;
        }

        public Criteria andStuNameBetween(String value1, String value2) {
            addCriterion("stu_name between", value1, value2, "stuName");
            return (Criteria) this;
        }

        public Criteria andStuNameNotBetween(String value1, String value2) {
            addCriterion("stu_name not between", value1, value2, "stuName");
            return (Criteria) this;
        }

        public Criteria andApplicationTimeIsNull() {
            addCriterion("application_time is null");
            return (Criteria) this;
        }

        public Criteria andApplicationTimeIsNotNull() {
            addCriterion("application_time is not null");
            return (Criteria) this;
        }

        public Criteria andApplicationTimeEqualTo(String value) {
            addCriterion("application_time =", value, "applicationTime");
            return (Criteria) this;
        }

        public Criteria andApplicationTimeNotEqualTo(String value) {
            addCriterion("application_time <>", value, "applicationTime");
            return (Criteria) this;
        }

        public Criteria andApplicationTimeGreaterThan(String value) {
            addCriterion("application_time >", value, "applicationTime");
            return (Criteria) this;
        }

        public Criteria andApplicationTimeGreaterThanOrEqualTo(String value) {
            addCriterion("application_time >=", value, "applicationTime");
            return (Criteria) this;
        }

        public Criteria andApplicationTimeLessThan(String value) {
            addCriterion("application_time <", value, "applicationTime");
            return (Criteria) this;
        }

        public Criteria andApplicationTimeLessThanOrEqualTo(String value) {
            addCriterion("application_time <=", value, "applicationTime");
            return (Criteria) this;
        }

        public Criteria andApplicationTimeLike(String value) {
            addCriterion("application_time like", value, "applicationTime");
            return (Criteria) this;
        }

        public Criteria andApplicationTimeNotLike(String value) {
            addCriterion("application_time not like", value, "applicationTime");
            return (Criteria) this;
        }

        public Criteria andApplicationTimeIn(List<String> values) {
            addCriterion("application_time in", values, "applicationTime");
            return (Criteria) this;
        }

        public Criteria andApplicationTimeNotIn(List<String> values) {
            addCriterion("application_time not in", values, "applicationTime");
            return (Criteria) this;
        }

        public Criteria andApplicationTimeBetween(String value1, String value2) {
            addCriterion("application_time between", value1, value2, "applicationTime");
            return (Criteria) this;
        }

        public Criteria andApplicationTimeNotBetween(String value1, String value2) {
            addCriterion("application_time not between", value1, value2, "applicationTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeIsNull() {
            addCriterion("start_time is null");
            return (Criteria) this;
        }

        public Criteria andStartTimeIsNotNull() {
            addCriterion("start_time is not null");
            return (Criteria) this;
        }

        public Criteria andStartTimeEqualTo(String value) {
            addCriterion("start_time =", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeNotEqualTo(String value) {
            addCriterion("start_time <>", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeGreaterThan(String value) {
            addCriterion("start_time >", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeGreaterThanOrEqualTo(String value) {
            addCriterion("start_time >=", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeLessThan(String value) {
            addCriterion("start_time <", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeLessThanOrEqualTo(String value) {
            addCriterion("start_time <=", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeLike(String value) {
            addCriterion("start_time like", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeNotLike(String value) {
            addCriterion("start_time not like", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeIn(List<String> values) {
            addCriterion("start_time in", values, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeNotIn(List<String> values) {
            addCriterion("start_time not in", values, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeBetween(String value1, String value2) {
            addCriterion("start_time between", value1, value2, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeNotBetween(String value1, String value2) {
            addCriterion("start_time not between", value1, value2, "startTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeIsNull() {
            addCriterion("end_time is null");
            return (Criteria) this;
        }

        public Criteria andEndTimeIsNotNull() {
            addCriterion("end_time is not null");
            return (Criteria) this;
        }

        public Criteria andEndTimeEqualTo(String value) {
            addCriterion("end_time =", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeNotEqualTo(String value) {
            addCriterion("end_time <>", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeGreaterThan(String value) {
            addCriterion("end_time >", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeGreaterThanOrEqualTo(String value) {
            addCriterion("end_time >=", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeLessThan(String value) {
            addCriterion("end_time <", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeLessThanOrEqualTo(String value) {
            addCriterion("end_time <=", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeLike(String value) {
            addCriterion("end_time like", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeNotLike(String value) {
            addCriterion("end_time not like", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeIn(List<String> values) {
            addCriterion("end_time in", values, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeNotIn(List<String> values) {
            addCriterion("end_time not in", values, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeBetween(String value1, String value2) {
            addCriterion("end_time between", value1, value2, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeNotBetween(String value1, String value2) {
            addCriterion("end_time not between", value1, value2, "endTime");
            return (Criteria) this;
        }

        public Criteria andLeaveDayIsNull() {
            addCriterion("leave_day is null");
            return (Criteria) this;
        }

        public Criteria andLeaveDayIsNotNull() {
            addCriterion("leave_day is not null");
            return (Criteria) this;
        }

        public Criteria andLeaveDayEqualTo(String value) {
            addCriterion("leave_day =", value, "leaveDay");
            return (Criteria) this;
        }

        public Criteria andLeaveDayNotEqualTo(String value) {
            addCriterion("leave_day <>", value, "leaveDay");
            return (Criteria) this;
        }

        public Criteria andLeaveDayGreaterThan(String value) {
            addCriterion("leave_day >", value, "leaveDay");
            return (Criteria) this;
        }

        public Criteria andLeaveDayGreaterThanOrEqualTo(String value) {
            addCriterion("leave_day >=", value, "leaveDay");
            return (Criteria) this;
        }

        public Criteria andLeaveDayLessThan(String value) {
            addCriterion("leave_day <", value, "leaveDay");
            return (Criteria) this;
        }

        public Criteria andLeaveDayLessThanOrEqualTo(String value) {
            addCriterion("leave_day <=", value, "leaveDay");
            return (Criteria) this;
        }

        public Criteria andLeaveDayLike(String value) {
            addCriterion("leave_day like", value, "leaveDay");
            return (Criteria) this;
        }

        public Criteria andLeaveDayNotLike(String value) {
            addCriterion("leave_day not like", value, "leaveDay");
            return (Criteria) this;
        }

        public Criteria andLeaveDayIn(List<String> values) {
            addCriterion("leave_day in", values, "leaveDay");
            return (Criteria) this;
        }

        public Criteria andLeaveDayNotIn(List<String> values) {
            addCriterion("leave_day not in", values, "leaveDay");
            return (Criteria) this;
        }

        public Criteria andLeaveDayBetween(String value1, String value2) {
            addCriterion("leave_day between", value1, value2, "leaveDay");
            return (Criteria) this;
        }

        public Criteria andLeaveDayNotBetween(String value1, String value2) {
            addCriterion("leave_day not between", value1, value2, "leaveDay");
            return (Criteria) this;
        }

        public Criteria andApprovalTeaIsNull() {
            addCriterion("approval_tea is null");
            return (Criteria) this;
        }

        public Criteria andApprovalTeaIsNotNull() {
            addCriterion("approval_tea is not null");
            return (Criteria) this;
        }

        public Criteria andApprovalTeaEqualTo(String value) {
            addCriterion("approval_tea =", value, "approvalTea");
            return (Criteria) this;
        }

        public Criteria andApprovalTeaNotEqualTo(String value) {
            addCriterion("approval_tea <>", value, "approvalTea");
            return (Criteria) this;
        }

        public Criteria andApprovalTeaGreaterThan(String value) {
            addCriterion("approval_tea >", value, "approvalTea");
            return (Criteria) this;
        }

        public Criteria andApprovalTeaGreaterThanOrEqualTo(String value) {
            addCriterion("approval_tea >=", value, "approvalTea");
            return (Criteria) this;
        }

        public Criteria andApprovalTeaLessThan(String value) {
            addCriterion("approval_tea <", value, "approvalTea");
            return (Criteria) this;
        }

        public Criteria andApprovalTeaLessThanOrEqualTo(String value) {
            addCriterion("approval_tea <=", value, "approvalTea");
            return (Criteria) this;
        }

        public Criteria andApprovalTeaLike(String value) {
            addCriterion("approval_tea like", value, "approvalTea");
            return (Criteria) this;
        }

        public Criteria andApprovalTeaNotLike(String value) {
            addCriterion("approval_tea not like", value, "approvalTea");
            return (Criteria) this;
        }

        public Criteria andApprovalTeaIn(List<String> values) {
            addCriterion("approval_tea in", values, "approvalTea");
            return (Criteria) this;
        }

        public Criteria andApprovalTeaNotIn(List<String> values) {
            addCriterion("approval_tea not in", values, "approvalTea");
            return (Criteria) this;
        }

        public Criteria andApprovalTeaBetween(String value1, String value2) {
            addCriterion("approval_tea between", value1, value2, "approvalTea");
            return (Criteria) this;
        }

        public Criteria andApprovalTeaNotBetween(String value1, String value2) {
            addCriterion("approval_tea not between", value1, value2, "approvalTea");
            return (Criteria) this;
        }

        public Criteria andStatusIsNull() {
            addCriterion("status is null");
            return (Criteria) this;
        }

        public Criteria andStatusIsNotNull() {
            addCriterion("status is not null");
            return (Criteria) this;
        }

        public Criteria andStatusEqualTo(String value) {
            addCriterion("status =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(String value) {
            addCriterion("status <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(String value) {
            addCriterion("status >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(String value) {
            addCriterion("status >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(String value) {
            addCriterion("status <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(String value) {
            addCriterion("status <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLike(String value) {
            addCriterion("status like", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotLike(String value) {
            addCriterion("status not like", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<String> values) {
            addCriterion("status in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<String> values) {
            addCriterion("status not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(String value1, String value2) {
            addCriterion("status between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(String value1, String value2) {
            addCriterion("status not between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andLeavecourseTeaIsNull() {
            addCriterion("leavecourse_tea is null");
            return (Criteria) this;
        }

        public Criteria andLeavecourseTeaIsNotNull() {
            addCriterion("leavecourse_tea is not null");
            return (Criteria) this;
        }

        public Criteria andLeavecourseTeaEqualTo(String value) {
            addCriterion("leavecourse_tea =", value, "leavecourseTea");
            return (Criteria) this;
        }

        public Criteria andLeavecourseTeaNotEqualTo(String value) {
            addCriterion("leavecourse_tea <>", value, "leavecourseTea");
            return (Criteria) this;
        }

        public Criteria andLeavecourseTeaGreaterThan(String value) {
            addCriterion("leavecourse_tea >", value, "leavecourseTea");
            return (Criteria) this;
        }

        public Criteria andLeavecourseTeaGreaterThanOrEqualTo(String value) {
            addCriterion("leavecourse_tea >=", value, "leavecourseTea");
            return (Criteria) this;
        }

        public Criteria andLeavecourseTeaLessThan(String value) {
            addCriterion("leavecourse_tea <", value, "leavecourseTea");
            return (Criteria) this;
        }

        public Criteria andLeavecourseTeaLessThanOrEqualTo(String value) {
            addCriterion("leavecourse_tea <=", value, "leavecourseTea");
            return (Criteria) this;
        }

        public Criteria andLeavecourseTeaLike(String value) {
            addCriterion("leavecourse_tea like", value, "leavecourseTea");
            return (Criteria) this;
        }

        public Criteria andLeavecourseTeaNotLike(String value) {
            addCriterion("leavecourse_tea not like", value, "leavecourseTea");
            return (Criteria) this;
        }

        public Criteria andLeavecourseTeaIn(List<String> values) {
            addCriterion("leavecourse_tea in", values, "leavecourseTea");
            return (Criteria) this;
        }

        public Criteria andLeavecourseTeaNotIn(List<String> values) {
            addCriterion("leavecourse_tea not in", values, "leavecourseTea");
            return (Criteria) this;
        }

        public Criteria andLeavecourseTeaBetween(String value1, String value2) {
            addCriterion("leavecourse_tea between", value1, value2, "leavecourseTea");
            return (Criteria) this;
        }

        public Criteria andLeavecourseTeaNotBetween(String value1, String value2) {
            addCriterion("leavecourse_tea not between", value1, value2, "leavecourseTea");
            return (Criteria) this;
        }

        public Criteria andLeaveReasonIsNull() {
            addCriterion("leave_reason is null");
            return (Criteria) this;
        }

        public Criteria andLeaveReasonIsNotNull() {
            addCriterion("leave_reason is not null");
            return (Criteria) this;
        }

        public Criteria andLeaveReasonEqualTo(String value) {
            addCriterion("leave_reason =", value, "leaveReason");
            return (Criteria) this;
        }

        public Criteria andLeaveReasonNotEqualTo(String value) {
            addCriterion("leave_reason <>", value, "leaveReason");
            return (Criteria) this;
        }

        public Criteria andLeaveReasonGreaterThan(String value) {
            addCriterion("leave_reason >", value, "leaveReason");
            return (Criteria) this;
        }

        public Criteria andLeaveReasonGreaterThanOrEqualTo(String value) {
            addCriterion("leave_reason >=", value, "leaveReason");
            return (Criteria) this;
        }

        public Criteria andLeaveReasonLessThan(String value) {
            addCriterion("leave_reason <", value, "leaveReason");
            return (Criteria) this;
        }

        public Criteria andLeaveReasonLessThanOrEqualTo(String value) {
            addCriterion("leave_reason <=", value, "leaveReason");
            return (Criteria) this;
        }

        public Criteria andLeaveReasonLike(String value) {
            addCriterion("leave_reason like", value, "leaveReason");
            return (Criteria) this;
        }

        public Criteria andLeaveReasonNotLike(String value) {
            addCriterion("leave_reason not like", value, "leaveReason");
            return (Criteria) this;
        }

        public Criteria andLeaveReasonIn(List<String> values) {
            addCriterion("leave_reason in", values, "leaveReason");
            return (Criteria) this;
        }

        public Criteria andLeaveReasonNotIn(List<String> values) {
            addCriterion("leave_reason not in", values, "leaveReason");
            return (Criteria) this;
        }

        public Criteria andLeaveReasonBetween(String value1, String value2) {
            addCriterion("leave_reason between", value1, value2, "leaveReason");
            return (Criteria) this;
        }

        public Criteria andLeaveReasonNotBetween(String value1, String value2) {
            addCriterion("leave_reason not between", value1, value2, "leaveReason");
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
package com.wsh.entity;

import java.util.ArrayList;
import java.util.List;

public class TeacherExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TeacherExample() {
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

        public Criteria andTeaIdIsNull() {
            addCriterion("tea_ID is null");
            return (Criteria) this;
        }

        public Criteria andTeaIdIsNotNull() {
            addCriterion("tea_ID is not null");
            return (Criteria) this;
        }

        public Criteria andTeaIdEqualTo(String value) {
            addCriterion("tea_ID =", value, "teaId");
            return (Criteria) this;
        }

        public Criteria andTeaIdNotEqualTo(String value) {
            addCriterion("tea_ID <>", value, "teaId");
            return (Criteria) this;
        }

        public Criteria andTeaIdGreaterThan(String value) {
            addCriterion("tea_ID >", value, "teaId");
            return (Criteria) this;
        }

        public Criteria andTeaIdGreaterThanOrEqualTo(String value) {
            addCriterion("tea_ID >=", value, "teaId");
            return (Criteria) this;
        }

        public Criteria andTeaIdLessThan(String value) {
            addCriterion("tea_ID <", value, "teaId");
            return (Criteria) this;
        }

        public Criteria andTeaIdLessThanOrEqualTo(String value) {
            addCriterion("tea_ID <=", value, "teaId");
            return (Criteria) this;
        }

        public Criteria andTeaIdLike(String value) {
            addCriterion("tea_ID like", value, "teaId");
            return (Criteria) this;
        }

        public Criteria andTeaIdNotLike(String value) {
            addCriterion("tea_ID not like", value, "teaId");
            return (Criteria) this;
        }

        public Criteria andTeaIdIn(List<String> values) {
            addCriterion("tea_ID in", values, "teaId");
            return (Criteria) this;
        }

        public Criteria andTeaIdNotIn(List<String> values) {
            addCriterion("tea_ID not in", values, "teaId");
            return (Criteria) this;
        }

        public Criteria andTeaIdBetween(String value1, String value2) {
            addCriterion("tea_ID between", value1, value2, "teaId");
            return (Criteria) this;
        }

        public Criteria andTeaIdNotBetween(String value1, String value2) {
            addCriterion("tea_ID not between", value1, value2, "teaId");
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

        public Criteria andTeaGenderIsNull() {
            addCriterion("tea_gender is null");
            return (Criteria) this;
        }

        public Criteria andTeaGenderIsNotNull() {
            addCriterion("tea_gender is not null");
            return (Criteria) this;
        }

        public Criteria andTeaGenderEqualTo(String value) {
            addCriterion("tea_gender =", value, "teaGender");
            return (Criteria) this;
        }

        public Criteria andTeaGenderNotEqualTo(String value) {
            addCriterion("tea_gender <>", value, "teaGender");
            return (Criteria) this;
        }

        public Criteria andTeaGenderGreaterThan(String value) {
            addCriterion("tea_gender >", value, "teaGender");
            return (Criteria) this;
        }

        public Criteria andTeaGenderGreaterThanOrEqualTo(String value) {
            addCriterion("tea_gender >=", value, "teaGender");
            return (Criteria) this;
        }

        public Criteria andTeaGenderLessThan(String value) {
            addCriterion("tea_gender <", value, "teaGender");
            return (Criteria) this;
        }

        public Criteria andTeaGenderLessThanOrEqualTo(String value) {
            addCriterion("tea_gender <=", value, "teaGender");
            return (Criteria) this;
        }

        public Criteria andTeaGenderLike(String value) {
            addCriterion("tea_gender like", value, "teaGender");
            return (Criteria) this;
        }

        public Criteria andTeaGenderNotLike(String value) {
            addCriterion("tea_gender not like", value, "teaGender");
            return (Criteria) this;
        }

        public Criteria andTeaGenderIn(List<String> values) {
            addCriterion("tea_gender in", values, "teaGender");
            return (Criteria) this;
        }

        public Criteria andTeaGenderNotIn(List<String> values) {
            addCriterion("tea_gender not in", values, "teaGender");
            return (Criteria) this;
        }

        public Criteria andTeaGenderBetween(String value1, String value2) {
            addCriterion("tea_gender between", value1, value2, "teaGender");
            return (Criteria) this;
        }

        public Criteria andTeaGenderNotBetween(String value1, String value2) {
            addCriterion("tea_gender not between", value1, value2, "teaGender");
            return (Criteria) this;
        }

        public Criteria andTeaDepartmentIsNull() {
            addCriterion("tea_department is null");
            return (Criteria) this;
        }

        public Criteria andTeaDepartmentIsNotNull() {
            addCriterion("tea_department is not null");
            return (Criteria) this;
        }

        public Criteria andTeaDepartmentEqualTo(String value) {
            addCriterion("tea_department =", value, "teaDepartment");
            return (Criteria) this;
        }

        public Criteria andTeaDepartmentNotEqualTo(String value) {
            addCriterion("tea_department <>", value, "teaDepartment");
            return (Criteria) this;
        }

        public Criteria andTeaDepartmentGreaterThan(String value) {
            addCriterion("tea_department >", value, "teaDepartment");
            return (Criteria) this;
        }

        public Criteria andTeaDepartmentGreaterThanOrEqualTo(String value) {
            addCriterion("tea_department >=", value, "teaDepartment");
            return (Criteria) this;
        }

        public Criteria andTeaDepartmentLessThan(String value) {
            addCriterion("tea_department <", value, "teaDepartment");
            return (Criteria) this;
        }

        public Criteria andTeaDepartmentLessThanOrEqualTo(String value) {
            addCriterion("tea_department <=", value, "teaDepartment");
            return (Criteria) this;
        }

        public Criteria andTeaDepartmentLike(String value) {
            addCriterion("tea_department like", value, "teaDepartment");
            return (Criteria) this;
        }

        public Criteria andTeaDepartmentNotLike(String value) {
            addCriterion("tea_department not like", value, "teaDepartment");
            return (Criteria) this;
        }

        public Criteria andTeaDepartmentIn(List<String> values) {
            addCriterion("tea_department in", values, "teaDepartment");
            return (Criteria) this;
        }

        public Criteria andTeaDepartmentNotIn(List<String> values) {
            addCriterion("tea_department not in", values, "teaDepartment");
            return (Criteria) this;
        }

        public Criteria andTeaDepartmentBetween(String value1, String value2) {
            addCriterion("tea_department between", value1, value2, "teaDepartment");
            return (Criteria) this;
        }

        public Criteria andTeaDepartmentNotBetween(String value1, String value2) {
            addCriterion("tea_department not between", value1, value2, "teaDepartment");
            return (Criteria) this;
        }

        public Criteria andTeaPhoneIsNull() {
            addCriterion("tea_phone is null");
            return (Criteria) this;
        }

        public Criteria andTeaPhoneIsNotNull() {
            addCriterion("tea_phone is not null");
            return (Criteria) this;
        }

        public Criteria andTeaPhoneEqualTo(String value) {
            addCriterion("tea_phone =", value, "teaPhone");
            return (Criteria) this;
        }

        public Criteria andTeaPhoneNotEqualTo(String value) {
            addCriterion("tea_phone <>", value, "teaPhone");
            return (Criteria) this;
        }

        public Criteria andTeaPhoneGreaterThan(String value) {
            addCriterion("tea_phone >", value, "teaPhone");
            return (Criteria) this;
        }

        public Criteria andTeaPhoneGreaterThanOrEqualTo(String value) {
            addCriterion("tea_phone >=", value, "teaPhone");
            return (Criteria) this;
        }

        public Criteria andTeaPhoneLessThan(String value) {
            addCriterion("tea_phone <", value, "teaPhone");
            return (Criteria) this;
        }

        public Criteria andTeaPhoneLessThanOrEqualTo(String value) {
            addCriterion("tea_phone <=", value, "teaPhone");
            return (Criteria) this;
        }

        public Criteria andTeaPhoneLike(String value) {
            addCriterion("tea_phone like", value, "teaPhone");
            return (Criteria) this;
        }

        public Criteria andTeaPhoneNotLike(String value) {
            addCriterion("tea_phone not like", value, "teaPhone");
            return (Criteria) this;
        }

        public Criteria andTeaPhoneIn(List<String> values) {
            addCriterion("tea_phone in", values, "teaPhone");
            return (Criteria) this;
        }

        public Criteria andTeaPhoneNotIn(List<String> values) {
            addCriterion("tea_phone not in", values, "teaPhone");
            return (Criteria) this;
        }

        public Criteria andTeaPhoneBetween(String value1, String value2) {
            addCriterion("tea_phone between", value1, value2, "teaPhone");
            return (Criteria) this;
        }

        public Criteria andTeaPhoneNotBetween(String value1, String value2) {
            addCriterion("tea_phone not between", value1, value2, "teaPhone");
            return (Criteria) this;
        }

        public Criteria andTeaFlagIsNull() {
            addCriterion("tea_flag is null");
            return (Criteria) this;
        }

        public Criteria andTeaFlagIsNotNull() {
            addCriterion("tea_flag is not null");
            return (Criteria) this;
        }

        public Criteria andTeaFlagEqualTo(String value) {
            addCriterion("tea_flag =", value, "teaFlag");
            return (Criteria) this;
        }

        public Criteria andTeaFlagNotEqualTo(String value) {
            addCriterion("tea_flag <>", value, "teaFlag");
            return (Criteria) this;
        }

        public Criteria andTeaFlagGreaterThan(String value) {
            addCriterion("tea_flag >", value, "teaFlag");
            return (Criteria) this;
        }

        public Criteria andTeaFlagGreaterThanOrEqualTo(String value) {
            addCriterion("tea_flag >=", value, "teaFlag");
            return (Criteria) this;
        }

        public Criteria andTeaFlagLessThan(String value) {
            addCriterion("tea_flag <", value, "teaFlag");
            return (Criteria) this;
        }

        public Criteria andTeaFlagLessThanOrEqualTo(String value) {
            addCriterion("tea_flag <=", value, "teaFlag");
            return (Criteria) this;
        }

        public Criteria andTeaFlagLike(String value) {
            addCriterion("tea_flag like", value, "teaFlag");
            return (Criteria) this;
        }

        public Criteria andTeaFlagNotLike(String value) {
            addCriterion("tea_flag not like", value, "teaFlag");
            return (Criteria) this;
        }

        public Criteria andTeaFlagIn(List<String> values) {
            addCriterion("tea_flag in", values, "teaFlag");
            return (Criteria) this;
        }

        public Criteria andTeaFlagNotIn(List<String> values) {
            addCriterion("tea_flag not in", values, "teaFlag");
            return (Criteria) this;
        }

        public Criteria andTeaFlagBetween(String value1, String value2) {
            addCriterion("tea_flag between", value1, value2, "teaFlag");
            return (Criteria) this;
        }

        public Criteria andTeaFlagNotBetween(String value1, String value2) {
            addCriterion("tea_flag not between", value1, value2, "teaFlag");
            return (Criteria) this;
        }

        public Criteria andTeaPasswordIsNull() {
            addCriterion("tea_password is null");
            return (Criteria) this;
        }

        public Criteria andTeaPasswordIsNotNull() {
            addCriterion("tea_password is not null");
            return (Criteria) this;
        }

        public Criteria andTeaPasswordEqualTo(String value) {
            addCriterion("tea_password =", value, "teaPassword");
            return (Criteria) this;
        }

        public Criteria andTeaPasswordNotEqualTo(String value) {
            addCriterion("tea_password <>", value, "teaPassword");
            return (Criteria) this;
        }

        public Criteria andTeaPasswordGreaterThan(String value) {
            addCriterion("tea_password >", value, "teaPassword");
            return (Criteria) this;
        }

        public Criteria andTeaPasswordGreaterThanOrEqualTo(String value) {
            addCriterion("tea_password >=", value, "teaPassword");
            return (Criteria) this;
        }

        public Criteria andTeaPasswordLessThan(String value) {
            addCriterion("tea_password <", value, "teaPassword");
            return (Criteria) this;
        }

        public Criteria andTeaPasswordLessThanOrEqualTo(String value) {
            addCriterion("tea_password <=", value, "teaPassword");
            return (Criteria) this;
        }

        public Criteria andTeaPasswordLike(String value) {
            addCriterion("tea_password like", value, "teaPassword");
            return (Criteria) this;
        }

        public Criteria andTeaPasswordNotLike(String value) {
            addCriterion("tea_password not like", value, "teaPassword");
            return (Criteria) this;
        }

        public Criteria andTeaPasswordIn(List<String> values) {
            addCriterion("tea_password in", values, "teaPassword");
            return (Criteria) this;
        }

        public Criteria andTeaPasswordNotIn(List<String> values) {
            addCriterion("tea_password not in", values, "teaPassword");
            return (Criteria) this;
        }

        public Criteria andTeaPasswordBetween(String value1, String value2) {
            addCriterion("tea_password between", value1, value2, "teaPassword");
            return (Criteria) this;
        }

        public Criteria andTeaPasswordNotBetween(String value1, String value2) {
            addCriterion("tea_password not between", value1, value2, "teaPassword");
            return (Criteria) this;
        }

        public Criteria andTeaClassIsNull() {
            addCriterion("tea_class is null");
            return (Criteria) this;
        }

        public Criteria andTeaClassIsNotNull() {
            addCriterion("tea_class is not null");
            return (Criteria) this;
        }

        public Criteria andTeaClassEqualTo(String value) {
            addCriterion("tea_class =", value, "teaClass");
            return (Criteria) this;
        }

        public Criteria andTeaClassNotEqualTo(String value) {
            addCriterion("tea_class <>", value, "teaClass");
            return (Criteria) this;
        }

        public Criteria andTeaClassGreaterThan(String value) {
            addCriterion("tea_class >", value, "teaClass");
            return (Criteria) this;
        }

        public Criteria andTeaClassGreaterThanOrEqualTo(String value) {
            addCriterion("tea_class >=", value, "teaClass");
            return (Criteria) this;
        }

        public Criteria andTeaClassLessThan(String value) {
            addCriterion("tea_class <", value, "teaClass");
            return (Criteria) this;
        }

        public Criteria andTeaClassLessThanOrEqualTo(String value) {
            addCriterion("tea_class <=", value, "teaClass");
            return (Criteria) this;
        }

        public Criteria andTeaClassLike(String value) {
            addCriterion("tea_class like", value, "teaClass");
            return (Criteria) this;
        }

        public Criteria andTeaClassNotLike(String value) {
            addCriterion("tea_class not like", value, "teaClass");
            return (Criteria) this;
        }

        public Criteria andTeaClassIn(List<String> values) {
            addCriterion("tea_class in", values, "teaClass");
            return (Criteria) this;
        }

        public Criteria andTeaClassNotIn(List<String> values) {
            addCriterion("tea_class not in", values, "teaClass");
            return (Criteria) this;
        }

        public Criteria andTeaClassBetween(String value1, String value2) {
            addCriterion("tea_class between", value1, value2, "teaClass");
            return (Criteria) this;
        }

        public Criteria andTeaClassNotBetween(String value1, String value2) {
            addCriterion("tea_class not between", value1, value2, "teaClass");
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
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
            addCriterion("tea_id is null");
            return (Criteria) this;
        }

        public Criteria andTeaIdIsNotNull() {
            addCriterion("tea_id is not null");
            return (Criteria) this;
        }

        public Criteria andTeaIdEqualTo(String value) {
            addCriterion("tea_id =", value, "teaId");
            return (Criteria) this;
        }

        public Criteria andTeaIdNotEqualTo(String value) {
            addCriterion("tea_id <>", value, "teaId");
            return (Criteria) this;
        }

        public Criteria andTeaIdGreaterThan(String value) {
            addCriterion("tea_id >", value, "teaId");
            return (Criteria) this;
        }

        public Criteria andTeaIdGreaterThanOrEqualTo(String value) {
            addCriterion("tea_id >=", value, "teaId");
            return (Criteria) this;
        }

        public Criteria andTeaIdLessThan(String value) {
            addCriterion("tea_id <", value, "teaId");
            return (Criteria) this;
        }

        public Criteria andTeaIdLessThanOrEqualTo(String value) {
            addCriterion("tea_id <=", value, "teaId");
            return (Criteria) this;
        }

        public Criteria andTeaIdLike(String value) {
            addCriterion("tea_id like", value, "teaId");
            return (Criteria) this;
        }

        public Criteria andTeaIdNotLike(String value) {
            addCriterion("tea_id not like", value, "teaId");
            return (Criteria) this;
        }

        public Criteria andTeaIdIn(List<String> values) {
            addCriterion("tea_id in", values, "teaId");
            return (Criteria) this;
        }

        public Criteria andTeaIdNotIn(List<String> values) {
            addCriterion("tea_id not in", values, "teaId");
            return (Criteria) this;
        }

        public Criteria andTeaIdBetween(String value1, String value2) {
            addCriterion("tea_id between", value1, value2, "teaId");
            return (Criteria) this;
        }

        public Criteria andTeaIdNotBetween(String value1, String value2) {
            addCriterion("tea_id not between", value1, value2, "teaId");
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

        public Criteria andTeaPassIsNull() {
            addCriterion("tea_pass is null");
            return (Criteria) this;
        }

        public Criteria andTeaPassIsNotNull() {
            addCriterion("tea_pass is not null");
            return (Criteria) this;
        }

        public Criteria andTeaPassEqualTo(String value) {
            addCriterion("tea_pass =", value, "teaPass");
            return (Criteria) this;
        }

        public Criteria andTeaPassNotEqualTo(String value) {
            addCriterion("tea_pass <>", value, "teaPass");
            return (Criteria) this;
        }

        public Criteria andTeaPassGreaterThan(String value) {
            addCriterion("tea_pass >", value, "teaPass");
            return (Criteria) this;
        }

        public Criteria andTeaPassGreaterThanOrEqualTo(String value) {
            addCriterion("tea_pass >=", value, "teaPass");
            return (Criteria) this;
        }

        public Criteria andTeaPassLessThan(String value) {
            addCriterion("tea_pass <", value, "teaPass");
            return (Criteria) this;
        }

        public Criteria andTeaPassLessThanOrEqualTo(String value) {
            addCriterion("tea_pass <=", value, "teaPass");
            return (Criteria) this;
        }

        public Criteria andTeaPassLike(String value) {
            addCriterion("tea_pass like", value, "teaPass");
            return (Criteria) this;
        }

        public Criteria andTeaPassNotLike(String value) {
            addCriterion("tea_pass not like", value, "teaPass");
            return (Criteria) this;
        }

        public Criteria andTeaPassIn(List<String> values) {
            addCriterion("tea_pass in", values, "teaPass");
            return (Criteria) this;
        }

        public Criteria andTeaPassNotIn(List<String> values) {
            addCriterion("tea_pass not in", values, "teaPass");
            return (Criteria) this;
        }

        public Criteria andTeaPassBetween(String value1, String value2) {
            addCriterion("tea_pass between", value1, value2, "teaPass");
            return (Criteria) this;
        }

        public Criteria andTeaPassNotBetween(String value1, String value2) {
            addCriterion("tea_pass not between", value1, value2, "teaPass");
            return (Criteria) this;
        }

        public Criteria andTeaCourseIsNull() {
            addCriterion("tea_course is null");
            return (Criteria) this;
        }

        public Criteria andTeaCourseIsNotNull() {
            addCriterion("tea_course is not null");
            return (Criteria) this;
        }

        public Criteria andTeaCourseEqualTo(String value) {
            addCriterion("tea_course =", value, "teaCourse");
            return (Criteria) this;
        }

        public Criteria andTeaCourseNotEqualTo(String value) {
            addCriterion("tea_course <>", value, "teaCourse");
            return (Criteria) this;
        }

        public Criteria andTeaCourseGreaterThan(String value) {
            addCriterion("tea_course >", value, "teaCourse");
            return (Criteria) this;
        }

        public Criteria andTeaCourseGreaterThanOrEqualTo(String value) {
            addCriterion("tea_course >=", value, "teaCourse");
            return (Criteria) this;
        }

        public Criteria andTeaCourseLessThan(String value) {
            addCriterion("tea_course <", value, "teaCourse");
            return (Criteria) this;
        }

        public Criteria andTeaCourseLessThanOrEqualTo(String value) {
            addCriterion("tea_course <=", value, "teaCourse");
            return (Criteria) this;
        }

        public Criteria andTeaCourseLike(String value) {
            addCriterion("tea_course like", value, "teaCourse");
            return (Criteria) this;
        }

        public Criteria andTeaCourseNotLike(String value) {
            addCriterion("tea_course not like", value, "teaCourse");
            return (Criteria) this;
        }

        public Criteria andTeaCourseIn(List<String> values) {
            addCriterion("tea_course in", values, "teaCourse");
            return (Criteria) this;
        }

        public Criteria andTeaCourseNotIn(List<String> values) {
            addCriterion("tea_course not in", values, "teaCourse");
            return (Criteria) this;
        }

        public Criteria andTeaCourseBetween(String value1, String value2) {
            addCriterion("tea_course between", value1, value2, "teaCourse");
            return (Criteria) this;
        }

        public Criteria andTeaCourseNotBetween(String value1, String value2) {
            addCriterion("tea_course not between", value1, value2, "teaCourse");
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

        public Criteria andTeaHeadImgIsNull() {
            addCriterion("tea_head_img is null");
            return (Criteria) this;
        }

        public Criteria andTeaHeadImgIsNotNull() {
            addCriterion("tea_head_img is not null");
            return (Criteria) this;
        }

        public Criteria andTeaHeadImgEqualTo(String value) {
            addCriterion("tea_head_img =", value, "teaHeadImg");
            return (Criteria) this;
        }

        public Criteria andTeaHeadImgNotEqualTo(String value) {
            addCriterion("tea_head_img <>", value, "teaHeadImg");
            return (Criteria) this;
        }

        public Criteria andTeaHeadImgGreaterThan(String value) {
            addCriterion("tea_head_img >", value, "teaHeadImg");
            return (Criteria) this;
        }

        public Criteria andTeaHeadImgGreaterThanOrEqualTo(String value) {
            addCriterion("tea_head_img >=", value, "teaHeadImg");
            return (Criteria) this;
        }

        public Criteria andTeaHeadImgLessThan(String value) {
            addCriterion("tea_head_img <", value, "teaHeadImg");
            return (Criteria) this;
        }

        public Criteria andTeaHeadImgLessThanOrEqualTo(String value) {
            addCriterion("tea_head_img <=", value, "teaHeadImg");
            return (Criteria) this;
        }

        public Criteria andTeaHeadImgLike(String value) {
            addCriterion("tea_head_img like", value, "teaHeadImg");
            return (Criteria) this;
        }

        public Criteria andTeaHeadImgNotLike(String value) {
            addCriterion("tea_head_img not like", value, "teaHeadImg");
            return (Criteria) this;
        }

        public Criteria andTeaHeadImgIn(List<String> values) {
            addCriterion("tea_head_img in", values, "teaHeadImg");
            return (Criteria) this;
        }

        public Criteria andTeaHeadImgNotIn(List<String> values) {
            addCriterion("tea_head_img not in", values, "teaHeadImg");
            return (Criteria) this;
        }

        public Criteria andTeaHeadImgBetween(String value1, String value2) {
            addCriterion("tea_head_img between", value1, value2, "teaHeadImg");
            return (Criteria) this;
        }

        public Criteria andTeaHeadImgNotBetween(String value1, String value2) {
            addCriterion("tea_head_img not between", value1, value2, "teaHeadImg");
            return (Criteria) this;
        }

        public Criteria andTeaNicknameIsNull() {
            addCriterion("tea_nickname is null");
            return (Criteria) this;
        }

        public Criteria andTeaNicknameIsNotNull() {
            addCriterion("tea_nickname is not null");
            return (Criteria) this;
        }

        public Criteria andTeaNicknameEqualTo(String value) {
            addCriterion("tea_nickname =", value, "teaNickname");
            return (Criteria) this;
        }

        public Criteria andTeaNicknameNotEqualTo(String value) {
            addCriterion("tea_nickname <>", value, "teaNickname");
            return (Criteria) this;
        }

        public Criteria andTeaNicknameGreaterThan(String value) {
            addCriterion("tea_nickname >", value, "teaNickname");
            return (Criteria) this;
        }

        public Criteria andTeaNicknameGreaterThanOrEqualTo(String value) {
            addCriterion("tea_nickname >=", value, "teaNickname");
            return (Criteria) this;
        }

        public Criteria andTeaNicknameLessThan(String value) {
            addCriterion("tea_nickname <", value, "teaNickname");
            return (Criteria) this;
        }

        public Criteria andTeaNicknameLessThanOrEqualTo(String value) {
            addCriterion("tea_nickname <=", value, "teaNickname");
            return (Criteria) this;
        }

        public Criteria andTeaNicknameLike(String value) {
            addCriterion("tea_nickname like", value, "teaNickname");
            return (Criteria) this;
        }

        public Criteria andTeaNicknameNotLike(String value) {
            addCriterion("tea_nickname not like", value, "teaNickname");
            return (Criteria) this;
        }

        public Criteria andTeaNicknameIn(List<String> values) {
            addCriterion("tea_nickname in", values, "teaNickname");
            return (Criteria) this;
        }

        public Criteria andTeaNicknameNotIn(List<String> values) {
            addCriterion("tea_nickname not in", values, "teaNickname");
            return (Criteria) this;
        }

        public Criteria andTeaNicknameBetween(String value1, String value2) {
            addCriterion("tea_nickname between", value1, value2, "teaNickname");
            return (Criteria) this;
        }

        public Criteria andTeaNicknameNotBetween(String value1, String value2) {
            addCriterion("tea_nickname not between", value1, value2, "teaNickname");
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
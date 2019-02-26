package com.wsh.entity;

import java.util.ArrayList;
import java.util.List;

public class StudentExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public StudentExample() {
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

        public Criteria andStuGradeIsNull() {
            addCriterion("stu_grade is null");
            return (Criteria) this;
        }

        public Criteria andStuGradeIsNotNull() {
            addCriterion("stu_grade is not null");
            return (Criteria) this;
        }

        public Criteria andStuGradeEqualTo(String value) {
            addCriterion("stu_grade =", value, "stuGrade");
            return (Criteria) this;
        }

        public Criteria andStuGradeNotEqualTo(String value) {
            addCriterion("stu_grade <>", value, "stuGrade");
            return (Criteria) this;
        }

        public Criteria andStuGradeGreaterThan(String value) {
            addCriterion("stu_grade >", value, "stuGrade");
            return (Criteria) this;
        }

        public Criteria andStuGradeGreaterThanOrEqualTo(String value) {
            addCriterion("stu_grade >=", value, "stuGrade");
            return (Criteria) this;
        }

        public Criteria andStuGradeLessThan(String value) {
            addCriterion("stu_grade <", value, "stuGrade");
            return (Criteria) this;
        }

        public Criteria andStuGradeLessThanOrEqualTo(String value) {
            addCriterion("stu_grade <=", value, "stuGrade");
            return (Criteria) this;
        }

        public Criteria andStuGradeLike(String value) {
            addCriterion("stu_grade like", value, "stuGrade");
            return (Criteria) this;
        }

        public Criteria andStuGradeNotLike(String value) {
            addCriterion("stu_grade not like", value, "stuGrade");
            return (Criteria) this;
        }

        public Criteria andStuGradeIn(List<String> values) {
            addCriterion("stu_grade in", values, "stuGrade");
            return (Criteria) this;
        }

        public Criteria andStuGradeNotIn(List<String> values) {
            addCriterion("stu_grade not in", values, "stuGrade");
            return (Criteria) this;
        }

        public Criteria andStuGradeBetween(String value1, String value2) {
            addCriterion("stu_grade between", value1, value2, "stuGrade");
            return (Criteria) this;
        }

        public Criteria andStuGradeNotBetween(String value1, String value2) {
            addCriterion("stu_grade not between", value1, value2, "stuGrade");
            return (Criteria) this;
        }

        public Criteria andStuDepartmentIsNull() {
            addCriterion("stu_department is null");
            return (Criteria) this;
        }

        public Criteria andStuDepartmentIsNotNull() {
            addCriterion("stu_department is not null");
            return (Criteria) this;
        }

        public Criteria andStuDepartmentEqualTo(String value) {
            addCriterion("stu_department =", value, "stuDepartment");
            return (Criteria) this;
        }

        public Criteria andStuDepartmentNotEqualTo(String value) {
            addCriterion("stu_department <>", value, "stuDepartment");
            return (Criteria) this;
        }

        public Criteria andStuDepartmentGreaterThan(String value) {
            addCriterion("stu_department >", value, "stuDepartment");
            return (Criteria) this;
        }

        public Criteria andStuDepartmentGreaterThanOrEqualTo(String value) {
            addCriterion("stu_department >=", value, "stuDepartment");
            return (Criteria) this;
        }

        public Criteria andStuDepartmentLessThan(String value) {
            addCriterion("stu_department <", value, "stuDepartment");
            return (Criteria) this;
        }

        public Criteria andStuDepartmentLessThanOrEqualTo(String value) {
            addCriterion("stu_department <=", value, "stuDepartment");
            return (Criteria) this;
        }

        public Criteria andStuDepartmentLike(String value) {
            addCriterion("stu_department like", value, "stuDepartment");
            return (Criteria) this;
        }

        public Criteria andStuDepartmentNotLike(String value) {
            addCriterion("stu_department not like", value, "stuDepartment");
            return (Criteria) this;
        }

        public Criteria andStuDepartmentIn(List<String> values) {
            addCriterion("stu_department in", values, "stuDepartment");
            return (Criteria) this;
        }

        public Criteria andStuDepartmentNotIn(List<String> values) {
            addCriterion("stu_department not in", values, "stuDepartment");
            return (Criteria) this;
        }

        public Criteria andStuDepartmentBetween(String value1, String value2) {
            addCriterion("stu_department between", value1, value2, "stuDepartment");
            return (Criteria) this;
        }

        public Criteria andStuDepartmentNotBetween(String value1, String value2) {
            addCriterion("stu_department not between", value1, value2, "stuDepartment");
            return (Criteria) this;
        }

        public Criteria andStuMajorIsNull() {
            addCriterion("stu_major is null");
            return (Criteria) this;
        }

        public Criteria andStuMajorIsNotNull() {
            addCriterion("stu_major is not null");
            return (Criteria) this;
        }

        public Criteria andStuMajorEqualTo(String value) {
            addCriterion("stu_major =", value, "stuMajor");
            return (Criteria) this;
        }

        public Criteria andStuMajorNotEqualTo(String value) {
            addCriterion("stu_major <>", value, "stuMajor");
            return (Criteria) this;
        }

        public Criteria andStuMajorGreaterThan(String value) {
            addCriterion("stu_major >", value, "stuMajor");
            return (Criteria) this;
        }

        public Criteria andStuMajorGreaterThanOrEqualTo(String value) {
            addCriterion("stu_major >=", value, "stuMajor");
            return (Criteria) this;
        }

        public Criteria andStuMajorLessThan(String value) {
            addCriterion("stu_major <", value, "stuMajor");
            return (Criteria) this;
        }

        public Criteria andStuMajorLessThanOrEqualTo(String value) {
            addCriterion("stu_major <=", value, "stuMajor");
            return (Criteria) this;
        }

        public Criteria andStuMajorLike(String value) {
            addCriterion("stu_major like", value, "stuMajor");
            return (Criteria) this;
        }

        public Criteria andStuMajorNotLike(String value) {
            addCriterion("stu_major not like", value, "stuMajor");
            return (Criteria) this;
        }

        public Criteria andStuMajorIn(List<String> values) {
            addCriterion("stu_major in", values, "stuMajor");
            return (Criteria) this;
        }

        public Criteria andStuMajorNotIn(List<String> values) {
            addCriterion("stu_major not in", values, "stuMajor");
            return (Criteria) this;
        }

        public Criteria andStuMajorBetween(String value1, String value2) {
            addCriterion("stu_major between", value1, value2, "stuMajor");
            return (Criteria) this;
        }

        public Criteria andStuMajorNotBetween(String value1, String value2) {
            addCriterion("stu_major not between", value1, value2, "stuMajor");
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

        public Criteria andStuPhoneIsNull() {
            addCriterion("stu_phone is null");
            return (Criteria) this;
        }

        public Criteria andStuPhoneIsNotNull() {
            addCriterion("stu_phone is not null");
            return (Criteria) this;
        }

        public Criteria andStuPhoneEqualTo(String value) {
            addCriterion("stu_phone =", value, "stuPhone");
            return (Criteria) this;
        }

        public Criteria andStuPhoneNotEqualTo(String value) {
            addCriterion("stu_phone <>", value, "stuPhone");
            return (Criteria) this;
        }

        public Criteria andStuPhoneGreaterThan(String value) {
            addCriterion("stu_phone >", value, "stuPhone");
            return (Criteria) this;
        }

        public Criteria andStuPhoneGreaterThanOrEqualTo(String value) {
            addCriterion("stu_phone >=", value, "stuPhone");
            return (Criteria) this;
        }

        public Criteria andStuPhoneLessThan(String value) {
            addCriterion("stu_phone <", value, "stuPhone");
            return (Criteria) this;
        }

        public Criteria andStuPhoneLessThanOrEqualTo(String value) {
            addCriterion("stu_phone <=", value, "stuPhone");
            return (Criteria) this;
        }

        public Criteria andStuPhoneLike(String value) {
            addCriterion("stu_phone like", value, "stuPhone");
            return (Criteria) this;
        }

        public Criteria andStuPhoneNotLike(String value) {
            addCriterion("stu_phone not like", value, "stuPhone");
            return (Criteria) this;
        }

        public Criteria andStuPhoneIn(List<String> values) {
            addCriterion("stu_phone in", values, "stuPhone");
            return (Criteria) this;
        }

        public Criteria andStuPhoneNotIn(List<String> values) {
            addCriterion("stu_phone not in", values, "stuPhone");
            return (Criteria) this;
        }

        public Criteria andStuPhoneBetween(String value1, String value2) {
            addCriterion("stu_phone between", value1, value2, "stuPhone");
            return (Criteria) this;
        }

        public Criteria andStuPhoneNotBetween(String value1, String value2) {
            addCriterion("stu_phone not between", value1, value2, "stuPhone");
            return (Criteria) this;
        }

        public Criteria andStuPassIsNull() {
            addCriterion("stu_pass is null");
            return (Criteria) this;
        }

        public Criteria andStuPassIsNotNull() {
            addCriterion("stu_pass is not null");
            return (Criteria) this;
        }

        public Criteria andStuPassEqualTo(String value) {
            addCriterion("stu_pass =", value, "stuPass");
            return (Criteria) this;
        }

        public Criteria andStuPassNotEqualTo(String value) {
            addCriterion("stu_pass <>", value, "stuPass");
            return (Criteria) this;
        }

        public Criteria andStuPassGreaterThan(String value) {
            addCriterion("stu_pass >", value, "stuPass");
            return (Criteria) this;
        }

        public Criteria andStuPassGreaterThanOrEqualTo(String value) {
            addCriterion("stu_pass >=", value, "stuPass");
            return (Criteria) this;
        }

        public Criteria andStuPassLessThan(String value) {
            addCriterion("stu_pass <", value, "stuPass");
            return (Criteria) this;
        }

        public Criteria andStuPassLessThanOrEqualTo(String value) {
            addCriterion("stu_pass <=", value, "stuPass");
            return (Criteria) this;
        }

        public Criteria andStuPassLike(String value) {
            addCriterion("stu_pass like", value, "stuPass");
            return (Criteria) this;
        }

        public Criteria andStuPassNotLike(String value) {
            addCriterion("stu_pass not like", value, "stuPass");
            return (Criteria) this;
        }

        public Criteria andStuPassIn(List<String> values) {
            addCriterion("stu_pass in", values, "stuPass");
            return (Criteria) this;
        }

        public Criteria andStuPassNotIn(List<String> values) {
            addCriterion("stu_pass not in", values, "stuPass");
            return (Criteria) this;
        }

        public Criteria andStuPassBetween(String value1, String value2) {
            addCriterion("stu_pass between", value1, value2, "stuPass");
            return (Criteria) this;
        }

        public Criteria andStuPassNotBetween(String value1, String value2) {
            addCriterion("stu_pass not between", value1, value2, "stuPass");
            return (Criteria) this;
        }

        public Criteria andStuNicknameIsNull() {
            addCriterion("stu_nickname is null");
            return (Criteria) this;
        }

        public Criteria andStuNicknameIsNotNull() {
            addCriterion("stu_nickname is not null");
            return (Criteria) this;
        }

        public Criteria andStuNicknameEqualTo(String value) {
            addCriterion("stu_nickname =", value, "stuNickname");
            return (Criteria) this;
        }

        public Criteria andStuNicknameNotEqualTo(String value) {
            addCriterion("stu_nickname <>", value, "stuNickname");
            return (Criteria) this;
        }

        public Criteria andStuNicknameGreaterThan(String value) {
            addCriterion("stu_nickname >", value, "stuNickname");
            return (Criteria) this;
        }

        public Criteria andStuNicknameGreaterThanOrEqualTo(String value) {
            addCriterion("stu_nickname >=", value, "stuNickname");
            return (Criteria) this;
        }

        public Criteria andStuNicknameLessThan(String value) {
            addCriterion("stu_nickname <", value, "stuNickname");
            return (Criteria) this;
        }

        public Criteria andStuNicknameLessThanOrEqualTo(String value) {
            addCriterion("stu_nickname <=", value, "stuNickname");
            return (Criteria) this;
        }

        public Criteria andStuNicknameLike(String value) {
            addCriterion("stu_nickname like", value, "stuNickname");
            return (Criteria) this;
        }

        public Criteria andStuNicknameNotLike(String value) {
            addCriterion("stu_nickname not like", value, "stuNickname");
            return (Criteria) this;
        }

        public Criteria andStuNicknameIn(List<String> values) {
            addCriterion("stu_nickname in", values, "stuNickname");
            return (Criteria) this;
        }

        public Criteria andStuNicknameNotIn(List<String> values) {
            addCriterion("stu_nickname not in", values, "stuNickname");
            return (Criteria) this;
        }

        public Criteria andStuNicknameBetween(String value1, String value2) {
            addCriterion("stu_nickname between", value1, value2, "stuNickname");
            return (Criteria) this;
        }

        public Criteria andStuNicknameNotBetween(String value1, String value2) {
            addCriterion("stu_nickname not between", value1, value2, "stuNickname");
            return (Criteria) this;
        }

        public Criteria andStuHeadImgIsNull() {
            addCriterion("stu_head_img is null");
            return (Criteria) this;
        }

        public Criteria andStuHeadImgIsNotNull() {
            addCriterion("stu_head_img is not null");
            return (Criteria) this;
        }

        public Criteria andStuHeadImgEqualTo(String value) {
            addCriterion("stu_head_img =", value, "stuHeadImg");
            return (Criteria) this;
        }

        public Criteria andStuHeadImgNotEqualTo(String value) {
            addCriterion("stu_head_img <>", value, "stuHeadImg");
            return (Criteria) this;
        }

        public Criteria andStuHeadImgGreaterThan(String value) {
            addCriterion("stu_head_img >", value, "stuHeadImg");
            return (Criteria) this;
        }

        public Criteria andStuHeadImgGreaterThanOrEqualTo(String value) {
            addCriterion("stu_head_img >=", value, "stuHeadImg");
            return (Criteria) this;
        }

        public Criteria andStuHeadImgLessThan(String value) {
            addCriterion("stu_head_img <", value, "stuHeadImg");
            return (Criteria) this;
        }

        public Criteria andStuHeadImgLessThanOrEqualTo(String value) {
            addCriterion("stu_head_img <=", value, "stuHeadImg");
            return (Criteria) this;
        }

        public Criteria andStuHeadImgLike(String value) {
            addCriterion("stu_head_img like", value, "stuHeadImg");
            return (Criteria) this;
        }

        public Criteria andStuHeadImgNotLike(String value) {
            addCriterion("stu_head_img not like", value, "stuHeadImg");
            return (Criteria) this;
        }

        public Criteria andStuHeadImgIn(List<String> values) {
            addCriterion("stu_head_img in", values, "stuHeadImg");
            return (Criteria) this;
        }

        public Criteria andStuHeadImgNotIn(List<String> values) {
            addCriterion("stu_head_img not in", values, "stuHeadImg");
            return (Criteria) this;
        }

        public Criteria andStuHeadImgBetween(String value1, String value2) {
            addCriterion("stu_head_img between", value1, value2, "stuHeadImg");
            return (Criteria) this;
        }

        public Criteria andStuHeadImgNotBetween(String value1, String value2) {
            addCriterion("stu_head_img not between", value1, value2, "stuHeadImg");
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
package ad.bean;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class AbAdvertiserExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public AbAdvertiserExample() {
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

        public Criteria andAdvertiserIdIsNull() {
            addCriterion("advertiser_id is null");
            return (Criteria) this;
        }

        public Criteria andAdvertiserIdIsNotNull() {
            addCriterion("advertiser_id is not null");
            return (Criteria) this;
        }

        public Criteria andAdvertiserIdEqualTo(String value) {
            addCriterion("advertiser_id =", value, "advertiserId");
            return (Criteria) this;
        }

        public Criteria andAdvertiserIdNotEqualTo(String value) {
            addCriterion("advertiser_id <>", value, "advertiserId");
            return (Criteria) this;
        }

        public Criteria andAdvertiserIdGreaterThan(String value) {
            addCriterion("advertiser_id >", value, "advertiserId");
            return (Criteria) this;
        }

        public Criteria andAdvertiserIdGreaterThanOrEqualTo(String value) {
            addCriterion("advertiser_id >=", value, "advertiserId");
            return (Criteria) this;
        }

        public Criteria andAdvertiserIdLessThan(String value) {
            addCriterion("advertiser_id <", value, "advertiserId");
            return (Criteria) this;
        }

        public Criteria andAdvertiserIdLessThanOrEqualTo(String value) {
            addCriterion("advertiser_id <=", value, "advertiserId");
            return (Criteria) this;
        }

        public Criteria andAdvertiserIdLike(String value) {
            addCriterion("advertiser_id like", value, "advertiserId");
            return (Criteria) this;
        }

        public Criteria andAdvertiserIdNotLike(String value) {
            addCriterion("advertiser_id not like", value, "advertiserId");
            return (Criteria) this;
        }

        public Criteria andAdvertiserIdIn(List<String> values) {
            addCriterion("advertiser_id in", values, "advertiserId");
            return (Criteria) this;
        }

        public Criteria andAdvertiserIdNotIn(List<String> values) {
            addCriterion("advertiser_id not in", values, "advertiserId");
            return (Criteria) this;
        }

        public Criteria andAdvertiserIdBetween(String value1, String value2) {
            addCriterion("advertiser_id between", value1, value2, "advertiserId");
            return (Criteria) this;
        }

        public Criteria andAdvertiserIdNotBetween(String value1, String value2) {
            addCriterion("advertiser_id not between", value1, value2, "advertiserId");
            return (Criteria) this;
        }

        public Criteria andAdvertiserNameIsNull() {
            addCriterion("advertiser_name is null");
            return (Criteria) this;
        }

        public Criteria andAdvertiserNameIsNotNull() {
            addCriterion("advertiser_name is not null");
            return (Criteria) this;
        }

        public Criteria andAdvertiserNameEqualTo(String value) {
            addCriterion("advertiser_name =", value, "advertiserName");
            return (Criteria) this;
        }

        public Criteria andAdvertiserNameNotEqualTo(String value) {
            addCriterion("advertiser_name <>", value, "advertiserName");
            return (Criteria) this;
        }

        public Criteria andAdvertiserNameGreaterThan(String value) {
            addCriterion("advertiser_name >", value, "advertiserName");
            return (Criteria) this;
        }

        public Criteria andAdvertiserNameGreaterThanOrEqualTo(String value) {
            addCriterion("advertiser_name >=", value, "advertiserName");
            return (Criteria) this;
        }

        public Criteria andAdvertiserNameLessThan(String value) {
            addCriterion("advertiser_name <", value, "advertiserName");
            return (Criteria) this;
        }

        public Criteria andAdvertiserNameLessThanOrEqualTo(String value) {
            addCriterion("advertiser_name <=", value, "advertiserName");
            return (Criteria) this;
        }

        public Criteria andAdvertiserNameLike(String value) {
            addCriterion("advertiser_name like", value, "advertiserName");
            return (Criteria) this;
        }

        public Criteria andAdvertiserNameNotLike(String value) {
            addCriterion("advertiser_name not like", value, "advertiserName");
            return (Criteria) this;
        }

        public Criteria andAdvertiserNameIn(List<String> values) {
            addCriterion("advertiser_name in", values, "advertiserName");
            return (Criteria) this;
        }

        public Criteria andAdvertiserNameNotIn(List<String> values) {
            addCriterion("advertiser_name not in", values, "advertiserName");
            return (Criteria) this;
        }

        public Criteria andAdvertiserNameBetween(String value1, String value2) {
            addCriterion("advertiser_name between", value1, value2, "advertiserName");
            return (Criteria) this;
        }

        public Criteria andAdvertiserNameNotBetween(String value1, String value2) {
            addCriterion("advertiser_name not between", value1, value2, "advertiserName");
            return (Criteria) this;
        }

        public Criteria andAdvertiserPhoneIsNull() {
            addCriterion("advertiser_phone is null");
            return (Criteria) this;
        }

        public Criteria andAdvertiserPhoneIsNotNull() {
            addCriterion("advertiser_phone is not null");
            return (Criteria) this;
        }

        public Criteria andAdvertiserPhoneEqualTo(String value) {
            addCriterion("advertiser_phone =", value, "advertiserPhone");
            return (Criteria) this;
        }

        public Criteria andAdvertiserPhoneNotEqualTo(String value) {
            addCriterion("advertiser_phone <>", value, "advertiserPhone");
            return (Criteria) this;
        }

        public Criteria andAdvertiserPhoneGreaterThan(String value) {
            addCriterion("advertiser_phone >", value, "advertiserPhone");
            return (Criteria) this;
        }

        public Criteria andAdvertiserPhoneGreaterThanOrEqualTo(String value) {
            addCriterion("advertiser_phone >=", value, "advertiserPhone");
            return (Criteria) this;
        }

        public Criteria andAdvertiserPhoneLessThan(String value) {
            addCriterion("advertiser_phone <", value, "advertiserPhone");
            return (Criteria) this;
        }

        public Criteria andAdvertiserPhoneLessThanOrEqualTo(String value) {
            addCriterion("advertiser_phone <=", value, "advertiserPhone");
            return (Criteria) this;
        }

        public Criteria andAdvertiserPhoneLike(String value) {
            addCriterion("advertiser_phone like", value, "advertiserPhone");
            return (Criteria) this;
        }

        public Criteria andAdvertiserPhoneNotLike(String value) {
            addCriterion("advertiser_phone not like", value, "advertiserPhone");
            return (Criteria) this;
        }

        public Criteria andAdvertiserPhoneIn(List<String> values) {
            addCriterion("advertiser_phone in", values, "advertiserPhone");
            return (Criteria) this;
        }

        public Criteria andAdvertiserPhoneNotIn(List<String> values) {
            addCriterion("advertiser_phone not in", values, "advertiserPhone");
            return (Criteria) this;
        }

        public Criteria andAdvertiserPhoneBetween(String value1, String value2) {
            addCriterion("advertiser_phone between", value1, value2, "advertiserPhone");
            return (Criteria) this;
        }

        public Criteria andAdvertiserPhoneNotBetween(String value1, String value2) {
            addCriterion("advertiser_phone not between", value1, value2, "advertiserPhone");
            return (Criteria) this;
        }

        public Criteria andAdvertiserEmailIsNull() {
            addCriterion("advertiser_email is null");
            return (Criteria) this;
        }

        public Criteria andAdvertiserEmailIsNotNull() {
            addCriterion("advertiser_email is not null");
            return (Criteria) this;
        }

        public Criteria andAdvertiserEmailEqualTo(String value) {
            addCriterion("advertiser_email =", value, "advertiserEmail");
            return (Criteria) this;
        }

        public Criteria andAdvertiserEmailNotEqualTo(String value) {
            addCriterion("advertiser_email <>", value, "advertiserEmail");
            return (Criteria) this;
        }

        public Criteria andAdvertiserEmailGreaterThan(String value) {
            addCriterion("advertiser_email >", value, "advertiserEmail");
            return (Criteria) this;
        }

        public Criteria andAdvertiserEmailGreaterThanOrEqualTo(String value) {
            addCriterion("advertiser_email >=", value, "advertiserEmail");
            return (Criteria) this;
        }

        public Criteria andAdvertiserEmailLessThan(String value) {
            addCriterion("advertiser_email <", value, "advertiserEmail");
            return (Criteria) this;
        }

        public Criteria andAdvertiserEmailLessThanOrEqualTo(String value) {
            addCriterion("advertiser_email <=", value, "advertiserEmail");
            return (Criteria) this;
        }

        public Criteria andAdvertiserEmailLike(String value) {
            addCriterion("advertiser_email like", value, "advertiserEmail");
            return (Criteria) this;
        }

        public Criteria andAdvertiserEmailNotLike(String value) {
            addCriterion("advertiser_email not like", value, "advertiserEmail");
            return (Criteria) this;
        }

        public Criteria andAdvertiserEmailIn(List<String> values) {
            addCriterion("advertiser_email in", values, "advertiserEmail");
            return (Criteria) this;
        }

        public Criteria andAdvertiserEmailNotIn(List<String> values) {
            addCriterion("advertiser_email not in", values, "advertiserEmail");
            return (Criteria) this;
        }

        public Criteria andAdvertiserEmailBetween(String value1, String value2) {
            addCriterion("advertiser_email between", value1, value2, "advertiserEmail");
            return (Criteria) this;
        }

        public Criteria andAdvertiserEmailNotBetween(String value1, String value2) {
            addCriterion("advertiser_email not between", value1, value2, "advertiserEmail");
            return (Criteria) this;
        }

        public Criteria andRemarkIsNull() {
            addCriterion("remark is null");
            return (Criteria) this;
        }

        public Criteria andRemarkIsNotNull() {
            addCriterion("remark is not null");
            return (Criteria) this;
        }

        public Criteria andRemarkEqualTo(String value) {
            addCriterion("remark =", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotEqualTo(String value) {
            addCriterion("remark <>", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkGreaterThan(String value) {
            addCriterion("remark >", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkGreaterThanOrEqualTo(String value) {
            addCriterion("remark >=", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLessThan(String value) {
            addCriterion("remark <", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLessThanOrEqualTo(String value) {
            addCriterion("remark <=", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLike(String value) {
            addCriterion("remark like", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotLike(String value) {
            addCriterion("remark not like", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkIn(List<String> values) {
            addCriterion("remark in", values, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotIn(List<String> values) {
            addCriterion("remark not in", values, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkBetween(String value1, String value2) {
            addCriterion("remark between", value1, value2, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotBetween(String value1, String value2) {
            addCriterion("remark not between", value1, value2, "remark");
            return (Criteria) this;
        }

        public Criteria andAdvertiserProvinceIsNull() {
            addCriterion("advertiser_province is null");
            return (Criteria) this;
        }

        public Criteria andAdvertiserProvinceIsNotNull() {
            addCriterion("advertiser_province is not null");
            return (Criteria) this;
        }

        public Criteria andAdvertiserProvinceEqualTo(String value) {
            addCriterion("advertiser_province =", value, "advertiserProvince");
            return (Criteria) this;
        }

        public Criteria andAdvertiserProvinceNotEqualTo(String value) {
            addCriterion("advertiser_province <>", value, "advertiserProvince");
            return (Criteria) this;
        }

        public Criteria andAdvertiserProvinceGreaterThan(String value) {
            addCriterion("advertiser_province >", value, "advertiserProvince");
            return (Criteria) this;
        }

        public Criteria andAdvertiserProvinceGreaterThanOrEqualTo(String value) {
            addCriterion("advertiser_province >=", value, "advertiserProvince");
            return (Criteria) this;
        }

        public Criteria andAdvertiserProvinceLessThan(String value) {
            addCriterion("advertiser_province <", value, "advertiserProvince");
            return (Criteria) this;
        }

        public Criteria andAdvertiserProvinceLessThanOrEqualTo(String value) {
            addCriterion("advertiser_province <=", value, "advertiserProvince");
            return (Criteria) this;
        }

        public Criteria andAdvertiserProvinceLike(String value) {
            addCriterion("advertiser_province like", value, "advertiserProvince");
            return (Criteria) this;
        }

        public Criteria andAdvertiserProvinceNotLike(String value) {
            addCriterion("advertiser_province not like", value, "advertiserProvince");
            return (Criteria) this;
        }

        public Criteria andAdvertiserProvinceIn(List<String> values) {
            addCriterion("advertiser_province in", values, "advertiserProvince");
            return (Criteria) this;
        }

        public Criteria andAdvertiserProvinceNotIn(List<String> values) {
            addCriterion("advertiser_province not in", values, "advertiserProvince");
            return (Criteria) this;
        }

        public Criteria andAdvertiserProvinceBetween(String value1, String value2) {
            addCriterion("advertiser_province between", value1, value2, "advertiserProvince");
            return (Criteria) this;
        }

        public Criteria andAdvertiserProvinceNotBetween(String value1, String value2) {
            addCriterion("advertiser_province not between", value1, value2, "advertiserProvince");
            return (Criteria) this;
        }

        public Criteria andAdvertiserCityIsNull() {
            addCriterion("advertiser_city is null");
            return (Criteria) this;
        }

        public Criteria andAdvertiserCityIsNotNull() {
            addCriterion("advertiser_city is not null");
            return (Criteria) this;
        }

        public Criteria andAdvertiserCityEqualTo(String value) {
            addCriterion("advertiser_city =", value, "advertiserCity");
            return (Criteria) this;
        }

        public Criteria andAdvertiserCityNotEqualTo(String value) {
            addCriterion("advertiser_city <>", value, "advertiserCity");
            return (Criteria) this;
        }

        public Criteria andAdvertiserCityGreaterThan(String value) {
            addCriterion("advertiser_city >", value, "advertiserCity");
            return (Criteria) this;
        }

        public Criteria andAdvertiserCityGreaterThanOrEqualTo(String value) {
            addCriterion("advertiser_city >=", value, "advertiserCity");
            return (Criteria) this;
        }

        public Criteria andAdvertiserCityLessThan(String value) {
            addCriterion("advertiser_city <", value, "advertiserCity");
            return (Criteria) this;
        }

        public Criteria andAdvertiserCityLessThanOrEqualTo(String value) {
            addCriterion("advertiser_city <=", value, "advertiserCity");
            return (Criteria) this;
        }

        public Criteria andAdvertiserCityLike(String value) {
            addCriterion("advertiser_city like", value, "advertiserCity");
            return (Criteria) this;
        }

        public Criteria andAdvertiserCityNotLike(String value) {
            addCriterion("advertiser_city not like", value, "advertiserCity");
            return (Criteria) this;
        }

        public Criteria andAdvertiserCityIn(List<String> values) {
            addCriterion("advertiser_city in", values, "advertiserCity");
            return (Criteria) this;
        }

        public Criteria andAdvertiserCityNotIn(List<String> values) {
            addCriterion("advertiser_city not in", values, "advertiserCity");
            return (Criteria) this;
        }

        public Criteria andAdvertiserCityBetween(String value1, String value2) {
            addCriterion("advertiser_city between", value1, value2, "advertiserCity");
            return (Criteria) this;
        }

        public Criteria andAdvertiserCityNotBetween(String value1, String value2) {
            addCriterion("advertiser_city not between", value1, value2, "advertiserCity");
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

        public Criteria andCreateTimeEqualTo(Date value) {
            addCriterion("create_time =", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotEqualTo(Date value) {
            addCriterion("create_time <>", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThan(Date value) {
            addCriterion("create_time >", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("create_time >=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThan(Date value) {
            addCriterion("create_time <", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThanOrEqualTo(Date value) {
            addCriterion("create_time <=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIn(List<Date> values) {
            addCriterion("create_time in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotIn(List<Date> values) {
            addCriterion("create_time not in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeBetween(Date value1, Date value2) {
            addCriterion("create_time between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotBetween(Date value1, Date value2) {
            addCriterion("create_time not between", value1, value2, "createTime");
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

        public Criteria andStatusEqualTo(Integer value) {
            addCriterion("status =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(Integer value) {
            addCriterion("status <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(Integer value) {
            addCriterion("status >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("status >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(Integer value) {
            addCriterion("status <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(Integer value) {
            addCriterion("status <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<Integer> values) {
            addCriterion("status in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<Integer> values) {
            addCriterion("status not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(Integer value1, Integer value2) {
            addCriterion("status between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("status not between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andUseridIsNull() {
            addCriterion("userID is null");
            return (Criteria) this;
        }

        public Criteria andUseridIsNotNull() {
            addCriterion("userID is not null");
            return (Criteria) this;
        }

        public Criteria andUseridEqualTo(String value) {
            addCriterion("userID =", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridNotEqualTo(String value) {
            addCriterion("userID <>", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridGreaterThan(String value) {
            addCriterion("userID >", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridGreaterThanOrEqualTo(String value) {
            addCriterion("userID >=", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridLessThan(String value) {
            addCriterion("userID <", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridLessThanOrEqualTo(String value) {
            addCriterion("userID <=", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridLike(String value) {
            addCriterion("userID like", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridNotLike(String value) {
            addCriterion("userID not like", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridIn(List<String> values) {
            addCriterion("userID in", values, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridNotIn(List<String> values) {
            addCriterion("userID not in", values, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridBetween(String value1, String value2) {
            addCriterion("userID between", value1, value2, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridNotBetween(String value1, String value2) {
            addCriterion("userID not between", value1, value2, "userid");
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
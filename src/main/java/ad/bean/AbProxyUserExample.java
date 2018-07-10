package ad.bean;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class AbProxyUserExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public AbProxyUserExample() {
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

        public Criteria andProxyNameIsNull() {
            addCriterion("proxy_name is null");
            return (Criteria) this;
        }

        public Criteria andProxyNameIsNotNull() {
            addCriterion("proxy_name is not null");
            return (Criteria) this;
        }

        public Criteria andProxyNameEqualTo(String value) {
            addCriterion("proxy_name =", value, "proxyName");
            return (Criteria) this;
        }

        public Criteria andProxyNameNotEqualTo(String value) {
            addCriterion("proxy_name <>", value, "proxyName");
            return (Criteria) this;
        }

        public Criteria andProxyNameGreaterThan(String value) {
            addCriterion("proxy_name >", value, "proxyName");
            return (Criteria) this;
        }

        public Criteria andProxyNameGreaterThanOrEqualTo(String value) {
            addCriterion("proxy_name >=", value, "proxyName");
            return (Criteria) this;
        }

        public Criteria andProxyNameLessThan(String value) {
            addCriterion("proxy_name <", value, "proxyName");
            return (Criteria) this;
        }

        public Criteria andProxyNameLessThanOrEqualTo(String value) {
            addCriterion("proxy_name <=", value, "proxyName");
            return (Criteria) this;
        }

        public Criteria andProxyNameLike(String value) {
            addCriterion("proxy_name like", value, "proxyName");
            return (Criteria) this;
        }

        public Criteria andProxyNameNotLike(String value) {
            addCriterion("proxy_name not like", value, "proxyName");
            return (Criteria) this;
        }

        public Criteria andProxyNameIn(List<String> values) {
            addCriterion("proxy_name in", values, "proxyName");
            return (Criteria) this;
        }

        public Criteria andProxyNameNotIn(List<String> values) {
            addCriterion("proxy_name not in", values, "proxyName");
            return (Criteria) this;
        }

        public Criteria andProxyNameBetween(String value1, String value2) {
            addCriterion("proxy_name between", value1, value2, "proxyName");
            return (Criteria) this;
        }

        public Criteria andProxyNameNotBetween(String value1, String value2) {
            addCriterion("proxy_name not between", value1, value2, "proxyName");
            return (Criteria) this;
        }

        public Criteria andProxyPhoneIsNull() {
            addCriterion("proxy_phone is null");
            return (Criteria) this;
        }

        public Criteria andProxyPhoneIsNotNull() {
            addCriterion("proxy_phone is not null");
            return (Criteria) this;
        }

        public Criteria andProxyPhoneEqualTo(String value) {
            addCriterion("proxy_phone =", value, "proxyPhone");
            return (Criteria) this;
        }

        public Criteria andProxyPhoneNotEqualTo(String value) {
            addCriterion("proxy_phone <>", value, "proxyPhone");
            return (Criteria) this;
        }

        public Criteria andProxyPhoneGreaterThan(String value) {
            addCriterion("proxy_phone >", value, "proxyPhone");
            return (Criteria) this;
        }

        public Criteria andProxyPhoneGreaterThanOrEqualTo(String value) {
            addCriterion("proxy_phone >=", value, "proxyPhone");
            return (Criteria) this;
        }

        public Criteria andProxyPhoneLessThan(String value) {
            addCriterion("proxy_phone <", value, "proxyPhone");
            return (Criteria) this;
        }

        public Criteria andProxyPhoneLessThanOrEqualTo(String value) {
            addCriterion("proxy_phone <=", value, "proxyPhone");
            return (Criteria) this;
        }

        public Criteria andProxyPhoneLike(String value) {
            addCriterion("proxy_phone like", value, "proxyPhone");
            return (Criteria) this;
        }

        public Criteria andProxyPhoneNotLike(String value) {
            addCriterion("proxy_phone not like", value, "proxyPhone");
            return (Criteria) this;
        }

        public Criteria andProxyPhoneIn(List<String> values) {
            addCriterion("proxy_phone in", values, "proxyPhone");
            return (Criteria) this;
        }

        public Criteria andProxyPhoneNotIn(List<String> values) {
            addCriterion("proxy_phone not in", values, "proxyPhone");
            return (Criteria) this;
        }

        public Criteria andProxyPhoneBetween(String value1, String value2) {
            addCriterion("proxy_phone between", value1, value2, "proxyPhone");
            return (Criteria) this;
        }

        public Criteria andProxyPhoneNotBetween(String value1, String value2) {
            addCriterion("proxy_phone not between", value1, value2, "proxyPhone");
            return (Criteria) this;
        }

        public Criteria andProxyPasswordIsNull() {
            addCriterion("proxy_password is null");
            return (Criteria) this;
        }

        public Criteria andProxyPasswordIsNotNull() {
            addCriterion("proxy_password is not null");
            return (Criteria) this;
        }

        public Criteria andProxyPasswordEqualTo(String value) {
            addCriterion("proxy_password =", value, "proxyPassword");
            return (Criteria) this;
        }

        public Criteria andProxyPasswordNotEqualTo(String value) {
            addCriterion("proxy_password <>", value, "proxyPassword");
            return (Criteria) this;
        }

        public Criteria andProxyPasswordGreaterThan(String value) {
            addCriterion("proxy_password >", value, "proxyPassword");
            return (Criteria) this;
        }

        public Criteria andProxyPasswordGreaterThanOrEqualTo(String value) {
            addCriterion("proxy_password >=", value, "proxyPassword");
            return (Criteria) this;
        }

        public Criteria andProxyPasswordLessThan(String value) {
            addCriterion("proxy_password <", value, "proxyPassword");
            return (Criteria) this;
        }

        public Criteria andProxyPasswordLessThanOrEqualTo(String value) {
            addCriterion("proxy_password <=", value, "proxyPassword");
            return (Criteria) this;
        }

        public Criteria andProxyPasswordLike(String value) {
            addCriterion("proxy_password like", value, "proxyPassword");
            return (Criteria) this;
        }

        public Criteria andProxyPasswordNotLike(String value) {
            addCriterion("proxy_password not like", value, "proxyPassword");
            return (Criteria) this;
        }

        public Criteria andProxyPasswordIn(List<String> values) {
            addCriterion("proxy_password in", values, "proxyPassword");
            return (Criteria) this;
        }

        public Criteria andProxyPasswordNotIn(List<String> values) {
            addCriterion("proxy_password not in", values, "proxyPassword");
            return (Criteria) this;
        }

        public Criteria andProxyPasswordBetween(String value1, String value2) {
            addCriterion("proxy_password between", value1, value2, "proxyPassword");
            return (Criteria) this;
        }

        public Criteria andProxyPasswordNotBetween(String value1, String value2) {
            addCriterion("proxy_password not between", value1, value2, "proxyPassword");
            return (Criteria) this;
        }

        public Criteria andProxyProvinceIsNull() {
            addCriterion("proxy_province is null");
            return (Criteria) this;
        }

        public Criteria andProxyProvinceIsNotNull() {
            addCriterion("proxy_province is not null");
            return (Criteria) this;
        }

        public Criteria andProxyProvinceEqualTo(String value) {
            addCriterion("proxy_province =", value, "proxyProvince");
            return (Criteria) this;
        }

        public Criteria andProxyProvinceNotEqualTo(String value) {
            addCriterion("proxy_province <>", value, "proxyProvince");
            return (Criteria) this;
        }

        public Criteria andProxyProvinceGreaterThan(String value) {
            addCriterion("proxy_province >", value, "proxyProvince");
            return (Criteria) this;
        }

        public Criteria andProxyProvinceGreaterThanOrEqualTo(String value) {
            addCriterion("proxy_province >=", value, "proxyProvince");
            return (Criteria) this;
        }

        public Criteria andProxyProvinceLessThan(String value) {
            addCriterion("proxy_province <", value, "proxyProvince");
            return (Criteria) this;
        }

        public Criteria andProxyProvinceLessThanOrEqualTo(String value) {
            addCriterion("proxy_province <=", value, "proxyProvince");
            return (Criteria) this;
        }

        public Criteria andProxyProvinceLike(String value) {
            addCriterion("proxy_province like", value, "proxyProvince");
            return (Criteria) this;
        }

        public Criteria andProxyProvinceNotLike(String value) {
            addCriterion("proxy_province not like", value, "proxyProvince");
            return (Criteria) this;
        }

        public Criteria andProxyProvinceIn(List<String> values) {
            addCriterion("proxy_province in", values, "proxyProvince");
            return (Criteria) this;
        }

        public Criteria andProxyProvinceNotIn(List<String> values) {
            addCriterion("proxy_province not in", values, "proxyProvince");
            return (Criteria) this;
        }

        public Criteria andProxyProvinceBetween(String value1, String value2) {
            addCriterion("proxy_province between", value1, value2, "proxyProvince");
            return (Criteria) this;
        }

        public Criteria andProxyProvinceNotBetween(String value1, String value2) {
            addCriterion("proxy_province not between", value1, value2, "proxyProvince");
            return (Criteria) this;
        }

        public Criteria andProxyCityIsNull() {
            addCriterion("proxy_city is null");
            return (Criteria) this;
        }

        public Criteria andProxyCityIsNotNull() {
            addCriterion("proxy_city is not null");
            return (Criteria) this;
        }

        public Criteria andProxyCityEqualTo(String value) {
            addCriterion("proxy_city =", value, "proxyCity");
            return (Criteria) this;
        }

        public Criteria andProxyCityNotEqualTo(String value) {
            addCriterion("proxy_city <>", value, "proxyCity");
            return (Criteria) this;
        }

        public Criteria andProxyCityGreaterThan(String value) {
            addCriterion("proxy_city >", value, "proxyCity");
            return (Criteria) this;
        }

        public Criteria andProxyCityGreaterThanOrEqualTo(String value) {
            addCriterion("proxy_city >=", value, "proxyCity");
            return (Criteria) this;
        }

        public Criteria andProxyCityLessThan(String value) {
            addCriterion("proxy_city <", value, "proxyCity");
            return (Criteria) this;
        }

        public Criteria andProxyCityLessThanOrEqualTo(String value) {
            addCriterion("proxy_city <=", value, "proxyCity");
            return (Criteria) this;
        }

        public Criteria andProxyCityLike(String value) {
            addCriterion("proxy_city like", value, "proxyCity");
            return (Criteria) this;
        }

        public Criteria andProxyCityNotLike(String value) {
            addCriterion("proxy_city not like", value, "proxyCity");
            return (Criteria) this;
        }

        public Criteria andProxyCityIn(List<String> values) {
            addCriterion("proxy_city in", values, "proxyCity");
            return (Criteria) this;
        }

        public Criteria andProxyCityNotIn(List<String> values) {
            addCriterion("proxy_city not in", values, "proxyCity");
            return (Criteria) this;
        }

        public Criteria andProxyCityBetween(String value1, String value2) {
            addCriterion("proxy_city between", value1, value2, "proxyCity");
            return (Criteria) this;
        }

        public Criteria andProxyCityNotBetween(String value1, String value2) {
            addCriterion("proxy_city not between", value1, value2, "proxyCity");
            return (Criteria) this;
        }

        public Criteria andFatherIdIsNull() {
            addCriterion("father_id is null");
            return (Criteria) this;
        }

        public Criteria andFatherIdIsNotNull() {
            addCriterion("father_id is not null");
            return (Criteria) this;
        }

        public Criteria andFatherIdEqualTo(Integer value) {
            addCriterion("father_id =", value, "fatherId");
            return (Criteria) this;
        }

        public Criteria andFatherIdNotEqualTo(Integer value) {
            addCriterion("father_id <>", value, "fatherId");
            return (Criteria) this;
        }

        public Criteria andFatherIdGreaterThan(Integer value) {
            addCriterion("father_id >", value, "fatherId");
            return (Criteria) this;
        }

        public Criteria andFatherIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("father_id >=", value, "fatherId");
            return (Criteria) this;
        }

        public Criteria andFatherIdLessThan(Integer value) {
            addCriterion("father_id <", value, "fatherId");
            return (Criteria) this;
        }

        public Criteria andFatherIdLessThanOrEqualTo(Integer value) {
            addCriterion("father_id <=", value, "fatherId");
            return (Criteria) this;
        }

        public Criteria andFatherIdIn(List<Integer> values) {
            addCriterion("father_id in", values, "fatherId");
            return (Criteria) this;
        }

        public Criteria andFatherIdNotIn(List<Integer> values) {
            addCriterion("father_id not in", values, "fatherId");
            return (Criteria) this;
        }

        public Criteria andFatherIdBetween(Integer value1, Integer value2) {
            addCriterion("father_id between", value1, value2, "fatherId");
            return (Criteria) this;
        }

        public Criteria andFatherIdNotBetween(Integer value1, Integer value2) {
            addCriterion("father_id not between", value1, value2, "fatherId");
            return (Criteria) this;
        }

        public Criteria andAgencyLevelIsNull() {
            addCriterion("agency_level is null");
            return (Criteria) this;
        }

        public Criteria andAgencyLevelIsNotNull() {
            addCriterion("agency_level is not null");
            return (Criteria) this;
        }

        public Criteria andAgencyLevelEqualTo(Integer value) {
            addCriterion("agency_level =", value, "agencyLevel");
            return (Criteria) this;
        }

        public Criteria andAgencyLevelNotEqualTo(Integer value) {
            addCriterion("agency_level <>", value, "agencyLevel");
            return (Criteria) this;
        }

        public Criteria andAgencyLevelGreaterThan(Integer value) {
            addCriterion("agency_level >", value, "agencyLevel");
            return (Criteria) this;
        }

        public Criteria andAgencyLevelGreaterThanOrEqualTo(Integer value) {
            addCriterion("agency_level >=", value, "agencyLevel");
            return (Criteria) this;
        }

        public Criteria andAgencyLevelLessThan(Integer value) {
            addCriterion("agency_level <", value, "agencyLevel");
            return (Criteria) this;
        }

        public Criteria andAgencyLevelLessThanOrEqualTo(Integer value) {
            addCriterion("agency_level <=", value, "agencyLevel");
            return (Criteria) this;
        }

        public Criteria andAgencyLevelIn(List<Integer> values) {
            addCriterion("agency_level in", values, "agencyLevel");
            return (Criteria) this;
        }

        public Criteria andAgencyLevelNotIn(List<Integer> values) {
            addCriterion("agency_level not in", values, "agencyLevel");
            return (Criteria) this;
        }

        public Criteria andAgencyLevelBetween(Integer value1, Integer value2) {
            addCriterion("agency_level between", value1, value2, "agencyLevel");
            return (Criteria) this;
        }

        public Criteria andAgencyLevelNotBetween(Integer value1, Integer value2) {
            addCriterion("agency_level not between", value1, value2, "agencyLevel");
            return (Criteria) this;
        }

        public Criteria andDistributionRatioIsNull() {
            addCriterion("distribution_ratio is null");
            return (Criteria) this;
        }

        public Criteria andDistributionRatioIsNotNull() {
            addCriterion("distribution_ratio is not null");
            return (Criteria) this;
        }

        public Criteria andDistributionRatioEqualTo(Float value) {
            addCriterion("distribution_ratio =", value, "distributionRatio");
            return (Criteria) this;
        }

        public Criteria andDistributionRatioNotEqualTo(Float value) {
            addCriterion("distribution_ratio <>", value, "distributionRatio");
            return (Criteria) this;
        }

        public Criteria andDistributionRatioGreaterThan(Float value) {
            addCriterion("distribution_ratio >", value, "distributionRatio");
            return (Criteria) this;
        }

        public Criteria andDistributionRatioGreaterThanOrEqualTo(Float value) {
            addCriterion("distribution_ratio >=", value, "distributionRatio");
            return (Criteria) this;
        }

        public Criteria andDistributionRatioLessThan(Float value) {
            addCriterion("distribution_ratio <", value, "distributionRatio");
            return (Criteria) this;
        }

        public Criteria andDistributionRatioLessThanOrEqualTo(Float value) {
            addCriterion("distribution_ratio <=", value, "distributionRatio");
            return (Criteria) this;
        }

        public Criteria andDistributionRatioIn(List<Float> values) {
            addCriterion("distribution_ratio in", values, "distributionRatio");
            return (Criteria) this;
        }

        public Criteria andDistributionRatioNotIn(List<Float> values) {
            addCriterion("distribution_ratio not in", values, "distributionRatio");
            return (Criteria) this;
        }

        public Criteria andDistributionRatioBetween(Float value1, Float value2) {
            addCriterion("distribution_ratio between", value1, value2, "distributionRatio");
            return (Criteria) this;
        }

        public Criteria andDistributionRatioNotBetween(Float value1, Float value2) {
            addCriterion("distribution_ratio not between", value1, value2, "distributionRatio");
            return (Criteria) this;
        }

        public Criteria andOfflineNumberIsNull() {
            addCriterion("offline_number is null");
            return (Criteria) this;
        }

        public Criteria andOfflineNumberIsNotNull() {
            addCriterion("offline_number is not null");
            return (Criteria) this;
        }

        public Criteria andOfflineNumberEqualTo(Integer value) {
            addCriterion("offline_number =", value, "offlineNumber");
            return (Criteria) this;
        }

        public Criteria andOfflineNumberNotEqualTo(Integer value) {
            addCriterion("offline_number <>", value, "offlineNumber");
            return (Criteria) this;
        }

        public Criteria andOfflineNumberGreaterThan(Integer value) {
            addCriterion("offline_number >", value, "offlineNumber");
            return (Criteria) this;
        }

        public Criteria andOfflineNumberGreaterThanOrEqualTo(Integer value) {
            addCriterion("offline_number >=", value, "offlineNumber");
            return (Criteria) this;
        }

        public Criteria andOfflineNumberLessThan(Integer value) {
            addCriterion("offline_number <", value, "offlineNumber");
            return (Criteria) this;
        }

        public Criteria andOfflineNumberLessThanOrEqualTo(Integer value) {
            addCriterion("offline_number <=", value, "offlineNumber");
            return (Criteria) this;
        }

        public Criteria andOfflineNumberIn(List<Integer> values) {
            addCriterion("offline_number in", values, "offlineNumber");
            return (Criteria) this;
        }

        public Criteria andOfflineNumberNotIn(List<Integer> values) {
            addCriterion("offline_number not in", values, "offlineNumber");
            return (Criteria) this;
        }

        public Criteria andOfflineNumberBetween(Integer value1, Integer value2) {
            addCriterion("offline_number between", value1, value2, "offlineNumber");
            return (Criteria) this;
        }

        public Criteria andOfflineNumberNotBetween(Integer value1, Integer value2) {
            addCriterion("offline_number not between", value1, value2, "offlineNumber");
            return (Criteria) this;
        }

        public Criteria andSalesChannelsIdIsNull() {
            addCriterion("sales_channels_id is null");
            return (Criteria) this;
        }

        public Criteria andSalesChannelsIdIsNotNull() {
            addCriterion("sales_channels_id is not null");
            return (Criteria) this;
        }

        public Criteria andSalesChannelsIdEqualTo(String value) {
            addCriterion("sales_channels_id =", value, "salesChannelsId");
            return (Criteria) this;
        }

        public Criteria andSalesChannelsIdNotEqualTo(String value) {
            addCriterion("sales_channels_id <>", value, "salesChannelsId");
            return (Criteria) this;
        }

        public Criteria andSalesChannelsIdGreaterThan(String value) {
            addCriterion("sales_channels_id >", value, "salesChannelsId");
            return (Criteria) this;
        }

        public Criteria andSalesChannelsIdGreaterThanOrEqualTo(String value) {
            addCriterion("sales_channels_id >=", value, "salesChannelsId");
            return (Criteria) this;
        }

        public Criteria andSalesChannelsIdLessThan(String value) {
            addCriterion("sales_channels_id <", value, "salesChannelsId");
            return (Criteria) this;
        }

        public Criteria andSalesChannelsIdLessThanOrEqualTo(String value) {
            addCriterion("sales_channels_id <=", value, "salesChannelsId");
            return (Criteria) this;
        }

        public Criteria andSalesChannelsIdLike(String value) {
            addCriterion("sales_channels_id like", value, "salesChannelsId");
            return (Criteria) this;
        }

        public Criteria andSalesChannelsIdNotLike(String value) {
            addCriterion("sales_channels_id not like", value, "salesChannelsId");
            return (Criteria) this;
        }

        public Criteria andSalesChannelsIdIn(List<String> values) {
            addCriterion("sales_channels_id in", values, "salesChannelsId");
            return (Criteria) this;
        }

        public Criteria andSalesChannelsIdNotIn(List<String> values) {
            addCriterion("sales_channels_id not in", values, "salesChannelsId");
            return (Criteria) this;
        }

        public Criteria andSalesChannelsIdBetween(String value1, String value2) {
            addCriterion("sales_channels_id between", value1, value2, "salesChannelsId");
            return (Criteria) this;
        }

        public Criteria andSalesChannelsIdNotBetween(String value1, String value2) {
            addCriterion("sales_channels_id not between", value1, value2, "salesChannelsId");
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

        public Criteria andProxyEmailIsNull() {
            addCriterion("proxy_email is null");
            return (Criteria) this;
        }

        public Criteria andProxyEmailIsNotNull() {
            addCriterion("proxy_email is not null");
            return (Criteria) this;
        }

        public Criteria andProxyEmailEqualTo(String value) {
            addCriterion("proxy_email =", value, "proxyEmail");
            return (Criteria) this;
        }

        public Criteria andProxyEmailNotEqualTo(String value) {
            addCriterion("proxy_email <>", value, "proxyEmail");
            return (Criteria) this;
        }

        public Criteria andProxyEmailGreaterThan(String value) {
            addCriterion("proxy_email >", value, "proxyEmail");
            return (Criteria) this;
        }

        public Criteria andProxyEmailGreaterThanOrEqualTo(String value) {
            addCriterion("proxy_email >=", value, "proxyEmail");
            return (Criteria) this;
        }

        public Criteria andProxyEmailLessThan(String value) {
            addCriterion("proxy_email <", value, "proxyEmail");
            return (Criteria) this;
        }

        public Criteria andProxyEmailLessThanOrEqualTo(String value) {
            addCriterion("proxy_email <=", value, "proxyEmail");
            return (Criteria) this;
        }

        public Criteria andProxyEmailLike(String value) {
            addCriterion("proxy_email like", value, "proxyEmail");
            return (Criteria) this;
        }

        public Criteria andProxyEmailNotLike(String value) {
            addCriterion("proxy_email not like", value, "proxyEmail");
            return (Criteria) this;
        }

        public Criteria andProxyEmailIn(List<String> values) {
            addCriterion("proxy_email in", values, "proxyEmail");
            return (Criteria) this;
        }

        public Criteria andProxyEmailNotIn(List<String> values) {
            addCriterion("proxy_email not in", values, "proxyEmail");
            return (Criteria) this;
        }

        public Criteria andProxyEmailBetween(String value1, String value2) {
            addCriterion("proxy_email between", value1, value2, "proxyEmail");
            return (Criteria) this;
        }

        public Criteria andProxyEmailNotBetween(String value1, String value2) {
            addCriterion("proxy_email not between", value1, value2, "proxyEmail");
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
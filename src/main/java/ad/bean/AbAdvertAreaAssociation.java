package ad.bean;

import java.util.Date;

public class AbAdvertAreaAssociation {
    private Integer id;

    private Integer adverId;

    private String provinceCode;

    private Integer areaGrade;

    private Date createTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getAdverId() {
        return adverId;
    }

    public void setAdverId(Integer adverId) {
        this.adverId = adverId;
    }

    public String getProvinceCode() {
        return provinceCode;
    }

    public void setProvinceCode(String provinceCode) {
        this.provinceCode = provinceCode == null ? null : provinceCode.trim();
    }

    public Integer getAreaGrade() {
        return areaGrade;
    }

    public void setAreaGrade(Integer areaGrade) {
        this.areaGrade = areaGrade;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
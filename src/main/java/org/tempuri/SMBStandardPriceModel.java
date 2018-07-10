
package org.tempuri;

import java.math.BigDecimal;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>SMBStandardPriceModel complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="SMBStandardPriceModel"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="BOMCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="ActualCostPrice" type="{http://www.w3.org/2001/XMLSchema}decimal"/&gt;
 *         &lt;element name="BOCostPrice" type="{http://www.w3.org/2001/XMLSchema}decimal"/&gt;
 *         &lt;element name="CostSupportPrice" type="{http://www.w3.org/2001/XMLSchema}decimal"/&gt;
 *         &lt;element name="StrictControlPrice" type="{http://www.w3.org/2001/XMLSchema}decimal"/&gt;
 *         &lt;element name="SalesManagerPrice" type="{http://www.w3.org/2001/XMLSchema}decimal"/&gt;
 *         &lt;element name="SaleCostPrice" type="{http://www.w3.org/2001/XMLSchema}decimal"/&gt;
 *         &lt;element name="AgentPrice" type="{http://www.w3.org/2001/XMLSchema}decimal"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SMBStandardPriceModel", propOrder = {
    "bomCode",
    "actualCostPrice",
    "boCostPrice",
    "costSupportPrice",
    "strictControlPrice",
    "salesManagerPrice",
    "saleCostPrice",
    "agentPrice"
})
public class SMBStandardPriceModel {

    @XmlElement(name = "BOMCode")
    protected String bomCode;
    @XmlElement(name = "ActualCostPrice", required = true)
    protected BigDecimal actualCostPrice;
    @XmlElement(name = "BOCostPrice", required = true)
    protected BigDecimal boCostPrice;
    @XmlElement(name = "CostSupportPrice", required = true)
    protected BigDecimal costSupportPrice;
    @XmlElement(name = "StrictControlPrice", required = true)
    protected BigDecimal strictControlPrice;
    @XmlElement(name = "SalesManagerPrice", required = true)
    protected BigDecimal salesManagerPrice;
    @XmlElement(name = "SaleCostPrice", required = true)
    protected BigDecimal saleCostPrice;
    @XmlElement(name = "AgentPrice", required = true)
    protected BigDecimal agentPrice;

    /**
     * 获取bomCode属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBOMCode() {
        return bomCode;
    }

    /**
     * 设置bomCode属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBOMCode(String value) {
        this.bomCode = value;
    }

    /**
     * 获取actualCostPrice属性的值。
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getActualCostPrice() {
        return actualCostPrice;
    }

    /**
     * 设置actualCostPrice属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setActualCostPrice(BigDecimal value) {
        this.actualCostPrice = value;
    }

    /**
     * 获取boCostPrice属性的值。
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getBOCostPrice() {
        return boCostPrice;
    }

    /**
     * 设置boCostPrice属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setBOCostPrice(BigDecimal value) {
        this.boCostPrice = value;
    }

    /**
     * 获取costSupportPrice属性的值。
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getCostSupportPrice() {
        return costSupportPrice;
    }

    /**
     * 设置costSupportPrice属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setCostSupportPrice(BigDecimal value) {
        this.costSupportPrice = value;
    }

    /**
     * 获取strictControlPrice属性的值。
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getStrictControlPrice() {
        return strictControlPrice;
    }

    /**
     * 设置strictControlPrice属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setStrictControlPrice(BigDecimal value) {
        this.strictControlPrice = value;
    }

    /**
     * 获取salesManagerPrice属性的值。
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getSalesManagerPrice() {
        return salesManagerPrice;
    }

    /**
     * 设置salesManagerPrice属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setSalesManagerPrice(BigDecimal value) {
        this.salesManagerPrice = value;
    }

    /**
     * 获取saleCostPrice属性的值。
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getSaleCostPrice() {
        return saleCostPrice;
    }

    /**
     * 设置saleCostPrice属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setSaleCostPrice(BigDecimal value) {
        this.saleCostPrice = value;
    }

    /**
     * 获取agentPrice属性的值。
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getAgentPrice() {
        return agentPrice;
    }

    /**
     * 设置agentPrice属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setAgentPrice(BigDecimal value) {
        this.agentPrice = value;
    }

}


package org.tempuri;

import java.math.BigDecimal;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>SMBStandardPriceModel complex type�� Java �ࡣ
 * 
 * <p>����ģʽƬ��ָ�������ڴ����е�Ԥ�����ݡ�
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
     * ��ȡbomCode���Ե�ֵ��
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
     * ����bomCode���Ե�ֵ��
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
     * ��ȡactualCostPrice���Ե�ֵ��
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
     * ����actualCostPrice���Ե�ֵ��
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
     * ��ȡboCostPrice���Ե�ֵ��
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
     * ����boCostPrice���Ե�ֵ��
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
     * ��ȡcostSupportPrice���Ե�ֵ��
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
     * ����costSupportPrice���Ե�ֵ��
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
     * ��ȡstrictControlPrice���Ե�ֵ��
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
     * ����strictControlPrice���Ե�ֵ��
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
     * ��ȡsalesManagerPrice���Ե�ֵ��
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
     * ����salesManagerPrice���Ե�ֵ��
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
     * ��ȡsaleCostPrice���Ե�ֵ��
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
     * ����saleCostPrice���Ե�ֵ��
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
     * ��ȡagentPrice���Ե�ֵ��
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
     * ����agentPrice���Ե�ֵ��
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

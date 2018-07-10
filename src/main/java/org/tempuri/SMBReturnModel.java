
package org.tempuri;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>SMBReturnModel complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="SMBReturnModel"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="returnFlag" type="{http://www.w3.org/2001/XMLSchema}boolean"/&gt;
 *         &lt;element name="returnMsg" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="standardPriceList" type="{http://tempuri.org/}ArrayOfSMBStandardPriceModel" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SMBReturnModel", propOrder = {
    "returnFlag",
    "returnMsg",
    "standardPriceList"
})
public class SMBReturnModel {

    protected boolean returnFlag;
    protected String returnMsg;
    protected ArrayOfSMBStandardPriceModel standardPriceList;

    /**
     * 获取returnFlag属性的值。
     * 
     */
    public boolean isReturnFlag() {
        return returnFlag;
    }

    /**
     * 设置returnFlag属性的值。
     * 
     */
    public void setReturnFlag(boolean value) {
        this.returnFlag = value;
    }

    /**
     * 获取returnMsg属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getReturnMsg() {
        return returnMsg;
    }

    /**
     * 设置returnMsg属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setReturnMsg(String value) {
        this.returnMsg = value;
    }

    /**
     * 获取standardPriceList属性的值。
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfSMBStandardPriceModel }
     *     
     */
    public ArrayOfSMBStandardPriceModel getStandardPriceList() {
        return standardPriceList;
    }

    /**
     * 设置standardPriceList属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfSMBStandardPriceModel }
     *     
     */
    public void setStandardPriceList(ArrayOfSMBStandardPriceModel value) {
        this.standardPriceList = value;
    }

}

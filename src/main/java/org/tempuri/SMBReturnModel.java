
package org.tempuri;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>SMBReturnModel complex type�� Java �ࡣ
 * 
 * <p>����ģʽƬ��ָ�������ڴ����е�Ԥ�����ݡ�
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
     * ��ȡreturnFlag���Ե�ֵ��
     * 
     */
    public boolean isReturnFlag() {
        return returnFlag;
    }

    /**
     * ����returnFlag���Ե�ֵ��
     * 
     */
    public void setReturnFlag(boolean value) {
        this.returnFlag = value;
    }

    /**
     * ��ȡreturnMsg���Ե�ֵ��
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
     * ����returnMsg���Ե�ֵ��
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
     * ��ȡstandardPriceList���Ե�ֵ��
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
     * ����standardPriceList���Ե�ֵ��
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

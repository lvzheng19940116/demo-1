
package org.tempuri;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>anonymous complex type�� Java �ࡣ
 * 
 * <p>����ģʽƬ��ָ�������ڴ����е�Ԥ�����ݡ�
 * 
 * <pre>
 * &lt;complexType&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="GetSMBStandardPriceListResult" type="{http://tempuri.org/}SMBReturnModel" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "getSMBStandardPriceListResult"
})
@XmlRootElement(name = "GetSMBStandardPriceListResponse")
public class GetSMBStandardPriceListResponse {

    @XmlElement(name = "GetSMBStandardPriceListResult")
    protected SMBReturnModel getSMBStandardPriceListResult;

    /**
     * ��ȡgetSMBStandardPriceListResult���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link SMBReturnModel }
     *     
     */
    public SMBReturnModel getGetSMBStandardPriceListResult() {
        return getSMBStandardPriceListResult;
    }

    /**
     * ����getSMBStandardPriceListResult���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link SMBReturnModel }
     *     
     */
    public void setGetSMBStandardPriceListResult(SMBReturnModel value) {
        this.getSMBStandardPriceListResult = value;
    }

}

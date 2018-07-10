
package org.tempuri;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>ArrayOfSMBParameterModel complex type�� Java �ࡣ
 * 
 * <p>����ģʽƬ��ָ�������ڴ����е�Ԥ�����ݡ�
 * 
 * <pre>
 * &lt;complexType name="ArrayOfSMBParameterModel"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="SMBParameterModel" type="{http://tempuri.org/}SMBParameterModel" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ArrayOfSMBParameterModel", propOrder = {
    "smbParameterModel"
})
public class ArrayOfSMBParameterModel {

    @XmlElement(name = "SMBParameterModel", nillable = true)
    protected List<SMBParameterModel> smbParameterModel;

    /**
     * Gets the value of the smbParameterModel property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the smbParameterModel property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getSMBParameterModel().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link SMBParameterModel }
     * 
     * 
     */
    public List<SMBParameterModel> getSMBParameterModel() {
        if (smbParameterModel == null) {
            smbParameterModel = new ArrayList<SMBParameterModel>();
        }
        return this.smbParameterModel;
    }

    public void setSmbParameterModel(List<SMBParameterModel> smbParameterModel) {
        this.smbParameterModel = smbParameterModel;
    }

}

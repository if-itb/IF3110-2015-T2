
package webservice;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for voteAnswer complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="voteAnswer"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="aid" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="uid" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="value" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "voteAnswer", propOrder = {
    "aid",
    "uid",
    "value"
})
public class VoteAnswer {

    protected int aid;
    protected int uid;
    protected String value;

    /**
     * Gets the value of the aid property.
     * 
     */
    public int getAid() {
        return aid;
    }

    /**
     * Sets the value of the aid property.
     * 
     */
    public void setAid(int value) {
        this.aid = value;
    }

    /**
     * Gets the value of the uid property.
     * 
     */
    public int getUid() {
        return uid;
    }

    /**
     * Sets the value of the uid property.
     * 
     */
    public void setUid(int value) {
        this.uid = value;
    }

    /**
     * Gets the value of the value property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getValue() {
        return value;
    }

    /**
     * Sets the value of the value property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setValue(String value) {
        this.value = value;
    }

}

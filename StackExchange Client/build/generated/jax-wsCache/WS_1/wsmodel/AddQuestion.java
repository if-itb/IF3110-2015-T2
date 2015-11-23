
package wsmodel;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for addQuestion complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="addQuestion"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="questionTitle" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="questionContent" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="voteQuestion" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="questionDate" type="{http://WSModel/}date" minOccurs="0"/&gt;
 *         &lt;element name="userID" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "addQuestion", propOrder = {
    "questionTitle",
    "questionContent",
    "voteQuestion",
    "questionDate",
    "userID"
})
public class AddQuestion {

    protected String questionTitle;
    protected String questionContent;
    protected int voteQuestion;
    protected Date questionDate;
    protected int userID;

    /**
     * Gets the value of the questionTitle property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getQuestionTitle() {
        return questionTitle;
    }

    /**
     * Sets the value of the questionTitle property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setQuestionTitle(String value) {
        this.questionTitle = value;
    }

    /**
     * Gets the value of the questionContent property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getQuestionContent() {
        return questionContent;
    }

    /**
     * Sets the value of the questionContent property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setQuestionContent(String value) {
        this.questionContent = value;
    }

    /**
     * Gets the value of the voteQuestion property.
     * 
     */
    public int getVoteQuestion() {
        return voteQuestion;
    }

    /**
     * Sets the value of the voteQuestion property.
     * 
     */
    public void setVoteQuestion(int value) {
        this.voteQuestion = value;
    }

    /**
     * Gets the value of the questionDate property.
     * 
     * @return
     *     possible object is
     *     {@link Date }
     *     
     */
    public Date getQuestionDate() {
        return questionDate;
    }

    /**
     * Sets the value of the questionDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link Date }
     *     
     */
    public void setQuestionDate(Date value) {
        this.questionDate = value;
    }

    /**
     * Gets the value of the userID property.
     * 
     */
    public int getUserID() {
        return userID;
    }

    /**
     * Sets the value of the userID property.
     * 
     */
    public void setUserID(int value) {
        this.userID = value;
    }

}

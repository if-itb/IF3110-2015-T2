
package wsmodel;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for addAnswer complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="addAnswer"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="question_id" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="answerContent" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="answerVote" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
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
@XmlType(name = "addAnswer", propOrder = {
    "questionId",
    "answerContent",
    "answerVote",
    "userID"
})
public class AddAnswer {

    @XmlElement(name = "question_id")
    protected int questionId;
    protected String answerContent;
    protected int answerVote;
    protected int userID;

    /**
     * Gets the value of the questionId property.
     * 
     */
    public int getQuestionId() {
        return questionId;
    }

    /**
     * Sets the value of the questionId property.
     * 
     */
    public void setQuestionId(int value) {
        this.questionId = value;
    }

    /**
     * Gets the value of the answerContent property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAnswerContent() {
        return answerContent;
    }

    /**
     * Sets the value of the answerContent property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAnswerContent(String value) {
        this.answerContent = value;
    }

    /**
     * Gets the value of the answerVote property.
     * 
     */
    public int getAnswerVote() {
        return answerVote;
    }

    /**
     * Sets the value of the answerVote property.
     * 
     */
    public void setAnswerVote(int value) {
        this.answerVote = value;
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

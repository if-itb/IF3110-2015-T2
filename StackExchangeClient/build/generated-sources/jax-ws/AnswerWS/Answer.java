
package AnswerWS;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for answer complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="answer"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="id_question" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="vote" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="content" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="date" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="username" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "answer", propOrder = {
    "id",
    "idQuestion",
    "vote",
    "content",
    "date",
    "username"
})
public class Answer {

    protected int id;
    @XmlElement(name = "id_question")
    protected int idQuestion;
    protected int vote;
    @XmlElement(required = true)
    protected String content;
    @XmlElement(required = true)
    protected String date;
    @XmlElement(required = true)
    protected String username;

    /**
     * Gets the value of the id property.
     * 
     */
    public int getId() {
        return id;
    }

    /**
     * Sets the value of the id property.
     * 
     */
    public void setId(int value) {
        this.id = value;
    }

    /**
     * Gets the value of the idQuestion property.
     * 
     */
    public int getIdQuestion() {
        return idQuestion;
    }

    /**
     * Sets the value of the idQuestion property.
     * 
     */
    public void setIdQuestion(int value) {
        this.idQuestion = value;
    }

    /**
     * Gets the value of the vote property.
     * 
     */
    public int getVote() {
        return vote;
    }

    /**
     * Sets the value of the vote property.
     * 
     */
    public void setVote(int value) {
        this.vote = value;
    }

    /**
     * Gets the value of the content property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getContent() {
        return content;
    }

    /**
     * Sets the value of the content property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setContent(String value) {
        this.content = value;
    }

    /**
     * Gets the value of the date property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDate() {
        return date;
    }

    /**
     * Sets the value of the date property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDate(String value) {
        this.date = value;
    }

    /**
     * Gets the value of the username property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUsername() {
        return username;
    }

    /**
     * Sets the value of the username property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUsername(String value) {
        this.username = value;
    }

}

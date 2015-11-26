
package StackExchangeWS.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "insertQuestion", namespace = "http://StackExchangeWS/")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "insertQuestion", namespace = "http://StackExchangeWS/", propOrder = {
    "token",
    "userId",
    "topic",
    "content"
})
public class InsertQuestion {

    @XmlElement(name = "token", namespace = "")
    private String token;
    @XmlElement(name = "userId", namespace = "")
    private int userId;
    @XmlElement(name = "topic", namespace = "")
    private String topic;
    @XmlElement(name = "content", namespace = "")
    private String content;

    /**
     * 
     * @return
     *     returns String
     */
    public String getToken() {
        return this.token;
    }

    /**
     * 
     * @param token
     *     the value for the token property
     */
    public void setToken(String token) {
        this.token = token;
    }

    /**
     * 
     * @return
     *     returns int
     */
    public int getUserId() {
        return this.userId;
    }

    /**
     * 
     * @param userId
     *     the value for the userId property
     */
    public void setUserId(int userId) {
        this.userId = userId;
    }

    /**
     * 
     * @return
     *     returns String
     */
    public String getTopic() {
        return this.topic;
    }

    /**
     * 
     * @param topic
     *     the value for the topic property
     */
    public void setTopic(String topic) {
        this.topic = topic;
    }

    /**
     * 
     * @return
     *     returns String
     */
    public String getContent() {
        return this.content;
    }

    /**
     * 
     * @param content
     *     the value for the content property
     */
    public void setContent(String content) {
        this.content = content;
    }

}

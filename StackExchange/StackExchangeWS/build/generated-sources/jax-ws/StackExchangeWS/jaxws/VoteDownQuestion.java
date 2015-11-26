
package StackExchangeWS.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "voteDownQuestion", namespace = "http://StackExchangeWS/")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "voteDownQuestion", namespace = "http://StackExchangeWS/", propOrder = {
    "token",
    "userId",
    "id"
})
public class VoteDownQuestion {

    @XmlElement(name = "token", namespace = "")
    private String token;
    @XmlElement(name = "userId", namespace = "")
    private int userId;
    @XmlElement(name = "id", namespace = "")
    private int id;

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
     *     returns int
     */
    public int getId() {
        return this.id;
    }

    /**
     * 
     * @param id
     *     the value for the id property
     */
    public void setId(int id) {
        this.id = id;
    }

}

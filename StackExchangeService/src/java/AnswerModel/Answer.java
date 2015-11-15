package AnswerModel;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="Answer")  // nama elemen SOAP
public class Answer {
    
    @XmlElement(name="id", required=true)
    private int id;
    @XmlElement(name="id_question", required=true)
    private int id_question;
    @XmlElement(name="vote", required=true)
    private int vote;
    @XmlElement(name="content", required=true)
    private String content;
    @XmlElement(name="date", required=true)
    private String date;
    @XmlElement(name="username", required=true)
    private String username;
    
    public Answer() {
        id = 0;
        id_question = 0;
        vote = 0;
    }
    
    public Answer(int id, int id_question, int vote, String content, String date, String username) {
        this.id = id;
        this.id_question = id_question;
        this.vote = vote;
        this.content = content;
        this.date = date;
        this.username = username;
    }
    
    public String getContent() {
        return content;
    }

}

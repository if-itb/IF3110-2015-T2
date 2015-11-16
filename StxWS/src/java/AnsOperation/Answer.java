/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AnsOperation;

import javax.xml.bind.annotation.*;

/**
 *
 * @author Muhtar Hartopo
 */
@XmlRootElement(name = "Answer")
public class Answer {
        @XmlElement(name = "Ansid", required = true)
	private int id;
        @XmlElement(name = "Ansqid", required = true)
	private int qid;
        @XmlElement(name = "Ansname", required = true)
	private String name;
        @XmlElement(name = "Ansemail", required = true)
	private String email;
        @XmlElement(name = "Anscontent", required = true)
	private String content;
        @XmlElement(name = "Ansvote", required = true)
	private int vote;
	
        public Answer() {
            id = 0;
            qid = 0;
            name = "";
            email = "empty@emp.ty";
            content = "";
            vote = 0;
        }
	public Answer(int _id, int _qid, String _nama, String _email, String _konten, int _vote) {
		id = _id;
		qid = _qid;
		name = _nama;
		email = _email;
		content = _konten;
		vote = _vote;
	}
	
	public int getId() {
		return id;
	}
	
	public String getNama() {
		return name;
	}
	public String getEmail() {
		return email;
	}
	public String getKonten() {
		return content;
	}
	public int getVote() {
		return vote;
	}

	public int getQid() {
		return qid;
	}
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AnsOperation;

/**
 *
 * @author Muhtar Hartopo
 */
public class Answer {
	private int id;
	private int qid;
	private String nama;
	private String email;
	private String konten;
	private int vote;
	
        public Answer() {
            id = 0;
            qid = 0;
            nama = "";
            email = "empty@emp.ty";
            konten = "";
            vote = 0;
        }
	public Answer(int _id, int _qid, String _nama, String _email, String _konten, int _vote) {
		id = _id;
		qid = _qid;
		nama = _nama;
		email = _email;
		konten = _konten;
		vote = _vote;
	}
	
	public int getId() {
		return id;
	}
	
	public String getNama() {
		return nama;
	}
	public void setNama(String nama) {
		this.nama = nama;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getKonten() {
		return konten;
	}
	public void setKonten(String konten) {
		this.konten = konten;
	}
	public int getVote() {
		return vote;
	}
	public void setVote(int vote) {
		this.vote = vote;
	}

	public int getQid() {
		return qid;
	}

	public void setQid(int qid) {
		this.qid = qid;
	}
	
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wbd.ans;

import javax.xml.bind.*;
import javax.xml.bind.annotation.*;

@XmlRootElement(name = "Answer")
/**
 *
 * @author User
 */
public class Answer {
    @XmlElement(name = "IDAns", required = true)
    private int idans;
    @XmlElement(name = "IDQ", required = true)
    private int idq;
    @XmlElement(name = "Nama", required = true)
    private String nama;
    @XmlElement(name = "Email", required = true)
    private String email;
    @XmlElement(name = "Answer", required = true)
    private String answer;
    
    public Answer(){
        idans = 0;
        idq = 0;
    }
    
    public Answer(int idA, int qid, String name, String alamatemail, String isi){
        idans = idA;
        idq = qid;
        nama = name;
        email = alamatemail;
        answer = isi;
    }
}

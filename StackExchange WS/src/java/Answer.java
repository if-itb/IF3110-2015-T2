package StackExchange;

import java.sql.Timestamp;

public class Answer {
    
    public int id;
    public int id_question;
	public int id_user;
    public String content;
    public Timestamp timepost;
    
    public Answer(int _id, int _id_question,  int _id_user, String _content, Timestamp _timepost){
        id=_id;
        id_question=_id_question;
        id_user=_id_user;
        content=_content;
        timepost=_timepost;
    }
}

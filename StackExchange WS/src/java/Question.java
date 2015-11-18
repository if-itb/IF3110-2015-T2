package StackExchange;

import java.sql.timestamp;

public class Question {
    public int id;
    public int id_user;
    public String topic;
	public String content;
    public Timestamp timepost;
  
    public Question(){
        id=0;
        id_user=0;
        topic=null;
        content=null;
		timepost=null;
    }
    
    public Question(int _id, int _id_user, String _topic, String content, Timestamp _timepost){
        id=_id;
        id_user=_id_user;
        topic=_topic;
		content=_content;
        timestamp=_timepost;
    }
    
    public void setQuestion(int _id, int _id_user, String _topic, String _content, Timestamp _timepost){
        id=_id;
        id_user=_id_user;
        topic=_topic;
        content=_content;
		timepost=_timepost;
    }
}

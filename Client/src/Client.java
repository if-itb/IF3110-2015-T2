import com.yangnormal.sstackex.Question;
import com.yangnormal.sstackex.WebServiceImplService;
import com.yangnormal.sstackex.WebServiceInterface;

public class Client{
    public static void main(String[] args) {
        WebServiceImplService webService = new WebServiceImplService();
        WebServiceInterface wsi = webService.getWebServiceImplPort();
        System.out.println("getQuestionList Test");
        for (int i=0;i<wsi.getQuestionList().getItem().size();i++){
            System.out.println(wsi.getQuestionList().getItem().get(i).getItem().toString());
        }
        System.out.println("getAnswerList Test");
        for (int i=0;i<wsi.getAnswerList(1).getItem().size();i++) {
            System.out.println(wsi.getAnswerList(1).getItem().get(i).getItem().toString());
        }
        Question q = new Question();
        System.out.println("register Test");
        System.out.println(wsi.register("john", "john@j.com", "abc"));
        System.out.println("Post Question Test");
        wsi.postQuestion(2,"a","HAHA","a@a.com", "HAHAHAHAHA");
        System.out.println("Post Answer");
        wsi.postAnswer(1,1,"a","a@a.com", "HAHAHAHAHA");
        System.out.println("Vote Question Up Test");
        wsi.vote(0,1,1,1);
        System.out.println("Vote Question Down Test");
        wsi.vote(0,1,-1,2);
        System.out.println("Vote Answer Up Test");
        wsi.vote(1,1,1,1);
        System.out.println("Vote Answer Down Test");
        wsi.vote(1,1,-1,2);
        System.out.println("getQuestion Array Test");
        System.out.println(wsi.getQuestionArray(1).getItem().toString());
        System.out.println("getQuestion (object)test");
        q = wsi.getQuestion(1);
        System.out.println(q.getAnswerSum());
        System.out.println("Delete Question Test");
        wsi.deleteQuestion(3, "a");



    }
}
import com.yangnormal.sstackex.Question;
import com.yangnormal.sstackex.WebServiceImplService;
import com.yangnormal.sstackex.WebServiceInterface;

public class Client{
    public static void main(String[] args) {
        WebServiceImplService webService = new WebServiceImplService();
        WebServiceInterface wsi = webService.getWebServiceImplPort();
        System.out.println("getQuestionList Test");
        Question q = new Question();
        q = wsi.getQuestion(1);
        System.out.println(q.getAnswerSum());
    }
}
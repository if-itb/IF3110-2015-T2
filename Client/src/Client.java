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
    }
}
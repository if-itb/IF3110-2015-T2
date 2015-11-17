import com.yangnormal.sstackex.WebServiceImplService;
import com.yangnormal.sstackex.WebServiceInterface;

public class Client{
    public static void main(String[] args) {
        WebServiceImplService webService = new WebServiceImplService();
        WebServiceInterface wsi = webService.getWebServiceImplPort();
        for (int i=0;i<wsi.getQuestionList().getItem().size();i++){
            System.out.println(i);
            System.out.println(wsi.getQuestionList().getItem().get(i).getItem().toString());
        }
    }

}
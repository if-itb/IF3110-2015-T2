package util;

import java.net.*;
import java.io.*;
import java.util.*;
import org.json.JSONArray;
import org.json.JSONObject;

/**
 * Created by elvan_owen on 11/17/15.
 */
public class HttpRequest {
    public static String executeGET(String targetURL) throws IOException{
        URL yahoo = new URL(targetURL);
        URLConnection yc = yahoo.openConnection();
        BufferedReader in = new BufferedReader(
                new InputStreamReader(
                        yc.getInputStream()));
        String inputLine;
        String res = "";

        while ((inputLine = in.readLine()) != null)
            res += inputLine;

        return res;
    }

    public static String executeMethod(String method, HashMap<String, String> data) throws IOException{
        URL url;
        URLConnection urlConn;
        DataOutputStream cgiInput;

        // URL of target page script.
        url = new URL("http://localhost:9000/StackxWS/ws");
        urlConn = url.openConnection();

        urlConn.setDoInput(true);
        urlConn.setDoOutput(true);
        urlConn.setUseCaches(false);
        urlConn.setRequestProperty("Content-Type", "text/xml");

        // Send POST output.
        cgiInput = new DataOutputStream(urlConn.getOutputStream());

        Iterator it = data.entrySet().iterator();
        String params = "";

        while (it.hasNext()) {
            Map.Entry pair = (Map.Entry)it.next();

            params += "<" + pair.getKey() + ">" + pair.getValue() + "</" + pair.getKey() + ">\n";
        }

        String content = "<?xml version=\"1.0\" encoding=\"UTF-8\"?><S:Envelope xmlns:S=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:SOAP-ENV=\"http://schemas.xmlsoap.org/soap/envelope/\">\n" +
                "    <SOAP-ENV:Header/>\n" +
                "    <S:Body>\n" +
                "        <ns2:" + method + " xmlns:ns2=\"http://stackx.me.org/\">\n" +
                            params +
                "        </ns2:" + method + ">\n" +
                "    </S:Body>\n" +
                "</S:Envelope>";

//        return content;

//        String content = "email=" + URLEncoder.encode(param1) + "&param2=" + URLEncoder.encode(param2);

        cgiInput.writeBytes(content);
        cgiInput.flush();
        cgiInput.close();

        // reads the CGI response and print it inside the servlet content
        BufferedReader cgiOutput =new BufferedReader(new InputStreamReader(urlConn.getInputStream()));

        String line = null;
        String res = "";
        while (null != (line = cgiOutput.readLine())){
            res += line;
        }

        return res;
    }

    public static String executePOST(String targetURL, HashMap<String, String> data) throws IOException{
        URL url;
        URLConnection urlConn;
        DataOutputStream cgiInput;

        // URL of target page script.
        url = new URL("http://localhost:9000/Identity_Service/Request");
        urlConn = url.openConnection();

        urlConn.setDoInput(true);
        urlConn.setDoOutput(true);
        urlConn.setUseCaches(false);
        urlConn.setRequestProperty("Content-Type", "text/xml");

        // Send POST output.
        cgiInput = new DataOutputStream(urlConn.getOutputStream());

        Iterator it = data.entrySet().iterator();
        String body = "";

        JSONObject obj = new JSONObject();

        while (it.hasNext()) {
            Map.Entry pair = (Map.Entry)it.next();

            try{
                obj.put(pair.getKey().toString(), pair.getValue().toString());
            }catch(Exception e){}
        }

        String content = obj.toString();

//        return content;

//        String content = "email=" + URLEncoder.encode(param1) + "&param2=" + URLEncoder.encode(param2);

        cgiInput.writeBytes(content);
        cgiInput.flush();
        cgiInput.close();

        // reads the CGI response and print it inside the servlet content
        BufferedReader cgiOutput =new BufferedReader(new InputStreamReader(urlConn.getInputStream()));

        String line = null;
        String res = "";
        while (null != (line = cgiOutput.readLine())){
            res += line;
        }

        return res;
    }
}

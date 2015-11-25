package com.wbd.tokenChecker;



import com.wbd.tokenChecker.TokenIdentity;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;



public class TokenChecker{



	public TokenIdentity check(String access_token) throws ParseException{
		TokenIdentity ti = new TokenIdentity();
		try{
			DefaultHttpClient httpClient = new DefaultHttpClient();
			HttpPost postRequest = new HttpPost(
				"http://localhost:8081/StackExchange_IS/rest/tokenValidate/");
			
			StringEntity input = new StringEntity("{\"access_token\":\""+access_token+"\"}");
			
			input.setContentType("application/json");
			postRequest.setEntity(input);
			
			HttpResponse response = httpClient.execute(postRequest);
	
			if (response.getStatusLine().getStatusCode() != 200) {
				throw new RuntimeException("Failed : HTTP error code : "
						+ response.getStatusLine().getStatusCode());
			}

			BufferedReader br = new BufferedReader(
				new InputStreamReader((response.getEntity().getContent())));
			
			String output_response;
			int tokenValidity;
			int user_id;
			
			if ((output_response = br.readLine()) != null) {

				JSONParser jsonParser = new JSONParser();
				JSONObject jsonObject = (JSONObject) jsonParser.parse(output_response);

				long tokenValid_long = (long) jsonObject.get("valid");
				tokenValidity = (int) tokenValid_long;
				
				ti.setValid(tokenValidity);
				
				long user_id_long = (long) jsonObject.get("id_user");
				user_id = (int) user_id_long; 
				ti.setIDUser(user_id);
				
			}
			 httpClient.getConnectionManager().shutdown();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return ti;

	}
}
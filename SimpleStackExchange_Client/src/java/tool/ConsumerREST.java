/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tool;

import javax.ws.rs.ClientErrorException;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Form;
import javax.ws.rs.core.MediaType;

/**
 * Jersey REST client generated for REST resource:RegistereduserFacadeREST
 * [user]<br>
 * USAGE:
 * <pre>
 *        ConsumerREST client = new ConsumerREST();
 *        Object response = client.XXX(...);
 *        // do whatever with response
 *        client.close();
 * </pre>
 *
 * @author mfikria
 */
public class ConsumerREST {

    private WebTarget webTarget;
    private Client client;
    private static final String BASE_URI = "http://localhost:8082/SimpleStackExchange_IdentityService/api";
    
    public ConsumerREST() {
        client = javax.ws.rs.client.ClientBuilder.newClient();
        webTarget = client.target(BASE_URI).path("user");
    }
    
    public ConsumerREST(String mode) {
        client = javax.ws.rs.client.ClientBuilder.newClient();
        webTarget = client.target(BASE_URI).path(mode);
    }
    
    public <T> T findByEmail(Class<T> responseType, String email) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("email/{0}", new Object[]{email}));
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_XML).get(responseType);
    }
    
    public String validate(String email, String password) throws ClientErrorException {
        Form form = new Form();
        form.param("email", email);
        form.param("password", password);
        return webTarget.path("validate").request(MediaType.TEXT_PLAIN).post(Entity.entity(form,MediaType.APPLICATION_FORM_URLENCODED_TYPE), String.class);
    }

    public void close() {
        client.close();
    }
}

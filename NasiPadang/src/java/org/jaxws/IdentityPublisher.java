/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.jaxws;

import javax.xml.ws.Endpoint;

/**
 *
 * @author user
 */
public class IdentityPublisher {
    public static void main(String[] args) {
	   Endpoint.publish("http://localhost:8002/ws/stackexchange", new IdentityImpl());
    }
}

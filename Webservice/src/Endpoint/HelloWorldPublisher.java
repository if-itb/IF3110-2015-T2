/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Endpoint;

import javax.xml.ws.Endpoint;
import Webservice.HelloWorldImpl;

/**
 *
 * @author Asus
 */
public class HelloWorldPublisher {
    public static void main(String[] args) {
	   Endpoint.publish("http://localhost:9999/ws/hello", new HelloWorldImpl());
    }
}

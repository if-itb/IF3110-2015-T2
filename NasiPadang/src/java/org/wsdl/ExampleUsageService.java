/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.wsdl;

/**
 *
 * @author user
 */
public class ExampleUsageService {
    public static void main(String args[]){
        StackExchangeImplService stackExchangeService = new StackExchangeImplService();
        org.wsdl.StackExchange stackExchange = stackExchangeService.getStackExchangeImplPort();
        ArrayQuestion allQuestion = stackExchange.getAllQuestion();
        System.out.println(allQuestion.get(0).name);
    }
}

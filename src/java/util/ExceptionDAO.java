/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

/**
 *
 * @author paulohenrique
 */
public class ExceptionDAO extends Exception{
      public ExceptionDAO() {
           // default\r
       }
  
      public ExceptionDAO(String message) {
          super(message);
      }
  
      public ExceptionDAO(Throwable cause) {
          super(cause);
       }
  
       public ExceptionDAO(String message, Throwable cause) {
           super(message, cause);
      }
  
  
   }
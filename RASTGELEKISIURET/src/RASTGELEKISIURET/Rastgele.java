/**
*
* @author Burak 
* @since 07.04.2020
*/
package RASTGELEKISIURET;


public class Rastgele { 
    
    public int Random() 
    {
       
         long nano_startTime = System.nanoTime();
         String a=Long.toString (nano_startTime);
         String rast=a.substring(6,a.length()-2);
         while (rast.length()>9) {            
            rast=rast.substring(1, rast.length());
         }   
         return Integer.valueOf(rast);
    }
}

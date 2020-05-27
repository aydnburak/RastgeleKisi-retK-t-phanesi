/**
*
* @author Burak 
* @since 07.04.2020
*/
package RASTGELEKISIURET;

public class KimlikNo {

    public String tcÜret(){
        Rastgele rastgele=new Rastgele();
        int[] karakterler = new int[11];
        
        karakterler[0]=rastgele.Random()%10;
        while (karakterler[0]==0) {                
                karakterler[0]=rastgele.Random()%10;   
        }
        for (int i = 1; i < 9; i++) {
            karakterler[i]=rastgele.Random()%10;
        }
        int tek=0,cift=0;
        for (int i = 0; i < 9; i++) {
            if ((i+1)%2==1) {
                tek+=karakterler[i];
            }
            if ((i+1)%2==0) {
                cift+=karakterler[i];
            }
        }
        karakterler[9]=((tek*7)-cift)%10;
        karakterler[10]=(tek+cift+karakterler[9])%10;
        String tc="";
        for (int i = 0; i < 11; i++) {
           tc+=Integer.toString(karakterler[i]);
        }
        return tc;
    }
    
    public boolean tcSorgula(String tc){
        int [] tcDizi=new int[11];
        
        if (tc.length()==11) {
            String[] string = tc.split("");
            if (string.length==11) {
                for (int i = 0; i < 11; i++) {
                    tcDizi[i]=Integer.parseInt (string[i]);
                }
                int tek=0,cift=0;
                for (int i = 0; i < 9; i++) {
                    if ((i+1)%2==0) {
                        cift+=tcDizi[i];
                    }
                    if ((i+1)%2==1) {
                        tek+=tcDizi[i];
                    }
                }
                if (((tek*7)-cift)%10==tcDizi[9]) {
                    if ((tek+cift+tcDizi[9])%10==tcDizi[10]) {
                        return true;
                    }else{
                        return false;
                    }
                }else{
                    return false;
                }
            }
            else{
             return false;
            } 
        }
        else{
            return false;
        }
    }
    
    
    
}

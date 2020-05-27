/**
*
* @author Burak 
* @since 07.04.2020
*/

package RASTGELEKISIURET;

public class IMEIno {
    public String imeiUret(){
        Rastgele rastgele=new Rastgele();
        int [] karakterler=new int[15];
        int tekTop=0,ciftTop=0;
        for (int i = 0; i < 14; i++) {
            karakterler[i]=rastgele.Random()%10;
        }
        for (int i = 0; i < 14; i++) {
            if ((i+1)%2==0) {
                int a=karakterler[i]*2;
                if (a>9) {
                    ciftTop+=(a-10)+1;
                }
                if (a<10) {
                    ciftTop+=a;
                }
            }
            if ((i+1)%2==1) {
                tekTop+=karakterler[i];
            }
        }
        int sonSayi=10-((ciftTop+tekTop)%10);
        if (sonSayi==10) {
            karakterler[14]=0;
        }
        else{
            karakterler[14]=sonSayi;
        }
        String imei="";
        for (int i = 0; i < 15; i++) {
           imei+=Integer.toString(karakterler[i]);
        }
        return imei;
    }
    
    public boolean imeiSorgula(String imei){
        int [] imeiDizi=new int[15];
        int tekTop=0,ciftTop=0;
        if (imei.length()==15) {
            
            String[] string = imei.split("");
            if (string.length==15) {
                for (int i = 0; i < 15; i++) {
                    imeiDizi[i]=Integer.parseInt (string[i]);
                }
                for (int i = 0; i < 14; i++) {
                    if ((i+1)%2==0) {
                        int a=imeiDizi[i]*2;
                        if (a<10) {
                            ciftTop+=a;
                        }
                        if (a>9) {
                            ciftTop+=(a-10)+1;
                        }
                    }
                    if ((i+1)%2==1) {
                        tekTop+=imeiDizi[i];
                    }
                }
                int a=10-((ciftTop+tekTop)%10);
                if (a==10) {
                  a=0;
                }
                if (imeiDizi[14]==a) {
                    return true;
                }
                else{
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

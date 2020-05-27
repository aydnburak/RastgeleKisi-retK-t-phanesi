/**
*
* @author Burak 
* @since 07.04.2020
*/
package RASTGELEKISIURET;

public class TelefonNo {
    public String telUret(){
        Rastgele rastgele=new Rastgele();
        int [] telDizi=new int[11];
        telDizi[0]=0;
        telDizi[1]=5;
        telDizi[2]=rastgele.Random()%3+3;
        for (int i = 3; i < 11; i++) {
            telDizi[i]=rastgele.Random()%10;
        }
        String tel="";
        for (int i = 0; i < 11; i++) {
           tel+=Integer.toString(telDizi[i]);
        }
        return tel;
    }
}

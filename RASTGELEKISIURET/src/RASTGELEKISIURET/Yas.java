/**
*
* @author Burak 
* @since 07.04.2020
*/

package RASTGELEKISIURET;

public class Yas {
    Rastgele rastgele=new Rastgele();
    public int YasUret(){
        
        int yaş=(rastgele.Random()%99)+1;
        return yaş;
    }
}

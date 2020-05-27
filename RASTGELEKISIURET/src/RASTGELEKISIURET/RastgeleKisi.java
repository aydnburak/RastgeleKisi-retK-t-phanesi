/**
*
* @author Burak 
* @since 07.04.2020
*/
package RASTGELEKISIURET;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;


public class RastgeleKisi {
    public ArrayList<String> isimler= new ArrayList<String>();
    Rastgele rastgele =new Rastgele();
    
    
    public String KisiUret(){
        
        //Random isimler text inden isimleri cekiyor
        try {
            //FileReader fileReader = new FileReader("random_isimler.txt");
            FileReader fileReader = new FileReader("random_isimler.txt");
            String line;
            try (BufferedReader br = new BufferedReader(fileReader)) {
                while ((line = br.readLine()) != null) {
                    isimler.add(line);
                }
            }
            catch (Exception e) {
                System.out.println("okumada sorun var tekrar deneyiniz...1");
            }
        } 
        catch (Exception e) {
            System.out.println("okumada sorun var tekrar deneyiniz...2");
        }
        String isimSoyisim=isimler.get(rastgele.Random()%3000);
        
        return isimSoyisim;
    }
}

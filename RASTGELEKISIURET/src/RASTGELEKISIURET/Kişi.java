/**
*
* @author Burak 
* @since 07.04.2020
*/
package RASTGELEKISIURET;


public class Kişi {
    public String tcKimlik;//nesne
    public String isimSoyisim;
    public int yaş;
    public String telefon;//nesne
    public String imei;//nesne
    
    public Kişi() {
        IMEIno imeial=new IMEIno();
        imei=imeial.imeiUret();
        KimlikNo tcal=new KimlikNo();
        tcKimlik=tcal.tcÜret();
        RastgeleKisi isimal =new RastgeleKisi();
        isimSoyisim=isimal.KisiUret();
        TelefonNo telal=new TelefonNo();
        telefon=telal.telUret();
        Yas yasal=new Yas();
        yaş=yasal.YasUret();
        
    }
    public boolean TcKontrol(String tc){
        KimlikNo kimlik=new KimlikNo(); 
        return kimlik.tcSorgula(tc);
    }
    public boolean imeiKontrol(String imei){
        IMEIno imeino=new IMEIno();
        return imeino.imeiSorgula(imei);
    }
}

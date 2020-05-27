/**
*
* @author Burak 
* @since 07.04.2020
*/
package testprogrami;

import RASTGELEKISIURET.*;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class TestProgrami {

    public static void main(String[] args) throws IOException {
        int sonuc=0;
           Scanner scanner = new Scanner(System.in);
        while (sonuc!=3) { 
            System.out.println("Lütfen Seçim Yapınız.");
            System.out.println("1- Rastgele Kişi Üret");
            System.out.println("2- Üretilmiş Dosya Kontrol Et");
            System.out.println("3- Çıkış");
            System.out.print("Seciminiz:");
            sonuc = scanner.nextInt();
            System.out.println("");
            
            if (sonuc==1) {
                System.out.print("Üretilecek Kişi Sayisi:");
                int kisisayisi = scanner.nextInt();
                for (int i = 0; i < kisisayisi; i++) {
                    Kişi kisi=new Kişi();
                    String s=kisi.tcKimlik+" "+kisi.isimSoyisim+" "+kisi.yaş+" "+kisi.telefon+" ("+kisi.imei+")"; 
                    KişileriYaz(s);
                }
                System.out.println("Kayıtlar Eklendi");
                System.out.println("");
                
                
            }
            if (sonuc==2) {
                KisileriKontrolEt();
            }
            if (sonuc==3) {
                
                System.out.println("Kisiler.txt temizlendi.");
                System.out.println("Çıkış Yapılıyor...");
            }
            if (sonuc<1||sonuc>3) {
                System.out.println("Hatalı Girdi...");
            }
        }
        PrintWriter writer = new PrintWriter("..\\TestProgrami\\Kisiler.txt");
        writer.print("");
        writer.close();
        
        
    }
    public static void KişileriYaz(String kisi) throws IOException{
        
        
            String Kayıt = kisi;

            File file = new File("..\\TestProgrami\\Kisiler.txt");
            if (!file.exists()) {
                file.createNewFile();
            }

            FileWriter fileWriter = new FileWriter(file, true);
            BufferedWriter bWriter = new BufferedWriter(fileWriter);

            bWriter.write(Kayıt);
            bWriter.newLine();
            bWriter.close();
    }
    public static void KisileriKontrolEt() throws FileNotFoundException, IOException{
        
        Kişi kisi =new Kişi();
        FileReader fileReader = new FileReader("..\\TestProgrami\\Kisiler.txt");
        String line;
        
        try (BufferedReader okuma = new BufferedReader(fileReader)) {
            int GecerliTc = 0, GecersizTc = 0, GecerliImei = 0, GecersizImei = 0;
            while ((line = okuma.readLine()) != null) {

                String[] Bilgiler = line.split(" ");
                
                
                if (kisi.TcKontrol(Bilgiler[0])==true) {
                    GecerliTc++;
                } 
                if (kisi.TcKontrol(Bilgiler[0])==false) {
                    GecersizTc++;
                    System.out.print("-");
                    System.out.print(Bilgiler[0]);
                    System.out.println("-");
                }

                if (kisi.imeiKontrol(Bilgiler[5].substring(1, Bilgiler[5].length() - 1))==true) {
                    GecerliImei++;
                } 
                if (kisi.imeiKontrol(Bilgiler[5].substring(1, Bilgiler[5].length() - 1))==false) {
                    GecersizImei++;
                    System.out.print("-");
                    System.out.print(Bilgiler[5]);
                    System.out.println("-");
                }

            }
            System.out.println("\nT.C Kimlik Kontrol\n" + GecerliTc + " Geçerli\n" + GecersizTc + " Geçersiz");
            System.out.println("\nIMEI Kontrol\n" + GecerliImei + " Geçerli\n" + GecersizImei + " Geçersiz\n");
        }

    }
    
}

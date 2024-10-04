import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Test {
	public static void main(String[] args) {
		
		// FileInputStream ile bir dosyadan veri alma ve okuma işlemi
		
		FileInputStream fis = null ; 
		
		try {
			fis = new FileInputStream("okuma.txt" );
			
		
			// read metodu bize byte cinsinden bir değer dönüyor bizim bunu mutlaka char veri tipinde dönüştürmemiz gerekiyor
//			System.out.println("Birinci Karakter : " + (char)(fis.read())); // byte olarak okuyor ve onun sayısal değerini dönüyorum
//			System.out.println("İkinci Karakter  : " + (char)(fis.read()));
//			System.out.println("Üçüncü Karater   : "+(char)(fis.read()));
			// read metodu tek bir byte okuyor en baştan başlayarak , eğer okuyacak byte kalmadıysa -1 değer döndürüyor.
			
		// belirli bir index'deki değerin konumundan başlamak için skip metodunu kullanıyoruz ve inputstreami'miz oradan başlıyor okumaya
		// bunun için skip metodunu kullanıyoruz
		// fis.skip(5);
		//	System.out.println("Okunan karakter : "+ (char) fis.read());
			
		// Tüm dosyayı okumak istiyorsak eğer
			
			/* int deger ;
			
			String s = "";
			while((deger = fis.read()) != -1) { // read metodundan dönen değeri deger değişkenime ata ve koşula bak
				
				s += (char)deger; // Dosyadan okuduğu her bir karakteri string karakterime ekle her defasında
			}
			System.out.println("Dosya içeriği : " + s);*/
			
		// Dosyanın belirli bir kısmından başlayıp belirli karakterlere kadar okuma , yani belirli bir aralığı okuyacağız.
			
			int value ;
			String a ="";
			int say = 0 ;
			fis.skip(5); // file input stream'imi dosyada'ki 5. index'e götürdüm
			while((value = fis.read()) != -1) {
				
				a += (char)value; // value değişkenini chara  dönüştür ve üzerine öyle ekle a string değişkenimin
				say++;
				if (say==11) {
					break;
				}
			}
			System.out.println("Dosyanın 5. Index'inden İtibaren Okunan 10 Karakter : " + a);
			
		} catch (FileNotFoundException ex) {
			System.out.println("Dosya bulunamadı!!!");
			ex.printStackTrace();
		} catch (IOException e) {
			System.out.println("Dosya okunurken hata meydana geldi");
			e.printStackTrace();
		}
		finally {
			try {
				if (fis != null) {
					fis.close();		
				}
			}
			catch(IOException ex) {
				System.out.println("Dosya kapatılırken bir hata meydana geldi!");
				ex.printStackTrace();
			}
		}
		
		
		
		
		
		
	}
}

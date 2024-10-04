import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		// Bizim dosyalarımız txt uzantılı yani String tipli bir yapıda ise
		// Bunları FileReader , BufferedReader ile okumamız daha efektif oluyor FileInputStream'e göre 
		
		try (Scanner scanner = new Scanner(new FileReader("ogrenciler.txt"))){
		// Scanner objelerimizin içerisine System.in'i gönderiyorduk , yani consol'dan okuma yapmasını istiyorduk
		// Bu sefer bu scanner objesinin içerisine oluşturduğumun FileReader objesini ve içerisinde bulunan dosyamızı
		// gönderiyoruz bu sayede satır satır okuma yapabiliyoruz.
		while (scanner.hasNextLine()) {
			
			System.out.println("Okunan Satır : " + scanner.nextLine());
			
			
			// nextLine metodu ters slash n görene kadar devam ediyor ilerlemeye satır boyunca
			// hasNextLine metoduda okuyacak başka satır var mı ona bakıyor ve duruma göre true veya false değer dönüyor
			
		// Scanner objemin constructor'ına okumak istediğim dosyamı ve okuyacak objeyi girerek okuma yapabiliyorum 
		// direkt satır satır
			
		}
		} catch (FileNotFoundException e) {
		System.out.println("Dosya bulunamadı!");
		e.printStackTrace();
		}
		
		// Sadece bilgisayar mühendisliği okuyan kişileri okumak istersem ne yapacağız
		
		try(Scanner scanner = new Scanner(new FileReader("ogrenciler.txt"))) {
			
			while (scanner.hasNextLine()) {
				String ogrenciBilgisi = scanner.nextLine();
			// Java'da split metodu belirli bir ayraç kullanarak String bir ifadeyi parçalara ayırmak için kullanılır.
			// Bu bir virgül , nokta veya boşluk olabilir
			// Split metodu içerisinde belirttiğimiz ayraçı baz alarak String ifadeyi ona göre parçalara ayırır
		    // Ve işlem sonunda bir string array döner
			String [] array = ogrenciBilgisi.split(","); // Satırdaki string ifadeyi virgül kısmından ayırdı
			if(array[1].equals("Bilgisayar Mühendisliği")) {   // Ve virgülü ortadan kaldırdı.
			System.out.println("Öğrenci Bilgileri : " + ogrenciBilgisi);
																// Parçaları arrayde belirli indexlere yerleştirdi ve
			}											       // bu arrayi döndürdü string olarak
			
			}
			
		} catch (FileNotFoundException e) {
			System.out.println("Dosya bulunamadı!");
			e.printStackTrace();
		}
		//-----------------------------------------------------------------------------------------------------------
		
		// BufferedReader aslında FileReader ile aynı işi yapıyor
		// Ancak BufferedReader'ımızda performans olarak FileReader'a göre daha hızlı şekilde okuma yapabiliyoruz
		// Kısaca FileReaderdan okuma işleminde daha hızlı ve efektif özellikle dosya boyutu büyükse
		
		/*
			Birbirlerinden Farkları : 
			 FileReader harici diskde bulunan dosyayı direkt okumak yerine gidip tek karakter okuyup geri dönüyor
			 Yani teker teker okuma yapıyor dosya içerisinde
			 Bu şekilde dosyaya çok fazla erişim yaptığımız için performans kaybına neden oluyor büyük dosyalarda
			 
			 Ancak BufferedReader kendi içerisinde bir tane buffer ( küme = kutu ) oluşturuyor.
			 Ve dosyaya gidiyor dosyada \n görene kadar bütün karakterleri okuyor daha sonra bu buffer'a koyuyor
			 O buffer'ı bizim java projemize getiriyor
			 Bu yolla dosyaya daha az erişim sağlamış oluyoruz ve performans kaybının önüne geçiyoruz.
		
		*/
		try(Scanner scanner = new Scanner(new BufferedReader(new FileReader("ogrenciler.txt")))){
			// BufferedReader Reader Class'ından bir obje veya referans alabiliyor 
			// Bende Reader sınıfından türeyen FileReader objesini ve içerisinde bulunduğu ogrenciler.txt dosyasını
			// okuması için ona gönderdim
			while(scanner.hasNextLine()) { // Okuma yaptığın satırda bir değer var mı bak true false değer dön ona göre
		
			String metin = scanner.nextLine(); // \n görene kadar satır okuma yap
			
			String [] array = metin.split(","); // okuduğun satırda virgül işareti varsa oradan böl ve onu kaldır
												// string değerleride bir arraye yerleştir indexleyerek
												// ve o string arrayide dön bulunduğun yere 
			if (array[1].equals("İşletme")) {
				System.out.println("Öğrenci Bilgileri : " + metin);
			}
			}
			}
			catch (FileNotFoundException ex) {
			System.out.println("Dosya bulunamadı!");
			ex.printStackTrace();
			}
	//----------------------------------------------------------------------------------------------------------------
	
// BufferedWriter'da Reader ile aynı mantıkta çalışıyor yazmak istedğimiz değerler bir buffer'a ( kutuya ) konuluyor
// FileWriter'da ise bu dosyaya teker teker gidip karakter yazıyor ve geliyor.
		
		try(BufferedWriter writer = new BufferedWriter(new FileWriter("ogrenciler.txt",true) )){ // sonuna ekleme yap 
			// BufferedReader'daki gibi (FileReader göndermiştik)
			// buradada Constructor'a bir FileWriter nesnesi ve bulunduğu dosyayı gönderiyorum
			writer.write("Ali Ozan,Hukuk\n");
			writer.write("Galim Garip,İnşaat Mühendisliği\n");
			writer.write("Sercan Hikme,Psikolog\n");
		}
		catch (IOException ex) {	
		System.out.println("Dosya açılırken hata oluştu!");
		ex.printStackTrace();
		}
		
	// Kısaca Dosyanın Okuma Süresini Azaltmak İstiyorsam BufferedReader 
	// Dosyaya yazma işlemininin süresini azaltmak istiyorsam BufferedWriter class'larını kullanmam daha iyi olur
	// BU İKİ SİNİF ÖZELLİKLE BÜYÜK DOSYALARDA PERFORMANS AÇISINDAN PROGRAMIMA FAYDA SAĞLIYOR.
	// Ayrıca bu sınıflarımın constructorları içerisinde FileWriter ve FileReader objelerini kullanmamın nedeni
	// Buffered Class'ları ile direkt bir dosyadan okuma ve yazma işlemlemlerini yapamıyorsunuz
	// Bunun için FileReader ve FileWriter class'larını ve objelerini kullanmam gerekiyor onlar ile direkt yapabiliyorum bu işlemi
	}
}

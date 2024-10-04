import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// Büyük dosyalarda dosyamızı kapatmayı unutursak arka plandaki kaynaklarımızı gereksiz yere kullanmış olacağız.
		// Buda önemli ölçüde performans kaybına neden olacak. O yüzden mutlaka ama mutlaka dosyayı kapatmamız gerekiyor
		// close  metodu ile , ister output işlemi yapalım ister input işlemi
		
		// TryWithResource yapısı işlemimiz bittiği anda direkt kendisi otomatik olarak dosyamızı kapatıyor
		
		// Burada referansını belirteceğim class FileOutputStream , FİleInputStream , FİleWriter olabilir
		// Mutlaka ama mutlaka bu referansın class'ının closeable interface'ini implement etmesi gerekiyor
		// Eğer implement etmesse trywithresource bu dosyamızı otomatik olarak kapatmayacak
		// Kısaca burada sadece Closeable interface'ini implement eden sınıfların referanslarını kullanabilirim
		try(FileWriter writer = new FileWriter("dosya.txt" , true);
			// Birden fazla dosya açabiliyoruz trywithresource yapısında
			FileOutputStream fos = new FileOutputStream("dosya2.txt", true)
				){
			String text = "FileOutput Stream sınıfı ile işlem yaparken string bir ifadeyi byte dönüştürmem gerekiyor\n";
			
			byte [] metin = text.getBytes();
			fos.write(metin);
		
			writer.write("Hayallerine ulaşmak için çok çalışman gerekiyor\n");
		    writer.write("Java programlama dilini seviyorum\n");
			
		}// Try anahtar kelimesinin yanına bir parantez açıp dosyamı ve kullanacağım sınıfı belirtiyorum
		catch (IOException ex) {
		System.out.println("Dosya oluşturulurken bir hata meydana geldi");
		ex.printStackTrace();
		}
		//---------------------------------------------------------------
		try(FileWriter writer1 = new FileWriter("diller.txt")) {
			Scanner scanner = new Scanner(System.in);
			String dil ;
			
			while (true) {
				
			System.out.print("Hangi dilleri biliyorsunuz? :");	
			dil = scanner.nextLine();
			
			
			if (dil.equals("-1")) {
				System.out.println("Programdan Çıkılıyor...");
				System.out.println("Dosyayı kontrol edin lütfen");
				break ;
			}
			writer1.write(dil + "\n");
				
			}
			scanner.close();
		}
		catch(IOException ex) {
			System.out.println("Dosya açılırken veya dosyaya yazma işlemi yapılırken hata meydana geldi");
			ex.printStackTrace();
		}

	}
		
}

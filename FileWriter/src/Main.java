import java.io.FileWriter;
import java.io.IOException;

public class Main {
	public static void main(String[] args) {
		
		// FileWriter class'ını kullanarak bir  txt dosyasına veri yazma işlemi nasıl yapılır 
		// FileİnputStream ve FileOutputStream class'ları ile okuma ve yazma işlemleri yaparken dönüştürme işlemi yapmak
		// zorunda kalıyorduk çünkü metotları byte halinde olan verileri integer bir değere dönüştürüyor
		// bizde bunu hangi veri tipine dönüştürmek istiyorsak örn : (char) ona dönüştürmek zorunda kalıyorduk
		// ekstradan bir dönüştürme işlemi yapıyorduk kısaca
		
		// FileWriter class'ı ilede direkt dosyamıza yazma output işlemini hiç bir dönüştürme yapmadan yapabiliyoruz.
		
		FileWriter writer = null ;
		
		try {
			writer = new FileWriter("text.txt", true);// FileWriter ile bir dosya açabilir veya varolan dosyaya veri girebiliriz
												// Bu veriyi direkt string tipte girebiliriz
			writer.write("Gonzel de Salvador\n");
			writer.write("Java bir programlama dilidir\n");
		}
		catch(IOException ex) {
		System.out.println("IOException hatası meydana geldi.");
		ex.printStackTrace();
		}
		finally {
			if (writer != null) { // null değilse // NullPointerException hatası almamak için böyle bir şart koydum
				try {
				writer.close();
				}
				catch(IOException ex) {
				System.out.println("Dosya kapatılamadı IOException hatası meydana geldi");
				ex.printStackTrace();
				}
			}
		}
		
		// FileWriter Class'ı string tipli verileri output etmek için yani yazmak için uygun bir sınıfdır
	}
}

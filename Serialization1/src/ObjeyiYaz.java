import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class ObjeyiYaz {
	public static void main(String[] args) {
		
		// Objeyi serileştirmek için ObjectOutputStream'e ihtiyacımız var.
		
		try(ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream("ogrenci.bin"))){
		// ObjectOutputStream contructor'ı içerisinde Stream class'ından bir obje ve dosya bekliyor	
		// Bizde burada oluşturduğumuz objeleri yazmak için FileOutputStream ve dosyasının adını yazdık
		// Yani ObjectOutputStream constructor'ına yazma işlemini yapacağım dosyam ve onun objesini FOS'u giriyorum
		// Burada dosyamın uzantısı bin yani binary dizisi şeklinde oluştuğunu söylemiş oluyoruz öyle bir yapısı var.
		// dat uzantısıda yine binary içeriğine sahip bir dosya istiyorsak kullanabileceğimiz bir uzantı
		// yada ser 
			
		Ogrenci ogrenci1 = new Ogrenci("Akın Telli", 1980832l, "Yazılım Mühendisliği");
		Ogrenci ogrenci2 = new Ogrenci("Harun Kaya", 1231241l, "İşletme") ;
		
		output.writeObject(ogrenci1);
		output.writeObject(ogrenci2);
		} catch (FileNotFoundException e) {
			System.out.println("Dosya bulunamadı");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("Dosya açılırken IOException hatası oluştu");
			e.printStackTrace();
		}
	}
}

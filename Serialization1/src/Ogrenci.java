import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.Serializable;
// Eğer class'ımın bazı özelliklerini değiştirip yeniden aynı şekilde tanımlıyorsam
// versiyonunu değiştirip bunu belirtmem gerekiyor javaya yoksa hata meydana gelir projemde
// Java serileştirme yaparken serileştirdiği objelerin o anki serialVersionUID'sini alıp onlar ile beraber dosyaya yazıyor
// Geri serileştirdiğimizde de yazdığı Id ile şuanki serialVersionUID'yi karşılaştırıyor eşitlerse direkt olarak objeyi getiriyor
// Eğer eşit değillerse İnvalidClassException hatası fırlatıyor.

public class Ogrenci implements Serializable { // Bu interface içerisinde herhangi bir metod yer almıyor
											   // Amacı zaten işaretlemek aslında kendisini implement eden sınıflardan
											   // obje türetilince bu objelerin serileştirilebileceğini javaya söylüyor
	private static final long serialVersionUID = 2L;
	// Class'ımın versiyonunu'da bu şekilde belirtmiş oluyorum Java'ya
	// Bu değişken değiştiğinde Java'ya bu class değişti demiş oluyoruz kısaca 
	private String isim ;
	private long id;
	private String bolum;
	private String dersler; // Yeni ekledik değişiklik yaptık class'da o yüzden serialVersionUID değerinide değiştirmeliyim
	
	
	
	
	public String getDersler() {
		return dersler;
	}

	public void setDersler(String dersler) {
		this.dersler = dersler;
	}

	@Override
	public String toString() {
	String bilgiler = "Öğrenci İsmi : " + isim + "\n"
					+ "Öğrenci Numarası : " + id + "\n"
					+ "Öğrenci Bölümü : " + bolum;
	return bilgiler;
	}

	public Ogrenci(String isim, long id, String bolum) {
		this.isim = isim;
		this.id = id;
		this.bolum = bolum;
	}
	
	// Objemizi okuyacağımız için toString metodunu kullanıyorum
	



	public static void main(String[] args) {
		// Bir objeye nasıl serileştirme yapılır
		// Bir obje serileştirilecekse bu objenin türediği sınıfın serializable interface'ini implement etmesi gerekiyor
		
		
		try(FileOutputStream stream = new FileOutputStream("dosya.txt")){
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

	
}

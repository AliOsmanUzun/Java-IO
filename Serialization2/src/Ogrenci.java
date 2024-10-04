import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.Serializable;

@SuppressWarnings("serial")
public class Ogrenci implements Serializable{ // Objeleri serileştirmek istiyorsam Serializable interface'ini implement
											 // etmesi lazım türedikleri sınıfın
	
	
	private String isim ;
	private long id;
	private String bolum;
	
	
	
	public Ogrenci(String isim, long id, String bolum) {
		this.isim = isim;
		this.id = id;
		this.bolum = bolum;
	}
	
	



	@Override
	public String toString() {
		String bilgiler = "Öğrenci İsmi : " + isim + "\n"
				+ "Öğrenci Numarası : " + id + "\n"
				+ "Öğrenci Bölümü : " + bolum;
		return bilgiler;
	}





	public static void main(String[] args) {

	try(FileOutputStream stream = new FileOutputStream("dosya.txt")){
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}

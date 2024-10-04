import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Arrays;

// Arrayleri ve Collectionları Nasıl Serileştiririz ? 
// Yani bir byte dizisine nasıl dönüştürürüz

public class ObjeyiYaz {

	

	
	public static void main(String[] args) {
		
		// objelerimizi oluşturalım
		Ogrenci ogrenci1 = new Ogrenci("Mehmet Sadık", 13049L, "Mekatronik Mühendisliği") ;
		Ogrenci ogrenci2 = new Ogrenci("Hakan Yanbaz", 51341L, "Ekonomi Yönetimi") ;
		Ogrenci ogrenci3 = new Ogrenci("Can Güler", 23512L, "Yazılım Mühendisliği") ;
		
		Ogrenci [] ogrenciArray = {ogrenci1,ogrenci2,ogrenci3};
		
		// Bir de arrayliste depolayalım objelerimi
		ArrayList<Ogrenci> arrayList_Ogrenci = new ArrayList<Ogrenci>(Arrays.asList(ogrenciArray));
		// ArrayListimin constructor'ına ona uygun tipte bir array gönderirsem o array ve içindeki objeleri ve verileri
		// Kendi içerisinde tutacak direkt olarak bunun Arrays sınıfından asList metodunu kullanıyorum
		
		try(ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream("ogrenciler.ser"))){
	// Serileştirdiğimiz objeyi bir byte dizisine dönüştürüp , byte veri tipindeki ogrenci.ser dosyasına yazıcaz
			 
			output.writeObject(ogrenciArray);
			output.writeObject(arrayList_Ogrenci);
			
		} 
		
		catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

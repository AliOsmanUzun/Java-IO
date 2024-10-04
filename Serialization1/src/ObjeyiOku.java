import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
// Ekstra öğrendiklerim
// FileInputStream direkt olarak dosyayı açar ve byte tipinde okuma yapar
public class ObjeyiOku {
	public static void main(String[] args) {
		Ogrenci ogrenci1 = null ;
		Ogrenci ogrenci2 = null;
		try(ObjectInputStream input = new ObjectInputStream( new FileInputStream ("ogrenci.bin"))){
			ogrenci1 = (Ogrenci) input.readObject();
			ogrenci2 = (Ogrenci)input.readObject();
			System.out.println(ogrenci1);
			System.out.println(ogrenci2);
			// writeObject nesnemizi Object class tipine çevirip ondan sonra binary bir diziye dönüştürüyordu
			// burada readObject metodu binary olan objemizi bir Object classı tipli bir nesne olarak dönüyor
			// Bende onu asıl türettiğim class tipine tür dönüşümü yapıyorum parantez içinde 
		} catch (FileNotFoundException e) {
			System.out.println("Dosya bulunamadı");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("Dosya açılırken veya okunurken hata meydana geldi");
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			System.out.println("Class bulunamadı");
			e.printStackTrace();
		}
	}
}

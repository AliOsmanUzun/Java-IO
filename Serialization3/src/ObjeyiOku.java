import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

public class ObjeyiOku {

	
	public static void main(String[] args) {
		
		try(ObjectInputStream input = new ObjectInputStream( new FileInputStream("ogrenciler.ser"))){
			
			  Ogrenci ogrenci =  (Ogrenci )input.readObject();
			  System.out.println(ogrenci);
			  System.out.println("Öğrenci Sayısı : " + Ogrenci.getOgrenciSayisi());
			  // Bu özelliğim static olduğu için yani class'a özgü olduğu için Java otomatik olarak 
			  // Bu özelliği serileştirmiyor
			  // Java static alanlarımız Class'a özgü olduğu için onu otomatik olarak transient bir alan olarak 
			  // kabul ediyor ve serileştirmiyor
			  
			  
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// Şuan ogrenci class'ından 1000 tane daha obje oluşturup dosyaya yazsakda performans anlamında bir etkisi olmaz
		// Çünkü sahip olduğu özellikler ve metotlar çok az
		// Ama bunlar çok sayıda olsaydı dosya boyutu gereksiz yere büyüyecekti 
		// Çünkü objenin sahip olduğu ama kullanmak istemediğimiz özellikleri ve metotları olabilir
		// Yani serileştirmek istemediğimiz özellikleri ve metotları varsa bunu Javaya belirtebilirim
		// Bunun için transient anahtar kelimesini kullanıyorum
	}
}

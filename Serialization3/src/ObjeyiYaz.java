import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;


public class ObjeyiYaz {

	

	
	public static void main(String[] args) {
		

		Ogrenci ogrenci = new Ogrenci("Burak Kayasız", 12412L, "Yazılım Mühendisliği");
		
		try(ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream("ogrenciler.ser"))){
	// Serileştirdiğimiz objeyi bir byte dizisine dönüştürüp , byte veri tipindeki ogrenci.ser dosyasına yazıcaz
			
			Ogrenci.setOgrenciSayisi(100);
			
			output.writeObject(ogrenci);
		} 
		
		catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

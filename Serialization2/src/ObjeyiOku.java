import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

public class ObjeyiOku {

	
	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		
		try(ObjectInputStream input = new ObjectInputStream( new FileInputStream("ogrenciler.ser"))){
			
	// Dosyaya yazma işlemini hangi sıra ile yaptıysam okuma işleminide o sırayla yapıyorum
	Ogrenci [] ogrenciArray = (Ogrenci[])input.readObject();
	
	ArrayList<Ogrenci> ogrenciArrayList = (ArrayList<Ogrenci>) input.readObject() ;
			
	for (Ogrenci i : ogrenciArray) {
		System.out.println(i + "\n");
	}
	
	System.out.println("\n*****************************************************\n");
	
	for (Ogrenci i : ogrenciArrayList) {
		System.out.println(i + "\n");
	}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
}

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;


public class Main {

	public static void main(String[] args) {
		
		// FileOutputStream class'ını kullanarak bir dosyayı açmayı ve o dosyaya verileri byte halinde yani Stream şeklinde 
		// yazmamızı sağlar
		
		FileOutputStream fos = null ; 	
		File file = new File("dosya.txt"); // Constructor'ın içerisine output edeceğim yazacağım dosyanın ismini giriyorum
		
	try {
		fos = new FileOutputStream(file , true ); // File class'ından bir obje oluşturmadanda burada direkt 
		// Constructor'a output yapacağım dosyasının adınıda girebilirim
		// burada write metodundaki değeri değiştirdikçe dosyamdaki değerler silinip yerine yenileri geliyor
		// eski verilerimin silinmesini istemiyorsam üzerine yeni veriler eklensin istiyorsam 
		// FileOutputStream constructor'ı içerisinde true değerini kullanmalıyım
	
		
		
		// Kısaca eğer bir dosyaya bir output işlemi yazma işlemi yapacaksak 
		// Bu verileri kesinlikle ama kesinlike bir byte array'ine dönüştürmemiz gerekiyor.
		String name = "Kamil Garip";
		byte [] name_array = name.getBytes();// getBytes ile string değişkenimin içerisindeki karakterleri byte array haline
											 // dönüştürmüş oldum 
		
		fos.write(name_array);
		// Bir byte arrayi'ni direkt olarak write metodu ile yazabilirim
		// byte [] array = {75,101,127,56,12,45,2,34,01,07,42,65,78,98};
		//fos.write(array);
		
		
		
//			fos.write(53);
//			fos.write(56);
//			fos.write(99);
//			fos.write(98);
		
	 
	} catch (FileNotFoundException ex) {
		System.out.println("File Not found exception oluştu");
	}	
	catch (IOException ex) {
		System.out.println("Dosyaya yazılırken bir hata oluştu");
	}
	/*
	Bu dosya açıldığında herhangi bir exception oluşursa dosyayı mutlaka kapatmak gerekiyor
	Ayrıca sıkıntı olmasa bile arka plandaki kaynakları boş yere harcamamak için bu dosyayı mutlaka kapatmamız gerekiyor
	Exception olsada olmasada bunu yakalamamız gerektiği için finally bloğunu kullanıyoruz.
	*/
	finally {
		try {
			fos.close();
		} catch (IOException e) {
		System.out.println("Dosya kapatılırken bir hata oluştu");
		}
	}
	}
}

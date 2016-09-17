abstract public class AlatLab{ 
      private int jumlah; 
      private String nama; 

public AlatLab(){ 
      jumlah=100; 
      nama="Alat-Alat Lab Kimia"; 
} 
public AlatLab(String nama, int jumlah){ 
      this.nama=nama; 
      this.jumlah=jumlah; 
} 

//abstract method 
abstract public int getHarga();

//getter setter nama
public String getNama (){ 
      return nama; 
} 
public void setNama (String nama){ 
      this.nama=nama; 
} 
//getter setter jumlah
public int getJumlah(){ 
      return jumlah; 
} 
public void setJumlah (int jumlah){ 
      this.jumlah=jumlah; 
} 
//tostring
public String toString(){ 
   return "\n\tNama Alat Lab\t : "+getNama()+
   "\n\tJumlah Alat\t : "+getJumlah(); 
} 
}
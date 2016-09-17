public class Erlenmeyer extends Gelas{ 
private String jenis; 
private int harga;

public Erlenmeyer(){ 
      super(); 
      jenis="Ukuran Besar"; 
	  harga=500000;
} 

public Erlenmeyer(String nama, int jumlah, int volume, String jenis, int harga){ 
      super(nama, jumlah, volume);  
      this.jenis=jenis; 
	  this.harga=harga;
} 
//getter setter jenis
public String getJenis (){ 
      return jenis;
} 
public void setJenis(String jenis) {
	  this.jenis=jenis;
}

@Override
public int getHarga (){ 
      return harga*super.getVolume();
} 
public void setHarga(int harga) {
	  this.harga=harga;
}

@Override 
public String toString(){ 
    return super.toString()+
	"\n\tJenis\t\t : "+getJenis()+
	"\n\tHarga\t\t : "+getHarga();
} 
}
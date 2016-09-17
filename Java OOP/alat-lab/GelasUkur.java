public class GelasUkur extends Gelas{ 
private String jenis; 
private int harga;

public GelasUkur(){ 
      super(); 
      jenis="Ukuran Sedang"; 
	  harga=200000;
} 

public GelasUkur(String nama, int jumlah, int volume, String jenis, int harga){ 
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
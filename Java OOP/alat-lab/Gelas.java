abstract public class Gelas extends AlatLab{ 
private int volume; 

public Gelas(){ 
      super(); 
      volume=30; 
} 
public Gelas(String nama, int jumlah, int volume){ 
      super(nama, jumlah);  
      this.volume=volume; 
} 
//getter setter volume
public int getVolume (){ 
      return volume; 
} 
public void setVolume (int volume){ 
      this.volume=volume; 
} 


@Override 
public String toString(){ 
    return super.toString()+
	"\n\tVolume\t\t : "+getVolume()+" ml";
} 
}
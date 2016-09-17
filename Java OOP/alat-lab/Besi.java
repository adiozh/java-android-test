abstract public class Besi extends AlatLab{ 
private int massa; 

public Besi(){ 
      super(); 
      massa=30; 
} 
public Besi(String nama, int jumlah, int massa){ 
      super(nama, jumlah);  
      this.massa=massa; 
} 
//getter setter volume
public int getMassa (){ 
      return massa; 
} 
public void setMassa (int massa){ 
      this.massa=massa; 
} 


@Override 
public String toString(){ 
    return super.toString()+
	"\n\tMassa\t\t : "+getMassa()+" kg";
} 
}
import java.util.Scanner;
public class Demo {
	public static void main(String[] abc) {
	Scanner data = new Scanner (System.in);
	int pilihan, pilihan2, pilihan3, pilihan4;
	int jml=0, aa, yy;

AlatLab[] alat = new AlatLab[6];
			Erlenmeyer[] ele = new Erlenmeyer[2];
			GelasUkur[] geluk = new GelasUkur[2];
			
			Timbangan[] timb = new Timbangan[2];
			Pinset[] pin = new Pinset[2];

			alat[1] = new Erlenmeyer("Erlenmeyer dari AlatLab",8,60,"Ukuran Besar",200000);
			alat[2] = new GelasUkur("Gelas Ukur dari AlatLab",12,30,"Ukuran Sedang",100000);

			alat[3] = new Timbangan("Timbangan dari AlatLab",20,4,"Timbangan Berat Badan",50000);
			alat[4] = new Pinset("Pinset dari AlatLab",15,1,"Pinset Besar",10000);

do { System.out.println("-------------------------------------- ");
  	 System.out.println("\t   Daftar Alat Lab ");
	 System.out.println("-------------------------------------- ");
	 System.out.println(" ");
	 System.out.println("\t1. Input Data Alat Lab");
	 System.out.println("\t2. Cetak Data");
	 System.out.println("\t3. Hapus Data");
	 System.out.println("\t4. Keluar");
	  System.out.println(" ");
	 System.out.println("--------------------------------------");
	 System.out.println(" ");
	 System.out.print("\tMasukkan pilihan : ");
	 pilihan = data.nextInt();
	
{
	if(pilihan==1){ 
			do{ System.out.println("-------------------------------------- ");
				System.out.println("\t   Menu Input Data Alat Lab");
				System.out.println("--------------------------------------");
				System.out.println(" ");
				System.out.println("\t1. Input Erlenmeyer");
				System.out.println("\t2. Input Gelas Ukur");
				System.out.println("\t3. Input Timbangan");
				System.out.println("\t4. Input Pinset");
				System.out.println("\t5. Kembali Menu");
				 System.out.println(" ");
				System.out.println("-------------------------------------- ");
				System.out.println(" ");
				System.out.print("\tMasukkan pilihan : ");
				pilihan3 = data.nextInt();
				
			switch(pilihan3){
					
			case 1: System.out.println(" ");
					System.out.print("\t Input Data Erlenmeyer ");
					jml++;
					System.out.println(" ");
					System.out.print("\tMasukkan Nama Erlenmeyer : ");
					String i=data.next();
					System.out.print("\tMasukkan Jumlah Erlenmeyer : ");
					int j= data.nextInt();
					System.out.print("\tMasukkan Volume Erlenmeyer : ");
					int k= data.nextInt();
					System.out.print("\tMasukkan Jenis Erlenmeyer : ");
					String kk= data.next();
					System.out.print("\tMasukkan Harga Erlenmeyer : ");
					int l= data.nextInt();
					alat[jml]=new Erlenmeyer(i,j,k,kk,l);
					break;
					
			case 2: System.out.println(" ");
					System.out.print("\t Input Data Gelas Ukur ");
					jml++;
					System.out.println(" ");
					System.out.print("\tMasukkan Nama Gelas Ukur : ");
					String m=data.next();
					System.out.print("\tMasukkan Jumlah Gelas Ukur : ");
					int n= data.nextInt();
					System.out.print("\tMasukkan Volume Gelas Ukur : ");
					int o= data.nextInt();
					System.out.print("\tMasukkan Jenis Gelas Ukur : ");
					String p= data.next();
					System.out.print("\tMasukkan Harga Gelas Ukur : ");
					int q= data.nextInt();
					alat[jml]=new GelasUkur(m,n,o,p,q);
					break;
					
			case 3: System.out.println(" ");
					System.out.print("\t Input Data Timbangan ");
					jml++;
					System.out.println(" ");
					System.out.print("\tMasukkan Nama Timbangan : ");
					String r=data.next();
					System.out.print("\tMasukkan Jumlah Timbangan : ");
					int s= data.nextInt();
					System.out.print("\tMasukkan Massa Timbanagan : ");
					int t= data.nextInt();
					System.out.print("\tMasukkan Jenis Timbanagn : ");
					String u= data.next();
					System.out.print("\tMasukkan Harga Timbangan : ");
					int v= data.nextInt();
					alat[jml]=new Timbangan(r,s,t,u,v);
					break;
			
			case 4:System.out.println(" ");
					System.out.print("\t Input Data Pinset ");
					jml++;
					System.out.println(" ");
					System.out.print("\tMasukkan Nama Pinset : ");
					String w=data.next();
					System.out.print("\tMasukkan Jumlah Pinset : ");
					int x= data.nextInt();
					System.out.print("\tMasukkan Massa Pinset : ");
					int y= data.nextInt();
					System.out.print("\tMasukkan Jenis Pinset : ");
					String z= data.next();
					System.out.print("\tMasukkan Harga Pinset : ");
					int zz= data.nextInt();
					alat[jml]=new Pinset(w,x,y,z,zz);
					break;
			}
	}
	while (pilihan3!=5);
}
else if (pilihan==2){
				System.out.println(" ");
					System.out.println("  Cetakan Data Alat-Alat Lab  ");
					System.out.println(" ");
					for(aa=1;aa<=jml;aa++){
					System.out.println ("  Daftar Alat ke "+(aa)+" : "+"\n "+alat[aa]+"\n ");
					}
			}
	
	else if (pilihan==3){
				System.out.println(" ");
					for(aa=1;aa<=jml;aa++){
					System.out.println ("Daftar Alat Lab ke "+(aa)+" : "+"\n "+alat[aa]+"\n ");
					}
					System.out.println(" ");
					System.out.print("Masukkan nomor Alat Lab yang ingin anda hapus : ");
					int no=data.nextInt();
					for(yy=1;yy<=jml;yy++){alat[no]=alat[no+1];}
					System.out.print("\n\t--Data Berhasil Dihapus--\n ");
					jml--;
					
			}
			
	else {return;}
}
	
	System.out.println(" ");
	System.out.println("\tApakah anda ingin kembali ke menu awal?");
	System.out.println("\t1. Ya");
	System.out.println("\t2. Tidak");
	System.out.println(" ");
	System.out.print("\tMasukkan pilihan : ");
	pilihan2 = data.nextInt();
	
	}  
	while (pilihan2==1);
}}
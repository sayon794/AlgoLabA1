import java.util.Scanner;


public class Menu {
	public Menu() {
		int array[] = {336,10305,315,10199,721,423,11709,439,796,10278,11518,11721,11504};
		System.out.println("Input the corresponding key to the problem number: (0 to exit)");
		for(int i=0;i<array.length;i++) {
			System.out.println(array[i]+" : "+(i+1));
		}
		Scanner S = new Scanner(System.in);
		int n;
		while(true) {
			n = S.nextInt();
			S.nextLine();
			if(n==0) break;
			if(n==1) new UVA_336();
			else if(n==2) new UVA_10305();
			else if(n==3) new UVA_315();
			else if(n==4) new UVA_10199();
			else if(n==5) new UVA_721();
			else if(n==6) new UVA_423();
			else if(n==7) new UVA_11709();
			else if(n==8) new UVA_439();
			else if(n==9) new UVA_796();
			else if(n==10) new UVA_10278();
			else if(n==11) new UVA_11518();
			else if(n==12) new UVA_11721();
			else if(n==13) new UVA_11504();
			System.out.println("Press any key to continue");
			S.nextLine();
		}
	}
}

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JFrame;


public class LudoGame extends JFrame{
	
   private final Font smallfont = new Font("Helvetica", Font.BOLD, 14);
	Image img;
	JComboBox cb1,cb2;
	String s1,s2;
	boolean status1 = true,status2;
	boolean firstThrowP1 = true;
	boolean firstThrowP2 = true;
	int x1,y1,x2,y2;
	int rn1,rn2;
	//boolean edge1 = false;
	//boolean edge2 = false;
	private boolean minus1 = false;
	private boolean plus1 = true;
	private boolean minus2 = false;
	private boolean plus2 = true;
	String win1 = "no";
	String win2 = "no";
	String nos1="0";
	String nos2="0";
	public LudoGame(){
		ImageIcon i = new ImageIcon("ludo.png"); 
	   	 img = i.getImage();
	   	 setTitle("Java Game : Ludo");
	   	 setSize(900,700);
	   	 String[] player = {"player","player 1","player 2"};
	   	 cb1 = new JComboBox(player);
	   	 cb1.setBounds(700, 150, 120, 25);
		 add(cb1);
		  cb1.setEditable(true);
		 
		 String[] play = {"pause","play"};
	   	 cb2 = new JComboBox(play);
	   	 cb2.setBounds(700, 200, 120, 25);
		 add(cb2);
		 cb2.setEditable(true);
		 
		 setLayout(null);
	   	 setResizable(true);
	   	 setVisible(true);
	   	 setBackground(Color.CYAN);
	   	 
	   	 setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	   	 x1=220;
	   	 y1=520;
	   	 x2=270;
	   	 y2=520;
	   	s2="play";
		s1="player 1";
	}
	public void paint(Graphics g){
		g.drawImage(img, 41, 41, this);
		//g.setColor(Color.WHITE);
		//g.fillRect(780, 290,20,20);
		//g.setColor(Color.black);
		//g.drawString("Digit on Dice : ", 695, 300);
		//g.drawString(nos, 780, 300);
		//s1 = (String) cb1.getSelectedItem();
		//s2 = (String) cb2.getSelectedItem();
		g.setFont(smallfont);
		if(s2.equals("play")&&s1.equals("player 1")&&status1){
			Random rno = new Random();
		    rn1 = rno.nextInt(6);
		    int rno1 = rn1+1;
			String str = rno1+" ";
			nos1=str;
			//g.setColor(Color.black);
			//g.drawString(str, 700, 300);
			System.out.println(str);
			
			if(firstThrowP1 && rn1 == 0 ){
				runP1S();
				
				firstThrowP1 = false;
			}
			else if(!firstThrowP1){
				
				runP1();
			}
			
			status1=false;
			status2=true;
			s2="play";
			s1="player 2";
		}
		if(s2.equals("play")&&s1.equals("player 2")&&status2){
			Random rno = new Random();
			rn2 = rno.nextInt(6);
			int rno2 = rn2+1;
			String str = rno2+" ";
			nos2=str;
			//g.setColor(Color.black);
			//g.drawString(str, 700, 300);
			System.out.println(str);
			
			if(firstThrowP2 && rn2 == 0 ){
				runP2S();
				
				firstThrowP2 = false;
			}
			else if(!firstThrowP2){
				
				runP2();
			}
			
			status2 = false;
			status1=true;
			
			s2="play";
			s1="player 1";
		}
		g.setColor(Color.GREEN);
		g.fillOval(x1,y1,35,35);
		g.setColor(Color.BLUE);
		g.fillOval(x2,y2,35,35);
		
		//winning declaration 
		
		if(win1.equals("yes")){
			g.setColor(Color.RED);
			g.drawString("Winner Player 1",700,500);
			s2="pause";
		}
        if(win2.equals("yes")){
        	g.setColor(Color.RED);
			g.drawString("Winner Player 2",700,500);
			s2="pause";
		}
        g.setColor(Color.WHITE);
		g.fillRect(780, 290,20,20);
		g.setColor(Color.black);
		g.drawString("Digit on Dice 1 : ", 660, 300);
		g.drawString(nos1, 790, 300);
		g.setColor(Color.WHITE);
		g.fillRect(780, 320,20,20);
		g.setColor(Color.black);
		g.drawString("Digit on Dice 2 : ", 660, 330);
		g.drawString(nos2, 790, 330);
		run();
		repaint();
	}
	public void run(){
		try{
			Thread.sleep(2000);
		}catch(Exception e){
			System.out.println("ERROR !!!!");
		}
	}
	public void runP1S(){
		try{
			Thread.sleep(1);
			x1=51;
			y1=408;
			
		}catch(Exception e){
			System.out.println("ERROR !!!!");
		}
	}
	public void runP1(){
		try{
			int oldX1 = x1;
			while(rn1-->=0){
				if(plus1){
					x1+=50;
					if(x1>510 ){
						x1-=50;
						y1-=40;
						
						plus1=false;
						minus1=true;
						
					}
					
				}
				else if(minus1){
					x1-=50;
                       if(x1<50){
						
						plus1=true;
						minus1=false;
						x1+=50;
						y1-=40;
						
					}
                       
				}
				
				Thread.sleep(100);
				
			}
			
			//ladder1:
			if(x1==251&&y1==408){
				runL11();
			}

			//ladder2:
			if(x1==451&&y1==408){
				runL12();
			}
			//ladder3:
			if(x1==51&&y1==368){
				runL13();
				plus1=false;
				minus1=true;
			}
			//ladder4:
			if(x1==251&&y1==328){
				runL14();
				plus1=false;
				minus1=true;
			}
			//ladder5:
			if(x1==251&&y1==288){
				runL15();
				plus1=false;
				minus1=true;
			}
			//ladder6:
			if(x1==51&&y1==248){
				runL16();
				plus1=false;
				minus1=true;
			}
			//ladder7:
			if(x1==451&&y1==248){
				runL17();
				plus1=false;
				minus1=true;
			}
			//ladder8:
			if(x1==201&&y1==168){
				runL18();
				plus1=false;
				minus1=true;
			}
			//ladder9:
			if(x1==451&&y1==168){
				runL19();
				plus1=false;
				minus1=true;
			}
			
			//tube1:
			if(x1==51&&y1==168){
				x1=151;
				y1=408;
			}
			//tube2:
			if(x1==401&&y1==168){
				x1=201;
				y1=408;
				
			}
			//tube3:
			if(x1==451&&y1==288){
				x1=401;
				y1=408;
				plus1=true;
				minus1=false;
				
			}
			//tube4:
			if(x1==451&&y1==208){
				x1=501;
				y1=368;
			}
			//tube5:
			if(x1==201&&y1==48){
				x1=451;
				y1=368;
			}
			//tube6:
			if(x1==101&&y1==248){
				x1=251;
				y1=368;
				plus1=false;
				minus1=true;
			}
			//tube7:
			if(x1==401&&y1==48){
				x1=151;
				y1=368;
			}
			//tube8:
			if(x1==101&&y1==88){
				x1=101;
				y1=328;
			}
			//tube9:
			if(x1==451&&y1==88){
				x1=501;
				y1=248;
			}
			
			//winning point
			if(x1==51&&y1==48){
				win1="yes";
			}		
			
			if(y1<48){
				x1=oldX1;
				y1+=40;
				plus1=false;
				minus1=true;
			}
			
	
			
			
			
			
		}catch(Exception e){
			System.out.println("ERROR !!!!");
		}
	}
	public void runP2S(){
		try{
			Thread.sleep(100);
			x2=54;
			y2=408;
			
		}catch(Exception e){
			System.out.println("ERROR !!!!");
		}
	}
	
	public void runP2(){
		try{
			int oldX2=x2;
			while(rn2-->=0){
				if(plus2){
					x2+=50;
					if(x2>510 ){
						x2-=50;
						y2-=40;
						
						plus2=false;
						minus2=true;
						
					}
					
				}
				else if(minus2){
					x2-=50; 
                    if(x2<50){
						
						plus2=true;
						minus2=false;
						x2+=50;
						y2-=40;
						
					}
                   
				}
				
				
				
					
					
				Thread.sleep(100);
				
			}
			
			//ladder1:
			if(x2==254&&y2==408){
				runL21();
			}

			//ladder2:
			if(x2==454&&y2==408){
				runL22();
			}
			//ladder3:
			if(x2==54&&y2==368){
				runL23();
				plus2=false;
				minus2=true;
			}
			//ladder4:
			if(x2==254&&y2==328){
				runL24();
				plus2=false;
				minus2=true;
			}
			//ladder5:
			if(x2==254&&y2==288){
				runL25();
				plus2=false;
				minus2=true;
			}
			//ladder6:
			if(x2==54&&y2==248){
				runL26();
				plus2=false;
				minus2=true;
			}
			//ladder7:
			if(x2==454&&y2==248){
				runL27();
				plus2=false;
				minus2=true;
			}
			//ladder8:
			if(x2==204&&y2==168){
				runL28();
				plus2=false;
				minus2=true;
			}
			//ladder9:
			if(x2==454&&y2==168){
				runL29();
				plus2=false;
				minus2=true;
			}
			
			//tube1:
			if(x2==54&&y2==168){
				x2=154;
				y2=408;
			}
			//tube2:
			if(x2==404&&y2==168){
				x2=204;
				y2=408;
			}
			//tube3:
			if(x2==454&&y2==288){
				x2=404;
				y2=408;
				plus2=true;
				minus2=false;
			}
			//tube4:
			if(x2==454&&y2==208){
				x2=504;
				y2=368;
			}
			//tube5:
			if(x2==204&&y2==48){
				x2=454;
				y2=368;
			}
			//tube6:
			if(x2==104&&y2==248){
				x2=254;
				y2=368;
				plus2=false;
				minus2=true;
			}
			//tube7:
			if(x2==404&&y2==48){
				x2=154;
				y2=368;
			}
			//tube8:
			if(x2==104&&y2==88){
				x2=104;
				y2=328;
			}
			//tube9:
			if(x2==454&&y2==88){
				x2=504;
				y2=248;
			}
			
			//winning point
			if(x2==54&&y2==48){
				win2="yes";
			}
			if(y2<48){
				x2=oldX2;
				y2+=40;
				plus2=false;
				minus2=true;
			}
			
		}catch(Exception e){
			System.out.println("ERROR !!!!");
		}
	}
	public void runL11(){
		try{
			int[] arrX = {251,273,293,309,322,339,359,374,389,401};
			int[] arrY = {408,392,374,358,336,320,299,278,264,248};
			
			for(int i=0;i<arrX.length;i++){
				x1=arrX[i];
				y1=arrY[i];
				Thread.sleep(1);
			}
			
		}catch(Exception e){
			System.out.println("Error!!!");
		}
	}
	public void runL12(){
		try{
			int[] arrX = {401,461,474,482,491,501};
			int[] arrY = {408,389,372,353,338,328};
			
			for(int i=0;i<arrX.length;i++){
				x1=arrX[i];
				y1=arrY[i];
				Thread.sleep(1);
			}
			
		}catch(Exception e){
			System.out.println("Error!!!");
		}
	}
	public void runL13(){
		try{
			int[] arrX = {51,68,78,88,94,101};
			int[] arrY = {368,348,331,317,301,288};
			
			for(int i=0;i<arrX.length;i++){
				x1=arrX[i];
				y1=arrY[i];
				Thread.sleep(1);
			}
			
		}catch(Exception e){
			System.out.println("Error!!!");
		}
	}
	public void runL14(){
		try{
			int[] arrX = {251,241,238,223,213,201,189,177,166,151};
			int[] arrY = {328,308,301,292,282,265,255,241,232,208};
			
			for(int i=0;i<arrX.length;i++){
				x1=arrX[i];
				y1=arrY[i];
				Thread.sleep(1);
			}
			
		}catch(Exception e){
			System.out.println("Error!!!");
		}
	}
	public void runL15(){
		try{
			int[] arrX = {251,266,267,272,274,280,283,290,295,298,301};
			int[] arrY = {288,263,253,234,210,182,154,127,95,72,48};
			
			for(int i=0;i<arrX.length;i++){
				x1=arrX[i];
				y1=arrY[i];
				Thread.sleep(1);
			}
			
		}catch(Exception e){
			System.out.println("Error!!!");
		}
	}
	public void runL16(){
		try{
			int[] arrX = {51,69,77,81,88,101};
			int[] arrY = {248,229,197,177,157,128};
			
			for(int i=0;i<arrX.length;i++){
				x1=arrX[i];
				y1=arrY[i];
				Thread.sleep(1);
			}
			
		}catch(Exception e){
			System.out.println("Error!!!");
		}
	}
	public void runL17(){
		try{
			int[] arrX = {451,467,476,484,490,501};
			int[] arrY = {248,224,198,172,156,128};
			
			for(int i=0;i<arrX.length;i++){
				x1=arrX[i];
				y1=arrY[i];
				Thread.sleep(1);
			}
			
		}catch(Exception e){
			System.out.println("Error!!!");
		}
	}
	public void runL18(){
		try{
			int[] arrX = {201,184,170,153,141,124,101};
			int[] arrY = {168,147,131,111,98,78,48};
			
			for(int i=0;i<arrX.length;i++){
				x1=arrX[i];
				y1=arrY[i];
				Thread.sleep(1);
			}
			
		}catch(Exception e){
			System.out.println("Error!!!");
		}
	}
	public void runL19(){
		try{
			int[] arrX = {451,438,425,408,394,381,368,351};
			int[] arrY = {168,146,136,119,107,87,70,48};
			
			for(int i=0;i<arrX.length;i++){
				x1=arrX[i];
				y1=arrY[i];
				Thread.sleep(1);
			}
			
		}catch(Exception e){
			System.out.println("Error!!!");
		}
	}
	
	
	public void runL21(){
		try{
			int[] arrX = {254,273,293,309,322,339,359,374,389,404};
			int[] arrY = {408,392,374,358,336,320,299,278,264,248};
			
			for(int i=0;i<arrX.length;i++){
				x2=arrX[i];
				y2=arrY[i];
				Thread.sleep(1);
			}
			
		}catch(Exception e){
			System.out.println("Error!!!");
		}
	}
	public void runL22(){
		try{
			int[] arrX = {404,461,474,482,491,504};
			int[] arrY = {408,389,372,353,338,328};
			
			for(int i=0;i<arrX.length;i++){
				x2=arrX[i];
				y2=arrY[i];
				Thread.sleep(1);
			}
			
		}catch(Exception e){
			System.out.println("Error!!!");
		}
	}
	public void runL23(){
		try{
			int[] arrX = {54,68,78,88,94,104};
			int[] arrY = {368,348,331,317,301,288};
			
			for(int i=0;i<arrX.length;i++){
				x2=arrX[i];
				y2=arrY[i];
				Thread.sleep(1);
			}
			
		}catch(Exception e){
			System.out.println("Error!!!");
		}
	}
	public void runL24(){
		try{
			int[] arrX = {254,241,238,223,213,201,189,177,166,154};
			int[] arrY = {328,308,301,292,282,265,255,241,232,208};
			
			for(int i=0;i<arrX.length;i++){
				x2=arrX[i];
				y2=arrY[i];
				Thread.sleep(1);
			}
			
		}catch(Exception e){
			System.out.println("Error!!!");
		}
	}
	public void runL25(){
		try{
			int[] arrX = {254,266,267,272,274,280,283,290,295,298,304};
			int[] arrY = {288,263,253,234,210,182,154,127,95,72,48};
			
			for(int i=0;i<arrX.length;i++){
				x2=arrX[i];
				y2=arrY[i];
				Thread.sleep(1);
			}
			
		}catch(Exception e){
			System.out.println("Error!!!");
		}
	}
	public void runL26(){
		try{
			int[] arrX = {54,69,77,81,88,104};
			int[] arrY = {248,229,197,177,157,128};
			
			for(int i=0;i<arrX.length;i++){
				x2=arrX[i];
				y2=arrY[i];
				Thread.sleep(1);
			}
			
		}catch(Exception e){
			System.out.println("Error!!!");
		}
	}
	public void runL27(){
		try{
			int[] arrX = {454,467,476,484,490,504};
			int[] arrY = {248,224,198,172,156,128};
			
			for(int i=0;i<arrX.length;i++){
				x2=arrX[i];
				y2=arrY[i];
				Thread.sleep(1);
			}
			
		}catch(Exception e){
			System.out.println("Error!!!");
		}
	}
	public void runL28(){
		try{
			int[] arrX = {204,184,170,153,141,124,104};
			int[] arrY = {168,147,131,111,98,78,48};
			
			for(int i=0;i<arrX.length;i++){
				x2=arrX[i];
				y2=arrY[i];
				Thread.sleep(1);
			}
			
		}catch(Exception e){
			System.out.println("Error!!!");
		}
	}
	public void runL29(){
		try{
			int[] arrX = {454,438,425,408,394,381,368,354};
			int[] arrY = {168,146,136,119,107,87,70,48};
			
			for(int i=0;i<arrX.length;i++){
				x2=arrX[i];
				y2=arrY[i];
				Thread.sleep(1);
			}
			
		}catch(Exception e){
			System.out.println("Error!!!");
		}
	}
	
	
	
	
	public static void main(String[] args){
		new LudoGame();
		Thread t1 = new Thread();
		t1.start();
	}
}

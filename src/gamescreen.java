import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Dimension;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;
import java.awt.SystemColor;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.SwingConstants;
import java.awt.Font;

public class gamescreen extends JPanel {
	public static JPanel contentPane= new JPanel();
	static Random rnd = new Random();
	static JLabel[][] lbl;
	int x=0,y=0;
	static int x1,y1,counter1=0,step=0;
	static int matrix[][];
	static int hiddenGold;
	static players p=new players();
	static Timer myTimer;
	static TimerTask task;
	public static A A;
	public static B B;
	public static C C;
	public static D D;
	public static File fileA,fileB,fileC,fileD;
	public static FileWriter fileWriterA,fileWriterB,fileWriterC,fileWriterD;
	public static BufferedWriter bWriterA,bWriterB,bWriterC,bWriterD;
	public static int controlMatrix() {
		for(int i=0;i<x1;i++) {
			for(int j=0;j<y1;j++) {
				if(matrix[i][j]!=13 & matrix[i][j]!=0) {
					return 1;
				}
			}
		}
		return 0;
	}
	public static void makeVisible(C C) {
		int nearX=0,nearY=0,nearX1=0,nearY1=0;
		int target[][]=new int[x1][y1];
		for(int i=0;i<x1;i++) {
			for(int j=0;j<y1;j++) {
				if(matrix[i][j]==13) {
					target[i][j]=Math.abs(C.location[0][0]-i)+Math.abs(C.location[0][1]-j);
					nearX=i;
					nearY=j;
				}
				else {
					target[i][j]=0;
				}
			}
		}
		int min=(x1*y1)+1;
		if(hiddenGold>0) {
			for(int i=0;i<x1;i++) {
				for(int j=0;j<y1;j++) {
					if(target[i][j]<min && target[i][j]!=0 ) {
						min=target[i][j];
						nearX=i;
						nearY=j;
					}
				}	
			 }
			deger=rnd.nextInt(4)+1;
			deger=deger*5;
			degerS= Integer.toString(deger);
			lbl[nearX][nearY].setBackground(Color.ORANGE);
			lbl[nearX][nearY].setText(degerS);
			matrix[nearX][nearY]=deger;
			hiddenGold--;
		}
		for(int i=0;i<x1;i++) {
			for(int j=0;j<y1;j++) {
				if(matrix[i][j]==13) {
					target[i][j]=Math.abs(C.location[0][0]-i)+Math.abs(C.location[0][1]-j);
					nearX1=i;
					nearY1=j;
				}
				else {
					target[i][j]=0;
				}
			}
		}
		min=(x1*y1)+1;
		if(hiddenGold>0) {
			for(int i=0;i<x1;i++) {
				for(int j=0;j<y1;j++) {
					if(target[i][j]<min && target[i][j]!=0 & nearX!=i & nearY!=j) {
						min=target[i][j];
						nearX1=i;
						nearY1=j;
					}
				}	
			 }
			deger=rnd.nextInt(4)+1;
			deger=deger*5;
			degerS= Integer.toString(deger);
			lbl[nearX1][nearY1].setBackground(Color.ORANGE);
			lbl[nearX1][nearY1].setText(degerS);
			matrix[nearX1][nearY1]=deger;
			hiddenGold--;
		}
		

	}
	public static void searchTarget(players X) {
			int targetX=0,targetY=0,say=0;
			int target[][]=new int[x1][y1];
			if(X.name=="A") {
				if(matrix[A.goal[0][0]][A.goal[0][1]]==0) {
					A.haveGoal=false;
				}
			}
			else if(X.name=="B") {
				if((matrix[B.goal[0][0]][B.goal[0][1]]==0)){
					B.haveGoal=false;
				}
			}
			else if(X.name=="C") {
				if((matrix[C.goal[0][0]][C.goal[0][1]]==0)) {
					C.haveGoal=false;
				}
			}
			else if(X.name=="D") {
				if((matrix[D.goal[0][0]][D.goal[0][1]]==0)) {
					D.haveGoal=false;
				}
			}
			if(X.haveGoal==false & X.goldNumber>X.target) {
				X.spentGold+=X.target;
				X.goldNumber-=X.target;
			for(int i=0;i<x1;i++) {
				for(int j=0;j<y1;j++) {
					if(matrix[i][j]!=0 & matrix[i][j]!=13) {
						target[i][j]=Math.abs(X.location[0][0]-i)+Math.abs(X.location[0][1]-j);
					}
					else {
						target[i][j]=0;
					}
				}
			}
			if(counter1%4==0) {
				int min=x1+1;
				for(int i=0;i<x1;i++) {
					for(int j=0;j<y1;j++) {
						if(target[i][j]<=min & target[i][j]!=0) {
							targetX=i;
							targetY=j;
							min=target[i][j];
							say++;
							}
						}	
				 }	
			}
			else if(counter1%4==1 || counter1%4==2 || counter1%4==3) {
				float max=0;
				float maliyet=0;
				for(int i=0;i<x1;i++) {
					for(int j=0;j<y1;j++) {
						if(target[i][j]!=0 & matrix[i][j]!=0 & matrix[i][j]!=13) {
							maliyet=(float)matrix[i][j]/target[i][j]; 
							max=maliyet;
							if(X.name!="D") {
								targetX=i;
								targetY=j;
							}
							say++;
							break;
						}
					}	
				 }
				int c=0,d=0,ak=0,bk=0,ck=0;
				for(int i=0;i<x1;i++) {
					for(int j=0;j<y1;j++) {
						if(target[i][j]!=0 && matrix[i][j]!=0 & matrix[i][j]!=13) {
							maliyet=(float)matrix[i][j]/target[i][j]; 
						}
						if(max<=maliyet & counter1%4==3 & target[i][j]!=0 & matrix[i][j]!=0 & matrix[i][j]!=13) {
					    if((i!=A.goal[0][0] & j!=A.goal[0][1])){
							 ak++;
					     }
					    if((i==A.goal[0][0] & j!=A.goal[0][1])) {
					    	ak++;
					    }
					    if((i!=A.goal[0][0] & j==A.goal[0][1])) {
					    	ak++;
					    }
					    if((i!=B.goal[0][0] & j!=B.goal[0][1])) {
					    	bk++;
					    }
					    if((i==B.goal[0][0] & j!=B.goal[0][1])) {
					    	bk++;
					    }
					    if((i!=B.goal[0][0] & j==B.goal[0][1])) {
					    	bk++;
					    }
					    if((i!=C.goal[0][0] & j!=C.goal[0][1])) {
					    	ck++;
					    }
					    if((i==C.goal[0][0] & j!=C.goal[0][1])) {
					    	ck++;
					    }
					    if((i!=C.goal[0][0] & j==C.goal[0][1])) {
					    	ck++;
					    }
					    if(ak==0 | bk==0 | ck==0) {
					    if((i==A.goal[0][0] & j==A.goal[0][1] & target[i][j]-3<=A.x)) {
					    	  d++;
					    	}
					    else if( (i==B.goal[0][0] & j==B.goal[0][1] & target[i][j]-3<=B.x)) {
					    	d++;
					    }
					    else if((i==C.goal[0][0] & j==C.goal[0][1] & target[i][j]-3<=C.x)) {
								d++;		    	
					     }
					    if(d==3) {
					    	max=maliyet;
					    	 targetX=i;
							 targetY=j;
							 say++;
							 ak=0; bk=0; ck=0; d=0;
					    }
					    else {
					    	targetX=D.location[0][0];
					    	targetY=D.location[0][1];
					    	ak=0; bk=0; ck=0; d=0;
					    }
						}
					    if(ak!=0 & bk!=0 & ck!=0) {
					    	max=maliyet;
					    	 targetX=i;
							 targetY=j;
							 say++;
							 ak=0; bk=0; ck=0; d=0;
					    } }
						else if(max<maliyet & target[i][j]!=0 & counter1%4!=3) {
							max=maliyet;
							targetX=i;
							targetY=j;
							say++;
						}	
				 }
			} }
			if(say!=0) {
				X.goal[0][0]=targetX;
				X.goal[0][1]=targetY;
				X.haveGoal=true;
			}
			else {
				X.goal[0][0]=X.location[0][0];
				X.goal[0][1]=X.location[0][1];
				X.haveGoal=true;
			}
		}
			
	}
	static String str,degerS;
	static int number,deger;
	static int s=0;
	static void printDistance(players X) 
    { 
		step=0;
		myTimer=new Timer();
		task =new TimerTask() {
            public void run() {
            	if(step==0) {
            		lbl[X.location[0][0]][X.location[0][1]].setText(X.name);
            		step++;
            	}
            	else {
    				if(matrix[X.location[0][0]][X.location[0][1]]==13  & s==0) {
    					deger=rnd.nextInt(4)+1;
    					deger=deger*5;
    					degerS= Integer.toString(deger);
    					lbl[X.location[0][0]][X.location[0][1]].setBackground(Color.ORANGE);
    					lbl[X.location[0][0]][X.location[0][1]].setText(X.name+""+degerS);
    					matrix[X.location[0][0]][X.location[0][1]]=deger;
    					hiddenGold--;
    				}
            	if(lbl[X.location[0][0]][X.location[0][1]].getText()==X.name & s==0) {
            		lbl[X.location[0][0]][X.location[0][1]].setText(str);
    					str="";
    			}
    		    else if(lbl[X.location[0][0]][X.location[0][1]].getText()!=X.name & s==0){
    		    str=lbl[X.location[0][0]][X.location[0][1]].getText();
    			str=str.substring(1,str.length());
    			if(Character.isDigit(str.charAt(0))) {
    					lbl[X.location[0][0]][X.location[0][1]].setText(str);
    				}
    				str="";
    			}
				if(X.location[0][0]<X.goal[0][0] & s==0) {
					X.stepnumber++;
					step++;
					X.location[0][0]+=1;
					lbl[X.location[0][0]][X.location[0][1]].setText(X.name);
					if(X.name=="A") {
            			try {
							bWriterA.write(X.location[0][0]+" "+X.location[0][1]+"\n->");
						} catch (IOException e) {
							e.printStackTrace();
						}
            		}
					if(X.name=="B") {
            			try {
							bWriterB.write(X.location[0][0]+" "+X.location[0][1]+"\n->");
						} catch (IOException e) {
							e.printStackTrace();
						}
            		}
					if(X.name=="C") {
            			try {
							bWriterC.write(X.location[0][0]+" "+X.location[0][1]+"\n->");
						} catch (IOException e) {
							e.printStackTrace();
						}
            		}
					if(X.name=="D") {
            			try {
							bWriterD.write(X.location[0][0]+" "+X.location[0][1]+"\n->");
						} catch (IOException e) {
							e.printStackTrace();
						}
            		}
				}
				else if(X.location[0][0]>X.goal[0][0] & s==0) {
					X.stepnumber++;
					step++;
					X.location[0][0]-=1;
					lbl[X.location[0][0]][X.location[0][1]].setText(X.name);
					if(X.name=="A") {
            			try {
							bWriterA.write(X.location[0][0]+" "+X.location[0][1]+"\n->");
						} catch (IOException e) {
							e.printStackTrace();
						}
            		}
					if(X.name=="B") {
            			try {
							bWriterB.write(X.location[0][0]+" "+X.location[0][1]+"\n->");
						} catch (IOException e) {
							e.printStackTrace();
						}
            		}
					if(X.name=="C") {
            			try {
							bWriterC.write(X.location[0][0]+" "+X.location[0][1]+"\n->");
						} catch (IOException e) {
							e.printStackTrace();
						}
            		}
					if(X.name=="D") {
            			try {
							bWriterD.write(X.location[0][0]+" "+X.location[0][1]+"\n->");
						} catch (IOException e) {
							e.printStackTrace();
						}
            		}
				}
				else if(X.location[0][1]<X.goal[0][1] & s==0) {
					X.stepnumber++;
					step++;
					X.location[0][1]+=1;
					lbl[X.location[0][0]][X.location[0][1]].setText(X.name);
					if(X.name=="A") {
            			try {
							bWriterA.write(X.location[0][0]+" "+X.location[0][1]+"\n->");
						} catch (IOException e) {
							e.printStackTrace();
						}
            		}
					if(X.name=="B") {
            			try {
							bWriterB.write(X.location[0][0]+" "+X.location[0][1]+"\n->");
						} catch (IOException e) {
							e.printStackTrace();
						}
            		}
					if(X.name=="C") {
            			try {
							bWriterC.write(X.location[0][0]+" "+X.location[0][1]+"\n->");
						} catch (IOException e) {
							e.printStackTrace();
						}
            		}
					if(X.name=="D") {
            			try {
							bWriterD.write(X.location[0][0]+" "+X.location[0][1]+"\n->");
						} catch (IOException e) {
							e.printStackTrace();
						}
            		}
				}
				else if(X.location[0][1]>X.goal[0][1] & s==0) {
					X.stepnumber++;
					step++;
					X.location[0][1]-=1;
					lbl[X.location[0][0]][X.location[0][1]].setText(X.name);
					if(X.name=="A") {
            			try {
							bWriterA.write(X.location[0][0]+" "+X.location[0][1]+"\n->");
						} catch (IOException e) {
							e.printStackTrace();
						}
            		}
					if(X.name=="B") {
            			try {
							bWriterB.write(X.location[0][0]+" "+X.location[0][1]+"\n->");
						} catch (IOException e) {
							e.printStackTrace();
						}
            		}
					if(X.name=="C") {
            			try {
							bWriterC.write(X.location[0][0]+" "+X.location[0][1]+"\n->");
						} catch (IOException e) {
							e.printStackTrace();
						}
            		}
					if(X.name=="D") {
            			try {
							bWriterD.write(X.location[0][0]+" "+X.location[0][1]+"\n->");
						} catch (IOException e) {
							e.printStackTrace();
						}
            		}
				}
				if(controlMatrix()==0) {
					 s++;
					try {
						bWriterA.close();
						 bWriterB.close();
					     bWriterC.close();
					     bWriterD.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
                    for(int i=0;i<x1;i++) {
                        for(int j=0;j<y1;j++) {
                            lbl[i][j].setVisible(false);
                        }
                    }
                    endscreen es=new endscreen();
                    es.lblCga.setText(Integer.toString(A.total));
                    es.lblCgb.setText(Integer.toString(B.total));
                    es.lblCgc.setText(Integer.toString(C.total));
                    es.lblCgd.setText(Integer.toString(D.total));
                    es.lblCa.setText(Integer.toString(A.goldNumber));
                    es.lblCb.setText(Integer.toString(B.goldNumber));
                    es.lblCc.setText(Integer.toString(C.goldNumber));
                    es.lblCd.setText(Integer.toString(D.goldNumber));
                    es.lblTa.setText(Integer.toString(A.stepnumber));
                    es.lblTb.setText(Integer.toString(B.stepnumber));
                    es.lblTc.setText(Integer.toString(C.stepnumber));
                    es.lblTd.setText(Integer.toString(D.stepnumber));
                    es.lblSa.setText(Integer.toString(A.spentGold));
                    es.lblSb.setText(Integer.toString(B.spentGold));
                    es.lblSc.setText(Integer.toString(C.spentGold));
                    es.lblSd.setText(Integer.toString(D.spentGold));
					myTimer.cancel();
					contentPane.setBounds(0,0,979,530);
                    screen.frame.setBounds(10,10,979,530);
                    es.contentPane.setBounds(0,0,979,530);
                    contentPane.add(es.contentPane);
                    contentPane.revalidate(); 
                    contentPane.repaint();
                }
				if(X.location[0][0]==X.goal[0][0] & X.location[0][1]==X.goal[0][1] & s==0) {
					if(X.goldNumber>0) {
						X.goldNumber-=X.move;
						X.spentGold+=X.move;
					}
					X.total+=matrix[X.location[0][0]][X.location[0][1]];
					X.goldNumber+=matrix[X.location[0][0]][X.location[0][1]];
					if(X.name=="C" & hiddenGold>0 & matrix[X.goal[0][0]][X.goal[0][1]]!=0 & s==0) {
						makeVisible(C);
					}
					matrix[X.goal[0][0]][X.goal[0][1]]=0;
					myTimer.cancel();
					counter1++;
					if(counter1%4==0 & s==0) {
						searchTarget(A);
						printDistance(A);
						X.haveGoal=false;
						searchTarget(A);
					}
					else if(counter1%4==1 & s==0) {
						searchTarget(B);
						printDistance(B);
						X.haveGoal=false;
						searchTarget(B);
					}
					else if(counter1%4==2 & s==0) {
						searchTarget(C);
						printDistance(C);
						X.haveGoal=false;
						searchTarget(C);
					}
					else if(counter1%4==3 & s==0) {
						A.x=Math.abs(A.location[0][0]-A.goal[0][0])+Math.abs(A.location[0][1]-A.goal[0][1]);
						B.x=Math.abs(B.location[0][0]-B.goal[0][0])+Math.abs(B.location[0][1]-B.goal[0][1]);
						C.x=Math.abs(C.location[0][0]-C.goal[0][0])+Math.abs(C.location[0][1]-C.goal[0][1]);
						searchTarget(D);
						printDistance(D);
						X.haveGoal=false;
					}
				}
				if(matrix[X.location[0][0]][X.location[0][1]]!=0 && matrix[X.location[0][0]][X.location[0][1]]!=13 & s==0) {
					X.total+=matrix[X.location[0][0]][X.location[0][1]];
					X.goldNumber+=matrix[X.location[0][0]][X.location[0][1]];
					matrix[X.location[0][0]][X.location[0][1]]=0;
				}
            }
				if(step==p.getStep()+1 & s==0) {
					if(X.goldNumber>0) {
						X.goldNumber-=X.move;
						X.spentGold+=X.move;
					}
					myTimer.cancel();
					counter1++;
					if(counter1%4==0) {
						searchTarget(A);
						printDistance(A);
						searchTarget(A);
					}
					else if(counter1%4==1) {
						searchTarget(B);
						printDistance(B);
						searchTarget(B);				
					}
					else if(counter1%4==2) {
						searchTarget(C);
						printDistance(C);
						searchTarget(C);
					}
					else if(counter1%4==3) {
						A.x=Math.abs(A.location[0][0]-A.goal[0][0])+Math.abs(A.location[0][1]-A.goal[0][1]);
						B.x=Math.abs(B.location[0][0]-B.goal[0][0])+Math.abs(B.location[0][1]-B.goal[0][1]);
						C.x=Math.abs(C.location[0][0]-C.goal[0][0])+Math.abs(C.location[0][1]-C.goal[0][1]);
						searchTarget(D);
						printDistance(D);
					}
				}
            } 
	     }; myTimer.schedule(task,10,500);
	     
	    
    } 
	public gamescreen(int a,int b,double c,double d,int code) {
        /* Estetik görüntüyü saglayamadigimiz icin silmek durumunda kaldik
         * contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(null);
        contentPane.setBounds(0,0,b*33,a*33);
		JPanel panel=new JPanel();
		JScrollPane scrollPane = new JScrollPane(panel);
        panel.setLayout(null);
        panel.setBounds(0,0,b*32,a*32);
        panel.setPreferredSize(new Dimension(1000,5000));

        scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.setBounds(0,0,b*32,a*32);
        contentPane.add(scrollPane);*/
		A=new A();
		B=new B();
		C=new C();
		D=new D();
		x1=b; y1=a;
		int gold;
		gold=(int)(a*b*c);
		if(gold==a*b) {
			gold=gold-4;
		}
		hiddenGold=(int)(gold*d);
		int arrayX[]= new int[gold];
		int arrayY[]= new int[gold];
		int hidden[]= new int[hiddenGold];
		for(int i=0;i<gold;i++) {
			arrayX[i]= rnd.nextInt(x1);
			arrayY[i]= rnd.nextInt(y1);
		}
		matrix=new int[b][a];
		for(int i=0;i<b;i++) {
			for(int j=0;j<a;j++) {
				matrix[i][j]=0;
			}
		}
		
		boolean kontrol=true;
		while(kontrol) {
			
		for(int i=0;i<gold;i++) {
			for(int j=0;j<gold;j++) {
				if(arrayX[i]==arrayX[j] && arrayY[i]==arrayY[j] && i!=j) {
					kontrol=true;
					arrayX[i]= rnd.nextInt(x1);
					arrayY[i]= rnd.nextInt(y1);
					i=0; j=0;
				}
				if((arrayX[i]==0 && arrayY[i]==0) || (arrayX[i]==0 && arrayY[i]==y1-1) || (arrayX[i]==x1-1 && arrayY[i]==0) || (arrayX[i]==x1-1 && arrayY[i]==y1-1)) {
					kontrol=true;
					arrayX[i]= rnd.nextInt(x1);
					arrayY[i]= rnd.nextInt(y1);
					i=0; j=0;
				}
				if(arrayX[i]==0 | arrayY[i]==0 | arrayX[i]==x1-1 | arrayY[i]==x1-1 | arrayX[i]==y1-1  | arrayY[i]==y1-1) {
					kontrol=true;
					arrayX[i]= rnd.nextInt(x1);
					arrayY[i]= rnd.nextInt(y1);
					i=0; j=0;
				}
			}
			kontrol=false;
		}
	}

		lbl=new JLabel[x1][y1];
		setLayout(null);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		
		for(int i=0;i<x1;i++) {
			for(int j=0;j<y1;j++) {
				lbl[i][j]=new JLabel();
				lbl[i][j].setFont(new Font("Tahoma", Font.PLAIN, 20));
				lbl[i][j].setHorizontalAlignment(SwingConstants.CENTER);
				lbl[i][j].setOpaque(true);
				lbl[i][j].setBackground(SystemColor.inactiveCaption);
				lbl[i][j].setBounds(x,y,30,30);
				contentPane.add(lbl[i][j]);
				x+=31;
			}
			x=0;
			y+=31;
		}
		int deger;
		String degerS;
		for(int i=0;i<gold;i++) {
			lbl[arrayX[i]][arrayY[i]].setBackground(Color.ORANGE);
			deger=rnd.nextInt(4)+1;
			deger=deger*5;
			degerS= Integer.toString(deger);
			lbl[arrayX[i]][arrayY[i]].setText(degerS);
			matrix[arrayX[i]][arrayY[i]]=deger;
		}
		for(int i=0;i<hiddenGold;i++) {
			hidden[i]=rnd.nextInt(gold);
		}
		boolean kontrol1=true;
		while(kontrol1) {
			for(int i=0;i<hiddenGold;i++) {
				for(int j=0;j<hiddenGold;j++) {
					if(hidden[i]==hidden[j] & i!=j) {
						kontrol1=true;
						hidden[i]=rnd.nextInt(gold);
						i=0; j=0;
					}
				}
				kontrol1=false;
			}
		}
		for(int i=0;i<hiddenGold;i++) {
			lbl[arrayX[hidden[i]]][arrayY[hidden[i]]].setBackground(Color.RED);
			matrix[arrayX[hidden[i]]][arrayY[hidden[i]]]=13;
			lbl[arrayX[hidden[i]]][arrayY[hidden[i]]].setText(" ");
		}
		
		lbl[0][0].setText("A");
		lbl[0][y1-1].setText("B");
		lbl[x1-1][y1-1].setText("C");
		lbl[x1-1][0].setText("D");
	
		A.location[0][0]=0; A.location[0][1]=0;
		B.location[0][0]=0;	B.location[0][1]=a-1;
		C.location[0][0]=b-1; C.location[0][1]=a-1;
		D.location[0][0]=b-1; D.location[0][1]=0;
		
		fileA = new File("fileA.txt");
		fileB = new File("fileB.txt");
		fileC = new File("fileC.txt");
		fileD = new File("fileD.txt");
		 if (!fileA.exists() | !fileB.exists()  | !fileC.exists()  | !fileD.exists() ) {
	            try {
					fileA.createNewFile();
					fileB.createNewFile();
					fileC.createNewFile();
					fileD.createNewFile();
				} catch (IOException e) {
					e.printStackTrace();
				}
	        }
		if(code==2) {
			A.target=(Integer.parseInt(changescreen.targetA.getText()));
			B.target=(Integer.parseInt(changescreen.targetB.getText()));
			C.target=(Integer.parseInt(changescreen.targetC.getText()));
			D.target=(Integer.parseInt(changescreen.targetD.getText()));
			A.move=(Integer.parseInt(changescreen.moveA.getText()));
			B.move=(Integer.parseInt(changescreen.moveB.getText()));
			C.move=(Integer.parseInt(changescreen.moveC.getText()));
			D.move=(Integer.parseInt(changescreen.moveD.getText()));
			p.step=Integer.parseInt(changescreen.step.getText());
			A.goldNumber=Integer.parseInt(changescreen.goldNumber.getText());
			B.goldNumber=Integer.parseInt(changescreen.goldNumber.getText());
			C.goldNumber=Integer.parseInt(changescreen.goldNumber.getText());
			D.goldNumber=Integer.parseInt(changescreen.goldNumber.getText());
		}

		try {
			fileWriterA = new FileWriter(fileA,true);
			fileWriterB = new FileWriter(fileB,true);
			fileWriterC = new FileWriter(fileC,true);
			fileWriterD = new FileWriter(fileD,true);
			bWriterA = new BufferedWriter(fileWriterA);
			bWriterB = new BufferedWriter(fileWriterB);
			bWriterC = new BufferedWriter(fileWriterC);
			bWriterD = new BufferedWriter(fileWriterD);
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			bWriterA.write(A.location[0][0]+" "+A.location[0][1]+"\n->");
			bWriterB.write(B.location[0][0]+" "+B.location[0][1]+"\n->");
			bWriterC.write(C.location[0][0]+" "+C.location[0][1]+"\n->");
			bWriterD.write(D.location[0][0]+" "+D.location[0][1]+"\n->");
		} catch (IOException e) {
			e.printStackTrace();
		}
		searchTarget(A);
		printDistance(A);		
	}
}

package accounting;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

public class MainProgram extends JFrame {
	String company;
	String typeindex;
	Container c;
	CardLayout card;
	
	Menu menupanel;
	BasicInformation basicinformation;
	SalesCompany salescompany;
	ServiceCompany servicecompany;
	DrawSOCI_sales soci1;
	DrawSOCI_service soci2;
	DrawSOFP sofp;
	
	int 현금, 매출채권, 상품, 선급보험료, 단기대여금;
	int 상품매입가격, 상품판매가격, 상품개수;
	int 용역수익;
	int 매입채무, 미지급비용;
	int 자본금, 이익잉여금;
	int 매출액, 매출원가, 매출총이익 = 매출액 - 매출원가;
	int 종업원급여, 운송비, 통신비, 임차료, 보험료, 광고비;
	int 판매관리비;
	int 당기순이익, 기타포괄이익, 당기포괄이익;
	
	public MainProgram() {
		setTitle("회계관리 프로그램");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		c = getContentPane();
		card = new CardLayout();
		c.setLayout(card);
		
		menupanel = new Menu();
		basicinformation = new BasicInformation();
		salescompany = new SalesCompany();
		servicecompany = new ServiceCompany();
		soci1 = new DrawSOCI_sales();
		soci2 = new DrawSOCI_service();
		sofp = new DrawSOFP();
		
		add("1", menupanel);
		add("2", basicinformation);
		add("3", salescompany);
		add("4", servicecompany);
		add("5", soci1);
		add("6", soci2);
		add("7", sofp);
		
		setSize(1000, 800);
		setVisible(true);		
	}
	class Menu extends JPanel{
		public Menu() {
			setLayout(null);
			
			JLabel title1 = new JLabel("재무회계를 시작합니다.");
			JLabel title2 = new JLabel("기업의 이름을 입력 후 종류를 선택해 주세요.");
			title1.setBounds(350, 100, 800, 100);
			title1.setFont(new Font("Gothic", Font.PLAIN, 30));
			title2.setBounds(200, 200, 800, 100);
			title2.setFont(new Font("Gothic", Font.PLAIN, 30));
			
			JLabel companyname = new JLabel("기업명을 입력하세요 : ");
			JTextField tf = new JTextField();
			companyname.setBounds(200, 300, 400, 100);
			companyname.setFont(new Font("Gothic", Font.PLAIN, 15));
			tf.setBounds(350, 325, 400, 50);
						
			JButton companytype1 = new JButton("상품매매기업");
			JButton companytype2 = new JButton("서비스기업");
			companytype1.setBounds(250, 450, 200, 50);
			companytype1.setFont(new Font("Gothic", Font.PLAIN, 20));
			companytype2.setBounds(550, 450, 200, 50);
			companytype2.setFont(new Font("Gothic", Font.PLAIN, 20));
			
			tf.addActionListener(new CompanyNameListener());
			companytype1.addActionListener(new CompanyTypeListener());
			companytype2.addActionListener(new CompanyTypeListener());
			
			add(title1);
			add(title2);
			
			add(companyname);
			
			add(tf);
			
			add(companytype1);
			add(companytype2);
			
		}
		class CompanyNameListener implements ActionListener{
			public void actionPerformed(ActionEvent e) {
				JTextField t = (JTextField)e.getSource();
				company = t.getText();
				
				JLabel companyname1 = new JLabel(company);
				companyname1.setBounds(350, 0, 800, 100);
				companyname1.setFont(new Font("Gothic", Font.PLAIN, 50));
				salescompany.add(companyname1);
				
				JLabel companyname2 = new JLabel(company);
				companyname2.setBounds(350, 0, 800, 100);
				companyname2.setFont(new Font("Gothic", Font.PLAIN, 50));
				servicecompany.add(companyname2);
				
				JLabel companyname3 = new JLabel(company);
				companyname3.setBounds(20, 70, 400, 50);
				companyname3.setFont(new Font("Gothic", Font.PLAIN, 30));
				soci1.add(companyname3);
				
				JLabel companyname4 = new JLabel(company);
				companyname4.setBounds(20, 70, 400, 50);
				companyname4.setFont(new Font("Gothic", Font.PLAIN, 30));
				soci2.add(companyname4);
				
				JLabel companyname5 = new JLabel(company);
				companyname5.setBounds(20, 70, 400, 50);
				companyname5.setFont(new Font("Gothic", Font.PLAIN, 30));
				sofp.add(companyname5);
			}
		}
		class CompanyTypeListener implements ActionListener{
			public void actionPerformed(ActionEvent e) {
				JButton b = (JButton)e.getSource();
				typeindex = b.getText();
				
				card.show(c, "2");
			}
		}
	}
	class BasicInformation extends JPanel{
		int left, right;
		JLabel leftsum;
		JLabel rightsum;
		public BasicInformation() {
			setLayout(null);
			
			JLabel formeraccount = new JLabel("이전 정보를 입력하세요.");
			JLabel asset1 = new JLabel("현금");
			JLabel asset2 = new JLabel("매출채권");
			JLabel asset3 = new JLabel("상품");
			JLabel asset4 = new JLabel("선급보험료");
			JLabel asset5 = new JLabel("단기대여금");
			JLabel liability1 = new JLabel("매입채무");
			JLabel liability2 = new JLabel("미지급비용");
			JLabel capital1 = new JLabel("자본금");
			JLabel capital2 = new JLabel("이익 잉여금");
			formeraccount.setBounds(300, 50, 600, 50);
		    formeraccount.setFont(new Font("Gothic", Font.PLAIN, 40));
		    asset1.setBounds(100, 150, 200, 50);
		    asset1.setFont(new Font("Gothic", Font.PLAIN, 30));
		    asset2.setBounds(100, 200, 200, 50);
		    asset2.setFont(new Font("Gothic", Font.PLAIN, 30));
		    asset3.setBounds(100, 250, 200, 50);
		    asset3.setFont(new Font("Gothic", Font.PLAIN, 30));
		    asset4.setBounds(100, 300, 200, 50);
		    asset4.setFont(new Font("Gothic", Font.PLAIN, 30));
		    asset5.setBounds(100, 350, 200, 50);
		    asset5.setFont(new Font("Gothic", Font.PLAIN, 30));
		    liability1.setBounds(450, 150, 200, 50);
		    liability1.setFont(new Font("Gothic", Font.PLAIN, 30));
		    liability2.setBounds(450, 200, 200, 50);
		    liability2.setFont(new Font("Gothic", Font.PLAIN, 30));
		    capital1.setBounds(450, 300, 200, 50);
		    capital1.setFont(new Font("Gothic", Font.PLAIN, 30));
		    capital2.setBounds(450, 350, 200, 50);
		    capital2.setFont(new Font("Gothic", Font.PLAIN, 30));
		    
		    JButton check = new JButton("계산 확인");
		    JButton warn = new JButton("<주의> 반드시 좌측 열과 우측 열의 합이 같게 설정해 주세요.");
		    JButton put = new JButton("<주의> 각 칸마다 <Enter>키를 입력하셔야 정보가 저장됩니다.");
		    JButton nextbutton = new JButton("Next");
		    check.setBounds(800, 360, 100, 30);
		    warn.setBounds(250, 570, 400, 30);
		    put.setBounds(250, 600, 400, 30);
			nextbutton.setBounds(910, 725, 70, 30);
			
			JTextField assettf1 = new JTextField();
			JTextField assettf2 = new JTextField();
			JTextField assettf3 = new JTextField();
			JTextField assettf4 = new JTextField();
			JTextField assettf5 = new JTextField();
			JTextField liabilitytf1 = new JTextField();
			JTextField liabilitytf2 = new JTextField();
			JTextField capitaltf1 = new JTextField();
			JTextField capitaltf2 = new JTextField();
			assettf1.setBounds(300, 160, 100, 30);
			assettf2.setBounds(300, 210, 100, 30);
			assettf3.setBounds(300, 260, 100, 30);
			assettf4.setBounds(300, 310, 100, 30);
			assettf5.setBounds(300, 360, 100, 30);
			liabilitytf1.setBounds(650, 160, 100, 30);
			liabilitytf2.setBounds(650, 210, 100, 30);
			capitaltf1.setBounds(650, 310, 100, 30);
			capitaltf2.setBounds(650, 360, 100, 30);
			
			assettf1.addActionListener(new Asset1Listener());
			assettf2.addActionListener(new Asset2Listener());
			assettf3.addActionListener(new Asset3Listener());
			assettf4.addActionListener(new Asset4Listener());
			assettf5.addActionListener(new Asset5Listener());
			liabilitytf1.addActionListener(new Liability1Listener());
			liabilitytf2.addActionListener(new Liability2Listener());
			capitaltf1.addActionListener(new Capital1Listener());
			capitaltf2.addActionListener(new Capital2Listener());
			check.addActionListener(new CheckListener());
			nextbutton.addActionListener(new NextListener());
			
			add(formeraccount);
			add(asset1);
			add(asset2);
			add(asset3);
			add(asset4);
			add(asset5);
			add(liability1);
			add(liability2);
			add(capital1);
			add(capital2);
			
			add(check);
			add(warn);
			add(put);
			add(nextbutton);
			
			add(assettf1);
			add(assettf2);
			add(assettf3);
			add(assettf4);
			add(assettf5);
			add(liabilitytf1);
			add(liabilitytf2);
			add(capitaltf1);
			add(capitaltf2);
			
			left = 현금 + 매출채권 + 상품 + 선급보험료 + 단기대여금;
			right = 매입채무 + 미지급비용 + 자본금 + 이익잉여금;
			
			leftsum = new JLabel("좌측 열의 합 : " + Integer.toString(left));
			rightsum = new JLabel("우측 열의 합 : " + Integer.toString(right));
			leftsum.setBounds(100, 400, 500, 100);
			leftsum.setFont(new Font("Gothic", Font.PLAIN, 30));
			rightsum.setBounds(450, 400, 500, 100);
			rightsum.setFont(new Font("Gothic", Font.PLAIN, 30));
								
			add(leftsum);
			add(rightsum);	
		}
		class Asset1Listener implements ActionListener{
			public void actionPerformed(ActionEvent e) {
				JTextField tf = (JTextField)e.getSource();
				현금 = Integer.parseInt(tf.getText());
			}
		}
		class Asset2Listener implements ActionListener{
			public void actionPerformed(ActionEvent e) {
				JTextField tf = (JTextField)e.getSource();
				매출채권 = Integer.parseInt(tf.getText());
			}
		}
		class Asset3Listener implements ActionListener{
			public void actionPerformed(ActionEvent e) {
				JTextField tf = (JTextField)e.getSource();
				상품 = Integer.parseInt(tf.getText());
			}
		}
		class Asset4Listener implements ActionListener{
			public void actionPerformed(ActionEvent e) {
				JTextField tf = (JTextField)e.getSource();
				선급보험료 = Integer.parseInt(tf.getText());
			}
		}
		class Asset5Listener implements ActionListener{
			public void actionPerformed(ActionEvent e) {
				JTextField tf = (JTextField)e.getSource();
				단기대여금 = Integer.parseInt(tf.getText());
			}
		}
		class Liability1Listener implements ActionListener{
			public void actionPerformed(ActionEvent e) {
				JTextField tf = (JTextField)e.getSource();
				매입채무 = Integer.parseInt(tf.getText());
			}
		}
		class Liability2Listener implements ActionListener{
			public void actionPerformed(ActionEvent e) {
				JTextField tf = (JTextField)e.getSource();
				미지급비용 = Integer.parseInt(tf.getText());
			}
		}
		class Capital1Listener implements ActionListener{
			public void actionPerformed(ActionEvent e) {
				JTextField tf = (JTextField)e.getSource();
				자본금 = Integer.parseInt(tf.getText());
			}
		}
		class Capital2Listener implements ActionListener{
			public void actionPerformed(ActionEvent e) {
				JTextField tf = (JTextField)e.getSource();
			    이익잉여금 = Integer.parseInt(tf.getText());
			}
		}		
		class CheckListener implements ActionListener{
			public void actionPerformed(ActionEvent e) {
				left = 현금 + 매출채권 + 상품 + 선급보험료 + 단기대여금;
				right = 매입채무 + 미지급비용 + 자본금 + 이익잉여금;
				leftsum.setText("좌측 합 : " + Integer.toString(left));
				rightsum.setText("우측 합 : "+ Integer.toString(right));					
			}
		}
		class NextListener implements ActionListener{
			public void actionPerformed(ActionEvent e) {
				if(typeindex.equals("상품매매기업")) {
					card.show(c, "3");
				}
				else if(typeindex.equals("서비스기업")) {
					card.show(c, "4");
				}
			}
		}
	}
	class SalesCompany extends JPanel{
		String dealtype;
		public SalesCompany() {
			setLayout(null);
			
			JLabel sentence1 = new JLabel("회계기간을 선택하고, 거래정보를 입력하십시오.");
			JLabel sentence2 = new JLabel("연도를 선택하십시오 : ");
			JLabel sentence3 = new JLabel("거래 일자와 종류를 선택하고, 금액을 입력하십시오.");
			JLabel dealdate = new JLabel("거래 일자 : ");
			JLabel deallist = new JLabel("거래 종류 : ");
			JLabel dealamount = new JLabel("거래 금액 : ");
			JLabel caution1 = new JLabel("(상품 매입 거래를 선택 시, 금액란에 상품원가, 상품 개수 의 형식으로 작성해주세요.)");
			JLabel caution2 = new JLabel("(상품 판매 거래를 선택 시, 금액란에 판매가격, 상품 개수 의 형식으로 작성해주세요.)");
			JLabel caution3 = new JLabel("(상품 매입을 먼저 입력한 후 상품 판매를 입력해 주세요.)");
			
			sentence1.setBounds(150, 100, 800, 100);
			sentence1.setFont(new Font("Gothic", Font.PLAIN, 30));
			sentence2.setBounds(150, 200, 800, 100);
			sentence2.setFont(new Font("Gothic", Font.PLAIN, 20));
			sentence3.setBounds(150, 260, 800, 100);
			sentence3.setFont(new Font("Gothic", Font.PLAIN, 20));
			dealdate.setBounds(150, 320, 100, 100);
			dealdate.setFont(new Font("Gothic", Font.PLAIN, 20));
			deallist.setBounds(150, 390, 100, 100);
			deallist.setFont(new Font("Gothic", Font.PLAIN, 20));
			dealamount.setBounds(150, 450, 100, 100);
			dealamount.setFont(new Font("Gothic", Font.PLAIN, 20));
			caution1.setBounds(410, 405, 600, 20);
			caution1.setFont(new Font("Gothic", Font.PLAIN, 15));
			caution2.setBounds(410, 420, 600, 20);
			caution2.setFont(new Font("Gothic", Font.PLAIN, 15));
			caution3.setBounds(410, 435, 600, 20);
			caution3.setFont(new Font("Gothic", Font.PLAIN, 15));
			
			JButton putinfobutton = new JButton("거래 정보 입력");
			JButton finishbutton = new JButton("당기의 거래 기록을 완료합니다.");
			putinfobutton.setBounds(580, 477, 150, 40);
			finishbutton.setBounds(150, 600, 700, 50);
			
			String [] month = {"1월", "2월", "3월", "4월", "5월", "6월", "7월", "8월", "9월", "10월", "11월", "12월"};
			JComboBox<String> monthlist = new JComboBox<String>(month);
			monthlist.setBounds(250, 350, 100, 40);
			
			String [] date = new String[31];
			for(int i=0; i<31; i++) {
				date[i] = Integer.toString(i+1);
				date[i] = date[i].concat("일");
			}
			JComboBox<String> datelist = new JComboBox<String>(date);
			datelist.setBounds(370, 350, 100, 40);
			
			String [] year = new String[20];
			year[0] = "연도를 선택해주세요.";
			for(int i=1; i<20; i++) {
				year[i] = Integer.toString(2019-i);
				year[i] = year[i].concat("년");
			}
			JComboBox<String> yearList = new JComboBox<String>(year);
			yearList.setBounds(350, 220, 200, 50);
			
			String [] deallistString = {"거래를 선택해주세요.", "상품 매입", "상품 판매", "종업원 급여 지급", 
					                    "운송비 지급", "통신비 지급", "임차료 지급", "보험료 지급", "광고비 지급"};
			JComboBox<String> dealList = new JComboBox<String>(deallistString);
			dealList.setBounds(250, 420, 150, 40);
			
			JTextField dealAmount = new JTextField();
			dealAmount.setBounds(250, 480, 300, 40);
			
			dealList.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					JComboBox<String> cb = (JComboBox<String>)e.getSource();
					int index = cb.getSelectedIndex(); 
					dealtype = deallistString[index];
				}
			});
			
			dealAmount.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					JTextField tf = (JTextField)e.getSource();
					int goodprice = 0, goodcount = 0, money = 0;
					if(tf.getText().contains(",")) {
						StringTokenizer st = new StringTokenizer(tf.getText(), ",");
						String str1 = st.nextToken();
						String str2 = st.nextToken();
						goodprice = Integer.parseInt(str1);
						goodcount = Integer.parseInt(str2);
					}
					else {
						money = Integer.parseInt(tf.getText());
					}					
					switch(dealtype) {
					case "상품 매입" :
						상품매입가격 = goodprice;
						상품개수 += goodcount;
						상품 += 상품매입가격 * goodcount;
						break;
					case "상품 판매" :
						상품판매가격 = goodprice;
						상품개수 -= goodcount;
						상품 -= 상품매입가격 * goodcount;
						매출액 += 상품판매가격 * goodcount;
						매출원가 += 상품매입가격 * goodcount;
						break;
					case "종업원 급여 지급" :
						종업원급여 += money;
						break;
					case "운송비 지급" :
						운송비 += money;
						break;
					case "통신비 지급" :
						통신비 += money;
						break;
					case "임차료 지급" :
						임차료 += money;
						break;
					case "보험료 지급" :
						보험료 += money;
						break;
					case "광고비 지급" :
						광고비 += money;
						break;
					}
				}
			});
			
			putinfobutton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					dealList.setSelectedIndex(0);
					dealAmount.setText("");
				}
			});
			finishbutton.addActionListener(new FinishListener());
			yearList.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e){
				JComboBox<String> cb = (JComboBox<String>)e.getSource();
				int x = cb.getSelectedIndex();
				String nowyear = Integer.toString(2019 - x);
				String term = nowyear + "년 1월 1일 ~ " + nowyear + "년 12월 31일";
				String now = nowyear + "년 12월 31일 현재";
				
				JLabel accountingterm = new JLabel(term);
				accountingterm.setBounds(270, 80, 600, 40);
				accountingterm.setFont(new Font("Gothic", Font.PLAIN, 30));
				soci1.add(accountingterm);
				
				JLabel accountingnow = new JLabel(now);
				accountingnow.setBounds(350, 80, 600, 40);
				accountingnow.setFont(new Font("Gothic", Font.PLAIN, 30));
				sofp.add(accountingnow);
			}
			});
			
			add(sentence1);
			add(sentence2);
			add(sentence3);
			add(dealdate);
			add(deallist);
			add(dealamount);
			add(caution1);
			add(caution2);
			add(caution3);
			
			add(putinfobutton);
			add(finishbutton);
			
			add(monthlist);
			add(datelist);
			add(yearList);
			add(dealList);
			
			add(dealAmount);
		}
		class FinishListener implements ActionListener{
			public void actionPerformed(ActionEvent e) {
				판매관리비 = 종업원급여 + 운송비 + 통신비 + 임차료 + 보험료 + 광고비;
				매출총이익 = 매출액 - 매출원가;
				당기순이익 = 매출총이익 - 판매관리비;
				당기포괄이익 = 당기순이익 + 기타포괄이익;
				
				JLabel val1 = new JLabel(Integer.toString(매출액));
				JLabel val2 = new JLabel(Integer.toString(매출원가));
				JLabel val3 = new JLabel(Integer.toString(매출총이익));
				JLabel val4 = new JLabel(Integer.toString(종업원급여));
				JLabel val5 = new JLabel(Integer.toString(운송비));
				JLabel val6 = new JLabel(Integer.toString(통신비));
				JLabel val7 = new JLabel(Integer.toString(임차료));
				JLabel val8 = new JLabel(Integer.toString(보험료));
				JLabel val9 = new JLabel(Integer.toString(광고비));
				JLabel val10 = new JLabel(Integer.toString(당기순이익));
				JLabel val11 = new JLabel(Integer.toString(기타포괄이익));
				JLabel val12 = new JLabel(Integer.toString(당기포괄이익));
				JLabel val13 = new JLabel(Integer.toString(판매관리비));
				val1.setBounds(800, 150, 400, 20);
				val1.setFont(new Font("Gothic", Font.PLAIN, 20));
				val2.setBounds(800, 190, 400, 20);
				val2.setFont(new Font("Gothic", Font.PLAIN, 20));
				val3.setBounds(800, 230, 400, 20);
				val3.setFont(new Font("Gothic", Font.PLAIN, 20));
				val4.setBounds(500, 310, 400, 20);
				val4.setFont(new Font("Gothic", Font.PLAIN, 20));
				val5.setBounds(500, 350, 400, 20);
				val5.setFont(new Font("Gothic", Font.PLAIN, 20));
				val6.setBounds(500, 390, 400, 20);
				val6.setFont(new Font("Gothic", Font.PLAIN, 20));
				val7.setBounds(500, 430, 400, 20);
				val7.setFont(new Font("Gothic", Font.PLAIN, 20));
				val8.setBounds(500, 470, 400, 20);
				val8.setFont(new Font("Gothic", Font.PLAIN, 20));
				val9.setBounds(500, 510, 400, 20);
				val9.setFont(new Font("Gothic", Font.PLAIN, 20));
				val10.setBounds(800, 550, 400, 20);
				val10.setFont(new Font("Gothic", Font.PLAIN, 20));
				val11.setBounds(800, 590, 400, 20);
				val11.setFont(new Font("Gothic", Font.PLAIN, 20));
				val12.setBounds(800, 630, 400, 20);
				val12.setFont(new Font("Gothic", Font.PLAIN, 20));
				val13.setBounds(800, 510, 400, 20);
				val13.setFont(new Font("Gothic", Font.PLAIN, 20));
				
				soci1.add(val1);
				soci1.add(val2);
				soci1.add(val3);
				soci1.add(val4);
				soci1.add(val5);
				soci1.add(val6);
				soci1.add(val7);
				soci1.add(val8);
				soci1.add(val9);
				soci1.add(val10);
				soci1.add(val11);
				soci1.add(val12);
				soci1.add(val13);
				
				현금  = 현금 + 당기포괄이익 - 상품매입가격 * 상품개수;
				이익잉여금 += 당기포괄이익;
				
				int 자산총계 = 현금 + 매출채권 + 상품 + 선급보험료 + 단기대여금;
				int 부채총계 = 매입채무 + 미지급비용;
				int 자본총계 = 자본금 + 이익잉여금;
				
				JLabel vval1 = new JLabel(Integer.toString(현금));
				JLabel vval2 = new JLabel(Integer.toString(매출채권));
				JLabel vval3 = new JLabel(Integer.toString(상품));
				JLabel vval4 = new JLabel(Integer.toString(선급보험료));
				JLabel vval5 = new JLabel(Integer.toString(단기대여금));
				JLabel vval6 = new JLabel(Integer.toString(자산총계));
				JLabel vval7 = new JLabel(Integer.toString(매입채무));
				JLabel vval8 = new JLabel(Integer.toString(미지급비용));
				JLabel vval9 = new JLabel(Integer.toString(부채총계));
				JLabel vval10 = new JLabel(Integer.toString(자본금));
				JLabel vval11 = new JLabel(Integer.toString(이익잉여금));
				JLabel vval12 = new JLabel(Integer.toString(자본총계));
				JLabel vval13 = new JLabel(Integer.toString(부채총계 + 자본총계));
				vval1.setBounds(350, 190, 400, 20);
				vval1.setFont(new Font("Gothic", Font.PLAIN, 20));
				vval2.setBounds(350, 230, 400, 20);
				vval2.setFont(new Font("Gothic", Font.PLAIN, 20));
				vval3.setBounds(350, 270, 400, 20);
				vval3.setFont(new Font("Gothic", Font.PLAIN, 20));
				vval4.setBounds(350, 310, 400, 20);
				vval4.setFont(new Font("Gothic", Font.PLAIN, 20));
				vval5.setBounds(350, 350, 400, 20);
				vval5.setFont(new Font("Gothic", Font.PLAIN, 20));
				vval6.setBounds(350, 550, 400, 20);
				vval6.setFont(new Font("Gothic", Font.PLAIN, 20));
				vval7.setBounds(850, 190, 400, 20);
				vval7.setFont(new Font("Gothic", Font.PLAIN, 20));
				vval8.setBounds(850, 230, 400, 20);
				vval8.setFont(new Font("Gothic", Font.PLAIN, 20));
				vval9.setBounds(850, 270, 400, 20);
				vval9.setFont(new Font("Gothic", Font.PLAIN, 20));
				vval10.setBounds(850, 390, 400, 20);
				vval10.setFont(new Font("Gothic", Font.PLAIN, 20));
				vval11.setBounds(850, 430, 400, 20);
				vval11.setFont(new Font("Gothic", Font.PLAIN, 20));
				vval12.setBounds(850, 470, 400, 20);
				vval12.setFont(new Font("Gothic", Font.PLAIN, 20));
				vval13.setBounds(850, 550, 400, 20);
				vval13.setFont(new Font("Gothic", Font.PLAIN, 20));
				
				sofp.add(vval1);
				sofp.add(vval2);
				sofp.add(vval3);
				sofp.add(vval4);
				sofp.add(vval5);
				sofp.add(vval6);
				sofp.add(vval7);
				sofp.add(vval8);
				sofp.add(vval9);
				sofp.add(vval10);
				sofp.add(vval11);
				sofp.add(vval12);
				sofp.add(vval13);
				
				card.show(c, "5");
			}
		}
	}
	class ServiceCompany extends JPanel{
		String dealtype;
		public ServiceCompany() {
			setLayout(null);
			
			JLabel sentence1 = new JLabel("회계기간을 선택하고, 거래정보를 입력하십시오.");
			JLabel sentence2 = new JLabel("연도를 선택하십시오 : ");
			JLabel sentence3 = new JLabel("거래 일자와 종류를 선택하고, 금액을 입력하십시오.");
			JLabel dealdate = new JLabel("거래 일자 : ");
			JLabel deallist = new JLabel("거래 종류 : ");
			JLabel dealamount = new JLabel("거래 금액 : ");
			
			sentence1.setBounds(150, 100, 800, 100);
			sentence1.setFont(new Font("Gothic", Font.PLAIN, 30));
			sentence2.setBounds(150, 200, 800, 100);
			sentence2.setFont(new Font("Gothic", Font.PLAIN, 20));
			sentence3.setBounds(150, 260, 800, 100);
			sentence3.setFont(new Font("Gothic", Font.PLAIN, 20));
			dealdate.setBounds(150, 320, 100, 100);
			dealdate.setFont(new Font("Gothic", Font.PLAIN, 20));
			deallist.setBounds(150, 390, 100, 100);
			deallist.setFont(new Font("Gothic", Font.PLAIN, 20));
			dealamount.setBounds(150, 450, 100, 100);
			dealamount.setFont(new Font("Gothic", Font.PLAIN, 20));
			
			JButton putinfobutton = new JButton("거래 정보 입력");
			JButton finishbutton = new JButton("당기의 거래 기록을 완료합니다.");
			putinfobutton.setBounds(580, 477, 150, 40);
			finishbutton.setBounds(150, 600, 700, 50);
			
			String [] month = {"1월", "2월", "3월", "4월", "5월", "6월", "7월", "8월", "9월", "10월", "11월", "12월"};
			JComboBox<String> monthlist = new JComboBox<String>(month);
			monthlist.setBounds(250, 350, 100, 40);
			
			String [] date = new String[31];
			for(int i=0; i<31; i++) {
				date[i] = Integer.toString(i+1);
				date[i] = date[i].concat("일");
			}
			JComboBox<String> datelist = new JComboBox<String>(date);
			datelist.setBounds(370, 350, 100, 40);
			
			String [] year = new String[20];
			year[0] = "연도를 선택해주세요.";
			for(int i=1; i<20; i++) {
				year[i] = Integer.toString(2019-i);
				year[i] = year[i].concat("년");
			}
			JComboBox<String> yearList = new JComboBox<String>(year);
			yearList.setBounds(350, 220, 200, 50);
			
			String [] deallistString = {"거래를 선택해주세요.", "용역 제공", "종업원 급여 지급", 
					                    "운송비 지급", "통신비 지급", "임차료 지급", "보험료 지급", "광고비 지급"};
			JComboBox<String> dealList = new JComboBox<String>(deallistString);
			dealList.setBounds(250, 420, 150, 40);
			
			JTextField dealAmount = new JTextField();
			dealAmount.setBounds(250, 480, 300, 40);
			
			dealList.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					JComboBox<String> cb = (JComboBox<String>)e.getSource();
					int index = cb.getSelectedIndex(); 
					dealtype = deallistString[index];
				}
			});
			
			dealAmount.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					JTextField tf = (JTextField)e.getSource();
					int money = Integer.parseInt(tf.getText());					
					switch(dealtype) {
					case "용역 제공" :
						용역수익 += money;
						break;
					case "종업원 급여 지급" :
						종업원급여 += money;
						break;
					case "운송비 지급" :
						운송비 += money;
						break;
					case "통신비 지급" :
						통신비 += money;
						break;
					case "임차료 지급" :
						임차료 += money;
						break;
					case "보험료 지급" :
						보험료 += money;
						break;
					case "광고비 지급" :
						광고비 += money;
						break;
					}
				}
			});
			
			putinfobutton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					dealList.setSelectedIndex(0);
					dealAmount.setText("");
				}
			});
			finishbutton.addActionListener(new FinishListener());
			yearList.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e){
				JComboBox<String> cb = (JComboBox<String>)e.getSource();
				int x = cb.getSelectedIndex();
				String nowyear = Integer.toString(2019 - x);
				String term = nowyear + "년 1월 1일 ~ " + nowyear + "년 12월 31일";
				String now = nowyear + "년 12월 31일 현재";
				
				JLabel accountingterm = new JLabel(term);
				accountingterm.setBounds(270, 80, 600, 40);
				accountingterm.setFont(new Font("Gothic", Font.PLAIN, 30));
				soci2.add(accountingterm);
				
				JLabel accountingnow = new JLabel(now);
				accountingnow.setBounds(350, 80, 600, 40);
				accountingnow.setFont(new Font("Gothic", Font.PLAIN, 30));
				sofp.add(accountingnow);
			}
			});
			
			add(sentence1);
			add(sentence2);
			add(sentence3);
			add(dealdate);
			add(deallist);
			add(dealamount);
			
			add(putinfobutton);
			add(finishbutton);
			
			add(monthlist);
			add(datelist);
			add(yearList);
			add(dealList);
			
			add(dealAmount);
		}
		class FinishListener implements ActionListener{
			public void actionPerformed(ActionEvent e) {
				판매관리비 = 종업원급여 + 운송비 + 통신비 + 임차료 + 보험료 + 광고비;
				당기순이익 = 용역수익 - 판매관리비;
				당기포괄이익 = 당기순이익 + 기타포괄이익;
				
				JLabel val1 = new JLabel(Integer.toString(용역수익));
				JLabel val2 = new JLabel(Integer.toString(종업원급여));
				JLabel val3 = new JLabel(Integer.toString(운송비));
				JLabel val4 = new JLabel(Integer.toString(통신비));
				JLabel val5 = new JLabel(Integer.toString(임차료));
				JLabel val6 = new JLabel(Integer.toString(보험료));
				JLabel val7 = new JLabel(Integer.toString(광고비));
				JLabel val8 = new JLabel(Integer.toString(당기순이익));
				JLabel val9 = new JLabel(Integer.toString(기타포괄이익));
				JLabel val10 = new JLabel(Integer.toString(당기포괄이익));
				JLabel val11 = new JLabel(Integer.toString(판매관리비));
				val1.setBounds(800, 190, 400, 20);
				val1.setFont(new Font("Gothic", Font.PLAIN, 20));
				val2.setBounds(500, 310, 400, 20);
				val2.setFont(new Font("Gothic", Font.PLAIN, 20));
				val3.setBounds(500, 350, 400, 20);
				val3.setFont(new Font("Gothic", Font.PLAIN, 20));
				val4.setBounds(500, 390, 400, 20);
				val4.setFont(new Font("Gothic", Font.PLAIN, 20));
				val5.setBounds(500, 430, 400, 20);
				val5.setFont(new Font("Gothic", Font.PLAIN, 20));
				val6.setBounds(500, 470, 400, 20);
				val6.setFont(new Font("Gothic", Font.PLAIN, 20));
				val7.setBounds(500, 510, 400, 20);
				val7.setFont(new Font("Gothic", Font.PLAIN, 20));
				val8.setBounds(800, 550, 400, 20);
				val8.setFont(new Font("Gothic", Font.PLAIN, 20));
				val9.setBounds(800, 590, 400, 20);
				val9.setFont(new Font("Gothic", Font.PLAIN, 20));
				val10.setBounds(800, 630, 400, 20);
				val10.setFont(new Font("Gothic", Font.PLAIN, 20));
				val11.setBounds(800, 510, 400, 20);
				val11.setFont(new Font("Gothic", Font.PLAIN, 20));
				
				soci2.add(val1);
				soci2.add(val2);
				soci2.add(val3);
				soci2.add(val4);
				soci2.add(val5);
				soci2.add(val6);
				soci2.add(val7);
				soci2.add(val8);
				soci2.add(val9);
				soci2.add(val10);
				soci2.add(val11);
				
				현금  = 현금 + 당기포괄이익;
				이익잉여금 += 당기포괄이익;
				
				int 자산총계 = 현금 + 매출채권 + 상품 + 선급보험료 + 단기대여금;
				int 부채총계 = 매입채무 + 미지급비용;
				int 자본총계 = 자본금 + 이익잉여금;
				
				JLabel vval1 = new JLabel(Integer.toString(현금));
				JLabel vval2 = new JLabel(Integer.toString(매출채권));
				JLabel vval3 = new JLabel(Integer.toString(상품));
				JLabel vval4 = new JLabel(Integer.toString(선급보험료));
				JLabel vval5 = new JLabel(Integer.toString(단기대여금));
				JLabel vval6 = new JLabel(Integer.toString(자산총계));
				JLabel vval7 = new JLabel(Integer.toString(매입채무));
				JLabel vval8 = new JLabel(Integer.toString(미지급비용));
				JLabel vval9 = new JLabel(Integer.toString(부채총계));
				JLabel vval10 = new JLabel(Integer.toString(자본금));
				JLabel vval11 = new JLabel(Integer.toString(이익잉여금));
				JLabel vval12 = new JLabel(Integer.toString(자본총계));
				JLabel vval13 = new JLabel(Integer.toString(부채총계 + 자본총계));
				vval1.setBounds(350, 190, 400, 20);
				vval1.setFont(new Font("Gothic", Font.PLAIN, 20));
				vval2.setBounds(350, 230, 400, 20);
				vval2.setFont(new Font("Gothic", Font.PLAIN, 20));
				vval3.setBounds(350, 270, 400, 20);
				vval3.setFont(new Font("Gothic", Font.PLAIN, 20));
				vval4.setBounds(350, 310, 400, 20);
				vval4.setFont(new Font("Gothic", Font.PLAIN, 20));
				vval5.setBounds(350, 350, 400, 20);
				vval5.setFont(new Font("Gothic", Font.PLAIN, 20));
				vval6.setBounds(350, 550, 400, 20);
				vval6.setFont(new Font("Gothic", Font.PLAIN, 20));
				vval7.setBounds(850, 190, 400, 20);
				vval7.setFont(new Font("Gothic", Font.PLAIN, 20));
				vval8.setBounds(850, 230, 400, 20);
				vval8.setFont(new Font("Gothic", Font.PLAIN, 20));
				vval9.setBounds(850, 270, 400, 20);
				vval9.setFont(new Font("Gothic", Font.PLAIN, 20));
				vval10.setBounds(850, 390, 400, 20);
				vval10.setFont(new Font("Gothic", Font.PLAIN, 20));
				vval11.setBounds(850, 430, 400, 20);
				vval11.setFont(new Font("Gothic", Font.PLAIN, 20));
				vval12.setBounds(850, 470, 400, 20);
				vval12.setFont(new Font("Gothic", Font.PLAIN, 20));
				vval13.setBounds(850, 550, 400, 20);
				vval13.setFont(new Font("Gothic", Font.PLAIN, 20));
				
				sofp.add(vval1);
				sofp.add(vval2);
				sofp.add(vval3);
				sofp.add(vval4);
				sofp.add(vval5);
				sofp.add(vval6);
				sofp.add(vval7);
				sofp.add(vval8);
				sofp.add(vval9);
				sofp.add(vval10);
				sofp.add(vval11);
				sofp.add(vval12);
				sofp.add(vval13);
				
				card.show(c, "6");
			}
		}
		
	}
	class DrawSOCI_sales extends JPanel{
		public DrawSOCI_sales() {
			setLayout(null);
			
			JLabel title = new JLabel("포괄손익계산서");
			JLabel la1 = new JLabel("매출액");
			JLabel la2 = new JLabel("매출원가");
			JLabel la3 = new JLabel("매출총이익");
			JLabel la4 = new JLabel("판매비와 관리비 : ");
			JLabel la5 = new JLabel("종업원급여");
			JLabel la6 = new JLabel("운송비");
			JLabel la7 = new JLabel("통신비");
			JLabel la8 = new JLabel("임차료");
			JLabel la9 = new JLabel("보험료");
			JLabel la10 = new JLabel("광고비");
			JLabel la11 = new JLabel("당기순이익");
			JLabel la12 = new JLabel("기타포괄이익");
			JLabel la13 = new JLabel("당기포괄이익");
			
			title.setBounds(300, 0, 800, 100);
			title.setFont(new Font("Gothic", Font.PLAIN, 60));
			la1.setBounds(20, 150, 400, 20);
			la1.setFont(new Font("Gothic", Font.PLAIN, 20));
			la2.setBounds(20, 190, 400, 20);
			la2.setFont(new Font("Gothic", Font.PLAIN, 20));
			la3.setBounds(20, 230, 400, 20);
			la3.setFont(new Font("Gothic", Font.PLAIN, 20));
			la4.setBounds(20, 270, 400, 20);
			la4.setFont(new Font("Gothic", Font.PLAIN, 20));
			la5.setBounds(220, 310, 400, 20);
			la5.setFont(new Font("Gothic", Font.PLAIN, 20));
			la6.setBounds(220, 350, 400, 20);
			la6.setFont(new Font("Gothic", Font.PLAIN, 20));
			la7.setBounds(220, 390, 400, 20);
			la7.setFont(new Font("Gothic", Font.PLAIN, 20));
			la8.setBounds(220, 430, 400, 20);
			la8.setFont(new Font("Gothic", Font.PLAIN, 20));
			la9.setBounds(220, 470, 400, 20);
			la9.setFont(new Font("Gothic", Font.PLAIN, 20));
			la10.setBounds(220, 510, 400, 20);
			la10.setFont(new Font("Gothic", Font.PLAIN, 20));
			la11.setBounds(20, 550, 400, 20);
			la11.setFont(new Font("Gothic", Font.PLAIN, 20));
			la12.setBounds(20, 590, 400, 20);
			la12.setFont(new Font("Gothic", Font.PLAIN, 20));
			la13.setBounds(20, 630, 400, 20);
			la13.setFont(new Font("Gothic", Font.PLAIN, 20));
			
						
			JButton nextbutton = new JButton("Next");
			nextbutton.setBounds(910, 725, 70, 30);
			
			nextbutton.addActionListener(new NextListener());
			
			add(title);
			add(la1);
			add(la2);
			add(la3);
			add(la4);
			add(la5);
			add(la6);
			add(la7);
			add(la8);
			add(la9);
			add(la10);
			add(la11);
			add(la12);
			add(la13);
						
			add(nextbutton);
		}
		class NextListener implements ActionListener{
			public void actionPerformed(ActionEvent e) {
				card.show(c, "7");
			}
		}
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			g.drawLine(0, 120, 1000, 120);
			g.drawLine(800, 210, 900, 210);
		    g.drawLine(500, 530, 600, 530);
		    g.drawLine(800, 530, 900, 530);
		    g.drawLine(800, 610, 900, 610);
		    g.drawLine(800, 650, 900, 650);
		}
	}
	class DrawSOCI_service extends JPanel{
		public DrawSOCI_service() {
			setLayout(null);
			
			JLabel title = new JLabel("포괄손익계산서");
			JLabel la1 = new JLabel("수익 : ");
			JLabel la2 = new JLabel("용역수익");
			JLabel la3 = new JLabel("비용 : ");
			JLabel la4 = new JLabel("종업원급여");
			JLabel la5 = new JLabel("운송비");
			JLabel la6 = new JLabel("통신비");
			JLabel la7 = new JLabel("임차료");
			JLabel la8 = new JLabel("보험료");
			JLabel la9 = new JLabel("광고비");
			JLabel la10 = new JLabel("당기순이익");
			JLabel la11 = new JLabel("기타포괄이익");
			JLabel la12 = new JLabel("당기포괄이익");
			
			title.setBounds(300, 0, 800, 100);
			title.setFont(new Font("Gothic", Font.PLAIN, 60));
			la1.setBounds(20, 150, 400, 20);
			la1.setFont(new Font("Gothic", Font.PLAIN, 20));
			la2.setBounds(220, 190, 400, 20);
			la2.setFont(new Font("Gothic", Font.PLAIN, 20));
			la3.setBounds(20, 270, 400, 20);
			la3.setFont(new Font("Gothic", Font.PLAIN, 20));
			la4.setBounds(220, 310, 400, 20);
			la4.setFont(new Font("Gothic", Font.PLAIN, 20));
			la5.setBounds(220, 350, 400, 20);
			la5.setFont(new Font("Gothic", Font.PLAIN, 20));
			la6.setBounds(220, 390, 400, 20);
			la6.setFont(new Font("Gothic", Font.PLAIN, 20));
			la7.setBounds(220, 430, 400, 20);
			la7.setFont(new Font("Gothic", Font.PLAIN, 20));
			la8.setBounds(220, 470, 400, 20);
			la8.setFont(new Font("Gothic", Font.PLAIN, 20));
			la9.setBounds(220, 510, 400, 20);
			la9.setFont(new Font("Gothic", Font.PLAIN, 20));
			la10.setBounds(20, 550, 400, 20);
			la10.setFont(new Font("Gothic", Font.PLAIN, 20));
			la11.setBounds(20, 590, 400, 20);
			la11.setFont(new Font("Gothic", Font.PLAIN, 20));
			la12.setBounds(20, 630, 400, 20);
			la12.setFont(new Font("Gothic", Font.PLAIN, 20));
						
			JButton nextbutton = new JButton("Next");
			nextbutton.setBounds(910, 725, 70, 30);
			
			nextbutton.addActionListener(new NextListener());
			
			add(title);
			add(la1);
			add(la2);
			add(la3);
			add(la4);
			add(la5);
			add(la6);
			add(la7);
			add(la8);
			add(la9);
			add(la10);
			add(la11);
			add(la12);
						
			add(nextbutton);
		}
		class NextListener implements ActionListener{
			public void actionPerformed(ActionEvent e) {
				card.show(c, "7");
			}
		}
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			g.drawLine(0, 120, 1000, 120);
		    g.drawLine(500, 530, 600, 530);
		    g.drawLine(800, 530, 900, 530);
		    g.drawLine(800, 610, 900, 610);
		    g.drawLine(800, 650, 900, 650);
		}
	}
	class DrawSOFP extends JPanel{
		public DrawSOFP() {
            setLayout(null);
			
			JLabel title = new JLabel("재무상태표");
			JLabel la1 = new JLabel("자산 : ");
			JLabel la2 = new JLabel("현금");
			JLabel la3 = new JLabel("매출채권");
			JLabel la4 = new JLabel("상품");
			JLabel la5 = new JLabel("선급보험료");
			JLabel la6 = new JLabel("단기대여금");
			JLabel la7 = new JLabel("자산 총계");
			JLabel la8 = new JLabel("부채 : ");
			JLabel la9 = new JLabel("매입채무");
			JLabel la10 = new JLabel("미지급비용");
			JLabel la11 = new JLabel("부채 총계");
			JLabel la12 = new JLabel("자본 : ");
			JLabel la13 = new JLabel("자본금");
			JLabel la14 = new JLabel("이익잉여금");
			JLabel la15 = new JLabel("자본 총계");
			JLabel la16 = new JLabel("부채와 자본 총계");
			
			title.setBounds(350, 0, 800, 100);
			title.setFont(new Font("Gothic", Font.PLAIN, 60));
			la1.setBounds(20, 150, 400, 20);
			la1.setFont(new Font("Gothic", Font.PLAIN, 20));
			la2.setBounds(150, 190, 400, 20);
			la2.setFont(new Font("Gothic", Font.PLAIN, 20));
			la3.setBounds(150, 230, 400, 20);
			la3.setFont(new Font("Gothic", Font.PLAIN, 20));
			la4.setBounds(150, 270, 400, 20);
			la4.setFont(new Font("Gothic", Font.PLAIN, 20));
			la5.setBounds(150, 310, 400, 20);
			la5.setFont(new Font("Gothic", Font.PLAIN, 20));
			la6.setBounds(150, 350, 400, 20);
			la6.setFont(new Font("Gothic", Font.PLAIN, 20));
			la7.setBounds(20, 550, 400, 20);
			la7.setFont(new Font("Gothic", Font.PLAIN, 20));
			la8.setBounds(520, 150, 400, 20);
			la8.setFont(new Font("Gothic", Font.PLAIN, 20));
			la9.setBounds(650, 190, 400, 20);
			la9.setFont(new Font("Gothic", Font.PLAIN, 20));
			la10.setBounds(650, 230, 400, 20);
			la10.setFont(new Font("Gothic", Font.PLAIN, 20));
			la11.setBounds(520, 270, 400, 20);
			la11.setFont(new Font("Gothic", Font.PLAIN, 20));
			la12.setBounds(520, 350, 400, 20);
			la12.setFont(new Font("Gothic", Font.PLAIN, 20));
			la13.setBounds(650, 390, 400, 20);
			la13.setFont(new Font("Gothic", Font.PLAIN, 20));
			la14.setBounds(650, 430, 400, 20);
			la14.setFont(new Font("Gothic", Font.PLAIN, 20));
			la15.setBounds(520, 470, 400, 20);
			la15.setFont(new Font("Gothic", Font.PLAIN, 20));
			la16.setBounds(520, 550, 400, 20);
			la16.setFont(new Font("Gothic", Font.PLAIN, 20));
			
			JButton back = new JButton("Back");
			back.setBounds(10, 725, 70, 30);
			
			back.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if(typeindex.equals("상품매매기업")) {
						card.show(c, "5");
					}
					else if(typeindex.equals("서비스기업")) {
						card.show(c, "6");
					}					
				}
			});
			
			add(title);
			add(la1);
			add(la2);
			add(la3);
			add(la4);
			add(la5);
			add(la6);
			add(la7);
			add(la8);
			add(la9);
			add(la10);
			add(la11);
			add(la12);
			add(la13);
			add(la14);
			add(la15);
			add(la16);
			
			add(back);
		}
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			g.drawLine(0, 120, 1000, 120);
			g.drawLine(500, 120, 500, 800);
			g.drawLine(350, 370, 450, 370);
			g.drawLine(350, 570, 450, 570);
			g.drawLine(850, 250, 950, 250);
			g.drawLine(850, 290, 950, 290);
			g.drawLine(850, 450, 950, 450);
			g.drawLine(850, 490, 950, 490);
			g.drawLine(850, 570, 950, 570);
		}
	}
	public static void main(String[] args) {
		new MainProgram();
	}
}


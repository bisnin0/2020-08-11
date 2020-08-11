import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.Calendar;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JToolBar;
/*참고 
//https://kin.naver.com/qna/detail.nhn?d1id=1&dirId=1040201&docId=340584822&qb=RGVmYXVsdENvbWJvQm94TW9kZWw=&enc=utf8&section=kin&rank=1&search_sort=0&spq=0
// DefaultComboBoxModel 로 검색해보기
 * 콤보박스에 데이터 추가하는방법 https://m.blog.naver.com/PostView.nhn?blogId=xeexee&logNo=220732510219&proxyReferer=https:%2F%2Fwww.google.com%2F
 * 
 * 
 * 
 * 
*/
public class CalendarSwing_2 extends JFrame implements ActionListener, ItemListener {
		Calendar now = Calendar.getInstance();
		int year = 2020;
		int month = 8;

		JButton leftBtn = new JButton("◀");
		JButton rightBtn = new JButton("▶");
		JLabel topLbl1 = new JLabel("년", 10);
		JLabel topLbl2 = new JLabel("월", 10);
		JToolBar yearTb = new JToolBar();
			JComboBox<Integer> yearCombo = new JComboBox<Integer>(); //년도 선택 콤보박스
				DefaultComboBoxModel<Integer> ydcb = new DefaultComboBoxModel<Integer>(); 
				
			JComboBox<Integer> monthCombo = new JComboBox<Integer>(); //월 선택 콤보박스
				DefaultComboBoxModel<Integer> mdcb = new DefaultComboBoxModel<Integer>();
				
		Font fontSize = new Font("굴림체", Font.BOLD, 15);
		
		JPanel frmTop = new JPanel(); //좌우 버튼과 콤보박스 들어갈위치
		JPanel frmCenter = new JPanel(new BorderLayout()); //요일과 날짜 들어갈부분(센터)
			JPanel centerNorth = new JPanel(new GridLayout(1,3, 2, 2)); //요일부분
			JPanel centerLbl = new JPanel(new GridLayout(0, 7, 5, 5));

		String weekLbl[] = {"일","월","화","수","목","금","토"};
//		now.set(year,month-1,1); 
//		int sDayNum = now.get(Calendar.DAY_OF_WEEK); // 1일의 요일 얻어오기
//		int endDate = now.getActualMaximum(Calendar.DATE); //달의 마지막날 구하기.
//		int Size = sDayNum+endDate-1;
//		String arr[] = new String[Size];
/////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////
public CalendarSwing_2() {
		super("달력 만들기");
		setBackground(Color.WHITE);
		
//		Integer yearList[] = new Integer[]; //Integer 배열선언부터 .. 이게 년도 담는거. int로해야하나? 
		//int num = Integer.parseInt(JLabel.getText());
		
		//콤보박스에 년월 넣기
		for(int i=1900; i<=2100; i++) { //년
			ydcb.addElement(i);
		}
		yearCombo.setModel(ydcb);
		yearCombo.setSelectedItem(year); //현재 년 객체로 만들어서 넣을 필요?
		
		
		for(int i=1; i<=12; i++) {//월
			mdcb.addElement(i);
		}
		monthCombo.setModel(mdcb);
		monthCombo.setSelectedItem(month); //현재 월 객체로 만들어서 넣을 필요?
		
		//년월 선택 콤보박스 위치
		leftBtn.setPreferredSize(new Dimension(47, 22));
		rightBtn.setPreferredSize(new Dimension(47, 22));
		frmTop.add(leftBtn);
		frmTop.add(yearCombo);
		frmTop.add(topLbl1);
		frmTop.add(monthCombo);
		frmTop.add(topLbl2);
		frmTop.add(rightBtn);
		
		frmTop.setOpaque(true);
		frmTop.setBackground(Color.cyan);
		add(BorderLayout.NORTH, frmTop); //콤보박스 패널 배치
		
		/////////////////요일 패널 구현
		centerNorth.setOpaque(true);
		centerNorth.setBackground(Color.WHITE);
		for(int i=0; i<7; i++) {
			JLabel lbl = new JLabel(weekLbl[i]);
			lbl.setFont(fontSize);
			lbl.setBackground(Color.lightGray);
			lbl.setHorizontalAlignment(JLabel.CENTER);
			lbl.setOpaque(true);
			centerNorth.add(lbl);
		}
		/////////////////날짜 패널 구현
		
		
		frmCenter.add(BorderLayout.NORTH, centerNorth);
		frmCenter.add(BorderLayout.CENTER, centerLbl);
		add(BorderLayout.CENTER, frmCenter);
		
		
		
		setSize(400,400);
		setVisible(true);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
		
		
		//이벤트 등록
		
		
		yearCombo.addItemListener(this);
		calendar();
//		calendar();
		
	}

	public void calendar() { //이부분 필요한가?
		centerLbl.removeAll();
		//http://blog.naver.com/javaking75/140187852894
		//위 블로그 체크
		//여기에서 lbl값 받아서 셋팅?
		
//		year = now.get(Calendar.YEAR); //일단 임시로 현재 달
//		month = now.get(Calendar.MONTH)+1; //일단 임시로 현재 월
//		now.set(2020, 6, 1); //현재 월 일 샛팅
		
//		year = 2019;  //
//		month = 8;  // 마우스로 특정문자 클릭하면 값을 대입하게
		
		now.set(year,month-1,1); //이걸로 선택한 달과 월을 결정
//		now.set(Calendar.DATE,1); //현재 달을 1일로 설정..이거를 이벤트로 입력받은 년월 설정
		int sDayNum = now.get(Calendar.DAY_OF_WEEK); // 1일의 요일 얻어오기
		int endDate = now.getActualMaximum(Calendar.DATE); //달의 마지막날 구하기.
//		System.out.println(sDayNum); 
		int Size = sDayNum+endDate-1;
		String arr[] = new String[Size];
		

		//////// 아래 배열이 공백과 날짜를 다 포함한 배열.
		//////// 이 배열 값을 리턴시키던지 멤버변수에서 구현해서 액션에서 쓰던지
		int j=1;
	     for (int i=0; i<sDayNum-1;i++){
	            arr[i]=" ";  
	        }//for-----------------
	        for (int i = sDayNum-1; i < Size ; i++) {   // 1부터 마지막일까지 반복.        
	        	
	        	arr[i]=String.valueOf(j);
	        	j++;
	        }
	     
//	    for(int i=0; i<=arr.length-1; i++) {
//	    	System.out.println(arr[i]);	
//	    } //배열출력
	    
	    for(int i=0; i<arr.length; i++) {
	    	JLabel dayLbl = new JLabel(arr[i]);//버튼 생성
	    	dayLbl.setFont(fontSize);
	    	dayLbl.setBackground(Color.white);
	    	dayLbl.setHorizontalAlignment(JLabel.CENTER);
	    	centerLbl.add(dayLbl);
	    }
		
	    // 이 배열로 바로 버튼생성하고 패널에 값 추가하면 될거같은데.
	    
	    
		//그냥 lbl에서 년이나 월 선택되면 객체로 만들어서 저장하고
		//그걸로 현재 날짜를 객체를 통해 셋팅하고
		// 거기에서 나온 날짜를 가져와서 배열에 넣고 출력하면되지않나? 공백은 찾아서 해결
		
		
//		int day = now.get(Calendar.DAY_OF_MONTH);
//		now.add(Calendar.YEAR,month); //현재 달의 
		
		
	}
	
	public void actionPerformed(ActionEvent ae) {
		
	}
	public void itemStateChanged(ItemEvent ie) {
	
		JComboBox event = (JComboBox)ie.getSource();
		if(event==yearCombo) {
			year = (Integer)yearCombo.getSelectedItem();
			calendar();
//			System.out.println(event);
		}////////event 확인
	}

	public static void main(String[] args) {
//		new CalendarSwing_2().calendar();
		new CalendarSwing_2();
	}

}

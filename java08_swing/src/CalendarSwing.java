import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
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
public class CalendarSwing extends JFrame implements ActionListener {
		JButton leftBtn = new JButton("◀");
		JButton rightBtn = new JButton("▶");
		
		JToolBar yearTb = new JToolBar();
			JComboBox<Integer> yearCombo = new JComboBox<Integer>(); //년도 선택 콤보박스
				DefaultComboBoxModel<Integer> ydcb = new DefaultComboBoxModel<Integer>(); 
				
			JComboBox<Integer> monthcombo = new JComboBox<Integer>(); //월 선택 콤보박스
				DefaultComboBoxModel<Integer> mdcb = new DefaultComboBoxModel<Integer>();
				
		
		
		JPanel frmTop = new JPanel(); //좌우 버튼과 콤보박스 들어갈위치
		JPanel frmCenter = new JPanel(new BorderLayout()); //요일과 날짜 들어갈부분(센터)
			JPanel centerNorth = new JPanel(new GridLayout(1,3)); //요일부분
			JPanel centerlbl = new JPanel(new GridLayout(0, 7, 2, 2));
	public CalendarSwing() {
		super("달력 만들기");
		
//		Integer yearList[] =  new Integer[]; //Integer 배열선언부터 .. 이게 년도 담는거. int로해야하나? 
		
		
		frmTop.add(leftBtn);
		
		
		
		frmTop.add(rightBtn);
		
		add(BorderLayout.NORTH, frmTop);
		
		setSize(700,700);
		setVisible(true);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
	}
	
	public void actionPerformed(ActionEvent ae) {
		
	}

	public static void main(String[] args) {
		new CalendarSwing();
	}

}

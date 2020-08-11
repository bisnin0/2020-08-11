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
/*���� 
//https://kin.naver.com/qna/detail.nhn?d1id=1&dirId=1040201&docId=340584822&qb=RGVmYXVsdENvbWJvQm94TW9kZWw=&enc=utf8&section=kin&rank=1&search_sort=0&spq=0
// DefaultComboBoxModel �� �˻��غ���
 * �޺��ڽ��� ������ �߰��ϴ¹�� https://m.blog.naver.com/PostView.nhn?blogId=xeexee&logNo=220732510219&proxyReferer=https:%2F%2Fwww.google.com%2F
 * 
 * 
 * 
 * 
*/
public class CalendarSwing_2 extends JFrame implements ActionListener, ItemListener {
		Calendar now = Calendar.getInstance();
		int year = 2020;
		int month = 8;

		JButton leftBtn = new JButton("��");
		JButton rightBtn = new JButton("��");
		JLabel topLbl1 = new JLabel("��", 10);
		JLabel topLbl2 = new JLabel("��", 10);
		JToolBar yearTb = new JToolBar();
			JComboBox<Integer> yearCombo = new JComboBox<Integer>(); //�⵵ ���� �޺��ڽ�
				DefaultComboBoxModel<Integer> ydcb = new DefaultComboBoxModel<Integer>(); 
				
			JComboBox<Integer> monthCombo = new JComboBox<Integer>(); //�� ���� �޺��ڽ�
				DefaultComboBoxModel<Integer> mdcb = new DefaultComboBoxModel<Integer>();
				
		Font fontSize = new Font("����ü", Font.BOLD, 15);
		
		JPanel frmTop = new JPanel(); //�¿� ��ư�� �޺��ڽ� ����ġ
		JPanel frmCenter = new JPanel(new BorderLayout()); //���ϰ� ��¥ ���κ�(����)
			JPanel centerNorth = new JPanel(new GridLayout(1,3, 2, 2)); //���Ϻκ�
			JPanel centerLbl = new JPanel(new GridLayout(0, 7, 5, 5));

		String weekLbl[] = {"��","��","ȭ","��","��","��","��"};
//		now.set(year,month-1,1); 
//		int sDayNum = now.get(Calendar.DAY_OF_WEEK); // 1���� ���� ������
//		int endDate = now.getActualMaximum(Calendar.DATE); //���� �������� ���ϱ�.
//		int Size = sDayNum+endDate-1;
//		String arr[] = new String[Size];
/////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////
public CalendarSwing_2() {
		super("�޷� �����");
		setBackground(Color.WHITE);
		
//		Integer yearList[] = new Integer[]; //Integer �迭������� .. �̰� �⵵ ��°�. int���ؾ��ϳ�? 
		//int num = Integer.parseInt(JLabel.getText());
		
		//�޺��ڽ��� ��� �ֱ�
		for(int i=1900; i<=2100; i++) { //��
			ydcb.addElement(i);
		}
		yearCombo.setModel(ydcb);
		yearCombo.setSelectedItem(year); //���� �� ��ü�� ���� ���� �ʿ�?
		
		
		for(int i=1; i<=12; i++) {//��
			mdcb.addElement(i);
		}
		monthCombo.setModel(mdcb);
		monthCombo.setSelectedItem(month); //���� �� ��ü�� ���� ���� �ʿ�?
		
		//��� ���� �޺��ڽ� ��ġ
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
		add(BorderLayout.NORTH, frmTop); //�޺��ڽ� �г� ��ġ
		
		/////////////////���� �г� ����
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
		/////////////////��¥ �г� ����
		
		
		frmCenter.add(BorderLayout.NORTH, centerNorth);
		frmCenter.add(BorderLayout.CENTER, centerLbl);
		add(BorderLayout.CENTER, frmCenter);
		
		
		
		setSize(400,400);
		setVisible(true);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
		
		
		//�̺�Ʈ ���
		
		
		yearCombo.addItemListener(this);
		calendar();
//		calendar();
		
	}

	public void calendar() { //�̺κ� �ʿ��Ѱ�?
		centerLbl.removeAll();
		//http://blog.naver.com/javaking75/140187852894
		//�� ��α� üũ
		//���⿡�� lbl�� �޾Ƽ� ����?
		
//		year = now.get(Calendar.YEAR); //�ϴ� �ӽ÷� ���� ��
//		month = now.get(Calendar.MONTH)+1; //�ϴ� �ӽ÷� ���� ��
//		now.set(2020, 6, 1); //���� �� �� ����
		
//		year = 2019;  //
//		month = 8;  // ���콺�� Ư������ Ŭ���ϸ� ���� �����ϰ�
		
		now.set(year,month-1,1); //�̰ɷ� ������ �ް� ���� ����
//		now.set(Calendar.DATE,1); //���� ���� 1�Ϸ� ����..�̰Ÿ� �̺�Ʈ�� �Է¹��� ��� ����
		int sDayNum = now.get(Calendar.DAY_OF_WEEK); // 1���� ���� ������
		int endDate = now.getActualMaximum(Calendar.DATE); //���� �������� ���ϱ�.
//		System.out.println(sDayNum); 
		int Size = sDayNum+endDate-1;
		String arr[] = new String[Size];
		

		//////// �Ʒ� �迭�� ����� ��¥�� �� ������ �迭.
		//////// �� �迭 ���� ���Ͻ�Ű���� ����������� �����ؼ� �׼ǿ��� ������
		int j=1;
	     for (int i=0; i<sDayNum-1;i++){
	            arr[i]=" ";  
	        }//for-----------------
	        for (int i = sDayNum-1; i < Size ; i++) {   // 1���� �������ϱ��� �ݺ�.        
	        	
	        	arr[i]=String.valueOf(j);
	        	j++;
	        }
	     
//	    for(int i=0; i<=arr.length-1; i++) {
//	    	System.out.println(arr[i]);	
//	    } //�迭���
	    
	    for(int i=0; i<arr.length; i++) {
	    	JLabel dayLbl = new JLabel(arr[i]);//��ư ����
	    	dayLbl.setFont(fontSize);
	    	dayLbl.setBackground(Color.white);
	    	dayLbl.setHorizontalAlignment(JLabel.CENTER);
	    	centerLbl.add(dayLbl);
	    }
		
	    // �� �迭�� �ٷ� ��ư�����ϰ� �гο� �� �߰��ϸ� �ɰŰ�����.
	    
	    
		//�׳� lbl���� ���̳� �� ���õǸ� ��ü�� ���� �����ϰ�
		//�װɷ� ���� ��¥�� ��ü�� ���� �����ϰ�
		// �ű⿡�� ���� ��¥�� �����ͼ� �迭�� �ְ� ����ϸ�����ʳ�? ������ ã�Ƽ� �ذ�
		
		
//		int day = now.get(Calendar.DAY_OF_MONTH);
//		now.add(Calendar.YEAR,month); //���� ���� 
		
		
	}
	
	public void actionPerformed(ActionEvent ae) {
		
	}
	public void itemStateChanged(ItemEvent ie) {
	
		JComboBox event = (JComboBox)ie.getSource();
		if(event==yearCombo) {
			year = (Integer)yearCombo.getSelectedItem();
			calendar();
//			System.out.println(event);
		}////////event Ȯ��
	}

	public static void main(String[] args) {
//		new CalendarSwing_2().calendar();
		new CalendarSwing_2();
	}

}

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
/*���� 
//https://kin.naver.com/qna/detail.nhn?d1id=1&dirId=1040201&docId=340584822&qb=RGVmYXVsdENvbWJvQm94TW9kZWw=&enc=utf8&section=kin&rank=1&search_sort=0&spq=0
// DefaultComboBoxModel �� �˻��غ���
 * �޺��ڽ��� ������ �߰��ϴ¹�� https://m.blog.naver.com/PostView.nhn?blogId=xeexee&logNo=220732510219&proxyReferer=https:%2F%2Fwww.google.com%2F
 * 
 * 
 * 
 * 
*/
public class CalendarSwing extends JFrame implements ActionListener {
		JButton leftBtn = new JButton("��");
		JButton rightBtn = new JButton("��");
		
		JToolBar yearTb = new JToolBar();
			JComboBox<Integer> yearCombo = new JComboBox<Integer>(); //�⵵ ���� �޺��ڽ�
				DefaultComboBoxModel<Integer> ydcb = new DefaultComboBoxModel<Integer>(); 
				
			JComboBox<Integer> monthcombo = new JComboBox<Integer>(); //�� ���� �޺��ڽ�
				DefaultComboBoxModel<Integer> mdcb = new DefaultComboBoxModel<Integer>();
				
		
		
		JPanel frmTop = new JPanel(); //�¿� ��ư�� �޺��ڽ� ����ġ
		JPanel frmCenter = new JPanel(new BorderLayout()); //���ϰ� ��¥ ���κ�(����)
			JPanel centerNorth = new JPanel(new GridLayout(1,3)); //���Ϻκ�
			JPanel centerlbl = new JPanel(new GridLayout(0, 7, 2, 2));
	public CalendarSwing() {
		super("�޷� �����");
		
//		Integer yearList[] =  new Integer[]; //Integer �迭������� .. �̰� �⵵ ��°�. int���ؾ��ϳ�? 
		
		
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

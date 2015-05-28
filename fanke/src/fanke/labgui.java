package fanke;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;



public class labgui extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private ArrayList<Shebei> b1=new ArrayList<Shebei>();
	private ArrayList<Shebei> b2=new ArrayList<Shebei>();
	private Shebei she;
	int rowz;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					labgui frame = new labgui();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public labgui() {
		
		// 定义数据库驱动程序
		String DBDRIVER = "sun.jdbc.odbc.JdbcOdbcDriver";
		// 定义数据库连接地址
		String DBURL = "jdbc:odbc:fanke";
		// 定义数据库连接对象，属于java.sql包中的接口
		Connection conn = null;
		// 定义Statement对象，用于操作数据库
		Statement stmt = null;
		// 定义一字符串变量，用于保存SQL语句
		String sql = null;
		// 定义一个结果集以存放检索的结果
		ResultSet r = null;
		// 1、加载驱动程序
		try {
			Class.forName(DBDRIVER);
		} catch (Exception e) {
			// 此处使用out.print是处于演示目的，在实际开发中所有的错误消息，
			// 绝对不能够通过System.out.print打印，否则会存在安全问题
			System.out.println("数据库驱动程序加载失败！！！");
		}
		// 2、连接数据库
		try {
			conn = DriverManager.getConnection(DBURL);
		} catch (Exception e) {
			System.out.println("数据库连接失败！！！");
		}
		// 3、操作数据库
		// 通过Connection对象实例化Statement对象
		try {
			int i=0;
			stmt = conn.createStatement();
			// 为sql变量赋值
			// 插入语句
			sql = "select * from shebeixinxi";
			r = stmt.executeQuery(sql);
			while(r.next()){
				she=new Shebei(r.getString(3),r.getString(2),r.getString(4),r.getString(5));
				b1.add(she);
			}
		} catch (Exception e) {
			System.out.println("操作数据库失败！！！");
		}
		// 4、关闭数据库
		try {
			// 关闭操作
			stmt.close();
			// 关闭连接
			conn.close();
		} catch (Exception e) {
			System.out.println("数据库关闭失败！！！");
		}
		
		
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 543, 406);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 36, 423, 159);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				rowz = table.getSelectedRow();
				
			}
		});
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
			},
			new String[] {
				"\u8BBE\u5907ID", "\u540D\u79F0", "\u4EF7\u683C", "\u72B6\u6001"
			}
		));
		scrollPane.setViewportView(table);
		for(int i=0;i<b1.size();i++){
			table.setValueAt(b1.get(i).getID(),i,0);
			table.setValueAt(b1.get(i).getName(),i,1);
			table.setValueAt(b1.get(i).getCast(),i,2);
			table.setValueAt(b1.get(i).getState(),i,3);
			
		}
		
		JLabel lblNewLabel = new JLabel("\u53EF\u4F7F\u7528\u8BBE\u5907\uFF1A");
		lblNewLabel.setBounds(10, 17, 93, 15);
		contentPane.add(lblNewLabel);
		
		JPanel panel = new JPanel();
		panel.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel.setBounds(10, 225, 299, 79);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JButton btnNewButton = new JButton("\u8D2D\u4E70\u7269\u54C1");
		btnNewButton.setBounds(10, 10, 93, 23);
		panel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("\u6807\u6CE8\u62A5\u5E9F");
		btnNewButton_1.setBounds(10, 43, 93, 23);
		panel.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("\u7269\u54C1\u4FEE\u7406");
		btnNewButton_2.setBounds(182, 10, 93, 23);
		panel.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("\u5237\u65B0");
		btnNewButton_3.setBounds(182, 43, 93, 23);
		panel.add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("\u5173\u95ED");
		btnNewButton_4.setBounds(402, 335, 93, 23);
		contentPane.add(btnNewButton_4);
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				run();
			}
		});
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				update up=new update(b1.get(rowz).getID());
				
			}
		});
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				for(int i=0;i<b1.size();i++){
					for(int j=0;j<4;j++){
						table.setValueAt(null,i,j);
					}
					
				}
				b2.add(b1.get(rowz));
				b1.remove(rowz);
				//for(int i=0;i<b2.size();i++){
					//table_1.setValueAt(b2.get(i).getID(), i, 0);
					//table_1.setValueAt(b2.get(i).getName(), i, 1);
					
				//}
				for(int i=0;i<b2.size();i++){
					delete del=new delete(b2.get(i).getID());
					System.out.println(b2.get(i).getID());
					Insert in=new Insert(b2.get(i).getID(),b2.get(i).getName());
				}
				for(int i=0;i<b1.size();i++){
					table.setValueAt(b1.get(i).getName(),i,0);
					table.setValueAt(b1.get(i).getID(),i,1);
					table.setValueAt(b1.get(i).getCast(),i,2);
					table.setValueAt(b1.get(i).getState(),i,3);
					
				}
				
				
			}
		});
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Goumai.run();
			}
		});
	}
	public void run() {
		try {
			labgui window = new labgui();
			window.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}

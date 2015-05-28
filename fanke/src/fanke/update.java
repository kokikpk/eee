package fanke;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class update {

	public update(String ID) {
		
		
		
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
					sql = "update shebeixinxi set state='损坏' Where equip_ID='"+ID+"' ";
					 stmt.executeUpdate(sql);
					
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
		// TODO 自动生成的构造函数存根
	}

}

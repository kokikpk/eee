package fanke;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Insert1 {

	public Insert1(String ID,String name,String cast,String state) {
		// TODO �Զ����ɵĹ��캯�����
		

		
		//�������ݿ���������
				String DBDRIVER = "sun.jdbc.odbc.JdbcOdbcDriver";
				// �������ݿ����ӵ�ַ
				String DBURL = "jdbc:odbc:fanke";
				// �������ݿ����Ӷ�������java.sql���еĽӿ�
				Connection conn = null;
				// ����Statement�������ڲ������ݿ�
				Statement stmt = null;
				// ����һ�ַ������������ڱ���SQL���
				String sql = null;
				// ����һ��������Դ�ż����Ľ��
				ResultSet r = null;
				// 1��������������
				try {
					Class.forName(DBDRIVER);
				} catch (Exception e) {
					// �˴�ʹ��out.print�Ǵ�����ʾĿ�ģ���ʵ�ʿ��������еĴ�����Ϣ��
					// ���Բ��ܹ�ͨ��System.out.print��ӡ���������ڰ�ȫ����
					System.out.println("���ݿ������������ʧ�ܣ�����");
				}
				// 2���������ݿ�
				try {
					conn = DriverManager.getConnection(DBURL);
				} catch (Exception e) {
					System.out.println("���ݿ�����ʧ�ܣ�����");
				}
				// 3���������ݿ�
				// ͨ��Connection����ʵ����Statement����
				try {
					int i=0;
					stmt = conn.createStatement();
					// Ϊsql������ֵ
					// �������
					sql = "insert into shebeixinxi (equip_ID,name,cast,state) values('"+ID+"','"+name+"','"+cast+"','"+state+"') ";
					 stmt.executeUpdate(sql);
					
				} catch (Exception e) {
					System.out.println("�������ݿ�ʧ�ܣ�����");
				}
				// 4���ر����ݿ�
				try {
					// �رղ���
					stmt.close();
					// �ر�����
					conn.close();
				} catch (Exception e) {
					System.out.println("���ݿ�ر�ʧ�ܣ�����");
				}
		// TODO �Զ����ɵĹ��캯�����
				// TODO �Զ����ɵĹ��캯�����
			}
	}



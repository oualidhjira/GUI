package database;
import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import struct.User;

public class Database {
   
		private DataSource ds;
		private Connection db;
		
		public Database(){
			
		}
		
		public Database(DataSource ds){
			this.setDs(ds);
		}
		
		public DataSource getDs() {
			return ds;
		}

		public void setDs(DataSource ds) {
			this.ds = ds;
			db=ds.getConnection();
		}

		public Connection getDb() {
			return db;
		}

		public void setDb(Connection db) {
			this.db = db;
		}
	    
	    public void insert(Object info){
			
			Class x = info.getClass();
			String tableName= x.getSimpleName();
			try {
			Field[] f = x.getDeclaredFields();
			f[0].setAccessible(true);
			StringBuffer query= new StringBuffer("insert into "+ tableName +" values('" + f[0].get(info)+"'");
			for (int i = 1; i < f.length; i++) {
				f[i].setAccessible(true);
				query.append(", '" +f[i].get(info) +"'");
			}
				query.append(")");
				System.out.println("Query"+query.toString());
				Statement sql = db.createStatement();
				sql.executeUpdate(query.toString());
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		public void update (Object info){
			Class x = info.getClass();
			String tableName= x.getSimpleName();
			try {
				
				Field[] f = x.getDeclaredFields();
				f[0].setAccessible(true);
				f[1].setAccessible(true);
				StringBuffer query = new StringBuffer("Update "+tableName +" set "+f[1].getName()+" = '"+f[1].get(info)+"'");
				for (int i = 2; i < f.length; i++) {
					f[i].setAccessible(true);
					query.append(","+f[i].getName()+" = '"+f[i].get(info)+"'");
					
				}
				query.append(" where "+f[0].getName()+" = '"+f[0].get(info)+"'");
				System.out.println(query.toString());
				Statement statement = db.createStatement();
				statement.executeUpdate(query.toString());
				
			} catch (Exception e) {
				System.out.print(e.getMessage());
				}
			
			
		}
		public void delete(Object info){
			
			Class x = info.getClass();
			String tableName= x.getSimpleName();
			try {
				
				Field[] f = x.getDeclaredFields();
				f[0].setAccessible(true);
				String query = "delete from "+tableName +" where "+f[0].getName()+" = '"+f[0].get(info)+"'";
				System.out.println(query);
				Statement statement = db.createStatement();
				statement.executeUpdate(query);
			} catch (Exception e) {
				// TODO: handle exception
			}
			
			
		}
		
		public Object select(Object info){
			
			Class x = info.getClass();
			String table = x.getSimpleName();
			try {
				Field[] f = x.getDeclaredFields();
				f[0].setAccessible(true);
				String query = "select * from "+table +" where "+f[0].getName()+" = '"+f[0].get(info)+"'";
				
				Statement statement = db.createStatement();
				ResultSet set =statement.executeQuery(query);
				if(set.next()){
					ResultSetMetaData rsm = set.getMetaData();
					int count =rsm.getColumnCount();
						for (int j = 2; j < count; j++) {
							String fn = rsm.getColumnName(j);
							Field field = x.getDeclaredField(fn);
							Object value = set.getObject(j);
							field.setAccessible(true);
							field.set(info, value);
						}
					return info;
				}	
			} catch (Exception e) {
				// TODO: handle exception
			}
			
			return null;
			
			
		}
		
		public List<Object> selectAll(Object info){
			
			ArrayList<Object> infos = new ArrayList<Object>();
			Class x = info.getClass();
			String table = x.getSimpleName();
			String query = "select * from "+table+";";
			System.out.println(query);
			Statement statement;
			try {
				statement = db.createStatement();
				ResultSet set =statement.executeQuery(query);
				System.out.println(set);
				if(set.next()){
					ResultSetMetaData rsm = set.getMetaData();
					int count =rsm.getColumnCount();
						for (int j = 1; j < count; j++) {
							String fn = rsm.getColumnName(j);
							System.out.println(fn);
							Field field = x.getDeclaredField(fn);
							Object value = set.getObject(j);
							field.setAccessible(true);
							field.set(info, value);
							infos.add(info);
							//Produit p = (Produit)info;
							//System.out.println(p);
						}
						System.out.println(">>"+infos.toString());
						return infos;
						
				}
			} catch (Exception e) {
				e.printStackTrace();
			}		
			return null;
			
		}

}

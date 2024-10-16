package com.shelley.util;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

/**
 * 封装了基本的CRUD方法，以供子类继承使用
 * 当前DAO直接在方法中获取数据连接
 * 整个DAO采取的是DBUtils解决方案
 * 
 * @author 禹舒怀
 *
 * @param <T>当前DAO处理的实体类是什么
 */
@SuppressWarnings({ "unchecked", "rawtypes",})
public class DAO<T> {
	
	private Class<T> clazz;
	//DBUtils的执行者
	private QueryRunner queryRunner = new QueryRunner();
	
	
	public DAO() {
		
		Type superClass = getClass().getGenericSuperclass();
		
		if(superClass instanceof ParameterizedType) {
			ParameterizedType parameterizedType = (ParameterizedType) superClass;
			Type[] typeArgs = parameterizedType.getActualTypeArguments();
			if(typeArgs != null && typeArgs.length > 0) {
				clazz = (Class<T>) typeArgs[0];
			}
		}
	}
	
	
	/**
	 * 返回某一个字段，例如：某一条记录的username，或返回数据表中的记录数
	 * @param <E>
	 * @param sql select count(*) from customer Long
	 * @param args
	 * @return
	 */
	
	public <E> E getForValue(String sql, Object ... args) {
		Connection conn = null;
		try {
			conn = JdbcUtils.getConnection();
			return (E) queryRunner.query(conn,sql,new ScalarHandler(),args);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JdbcUtils.releaseConnection(conn);
			//不关闭，会遇到限制数据库连接的情况，因为数据库连接池限制连接次数为5（自己可设置）
		}
		return null;
	}
	/**
	 * 返回T对应的List集合
	 * @param sql
	 * @param args
	 * @return
	 */
	public List<T> getForList(String sql, Object ... args){
		Connection conn = null;
		try {
			conn = JdbcUtils.getConnection();
			return queryRunner.query(conn,sql,new BeanListHandler<T>(clazz),args);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JdbcUtils.releaseConnection(conn);
		}
		return null;
	} 
	
	/**
	 * 返回对应T的一个实例（对象）
	 * @param sql
	 * @param args
	 * @return
	 */
	public T get(String sql, Object ... args) {
		Connection conn = null;
		try {
			conn = JdbcUtils.getConnection();
			return queryRunner.query(conn,sql,new BeanHandler<T>(clazz),args);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JdbcUtils.releaseConnection(conn);
		}
		return null;
	}
	
	
	/**
	 * 该方法封装了INSERT，DELETE，UPDATE
	 * @param sql
	 * @param objects
	 */
	public void update(String sql, Object ... args) {
		Connection conn = null;
		try {
			conn = JdbcUtils.getConnection();
			//DBUtils工具类中提取的通用的增删改的方法
			queryRunner.update(conn,sql,args);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JdbcUtils.releaseConnection(conn);
		}
	}
	
}

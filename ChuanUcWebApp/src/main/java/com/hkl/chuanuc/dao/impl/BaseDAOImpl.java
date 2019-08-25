package com.hkl.chuanuc.dao.impl;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.persistence.metamodel.SingularAttribute;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public abstract class BaseDAOImpl<T, ID extends Serializable> {

	private static final Logger _Logger = Logger.getLogger(BaseDAOImpl.class);
	@Autowired
	private SessionFactory sessionFactory;

	public List<T> findAll() {
		List<T> result = Collections.emptyList();
		Session session = null;
		try {
			session = sessionFactory.openSession();
			CriteriaBuilder builder = session.getCriteriaBuilder();
			CriteriaQuery<T> criteria = builder.createQuery(getEntityClass());
			Root<T> root = criteria.from(getEntityClass());
			criteria.select(root);
			result = session.createQuery(criteria).getResultList();
		} catch (Exception e) {
			_Logger.error(e.getMessage(), e);
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return result;
	}

	public T findById(ID id) {
		T result = null;
		Session session = null;
		try {
			session = sessionFactory.openSession();
			session.beginTransaction();
			result = session.get(getEntityClass(), id);
			session.getTransaction().commit();
		} catch (Exception e) {
			_Logger.error(e.getMessage(), e);
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return result;
	}

	public List<T> findAllById(List<ID> ids) {
		List<T> result = Collections.emptyList();
		Session session = null;
		try {
			session = sessionFactory.openSession();
			session.beginTransaction();

			CriteriaBuilder builder = session.getCriteriaBuilder();
			CriteriaQuery<T> criteria = builder.createQuery(getEntityClass());
			Root<T> root = criteria.from(getEntityClass());
			SingularAttribute attrId = root.getModel().getId(getIdClass());
			criteria.where(root.get(attrId).in(ids));
			result = session.createQuery(criteria).getResultList();
			session.getTransaction().commit();
		} catch (Exception e) {
			_Logger.error(e.getMessage(), e);
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return result;
	}

	public long count() {
		long count = 0;
		Session session = null;
		try {
			session = sessionFactory.openSession();
			session.beginTransaction();

			CriteriaBuilder builder = session.getCriteriaBuilder();
			CriteriaQuery<Long> criteria = builder.createQuery(Long.class);
			Root<T> root = criteria.from(getEntityClass());
			criteria.select(builder.count(root));
			count = session.createQuery(criteria).getSingleResult();
			session.getTransaction().commit();
		} catch (Exception e) {
			_Logger.error(e.getMessage(), e);
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return count;
	}

	public void saveOrUpdate(T entity) {
		Session session = null;
		try {
			session = sessionFactory.openSession();
			session.beginTransaction();
			session.saveOrUpdate(entity);
			session.getTransaction().commit();
		} catch (Exception e) {
			_Logger.error(e.getMessage(), e);
		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

	public int save(T entity) {
		int rs = 0;
		Session session = null;
		try {
			session = sessionFactory.openSession();
			session.beginTransaction();
			rs = (Integer) session.save(entity);
			session.getTransaction().commit();
		} catch (Exception e) {
			// _Logger.error(e.getMessage(), e);
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return rs;
	}

	public void update(T entity) {
		Session session = null;
		try {
			session = sessionFactory.openSession();
			session.beginTransaction();
			session.update(entity);
			session.getTransaction().commit();
		} catch (Exception e) {
			_Logger.error(e.getMessage(), e);
		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

	public void saveAll(List<T> list) {
		Session session = null;
		try {
			session = sessionFactory.openSession();
			session.beginTransaction();
			Iterator<T> it = list.iterator();
			while (it.hasNext()) {
				T temp = it.next();
				session.save(temp);
			}
			session.getTransaction().commit();
		} catch (Exception e) {
			_Logger.error(e.getMessage(), e);
		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

	public void updateAll(List<T> list) {
		Session session = null;
		try {
			session = sessionFactory.openSession();
			session.beginTransaction();
			Iterator<T> it = list.iterator();
			while (it.hasNext()) {
				T temp = it.next();
				session.update(temp);
			}
			session.getTransaction().commit();
		} catch (Exception e) {
			_Logger.error(e.getMessage(), e);
		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

	public void delete(T entity) {
		Session session = null;
		try {
			session = sessionFactory.openSession();
			session.beginTransaction();
			session.delete(entity);
			session.getTransaction().commit();
		} catch (Exception e) {
			_Logger.error(e.getMessage(), e);
		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

	public void deleteAll() {
		Session session = null;
		try {
			session = sessionFactory.openSession();
			session.beginTransaction();
			String hql = "TRUNCATE TABLE " + getEntityClass().getAnnotation(javax.persistence.Table.class).name();
			session.createNativeQuery(hql).executeUpdate();
			session.getTransaction().commit();
		} catch (Exception e) {
			_Logger.error(e.getMessage(), e);
		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

	public void deleteAll(List<T> entities) {
		Session session = null;
		try {
			session = sessionFactory.openSession();
			session.beginTransaction();
			for (T entity : entities) {
				session.delete(entity);
			}
			session.getTransaction().commit();
		} catch (Exception e) {
			_Logger.error(e.getMessage(), e);
		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

	public void deleteById(ID id) {
		Session session = null;
		try {
			session = sessionFactory.openSession();
			session.beginTransaction();
			T entity = session.get(getEntityClass(), id);
			session.delete(entity);
			session.getTransaction().commit();
		} catch (Exception e) {
			_Logger.error(e.getMessage(), e);
		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

	public boolean existsById(ID id) {
		boolean isExists = false;
		Session session = null;
		try {
			session = sessionFactory.openSession();
			session.beginTransaction();

			T entity = session.get(getEntityClass(), id);
			if (entity != null) {
				isExists = true;
			}
			session.getTransaction().commit();
		} catch (Exception e) {
			_Logger.error(e.getMessage(), e);
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return isExists;
	}

	private Class<T> getEntityClass() {
		return (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
	}

	private Class<T> getIdClass() {
		return (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[1];
	}
}

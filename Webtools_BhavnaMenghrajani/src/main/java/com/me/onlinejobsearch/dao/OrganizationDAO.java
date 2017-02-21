package com.me.onlinejobsearch.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.springframework.stereotype.Component;

import com.me.onlinejobsearch.pojo.Organization;

@Component
public class OrganizationDAO extends DAO {

	public void create(String organizationName, String organizationType) {
		try {
			begin();
			Organization organization = new Organization(organizationName, organizationType);
			getSession().save(organization);

			commit();
			close();
			return;

		} catch (HibernateException e) {
			rollback();

		}
	}

	public Organization get(String orgName) {
		try {
			begin();
			Query q = getSession().createQuery("from Organization where organizationName = :orgName");
			q.setString("orgName", orgName);
			Organization org = (Organization) q.uniqueResult();
			commit();
			return org;
		} catch (HibernateException e) {
			rollback();

		}
		return null;
	}

	public List list() {
		try {
			begin();
			Query q = getSession().createQuery("from Organization");
			List list = q.list();
			commit();
			return list;
		} catch (HibernateException e) {
			rollback();
			return null;

		}
	}

}

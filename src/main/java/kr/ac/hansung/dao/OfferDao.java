package kr.ac.hansung.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import kr.ac.hansung.model.Offer;

@Repository
@Transactional
public class OfferDao {

	@Autowired
	private SessionFactory sessionFactory;

	public Offer getOfferbyId(int id) {

		Session session = sessionFactory.getCurrentSession();
		Offer offer = (Offer) session.get(Offer.class, id);

		return offer;

	}

	// cRud method
	public List<Offer> getOffers() {

		Session session = sessionFactory.getCurrentSession();
		String hql = "from Offer";

		Query<Offer> query = session.createQuery(hql, Offer.class);
		List<Offer> offerList = query.getResultList();

		return offerList;

	}

	// Crud method
	public void insert(Offer offer) {

		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(offer);
		session.flush();

	}

	// crUd method
	public void update(Offer offer) {
		Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(offer);
        session.flush();


	}

	// cruD method
	public void delete(Offer offer) {
		Session session = sessionFactory.getCurrentSession();
        session.delete(offer);
        session.flush();


	}

}

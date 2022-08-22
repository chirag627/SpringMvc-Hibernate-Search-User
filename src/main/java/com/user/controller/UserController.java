package com.user.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.user.model.User;
import com.user.utils.HibernateUtils;

@Controller
public class UserController {

	@RequestMapping("/home")
	public String homePage(Model model, HttpServletRequest req, HttpServletResponse resp) {

		Session session = null;
		session = HibernateUtils.getSessionFactory().openSession();
		Query query2 = session.createQuery("FROM User");
		List usrs = query2.list();
		System.out.println(usrs.toString());

		System.out.println("session");
		model.addAttribute("LIST_USERS", usrs);

		return "index.jsp";

	}

	@RequestMapping("/search")
	public String Search(@RequestParam("id") int id, Model model, HttpServletRequest req, HttpServletResponse resp) {

		Session session = null;
		session = HibernateUtils.getSessionFactory().openSession();
		Query query2 = session.createQuery("FROM User where id=" + id);
		List usrs = query2.list();

		if (usrs.isEmpty()) {
			model.addAttribute("fail", "User doesnot exists");
			return "index.jsp";
		} else {

			model.addAttribute("LIST_USERS", usrs);
			return "search.jsp";

		}
	}

	@RequestMapping(value = "/edit", method = RequestMethod.POST)
	public String edit(@RequestParam("id") int id, @RequestParam("name") String name,
			@RequestParam("email") String email, @RequestParam("city") String city, Model model, HttpServletRequest req,
			HttpServletResponse resp) {

		Session session = null;
		session = HibernateUtils.getSessionFactory().openSession();

		Transaction tx = session.beginTransaction();

		User user = session.load(User.class, id);
		System.out.println(user);

		user.setName(name);
		user.setEmail(email);
		user.setCity(city);

		session.update(user);
		tx.commit();
		session.close();

		model.addAttribute("success", "User Updated Successfully");
		return "/home";

	}

}

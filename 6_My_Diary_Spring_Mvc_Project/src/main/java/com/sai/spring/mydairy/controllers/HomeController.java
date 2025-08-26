package com.sai.spring.mydairy.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.sai.spring.mydairy.business.EntriesBusiness;
import com.sai.spring.mydairy.business.UsersBusiness;
import com.sai.spring.mydairy.entities.Entries;
import com.sai.spring.mydairy.entities.User;

@Controller
public class HomeController {

	@Autowired
	HttpSession session;

	@Autowired
	private UsersBusiness usersBusiness;

	public HttpSession getSession() {
		return session;
	}

	public void setSession(HttpSession session) {
		this.session = session;
	}

	public UsersBusiness getUsersBusiness() {
		return usersBusiness;
	}

	public void setUsersBusiness(UsersBusiness usersBusiness) {
		this.usersBusiness = usersBusiness;
	}

	@Autowired
	private EntriesBusiness entriesBusiness;

	public EntriesBusiness getEntriesBusiness() {
		return entriesBusiness;
	}

	public void setEntriesBusiness(EntriesBusiness entriesBusiness) {
		this.entriesBusiness = entriesBusiness;
	}

	@RequestMapping("/home")
	public ModelAndView loginPage() {

		ModelAndView model = new ModelAndView("loginpage");
		return model;

	}

	@RequestMapping("/register")
	public ModelAndView registrationPage() {

		ModelAndView model = new ModelAndView("registrationpage");
		return model;

	}

	@RequestMapping("userhome")
	public ModelAndView userHomePage() {

		ModelAndView model = new ModelAndView("userhomepage");

		User user = (User) session.getAttribute("user");

		List<Entries> entries = null;

		try {
			entries = entriesBusiness.findByUserId(user.getId());
		} catch (Exception e) {
			e.printStackTrace();
		}
		model.addObject("entrieslist", entries);

		return model;

	}

	@RequestMapping(value = "saveuser", method = RequestMethod.POST)
	public ModelAndView saveUser(@ModelAttribute("user") User user) {

		// Save the user details in the Database

		System.out.println(user);

		ModelAndView model = new ModelAndView("registersuccess");

		usersBusiness.save(user);

		return model;

	}

	@RequestMapping(value = "/authenticate", method = RequestMethod.POST)
	public ModelAndView authenticteUser(@ModelAttribute("user") User user) {

		ModelAndView model = new ModelAndView("usernotexistorregistered");

		User dbUserDetails = usersBusiness.findByUserName(user.getUsername());

		if (dbUserDetails != null && user.getPassword().equals(dbUserDetails.getPassword())) {

			model.setViewName("userhomepage");
			model.addObject("user", dbUserDetails);

			List<Entries> entries = null;

			session.setAttribute("user", dbUserDetails);

			try {
				entries = entriesBusiness.findByUserId(dbUserDetails.getId());
			} catch (Exception e) {
				e.printStackTrace();
			}
			model.addObject("entrieslist", entries);
		}

		return model;
	}

	@RequestMapping("addentry")
	public ModelAndView addEntry() {

		ModelAndView model = new ModelAndView("addentryform");

		return model;

	}

	@RequestMapping("saveentry")
	public ModelAndView saveEntry(@ModelAttribute("entry") Entries entry) {

		ModelAndView model = new ModelAndView("userhomepage");

		entriesBusiness.save(entry);

		User user = (User) session.getAttribute("user");

		List<Entries> entries = null;

		try {
			entries = entriesBusiness.findByUserId(user.getId());
		} catch (Exception e) {
			e.printStackTrace();
		}
		model.addObject("entrieslist", entries);

		return model;

	}

	@RequestMapping("viewentry")
	public ModelAndView viewEntry(@RequestParam("id") int id) {

		ModelAndView model = new ModelAndView("displayentry");
		Entries entry = entriesBusiness.findById(id);
		model.addObject("entry", entry);

		User user = (User) session.getAttribute("user");

		if (user == null) {
			model.setViewName("loginpage");
		}

		return model;

	}

	@RequestMapping("updateentry")
	public ModelAndView updateEntry(@RequestParam("id") int id) {

		ModelAndView model = new ModelAndView("displayupdateentry");

		Entries entry = entriesBusiness.findById(id);

		model.addObject("entry", entry);

		User user = (User) session.getAttribute("user");

		if (user == null) {
			model.setViewName("loginpage");
		}

		return model;

	}

	@RequestMapping("processentryupdate")
	public ModelAndView processUpdateEntry(@ModelAttribute("entry") Entries entry) {

		ModelAndView model = new ModelAndView("userhomepage");

		entriesBusiness.update(entry);

		User user = (User) session.getAttribute("user");

		List<Entries> entries = null;

		try {
			entries = entriesBusiness.findByUserId(user.getId());
		} catch (Exception e) {
			e.printStackTrace();
		}
		model.addObject("entrieslist", entries);

		return model;

	}

	@RequestMapping("deleteentry")
	public ModelAndView deleteEntry(@RequestParam("id") int id) {

		ModelAndView model = new ModelAndView("userhomepage");

		Entries entry = entriesBusiness.findById(id);
		entriesBusiness.delete(entry);

		User user = (User) session.getAttribute("user");
		if (user == null) {
			model.setViewName("loginpage");
		}
		

		List<Entries> entries = null;

		try {
			entries = entriesBusiness.findByUserId(user.getId());
		} catch (Exception e) {
			e.printStackTrace();
		}
		model.addObject("entrieslist", entries);

		return model;

	}

	@RequestMapping("signout")
	public ModelAndView signout() {

		ModelAndView model = new ModelAndView("loginpage");
		session.invalidate();
		;
		return model;

	}

}

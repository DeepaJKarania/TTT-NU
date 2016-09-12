package com.shoes.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import com.shoes.dao.CategoryDao;
import com.shoes.model.Category;

@Controller
public class CategoryController {

	@Autowired
	CategoryDao catDao;

	@RequestMapping(value = "/Category", method = RequestMethod.GET)
	public ModelAndView displayCategory() {
		System.out.print("Inside GET");
		String data = catDao.listCategory(); // retrieve data
		ModelAndView m = new ModelAndView("AddCategory", "category", new Category());
		m.addObject("catList", data);
		System.out.println(data);
		System.out.print("Inside GET before");
		return m;
	}
	
//---------------------------------Add Data
	
	@RequestMapping(value = "/addCategory", method = RequestMethod.POST)
	public ModelAndView addCategory(Category cat) {
		System.out.println("inside post");
		catDao.addCategory(cat);
		String data = catDao.listCategory();
		ModelAndView m = new ModelAndView("AddCategory", "category", new Category());
		m.addObject("catList", data);
		return m;

	}

// --------------------Delete Data ----/DeleteCategory is a href link mean url

	@RequestMapping(value = "/DeleteCategory", method = RequestMethod.GET)
	public ModelAndView delCategory(@RequestParam("catId") int cat) {
		// catDao.addCategory(cat);
		System.out.println(cat);
		catDao.removeCat(cat);
		String data = catDao.listCategory();
		ModelAndView m = new ModelAndView("AddCategory", "category", new Category());
		m.addObject("catList", data);
		return m;

	}

	// ------------------Update-----------------------------------------------------------

	@RequestMapping("UpdateCategory")
	public ModelAndView updateUser(@ModelAttribute Category catObject) {
		System.out.println("Inside update ");
		catDao.updateRow(catObject);
		String data = catDao.listCategory();
		ModelAndView m = new ModelAndView("AddCategory", "category", new Category());
		m.addObject("catList", data);

		return m;
	}

	//---this method for taking data on the click of edit and retrieve data on the behalf of that id --------------------
	@RequestMapping(value = "/editCategory", method = RequestMethod.GET)
	public ModelAndView dispUpdateCategory(@RequestParam("catId") int cat) {
		System.out.print("Iside GET");
		Category catObject = catDao.getRowById(cat); // retrieve data
		ModelAndView m = new ModelAndView("UpdateCategory", "category", new Category());
		m.addObject("catObject", catObject);
		System.out.println(cat + "inside dispUpdateCategory ");

		return m;
	}

}

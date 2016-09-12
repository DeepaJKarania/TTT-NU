package com.shoes.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import com.shoes.dao.CategoryDao;
import com.shoes.dao.SupplierDao;
import com.shoes.model.Category;
import com.shoes.model.Supplier;

@Controller
public class SupplierController {

	@Autowired
	SupplierDao supDao;

	@RequestMapping(value = "/Supplier", method = RequestMethod.GET)
	public ModelAndView displaySupplier() {
		System.out.print("Inside GET");
		String data = supDao.listSupplier(); // retrieve data
		ModelAndView m = new ModelAndView("AddSupplier", "supplier", new Supplier());
		m.addObject("supList", data);
		System.out.println(data);
		System.out.print("Inside GET before");
		return m;
	}
	
//---------------------------------Add Data
	
	@RequestMapping(value = "/addSupplier", method = RequestMethod.POST)
	public ModelAndView addSupplier(Supplier sup) {
		System.out.println("inside post");
		supDao.addSupplier(sup);
		String data = supDao.listSupplier();
		ModelAndView m = new ModelAndView("AddSupplier", "supplier", new Supplier());
		m.addObject("supList", data);
		return m;

	}

// --------------------Delete Data ----/DeleteCategory is a href link mean url

	@RequestMapping(value = "/DeleteSupplier", method = RequestMethod.GET)
	public ModelAndView delSupplier(@RequestParam("supId") int sup) {
		
		System.out.println(sup);
		supDao.removeSup(sup);
		String data = supDao.listSupplier();
		ModelAndView m = new ModelAndView("AddSupplier", "supplier", new Supplier());
		m.addObject("supList", data);
		return m;

	}

	// ------------------Update-----------------------------------------------------------

	@RequestMapping("UpdateSupplier")
	public ModelAndView updateUser(@ModelAttribute Supplier supObject) {
		System.out.println("Inside update ");
		supDao.updateRow(supObject);
		String data = supDao.listSupplier();
		ModelAndView m = new ModelAndView("AddSupplier", "supplier", new Supplier());
		m.addObject("supList", data);

		return m;
	}

	//---this method for taking data on the click of edit and retrieve data on the behalf of that id --------------------
	@RequestMapping(value = "/editSupplier", method = RequestMethod.GET)
	public ModelAndView dispUpdateSupplier(@RequestParam("supId") int sup) {
		System.out.print("Iside GET");
		Supplier supObject = supDao.getRowById(sup); // retrieve data
		ModelAndView m = new ModelAndView("UpdateSupplier", "supplier", new Supplier());
		m.addObject("supObject", supObject);
		System.out.println(sup + "inside dispUpdateSupplier ");

		return m;
	}

}

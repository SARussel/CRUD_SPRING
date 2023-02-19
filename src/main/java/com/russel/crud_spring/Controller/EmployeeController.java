package com.russel.crud_spring.Controller;

import com.russel.crud_spring.Model.Employee;
import com.russel.crud_spring.Routes;
import com.russel.crud_spring.Service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;
    // display list of Employees
    @GetMapping(Routes.ROOT)
    public String viewHomePage(Model model) {
        /*
        TODO: THIS IS A SAMPLE TODO

         */
        model.addAttribute("listOfEmployees", employeeService.getAllEmployees());
        model.addAttribute("lang", LocaleContextHolder.getLocale().getLanguage());
        model.addAttribute("rootURL", Routes.ROOT);
        return "index";
    }

    @GetMapping(Routes.ADD_EMPLOYEE)
    public String getEmployeeForm(Model model, HttpServletRequest request){
        Employee employeeForm = new Employee();
        model.addAttribute("employeeForm", employeeForm);
        return "employee/create-employee";
    }

    @PostMapping(Routes.ADD_EMPLOYEE)
    public String addEmployee(@ModelAttribute Employee employee, Model model){
        employeeService.addNewEmployee(employee);
        model.addAttribute("listOfEmployees", employeeService.getAllEmployees());
        model.addAttribute("lang", LocaleContextHolder.getLocale().getLanguage());
        model.addAttribute("rootURL", Routes.ROOT);
        return "redirect:/";
    }
}

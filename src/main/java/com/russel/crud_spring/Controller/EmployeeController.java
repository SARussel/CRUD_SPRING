package com.russel.crud_spring.Controller;

import com.russel.crud_spring.Service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;
    // display list of Employees
    @GetMapping("/")
    public String viewHomePage(Model model) {
        model.addAttribute("listOfEmployees", employeeService.getAllEmployees());
        model.addAttribute("lang", LocaleContextHolder.getLocale().getLanguage());
        return "index";
    }
}

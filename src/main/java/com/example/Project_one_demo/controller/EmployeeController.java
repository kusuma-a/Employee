package com.example.Project_one_demo.controller;

import com.example.Project_one_demo.entity.Employee;
import com.example.Project_one_demo.repository.EmployeeRepository;
import com.example.Project_one_demo.service.EmployeeService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/employees")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @GetMapping
    public String listEmployees(Model model){
        model.addAttribute("employees",employeeService.getAllEmployees());
        return "employees/list";
    }

    @GetMapping("/new")
    public String showEmployeeForm(Model model){
        model.addAttribute("employee",new Employee());
        return "employees/form";
    }
    @PostMapping
    public String saveEmployee(@Valid @ModelAttribute Employee employee, BindingResult result,Model model){
        if(result.hasErrors()){
            return "employees/form";
        }
        employeeService.saveEmployee(employee);
        return "redirect:/employees";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable Long id, Model model){
        Employee employee = employeeService.getEmployeeById(id);
        model.addAttribute("employee",employee);
        return "employees/form";
    }
    @PostMapping("/delete/{id}")
    public String deleteEmployee(@PathVariable Long id){
        employeeService.deleteEmployee(id);
        return "redirect:/employees";
    }

}

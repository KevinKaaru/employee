package com.kaaru.employeeapp.employee_service.service;

import com.kaaru.employeeapp.employee_service.entity.Employee;
import com.kaaru.employeeapp.employee_service.openfeignclients.AddressClient;
import com.kaaru.employeeapp.employee_service.repository.EmployeeRepo;
import com.kaaru.employeeapp.employee_service.response.AddressResponse;
import com.kaaru.employeeapp.employee_service.response.EmployeeResponse;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {
    @Autowired
    private   EmployeeRepo employeeRepo;
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private AddressClient addressClient;

    public EmployeeResponse getEmployeeById(int id){
        Employee employee= employeeRepo.findById(id).get();
     EmployeeResponse employeeResponse  = modelMapper.map(employee,EmployeeResponse.class);
     ResponseEntity<AddressResponse> addressResponseEntity=addressClient.getAddressByEmployeeId(id);
     AddressResponse addressResponse=addressResponseEntity.getBody();
     employeeResponse.setAddressResponse(addressResponse);
        return  employeeResponse;


        //incase we are not using modelmapper
      /*  EmployeeResponse employeeResponse=new EmployeeResponse();
        employeeResponse.setId(employee.getId());
        employeeResponse.setName(employee.getName());
        employeeResponse.setEmail(employee.getEmail());
        employeeResponse.setBloodgroup(employee.getBloodgroup());
        return  employeeResponse;*/

    }
}

package cl.falabella.omniChanel.Services;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

;

@WebService(serviceName = "ServiciosWSDL", targetNamespace = "http://xmlns.oscarblancarte.com/services/v1/EmployeeService")
public class ServiciosWSDL {
    private static final List<Employee> EMPLOYEES = new ArrayList<>();

    @WebMethod
    @WebResult(name = "employee")
    public List<Employee> getEmployeeList(){
        return EMPLOYEES;
    }

    @WebMethod
    public boolean createEmployee(@WebParam(name = "employee") Employee employee){
        EMPLOYEES.add(employee);
        return true;
    }



}

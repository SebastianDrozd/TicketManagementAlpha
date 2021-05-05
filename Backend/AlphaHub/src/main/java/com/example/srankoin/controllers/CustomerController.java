package com.example.srankoin.controllers;
import com.example.srankoin.models.Customer;
import com.example.srankoin.services.CustomerService;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@RequestMapping("api/v1/Customers")
@RestController
@CrossOrigin(origins = "*")
public class CustomerController {

    private final CustomerService customerService; // declare the customerService

    public CustomerController(CustomerService customerService) { // constructor injection
        this.customerService = customerService;
    }

    //return all Customer Info
    @GetMapping
    public ResponseEntity<?> getAllCustomers(){
       List<Customer> customers = customerService.getAllCustomers();
       return ResponseEntity.ok(customers);
    }

    //grab the customer by id
    @GetMapping("/{id}")
    public ResponseEntity<Customer> findById(@PathVariable Integer id){
        Customer customer = customerService.findByIdentification(id);
        return ResponseEntity.ok(customer);
    }

    //method to post Customer data
    @PostMapping("/import")
    public void mapReapExcelDatatoDB(@RequestParam("file") MultipartFile reapExcelDataFile) throws IOException {

        //create the temp customer list
        List<Customer> tempStudentList = new ArrayList<Customer>();
        //create the Xcel workbook
        XSSFWorkbook workbook = new XSSFWorkbook(reapExcelDataFile.getInputStream());
        XSSFSheet worksheet = workbook.getSheetAt(0);

        //iterate through each row in the excel fileset
        for(int i=1;i<worksheet.getPhysicalNumberOfRows()-1 ;i++) {
            Customer tempStudent = new Customer(); //create new temp customer
            XSSFRow row = worksheet.getRow(i);
            tempStudent.setId(row.getRowNum()); //grab the id from the first row
            tempStudent.setCustomer(row.getCell(0).getStringCellValue());
            //Grab remaining values from the row
            tempStudent.setPhoneNumbers(row.getCell(1).getStringCellValue());
            tempStudent.setEmail(row.getCell(2).getStringCellValue());
            tempStudent.setFullName(row.getCell(3).getStringCellValue());
            tempStudent.setBillingAddress(row.getCell(4).getStringCellValue());
            tempStudent.setShippingAddress(row.getCell(5).getStringCellValue());
            tempStudentList.add(tempStudent);
            customerService.saveCustomer(tempStudent);
        }
        System.out.println(tempStudentList);

    }
}
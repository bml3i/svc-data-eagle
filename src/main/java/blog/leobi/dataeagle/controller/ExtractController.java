package blog.leobi.dataeagle.controller;

import blog.leobi.dataeagle.constant.CustomerConst;
import blog.leobi.dataeagle.dto.CustomerDTO;
import blog.leobi.dataeagle.dto.ResponseDTO;
import blog.leobi.dataeagle.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path="/api", produces = MediaType.APPLICATION_JSON_VALUE)
public class ExtractController {

    @Autowired
    CustomerService customerService;

    @GetMapping("/hello")
    public String extract() {
        return "hello world";
    }

    @PostMapping("/customer")
    public ResponseEntity<ResponseDTO> createCustomer(@RequestBody CustomerDTO customerDTO) {

        customerService.createCustomer(customerDTO);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(new ResponseDTO().buildSuccessMessage(CustomerConst.CUSTOMER_CREATED_SUCCESS));
    }

}


package com.crud.consultorio.controller;


import com.crud.consultorio.DTOs.TestDTO;
import com.crud.consultorio.model.Test;
import com.crud.consultorio.repositories.ITestRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/test")
public class TestController {
     @Autowired
    private ITestRepository _testRepository;
     
     @PostMapping
     public Test insertTest(@RequestBody TestDTO test) {
        var newTest = new Test(null, test.getName(),
                                   test.getDescription(),
                                       test.getPrice(),
                                     test.getDuration());

        return _testRepository.save(newTest);
    };
     
    @GetMapping
    public List<Test> getTest(){
        return _testRepository.findAll();
    }
    
    @GetMapping("/{id}")
    public Test getTest(@PathVariable int id){
        return _testRepository.findById(id).orElse(null);
    }
    
    @PutMapping("/{id}")
    public Test updateScheduling(@PathVariable int id, @RequestBody TestDTO test){
        var newTest = _testRepository.findById(id).orElse(null);

        if (newTest != null){

            newTest.setName(test.getName());
            newTest.setDescription(test.getDescription());
            newTest.setPrice(test.getPrice());
            newTest.setDuration(test.getDuration());


            return _testRepository.save(newTest);
        }

        return null;
    }
    
    @DeleteMapping("/{id}")
    public void deleteScheduling(@PathVariable int id){
        _testRepository.deleteById(id);
    }
}

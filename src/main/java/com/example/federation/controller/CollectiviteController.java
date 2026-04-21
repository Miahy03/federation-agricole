package com.example.federation.controller;
import com.example.federation.entity.Collectivity;
import com.example.federation.service.CollectiviteService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/collectivites")
public class CollectiviteController{
private final CollectiviteService service;
public CollectiviteController(CollectiviteService service){this.service=service;}

@PostMapping
public Collectivity create(@RequestBody Collectivity c){
return service.create(c);
}

@GetMapping
public List<Collectivity> all(){
return service.all();
}
}

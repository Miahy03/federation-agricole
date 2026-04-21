package com.example.federation.controller;
import com.example.federation.entity.Collectivite;
import com.example.federation.service.CollectiviteService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/collectivites")
public class CollectiviteController{
private final CollectiviteService service;
public CollectiviteController(CollectiviteService service){this.service=service;}

@PostMapping
public Collectivite create(@RequestBody Collectivite c){
return service.create(c);
}

@GetMapping
public List<Collectivite> all(){
return service.all();
}
}

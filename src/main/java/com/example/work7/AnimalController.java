package com.example.work7;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.Map;

@RestController
public class AnimalController {
    public Animal animal = new Animal("cat", 25);

    @GetMapping("/animals")
    public Animal getAnimals() {
        return animal;
    }

    @PostMapping("/animals")
    public ResponseEntity<String> create(@Validated @RequestBody CreateForm form) {
        //登録処理は割愛
        URI url = UriComponentsBuilder.fromUriString("http://localhost:8080")
                .path("/animals/id")
                .build()
                .toUri();
        return ResponseEntity.created(url).body("animal successfully created");
    }

    @PatchMapping("/animals/{id}")
    public ResponseEntity<Map<String, String>> update(@PathVariable("id") int id, @Validated @RequestBody UpdateForm form) {
        // 更新処理は省略
        return ResponseEntity.ok(Map.of("message", "animal successfully updated"));
    }

    @DeleteMapping("/animals/{id}")
    public ResponseEntity<Map<String, String>> delete(@PathVariable("id") int id) {
        // 処理は省略
        return ResponseEntity.ok(Map.of("message", "animal successfully delete"));
    }

}

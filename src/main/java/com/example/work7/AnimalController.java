package com.example.work7;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Map;

@RestController
public class AnimalController {
    @GetMapping("/animals")
    public List<String> getAnimals(@RequestParam(name = "name", required = false, defaultValue = "") String name
            , @RequestParam(name = "weight", required = false, defaultValue = "") String weight) {
        return List.of(name, weight);
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

// package com.catalog.Catalog.application.web;

// import java.util.UUID;

// import com.catalog.Catalog.application.dto.VideoDTO;
// import com.catalog.Catalog.application.service.IVideoService;
// import com.catalog.Catalog.domain.entity.Video;
// import org.springframework.http.HttpStatus;
// import org.springframework.http.ResponseEntity;
// import org.springframework.web.bind.annotation.DeleteMapping;
// import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.PathVariable;
// import org.springframework.web.bind.annotation.PostMapping;
// import org.springframework.web.bind.annotation.PutMapping;
// import org.springframework.web.bind.annotation.RequestBody;
// import org.springframework.web.bind.annotation.RequestMapping;
// import org.springframework.web.bind.annotation.RestController;

// @RestController
// @RequestMapping("/api/videos")
// public class VideoController {

// private IVideoService VideoService;

// public VideoController(IVideoService VideoService) {
// this.VideoService = VideoService;
// }

// @GetMapping
// public ResponseEntity findAll() {
// try {
// return ResponseEntity.ok().body(this.VideoService.findAll());
// } catch (Exception e) {

// }

// return null;
// }

// @GetMapping("/{id}")
// public ResponseEntity findById(@PathVariable UUID id) {
// try {
// return this.VideoService.findById(id).map(record ->
// ResponseEntity.ok().build())
// .orElse(ResponseEntity.notFound().build());

// } catch (Exception e) {

// }

// return null;
// }

// @PostMapping
// public ResponseEntity create(@RequestBody VideoDTO toAdd) {
// try {
// Video Video = this.VideoService.create(toAdd);
// return ResponseEntity.status(HttpStatus.CREATED).body(Video);
// } catch (Exception e) {
// // TODO: handle exception
// }

// return null;
// }

// @PutMapping("/{id}")
// public ResponseEntity update(@PathVariable UUID id, @RequestBody VideoDTO
// toUpdate) {
// try {
// return this.VideoService.findById(id).map(record -> {
// Video updated = this.VideoService.update(toUpdate);
// return ResponseEntity.ok().body(updated);
// }).orElse(ResponseEntity.notFound().build());
// } catch (Exception e) {
// // TODO: handle exception
// }

// return null;
// }

// @DeleteMapping("/{id}")
// public ResponseEntity delete(@PathVariable UUID id) {
// try {
// return VideoService.findById(id).map(record -> {
// this.VideoService.delete(id);
// return ResponseEntity.ok().build();
// }).orElse(ResponseEntity.notFound().build());
// } catch (Exception e) {
// // TODO: handle exception
// }

// return null;
// }
// }

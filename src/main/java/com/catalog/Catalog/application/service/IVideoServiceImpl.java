// package com.catalog.Catalog.application.service;

// import java.util.Optional;
// import java.util.UUID;

// import com.catalog.Catalog.application.dto.VideoDTO;
// import com.catalog.Catalog.domain.entity.Video;
// import com.catalog.Catalog.domain.repository.IVideoRepository;

// import org.springframework.stereotype.Service;

// @Service
// public class IVideoServiceImpl implements IVideoService {

// IVideoRepository VideoRepository;

// public IVideoServiceImpl(IVideoRepository VideoRepository) {
// this.VideoRepository = VideoRepository;
// }

// @Override
// public Iterable<Video> findAll() {
// return this.VideoRepository.findAllCategories();
// }

// @Override
// public Optional<Video> findById(UUID id) {
// return this.VideoRepository.findById(id);
// }

// @Override
// public Video create(VideoDTO toAdd) {
// return this.VideoRepository.create(toAdd.toEntity());
// }

// @Override
// public Video update(VideoDTO toUpdate) {
// return this.VideoRepository.update(toUpdate.toEntity());
// }

// @Override
// public void delete(UUID id) {
// this.VideoRepository.delete(id);
// }

// }

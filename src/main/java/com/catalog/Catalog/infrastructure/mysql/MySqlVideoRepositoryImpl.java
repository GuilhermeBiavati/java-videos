// package com.catalog.Catalog.infrastructure.mysql;

// import java.util.Optional;
// import java.util.UUID;

// import com.catalog.Catalog.application.dto.VideoDTO;
// import com.catalog.Catalog.domain.entity.Video;
// import com.catalog.Catalog.domain.repository.IVideoRepository;

// import org.springframework.stereotype.Repository;

// @Repository
// public class MySqlVideoRepositoryImpl implements IVideoRepository {

// private SpringDataVideoRepository springDataVideoRepository;

// public MySqlVideoRepositoryImpl(SpringDataVideoRepository
// springDataVideoRepository) {
// this.springDataVideoRepository = springDataVideoRepository;
// }

// @Override
// public Iterable<Video> findAllCategories() {
// return this.springDataVideoRepository.findAll();
// }

// @Override
// public Video create(Video toAdd) {
// return this.springDataVideoRepository.save(toAdd);
// }

// @Override
// public Optional<Video> findById(UUID id) {
// return this.springDataVideoRepository.findById(id);
// }

// @Override
// public Video update(Video toUpdate) {
// return this.springDataVideoRepository.save(toUpdate);
// }

// @Override
// public void delete(UUID id) {
// this.springDataVideoRepository.deleteById(id);
// }

// // @Override
// // public Optional<Video> findById() {
// // // TODO Auto-generated method stub
// // return null;
// // }

// }

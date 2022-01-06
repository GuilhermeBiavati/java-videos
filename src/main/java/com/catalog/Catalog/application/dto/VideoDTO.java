package com.catalog.Catalog.application.dto;

import java.io.Serializable;

import com.catalog.Catalog.domain.entity.Video;
import com.github.dozermapper.core.DozerBeanMapperBuilder;
import com.github.dozermapper.core.Mapper;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode
public class VideoDTO implements Serializable {

    private static final long serialVersionUID = 1L;
    private String name;

    public Video toEntity() {
        Mapper mapper = DozerBeanMapperBuilder.buildDefault();
        Video entity = mapper.map(this, Video.class);

        return entity;
    }
}

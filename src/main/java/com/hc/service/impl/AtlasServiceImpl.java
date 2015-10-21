package com.hc.service.impl;

import com.hc.dao.AtlasRepository;
import com.hc.dao.PicTypeRepository;
import com.hc.dao.TagRepository;
import com.hc.domain.Atlas;
import com.hc.domain.PicType;
import com.hc.domain.Picture;
import com.hc.domain.Tag;
import com.hc.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2015/9/5.
 */
@Component("atlasService")
@Transactional
public class AtlasServiceImpl implements AtlasService {

    @Autowired
    TagRepository tagRepository;

    @Autowired
    AtlasRepository atlasRepository;

    @Autowired
    PicTypeRepository picTypeRepository;

    @Autowired
    PictureService pictureService;

    @Autowired
    PicTypeService picTypeService;

    @Autowired
    TagService tagService;

    @Autowired
    UserService userService;

    @Override
    public void delete(long id) {
        List<Picture> pictures = pictureService.findPicturesByAtlasId(id);
        pictures.stream().forEach( picture -> {
            pictureService.delete(picture.getId());
        });
        atlasRepository.delete(id);
    }

    @Override
    public List<Tag> atlasTag(long atlasId) {
        Atlas atlas = atlasRepository.findOne(atlasId);
        return null;
    }

    @Override
    public Page<Atlas> findAll(Pageable pageable) {
        Page<Atlas> atlases = atlasRepository.findAll(pageable);
        return atlases;
    }

    @Override
    public Page<Atlas> findByAtlasName(String atlas, Pageable pageable) {
        return atlasRepository.findByAtlasLike(atlas, pageable);
    }

    @Override
    public Atlas save(Atlas atlas) {
        return atlasRepository.save(atlas);
    }

    @Override
    public Atlas saveForForm(Map<String, Object> params) {
        String name = (String) params.get("name");
        long pictypeId = Long.valueOf(params.get("pictype").toString());
        List<Integer> tagIds = (List<Integer>) params.get("tagIds");
        List<String> filenames = (List<String>) params.get("files");

        Atlas atlas = new Atlas();
        List<Tag> tags = new ArrayList<>();
        for (Integer tagId : tagIds){
            tags.add(tagService.findOne(tagId));
        }
        atlas.setTags(tags);
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        atlas.setUser(userService.findUserByUsername(((UserDetails)principal).getUsername()));
        atlas.setAtlas(name);
        atlas.setPicType(picTypeService.findOne(pictypeId));
        atlas.setAddtime(String.valueOf(System.currentTimeMillis()));
        atlasRepository.save(atlas);

        for (String picpath : filenames){
            Picture picture = new Picture();
            picture.setPicpath(picpath);
            picture.setAtlas(atlas);
            picture.setAddtime(String.valueOf(System.currentTimeMillis()));
            pictureService.save(picture);
        }
        return atlas;
    }

    @Override
    public Atlas findOne(long id) {
        return atlasRepository.findOne(id);
    }

    @Override
    public Atlas updateForForm(Map<String, Object> params) {

        String name = (String) params.get("atlas");
        long atlasId = Long.valueOf(params.get("id").toString());
        long pictypeId = Long.valueOf(params.get("picTypeId").toString());
        List<Integer> tagIds = (List<Integer>) params.get("tagIds");
        List<String> filenames = (List<String>) params.get("files");

        Atlas atlas = atlasRepository.findOne(atlasId);
        List<Tag> tags = new ArrayList<>();
        for (Integer tagId : tagIds){
            tags.add(tagService.findOne(tagId));
        }
        atlas.setTags(tags);
        atlas.setAtlas(name);
        atlas.setPicType(picTypeService.findOne(pictypeId));
        atlasRepository.save(atlas);

        for (String picpath : filenames){
            Picture picture = new Picture();
            picture.setPicpath(picpath);
            picture.setAtlas(atlas);
            picture.setAddtime(String.valueOf(System.currentTimeMillis()));
            pictureService.save(picture);
        }
        return atlas;
    }
}

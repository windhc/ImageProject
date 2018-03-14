package com.hc.service.impl;

import com.hc.dao.AtlasRepository;
import com.hc.dao.PicTypeRepository;
import com.hc.dao.TagRepository;
import com.hc.domain.Atlas;
import com.hc.domain.Picture;
import com.hc.domain.Tag;
import com.hc.exception.ServiceException;
import com.hc.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author Administrator
 * @date 2015/9/5
 */
@Service
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
        atlasRepository.deleteById(id);
    }

    @Override
    public List<Tag> atlasTag(long atlasId) {
        Atlas atlas = atlasRepository.findById(atlasId).orElseThrow(ServiceException::new);
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

        for (String picpath : filenames){
            Picture picture = new Picture();
            picture.setPicpath(picpath);
            picture.setAtlas(atlas);
            picture.setAddtime(String.valueOf(System.currentTimeMillis()));
            pictureService.save(picture);
            if (filenames.get(0).equals(picpath)) {
                atlas.setFrontCover(picpath);
            }
        }
        atlasRepository.save(atlas);
        return atlas;
    }

    @Override
    public Atlas findOne(long id) {
        return atlasRepository.findById(id).orElseThrow(ServiceException::new);
    }

    @Override
    public Atlas updateForForm(Map<String, Object> params) {

        String name = (String) params.get("atlas");
        long atlasId = Long.valueOf(params.get("id").toString());
        long pictypeId = Long.valueOf(params.get("picTypeId").toString());
        List<Integer> tagIds = (List<Integer>) params.get("tagIds");
        List<String> filenames = (List<String>) params.get("files");

        Atlas atlas = atlasRepository.findById(atlasId).orElseThrow(ServiceException::new);
        List<Tag> tags = new ArrayList<>();
        for (Integer tagId : tagIds){
            tags.add(tagService.findOne(tagId));
        }
        atlas.setTags(tags);
        atlas.setAtlas(name);
        atlas.setPicType(picTypeService.findOne(pictypeId));

        for (String picpath : filenames){
            Picture picture = new Picture();
            picture.setPicpath(picpath);
            picture.setAtlas(atlas);
            picture.setAddtime(String.valueOf(System.currentTimeMillis()));
            pictureService.save(picture);
            if (filenames.get(0).equals(picpath)) {
                atlas.setFrontCover(picpath);
            }
        }
        atlasRepository.save(atlas);
        return atlas;
    }

    @Override
    public Page<Atlas> findByPicType(long typeId, Pageable pageable) {
        return atlasRepository.findByPicTypeId(typeId, pageable);
    }

    @Override
    public Page<Atlas> findByTagIds(List<Long> tagIds, PageRequest pageRequest) {

        List<Tag> tags = new ArrayList<>();
        for(long tagId : tagIds) {
            tags.add(tagService.findOne(tagId));
        }
        return atlasRepository.findByTagsIn(tags, pageRequest);
    }
}

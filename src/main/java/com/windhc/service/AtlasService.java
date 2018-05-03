package com.windhc.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.windhc.dao.AtlasMapper;
import com.windhc.dao.PicTypeMapper;
import com.windhc.dao.TagMapper;
import com.windhc.domain.Atlas;
import com.windhc.domain.Picture;
import com.windhc.domain.Tag;
import com.windhc.utils.PageRequest;
import org.springframework.beans.factory.annotation.Autowired;
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
public class AtlasService {

    @Autowired
    private TagMapper tagMapper;

    @Autowired
    private AtlasMapper atlasMapper;

    @Autowired
    private PicTypeMapper picTypeMapper;

    @Autowired
    private PictureService pictureService;

    @Autowired
    private PicTypeService picTypeService;

    @Autowired
    private TagService tagService;

    @Autowired
    private UserService userService;

    public void delete(long id) {
        List<Picture> pictures = pictureService.findPicturesByAtlasId(id);
        pictures.stream().forEach( picture -> {
            pictureService.delete(picture.getId());
        });
        atlasMapper.deleteByPrimaryKey(id);
    }

    public List<Tag> atlasTag(long atlasId) {
        Atlas atlas = atlasMapper.selectByPrimaryKey(atlasId);
        return null;
    }

    public PageInfo<Atlas> findAll(PageRequest pageRequest) {
        return PageHelper.startPage(pageRequest.getPageNum(), pageRequest.getPageSize())
                .doSelectPageInfo(() -> atlasMapper.selectAll());
    }

//    public Page<Atlas> findByAtlasName(String atlas, Pageable pageable) {
//        return atlasMapper.findByAtlasLike(atlas, pageable);
//    }

    public void save(Atlas atlas) {
        atlasMapper.insertSelective(atlas);
    }

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
        atlasMapper.insertSelective(atlas);
        return atlas;
    }

    public Atlas findOne(long id) {
        return atlasMapper.selectByPrimaryKey(id);
    }

    public Atlas updateForForm(Map<String, Object> params) {
        String name = (String) params.get("atlas");
        long atlasId = Long.valueOf(params.get("id").toString());
        long pictypeId = Long.valueOf(params.get("picTypeId").toString());
        List<Integer> tagIds = (List<Integer>) params.get("tagIds");
        List<String> filenames = (List<String>) params.get("files");

        Atlas atlas = atlasMapper.selectByPrimaryKey(atlasId);
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
        atlasMapper.insertSelective(atlas);
        return atlas;
    }

//    public Page<Atlas> findByPicType(long typeId, Pageable pageable) {
//        return atlasMapper.findByPicTypeId(typeId, pageable);
//    }

//    public Page<Atlas> findByTagIds(List<Long> tagIds, PageRequest pageRequest) {
//        List<Tag> tags = new ArrayList<>();
//        for(long tagId : tagIds) {
//            tags.add(tagService.findOne(tagId));
//        }
//        return atlasMapper.findByTagsIn(tags, pageRequest);
//    }
}

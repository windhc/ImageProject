package com.hc.web;

import com.hc.domain.DemoEntity;
import com.hc.service.DemoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2015/7/26.
 *
 * @RestController api形式，返回json数据
 * 1：addOne 单条增加
 * 2: addList 多条增加
 * 3: remove 删除操作
 * 4: removeIn 删除的in操作
 * 5: modify 修改操作
 * 6: queryOne 查找单条，不存在返回null
 * 7: queryList 多条查询，不存在返回[]空数组
 * 8: queryPage 分页查询
 * 9：transaction 事务测试
 */
@RestController
@RequestMapping("/demo")
public class DemoController {

    @Autowired
    private DemoService demoService;


    private final static Logger log = LoggerFactory.getLogger(DemoController.class);

    @RequestMapping({"", "/index"})
    public String index(){
        log.info("requested index page");
        return "/index.html";
    }

    /**
     * 单条插入
     * @return int
     */
    @RequestMapping("/addOne")
    public void addOne(){
        //构造数据
        DemoEntity demo = new DemoEntity();
        demo.setName("demo");
        demo.setIntro("demo is a insertOne test!");
        //执行业务
        demoService.addOne(demo);
    }

    /**
     * 多条插入
     * @return int
     */
    @RequestMapping("/addList")
    public int addList(){
        //构造数据 length=3的list
        List<DemoEntity> demolist = new ArrayList<DemoEntity>();
        DemoEntity demo1 = new DemoEntity();
        demo1.setName("demo");
        demo1.setIntro("demo is a insertList test!");
        demolist.add(demo1);
        DemoEntity demo2 = new DemoEntity();
        demo2.setName("demo");
        demo2.setIntro("demo is a insertList test!");
        demolist.add(demo2);
        DemoEntity demo3 = new DemoEntity();
        demo3.setName("demo");
        demo3.setIntro("demo is a insertList test!");
        demolist.add(demo3);
        //执行业务
        return demoService.addList(demolist);
    }

    /**
     * 更新数据
     * @return int
     */
    @RequestMapping("/modify")
    public DemoEntity modify(){
        //构造数据
        DemoEntity demo = new DemoEntity();
        demo.setId(45);
        demo.setName("demoUpdate");
        demo.setIntro("demo is a updateDemo test!");
        //执行业务
        return demoService.update(demo);
    }

    /**
     * 删除数据
     * @return int
     */
    @RequestMapping("/remove")
    public void remove(){
        //构造数据
        int id = 58;
        //执行业务
        demoService.remove(id);
    }

    /**
     * 单条查询
     * @return int
     */
    @RequestMapping("/queryOne")
    public DemoEntity queryOne(){
        //构造数据
        int id = 5;
        //执行业务(不存在null)
        DemoEntity demo = demoService.queryOne(id);
        return demo;
    }
}

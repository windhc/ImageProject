package com.hc.service;

import com.hc.dao.DemoRepository;
import com.hc.domain.DemoEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 业务处理层
 */
@Service
public class DemoService {
	
	@Autowired
	private DemoRepository demoRepository;

	public DemoEntity addOne(DemoEntity demo) {

		return (DemoEntity) demoRepository.save(demo);
	}

	public int addList(List<DemoEntity> demolist) {

		return 0;
	}

	public DemoEntity update(DemoEntity demo) {
		return (DemoEntity) demoRepository.save(demo);
	}

	public void remove(int id) {
		demoRepository.delete(id);
	}

//	public int removeIn(List<Integer> ids) {
//		return demoRepository.removeIn(ids);
//	}

	/**
	 * 事务
	 */
	@Transactional
	public void transaction() {
		//构造数据
		DemoEntity demo = new DemoEntity();
		demo.setName("demo");
		demo.setIntro("demo is a insertOne test!");
		addOne(demo);
		//添加以下一行会抛异常，事务回滚
		Integer.parseInt("sss");
		addOne(demo);
	}
	public DemoEntity queryOne(int id) {
		return (DemoEntity) demoRepository.findOne(id);
	}
//
//	public List<DemoEntity> queryList(String name) {
//		List<DemoEntity> demos = demoRepository.queryList(name);
//		return demos;
//	}
//
//	public Pager<DemoEntity> queryPage(List<String> ids, String name, Pager<DemoEntity> pager) {
//		List<DemoEntity> demos = demoRepository.queryPage(ids,name,pager);
//		int count = demoRepository.count(ids,name);
//		pager.setTotal(count);
//		pager.setEndNo();
//		pager.setResult(demos);
//		return pager;
//	}
}

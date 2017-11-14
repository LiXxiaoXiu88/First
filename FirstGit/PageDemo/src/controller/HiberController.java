package controller;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import pojo.Hiber;

import service.HiberService;

@Controller
public class HiberController {

	@Autowired
	private HiberService hs;

	public HiberService getHs() {
		return hs;
	}

	public void setHs(HiberService hs) {
		this.hs = hs;
	}

	@RequestMapping("/getAll")
	// defaultValue="1"初始值=1
	public String getAll(@RequestParam(defaultValue = "1") int pageindex,
			HttpServletRequest request) {

		int count = hs.conut();
		int countpage = count % 5 == 0 ? count / 5 : count / 5 + 1;
		request.getSession().setAttribute("countpage", countpage);
		// 调用分页查询 所有的第几页 第几条开始 每页显示几条全部在这里搞定
		// 每页显示条数直接固定5调
		// 最后一页也能点到最后一页
		if (pageindex < 1 || pageindex > countpage) {
			return "index.jsp";
		} else {
			System.out.println("!!!");
			// 第一步 一定要根据当前页码算出起始条数
			//pageindex 当前页数      *5从第几条开始
			int begin = (pageindex - 1) * 5;
			
			List<Hiber> list = hs.getAll(begin, 5);
			// 1.存查出来的结果集
			request.getSession().setAttribute("list", list);
			// 2.存当前页码 也要存在作用域
			request.getSession().setAttribute("pageindex", pageindex);

			/*
			 * int count = hs.conut(); int count=hs.conut(); int
			 * countpage=count%5==0?count/5:count/5+1;
			 * request.getSession().setAttribute("countpage", countpage);
			 * 
			 * int countpages=0; 
			 * if (count%5==0) { 
			 * countpages=count/5; 
			 * }else {
			 * countpages=count/5+1; 
			 * }
			 * request.getSession().setAttribute("countpages", countpages);
			 */

			return "index.jsp";

		}

	}

}

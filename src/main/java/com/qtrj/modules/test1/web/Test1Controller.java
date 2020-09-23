/**
 * Copyright &copy; 2015-2020 <a href="http://www.qdbak.com/">青岛佰安客科技有限公司</a> All rights reserved.
 */
package com.qtrj.modules.test1.web;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.ConstraintViolationException;

import org.apache.shiro.authz.annotation.Logical;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.google.common.collect.Lists;
import com.qtrj.common.utils.DateUtils;
import com.qtrj.common.config.Global;
import com.qtrj.common.json.AjaxJson;
import com.qtrj.core.persistence.Page;
import com.qtrj.core.web.BaseController;
import com.qtrj.common.utils.StringUtils;
import com.qtrj.common.utils.excel.ExportExcel;
import com.qtrj.common.utils.excel.ImportExcel;
import com.qtrj.modules.test1.entity.Test1;
import com.qtrj.modules.test1.service.Test1Service;

/**
 * 测试1Controller
 * @author 尹彬
 * @version 2020-06-21
 */
@Controller
@RequestMapping(value = "${adminPath}/test1/test1")
public class Test1Controller extends BaseController {

	@Autowired
	private Test1Service test1Service;
	
	@ModelAttribute
	public Test1 get(@RequestParam(required=false) String id) {
		Test1 entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = test1Service.get(id);
		}
		if (entity == null){
			entity = new Test1();
		}
		return entity;
	}
	
	/**
	 * 测试1列表页面
	 */
	@RequiresPermissions("test1:test1:list")
	@RequestMapping(value = {"list", ""})
	public String list(Test1 test1, Model model) {
		model.addAttribute("test1", test1);
		return "modules/test1/test1List";
	}
	
		/**
	 * 测试1列表数据
	 */
	@ResponseBody
	@RequiresPermissions("test1:test1:list")
	@RequestMapping(value = "data")
	public Map<String, Object> data(Test1 test1, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<Test1> page = test1Service.findPage(new Page<Test1>(request, response), test1); 
		return getBootstrapData(page);
	}

	/**
	 * 查看，增加，编辑测试1表单页面
	 */
	@RequiresPermissions(value={"test1:test1:view","test1:test1:add","test1:test1:edit"},logical=Logical.OR)
	@RequestMapping(value = "form")
	public String form(Test1 test1, Model model) {
		model.addAttribute("test1", test1);
		return "modules/test1/test1Form";
	}

	/**
	 * 保存测试1
	 */
	@ResponseBody
	@RequiresPermissions(value={"test1:test1:add","test1:test1:edit"},logical=Logical.OR)
	@RequestMapping(value = "save")
	public AjaxJson save(Test1 test1, Model model) throws Exception{
		AjaxJson j = new AjaxJson();
		/**
		 * 后台hibernate-validation插件校验
		 */
		String errMsg = beanValidator(test1);
		if (StringUtils.isNotBlank(errMsg)){
			j.setSuccess(false);
			j.setMsg(errMsg);
			return j;
		}
		//新增或编辑表单保存
		test1Service.save(test1);//保存
		j.setSuccess(true);
		j.setMsg("保存测试1成功");
		return j;
	}
	
	/**
	 * 删除测试1
	 */
	@ResponseBody
	@RequiresPermissions("test1:test1:del")
	@RequestMapping(value = "delete")
	public AjaxJson delete(Test1 test1) {
		AjaxJson j = new AjaxJson();
		test1Service.delete(test1);
		j.setMsg("删除测试1成功");
		return j;
	}
	
	/**
	 * 批量删除测试1
	 */
	@ResponseBody
	@RequiresPermissions("test1:test1:del")
	@RequestMapping(value = "deleteAll")
	public AjaxJson deleteAll(String ids) {
		AjaxJson j = new AjaxJson();
		String idArray[] =ids.split(",");
		for(String id : idArray){
			test1Service.delete(test1Service.get(id));
		}
		j.setMsg("删除测试1成功");
		return j;
	}
	
	/**
	 * 导出excel文件
	 */
	@ResponseBody
	@RequiresPermissions("test1:test1:export")
    @RequestMapping(value = "export")
    public AjaxJson exportFile(Test1 test1, HttpServletRequest request, HttpServletResponse response) {
		AjaxJson j = new AjaxJson();
		try {
            String fileName = "测试1"+DateUtils.getDate("yyyyMMddHHmmss")+".xlsx";
            Page<Test1> page = test1Service.findPage(new Page<Test1>(request, response, -1), test1);
    		new ExportExcel("测试1", Test1.class).setDataList(page.getList()).write(response, fileName).dispose();
    		j.setSuccess(true);
    		j.setMsg("导出成功！");
    		return j;
		} catch (Exception e) {
			j.setSuccess(false);
			j.setMsg("导出测试1记录失败！失败信息："+e.getMessage());
		}
			return j;
    }

	/**
	 * 导入Excel数据

	 */
	@ResponseBody
	@RequiresPermissions("test1:test1:import")
    @RequestMapping(value = "import")
   	public AjaxJson importFile(@RequestParam("file")MultipartFile file, HttpServletResponse response, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		try {
			int successNum = 0;
			int failureNum = 0;
			StringBuilder failureMsg = new StringBuilder();
			ImportExcel ei = new ImportExcel(file, 1, 0);
			List<Test1> list = ei.getDataList(Test1.class);
			for (Test1 test1 : list){
				try{
					test1Service.save(test1);
					successNum++;
				}catch(ConstraintViolationException ex){
					failureNum++;
				}catch (Exception ex) {
					failureNum++;
				}
			}
			if (failureNum>0){
				failureMsg.insert(0, "，失败 "+failureNum+" 条测试1记录。");
			}
			j.setMsg( "已成功导入 "+successNum+" 条测试1记录"+failureMsg);
		} catch (Exception e) {
			j.setSuccess(false);
			j.setMsg("导入测试1失败！失败信息："+e.getMessage());
		}
		return j;
    }
	
	/**
	 * 下载导入测试1数据模板
	 */
	@ResponseBody
	@RequiresPermissions("test1:test1:import")
    @RequestMapping(value = "import/template")
     public AjaxJson importFileTemplate(HttpServletResponse response) {
		AjaxJson j = new AjaxJson();
		try {
            String fileName = "测试1数据导入模板.xlsx";
    		List<Test1> list = Lists.newArrayList(); 
    		new ExportExcel("测试1数据", Test1.class, 1).setDataList(list).write(response, fileName).dispose();
    		return null;
		} catch (Exception e) {
			j.setSuccess(false);
			j.setMsg( "导入模板下载失败！失败信息："+e.getMessage());
		}
		return j;
    }

}
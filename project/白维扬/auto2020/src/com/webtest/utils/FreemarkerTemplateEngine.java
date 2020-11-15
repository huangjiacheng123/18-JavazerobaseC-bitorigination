package com.webtest.utils;

import java.io.File;
import java.io.StringWriter;
import java.util.Map;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateExceptionHandler;

public class FreemarkerTemplateEngine {
	private static final String DEFAULT_TEMPLATE = "reportTemplate.html";

	public String getTemplatePath() {
		return "conf";
	}

	public String run(Map<String, Object> context) throws Exception {
		return executeFreemarker(context);
	}

	private String executeFreemarker(Map<String, Object> context) throws Exception {
		// 这里的配置设置用官网最新的，http://freemarker.foofun.cn/pgui_quickstart_all.html
		Configuration cfg = new Configuration(Configuration.VERSION_2_3_22);
		cfg.setDirectoryForTemplateLoading(new File(getTemplatePath()));
		cfg.setDefaultEncoding("UTF-8");
		cfg.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);
		Template temp = cfg.getTemplate(getTemplate());
		StringWriter out = new StringWriter();
		temp.process(context, out);
		// System.out.print(out.toString());
		return out.toString();
	}

	public String getTemplate() {
		// TODO Auto-generated method stub
		return DEFAULT_TEMPLATE;
	}
}

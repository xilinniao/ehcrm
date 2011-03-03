/**
 * 
 */
package com.eh.base.util;

import java.io.IOException;
import java.io.StringWriter;

import freemarker.cache.ClassTemplateLoader;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

/**
 * @author 周才伦 Oct 26, 2010
 */
public class FreeMarkerUtil {
	private static String TEMPLATE_PATH = "/config/freemaker/json";

    private static Configuration cfg = new Configuration();

    static{
            // Specify the data source where the template files come from.
            // Here I set a file directory for it:
            cfg.setTemplateLoader(new ClassTemplateLoader(FreeMarkerUtil.class , TEMPLATE_PATH));

            // Specify how templates will see the data-model. This is an advanced
            // topic...
            // but just use this:
            //cfg.setObjectWrapper(new DefaultObjectWrapper());

            // the SoftCacheStorage is thread-safe
            //cfg.setCacheStorage(new freemarker.cache.MruCacheStorage(20, 250));
            //cfg.setCacheStorage(new SoftCacheStorage());
            cfg.setDefaultEncoding("UTF-8");
    }
	/**
	 * 处理
	 * @param templateText
	 * @param data
	 * @return
	 */
	public static String process(String templateName , Object data) {
		try {
			Template template = cfg.getTemplate(templateName);
			StringWriter stringWriter = new StringWriter();
			template.process(data, stringWriter);
			stringWriter.flush();
			return stringWriter.toString();
		} catch (TemplateException e) {
			throw new RuntimeException(e);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}
}

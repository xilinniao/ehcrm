package com.eh.shop.front.web;

import static nl.captcha.Captcha.NAME;

import java.awt.Color;
import java.awt.Font;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import nl.captcha.Captcha;
import nl.captcha.backgrounds.GradiatedBackgroundProducer;
import nl.captcha.servlet.CaptchaServletUtil;
import nl.captcha.text.producer.DefaultTextProducer;
import nl.captcha.text.renderer.DefaultWordRenderer;

public class CaptchaServlet extends HttpServlet {

    /**
	 * 
	 */
	private static final long serialVersionUID = 6201842092807209175L;

	private static DefaultWordRenderer dwr = null;
    
    private static char[] numberChar = new char[] {'0','1', '2', '3', '4', '5', '6', '7', '8','9'};

    @Override
    public void init() throws ServletException {
    	List<Font> fontList = new ArrayList<Font>();  
    	fontList.add(new Font("Arial", Font.HANGING_BASELINE, 30));//可以设置斜体之类的  
        fontList.add(new Font("Courier", Font.PLAIN, 30));
        List<Color> colorList = new ArrayList<Color>();
        colorList.add(Color.green);
        
        dwr = new DefaultWordRenderer(colorList,fontList);
    }

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp)throws ServletException, IOException {
    	
    	List<Font> fontList = new ArrayList<Font>();  
    	fontList.add(new Font("Arial", Font.HANGING_BASELINE, 30));//可以设置斜体之类的  
        fontList.add(new Font("Courier", Font.PLAIN, 30));
        List<Color> colorList = new ArrayList<Color>();
        colorList.add(Color.BLACK);
        colorList.add(Color.ORANGE);
        colorList.add(Color.blue);
        
        dwr = new DefaultWordRenderer(colorList,fontList);
        
        
        Captcha captcha = new Captcha.Builder(100, 30)
	        .addText(new DefaultTextProducer(4,numberChar),dwr)
	        .addBorder()
	        //.addNoise()
	        //.addBackground()
	        .addBackground(new GradiatedBackgroundProducer())
	        .build();

            /*    .addText()
                .addBackground(new GradiatedBackgroundProducer())
            .gimp()
            .addNoise()
            .addBorder()
            .build();*/

        CaptchaServletUtil.writeImage(resp, captcha.getImage());
        req.getSession().setAttribute(NAME, captcha);
    }
}

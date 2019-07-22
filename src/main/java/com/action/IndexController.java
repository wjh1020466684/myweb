package com.action;
import java.util.*;
import  com.service.*;
import  com.entity.*;

import com.util.CalculatorUtil;
import com.util.CaptchaUtil;
import com.util.VerifyCodeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class IndexController {
    @Value("${spring.datasource.url}")
     private String url;
    @Autowired
    private IDeptService ds;

    @Autowired
    private IEmpService es;

    @RequestMapping(value = "/index")
    public  String index(){
      System.out.println("-----------idnex");
        System.out.println("--url"+url);

        List<Dept> list=ds.selectAll();
        System.out.println("list"+list);
        return "index";
    }
  @RequestMapping(value = "/regist")
   @ResponseBody()
    public  void  zhu(ModelAndView mov, HttpSession session, String tel){

      /*String verifyCode= VerifyCodeUtil.generateVerifyCode(4);
      System.out.println(verifyCode);*/
      System.out.println(tel);
      String ss= CaptchaUtil.sendCaptcha(tel);
      session.setAttribute("ss",ss);
    //  return  CalculatorUtil.getJSONString(0,verifyCode) ;

  }

  @RequestMapping(value="testAction")
    public String test(HttpServletRequest request){
      String content=request.getParameter("editorValue");
      System.out.println("editorValue= /n"+content);
      request.setAttribute("content", content);

        return "success" ;
  }
    @RequestMapping(value = "/zhuce1")
    public  String zhu(ModelAndView mov ,HttpSession session,String tel,String code) {
        System.out.println("tel=" + tel);
        System.out.println("code=" + code);
        String as = (String) session.getAttribute("ss");
        System.out.println("as="+as);
        if (code.equals(as)) {
            return "success";
        } else {
            return "zhuce";
        }
    }
}

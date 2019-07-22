<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";

%>
<html>
<head>
    <title>注册</title>
    <script src="js/jquery-1.12.4.js"></script>
    <script type="text/javascript" charset="utf-8" src="//g.alicdn.com/sd/ncpc/nc.js?t=2015052012"></script>
    <script type="text/javascript">
        $(function(){
            aa();
        })
        function aa(){
            var nc_token = ["CF_APP_1", (new Date()).getTime(), Math.random()].join(':');
            var NC_Opt =
                {
                    renderTo: "#your-dom-id",
                    appkey: "CF_APP_1",
                    scene: "register",
                    token: nc_token,
                    customWidth: 300,
                    trans:{"key1":"code0"},
                    elementID: ["usernameID"],
                    is_Opt: 0,
                    language: "cn",
                    isEnabled: true,
                    timeout: 3000,
                    times:5,
                    apimap: {
                        // 'analyze': '//a.com/nocaptcha/analyze.jsonp',
                        // 'get_captcha': '//b.com/get_captcha/ver3',
                        // 'get_captcha': '//pin3.aliyun.com/get_captcha/ver3'
                        // 'get_img': '//c.com/get_img',
                        // 'checkcode': '//d.com/captcha/checkcode.jsonp',
                        // 'umid_Url': '//e.com/security/umscript/3.2.1/um.js',
                        // 'uab_Url': '//aeu.alicdn.com/js/uac/909.js',
                        // 'umid_serUrl': 'https://g.com/service/um.json'
                    },
                    callback: function (data) {
                        window.console && console.log(nc_token)
                        window.console && console.log(data.csessionid)
                        window.console && console.log(data.sig)
                        var tel=$("[name='tel']").val().trim();
                        alert(tel);
                        $.ajax({
                            type:"post",
                            url:"regist",
                            data:{'tel':tel},
                            dataType:"json",
                            success:function(data){
                                if(0== data.result){
                                    console.log(data.msg);
                                    alert("短信已发送成功")
                                } else if (1 == data.code) {
                                    alert(data.msg);
                                } else {
                                    alert("系统出现未知异常");
                                }
                            }
                            /* error:function(){
                                 alert("验证码发送失败！");
                             }*/
                        });
                    }
                }
            var nc = new noCaptcha(NC_Opt)
            nc.upLang('cn', {
                _startTEXT: "请按住滑块，拖动到最右边",
                _yesTEXT: "验证通过",
                _error300: "哎呀，出错了，点击<a href=\"javascript:__nc.reset()\">刷新</a>再来一次",
                _errorNetwork: "网络不给力，请<a href=\"javascript:__nc.reset()\">点击刷新</a>",
            })
        }
    </script>
</head>
<h1>账号注册</h1>
<form action="zhuce1" method="post">
    <p>手机号：<input type="text" name="tel"/>&nbsp; </p>
    <p>验证码：<input type="text" name="code"/>
    <div id="your-dom-id" class="nc-container mycode" style="display: inline-block; margin-left: 10px;"></div> <!--No-Captcha渲染的位置，其中 class 中必须包含 nc-container-->
    </p>
    <p><input type="submit" name="注册" /></p>
</form>
</body>
</html>

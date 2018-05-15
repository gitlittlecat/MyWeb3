package com.ye.user.servlet;

import com.ye.user.domain.User;
import com.ye.user.service.UserService;
import com.ye.user.utiles.UserUUID;
import org.apache.commons.beanutils.BeanUtils;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

public class RegisterServlet extends javax.servlet.http.HttpServlet {
    public void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        //解决编码问题
        response.setContentType("text/html;charset=utf-8");
        request.setCharacterEncoding("utf-8");
        //接收参数封装实体
        Map<String, String[]> map = request.getParameterMap();
        User user = new User();
        try {
            BeanUtils.populate(user, map);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        //暂时设置uid为00b
        user.setUid(UserUUID.getUUID());
        //调用service层处理业务
        UserService service = new UserService();
        try {
            service.register(user);
            response.getWriter().write("注册成功");
        } catch (Exception e) {
            e.printStackTrace();
            if (e.getMessage().contains("Duplicate entry")&&e.getMessage().contains("for key 'username'"))
            {
                response.getWriter().write("用户名重复");
                return;
            }
            response.getWriter().write("注册失败，请联系管理员");
        }

    }

    public void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        doPost(request, response);
    }
}

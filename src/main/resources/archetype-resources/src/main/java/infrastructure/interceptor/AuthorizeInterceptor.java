package ${package}.infrastructure.interceptor;

import com.alibaba.fastjson.JSONObject;
import com.kaochong.teaching.common.UserHolder;
import com.kaochong.teaching.common.constants.CommonConstants;
import com.kaochong.teaching.common.dto.UserDTO;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class AuthorizeInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String userStr = request.getHeader(CommonConstants.userHeader);
        if(StringUtils.isNotBlank(userStr)){
            byte[] userDecode = Base64.decodeBase64(userStr);
            if(!ArrayUtils.isEmpty(userDecode)){
                //解析用户信息
                UserDTO user = JSONObject.parseObject(new String(userDecode), UserDTO.class);
                UserHolder.setUser(user);
            }
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        UserHolder.removeUser();
    }

}

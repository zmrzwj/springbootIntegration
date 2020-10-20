package com.sccddw.test.aspect;

import com.baomidou.mybatisplus.core.conditions.interfaces.Join;

import org.apache.commons.lang3.ArrayUtils;
import org.apache.ibatis.javassist.*;
import org.apache.ibatis.javassist.bytecode.CodeAttribute;
import org.apache.ibatis.javassist.bytecode.LocalVariableAttribute;
import org.apache.ibatis.javassist.bytecode.MethodInfo;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 * description
 *
 * @author dell
 * date 2020/10/20 20:50
 * @version 1.0
 **/
@Aspect
@Component
public class AopTestAspect {

    /**
     *自定义日志
     */
    private Logger logger = LoggerFactory.getLogger(AopTestAspect.class);

    /**
     * 使用javassist来获取方法参数名称
     * @param class_name    类名
     * @param method_name   方法名
     * @return
     * @throws Exception
     */
    private String[] getFieldsName(String class_name, String method_name) throws Exception {
        Class<?> clazz = Class.forName(class_name);
        String clazz_name = clazz.getName();

        ClassPool pool = ClassPool.getDefault();
        ClassClassPath classClassPath = new ClassClassPath(clazz);
        pool.insertClassPath(classClassPath);

        CtClass ctClass = pool.getCtClass(class_name);
        CtMethod ctMethod = ctClass.getDeclaredMethod(method_name);
        MethodInfo methodInfo = ctMethod.getMethodInfo();
        CodeAttribute codeAttribute = methodInfo.getCodeAttribute();
        LocalVariableAttribute attr = (LocalVariableAttribute) codeAttribute.getAttribute(LocalVariableAttribute.tag);
        if(attr == null){
            return null;
        }
        String[] paramsArgsName = new String[ctMethod.getParameterTypes().length];
        int pos = Modifier.isStatic(ctMethod.getModifiers()) ? 0 : 1;
        for (int i=0;i<paramsArgsName.length;i++){
            paramsArgsName[i] = attr.variableName(i + pos);
        }
        return paramsArgsName;
    }

    /**
     * 判断是否为基本类型：包括String
     * @param clazz clazz
     * @return  true：是;     false：不是
     */
    private boolean isPrimite(Class<?> clazz){
        if (clazz.isPrimitive() || clazz == String.class){
            return true;
        }else {
            return false;
        }
    }


    /**
     * 打印方法参数值  基本类型直接打印，非基本类型需要重写toString方法
     * @param paramsArgsName    方法参数名数组
     * @param paramsArgsValue   方法参数值数组
     */
    private void logParam(String[] paramsArgsName,Object[] paramsArgsValue){
        if(ArrayUtils.isEmpty(paramsArgsName) || ArrayUtils.isEmpty(paramsArgsValue)){
            logger.info("该方法没有参数");
            return;
        }
        StringBuffer buffer = new StringBuffer();
        for (int i=0;i<paramsArgsName.length;i++){
            //参数名
            String name = paramsArgsName[i];
            //参数值
            Object value = paramsArgsValue[i];
            buffer.append(name +" = ");
            if(isPrimite(value.getClass())){
                buffer.append(value + "  ,");
            }else {
                buffer.append(value.toString() + "  ,");
            }
        }
        logger.info("开始打印方法：");
        logger.info(buffer.toString());
    }



    @Before("execution(public * com.sccddw.test.service.impl.AopTestImpl.*(..))")
    public void before(JoinPoint joinPoint) {
        String class_name = joinPoint.getTarget().getClass().getName();
        String method_name = joinPoint.getSignature().getName();

        /**
         * 获取方法的参数值数组。
         */
        Object[] method_args = joinPoint.getArgs();

        try {
            /**
             * 获取方法参数名称
             */
            String[] paramNames = getFieldsName(class_name, method_name);

            /**
             * 打印方法的参数名和参数值
             */
            logParam(paramNames,method_args);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

package com.myj.shopping.exception;

import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

/**
 * 自定义注解@EnableExceptionHandler
 */
@Retention(value = RetentionPolicy.RUNTIME) //指定注解在程序运行期间可以通过反射机制获取和使用。
@Target(value = {ElementType.TYPE}) //指定注解可以应用于类型，例如类、接口、枚举等。
@Documented //表示该注解会被包含在生成的 JavaDoc 文档中，以便开发者在查看文档时能够了解这个注解的用途和相关信息。
@Import({ExceptionHandlerAdvice.class}) //用于在配置类中，将指定的类导入到 Spring 容器中，以便进行相关的配置和处理。
public @interface EnableExceptionHandler {
    //在运行时，Spring 框架可以根据这个注解以及引入的 `ExceptionHandlerAdvice` 类来处理可能出现的异常情况。
}


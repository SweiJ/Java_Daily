package com.xxxx.seckill.validator;

import com.xxxx.seckill.vo.IsMobileValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

/**
 * Created with IntelliJ IDEA.
 * Description: 校验手机号注解
 * User: SweiPC
 * Date: 2022-06-15
 * Time: 11:25
 */
@Target({ElementType.METHOD, ElementType.FIELD, ElementType.ANNOTATION_TYPE, ElementType.CONSTRUCTOR, ElementType.PARAMETER, ElementType.TYPE_USE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(
        validatedBy = {IsMobileValidator.class}
)
public @interface IsMobile {

    boolean requird() default true;

    String message() default "{手机号码格式错误}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}

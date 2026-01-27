package com.reis.ecommerce.common.aop.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

@Target({java.lang.annotation.ElementType.METHOD}) // Sadece method seviyesinde kullanılabilir
@Retention(java.lang.annotation.RetentionPolicy.RUNTIME) // Çalışma zamanında erişilebilir - AOP yakalayabilir Runtime anında
@Documented
public @interface TrackPerformance
{

}

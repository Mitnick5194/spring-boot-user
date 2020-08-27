package org.spring.framework;

import com.ajie.chilli.utils.common.StringUtils;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.AnnotationBeanNameGenerator;

/**
 * beanname生成策略，使用权限命名，防止不同包相同类名扫描注入失败（springboot扫描包注入默认使用类名）
 */
public class UniqueNameGenerator extends AnnotationBeanNameGenerator {
    @Override
    public String generateBeanName(BeanDefinition definition, BeanDefinitionRegistry registry) {
        String name = definition.getBeanClassName();
        if(StringUtils.isEmpty(name)){
            return super.generateBeanName(definition,registry);
        }
        return name;
    }
}

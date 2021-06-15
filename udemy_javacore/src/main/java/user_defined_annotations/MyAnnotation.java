package user_defined_annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

/*
    Target annotation is used for define where the annotation MyAnnotation is called. Here it is called at Method level and local variable,
    if we call at Class level then it will have error
 */
@Target({ElementType.METHOD, ElementType.LOCAL_VARIABLE})
public @interface MyAnnotation {
    /*
        whenever this annotation is called, it require to have value of id as a long
        default means not required
    */
    long id() ;
    String name() default "My annotation";
}

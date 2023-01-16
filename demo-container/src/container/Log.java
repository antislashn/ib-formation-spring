package container;

import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;
import java.util.logging.Level;

import com.sun.java.accessibility.util.TopLevelWindowListener;

@Retention(RUNTIME)
@Target(METHOD)
public @interface Log {
	String level() default "INFO";
}

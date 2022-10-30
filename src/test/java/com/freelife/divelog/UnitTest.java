package com.freelife.divelog;

import org.junit.jupiter.api.Tag;

import java.lang.annotation.*;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Tag("unit")
public @interface UnitTest {

}

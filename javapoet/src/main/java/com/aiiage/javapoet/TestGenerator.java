package com.aiiage.javapoet;

import com.squareup.javapoet.JavaFile;
import com.squareup.javapoet.MethodSpec;
import com.squareup.javapoet.TypeSpec;

import javax.lang.model.element.Modifier;

//测试JavaPoet的类，和项目无关
public class TestGenerator {

    //可以生成

    /**
     * package com.aiiage.javapoet;
     *
     *   import java.lang.String;
     *   import java.lang.System;
     *
     *   public final class HelloWorld {
     *       public static void main(String[] args) {
     *           System.out.println("Hello, JavaPoet!");
     *       }
     *   }
     * @param args
     */
    public static void main(String[] args) {
        generating();
    }

    public static void generating() {
        MethodSpec main = MethodSpec.methodBuilder("main")
                .addModifiers(Modifier.PUBLIC, Modifier.STATIC)
                .returns(void.class)
                .addParameter(String[].class, "args")
                .addStatement("$T.out.println($S)", System.class, "Hello, JavaPoet!")
                .build();

        TypeSpec helloWorld = TypeSpec.classBuilder("HelloWorld")
                .addModifiers(Modifier.PUBLIC, Modifier.FINAL)
                .addMethod(main)
                .build();

        JavaFile javaFile = JavaFile.builder("com.aiiage.javapoet", helloWorld)
                .build();
        try {
            javaFile.writeTo(System.out);
        } catch (Exception e) {

        }

    }
}

package com.aiiage.javapoet;

import com.aiiage.libannotation.MyRouteAnnotation;
import com.google.auto.service.AutoService;
import com.squareup.javapoet.JavaFile;
import com.squareup.javapoet.MethodSpec;
import com.squareup.javapoet.TypeSpec;

import java.io.IOException;
import java.util.Collections;
import java.util.Set;

import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.Filer;
import javax.annotation.processing.ProcessingEnvironment;
import javax.annotation.processing.Processor;
import javax.annotation.processing.RoundEnvironment;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.Element;
import javax.lang.model.element.Modifier;
import javax.lang.model.element.TypeElement;

/**
 * Created By HuangQing on 2018/7/20 15:38
 **/
@AutoService(Processor.class)
public class MyrouterProcessor extends AbstractProcessor {
    private Filer filer;

    @Override
    public synchronized void init(ProcessingEnvironment processingEnv) {
        super.init(processingEnv);
        filer = processingEnv.getFiler(); // 获得filer对象，用来创建文件
    }

    @Override
    public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment roundEnv) {
        System.out.println("myrouterprocessor process");
        Set<? extends Element> elements = roundEnv.getElementsAnnotatedWith(MyRouteAnnotation.class);
        for (Element element : elements) {//遍历扫描到的注解集合
            MyRouteAnnotation yyRouteAnnotation = element.getAnnotation(MyRouteAnnotation.class);
            if (yyRouteAnnotation != null) {
                // 当前注解是我们自定义的注解，也就是MyRouteAnnotation时，执行下列代码
                TypeSpec myrouter = TypeSpec.classBuilder("Myrouter")//声明类名为Myrouter
                        .addModifiers(Modifier.PUBLIC, Modifier.FINAL)//声明类的修饰符为 public final
                        .addMethod(getMethodSpec("doHello", "xxx"))//为Myrouter类添加名为doHello的方法，返回值为xxx
                        .build();

                try {
                    // 建立 com.aiiage.testjavapoet.Myrouter.java 对象
                    JavaFile javaFile = JavaFile.builder("com.aiiage.testjavapoet", myrouter)
                            .addFileComment(" This codes are generated automatically. Do not modify!")
                            .build();
                    // 写入文件
                    javaFile.writeTo(filer);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return true;
    }


    /**
     * @param methodStr 方法名
     * @param returnStr 返回值
     * @return
     */
    private static MethodSpec getMethodSpec(String methodStr, String returnStr) {
        return MethodSpec.methodBuilder(methodStr)
                .addModifiers(Modifier.PUBLIC, Modifier.STATIC)//指定方法修饰符为 public static
                .returns(String.class) //指定返回值为String类型
                .addStatement("return $S", returnStr) //拼接返回值语句
                .build();
    }

    @Override
    public Set<String> getSupportedAnnotationTypes() {
        return Collections.singleton(MyRouteAnnotation.class.getCanonicalName());
    }

    @Override
    public SourceVersion getSupportedSourceVersion() {
        return SourceVersion.latestSupported();
    }
}

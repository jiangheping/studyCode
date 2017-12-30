package design.proxy.cglibDynamicProxy;

import design.proxy.staticProxy.JavaCoder;
import sun.misc.ProxyGenerator;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Created by admin on 2017/9/10.
 */
public class CodeUtil {
    public static void main(String[] args) throws IOException {
        byte[] classFile = ProxyGenerator.generateProxyClass("TestProxyGen", JavaCoder.class.getInterfaces());
        File file = new File("D:/aaa/TestProxyGen.class");
        FileOutputStream fos = new FileOutputStream(file);
        fos.write(classFile);
        fos.flush();
        fos.close();
    }
}

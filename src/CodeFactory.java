import LeetCode.LeetCode;
import NowCoder.NowCoder;

import java.lang.reflect.Constructor;
import java.util.HashMap;
import java.util.Map;
import java.util.StringJoiner;

public class CodeFactory {
    private String packageName;
    private String secondPackage;
    private String no;

    private static final Map<String, Class<?>> PACKAGE_MAP = new HashMap<>();

    static {
        // 动态加载不同的类到映射表中，便于扩展
        PACKAGE_MAP.put("LeetCode", LeetCode.class);
        PACKAGE_MAP.put("NowCoder", NowCoder.class);
    }

    public void execute() throws Exception {
        StringJoiner stringJoiner = new StringJoiner(".");
        stringJoiner.add(packageName);
        stringJoiner.add(secondPackage);
        stringJoiner.add(packageName + no);
        String className = stringJoiner.toString();

        // 查找包名对应的类
        Class<?> clazz = PACKAGE_MAP.get(packageName);

        if (clazz != null) {
            Object instance = getClassInstance(className, clazz);
            invokeExecuteMethod(instance);
        } else {
            throw new IllegalArgumentException("Unsupported package: " + packageName);
        }
    }

    private <T> T getClassInstance(String className, Class<T> clazz) throws Exception {
        Class<?> classObj = Class.forName(className);
        Constructor<?> constructor = classObj.getDeclaredConstructor();
        return clazz.cast(constructor.newInstance());
    }

    private void invokeExecuteMethod(Object instance) throws Exception {
        // 使用反射调用 execute 方法
        instance.getClass().getMethod("execute").invoke(instance);
    }

    public void setPackageName(String packageName) {
        this.packageName = packageName;
    }

    public void setSecondPackage(String secondPackage) {
        this.secondPackage = secondPackage;
    }

    public void setNo(String no) {
        this.no = no;
    }
}

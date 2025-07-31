public class CodeExecute {
    public static void main(String[] args) {
        try {
            //executeByPackage("LeetCode");
            executeByPackage("NowCoder");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static void executeByPackage(String packageName) throws Exception {
        CodeFactory codeFactory = new CodeFactory();
        switch (packageName){
            case "LeetCode":
                codeFactory.setPackageName("LeetCode");
                codeFactory.setSecondPackage("Array");
                codeFactory.setNo("2683");
                codeFactory.execute();
            case "NowCoder":
                codeFactory.setPackageName("NowCoder");
                codeFactory.setSecondPackage("Array");
                codeFactory.setNo("HJ1");
                codeFactory.execute();
        }
    }
}

package com.jitsain.gethash.utils.print;


import java.util.Arrays;

/**
 * 在控制台按照传入格式输出
 *
 * @author zhong
 * @date 2023-02-03 10:48
 */
public class ColorPrint {

    /**
     * 分号
     */
    private static final String SEMICOLON = ";";

    /**
     * 默认黑色打印
     *
     * @param txt 信息
     */
    public static void outPrintln(String txt) {
        System.out.println(format(txt, PrintCode.BLACK));
    }

    /**
     * 换行打印
     *
     * @param txt   信息
     * @param codes 格式化参数
     */
    public static void outPrintln(String txt, PrintCode... codes) {
        System.out.println(format(txt, codes));
    }

    /**
     * 不换行打印
     *
     * @param txt   打印内容
     * @param codes 格式化参数
     */
    public static void outPrint(String txt, PrintCode... codes) {
        System.out.print(format(txt, codes));
    }

    /**
     * 默认红色打印
     *
     * @param txt 信息
     */
    public static void errorPrintln(String txt) {
        System.err.println(format(txt, PrintCode.RED));
    }

    /**
     * 换行打印
     *
     * @param txt   信息
     * @param codes 格式化参数
     */
    public static void errorPrintln(String txt, PrintCode... codes) {
        System.err.println(format(txt, codes));
    }

    /**
     * 不换行打印
     *
     * @param txt   打印内容
     * @param codes 格式化参数
     */
    public static void errorPrint(String txt, PrintCode... codes) {
        System.err.print(format(txt, codes));
    }

    /**
     * 格式化信息
     *
     * @param txt   信息
     * @param codes 参数集合
     * @return 格式化后的信息
     */
    private static String format(String txt, PrintCode... codes) {
        String codeStr = String.join(SEMICOLON, Arrays.stream(codes).map((printCode) -> String.valueOf(printCode.getCode())).toArray(String[]::new));
        return (char) 27 + "[" + codeStr + "m" + txt + (char) 27 + "[0m";
    }

    /**
     * 打印样例
     */
    public static void printExample() {
        ColorPrint.outPrintln("样例提示：黑色字体和黑色背景是一个取反色,和整体控制台主题背景有关,主题背景如果为深色,则相应的字体和背景变为白色,反之黑色",
                PrintCode.BOLD, PrintCode.UNDERLINE);
        ColorPrint.outPrintln("");
        ColorPrint.outPrintln("灰色(ColorPrint.PrintCode.GREY)", PrintCode.GREY);
        ColorPrint.outPrintln("黑色(ColorPrint.PrintCode.BLACK)", PrintCode.BLACK);
        ColorPrint.outPrintln("红色(ColorPrint.PrintCode.RED)", PrintCode.RED);
        ColorPrint.outPrintln("绿色(ColorPrint.PrintCode.GREEN)", PrintCode.GREEN);
        ColorPrint.outPrintln("黄色(ColorPrint.PrintCode.YELLOW)", PrintCode.YELLOW);
        ColorPrint.outPrintln("蓝色(ColorPrint.PrintCode.BLUE)", PrintCode.BLUE);
        ColorPrint.outPrintln("品红(ColorPrint.PrintCode.MAGENTA)", PrintCode.MAGENTA);
        ColorPrint.outPrintln("蓝绿(ColorPrint.PrintCode.CYAN)", PrintCode.CYAN);
        ColorPrint.outPrintln("黑色背景(ColorPrint.PrintCode.BLACK_BACKGROUND)",
                PrintCode.GREY, PrintCode.BLACK_BACKGROUND);
        ColorPrint.outPrintln("红色背景(ColorPrint.PrintCode.RED_BACKGROUND)",
                PrintCode.BLACK, PrintCode.RED_BACKGROUND);
        ColorPrint.outPrintln("绿色背景(ColorPrint.PrintCode.GREEN_BACKGROUND)",
                PrintCode.BLACK, PrintCode.GREEN_BACKGROUND);
        ColorPrint.outPrintln("黄色背景(ColorPrint.PrintCode.YELLOW_BACKGROUND)",
                PrintCode.BLACK, PrintCode.YELLOW_BACKGROUND);
        ColorPrint.outPrintln("蓝色背景(ColorPrint.PrintCode.BLUE_BACKGROUND)",
                PrintCode.BLACK, PrintCode.BLUE_BACKGROUND);
        ColorPrint.outPrintln("品红背景(ColorPrint.PrintCode.MAGENTA_BACKGROUND)",
                PrintCode.BLACK, PrintCode.MAGENTA_BACKGROUND);
        ColorPrint.outPrintln("蓝绿背景(ColorPrint.PrintCode.CYAN_BACKGROUND)",
                PrintCode.BLACK, PrintCode.CYAN_BACKGROUND);
        ColorPrint.outPrintln("灰色背景(ColorPrint.PrintCode.GREY_BACKGROUND)",
                PrintCode.BLACK, PrintCode.GREY_BACKGROUND);
        ColorPrint.outPrintln("默认字体(不传入其它参数)");
        ColorPrint.outPrintln("加粗(ColorPrint.PrintCode.BOLD)", PrintCode.BOLD);
        ColorPrint.outPrintln("斜体(ColorPrint.PrintCode.ITALIC)", PrintCode.ITALIC);
        ColorPrint.outPrintln("下划线(ColorPrint.PrintCode.UNDERLINE)", PrintCode.UNDERLINE);
        ColorPrint.outPrintln(
                "示例:灰底/黑字/加粗/下划线/倾斜(ColorPrint.PrintCode.GREY_BACKGROUND," +
                        "ColorPrint.PrintCode.BLACK,ColorPrint.PrintCode.BOLD," +
                        "ColorPrint.PrintCode.UNDERLINE,ColorPrint.PrintCode.ITALIC)",
                PrintCode.GREY_BACKGROUND, PrintCode.BLACK,
                PrintCode.BOLD, PrintCode.UNDERLINE, PrintCode.ITALIC);
    }
}


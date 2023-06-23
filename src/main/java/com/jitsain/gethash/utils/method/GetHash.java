package com.jitsain.gethash.utils.method;

import com.jitsain.gethash.utils.print.ColorPrint;
import com.jitsain.gethash.utils.print.PrintCode;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static com.jitsain.gethash.utils.hash.file.FileHash.*;
import static com.jitsain.gethash.utils.hash.string.StringHash.*;

/**
 * @author zhong
 * @date 2023-02-18 10:45
 */
public class GetHash {

    public static void getHash(String[] args) {
        List<String> arr = new ArrayList<>(Arrays.asList(args));
        if (arr.size() == 3) {
            String method = arr.get(2);
            if (arr.get(0).equals("-s")) {
                String str = arr.get(1);
                Pattern pattern = Pattern.compile("^'(.*)'$");
                Matcher matcher = pattern.matcher(str);
                if (matcher.find()) {
                    str = matcher.group(1);
                }
                switch (method.toLowerCase()) {
                    case "sha1" -> ColorPrint.outPrintln("Succeeded: " + getStringSHA1(str), PrintCode.GREEN);
                    case "sha256" -> ColorPrint.outPrintln("Succeeded: " + getStringSHA256(str), PrintCode.GREEN);
                    case "sha512" -> ColorPrint.outPrintln("Succeeded: " + getStringSHA512(str), PrintCode.GREEN);
                    case "md5" -> ColorPrint.outPrintln("Succeeded: " + getStringMD5(str), PrintCode.GREEN);
                    default ->
                            ColorPrint.outPrintln("Parameter Error: unknown hash algorithm " + "\"" + method + "\"", PrintCode.RED);
                }
            } else if (arr.get(0).equals("-f")) {
                File file = new File(arr.get(1));
                if (file.exists()) {
                    switch (method.toLowerCase()) {
                        case "sha1" -> ColorPrint.outPrintln("Succeeded: " + getFileSHA1(file), PrintCode.GREEN);
                        case "sha256" -> ColorPrint.outPrintln("Succeeded: " + getFileSHA256(file), PrintCode.GREEN);
                        case "sha512" -> ColorPrint.outPrintln("Succeeded: " + getFileSHA512(file), PrintCode.GREEN);
                        case "md5" -> ColorPrint.outPrintln("Succeeded: " + getFileMD5(file), PrintCode.GREEN);
                        default ->
                                ColorPrint.outPrintln("Parameter Error: unknown hash algorithm " + "\"" + method + "\"", PrintCode.RED);
                    }
                } else {
                    ColorPrint.outPrintln("File Error: file does not exist " + "\"" + file.getAbsolutePath() + "\"", PrintCode.RED);
                }
            } else {
                ColorPrint.outPrintln("Parameter Error: unknown parameter " + "\"" + arr.get(0) + "\"", PrintCode.RED);
            }
        } else {
            ColorPrint.outPrintln("Parameter Error: unknown requests parameter", PrintCode.RED);
            return;
        }
    }
}

package common.util;

import java.util.Arrays;
import java.util.List;

/**
 * @author guotx
 * @create 2018-06-21 10:56
 * @desc 文件处理工具
 **/
public class FileUtil {
    // private static Logger logger = LoggerFactory.getLogger(FileUtil.class);

    /**
     * 常用图片格式
     */
    private static String[] imgExts = {"bmp", "jpg", "png", "jpeg", "gif"};
    private static List<String> imgExtList;

    static {
        imgExtList = Arrays.asList(imgExts);
    }

    /**
     * 根据文件扩展名判断是否为图片文件
     *
     * @param fileExt
     * @return 是图片返回true，否则返回false
     */
    public static boolean isImg(String fileExt) {
        if (fileExt == null) {
            return false;
        }
        return imgExtList.contains(fileExt.toLowerCase());
    }

    public static void main(String[] args) {
        String ext1 = "png";
        String ext2 = "doc";
        String ext3 = "GIF";
//        logger.info("isImg info | ext1 : {}", isImg(ext1));
//        logger.info("isImg info | ext2 : {}", isImg(ext2));
//        logger.info("isImg info | ext3 : {}", isImg(ext3));
    }
}

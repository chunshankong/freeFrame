package freeframe.speech;

import com.baidu.aip.speech.AipSpeech;
import com.baidu.aip.speech.TtsResponse;
import com.baidu.aip.util.Util;
import org.json.JSONObject;

import javax.sound.sampled.AudioFileFormat;
import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import java.io.File;
import java.io.IOException;

/**
 * 百度语音工具类
 */
public class SpeechUtil {


    public static final String APP_ID = "15716422";

    public static final String API_KEY = "8F6k6An9CIx974YvRYQXtXep";

    public static final String SECRET_KEY = "yBYaahfD8Xz3kxa852FMG0XNK83ivUUj";

    private static AipSpeech client;

    public static final int RATE = 8000;

    public static final String FORMAT = "pcm";

    public static void main(String[] args) throws IOException {
//        SpeechSynthesizer("简单测试百度语音合成", "d:/SpeechSynthesizer.mp3");
        SpeechRecognition("d:/AudioFile/1552227142702.wav",FORMAT,RATE);

//        SpeechRecognitionForBytes();
    }


    /**
     * 单例 懒加载模式 返回实例
     * @return
     */
    public static AipSpeech getInstance(){
        if (client==null){
            synchronized (AipSpeech.class){
                if (client==null) {
                    client = new AipSpeech(APP_ID, API_KEY, SECRET_KEY);
                }
            }
        }
        return client;
    }

    /**
     * 语音合成
     * @param word 文字内容
     * @param outputPath 合成语音生成路径
     * @return
     */
    public static boolean SpeechSynthesizer(String word, String outputPath) {
        /*
        最长的长度
         */
        int maxLength = 1024;
        if (word.getBytes().length >= maxLength) {
            return false;
        }
        // 初始化一个AipSpeech
        client = getInstance();

        // 可选：设置网络连接参数
        client.setConnectionTimeoutInMillis(2000);
        client.setSocketTimeoutInMillis(60000);

        // 可选：设置代理服务器地址, http和socket二选一，或者均不设置
//        client.setHttpProxy("proxy_host", proxy_port);  // 设置http代理
//        client.setSocketProxy("proxy_host", proxy_port);  // 设置socket代理

        // 调用接口
        TtsResponse res = client.synthesis(word, "zh", 1, null);
        byte[] data = res.getData();
        org.json.JSONObject res1 = res.getResult();
        if (data != null) {
            try {
                Util.writeBytesToFileSystem(data, outputPath);
            } catch (IOException e) {
                e.printStackTrace();
            }
            return true;
        }
        if (res1 != null) {
            System.out.println(" result : " + res1.toString());
        }
        return false;

    }

    /**
     * 语音识别
     * @param videoPath
     * @param videoType
     * @return
     */
    public static String SpeechRecognition(String videoPath, String videoType,int rate) {
        // 初始化一个AipSpeech
        client = getInstance();

        // 可选：设置网络连接参数
        client.setConnectionTimeoutInMillis(2000);
        client.setSocketTimeoutInMillis(60000);

        // 可选：设置代理服务器地址, http和socket二选一，或者均不设置
//        client.setHttpProxy("proxy_host", proxy_port);  // 设置http代理
//        client.setSocketProxy("proxy_host", proxy_port);  // 设置socket代理


        // 调用接口
        JSONObject res = client.asr(videoPath, videoType, rate, null);
        System.out.println(" SpeechRecognition : " + res.toString());
        return res.get("result").toString();
    }

    /**
     * 语音识别
     * @param data
     * @param videoType
     * @return
     */
    public static String SpeechRecognitionForBytes(byte[] data, String videoType,int rate) {
        // 初始化一个AipSpeech
        client = getInstance();

        // 可选：设置网络连接参数
        client.setConnectionTimeoutInMillis(2000);
        client.setSocketTimeoutInMillis(60000);

        // 对语音二进制数据进行识别
        JSONObject asrRes2 = client.asr(data, videoType, rate, null);
        System.out.println(asrRes2);


        return asrRes2.get("result").toString()
                ;
    }



}


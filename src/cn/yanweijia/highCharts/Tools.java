package cn.yanweijia.highCharts;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Tools {
	/**
	 * 获取当前日期时间
	 * @return
	 */
	public static String getFormatDatetime(){
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String dateTime = simpleDateFormat.format(new Date());
		return dateTime;
	}
	/**
	 * 获取当前日期
	 * @return
	 */
	public static String getFormatDate(){
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
		String date = simpleDateFormat.format(new Date());
		return date;
	}
	/**
	 * 记录日志
	 * @param str
	 */
	public static void log(String str){
		str = "[" + getFormatDatetime() + "]:" + str;
		System.out.println(str);
		FileWriter fw = null;
		try{
			fw = new FileWriter("I:/Task.log",true);	//用追加方式打开文件
			fw.write(str + "\r\n");
			fw.close();
		}catch(Exception e){
			System.out.println("调试日志文件写入失败!");
		}
		
	}
	
	/**
	 * 写到文本文件
	 * @param str 文件内容 
	 */
	public static void writeToTextFile(String str){
		FileWriter fw = null;
		
		try {
			fw = new FileWriter("I:/webpage.html",false);
			fw.write(str);
			fw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	/**
	 * 写到文本文件
	 * @param str 文件内容 
	 */
	public static void writeToTextFile(String filePath,String str){
		FileWriter fw = null;
		
		try {
			fw = new FileWriter(filePath,false);
			fw.write(str);
			fw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	/**
	 * 执行命令,不会阻塞进程/线程
	 */
	public static boolean execCMD(String cmd){
		try {
			Runtime.getRuntime().exec("cmd /c " + cmd);
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	/**
	 * 执行命令,完成后再返回,阻塞进程/线程
	 */
	public static boolean execCMDuntilFinished(String cmd){
		BufferedReader br = null; 
		try {
			Process p = Runtime.getRuntime().exec("cmd /c " + cmd);
			br = new BufferedReader(new InputStreamReader(p.getInputStream()));  
            String line = null;  
            StringBuilder sb = new StringBuilder();  
            while ((line = br.readLine()) != null) {  
                sb.append(line + "\n");  
            }  
            System.out.println(sb.toString());
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}finally{
			if (br != null)  
            {  
                try {  
                    br.close();  
                } catch (Exception e) {  
                    e.printStackTrace();  
                }  
            }  
		}
		return true;
	}
}

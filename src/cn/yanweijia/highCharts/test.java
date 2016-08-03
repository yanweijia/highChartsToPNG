package cn.yanweijia.highCharts;

import cn.yanweijia.highCharts.JSONInfo;

/**
 * 
 * @author 严唯嘉
 * @func 测试自动生成highCharts并打开对应图片
 */
public class test {
	/**
	 * 测试
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		//获取程序运行根目录
		String relativelyPath=System.getProperty("user.dir"); 
		relativelyPath += "\\highCharts\\";
		getAreaChart(relativelyPath);	//生成面积图并打开
		
		//getPieChart(relativelyPath);	//生成饼图并打开
		
		//getBarChart(relativelyPath);	//生成条形统计图并打开

	}
	
	/**
	 * 测试面积统计图 
	 * @param path highcharts目录路径
	 */
	public static void getAreaChart(String path){
		String mainTitle = "主标题";
		String verticalTitle = "奖金";
		String groupName = "月份";
		String[] names = {"一月","二月","三月","四月","五月","六月"};
		double[] datas = {1.1,10.20,15.45,45.85,11.23,6.25};
		Tools.writeToTextFile(path + "test.json", JSONInfo.getAreaChartJSON(mainTitle, verticalTitle,groupName, names,datas));
		Tools.execCMDuntilFinished(path + "phantomjs " + path + "highcharts-convert.js -infile " + path + "test.json -outfile " + path + "chartTest.png -width 1000 -constr Chart -resources " + path + "highcharts.js," + path + "jquery.js");
		Tools.execCMD("start " + path + "chartTest.png");
	}
	
	/**
	 * 测试获取饼图统计图
	 */
	public static void getPieChart(String path){
		String mainTitle = "主标题";
		String subTitle = "副标题";
		String[] names = {"一月","二月","三月","四月","五月","六月"};
		double[] datas = {1.1,10.20,15.45,45.85,11.23,6.25};
		Tools.writeToTextFile(path + "test.json", JSONInfo.getPieChartJSON(mainTitle, subTitle, names,datas));
		Tools.execCMDuntilFinished(path + "phantomjs " + path + "highcharts-convert.js -infile " + path + "test.json -outfile " + path + "chartTest.png -width 1000 -constr Chart -resources " + path + "highcharts.js," + path + "jquery.js");
		Tools.execCMD("start " + path + "chartTest.png");
	}
	/**
	 * 测试获取条形统计图
	 */
	public static void getBarChart(String path){
		String mainTitle = "主标题";
		String subTitle = "副标题";
		String horizontalTitle = "水平坐标轴标题";
		String verticalTitle = "纵坐标轴标题";
		String groupName = "水果";
		String[] axesNames = {"一月","二月","三月","四月","五月","六月"};
		double[] data = {1.1,10.20,15.45,45.85,11.23,6.25};
		Tools.writeToTextFile(path + "test.json", JSONInfo.getBarChartJSON(mainTitle, subTitle, horizontalTitle, verticalTitle, axesNames, groupName, data));
		Tools.execCMDuntilFinished(path + "phantomjs " + path + "highcharts-convert.js -infile " + path + "test.json -outfile " + path + "chartTest.png -width 1000 -constr Chart -resources " + path + "highcharts.js," + path + "jquery.js");
		Tools.execCMD("start " + path + "chartTest.png");
	}
}

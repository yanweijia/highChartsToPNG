package cn.yanweijia.highCharts;

/**
 * <strong>如对json数据格式有问题请看项目根目录下面的highCharts文件夹里面的README文件</strong>
 * @author 严唯嘉
 * @func 自动生成highCharts统计图表使用的json数据
 */
public class JSONInfo {
	
	/**图表主标题*/
	public static final String TITLE_MAIN = "#title";
	/**图表副标题*/
	public static final String TITLE_SUB = "#subTitle";
	/**水平坐标标题*/
	public static final String TITLE_HORIZONTAL = "#horizontalTitle";
	/**垂直坐标标题*/
	public static final String TITLE_VERTICAL = "#verticalTitle";
	/**数据坐标轴列名,用逗号','分隔开,如 '列名1','列名2','列名3' */
	public static final String NAME_AXES = "#axesNames";
	/**数据组标题*/
	public static final String NAME_GROUPNAME = "#groupName";
	/**数据,用逗号','分隔开 如 123,124,125*/
	public static final String DATA = "#data";
	
	
	
	/**条形统计图*/
	public static final String CHART_BAR = "{chart: {type: 'bar'},title: {text: 'title'},subtitle: {text: '#subTitle'},xAxis: {categories: [#axesNames],title: {text: '#verticalTitle'}},yAxis: {min: 0,title: {text: '#horizontalTitle',align: 'high'},labels: {overflow: 'justify'}},tooltip: {valueSuffix: ' millions'},plotOptions: {bar: {dataLabels: {enabled: true}}},legend: {layout: 'vertical',align: 'right',verticalAlign: 'top',x: -40,y: 80,floating: true,borderWidth: 1,backgroundColor: ((Highcharts.theme && Highcharts.theme.legendBackgroundColor) || '#FFFFFF'),shadow: true},credits: {enabled: false},series: [{name: '#groupName',data: [#data]}]}";
	/**饼图*/
	public static final String CHART_PIE = "{chart: {plotBackgroundColor: null,plotBorderWidth: null,plotShadow: false,type: 'pie'},title: {text: '#title'},subtitle: {text: '#subTitle'},tooltip: {pointFormat: '{series.name}: <b>{point.percentage:.2f}%</b>'},plotOptions: {pie: {allowPointSelect: true,cursor: 'pointer',dataLabels: {enabled: true,format: '<b>{point.name}</b>: {point.percentage:.2f} %',style: {color: (Highcharts.theme && Highcharts.theme.contrastTextColor) || 'black'}}}},series: [{name: 'Brands',colorByPoint: true,data: [#data]}]}";
	/**面积统计图*/
	public static final String CHART_AREA = "{chart: {type: 'areaspline'},title: {text: '#title'},legend: {layout: 'vertical',align: 'left',verticalAlign: 'top',x: 150,y: 100,floating: true,borderWidth: 1,backgroundColor: (Highcharts.theme && Highcharts.theme.legendBackgroundColor) || '#FFFFFF'},xAxis: {categories: [#axesNames]},yAxis: {title: {text: '#verticalTitle'}},tooltip: {shared: true,valueSuffix: ' units'},credits: {enabled: false},plotOptions: {areaspline: {fillOpacity: 0.5}},series: [{name: '#groupTitle',data: [#data]}]}";
	
	
	/**
	 * 获取面积图的JSON表示.其中非数组项可以为null,默认为空白字符串.
	 * @param mainTitle 图表标题
	 * @param verticalTitle 图表垂直坐标标题
	 * @param groupTitle 数据名称
	 * @param names 每个点对应的名称 '列1','列2','列3','列4','列5'
	 * @param datas 每个点对应的值 如 ,1,2,3,4,5 
	 * @return
	 */
	public static String getAreaChartJSON(
								String mainTitle,
								String verticalTitle,
								String groupTitle,
								String[] names,
								double[] datas){
		String nameStr = "", dataStr = "";
		if(mainTitle == null)
			mainTitle = "";
		if(verticalTitle == null)
			verticalTitle = "";
		if(groupTitle == null)
			groupTitle = "";
		//将数组替换成目标格式
		int length = names.length<datas.length?names.length:datas.length;
		for(int i = 0 ; i < length - 1 ; i++){
			nameStr += "'" + names[i] + "',";
			dataStr += datas[i] + ",";
		}
		nameStr += "'" + names[length - 1] + "'";
		dataStr += datas[length - 1];
		
		String result = JSONInfo.CHART_AREA;
		result = result.replaceAll(JSONInfo.TITLE_MAIN, mainTitle);
		result = result.replaceAll(JSONInfo.TITLE_VERTICAL, verticalTitle);
		result = result.replaceAll(JSONInfo.NAME_GROUPNAME,groupTitle);
		result = result.replaceAll(JSONInfo.NAME_AXES,nameStr);
		result = result.replaceAll(JSONInfo.DATA, dataStr);
		
		return result;
	}
	
	/**
	 * 获取饼图的JSON表示,其中非数组参数mainTitle和subTitle可空
	 * @param mainTitle 主标题
	 * @param subTitle 副标题
	 * @param names 饼图的各个扇区名称
	 * @param datas 各个扇区数据
	 * @return json表示
	 */
	public static String getPieChartJSON(
								String mainTitle,
								String subTitle,
								String[] names,
								double[] datas){
		if(mainTitle == null)
			mainTitle = "";
		if(subTitle == null)
			subTitle = "";
		//生成数据域
		String dataStr = "";
		int length = names.length<datas.length?names.length:datas.length;
		for(int i = 0 ; i < length - 1 ; i++){
			dataStr += "{name:'" + names[i] + "',y:" + datas[i] + "},";
		}
		dataStr += "{name:'" + names[length - 1] + "',y:" + datas[length - 1] + "}";
		String result = JSONInfo.CHART_PIE;
		
		//开始用真实数据替换
		result = result.replaceAll(JSONInfo.TITLE_MAIN, mainTitle);
		result = result.replaceAll(JSONInfo.TITLE_SUB, subTitle);
		result = result.replaceAll(JSONInfo.DATA, dataStr);
		
		return result;
	}
	
	
	/**
	 * 获取条形统计图(横放的柱状)的JSON表示,其中,非数组的参数可空
	 * @param mainTitle 图表标题
	 * @param subTitle 图表副标题
	 * @param horizontalTitle 图表水平(横坐标)标题
	 * @param verticalTitle 图表垂直(纵坐标)标题
	 * @param axesNames 数据坐标轴列名数组,如 列名1,列名2...
	 * @param groupName 该系列类型 如 水果统计图就写 水果
	 * @param data <strong>double</strong>放数据的数组
	 * @return json数据
	 */
	public static String getBarChartJSON(
							String mainTitle,
							String subTitle,
							String horizontalTitle,
							String verticalTitle,
							String[] axesNames,
							String groupName,
							double[] data){
		String result = JSONInfo.CHART_BAR;
		if(mainTitle == null)
			mainTitle = "";
		if(subTitle == null)
			subTitle = "";
		if(horizontalTitle == null)
			horizontalTitle="";
		if(verticalTitle ==null)
			verticalTitle = "";
		if(groupName == null)
			groupName = "";
		//将传递进来的数组转换为目标格式,逗号分隔
		String axesNamesStr = "" , dataStr = "";
		int length = axesNames.length<data.length?axesNames.length:data.length;
		for(int i = 0 ; i < length - 1 ; i++){
			axesNamesStr += "'" + axesNames[i] + "'" + ",";
			dataStr += data[i] + ",";
		}
		axesNamesStr += "'" + axesNames[length - 1] + "'";
		dataStr += data[length - 1];

		//替换数据
		result = result.replaceAll(JSONInfo.TITLE_MAIN, mainTitle);
		result = result.replaceAll(JSONInfo.TITLE_SUB, subTitle);
		result = result.replaceAll(JSONInfo.TITLE_HORIZONTAL, horizontalTitle);
		result = result.replaceAll(JSONInfo.TITLE_VERTICAL, verticalTitle);
		result = result.replaceAll(JSONInfo.NAME_AXES, axesNamesStr);
		result = result.replaceAll(JSONInfo.NAME_GROUPNAME, groupName);
		result = result.replaceAll(JSONInfo.DATA, dataStr);
		
		return result;
	}
	
}
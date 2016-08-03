# highChartsToPNG
将highCharts图表转换为图片/ A program to convert highCharts to picture(PNG/JPG/PDF) 

Any queations ,please contact me (admin##yanweijia.cn)(replace ## with@)
如有疑问请联系上述邮箱.

如何将highcharts图表本地用命令导出图片
http://bbs.hcharts.cn/forum.php?mod=viewthread&tid=989

本文件夹已配置好,直接用cmd切换当前目录并执行以下命令即可
具体命令格式:
***`phantomjs  highcharts-convert.js -infile value.json -outfile chart1.png -width 1000 -constr Chart -resources highcharts.js,jquery.js`***

#####其中
highcharts-convert.js  指的是导出服务器文件
-infile value.json     为图表配置文件，可以是 .json 文件，也可以是 svg 文件
-outfile charts1.png     输出文件，后缀必须为.jpg, .png .pdf 或者 .svg.
-scale                          缩放比例，例如 图表宽度为 600px ，设置缩放为 2的情况下，输出的文件宽度为 1200px
-width                          输出文件宽度，设置该属性将会覆盖 scale 的值
-constr                        图表类型，可以是：Chart、StockChart、Map
-callback                     图表回调函数，设置该函数将会在图表构造完毕后执行



###重要:
请勿更改highcharts-convert.js文件
已经在官网文件的基础上将682行更改为fileList = params.resources.split('\,');
具体更改原因请参考
http://stackoverflow.com/questions/38294099/highcharts-and-phantomjs-error-cant-find-variable-highcharts


json格式如下(仅将对应json数据复制进value.json即可,如果还需其他数据,可以直接在官网上面找http://www.highcharts.com/demo):


**柱状统计图(横向) 三组数据的例子**
`{
	chart: {
		type: 'bar'
	},
	title: {
		text: '主标题'
	},
	subtitle: {
		text: '副标题'
	},
	xAxis: {
		categories: ['列名1', '列名2', '列名3', '列名4', '列名5'],
		title: {
		text: '纵坐标轴标题'
		}
	},
	yAxis: {
		min: 0,
		title: {
			text: '横坐标轴标题',
			align: 'high'
		},
		labels: {
		overflow: 'justify'
		}
	},
	tooltip: {
		valueSuffix: ' millions'
	},
	plotOptions: {
		bar: {
		dataLabels: {
			enabled: true
		}
		}
	},
	legend: {
		layout: 'vertical',
		align: 'right',
		verticalAlign: 'top',
		x: -40,
		y: 80,
		floating: true,
		borderWidth: 1,
		backgroundColor: ((Highcharts.theme && Highcharts.theme.legendBackgroundColor) || '#FFFFFF'),
		shadow: true
	},
	credits: {
		enabled: false
	},
	series: [{
		name: '组数据1名称',
		data: [107, 31, 635, 203, 2]
	}, {
		name: '组数据2名称',
		data: [133, 156, 947, 408, 6]
	}, {
		name: '组数据3名称',
		data: [1052, 954, 4250, 740, 38]
	}]
}`
![chart1](https:/github.com/yanweijia/highChartsToPNG/READMEFILE/chart1.png)
**饼图,带百分比**
`{
	chart: {
		plotBackgroundColor: null,
		plotBorderWidth: null,
		plotShadow: false,
		type: 'pie'
	},
	title: {
		text: '主标题'
	},
	tooltip: {
		pointFormat: '{series.name}: <b>{point.percentage:.2f}%</b>'
	},
	plotOptions: {
		pie: {
		allowPointSelect: true,
		cursor: 'pointer',
		dataLabels: {
			enabled: true,
			format: '<b>{point.name}</b>: {point.percentage:.2f} %',
			style: {
			color: (Highcharts.theme && Highcharts.theme.contrastTextColor) || 'black'
			}
		}
		}
	},
	series: [{
		name: 'Brands',
		colorByPoint: true,
		data: [{
		name: '数据1',
		y: 56.33
		}, {
		name: '数据2',
		y: 24.03,
		sliced: true,
		selected: true
		}, {
		name: '数据3',
		y: 10.38
		}, {
		name: '数据4',
		y: 4.77
		}, {
		name: '数据5',
		y: 0.91
		}, {
		name: '数据6',
		y: 0.2
		}]
	}]
}`
![chart2](https:/github.com/yanweijia/highChartsToPNG/READMEFILE/chart2.png)
**面积图**
`{
	chart: {
		type: 'areaspline'
	},
	title: {
		text: '标题'
	},
	legend: {
		layout: 'vertical',
		align: 'left',
		verticalAlign: 'top',
		x: 150,
		y: 100,
		floating: true,
		borderWidth: 1,
		backgroundColor: (Highcharts.theme && Highcharts.theme.legendBackgroundColor) || '#FFFFFF'
	},
	xAxis: {
		categories: [
		'横坐标数据1',
		'横坐标数据2',
		'横坐标数据3',
		'横坐标数据4',
		'横坐标数据5',
		'横坐标数据6',
		'横坐标数据7'
		]
	},
	yAxis: {
		title: {
		text: '纵坐标轴标题'
		}
	},
	tooltip: {
		shared: true,
		valueSuffix: ' units'
	},
	credits: {
		enabled: false
	},
	plotOptions: {
		areaspline: {
		fillOpacity: 0.5
		}
	},
	series: [{
		name: '曲线标题',
		data: [3, 4, 3, 5, 4, 10, 12]
	}]
}`
![chart3](https:/github.com/yanweijia/highChartsToPNG/READMEFILE/chart3.png)
My Blog
[风旋碧浪@严唯嘉 博客]( http://www.yanweijia.cn/2016/08/03/highchartstopng/)
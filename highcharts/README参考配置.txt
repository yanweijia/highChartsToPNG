��ν�highchartsͼ�����������ͼƬ
http://bbs.hcharts.cn/forum.php?mod=viewthread&tid=989

���ļ��������ú�,ֱ����cmd�л���ǰĿ¼��ִ�����������
���������ʽ:
phantomjs  highcharts-convert.js -infile value.json -outfile chart1.png -width 1000 -constr Chart -resources highcharts.js,jquery.js

����
highcharts-convert.js  ָ���ǵ����������ļ�
-infile value.json     Ϊͼ�������ļ��������� .json �ļ���Ҳ������ svg �ļ�
-outfile charts1.png     ����ļ�����׺����Ϊ.jpg, .png .pdf ���� .svg.
-scale                          ���ű��������� ͼ����Ϊ 600px ����������Ϊ 2������£�������ļ����Ϊ 1200px
-width                          ����ļ���ȣ����ø����Խ��Ḳ�� scale ��ֵ
-constr                        ͼ�����ͣ������ǣ�Chart��StockChart��Map
-callback                     ͼ��ص����������øú���������ͼ������Ϻ�ִ��



��Ҫ:
�������highcharts-convert.js�ļ�
�Ѿ��ڹ����ļ��Ļ����Ͻ�682�и���ΪfileList = params.resources.split('\,');
�������ԭ����ο�
http://stackoverflow.com/questions/38294099/highcharts-and-phantomjs-error-cant-find-variable-highcharts


json��ʽ����(������Ӧjson���ݸ��ƽ�value.json����,���������������,����ֱ���ڹ���������http://www.highcharts.com/demo):


��״ͳ��ͼ(����) �������ݵ�����
{
	chart: {
		type: 'bar'
	},
	title: {
		text: '������'
	},
	subtitle: {
		text: '������'
	},
	xAxis: {
		categories: ['����1', '����2', '����3', '����4', '����5'],
		title: {
		text: '�����������'
		}
	},
	yAxis: {
		min: 0,
		title: {
			text: '�����������',
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
		name: '������1����',
		data: [107, 31, 635, 203, 2]
	}, {
		name: '������2����',
		data: [133, 156, 947, 408, 6]
	}, {
		name: '������3����',
		data: [1052, 954, 4250, 740, 38]
	}]
}

��ͼ,���ٷֱ�
{
	chart: {
		plotBackgroundColor: null,
		plotBorderWidth: null,
		plotShadow: false,
		type: 'pie'
	},
	title: {
		text: '������'
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
		name: '����1',
		y: 56.33
		}, {
		name: '����2',
		y: 24.03,
		sliced: true,
		selected: true
		}, {
		name: '����3',
		y: 10.38
		}, {
		name: '����4',
		y: 4.77
		}, {
		name: '����5',
		y: 0.91
		}, {
		name: '����6',
		y: 0.2
		}]
	}]
}
���ͼ
{
	chart: {
		type: 'areaspline'
	},
	title: {
		text: '����'
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
		'����������1',
		'����������2',
		'����������3',
		'����������4',
		'����������5',
		'����������6',
		'����������7'
		]
	},
	yAxis: {
		title: {
		text: '�����������'
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
		name: '���߱���',
		data: [3, 4, 3, 5, 4, 10, 12]
	}]
}
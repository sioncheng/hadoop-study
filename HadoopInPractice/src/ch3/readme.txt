cd $HADOOP_HOME
bin/hadoop fs -put $HadoopInPractice_HOME/data/customers.txt input
bin/hadoop fs -put $HadoopInPractice_HOME/data/orders.txt input
mkdir jobs
cd jobs
jar cvf HadoopInPractice.jar -C $HadoopInPractice_HOME/bin .
cd ..
bin/hadoop fs -rmr output
bin/hadoop ./jobs/HadoopInPractice.jar ch1.Driver input output
bin/hadoop fs -cat output/part-r-00000

#after that , you will get
	1,SMITH,iphone4
	1,SMITH,thinkpad x1
	10,TAYLOR,apple magic mouse
	10,TAYLOR,imac
	11,ANDERSON,samsung 9300
	11,ANDERSON,sennheiser hd598
	12,THOMAS,nokia lumia 900
	13,JACKSON,thinkpad x230
	14,WHITE,samsung 830 ssd 256g
	15,HARRIS,kingston 1333 4G * 2
	16,MARTIN,powersync ukm-922
	17,THOMPSON,westdata 2TB
	17,THOMPSON,crucial CT128M4SSD2
	18,GARCIA,it-ceo 2.5inch diskdriver box
	19,MARTINEZ,kingston 1600 8g*2
	2,JOHNSON,macbook pro mc723
	2,JOHNSON,iphone 4s
	20,ROBINSON,intel 520 128g ssd
	21,CLARK,crucial 60g ssd
	22,RODRIGUEZ,crucial CT256M4SSD2
	23,LEWIS,samsung i9300
	24,LEE,nikon d5100
	25,WALKER,canon r236
	26,HALL,dell new xps 14
	27,ALLEN,cisco cvr100
	28,YOUNG,macbook pro md322
	29,HERNANDEZ,philips za830
	3,WILLIAMS,htc 8x
	3,WILLIAMS,ipad 3
	30,KING,hp 23-1019
	4,JONES,samsung galax I
	5,BROWN,nexus tab 7
	6,DAVIS,sumsang 830 ssd
	7,MILLER,ipod class 3
	8,WILSON,mac mini
	9,MOORE,mac pro
	9,MOORE,TPLink TL-920
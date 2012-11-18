cd $HADOOP_HOME
bin/hadoop fs -put $HadoopInPractice_HOME/data/numbers.txt input
mkdir jobs
cd jobs
jar cvf HadoopInPractice.jar -C $HadoopInPractice_HOME/bin .
cd ..
bin/hadoop fs -rmr output
bin/hadoop ./jobs/HadoopInPractice.jar ch2.SimpleSecondSortDriver input/numbers.txt output
bin/hadoop fs -cat output/part-r-00000


#after those steps ,you will get (numbers.txt is from http://p-x1984.iteye.com/blog/800269)

1	2
3	4
5	6
7	82
7	82
12	211
20	21
20	21
20	21
20	21
31	42
40	511
50	54
50	54
50	54
50	54
50	54
50	54
50	54
50	54
53	54
60	52
60	52
60	52
60	52
60	52
60	52
60	52
60	52
63	61
70	55
70	55
70	55
70	55
70	55
70	55
71	55
71	55
73	54
73	54
74	58
74	58
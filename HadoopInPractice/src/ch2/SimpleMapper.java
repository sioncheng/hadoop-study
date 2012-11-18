package ch2;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;
import java.lang.InterruptedException;
import java.util.StringTokenizer;

public class SimpleMapper extends Mapper<LongWritable,Text,IntWritable,IntWritable>{

	@Override
	public void map(LongWritable key,Text value,Context context) 
			throws IOException,InterruptedException{
		
		StringTokenizer st = new StringTokenizer(value.toString());
		
		int na = Integer.parseInt(st.nextToken());
		int nb = Integer.parseInt(st.nextToken());
		
		IntWritable ina = new IntWritable(na);
		IntWritable inb = new IntWritable(nb);
		
		context.write(ina, inb);
	}
}

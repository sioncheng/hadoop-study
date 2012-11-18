package ch2;

import org.apache.hadoop.mapreduce.Partitioner;
import org.apache.hadoop.io.IntWritable;

public class SimplePartitioner extends Partitioner<IntWritable,IntWritable>{

	@Override 
	public int getPartition(IntWritable key,IntWritable value, int numPartitions){
		//assume input key's arrange is 0-100
		int capacity = 100 / numPartitions;
		
		return key.get() / capacity;
	}
}

package ch2;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.mapreduce.Reducer;

import java.lang.Iterable;
import java.io.IOException;
import java.lang.InterruptedException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SimpleReducer extends Reducer<IntWritable,IntWritable,IntWritable,IntWritable>{

	@Override
	public void reduce(IntWritable key,Iterable<IntWritable> values,Context context)
		throws IOException,InterruptedException{
		
		List<IntWritable> valuesList = new ArrayList<IntWritable>();
		
		for(IntWritable i : values){
			valuesList.add(i);
		}
		
		Collections.sort(valuesList);
		for(IntWritable i : valuesList){
			context.write(key, i);
		}
	}
}

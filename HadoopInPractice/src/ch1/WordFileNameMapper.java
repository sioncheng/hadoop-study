package ch1;

import org.apache.hadoop.mapreduce.Mapper;
//import org.apache.hadoop.mapreduce.Mapper.Context; 
import org.apache.hadoop.io.Text;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.mapreduce.lib.input.FileSplit;

import java.io.IOException;
import java.lang.InterruptedException;



public class WordFileNameMapper 
	extends Mapper<LongWritable,Text,Text,Text> {

	private Text documentId ;
	
	@Override
	public void setup(Context context){
		FileSplit split = (FileSplit)context.getInputSplit();
		String filename = split.getPath().getName();
		documentId = new Text(filename);
	}
	
	@Override
	public void map(LongWritable key,Text value,Context context)
		throws IOException,InterruptedException{
		
		
		context.write(value, documentId);
	}
}

package ch1;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.lib.input.TextInputFormat;
import org.apache.hadoop.mapreduce.lib.output.TextOutputFormat;

import java.io.IOException;
import java.lang.ClassNotFoundException;
import java.lang.InterruptedException;


public class Driver {

	/**
	 * @param args
	 */
	public static void main(String[] args) 
			throws IOException,ClassNotFoundException,InterruptedException{
		// TODO Auto-generated method stub

		Configuration conf = new Configuration();
		
		Job job = Job.getInstance(conf);
		
		job.setJobName("wordFileNameJob") ;
		job.setJarByClass(Driver.class);
		
		job.setMapperClass(WordFileNameMapper.class);
		job.setReducerClass(WordFileNameReducer.class);
		
		job.setMapOutputKeyClass(Text.class);
		job.setMapOutputValueClass(Text.class);
		
		job.setInputFormatClass(TextInputFormat.class);
		job.setOutputFormatClass(TextOutputFormat.class);
		
		TextInputFormat.setInputPaths(job, new Path(args[0]));
		TextOutputFormat.setOutputPath(job,new Path(args[1]));
		
		int code = job.waitForCompletion(true) ? 0 : 1;
		
		System.exit(code);
	}

}

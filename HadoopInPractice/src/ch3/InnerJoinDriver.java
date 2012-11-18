package ch3;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.mapreduce.lib.input.TextInputFormat;
import org.apache.hadoop.mapreduce.lib.output.TextOutputFormat;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.fs.Path;

public class InnerJoinDriver  {
	
	public static void main(String[] args) throws Exception{
		
		Configuration conf = new Configuration();
		Job job = Job.getInstance(conf);
		
		job.setJobName("innerjoin");
		job.setJarByClass(InnerJoinDriver.class);		
		
		job.setMapperClass(JoinMapper.class);
		job.setReducerClass(InnerJoinReducer.class);
		
		job.setMapOutputKeyClass(Text.class);
		job.setMapOutputValueClass(TagedTextValue.class);
		
		job.setInputFormatClass(TextInputFormat.class);
		job.setOutputFormatClass(TextOutputFormat.class);
		
		TextInputFormat.setInputPaths(job, new Path(args[0]));
		TextOutputFormat.setOutputPath(job,new Path(args[1]));
		
		int code = job.waitForCompletion(true) ? 0 : 1;
		
		System.exit(code);
	}

}

package com.qtrj.modules.monitor.task;

import org.quartz.DisallowConcurrentExecution;

import com.qtrj.modules.monitor.entity.Task;

@DisallowConcurrentExecution  
public class TestTask extends Task{

	@Override
	public void run() {
		System.out.println("这是测试任务TestTask。");
		
	}

}

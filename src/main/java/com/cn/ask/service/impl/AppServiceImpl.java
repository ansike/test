package com.cn.ask.service.impl;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cn.ask.dao.AppMapper;
import com.cn.ask.model.App;
import com.cn.ask.model.AppExample;
import com.cn.ask.service.AppService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Service
public class AppServiceImpl implements AppService {

	@Autowired
	AppMapper appMapper;

	@Override
	public PageInfo<App> findApp(Integer start, Integer size, String appName) {
		String name = appName == null ? appName = "" : appName;
		PageHelper.startPage(start, size);
		AppExample example = new AppExample();
		example.createCriteria().andAppNameLike("%" + name + "%");
		example.clear();
		return new PageInfo<App>(appMapper.selectByExample(example));
	}

	@Override
	public void insertApp(App app) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteApp(App apps) {
		// TODO Auto-generated method stub

	}

	@Override
	public void updateApp(App app) {
		// TODO Auto-generated method stub

	}

	public static void main(String[] args) {
        int a[] = new int[]{8,1,4,6,2,3,5,7,9};  
        quickSort(a,0,a.length -1);  
        System.out.println(Arrays.toString(a));  

	}

    private static int partition(int data[],int low,int high){//分治  
        int key = data[low];  
        while(low<high){  
            while(low<high && data[high]>key)//从右向左  
                high--;  
                data[low] = data[high];  
                  
            while(low<high && data[low]<key)//从左向右  
                low++;  
                data[high] = data[low];  
        }  
        data[low] = key;//把轴元素放在轴所在地位置  
        return low;//返回轴所在的位置  
    }  
      
    private static void quickSort(int data[],int low,int high){//递归  
        int q;  
        if(low<high){  
             q = partition(data,low,high);  
             quickSort(data,q+1,high);  
             quickSort(data,low,q-1);  
    }  
    }  
}

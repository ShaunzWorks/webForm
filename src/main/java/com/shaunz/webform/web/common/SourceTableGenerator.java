package com.shaunz.webform.web.common;

import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.shaunz.webform.web.source.dao.SourceMapper;
import com.shaunz.webform.web.source.entity.Source;

@Service
public class SourceTableGenerator {
	private Logger logger = Logger.getLogger(SourceTableGenerator.class);
	
	@Resource
	private SourceMapper sourceMapper;
	private static HashMap<String, HashMap<String,Source>> sourceTables;
	
	private List<Source> retrieveWholeSourceTable(){
		return sourceMapper.quaryAll();
	}
	
	public SourceTableGenerator(){
		
	}
	
	public void init() {
		List<Source> sources = retrieveWholeSourceTable();
		Source source;
		
		if(sourceTables == null){
			sourceTables = new HashMap<String, HashMap<String,Source>>();
		}
		if(sources != null && sources.size() > 0){
			for (int i = 0; i < sources.size(); i++) {
				HashMap<String,Source> tmpLst;
				
				source = sources.get(i);
				if(sourceTables.containsKey(source.getGroupNm())){
					tmpLst = sourceTables.get(source.getGroupNm());
				} else {
					tmpLst = new HashMap<String,Source>();
					sourceTables.put(source.getGroupNm(), tmpLst);
				}
				tmpLst.put(source.getName(), source);
			}
		} else {
			logger.warn("System retrieved nothing from tb_source...");
		}
		logger.info("tb_source generation finished...");
	}
	
	public HashMap<String,Source> getSourceBy(String groupNm){
		return sourceTables.get(groupNm);
	}
	
	public String getSourceValueBy(String groupNm,String name){
		String value = "";
		HashMap<String,Source> sources = sourceTables.get(groupNm);
		Source source;
		if(sources != null && sources.size() > 0){
			source = sources.get(name);
			if(source != null){
				value = source.getValue();
			}
		}
		return value;
	}
	
	public String getHomePageParameterby(String name){
		return getSourceValueBy("homepage",name);
	}
}

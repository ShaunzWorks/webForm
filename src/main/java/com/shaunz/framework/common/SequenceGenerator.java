package com.shaunz.framework.common;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shaunz.framework.common.sequence.dao.SequenceMapper;

@Service
public class SequenceGenerator {
	private static String MNGMT_SQ_NM = "mngmt_sq";
	@Autowired
	private SequenceMapper sequenceMapper;
	
	public int getNextSequenceNo(String sequenceNm){
		return sequenceMapper.getNextSequenceNo(sequenceNm);
	}
	
	public int getNextMngmtSequenceNo(){
		return getNextSequenceNo(MNGMT_SQ_NM);
	}
}

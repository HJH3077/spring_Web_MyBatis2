package com.ict.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;

public class DAO {
	// DB접속 정보와 mapper.xml 의 위치 정보를 가지고 객체가 생성됨
	private SqlSessionTemplate sqlSessionTemplate ;

	public void setSqlSessionTemplate(SqlSessionTemplate sqlSessionTemplate) {
		this.sqlSessionTemplate = sqlSessionTemplate;
	} 

	// 메소드
	// 전체 리스트
	public List<VO> getList() {
		List<VO> list = null;
		list = sqlSessionTemplate.selectList("list");
		return list;
	}

	// 삽입
	public int getInsert(VO vo) {
		int result = 0;
		result = sqlSessionTemplate.insert("insert", vo);
		return result;
	}

	// 상세 보기
	public VO getSelectOne(String idx) {
		
		VO vo = null;
		vo = sqlSessionTemplate.selectOne("onelist", idx);
		return vo;
	}
	
	// 업데이트
	public int getUpdate(VO vo) {
		int result = 0;
		result = sqlSessionTemplate.update("update", vo);
		return result;
	}

	// 삭제
	public int getDelete(String idx) {
		int result = 0;
		result = sqlSessionTemplate.update("delete", idx);
		return result;
	}

}

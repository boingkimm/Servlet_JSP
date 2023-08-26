package com.dao;

import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;

import com.dto.BoardDTO;
import com.dto.PageDTO;

public class BoardDAO {

	//전체목록
	public PageDTO list(SqlSession session, int curPage) {
		
		//PageDTO에 4개의 데이터 저장
		/* 
		 	List<BoardDTO> list;
			int perPage = 3;
			int totalCount;
			int curPage;
		 */
		PageDTO pageDTO = new PageDTO();
		
		//시작위치 (0, 3, 6,..) = (현재페이지-1)*페이지당 보여줄 개수
		int offset = (curPage-1)*pageDTO.getPerPage();
		
		//한 페이지당 보여줄 개수 (3)
		int limit = pageDTO.getPerPage();  
		
		//list 저장
		//3개 레코드가 저장됨
		List<BoardDTO> list = 
				session.selectList("BoardMapper.list", 
									null, 
									new RowBounds(offset, limit));
		pageDTO.setList(list);

		//curPage 저장
		pageDTO.setCurPage(curPage);
		
		//totalCount 저장
		int totalCount = session.selectOne("BoardMapper.totalCount");
		pageDTO.setTotalCount(totalCount);
		
		return pageDTO;
	}
}

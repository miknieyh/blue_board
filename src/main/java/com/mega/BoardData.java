package com.mega;

import java.sql.Timestamp;
import java.util.ArrayList;

public class BoardData {
	private int idx;
	private int m_idx;
	private String title;
	private String content;
	private String writer;
	private Timestamp wdate;
	private boolean mine;
	private int c_idx;
	private String comments;
	private ArrayList<BoardData> cArr;
	private String file1;
	private String file2; 

	public ArrayList<BoardData> getcArr() {
		return cArr;
	}

	public void setcArr(ArrayList<BoardData> cArr) {
		this.cArr = cArr;
	}

	public BoardData(int c_idx, int idx,int m_idx, String writer, String comments ,boolean mine) {
		this.c_idx = c_idx;
		this.idx=idx;
		this.m_idx=m_idx;
		this.writer=writer;
		this.comments=comments;
		this.mine=mine;
	}

	public BoardData(int idx, int m_idx, String title, String writer, String content, Timestamp wdate, boolean mine) {
		this.idx = idx;
		this.m_idx = m_idx;
		this.title = title;
		this.writer = writer;
		this.content = content;
		this.wdate = wdate;
		this.mine = mine;

	}
	public BoardData(int idx, String title, String content) {
		this.idx = idx;
		this.title = title;
		this.content = content;
	}

	public BoardData(int idx, String title, String content,ArrayList<BoardData> cArr, String file1, String file2 ) {
		this.idx = idx;
		this.title = title;
		this.content = content;
		this.cArr = cArr;
		this.file1 = file1;
		this.file2 = file2; 
	}

	public int getC_idx() {
		return c_idx;
	}

	public void setC_idx(int c_idx) {
		this.c_idx = c_idx;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public boolean isMine() {
		return mine;
	}

	public void setMine(boolean mine) {
		this.mine = mine;
	}

	

	@Override
	public String toString() {
		return "BoardData [idx=" + idx + ", title=" + title + ", content=" + content + ", writer=" + writer + "]";
	}

	public int getIdx() {
		return idx;
	}

	public void setIdx(int idx) {
		this.idx = idx;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public Timestamp getWdate() {
		return wdate;
	}

	public void setWdate(Timestamp wdate) {
		this.wdate = wdate;
	}

	public int getM_idx() {
		return m_idx;
	}

	public void setM_idx(int m_idx) {
		this.m_idx = m_idx;
	}

	public String getFile2() {
		return file2;
	}

	public void setFile2(String file2) {
		this.file2 = file2;
	}

	public String getFile1() {
		return file1;
	}

	public void setFile1(String file1) {
		this.file1 = file1;
	}

}

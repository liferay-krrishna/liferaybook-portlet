package com.mpower.springcrud.portlet.dto;

import com.mpower.springcrud.model.Book;

import java.io.Serializable;

public class BookDetailDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8948825150464970583L;
	public Book bookDetailForm;
	
	public Book getBookDetailForm() {
		return bookDetailForm;
	}
	public void setBookDetailForm(Book bookDetailForm) {
		this.bookDetailForm = bookDetailForm;
	}
	
}

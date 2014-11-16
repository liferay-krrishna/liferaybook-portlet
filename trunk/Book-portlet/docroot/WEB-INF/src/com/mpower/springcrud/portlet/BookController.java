package com.mpower.springcrud.portlet;

import java.util.ArrayList;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.xml.namespace.QName;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.portlet.bind.annotation.ActionMapping;
import org.springframework.web.portlet.bind.annotation.RenderMapping;

import com.liferay.portal.kernel.dao.orm.Criterion;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.language.UnicodeLanguageUtil;
import com.liferay.portal.kernel.portlet.PortletClassLoaderUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.mpower.springcrud.model.Book;
import com.mpower.springcrud.portlet.dto.BookDetailDTO;
import com.mpower.springcrud.service.BookLocalServiceUtil;


@Controller(value="bookController")
@RequestMapping("VIEW")
@SessionAttributes("bookDetailDTO")
public class BookController {

	@RenderMapping
	public String defaultRenderJsp(RenderRequest renderRequest, RenderResponse renderResponse, Model model){
		 
		 List<Book> booksList =new ArrayList<Book>();
		 try {
			booksList=BookLocalServiceUtil.getBooks(0, BookLocalServiceUtil.getBooksCount());
		} catch (SystemException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		  
		 	model.addAttribute("bookTypeExt", "123");
		    model.addAttribute("bookExt", "123");
		    model.addAttribute("authorExt", "123");
		    
		    model.addAttribute("searchFields", null+"~"+null+"~"+"none");
		    
		model.addAttribute("bookList", booksList);
		System.out.println("default");
		
		
		 
		return Constants.searchPage;
	}
	
	@RenderMapping(params="javax.portlet.action=bookListRender")
	public String bookListRenderJsp(RenderRequest renderRequest, RenderResponse renderResponse, Model model){
		
		
		return Constants.searchPage;
	}
	@RenderMapping(params="javax.portlet.action=searchPage")
	public String bookListRendeJsp(RenderRequest renderRequest,  @ModelAttribute("bookDetailDTO") BookDetailDTO bookDetailDTO,RenderResponse renderResponse, Model model) throws SystemException{
		System.out.println("in render url");
		String bookName="";
		String author="";
		String bookType ="";
		String searchFileds=ParamUtil.getString(renderRequest, "searchFileds");
		System.out.println(" searchFileds------- "+searchFileds);
		List<Book> booksList =new ArrayList<Book>();
		/*String[] searchFiled=searchFileds.split("~");
		
		
		
		System.out.println("size "+searchFiled.length);
		for(String str:searchFiled){
			System.out.println(" -- "+str);
		}*/
		 bookName = ParamUtil.getString(renderRequest, "bookExt");
		 author = ParamUtil.getString(renderRequest, "authorExt");
		 bookType=ParamUtil.getString(renderRequest, "bookTypeExt");
		 System.out.println("beforee if values ");
		 System.out.println(bookName+" -- "+author+" -- "+bookType);
		if(bookName.equalsIgnoreCase("123")&&
				author.equalsIgnoreCase("123")&&
					bookType.equalsIgnoreCase("123")){
				System.out.println("in if");
			booksList=BookLocalServiceUtil.getBooks(0, BookLocalServiceUtil.getBooksCount());
		
		}
		else{		
			if(bookName.equals("123")){
				bookName="";
			}
			if(author.equals("123"))
			{
				author="";
			}if(bookType.equals("123")||bookType.equals("none")	){
				bookType="";
			}
				
			/* if( ParamUtil.getString(renderRequest, "bookType").equalsIgnoreCase("none") && 
						ParamUtil.getString(renderRequest, "bookType").equalsIgnoreCase("")){
					 bookType = ParamUtil.getString(renderRequest, "bookType");
					 System.out.println("in if of booktype");
					 
				}else{
					bookType="";
				}*/
			 System.out.println("in else \n beforee dyanmic query ");
			 System.out.println(bookName+" -- "+author+" -- "+bookType);
			DynamicQuery dynamicQuery=DynamicQueryFactoryUtil.forClass(Book.class, PortletClassLoaderUtil.getClassLoader());
			Criterion criterion = null;
			criterion = RestrictionsFactoryUtil.like("bookName",
					new StringBuilder("%").append(bookName).append("%").toString());					
			//	StringPool.PERCENT+bookName+StringPool.PERCENT);
			criterion = RestrictionsFactoryUtil.and(criterion, 
					RestrictionsFactoryUtil.like("author",new StringBuilder("%").append(author).append("%").toString()));
			criterion = RestrictionsFactoryUtil.and(criterion , RestrictionsFactoryUtil.like("bookType",new StringBuilder("%").append(bookType).append("%").toString()));
			 
			dynamicQuery.add(criterion);		
			/*dynamicQuery.add(PropertyFactoryUtil.forName("bookName").like(bookName));
			dynamicQuery.add(RestrictionsFactoryUtil.like("author", StringPool.per));
			dynamicQuery.add(RestrictionsFactoryUtil.like("bookName", "bookName"));*/
				booksList=BookLocalServiceUtil.dynamicQuery(dynamicQuery);
				System.out.println("size "+booksList.size());
				if(bookName.equalsIgnoreCase("")||bookName.length()==0){
					bookName="123";
				}
				if(author.equalsIgnoreCase("")||author.length()==0){
					author="123";
				}
				if(bookType.equalsIgnoreCase("none")||bookType.length()==0){
					bookType="123";
				}
		}
		
		System.out.println(bookName+" -- "+author+" -- "+bookType);
	
	 	model.addAttribute("bookTypeExt", bookType);
	    model.addAttribute("bookExt", bookName);
	    model.addAttribute("authorExt", author);
	    
		model.addAttribute("bookList", booksList);
		model.addAttribute("searchFields", searchFileds);
		
		return Constants.searchPage;
	}
	
	@ActionMapping(params ="javax.portlet.action=searchBooks")
	public void searchBooks(ActionRequest actionRequest, @ModelAttribute("bookDetailDTO") BookDetailDTO bookDetailDTO,
			BindingResult bindingResult,  ActionResponse actionResponse, Model model){
System.out.println("in action");
		String bookName="";
		String author="";
		String bookType ="";
		String searchFileds=ParamUtil.getString(actionRequest, "searchFileds");
		//System.out.println(" searchFileds------- "+searchFileds);
		List<Book> booksList =new ArrayList<Book>();
		/*String[] searchFiled=searchFileds.split("~");
		
		
		
		System.out.println("size "+searchFiled.length);
		for(String str:searchFiled){
			System.out.println(" -- "+str);
		}*/
		 bookName = ParamUtil.getString(actionRequest, "bookExt");
		 author = ParamUtil.getString(actionRequest, "authorExt");
		 bookType=ParamUtil.getString(actionRequest, "bookTypeExt");
		if(bookName.equalsIgnoreCase("123")&&
				author.equalsIgnoreCase("123")&&
					bookType.equalsIgnoreCase("123")){
					System.out.println("in if");
				try {
					booksList=BookLocalServiceUtil.getBooks(0, BookLocalServiceUtil.getBooksCount());
				} catch (SystemException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		
		}
		else{			
			
				bookName = ParamUtil.getString(actionRequest, "bookName").trim();
			 author = ParamUtil.getString(actionRequest, "author").trim();	
			 if( !ParamUtil.getString(actionRequest, "bookType").equalsIgnoreCase("none") && 
						!ParamUtil.getString(actionRequest, "bookType").equalsIgnoreCase("")){
					 bookType = ParamUtil.getString(actionRequest, "bookType");
					 System.out.println("in if of booktype");
					 
				}else{
					bookType="";
				}
			 System.out.println("in else \n beforee dyanmic query ");
			 System.out.println(bookName+" -- "+author+" -- "+bookType);
			DynamicQuery dynamicQuery=DynamicQueryFactoryUtil.forClass(Book.class, PortletClassLoaderUtil.getClassLoader());
			Criterion criterion = null;
			criterion = RestrictionsFactoryUtil.like("bookName",
					new StringBuilder("%").append(bookName).append("%").toString());					
			//	StringPool.PERCENT+bookName+StringPool.PERCENT);
			criterion = RestrictionsFactoryUtil.and(criterion, 
					RestrictionsFactoryUtil.like("author",new StringBuilder("%").append(author).append("%").toString()));
			criterion = RestrictionsFactoryUtil.and(criterion , RestrictionsFactoryUtil.like("bookType",new StringBuilder("%").append(bookType).append("%").toString()));
			 
			dynamicQuery.add(criterion);		
			/*dynamicQuery.add(PropertyFactoryUtil.forName("bookName").like(bookName));
			dynamicQuery.add(RestrictionsFactoryUtil.like("author", StringPool.per));
			dynamicQuery.add(RestrictionsFactoryUtil.like("bookName", "bookName"));*/
		try {
			if(bookName.equalsIgnoreCase("")||bookName.length()==0){
				bookName="123";
			}
			if(author.equalsIgnoreCase("")||author.length()==0){
				author="123";
			}
			if(bookType.equalsIgnoreCase("none")||bookType.length()==0){
				bookType="123";
			}
			
			booksList=BookLocalServiceUtil.dynamicQuery(dynamicQuery);System.out.println("size "+booksList.size());
			
		} catch (SystemException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
		
		
		
		System.out.println(bookName+" -- "+author+" -- "+bookType);
	
	 	model.addAttribute("bookTypeExt", bookType);
	    model.addAttribute("bookExt", bookName);
	    model.addAttribute("authorExt", author);
	    
		model.addAttribute("bookList", booksList);
		model.addAttribute("searchFields", searchFileds);
		actionResponse.setRenderParameter(ActionRequest.ACTION_NAME, "bookListRender");
		
	}
	@ActionMapping(params ="javax.portlet.action=editBookDetails")
	public void editBookDetails(ActionRequest actionRequest, @ModelAttribute("bookDetailDTO") BookDetailDTO bookDetailDTO,
			BindingResult bindingResult,  ActionResponse actionResponse, Model model){
	System.out.println("in edit list");
		long bookId=ParamUtil.getLong(actionRequest, "bookId");
		try {
			QName qName = new QName("http://liferay.com", "editEvent", "x");
			actionResponse.setEvent(qName, bookId);
		
		
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	@ActionMapping(params ="javax.portlet.action=somethingToDo")
	public void somethingToDo(ActionRequest actionRequest, @ModelAttribute("bookDetailDTO") BookDetailDTO bookDetailDTO,
			BindingResult bindingResult,  ActionResponse actionResponse, Model model){
	System.out.println("in somethingToDo");
		
		try {
			//UnicodeLanguageUtil n;
			System.out.println("  selected items "+ParamUtil.getString(actionRequest, "todoItems"));
			String[] rowIds = ParamUtil.getParameterValues(actionRequest, "rowIds");
			
			for(String str:rowIds){
				System.out.println("row ids \t"+str);
			}
		
		
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	@ActionMapping(params ="javax.portlet.action=deleteBookDetails")
	public void bookBookDetails(ActionRequest actionRequest, @ModelAttribute("bookDetailDTO") BookDetailDTO bookDetailDTO,
			BindingResult bindingResult,  ActionResponse actionResponse, Model model){
		
		long bookId=ParamUtil.getLong(actionRequest, "bookId");
		try {
			BookLocalServiceUtil.deleteBook(bookId);
			bookDetailDTO.setBookDetailForm(null);
			
		} catch (SystemException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (PortalException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
		
		
	@ModelAttribute(value="bookDetailDTO")
	public BookDetailDTO bookModelAttribute(){
		BookDetailDTO bookDetailDTO=new BookDetailDTO();
		return bookDetailDTO;
	}
	
	
	
	/*
	@RenderMapping(params="action=paginationOfSearchConatiner")
	public String paginationSearchConatinerp(RenderRequest renderRequest, RenderResponse renderResponse, Model model){
		
		 ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
		 String orderByCol = ParamUtil.getString(renderRequest, "orderByCol");
		 String orderByType = ParamUtil.getString(renderRequest, "orderByType");
		 String curValue = ParamUtil.getString(renderRequest, "curr");
		 SearchContainer<Book> searchContainer = null;
		 //Create Portlet URL and set required param for pagination
		 PortletURL portletURL = PortletURLFactoryUtil.create(portletRequest, PORTLET_ID, themeDisplay.getPlid(), PortletRequest.RENDER_PHASE);
		 searchContainer = new SearchContainer<Book>(renderRequest, null, null, CUR_CONTENT, DELTA, portletURL, null,StringPool.BLANK);
		 searchContainer.setEmptyResultsMessage(LanguageUtil.get(themeDisplay.getLocale(), "empty-result-message"));
		 searchContainer.setIteratorURL(portletURL);
		 searchContainer.setOrderByCol(orderByCol);
		 searchContainer.setOrderByType(orderByType);
		 searchContainer.setResults(getSortedList(int start, int end, themeDisplay.getCompanyId(), orderByType,  orderByCol));
		 searchContainer.setTotal(BookLocalServiceUtil.getBooksCount());
		
		return "book_search";
		
	}
	 public static List<Book> getSortedList(int start, int end, long companyId, String orderByType, String orderByColumn)
	 {
	 List<Book> myList = new ArrayList<Book>();
	 DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(Book.class);
	 dynamicQuery.add(PropertyFactoryUtil.forName("companyId").eq(companyId));
	 dynamicQuery.setLimit(start, end);
	 if (orderByType.equalsIgnoreCase("asc"))
	 {
	 dynamicQuery.addOrder(OrderFactoryUtil.asc(orderByColumn));
	 } else
	 {
	 dynamicQuery.addOrder(OrderFactoryUtil.desc(orderByColumn));
	 }
	  
	 try
	 {
		 
	 myList= BookLocalServiceUtil.dynamicQuery(dynamicQuery);
	 
	 } catch (SystemException e)
	 {
	 System.out.println("error in getting list");
	 }
	 return myList;
	 }*/
	
}

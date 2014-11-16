package com.mpower.springcrud.portlet;

import java.util.ArrayList;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.Event;
import javax.portlet.EventRequest;
import javax.portlet.EventResponse;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.portlet.bind.annotation.ActionMapping;
import org.springframework.web.portlet.bind.annotation.EventMapping;
import org.springframework.web.portlet.bind.annotation.RenderMapping;

import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.dao.orm.Criterion;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.portlet.PortletClassLoaderUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.mpower.springcrud.model.Book;
import com.mpower.springcrud.portlet.dto.BookDetailDTO;
import com.mpower.springcrud.service.BookLocalServiceUtil;


@Controller(value="bookDetailController")
@RequestMapping("VIEW")
@SessionAttributes("bookDetailDTO")
public class BookDetailController {

	@RenderMapping
	public String defaultRenderJsp(RenderRequest renderRequest, RenderResponse renderResponse){
		 
	//	System.out.println("default");
		
		return Constants.home;
	}
	@ActionMapping(params ="javax.portlet.action=saveBook")
	public void saveBookToDBAction(ActionRequest actionRequest, @ModelAttribute("bookDetailDTO") BookDetailDTO bookDetailDTO,
			BindingResult bindingResult,  ActionResponse actionResponse, Model model){
		
		
		String bookName = ParamUtil.getString(actionRequest, "bookName");
		String author = ParamUtil.getString(actionRequest, "author");
		double price = ParamUtil.getDouble(actionRequest, "price");
		String bookType = ParamUtil.getString(actionRequest, "bookType");
		long bookId= ParamUtil.getLong(actionRequest, "bookId");
		
	 
	try {
		
		 Book bookDetailForm=null;
		 if(bookId==0){
			 bookId = CounterLocalServiceUtil.increment();
		 bookDetailForm=BookLocalServiceUtil.createBook(bookId);
		 bookDetailForm.setBookName(bookName);
		 bookDetailForm.setBookType(bookType);
		 bookDetailForm.setPrice(price);
		 bookDetailForm.setAuthor(author);
		 BookLocalServiceUtil.addBook(bookDetailForm);
		 }
		 else{
		
			 bookDetailForm=bookDetailDTO.getBookDetailForm();
			 bookDetailForm.setBookName(bookName);
			 bookDetailForm.setBookType(bookType);
			 bookDetailForm.setPrice(price);
			 bookDetailForm.setAuthor(author);
			 BookLocalServiceUtil.updateBook(bookDetailForm);
		 }
		 bookDetailForm=null;
			bookDetailDTO.setBookDetailForm(null);
		
	} catch (SystemException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	}
	@EventMapping(value ="{http://liferay.com}editEvent")
	public void editBookDetails(EventRequest actionRequest, @ModelAttribute("bookDetailDTO") BookDetailDTO bookDetailDTO,
			BindingResult bindingResult,  EventResponse actionResponse, Model model){
	System.out.println("in edit detail");
		Event event = actionRequest.getEvent();
		long bookId=(long) event.getValue();
		try {
			Book bookDetailForm=BookLocalServiceUtil.fetchBook(bookId);
			model.addAttribute("save", "true");
			bookDetailDTO.setBookDetailForm(bookDetailForm);
		
		} catch (SystemException e) {
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
	@RenderMapping(params="javax.portlet.action=searchPage")
	public String bookListRendeJsp(RenderRequest renderRequest,  @ModelAttribute("bookDetailDTO") BookDetailDTO bookDetailDTO,RenderResponse renderResponse, Model model) throws SystemException{
		
		Enumeration paramNames = renderRequest.getParameterNames();
		Map<String,String> params= new HashMap<String,String>();
		    while(paramNames.hasMoreElements()) 
		{
		      String paramName = (String)paramNames.nextElement();
		      
		      String paramValue = renderRequest.getParameter(paramName);

		params.put(paramName,paramValue);
		}
		    Set<String> set=params.keySet();
		    Iterator iterator = set.iterator();
		    
		  
		    while (iterator.hasNext()) {
		    
		    String key = (String) iterator.next();
		     
		 
		     String value = (String)params.get(key);
		     
		    System.out.println("Key: "+ key+", Value: "+ value);
		     
		     }
		
		
		System.out.println("@RenderMapping(params=action=searchPage "+ParamUtil.getBoolean(renderRequest, "searchDone"));
		
		String searchFileds=ParamUtil.getString(renderRequest, "searchFileds");
		System.out.println(" searchFileds------- "+searchFileds);
		List<Book> booksList =new ArrayList<Book>();
		String[] searchFiled=searchFileds.split("~");
		System.out.println("size "+searchFiled.length);
		for(String str:searchFiled){
			System.out.println(" -- "+str);
		}
		if((searchFiled[0].length()==0||searchFiled[0].equals(null))&&(searchFiled[1].length()==0||searchFiled[1].equals(null))&&
				(searchFiled[2].equalsIgnoreCase("none"))){
		booksList=BookLocalServiceUtil.getBooks(0, BookLocalServiceUtil.getBooksCount());
		
		}
		else{
			DynamicQuery dynamicQuery=DynamicQueryFactoryUtil.forClass(Book.class, PortletClassLoaderUtil.getClassLoader());
			Criterion criterion = null;
			criterion = RestrictionsFactoryUtil.like("bookName",
					new StringBuilder("%").append(searchFiled[0] ).append("%").toString());
					
			//	StringPool.PERCENT+bookName+StringPool.PERCENT);
			criterion = RestrictionsFactoryUtil.and(criterion, 
					RestrictionsFactoryUtil.like("author",new StringBuilder("%").append(searchFiled[1] ).append("%").toString()));
			criterion = RestrictionsFactoryUtil.and(criterion , RestrictionsFactoryUtil.like("bookType",new StringBuilder("%").append(searchFiled[2]).append("%").toString()));
			 
			dynamicQuery.add(criterion);
		
			dynamicQuery.add(PropertyFactoryUtil.forName("bookName").like(bookName));
			dynamicQuery.add(RestrictionsFactoryUtil.like("author", StringPool.per));
			dynamicQuery.add(RestrictionsFactoryUtil.like("bookName", "bookName"));
		booksList=BookLocalServiceUtil.dynamicQuery(dynamicQuery);
		}
		
			
		model.addAttribute("bookList", booksList);
		model.addAttribute("searchFields", searchFileds);
		
		return Constants.searchPage;
	}
	
	@ActionMapping(params ="javax.portlet.action=searchBooks")
	public void searchBooks(ActionRequest actionRequest, @ModelAttribute("bookDetailDTO") BookDetailDTO bookDetailDTO,
			BindingResult bindingResult,  ActionResponse actionResponse, Model model){
		
		
		
		 List<Book> booksList =new ArrayList<Book>();
		 try {
			 String bookName = ParamUtil.getString(actionRequest, "bookName");
				String author = ParamUtil.getString(actionRequest, "author");	
				String bookType = ParamUtil.getString(actionRequest, "bookType");
				if(bookType.equals("none")){
					bookType="";
				}
				//StringPool.PERCENT ;
			
				DynamicQuery dynamicQuery=DynamicQueryFactoryUtil.forClass(Book.class, PortletClassLoaderUtil.getClassLoader());
				Criterion criterion = null;
				criterion = RestrictionsFactoryUtil.like("bookName",
						new StringBuilder("%").append(bookName ).append("%").toString());
						
				//	StringPool.PERCENT+bookName+StringPool.PERCENT);
				criterion = RestrictionsFactoryUtil.and(criterion, RestrictionsFactoryUtil.like("author",new StringBuilder("%").append(author ).append("%").toString()));
				criterion = RestrictionsFactoryUtil.and(criterion , RestrictionsFactoryUtil.like("bookType",new StringBuilder("%").append(bookType).append("%").toString()));
				 
				dynamicQuery.add(criterion);
			
				dynamicQuery.add(PropertyFactoryUtil.forName("bookName").like(bookName));
				dynamicQuery.add(RestrictionsFactoryUtil.like("author", StringPool.per));
				dynamicQuery.add(RestrictionsFactoryUtil.like("bookName", "bookName"));
			booksList=BookLocalServiceUtil.dynamicQuery(dynamicQuery);
			bookDetailDTO.setBookDetailForm(null);
			model.addAttribute("searchFields", bookName+"~"+author+"~"+bookType);
			model.addAttribute("bookList", booksList);
			actionResponse.setRenderParameter(ActionRequest.ACTION_NAME, "bookListRender");
		} catch (SystemException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
	}
*/	
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
